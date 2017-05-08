package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC46DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC46DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV29DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV29DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN19DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN19DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC02DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC02DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS71DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS71DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   ccfc13s.src
**
** Service Name:  CCFC13S
**
** Description:   This service will retrieve all associated rows on the 
**                Person Merge table for a given Id Person.  It also dtermines
**                if the Id Person passed into the window is an employee by 
**                checking the category table for a category of EMP or FEM.  
**                The service also checks whether or not the employee logged 
**                into the window is the primary worker in the stage or is 
**                part of the unit hierarchy for the stage.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/09/96 
** 
** Programmer:    Timothy R. Overend
**
** Archive Information: $Revision:   1.6  $
**                      $Date:   09 Sep 1996 15:57:38  $
**                      $Modtime:   09 Sep 1996 15:15:46  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  03/07/96  PHILLILH  SIR # 3667 - Changed the call to Unit Access function
**                      to expectTUX_STATUSPARMS rather than &sqlca because 
**                      functions expectTUX_STATUSPARMS not &sqlca.
**
**  05/07/96  OMARAJJ   SIR#20700 - Added code after the call to CINV29d.pc
**                      to check if the id person closed is a former employee.
**                      In addition to a current employee.       
**  09/01/96  MAXHAMKJ  PERF SIR 21941: Inserted call to CLSS71d.pc before
**                      clsc46d.pc - CLSS71d will check to see if the Person
**                      has been merged at all. If not, there's no reason
**                      to call clsc46d.
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR 
**						to PROCESS_TUX_RC_ERROR_NOFREE after the 
**						ARC_UTLCheckServiceBatchBlock so that it doesn't free the 
**						input and output objects before they are allocated
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/


/*
** Extern for version control table.
*/







public class Ccfc13s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String PRIMARY_WORKER = "PR";
    public static final String EMPLOYEE_CATEGORY = "EMP";
    /* SIR#20700 */
    public static final String EMPLOYEE_CATEGORY_FORMER = "FEM";
    CCFC13SO CCFC13S(CCFC13SI ccfc13si) {
        CCFC13SO ccfc13so = new CCFC13SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_UTLCheckServiceBatchBlock("CCFC13S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        int i17 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  long            rc = 0;
        
        CLSC46DI pCLSC46DInputRec = null;
        CLSC46DO pCLSC46DOutputRec = null;
        CINV29DI pCINV29DInputRec = null;
        CINV29DO pCINV29DOutputRec = null;
        CCMN19DI pCCMN19DInputRec = null;
        CCMN19DO pCCMN19DOutputRec = null;
        CSEC02DI pCSEC02DInputRec = null;
        CSEC02DO pCSEC02DOutputRec = null;
        CCMN04UI pCCMN04UInputRec = null;
        CCMN04UO pCCMN04UOutputRec = null;
        CLSS71DI pCLSS71DInputRec = null;
        CLSS71DO pCLSS71DOutputRec = null;
        
        /*
        ** Call CheckStageEventStatus
        */
        rc = ARC_PRFServiceStartTime_TUX(ccfc13si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(ccfc13so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        
        /* 
        ** PERFORMANCE SIR 21941: Instead of calling CLSC46D.PC right away,
        ** call CLSS71D first to see if the person has been merged. If not,
        ** there's no reason to call the Person Merge DAM. This will save
        ** on processing time in some instances, and improve overall performance.
        */
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSS71DInputRec = new CLSS71DI();
        
        pCLSS71DOutputRec = new CLSS71DO();
        pCLSS71DInputRec.setArchInputStruct(ccfc13si.getArchInputStruct());
        pCLSS71DInputRec.setUlIdPrimaryClient(ccfc13si.getUlIdPerson());
        pCLSS71DInputRec.getArchInputStruct().setUsPageNbr(ccfc13si.getArchInputStruct().getUsPageNbr());
        pCLSS71DInputRec.getArchInputStruct().setUlPageSizeNbr(ccfc13si.getArchInputStruct().getUlPageSizeNbr());
        rc = clss71dQUERYdam(sqlca, pCLSS71DInputRec, pCLSS71DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                ccfc13so.getArchOutputStruct().setUlRowQty(0);
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        
        if ((rc == SUCCESS) && (0 != pCLSS71DOutputRec.getROWCLSS71DO_ARRAY().getROWCLSS71DO(0).getUlIdPersMergeForward())) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCLSC46DInputRec = new CLSC46DI();
            
            pCLSC46DOutputRec = new CLSC46DO();
            pCLSC46DInputRec.setArchInputStruct(ccfc13si.getArchInputStruct());
            pCLSC46DInputRec.setUlIdPerson(ccfc13si.getUlIdPerson());
            pCLSC46DInputRec.getArchInputStruct().setUsPageNbr(ccfc13si.getArchInputStruct().getUsPageNbr());
            pCLSC46DInputRec.getArchInputStruct().setUlPageSizeNbr(ccfc13si.getArchInputStruct().getUlPageSizeNbr());
            
            
            //  Call CINV51D
            rc = clsc46dQUERYdam(sqlca, pCLSC46DInputRec, pCLSC46DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    //  Set fields in CCFC13SO to the fields in CLSC46DO
                    
                    for (i17 = 0;(i17 < pCLSC46DOutputRec.getArchOutputStruct().getUlRowQty());i17++) {
                        ccfc13so.getROWCCFC13SOG00_ARRAY().getROWCCFC13SOG00(i17).setSzScrNmPersMergeForward(pCLSC46DOutputRec.getROWCLSC46DO_ARRAY().getROWCLSC46DO(i17).getSzNmPersonFull());
                        ccfc13so.getROWCCFC13SOG00_ARRAY().getROWCCFC13SOG00(i17).setSzNmNameFirst(pCLSC46DOutputRec.getROWCLSC46DO_ARRAY().getROWCLSC46DO(i17).getSzNmNameFirst());
                        ccfc13so.getROWCCFC13SOG00_ARRAY().getROWCCFC13SOG00(i17).setSzNmNameMiddle(pCLSC46DOutputRec.getROWCLSC46DO_ARRAY().getROWCLSC46DO(i17).getSzNmNameMiddle());
                        ccfc13so.getROWCCFC13SOG00_ARRAY().getROWCCFC13SOG00(i17).setSzNmNameLast(pCLSC46DOutputRec.getROWCLSC46DO_ARRAY().getROWCLSC46DO(i17).getSzNmNameLast());
                        ccfc13so.getROWCCFC13SOG00_ARRAY().getROWCCFC13SOG00(i17).setUlIdPersMergeForward(pCLSC46DOutputRec.getROWCLSC46DO_ARRAY().getROWCLSC46DO(i17).getUlIdPersMergeForward());
                        ccfc13so.getROWCCFC13SOG00_ARRAY().getROWCCFC13SOG00(i17).setSzScrNmPersMergeClosed(pCLSC46DOutputRec.getROWCLSC46DO_ARRAY().getROWCLSC46DO(i17).getSzSysNmPersonFull());
                        ccfc13so.getROWCCFC13SOG00_ARRAY().getROWCCFC13SOG00(i17).setSzScrNmNameFirst(pCLSC46DOutputRec.getROWCLSC46DO_ARRAY().getROWCLSC46DO(i17).getSzScrNmNameFirst());
                        ccfc13so.getROWCCFC13SOG00_ARRAY().getROWCCFC13SOG00(i17).setSzScrNmNameMiddle(pCLSC46DOutputRec.getROWCLSC46DO_ARRAY().getROWCLSC46DO(i17).getSzScrNmNameMiddle());
                        ccfc13so.getROWCCFC13SOG00_ARRAY().getROWCCFC13SOG00(i17).setSzScrNmNameLast(pCLSC46DOutputRec.getROWCLSC46DO_ARRAY().getROWCLSC46DO(i17).getSzScrNmNameLast());
                        ccfc13so.getROWCCFC13SOG00_ARRAY().getROWCCFC13SOG00(i17).setUlIdPersMergeClosed(pCLSC46DOutputRec.getROWCLSC46DO_ARRAY().getROWCLSC46DO(i17).getUlIdPersMergeClosed());
                        ccfc13so.getROWCCFC13SOG00_ARRAY().getROWCCFC13SOG00(i17).setSzScrNmPersMergeWrkr(pCLSC46DOutputRec.getROWCLSC46DO_ARRAY().getROWCLSC46DO(i17).getSzSysNmPersonFull3());
                        ccfc13so.getROWCCFC13SOG00_ARRAY().getROWCCFC13SOG00(i17).setSzScrNmPersMrgSpltWrkr(pCLSC46DOutputRec.getROWCLSC46DO_ARRAY().getROWCLSC46DO(i17).getSzSysNmPersonFull4());
                        ccfc13so.getROWCCFC13SOG00_ARRAY().getROWCCFC13SOG00(i17).setUlIdPersMergeWrkr(pCLSC46DOutputRec.getROWCLSC46DO_ARRAY().getROWCLSC46DO(i17).getUlIdPersMergeWrkr());
                        ccfc13so.getROWCCFC13SOG00_ARRAY().getROWCCFC13SOG00(i17).setUlIdPersMergeSplitWrkr(pCLSC46DOutputRec.getROWCLSC46DO_ARRAY().getROWCLSC46DO(i17).getUlIdPersMergeSplitWrkr());
                        ccfc13so.getROWCCFC13SOG00_ARRAY().getROWCCFC13SOG00(i17).setTsLastUpdate(pCLSC46DOutputRec.getROWCLSC46DO_ARRAY().getROWCLSC46DO(i17).getTsLastUpdate());
                        ccfc13so.getROWCCFC13SOG00_ARRAY().getROWCCFC13SOG00(i17).setUlIdPersonMerge(pCLSC46DOutputRec.getROWCLSC46DO_ARRAY().getROWCLSC46DO(i17).getUlIdPersonMerge());
                        ccfc13so.getROWCCFC13SOG00_ARRAY().getROWCCFC13SOG00(i17).setCIndPersMergeInvalid(pCLSC46DOutputRec.getROWCLSC46DO_ARRAY().getROWCLSC46DO(i17).getCIndPersMergeInvalid());
                        ccfc13so.getROWCCFC13SOG00_ARRAY().getROWCCFC13SOG00(i17).setDtDtPersMerge(pCLSC46DOutputRec.getROWCLSC46DO_ARRAY().getROWCLSC46DO(i17).getDtDtPersMerge());
                        ccfc13so.getROWCCFC13SOG00_ARRAY().getROWCCFC13SOG00(i17).setDtDtPersMergeSplit(pCLSC46DOutputRec.getROWCLSC46DO_ARRAY().getROWCLSC46DO(i17).getDtDtPersMergeSplit());
                    }
                    ccfc13so.getArchOutputStruct().setBMoreDataInd(pCLSC46DOutputRec.getArchOutputStruct().getBMoreDataInd());
                    ccfc13so.getArchOutputStruct().setUlRowQty(pCLSC46DOutputRec.getArchOutputStruct().getUlRowQty());
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
        
        /*
        ** Call the employee flag retrieval dam to check to see if the person
        ** that was passed into the window was an employee or not
        */
        /**************************************************************************
        ** Call the Employee Flag Retrieval Dam - CINV29D
        **
        ** Description - This DAM retrieves a list of categories for
        **               a given ID PERSON.
        **************************************************************************/
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCINV29DInputRec = new CINV29DI();
        
        pCINV29DOutputRec = new CINV29DO();
        pCINV29DInputRec.setArchInputStruct(ccfc13si.getArchInputStruct());
        pCINV29DInputRec.setUlIdPerson(ccfc13si.getUlIdPerson());
        rc = cinv29dQUERYdam(sqlca, pCINV29DInputRec, pCINV29DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Set the employee indicator to true if the 
                // one of the rows returned has a category
                // of employee
                
                // SIR#20700 - Add the code to check if the category is Former Employee
                for (i17 = 0;(i17 < pCINV29DOutputRec.getArchOutputStruct().getUlRowQty());i17++) {
                    
                    
                    
                    //  SIR #2455: Added the condition to see if the Date Letters issued
                    // field was filled for the first time.
                    if ((pCINV29DOutputRec.getROWCINV29DO_ARRAY().getROWCINV29DO(i17).getSzCdCategoryCategory().equals(EMPLOYEE_CATEGORY)) || (pCINV29DOutputRec.getROWCINV29DO_ARRAY().getROWCINV29DO(i17).getSzCdCategoryCategory().equals(EMPLOYEE_CATEGORY_FORMER))) {
                        ccfc13so.setBIndActiveStatus(true);
                    }
                }
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                ccfc13so.setBIndActiveStatus(false);
                
                //  Set CCMN01UI DtEventOccurred to current system date
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        
        if (WtcHelperConstants.ARC_SUCCESS == rc) {
            // 
            // Call the Primary Worker Retrieval Dam - CCMN19D
            // Description - The purpose of this dam (ccmn19dQUERYdam) is to retrieve
            // the PRIMARY (PR) or HISTORICAL PRIMARY (HP) worker
            // and NM_STAGE of the ID_STAGE which is passed into the dam.
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCCMN19DInputRec = new CCMN19DI();
            
            pCCMN19DOutputRec = new CCMN19DO();
            pCCMN19DInputRec.setArchInputStruct(ccfc13si.getArchInputStruct());
            pCCMN19DInputRec.setUlIdStage(ccfc13si.getUlIdStage());
            pCCMN19DInputRec.setSzCdStagePersRole(PRIMARY_WORKER);
            
            
            //  Call Post Event function
            
            rc = ccmn19dQUERYdam(sqlca, pCCMN19DInputRec, pCCMN19DOutputRec);
            
            //  Analyze error code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    if (ccfc13si.getUlIdPersonRequestor() == pCCMN19DOutputRec.getUlIdTodoPersWorker()) {
                        ccfc13so.setCSysIndPrimaryWorker(1);
                    }
                    
                    else {
                        ccfc13so.setCSysIndPrimaryWorker(0);
                    }
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
        if (WtcHelperConstants.ARC_SUCCESS == rc &&!(ccfc13so.getCSysIndPrimaryWorker() != 0)) {
            // 
            // Call the Stage and Case Retrieval Dam - CSEC02D
            // Description - This DAM makes a full row retrieval from the STAGE 
            // and CAPS_CASE tables.
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCSEC02DInputRec = new CSEC02DI();
            
            pCSEC02DOutputRec = new CSEC02DO();
            pCSEC02DInputRec.setArchInputStruct(ccfc13si.getArchInputStruct());
            pCSEC02DInputRec.setUlIdStage(ccfc13si.getUlIdStage());
            rc = csec02dQUERYdam(sqlca, pCSEC02DInputRec, pCSEC02DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    // 
                    // Call the Unit  Retrieval Dam - CCMN04U
                    // Description - This is a common function designed to determine whether
                    // or not a set of employees (the user + designees) has
                    // access for unit modification.  This is performed by
                    // comparing the Unit Member Roles of the set of employees
                    // against that of the unit's approver and checks up the
                    // unit heirarchy via the Parent Unit, if necessary.  The
                    // function receives ID PERSON for the user, ID PERSON for
                    // the user's designees and either ID UNIT or CD UNIT PROGRAM,
                    // CD UNIT REGION, and NBR UNIT.  It returns either TRUE or
                    // FALSE.
                    // 
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCCMN04UInputRec = new CCMN04UI();
                    
                    pCCMN04UOutputRec = new CCMN04UO();
                    
                    pCCMN04UInputRec.setArchInputStruct(ccfc13si.getArchInputStruct());
                    
                    
                    pCCMN04UInputRec.setUlIdUnit(pCSEC02DOutputRec.getUlIdUnit());
                    
                    pCCMN04UInputRec.getUlIdPerson_ARRAY().setUlIdPerson(0, ccfc13si.getUlIdPersonRequestor());
                    
                    
                    //  Call CAUD62D
                    rc = Ccmn04u.UnitAccess(pCCMN04UInputRec, pCCMN04UOutputRec, pServiceStatus);
                    
                    //  Analyze error code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            ccfc13so.setCSysIndPrimaryWorker(pCCMN04UOutputRec.getBSysIndGeneric());
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                            pServiceStatus.explan_code = Messages.MSG_DATABASE_RETRIEVE_FAIL;
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            break;
                    }
                    
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
        
        /*
        ** Load Translation Map
        */
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccfc13si.getArchInputStruct() , ccfc13so.getArchOutputStruct());
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
        return ccfc13so;
    }

}
