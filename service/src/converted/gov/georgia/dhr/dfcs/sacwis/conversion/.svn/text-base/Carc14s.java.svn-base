package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC14SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSCB3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSCB3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES00DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES00DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS15DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS15DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS12DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS12DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
**
** Module File:    CARC14S.src
**
** Service Name:   CARC14S
**
** Description:   This service retrieves security information for a given
**                employee from the Employee Table if it exists. It also
**                retrieves any temporary assignments of the employee, which
**                can be up to five assignments.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  09-OCT-95
**
** Programmer:    adkinsmc
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:25:22  $
**                      $Modtime:   28 Mar 1996 22:10:40  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  12/12/95  WANGSS    All Email Address references removed due to STARC
**                      sign-off
**
**  04/20/01  APT       Added the call to new dam CLSCB3D.PC, which
**                      retrieves all rows from the EMP_SEC_CLASS_LINK
**                      table.  Modified output message calculation.
**                      Removed the population of CdEmpSecurityClassNm
**                      from CSES00D.
**  04/07/03  Websted	Added call to ARC_UTLCheckServiceBatchBlock
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






public class Carc14s {
    
    public static final int ARC_BAT_SERVICE_BLOCKED = 19253;
    CARC14SO CARC14S(CARC14SI carc14si) {
        CARC14SO carc14so = new CARC14SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_UTLCheckServiceBatchBlock("CARC14S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        int i8 = 0;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        //##  long            rc = 0;
        
        /*********************************************************************
        **  APT 03/30/2001 BEGIN SECURITY UPGRADE
        **        Add CLSCB3D DAM declarations
        *********************************************************************/
        CLSCB3DI pCLSCB3DInputRec = null;
        CLSCB3DO pCLSCB3DOutputRec = null;
        /*********************************************************************
        **  APT 03/30/2001 END SECURITY UPGRADE
        *********************************************************************/
        CSES00DI pCSES00DInputRec = null;
        CSES00DO pCSES00DOutputRec = null;
        CLSS15DI pCLSS15DInputRec = null;
        CLSS15DO pCLSS15DOutputRec = null;
        CLSS12DI pCLSS12DInputRec = null;
        CLSS12DO pCLSS12DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(carc14si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(carc14so.getDtWCDDtSystemDate() , 0);
        
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        
        /*********************************************************************
        **  APT 03/30/2001 BEGIN SECURITY UPGRADE
        **     Allocate memory for and populate the output message
        **     for CLSCB3D DAM.
        *********************************************************************/
        
        /*
        ** Allocate memory  DAM Input and Output Structures
        */
        
        pCLSCB3DInputRec = new CLSCB3DI();
        
        pCLSCB3DOutputRec = new CLSCB3DO();
        pCLSCB3DInputRec.setArchInputStruct(carc14si.getArchInputStruct());
        pCLSCB3DInputRec.setUlIdPerson(carc14si.getUlIdPerson());
        pCLSCB3DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSCB3DO._CLSCB3DO__ROWCLSCB3DO_SIZE);
        
        
        /*
        ** Call CINT20D
        */
        rc = clscb3dQUERYdam(sqlca, pCLSCB3DInputRec, pCLSCB3DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Populate Output Message
                
                for (i8 = 0;i8 < pCLSCB3DOutputRec.getArchOutputStruct().getUlRowQty();i8++) {
                    carc14so.getROWCARC14SOG02_ARRAY().getROWCARC14SOG02(i8).setSzNmSecurityClass(pCLSCB3DOutputRec.getROWCLSCB3DO_ARRAY().getROWCLSCB3DO(i8).getSzNmSecurityClass());
                    carc14so.getROWCARC14SOG02_ARRAY().getROWCARC14SOG02(i8).setUlIdPerson(pCLSCB3DOutputRec.getROWCLSCB3DO_ARRAY().getROWCLSCB3DO(i8).getUlIdPerson());
                    carc14so.getROWCARC14SOG02_ARRAY().getROWCARC14SOG02(i8).setUlIdEmpSecLink(pCLSCB3DOutputRec.getROWCLSCB3DO_ARRAY().getROWCLSCB3DO(i8).getUlIdEmpSecLink());
                    carc14so.getROWCARC14SOG02_ARRAY().getROWCARC14SOG02(i8).setTsLastUpdate(pCLSCB3DOutputRec.getROWCLSCB3DO_ARRAY().getROWCLSCB3DO(i8).getTsLastUpdate());
                }
                carc14so.setUlRowQty2(pCLSCB3DOutputRec.getArchOutputStruct().getUlRowQty());
                carc14so.getArchOutputStruct().setBMoreDataInd(pCLSCB3DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                // 
                // OPTIONAL CODE NOTE (BEGIN): Generic Retrieve DAM 1
                // 
                
                // 
                // APT 03/30/2001 END SECURITY UPGRADE
                // 
                
                //  Allocate memory for DAM Input and Output Structures
                pCSES00DInputRec = new CSES00DI();
                
                pCSES00DOutputRec = new CSES00DO();
                pCSES00DInputRec.setArchInputStruct(carc14si.getArchInputStruct());
                pCSES00DInputRec.setUlIdPerson(carc14si.getUlIdPerson());
                rc = cses00dQUERYdam(sqlca, pCSES00DInputRec, pCSES00DOutputRec);
                
                //  Analyze error code
                switch (rc) {
                        
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        carc14so.setSzIdEmployeeLogon(pCSES00DOutputRec.getSzIdEmployeeLogon());
                        carc14so.setTsLastUpdate(pCSES00DOutputRec.getTsLastUpdate());
                        
                        // 
                        // APT 03/30/2001 END SECURITY UPGRADE
                        // 
                        // 
                        // OPTIONAL CODE NOTE (BEGIN): Generic Retrieve DAM 1
                        // 
                        
                        //  Allocate memory  DAM Input and Output Structures
                        pCLSS12DInputRec = new CLSS12DI();
                        
                        pCLSS12DOutputRec = new CLSS12DO();
                        pCLSS12DInputRec.setArchInputStruct(carc14si.getArchInputStruct());
                        pCLSS12DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS12DO._CLSS12DO__ROWCLSS12DO_SIZE);
                        rc = clss12dQUERYdam(sqlca, pCLSS12DInputRec, pCLSS12DOutputRec);
                        switch (rc) {
                                
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                
                                
                                
                                //  Populate Output Message
                                
                                //  Set fields in CARC14SOG01 to fields in CLSS12DOG00
                                
                                
                                for (i8 = 0;i8 < pCLSS12DOutputRec.getArchOutputStruct().getUlRowQty();i8++) {
                                    carc14so.getROWCARC14SOG01_ARRAY().getROWCARC14SOG01(i8).setSzNmSecurityClass(pCLSS12DOutputRec.getROWCLSS12DO_ARRAY().getROWCLSS12DO(i8).getSzNmSecurityClass());
                                    carc14so.getROWCARC14SOG01_ARRAY().getROWCARC14SOG01(i8).setCIndRestrict(pCLSS12DOutputRec.getROWCLSS12DO_ARRAY().getROWCLSS12DO(i8).getCIndRestrict());
                                }
                                carc14so.setUlRowQty(pCLSS12DOutputRec.getArchOutputStruct().getUlRowQty());
                                carc14so.getArchOutputStruct().setBMoreDataInd(pCLSS12DOutputRec.getArchOutputStruct().getBMoreDataInd());
                                
                                // 
                                // OPTIONAL CODE NOTE (BEGIN): Generic Retrieve DAM 1
                                // 
                                
                                
                                // 
                                // OPTIONAL CODE NOTE (BEGIN): Generic Retrieve DAM 1
                                // 
                                
                                //  Allocate memory  DAM Input and Output Structures
                                pCLSS15DInputRec = new CLSS15DI();
                                
                                pCLSS15DOutputRec = new CLSS15DO();
                                pCLSS15DInputRec.setArchInputStruct(carc14si.getArchInputStruct());
                                pCLSS15DInputRec.setUlIdPerson(carc14si.getUlIdPerson());
                                pCLSS15DInputRec.getArchInputStruct().setUsPageNbr(carc14si.getArchInputStruct().getUsPageNbr());
                                pCLSS15DInputRec.getArchInputStruct().setUlPageSizeNbr(carc14si.getArchInputStruct().getUlPageSizeNbr());
                                
                                
                                //  Call CRES13D
                                rc = clss15dQUERYdam(sqlca, pCLSS15DInputRec, pCLSS15DOutputRec);
                                switch (rc) {
                                    case WtcHelperConstants.SQL_SUCCESS:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        
                                        
                                        
                                        //  Populate Output Message
                                        
                                        //  Set fields in CARC14SOG00 to fields in CLSS15DOG00
                                        
                                        
                                        for (i8 = 0;i8 < pCLSS15DOutputRec.getArchOutputStruct().getUlRowQty();i8++) {
                                            carc14so.getROWCARC14SOG00_ARRAY().getROWCARC14SOG00(i8).setSzNmPersonFull(pCLSS15DOutputRec.getROWCLSS15DO_ARRAY().getROWCLSS15DO(i8).getSzNmPersonFull());
                                            carc14so.getROWCARC14SOG00_ARRAY().getROWCARC14SOG00(i8).setTsLastUpdate(pCLSS15DOutputRec.getROWCLSS15DO_ARRAY().getROWCLSS15DO(i8).getTsLastUpdate());
                                            carc14so.getROWCARC14SOG00_ARRAY().getROWCARC14SOG00(i8).setDtDtAssignExpiration(pCLSS15DOutputRec.getROWCLSS15DO_ARRAY().getROWCLSS15DO(i8).getDtDtAssignExpiration());
                                            carc14so.getROWCARC14SOG00_ARRAY().getROWCARC14SOG00(i8).setUlIdPerson(pCLSS15DOutputRec.getROWCLSS15DO_ARRAY().getROWCLSS15DO(i8).getUlIdPerson());
                                            carc14so.getROWCARC14SOG00_ARRAY().getROWCARC14SOG00(i8).setUlIdEmpTempAssign(pCLSS15DOutputRec.getROWCLSS15DO_ARRAY().getROWCLSS15DO(i8).getUlIdEmpTempAssign());
                                            carc14so.getROWCARC14SOG00_ARRAY().getROWCARC14SOG00(i8).setUlIdPersonDesignee(pCLSS15DOutputRec.getROWCLSS15DO_ARRAY().getROWCLSS15DO(i8).getUlIdPersonDesignee());
                                        }
                                        carc14so.getArchOutputStruct().setBMoreDataInd(pCLSS15DOutputRec.getArchOutputStruct().getBMoreDataInd());
                                        carc14so.getArchOutputStruct().setUlRowQty(pCLSS15DOutputRec.getArchOutputStruct().getUlRowQty());
                                        
                                    case NO_DATA_FOUND:
                                        pServiceStatus.severity = FND_SEVERITY_OK;
                                        pServiceStatus.explan_code = SUCCESS;
                                        rc = WtcHelperConstants.ARC_SUCCESS;
                                        
                                        break;
                                        
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                        
                                        break;
                                }
                                
                                break;
                                
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
                
                
                
                break;
                
                // APT 9/5/2001 SECURITY UPGRADE: comment out code for error when no row returned,
                // Added this case to the SQL_SUCCESS above
                //       case SQL_NOT_FOUND:
                
                
                //  Set severity to FND_SEVERITY_ERROR
                //        pServiceStatus->severity = FND_SEVERITY_ERROR;
                
                
                //  Set explan_code to MSG_DATABASE_RETRIEVE_FAIL
                //        pServiceStatus->explan_code = MSG_DATABASE_RETRIEVE_FAIL;
                
                
                //        break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        /*********************************************************************
        **  APT 05/10/01 END SECURITY UPGRADE
        *********************************************************************/
        
        /**************************************************************************
        ** OPTIONAL CODE NOTE (END): Calculate Output Message Size for a
        ** multiple row retrieval
        **************************************************************************/
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(carc14si.getArchInputStruct() , carc14so.getArchOutputStruct());
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
        return carc14so;
    }

}
