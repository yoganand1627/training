package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN44DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN44DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES20DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES20DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS22DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS22DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS23DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS23DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS60DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS60DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
/**************************************************************************
** 
** Module File:    CSUB14S.src
**
** Service Name:   CSUB14S
**
** Description:   This is the retrieve service used by Conservatorship
**                Removal to retrieve information regarding the Removal
**                Event.  It retrieves the detail for the event, as well
**                as the removal reason, child removal characteristics,
**                and adult removal characteristics.
**               
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  18 October 1995
** 
** Programmer:    Greg Dyar
**
** Archive Information: $Revision:   1.5  $
**                      $Date:   07 May 1999 07:44:06  $
**                      $Modtime:   06 May 1999 16:03:30  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  10/18/95  DYARGR    Initial checkout for coding  
**
**  01/08/96  WILSONET  SIR#2389, 2391 (Search on SIR#2389)
**                      Add check to determine whether Child Characteristics
**                      are NA.  If NA, then open CVS but do not try to 
**                      populate checkboxes.                 
**
**  01/12/96  WILSONET  SIR#2556: Add a counter that is specifically 
**                      designated for the CPL characteristics, so that you 
**                      do not increment 'i' every time that you loop.
**
**  01/16/96  WILSONET  SIR#2652: New DAM, CLSS60D, was added to retrieve
**                      only current child characteristics.  That is, 
**                      all characteristics with an end date of > today.
**
**  01/27/96  WILSONET  SIR#2820: When in MODIFY, retrieve should populate
**                      based on the characteristics selected from Person
**                      Characteristics on the day the Removal was begun.
**                      MODIFY will allow user to change characteristics
**                      in Removal, but only those previously selected.
**
**  03/25/96  DYARGR    SIR 5043 - Added invalidate approval logic for CVS
**                      Removal, including the logic to determine if the 
**                      Conclusion has been submitted for approval. We have
**                      to retrieve this info in the retrieve service.
**
**  04/03/96  DYARGR    SIR 20165 - SIR 5043 broke logic above, added logic
**                      to handle certain error conditions correctly.
**
**  04/10/96  OMARAJJ   SIR#4249 - A comparison between the current date and 
**                      the child's birthday is performed to check if the 
**                      child is older than 18 years.  Using 
**                      ARC_UTLCompareDateAndTime to compare the dates and 
**                      than checking against a constant cannot be used 
**                      because of variations in the number of minutes 
**                      between any two dates.  Thus, new logic
**                      is included to correct for this situation.
**  6/14/96   PURCELA   SIR #10113 - Moved CSES21D memory freeing to be
**                      inside the same if statement as it is allocated in.
**                      Otherwise, unallocated memory was being freed. 
**
** 09/15/97   PAULS     SIR 14162 - Added a new field on the Conservatorship
**                      Removal Window. This Field records the Marital Status
**                      of the Mother when the child was born. 
** 05/06/1999 PAULS    SIR 14462 - Moved Mother Married Field from Conservatorship
**                      Removal window to Person Detail CVS/FA .
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; } 
**
**  04/30/03   Srini   SIR 17091: Added the error handling to take care of full 
**					   table scans for ccmn87dQUERYdam.
**
**  08/12/03	JEH	SIR 18571: Added proper handling of FRE and FSU stage
**			types when looking up pending stage closure.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Csub14s {
    
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int AGE_MAX_DIFF = 18;
    public static final int EIGHTEEN_IN_MINS = 9460800;
    public static final int YEAR_IN_MINS = 525600;
    public static final int MONTH_IN_MINS = 43200;
    
    /*
    ** String Test Modification: 28 November 1995
    ** Status New needs to be used to determine if the
    ** Primary Child should be retrieved.
    */
    public static final String STATUS_NEW = "NEW";
    
    public static final String CPL_CHARACTERISTIC = "CPL";
    public static final String REMOVAL_STG_PERS_ROLL = "PC";
    
    
    public static final int LB_REMOVAL = 0;
    public static final int LB_CHILD = 1;
    public static final int LB_CARE = 2;
    
    public static final char YES = 'Y';
    public static final char NO = 'N';
    
    public static final char NO_PERSON_CHAR = '2';
    
    public static final int MAX_DAY = 12;
    public static final int MAX_MONTH = 31;
    public static final int MAX_YEAR = 4712;
    
    /* SIR 18571 */
    public static final String FAMILY_REUN = "FRE";
    public static final String FAMILY_SUB = "FSU";
    public static final String INVESTIGATION = "INV";
    
    /* SIR 21130 */
    public static final String FAMILY_PRES = "FPR";
    public static final String INV_CCL_TYPE = "CCL";
    public static final String FPR_CCL_TYPE = "STG";
    public static final String EVENT_STATUS_PENDING = "PEND";
    CSUB14SO CSUB14S(CSUB14SI csub14si) {
        CSUB14SO csub14so = new CSUB14SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i421 = 0;
        int k = 0;/* Interger used for a looping logic
        SIR #20083 */
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        /* SIR#4249 */
        int Year1 = 0;
        int Year2 = 0;
        int Month1 = 0;
        int Month2 = 0;
        int Day1 = 0;
        int Day2 = 0;
        int lRC10 = 0;
        int /* local return value */
        RetVal = 0;
        int bFoundPlacement = 0;
        
        
        
        
        CCMN44DI pCCMN44DInputRec = null;
        CCMN44DO pCCMN44DOutputRec = null;
        
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        CSES21DI pCSES21DInputRec = null;
        CSES21DO pCSES21DOutputRec = null;
        
        CSES20DI pCSES20DInputRec = null;
        CSES20DO pCSES20DOutputRec = null;
        
        CLSS21DI pCLSS21DInputRec = null;
        CLSS21DO pCLSS21DOutputRec = null;
        CLSS22DI pCLSS22DInputRec = null;/* Retreive from Removal Char Child  */
        CLSS22DO pCLSS22DOutputRec = null;/* use IdEvent to return the records.*/
        
        
        CLSS23DI pCLSS23DInputRec = null;
        CLSS23DO pCLSS23DOutputRec = null;
        CLSS60DI pCLSS60DInputRec = null;/* SIR#2652 - PERS CHAR CONSERV  */
        CLSS60DO pCLSS60DOutputRec = null;/* Retrieve from Characteristics */
        
        
        /* SIR 5043 */
        CINT21DI pCINT21DInputRec = null;
        CINT21DO pCINT21DOutputRec = null;
        
        CCMN87DI pCCMN87DInputRec = null;
        CCMN87DO pCCMN87DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(csub14si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(csub14so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        if (0 != csub14si.getUlIdEvent()) {
            //  Allocate memory for DAM Input and Output Structures
            pCCMN45DInputRec = new CCMN45DI();
            
            pCCMN45DOutputRec = new CCMN45DO();
            pCCMN45DInputRec.setArchInputStruct(csub14si.getArchInputStruct());
            pCCMN45DInputRec.setUlIdEvent(csub14si.getUlIdEvent());
            
            //  Call CSES28D
            rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    //  Set RetVal to FND_SUCCESS
                    RetVal = SUCCESS;
                    csub14so.getROWCSUB14SOG04().setUlIdEvent(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdEvent());
                    csub14so.getROWCSUB14SOG04().setUlIdStage(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdStage());
                    csub14so.getROWCSUB14SOG04().setUlIdPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                    csub14so.getROWCSUB14SOG04().setSzCdTask(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdTask());
                    csub14so.getROWCSUB14SOG04().setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                    csub14so.getROWCSUB14SOG04().setSzCdEventType(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventType());
                    csub14so.getROWCSUB14SOG04().setSzTxtEventDescr(pCCMN45DOutputRec.getROWCCMN45DO().getSzTxtEventDescr());
                    csub14so.getROWCSUB14SOG04().setDtDtEventOccurred(pCCMN45DOutputRec.getROWCCMN45DO().getDtDtEventOccurred());
                    csub14so.getROWCSUB14SOG04().setTsLastUpdate(pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                    //  When this is the last stage in the case, we don't
                    // want any SvcAuths that are above COMPlete to have a term
                    // date greater than today (unless the Service Codes correspond
                    // to types of daycare services--Ex. 40M. Otherwise, the SvcAuths
                    // are NEW or PROC and we don't give edit checks on these
                    
                    if (0 != pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus().compareTo(STATUS_NEW)) {
                        //  Allocate memory for DAM Input and Output Structures
                        pCSES20DInputRec = new CSES20DI();
                        
                        pCSES20DOutputRec = new CSES20DO();
                        pCSES20DInputRec.setArchInputStruct(csub14si.getArchInputStruct());
                        pCSES20DInputRec.setUlIdEvent(csub14si.getUlIdEvent());
                        rc = cses20dQUERYdam(sqlca, pCSES20DInputRec, pCSES20DOutputRec);
                        
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                csub14so.getROWCSUB14SOG00().setUlIdEvent(pCSES20DOutputRec.getUlIdEvent());
                                csub14so.getROWCSUB14SOG00().setUlIdVictim(pCSES20DOutputRec.getUlIdVictim());
                                //   PROCESS_TUX_SQL_ERROR is called only when there is an unexpected
                                // SQL error returned from the DAM.
                                csub14so.getROWCSUB14SOG00().setLNbrRemovalAgeMo(pCSES20DOutputRec.getLNbrRemovalAgeMo());
                                
                                csub14so.getROWCSUB14SOG00().setLNbrRemovalAgeYr(pCSES20DOutputRec.getLNbrRemovalAgeYr());
                                csub14so.getROWCSUB14SOG00().setCIndRemovalNACare(pCSES20DOutputRec.getCIndRemovalNACare());
                                csub14so.getROWCSUB14SOG00().setCIndRemovalNaChild(pCSES20DOutputRec.getCIndRemovalNaChild());
                                csub14so.getROWCSUB14SOG00().setTsLastUpdate(pCSES20DOutputRec.getTsLastUpdate());
                                csub14so.getROWCSUB14SOG00().setDtDtRemoval(pCSES20DOutputRec.getDtDtRemoval());
                                //  SIR 14462 - Removed Mother Married Field                            
                                // Sir 14162- Populate The Service Input Message     
                                // pOutputMsg->ROWCSUB14SOG00.cCdRemovalMothrMarrd =
                                // pCSES20DOutputRec->cCdRemovalMothrMarrd ;
                                
                                //  Allocate memory for DAM Input and Output Structures
                                pCCMN44DInputRec = new CCMN44DI();
                                
                                pCCMN44DOutputRec = new CCMN44DO();
                                pCCMN44DInputRec.setArchInputStruct(csub14si.getArchInputStruct());
                                pCCMN44DInputRec.setUlIdPerson(pCSES20DOutputRec.getUlIdVictim());
                                rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        csub14so.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                                        break;
                                    case NO_DATA_FOUND:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        rc = WtcHelperConstants.ARC_SUCCESS;
                                        break;
                                        
                                    default :
                                        
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        
                                        RetVal = Csub50s.FND_FAIL;
                                        break;
                                }
                                
                                
                                
                                
                                if (SUCCESS == RetVal) {
                                    
                                    //  Allocate memory for DAM Input and Output Structures
                                    pCLSS21DInputRec = new CLSS21DI();
                                    
                                    pCLSS21DOutputRec = new CLSS21DO();
                                    pCLSS21DInputRec.setArchInputStruct(csub14si.getArchInputStruct());
                                    pCLSS21DInputRec.setUlIdEvent(csub14si.getUlIdEvent());
                                    
                                    //  Call CMSC16D
                                    rc = clss21dQUERYdam(sqlca, pCLSS21DInputRec, pCLSS21DOutputRec);
                                    
                                    //  Analyze error code
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            
                                            
                                            
                                            //  Populate Output Message
                                            
                                            //  Set fields in CSUB14SO to fields in CLSS21DO
                                            
                                            
                                            for (i421 = 0;i421 < pCLSS21DOutputRec.getArchOutputStruct().getUlRowQty();i421++) {
                                                csub14so.getROWCSUB14SOG01_ARRAY().getROWCSUB14SOG01(i421).setSzCdRemovalReason(pCLSS21DOutputRec.getROWCLSS21DO_ARRAY().getROWCLSS21DO(i421).getSzCdRemovalReason());
                                                csub14so.getROWCSUB14SOG01_ARRAY().getROWCSUB14SOG01(i421).setTsLastUpdate(pCLSS21DOutputRec.getROWCLSS21DO_ARRAY().getROWCLSS21DO(i421).getTsLastUpdate());
                                                csub14so.getROWCSUB14SOG01_ARRAY().getROWCSUB14SOG01(i421).setUlIdEvent(pCLSS21DOutputRec.getROWCLSS21DO_ARRAY().getROWCLSS21DO(i421).getUlIdEvent());
                                            }
                                            
                                            csub14so.getUlRowQty_ARRAY().setUlRowQty(LB_REMOVAL, pCLSS21DOutputRec.getArchOutputStruct().getUlRowQty());
                                            
                                            // SIR#2820 : Remove if statement
                                            // if (YES != pOutputMsg->
                                            // ROWCSUB14SOG00.cIndRemovalNaChild)
                                            // {
                                            //  Allocate memory for DAM Input and Output Structures
                                            pCLSS22DInputRec = new CLSS22DI();
                                            
                                            pCLSS22DOutputRec = new CLSS22DO();
                                            pCLSS22DInputRec.setArchInputStruct(csub14si.getArchInputStruct());
                                            pCLSS22DInputRec.setUlIdEvent(csub14si.getUlIdEvent());
                                            rc = clss22dQUERYdam(sqlca, pCLSS22DInputRec, pCLSS22DOutputRec);
                                            
                                            //  Analyze return code
                                            switch (rc) {
                                                case WtcHelperConstants.SQL_SUCCESS:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    
                                                    
                                                    
                                                    //  Populate Output Message
                                                    
                                                    //  Set fields in CSUB14SO to fields in CLSS22DO
                                                    
                                                    
                                                    for (i421 = 0;i421 < pCLSS22DOutputRec.getArchOutputStruct().getUlRowQty();i421++) {
                                                        csub14so.getROWCSUB14SOG02_ARRAY().getROWCSUB14SOG02(i421).setSzCdRemovChildChar(pCLSS22DOutputRec.getROWCLSS22DO_ARRAY().getROWCLSS22DO(i421).getSzCdRemovChildChar());
                                                        csub14so.getROWCSUB14SOG02_ARRAY().getROWCSUB14SOG02(i421).setTsLastUpdate(pCLSS22DOutputRec.getROWCLSS22DO_ARRAY().getROWCLSS22DO(i421).getTsLastUpdate());
                                                        csub14so.getROWCSUB14SOG02_ARRAY().getROWCSUB14SOG02(i421).setUlIdEvent(pCLSS22DOutputRec.getROWCLSS22DO_ARRAY().getROWCLSS22DO(i421).getUlIdEvent());
                                                        csub14so.getROWCSUB14SOG02_ARRAY().getROWCSUB14SOG02(i421).setCIndCharChildCurrent(pCLSS22DOutputRec.getROWCLSS22DO_ARRAY().getROWCLSS22DO(i421).getCIndCharChildCurrent());
                                                    }
                                                    
                                                    csub14so.getUlRowQty_ARRAY().setUlRowQty(LB_CHILD, pCLSS22DOutputRec.getArchOutputStruct().getUlRowQty());
                                                    
                                                    
                                                    
                                                    RetVal = SUCCESS;
                                                    break;
                                                case NO_DATA_FOUND:
                                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                                    pServiceStatus.explan_code = SUCCESS;
                                                    // if there is no placement, exit out of this subfunction
                                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                                    break;
                                                    
                                                default :
                                                    
                                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                    
                                                    break;
                                            }
                                            
                                            // Start SIR 23416 - Removed other types of Day Care from edit check which will then
                                            // set off open SVC AUTH edit check for those types of day care
                                            if (YES != csub14so.getROWCSUB14SOG00().getCIndRemovalNACare()) {
                                                //  Allocate memory for DAM Input and Output Structures
                                                pCLSS23DInputRec = new CLSS23DI();
                                                
                                                pCLSS23DOutputRec = new CLSS23DO();
                                                pCLSS23DInputRec.setArchInputStruct(csub14si.getArchInputStruct());
                                                pCLSS23DInputRec.setUlIdEvent(csub14si.getUlIdEvent());
                                                rc = clss23dQUERYdam(sqlca, pCLSS23DInputRec, pCLSS23DOutputRec);
                                                switch (rc) {
                                                    case WtcHelperConstants.SQL_SUCCESS:
                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                        pServiceStatus.explan_code = SUCCESS;
                                                        
                                                        
                                                        
                                                        //  Populate Output Message
                                                        
                                                        //  Set fields in CSUB14SO to fields in CLSS23DO
                                                        for (i421 = 0;i421 < pCLSS23DOutputRec.getArchOutputStruct().getUlRowQty();i421++) {
                                                            csub14so.getROWCSUB14SOG03_ARRAY().getROWCSUB14SOG03(i421).setSzCdRemovAdultChar(pCLSS23DOutputRec.getROWCLSS23DO_ARRAY().getROWCLSS23DO(i421).getSzCdRemovAdultChar());
                                                            csub14so.getROWCSUB14SOG03_ARRAY().getROWCSUB14SOG03(i421).setTsLastUpdate(pCLSS23DOutputRec.getROWCLSS23DO_ARRAY().getROWCLSS23DO(i421).getTsLastUpdate());
                                                            csub14so.getROWCSUB14SOG03_ARRAY().getROWCSUB14SOG03(i421).setUlIdEvent(pCLSS23DOutputRec.getROWCLSS23DO_ARRAY().getROWCLSS23DO(i421).getUlIdEvent());
                                                        }
                                                        csub14so.getUlRowQty_ARRAY().setUlRowQty(LB_CARE, pCLSS23DOutputRec.getArchOutputStruct().getUlRowQty());
                                                        
                                                        break;
                                                        
                                                    case NO_DATA_FOUND:
                                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                                        pServiceStatus.explan_code = SUCCESS;
                                                        rc = WtcHelperConstants.ARC_SUCCESS;
                                                        break;
                                                        
                                                    default :
                                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                                        
                                                        RetVal = Csub50s.FND_FAIL;
                                                        break;
                                                }
                                            }
                                            break;
                                            
                                            
                                        default :
                                            pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                            
                                            
                                            RetVal = Csub50s.FND_FAIL;
                                            break;
                                    }
                                    break;
                                }
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                RetVal = Csub50s.FND_FAIL;
                                break;
                        }
                    }
                    break;
                    
                    
                default :
                    
                    RetVal = Csub50s.FND_FAIL;
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        
        if (((WINDOW_MODE_NEW == csub14si.getSzSysCdWinMode()) || (WINDOW_MODE_NEW_USING == csub14si.getSzSysCdWinMode()) || (0 == csub14si.getUlIdEvent())) && (SUCCESS == RetVal)) {
            //  Allocate memory for DAM Input and Output Structures
            pCCMN44DInputRec = new CCMN44DI();
            
            pCCMN44DOutputRec = new CCMN44DO();
            pCCMN44DInputRec.setArchInputStruct(csub14si.getArchInputStruct());
            pCCMN44DInputRec.setUlIdPerson(csub14si.getUlIdPerson());
            
            //  Call DAM
            rc = ccmn44dQUERYdam(sqlca, pCCMN44DInputRec, pCCMN44DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    csub14so.setSzCdPersonEthnicGroup(pCCMN44DOutputRec.getSzCdPersonEthnicGroup());
                    csub14so.setSzNmPersonFull(pCCMN44DOutputRec.getSzNmPersonFull());
                    csub14so.setDtDtPersonBirth(pCCMN44DOutputRec.getDtDtPersonBirth());
                    if ((DateHelper.NULL_DATE != pCCMN44DOutputRec.getDtDtPersonBirth().month) && (DateHelper.NULL_DATE != pCCMN44DOutputRec.getDtDtPersonBirth().day) && (DateHelper.NULL_DATE != pCCMN44DOutputRec.getDtDtPersonBirth().year)) {
                        //  SIR#4249 - A comparison between the current date and
                        // the child's birthday is performed to check if the child
                        // is older than 18 years.  Using ARC_UTLCompareDateAndTime
                        // to compare the dates and than checking against a constant
                        // cannot be used because of variations in the number of 
                        // minutes between the two dates.  Thus, the following logic
                        // is included to correct for this situation.
                        
                        //  set the system date and the birthdate to temp, variables
                        Year1 = csub14so.getDtWCDDtSystemDate().year;
                        Month1 = csub14so.getDtWCDDtSystemDate().month;
                        Day1 = csub14so.getDtWCDDtSystemDate().day;
                        Year2 = pCCMN44DOutputRec.getDtDtPersonBirth().year;
                        Month2 = pCCMN44DOutputRec.getDtDtPersonBirth().month;
                        Day2 = pCCMN44DOutputRec.getDtDtPersonBirth().day;
                        // SIR 23746 - Added this if condition to check on parameter.
                        if ((Year1 - Year2 > AGE_MAX_DIFF) || ((Year1 - Year2 == AGE_MAX_DIFF) && (Month1 > Month2)) || ((Year1 - Year2 == AGE_MAX_DIFF) && (Month1 == Month2) && (Day1 >= Day2))) {
                            pServiceStatus.explan_code = Messages.MSG_SUB_CHILD_OVER_18;
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            
                            RetVal = Csub50s.FND_FAIL;
                            rc = Messages.MSG_SUB_CHILD_OVER_18;
                            
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        }
                        
                        else {
                            
                            RetVal = SUCCESS;
                        }
                    }
                    
                    
                    
                    
                    else {
                        RetVal = SUCCESS;
                    }
                    if (SUCCESS == RetVal) {
                        pCSES21DInputRec = new CSES21DI();
                        
                        pCSES21DOutputRec = new CSES21DO();
                        pCSES21DInputRec.setArchInputStruct(csub14si.getArchInputStruct());
                        pCSES21DInputRec.setSzCdStagePersRole(REMOVAL_STG_PERS_ROLL);
                        pCSES21DInputRec.setUlIdPerson(csub14si.getUlIdPerson());
                        pCSES21DInputRec.setUlIdStage(csub14si.getUlIdStage());
                        rc = cses21dQUERYdam(sqlca, pCSES21DInputRec, pCSES21DOutputRec);
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                
                                
                                if (pCSES21DOutputRec.getUlSysNbrUlongKey() > 0) {
                                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                                    pServiceStatus.explan_code = Messages.MSG_SUB_SUBC_STAGE_EXISTS;
                                    
                                    //  SIR 21065
                                    // Added logic for error conditions
                                    RetVal = Csub50s.FND_FAIL;
                                    
                                    // Call DAM
                                    rc = Messages.MSG_SUB_SUBC_STAGE_EXISTS;
                                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                }
                                
                                
                                else if (NO_PERSON_CHAR == pCCMN44DOutputRec.getBCdPersonChar()) {
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    csub14so.getUlRowQty_ARRAY().setUlRowQty(LB_CHILD, 0);
                                    csub14so.getROWCSUB14SOG00().setCIndRemovalNaChild(YES);
                                }
                                
                                
                                else {
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    
                                    //  Process Placement Characteristics
                                    // The child must have placement characteristics in the
                                    // Person window before the removal event can be started
                                    //  Allocate memory for DAM Input and Output Structures
                                    pCLSS60DInputRec = new CLSS60DI();
                                    
                                    pCLSS60DOutputRec = new CLSS60DO();
                                    pCLSS60DInputRec.setArchInputStruct(csub14si.getArchInputStruct());
                                    pCLSS60DInputRec.setDtScrDtCharEffDate(csub14so.getDtWCDDtSystemDate());
                                    pCLSS60DInputRec.setUlIdPerson(csub14si.getUlIdPerson());
                                    rc = clss60dQUERYdam(sqlca, pCLSS60DInputRec, pCLSS60DOutputRec);
                                    switch (rc) {
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            pServiceStatus.severity = FND_SEVERITY_OK;
                                            pServiceStatus.explan_code = SUCCESS;
                                            k = 0;// SIR#2556: Loop counter for CPL chars
                                            
                                            for (i421 = 0;(i421 < pCLSS60DOutputRec.getArchOutputStruct().getUlRowQty());i421++) {
                                                if (0 == CPL_CHARACTERISTIC.compareTo(pCLSS60DOutputRec.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i421).getSzCdCharCategory())) {
                                                    bFoundPlacement = 1;// flag to determine if characteristics are complete
                                                    csub14so.getROWCSUB14SOG02_ARRAY().getROWCSUB14SOG02(k).setSzCdRemovChildChar(pCLSS60DOutputRec.getROWCLSS60DO_ARRAY().getROWCLSS60DO(i421).getCdCharacteristic());
                                                    k++;
                                                }
                                            }
                                            if (bFoundPlacement) {
                                                pServiceStatus.severity = FND_SEVERITY_OK;
                                                pServiceStatus.explan_code = SUCCESS;
                                                csub14so.getUlRowQty_ARRAY().setUlRowQty(LB_CHILD, k);
                                                csub14so.getROWCSUB14SOG00().setCIndRemovalNaChild(NO);
                                            }
                                            
                                            
                                            else {
                                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                                pServiceStatus.explan_code = Messages.MSG_SUB_PLCMT_CHAR_NEEDED;
                                                
                                                //  SIR 20165
                                                // Added logic to handle error conditions correctly
                                                RetVal = Csub50s.FND_FAIL;
                                                rc = Messages.MSG_SUB_PLCMT_CHAR_NEEDED;
                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                            }
                                            //  Do nothing, the output message just returns success or
                                            // failure.
                                            break;
                                            
                                            // case SQL_NOT_FOUND:
                                            // pServiceStatus->severity = FND_SEVERITY_ERROR;
                                            // pServiceStatus->explan_code = MSG_CMN_TMSTAMP_MISMATCH;
                                            // rc = MSG_CMN_TMSTAMP_MISMATCH;
                                            // break;
                                            
                                        case NO_DATA_FOUND:
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_SUB_PLCMT_CHAR_NEEDED;
                                            
                                            //  SIR 20165
                                            // Added logic to handle error conditions
                                            RetVal = Csub50s.FND_FAIL;
                                            
                                            //  Call DAM
                                            rc = Messages.MSG_SUB_PLCMT_CHAR_NEEDED;
                                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                            break;
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                            
                                            //  SIR 20165
                                            // Added logic to handle error conditions
                                            RetVal = Csub50s.FND_FAIL;
                                            break;
                                    }
                                    
                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                }
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                
                                //  SIR 20165
                                // Added logic to hanlde error conditions
                                RetVal = Csub50s.FND_FAIL;
                                break;
                        }
                    }
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    //  SIR 20165
                    // Added logic to handle error conditions
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        
        /*
        ** If we only get one row back, then the current stage (the
        ** stage we are closing) is the last stage in the case.
        */
        if (SUCCESS == RetVal) {
            //  Allocate memory for DAM Input and Output Structures
            pCINT21DInputRec = new CINT21DI();
            
            pCINT21DOutputRec = new CINT21DO();
            pCINT21DInputRec.setArchInputStruct(csub14si.getArchInputStruct());
            
            pCINT21DInputRec.setUlIdStage(csub14si.getUlIdStage());
            rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
            
            //  Analyze error code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    
                    //  Populate Output Message
                    //  When we find out what the stage is, we need to determine which
                    // Event Type to pass to the event retrieval dam
                    // 
                    // BEGIN CCMN87D : Event Retrieval
                    // 
                    //  Allocate memory for DAM Input and Output Structures
                    pCCMN87DInputRec = new CCMN87DI();
                    
                    pCCMN87DOutputRec = new CCMN87DO();
                    pCCMN87DInputRec.setArchInputStruct(csub14si.getArchInputStruct());
                    pCCMN87DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    pCCMN87DInputRec.getArchInputStruct().setUsPageNbr(1);
                    pCCMN87DInputRec.getArchInputStruct().setUlPageSizeNbr(1);
                    pCCMN87DInputRec.setUlIdStage(csub14si.getUlIdStage());
                    
                    if (0 == INVESTIGATION.compareTo(pCINT21DOutputRec.getSzCdStage()) || 0 == FAMILY_REUN.compareTo(pCINT21DOutputRec.getSzCdStage()) || 0 == FAMILY_SUB.compareTo(pCINT21DOutputRec.getSzCdStage())) {
                        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(INV_CCL_TYPE);
                    }
                    else if (0 == FAMILY_PRES.compareTo(pCINT21DOutputRec.getSzCdStage())) {
                        pCCMN87DInputRec.getROWCCMN87DI_ARRAY().getROWCCMN87DI(0).setSzCdEventType(FPR_CCL_TYPE);
                    }
                    
                    //  Call DAM
                    rc = ccmn87dQUERYdam(sqlca, pCCMN87DInputRec, pCCMN87DOutputRec);
                    
                    //  Analyze error code
                    switch (rc) {
                            
                            // case SQL_NOT_FOUND:
                            // pServiceStatus->severity = FND_SEVERITY_ERROR;
                            // pServiceStatus->explan_code = MSG_CMN_TMSTAMP_MISMATCH;
                            // rc = MSG_CMN_TMSTAMP_MISMATCH;
                            // break;
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            //  RIOSJA, SIR 19973 - Added condition for Service Auths in APRV
                            // status so we can look for ones whose Term Date is in the future.
                            // If any exist, we must then check for an eligible stage to which
                            // the Service Auths can be progressed.
                            // ----------
                            // SIR 20911
                            // Only test for Term Date when Service Auth status is COMP, PEND
                            // or APRV. All other statuses are discarded. If status is COMP or
                            // PEND, and the Term Date is in the future, this stage cannot be
                            // submitted for closure. If status is APRV and Term Date is in the
                            // future, Service Auths are progressed to an open stage later when
                            // the closure event is approved.
                            if (!(strncmp(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getSzCdEventStatus() , EVENT_STATUS_PENDING, EVENT_STATUS_PENDING.length()) != 0)) {
                                csub14so.setUlIdEvent(pCCMN87DOutputRec.getROWCCMN87DO_ARRAY().getROWCCMN87DO(0).getUlIdEvent());
                            }
                            else {
                                csub14so.setUlIdEvent(0);
                            }
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            break;
                        case NO_DATA_FOUND:
                            csub14so.setUlIdEvent(0);
                            
                            //  Call DAM
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            break;
                        case Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                            rc = Messages.MSG_INSUFF_DATA_FOR_EVENT_LIST;
                            RetVal = Csub50s.FND_FAIL;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                    
                    // 
                    // END CCMN87D: Event Retrieval
                    // 
                    
                    RetVal = SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    RetVal = Csub50s.FND_FAIL;
                    break;
            }
        }
        
        /*
        ** Leaving this in temporarily, having a problem with
        ** truncation of retrieved output.  Think we solved the
        ** problem with a XLT fix.  Take out during string GRD
        */
        /*  *pOutputMsgSize = sizeof(_CSUB14SO);*/
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(csub14si.getArchInputStruct() , csub14so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            rc = SUCCESS;
        }
        /*
        ** RIOSJA, SIR 19973
        ** If Term Date is in the future:
        ** 1.) If Service Auth is APRV'd, set
        ** bSvcAuthsToProgress to TRUE so that
        ** later we can check for an eligible
        ** stage to which we can progress the
        ** Service Auth.
        ** 2.) Otherwise set bPassedSvcAuthEdit
        ** to FALSE so that we know that not all
        ** COMP and PEND Service Auths are closed
        ** and we can display a message to the
        ** user telling them that they cannot
        ** close the stage.
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
                
                //  Call DAM
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return csub14so;
    }

}
