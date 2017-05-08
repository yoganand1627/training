package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN14SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNF8DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNF8DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN52DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN52DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN37DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN37DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04UO;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn04u;
/**************************************************************************
**
** Module File:   CCMN14S.src
**
** Service Name:  CCMN14S
**
** Description:   Updates the IND STAGE PERS EMP NEW field in the
**        STAGE PERSON LINK table for a certain person
**        and a certain STAGE (for all ID_STAGEs sent to this service)
**                then retrieve all the Assignments for that certain person.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/07/95
**
** Programmer:    Alex Ramirez/Mary Sladewski
**
**  Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  04/07/95  RAMIREAP  SIR 363. When no rows are returned by DAM CCMN37D,
**                      the right message id is passed back to the client.
**  04/26/95  PITMANGS  Add call to UnitAccess common function to determine
**                      if user has supervisor priviliges.
**  04/27/95  PITMANGS  Add DAM to retrieve from the TEMP_STAGE_PERS_LINK
**                      in case of system crash during Intake to allow user
**                      to return to the particular record call.
**  05/24/95  FOGARTIS  Modified code to retrieve no more than 20 rows
**                      total between the temporary and normal stage pers
**                      link tables. Also added logic to seamlessly handle
**                      virtual pages across two tables. Search string =
**                      052495.
**  08/10/95  RUSSELRM  PWO# 1111 - Removed STAGE and NAME timestamps.
**  09/26/95    KRD     SIR 1258 - Modified CallCCMN37D() due to data element change
**                      of CD UNIT REGION to CD STAGE REGION
**  08/02/96  ZABIHIN   SIR 21891 - Was missing versioning. Added the lines.
**  04/02/97  RIOSJA    SIR 13618 - MHMR Enhancement for AFC Investigation
**                      "Waiting for Superintendent Comments". The value of
**                      the Superintendent Notified indicator will be passed
**                      back to the window.
**  06/29/05  casdorjm  SIR 23689 - Added copy from dam outputs into output
**                      object and passed the cReqDuncCd from the input object
**                      to the dam input object
**  07/11/05  yeehp	    SIR 23750 - added mobile status field.
**  07/12/05  Nallavs   SIR 23265 -- Added Recidivism field.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/


/* SIR 21891 - added the versioning line below */
/*
** Extern for version control table
*/






public class Ccmn14s {
    public static final int FILTER_BY_INV_30 = 1;
    public static final int FILTER_BY_SVC_60 = 2;
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final char YES = 'Y';
    public static final char NO = 'N';
    public static final String CRASH_RECOVERY_STAGE = "NO ASSIGN";
    CCMN14SO CCMN14S(CCMN14SI ccmn14si) {
        CCMN14SO ccmn14so = new CCMN14SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        
        /*
        ** Call CAUD08D The Contract County AUD performs a full row insert,
        ** update or delete to the Contract County table.
        */
        rc = ARC_PRFServiceStartTime_TUX(ccmn14si.getArchInputStruct());
        if (ccmn14si.getROWCCMN52DI_ARRAY().getROWCCMN52DI(0).getUlIdStage() != 0) {
            rc = Ccmn26s.CallCCMN52D(ccmn14si, ccmn14so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        
        /*
        ** IMPACT BEGIN - moved the if-statement so that the service's error
        **  handling works correctly.
        */
        /*
        ** If rows are returned from either table, compare the two and fill
        ** in the output message
        */
        if (((int) ccmn14si.getArchInputStruct().getCReqFuncCd() != FILTER_BY_INV_30) && ((int) ccmn14si.getArchInputStruct().getCReqFuncCd() != FILTER_BY_SVC_60)) {
            rc = CallCCMNF8D(ccmn14si, ccmn14so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        /*
        ** Copy output if compared CSLI's and LiTypes are equal
        */
        if (ccmn14so.getArchOutputStruct().getUlRowQty() < ccmn14si.getArchInputStruct().getUlPageSizeNbr()) {
            
            //  Get the current date and store it in dtCurrDate
            rc = CallCCMN37D(ccmn14si, ccmn14so, pServiceStatus);
            
            // Stop DAM Performance Timer
            //##                                    ARC_PRFDataAccessStopTime();
            
            // Analyze return code
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:// Contract County Retrieve
                    break;
                case Messages.MSG_CMN_EMPTY_WORKLOAD:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        
        
        
        /*
        ** SIR 15960 - the if-statement was originally here
        */
        
        
        /*
        ** SIR 15960 - Moved the if-statement to ensure that an error
        ** is only returned after processing all of the rows in both
        ** loops.
        */
        if ((ccmn14si.getBSysIndSupervisor() != YES) && (ccmn14si.getBSysIndSupervisor() != NO)) {
            
            rc = CallUnitAccess(ccmn14si, ccmn14so, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(ccmn14si.getArchInputStruct() , ccmn14so.getArchOutputStruct());
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
        return ccmn14so;
    }

    static int CallCCMNF8D(CCMN14SI pInputMsg236, CCMN14SO pOutputMsg217, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        int count = 0;
        CCMNF8DI pCCMNF8DInputRec = null;
        CCMNF8DO pCCMNF8DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNF8DInputRec = new CCMNF8DI();
        
        pCCMNF8DOutputRec = new CCMNF8DO();
        pCCMNF8DInputRec.setArchInputStruct(pInputMsg236.getArchInputStruct());
        
        pCCMNF8DInputRec.setUlIdTempStagePerson(pInputMsg236.getUlIdPerson());
        rc = ccmnf8dQUERYdam(sqlca, pCCMNF8DInputRec, pCCMNF8DOutputRec);
        switch (rc) {
                
            case SUCCESS:
                //  Populate Output Message   ISF 052495
                for (count = 0;count < pCCMNF8DOutputRec.getArchOutputStruct().getUlRowQty();count++) {
                    pOutputMsg217.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).setSzCdStagePersRole(pCCMNF8DOutputRec.getROWCCMNF8DO_ARRAY().getROWCCMNF8DO(count).getSzCdTempStagePersRole());
                    pOutputMsg217.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).setSzCdStage(pCCMNF8DOutputRec.getROWCCMNF8DO_ARRAY().getROWCCMNF8DO(count).getSzCdTempStage());
                    pOutputMsg217.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).setSzNmCase(CRASH_RECOVERY_STAGE);
                    pOutputMsg217.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).setUlIdStage(pCCMNF8DOutputRec.getROWCCMNF8DO_ARRAY().getROWCCMNF8DO(count).getUlIdTempStage());
                    pOutputMsg217.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).setTsLastUpdate(pCCMNF8DOutputRec.getROWCCMNF8DO_ARRAY().getROWCCMNF8DO(count).getTsLastUpdate());
                    
                }
                break;
            case NO_DATA_FOUND:
                
                pInputMsg236.setUlRowQty(pCCMNF8DOutputRec.getUlRowQty());
                
                
                //  Call CLSC18D
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        pOutputMsg217.getArchOutputStruct().setUlRowQty(pCCMNF8DOutputRec.getArchOutputStruct().getUlRowQty());
        pOutputMsg217.getArchOutputStruct().setBMoreDataInd(pCCMNF8DOutputRec.getArchOutputStruct().getBMoreDataInd());
        
        if (pInputMsg236.getArchInputStruct().getUlPageSizeNbr() == pCCMNF8DOutputRec.getArchOutputStruct().getUlRowQty()) {
            pOutputMsg217.getArchOutputStruct().setBMoreDataInd(1);
        }
        return rc;
    }

    static int CallCCMN52D(CCMN14SI pInputMsg237, CCMN14SO * pOutputMsg218, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int i139 = 0;
        int rc = 0;/* Return code */
        CCMN52DI pCCMN52DInputRec = null;
        CCMN52DO pCCMN52DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN52DInputRec = new CCMN52DI();
        
        pCCMN52DOutputRec = new CCMN52DO();
        pCCMN52DInputRec.setUlIdPerson(pInputMsg237.getUlIdPerson());
        pCCMN52DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        /*
        ** Populate input message
        */
        for (i139 = 0;((pInputMsg237.getROWCCMN52DI_ARRAY().getROWCCMN52DI(i139).getUlIdStage() != 0) && (i139 < CCMN14SO._CCMN14SO__ROWCCMN37DO_SIZE));i139++) {
            pCCMN52DInputRec.setUlIdStage(pInputMsg237.getROWCCMN52DI_ARRAY().getROWCCMN52DI(i139).getUlIdStage());
            pCCMN52DInputRec.setTsLastUpdate(pInputMsg237.getROWCCMN52DI_ARRAY().getROWCCMN52DI(i139).getTsLastUpdate());
            
            //  CCMN43D - This DAM will Delete rows from the TODO table.
            
            //  Start Performance Timer
            rc = ccmn52dAUDdam(sqlca, pCCMN52DInputRec, pCCMN52DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                case NO_DATA_FOUND:
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

    static int CallCCMN37D(CCMN14SI pInputMsg238, CCMN14SO pOutputMsg219, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code  */
        int i140 = 0;
        int count = 0;/* Counter to populate output message */
        /*
        ** Declare local variables
        */
        CCMN37DI pCCMN37DInputRec = null;
        CCMN37DO pCCMN37DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN37DInputRec = new CCMN37DI();
        
        pCCMN37DOutputRec = new CCMN37DO();
        pCCMN37DInputRec.setBWcdCdSortBy(pInputMsg238.getBWcdCdSortBy());
        pCCMN37DInputRec.setUlIdPerson(pInputMsg238.getUlIdPerson());
        if (pOutputMsg219.getArchOutputStruct().getUlRowQty() > 0) {
            pCCMN37DInputRec.getArchInputStruct().setUsPageNbr(1);
        }
        else {
            pCCMN37DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg238.getArchInputStruct().getUsPageNbr());
        }
        pCCMN37DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg238.getArchInputStruct().getUlPageSizeNbr() - pOutputMsg219.getArchOutputStruct().getUlRowQty());
        pCCMN37DInputRec.setUlRowQty(pInputMsg238.getUlRowQty());
        pCCMN37DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg238.getArchInputStruct().getCReqFuncCd());
        rc = ccmn37dQUERYdam(sqlca, pCCMN37DInputRec, pCCMN37DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case SUCCESS:
                //  Populate Output Message:
                // Set starting index point in Output Messgae for row population based
                // upon previous row returns within other Call Dam functions
                // ISF 052495
                count = pOutputMsg219.getArchOutputStruct().getUlRowQty();
                
                for (i140 = 0;i140 < pCCMN37DOutputRec.getArchOutputStruct().getUlRowQty();++i140) {
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).setBIndCaseSensitive(pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getBIndCaseSensitive());
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).setSzCdStagePersRole(pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getSzCdStagePersRole());
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).setSzNmStage(pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getSzNmStage());
                    
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).setSzCdStageCnty(pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getSzCdStageCnty());
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).setSzCdStage(pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getSzCdStage());
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).setSzCdStageType(pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getSzCdStageType());
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).getDtDtStagePersLink().day = pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getDtDtStagePersLink().day;
                    
                    //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).getDtDtStagePersLink().month = pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getDtDtStagePersLink().month;
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).getDtDtStagePersLink().year = pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getDtDtStagePersLink().year;
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).getDtDtStageStart().day = pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getDtDtStageStart().day;
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).getDtDtStageStart().month = pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getDtDtStageStart().month;
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).getDtDtStageStart().year = pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getDtDtStageStart().year;
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).setSzCdStageProgram(pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getSzCdStageProgram());
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).setSzCdStageRegion(pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getSzCdStageRegion());
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).setSzNbrUnit(pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getSzNbrUnit());
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).setBIndStagePersEmpNew(pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getBIndStagePersEmpNew());
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).setUlIdCase(pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getUlIdCase());
                    
                    //  Error processing will be handled in the main program
                    
                    // 
                    // End Call to Risk Factor AUD Dam - CMSC58D SIR 19918
                    // 
                    
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).setUlIdStage(pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getUlIdStage());
                    
                    //## BEGIN TUX/XML: Declare XML variables 
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).setSzNmCase(pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getSzNmCase());
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).setSzCdStageReasonClosed(pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getSzCdStageReasonClosed());
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).setSzCdMobileStatus(pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getSzCdMobileStatus());
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).setTsLastUpdate(pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getTsLastUpdate());
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).setCIndWkldSuperintNotif(pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getCIndWkldSuperintNotif());
                    pOutputMsg219.getROWCCMN37DO_ARRAY().getROWCCMN37DO(count).setSzCdRecidivism(pCCMN37DOutputRec.getROWCCMN37DO_ARRAY().getROWCCMN37DO(i140).getSzCdRecidivism());
                    count++;
                }
                
                break;
                
                //  On an INSERT or UPDATE statement, SQL_DUPLICATE_KEY is returned
                // if there is an attempt to store a duplicate primary key value.
                // pServiceStatus->explan_code should be set to the appropriate
                // message by the programmer.
            case NO_DATA_FOUND:
                if (0 == pOutputMsg219.getArchOutputStruct().getUlRowQty()) {
                    pServiceStatus.severity = FND_WARNING;
                    pServiceStatus.explan_code = Messages.MSG_CMN_EMPTY_WORKLOAD;
                    
                    //  Call CINT21D
                    rc = Messages.MSG_CMN_EMPTY_WORKLOAD;
                }
                else {
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        pOutputMsg219.getArchOutputStruct().setUlRowQty(pCCMN37DOutputRec.getArchOutputStruct().getUlRowQty() + pOutputMsg219.getArchOutputStruct().getUlRowQty());
        pOutputMsg219.getArchOutputStruct().setBMoreDataInd(pCCMN37DOutputRec.getArchOutputStruct().getBMoreDataInd());
        return rc;
    }

    static int CallUnitAccess(CCMN14SI pInputMsg239, CCMN14SO pOutputMsg220, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        CCMN04UI pInput = null;
        CCMN04UO pOutput = null;
        /*
        ** Declare Local Variables
        */
        
        /*
        ** Allocate memory for Unit Access Input and Output Structures
        */
        pInput = new CCMN04UI();
        
        pOutput = new CCMN04UO();
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
        pInput.getUlIdPerson_ARRAY().setUlIdPerson(0, pInputMsg239.getUlIdPerson());
        pInput.setSzCdUnitProgram(pInputMsg239.getSzCdUnitProgram());
        pInput.setSzCdUnitRegion(pInputMsg239.getSzCdUnitRegion());
        pInput.setSzNbrUnit(pInputMsg239.getSzNbrUnit());
        
        /*
        ** Retrieve a Contact record using the ID EVENT provided in
        ** INITDATA.
        */
        rc = Ccmn04u.UnitAccess(pInput, pOutput, pServiceStatus);
        
        if (pOutput.getBSysIndGeneric() == true) {
            pOutputMsg220.setBSysIndSupervisor('Y');
        }
        else {
            pOutputMsg220.setBSysIndSupervisor('N');
        }
        return rc;
    }

}
