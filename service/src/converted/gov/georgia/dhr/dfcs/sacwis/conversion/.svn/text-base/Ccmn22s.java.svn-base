package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN22SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN22SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN49DI;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN48DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN48DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN49DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNE0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNE0DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNF3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNF3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNF4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNF4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNG5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNG5DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN36DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN36DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDC2DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDC2DO;
/**************************************************************************
** 
** Module File:   CCMN22S.src
**
** Service Name:  CCMN22S - SAVE UNIT DETAIL
**
** Description:   This service is designed to save modified or new Unit
**                Information (Unit Specialization, Parent Unit, Unit
**                Approver) and Unit Member Information (ID Person, Unit
**                Role, In/Out status).  It updates the UNIT and UNIT EMP
**                LINK tables.
**                
** DAMS           CCMN48D
**                CCMN49D
**                CCMNE0D
**                CCMNF3D
** PWO 1080:      removed CCMNF4D
** PWO 1080:      added   CCMNG5D
** PWO 1080:      added   CCMN36D
** PWO 1080:      restored CCMNF4D
**
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  23 Feb 1995 
** 
** Programmer:    KRD
**
** ** PWO 1037: svcshell.src: added 'Archive Information' lines **
** Archive Information: $Revision:   1.3  $
**                      $Date:   12 Aug 1996 14:38:56  $
**                      $Modtime:   12 Aug 1996 13:52:44  $
**                      $Author:   pvcs  $
**
** ** PWO 1037: svcshell.src: added 'Change History' heading **
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**   1Aug95   sladewmf  PWO 1037: made minor changes to comply with the 
**                      May 18 15:15 version of the svcshell.src model 
**                      (from /caps/sys/tools/shells).
**   8Aug95   sladewmf  PWO 1080: Removed references to CCMNF4D and added
**                      references to CCMNG5D.
**  24Aug95   sladewmf  PWO 1080: Added references to CCMN36D (this should
**                      have been done with the 8Aug95 change, but was not).
**                      Restored references to CCMNF4D.
**  21Apr96   sladewmf  SIR #20159: Added a call to CallCAUDC2D function.
**  7/26/96    zabihin  sir 21891 : version control code was missing, I
**                      just added the lines.
**
**   8/12/96  vanderm   SIR #21968;  Database should be restored to its
**                      original state for all services which perform
**                      updates that encounter an error.  
**                      Error handling changed from FND_SEVERITY_WARNING to
**                      FND_SEVERITY_ERROR for all AUD dams.
**
**  06/09/03   Srini    SIR# 18139 Pass the username to the dam to be logged 
**						as part of audit log.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn22s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String UNIT_MEMBER_IN_ASSIGNED = "IN";
    public static final String UNIT_MEMBER_OUT_ASSIGNED = "OUT";
    CCMN22SO CCMN22S(CCMN22SI ccmn22si) {
        CCMN22SO ccmn22so = new CCMN22SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int uCount = 0;/* loop variable */
        int ulIdUnit4 = 0;
        
        /*
        ** Need an input/output message separate from the Service input
        ** and output messages to pass data between DAMs
        **
        ** PWO 1037:
        ** The following four functions use this DamMsg: 
        ** CallCCMN49D, CallCCMNE0D, CallCCMNG5D, CallCCMNF4D
        ** CallCCMNE0D, CallCCMNG5D and CallCCMNF4D do not need all 
        ** of the values in _CCMN49DI; CallCCMN49D does.
        */
        CCMN49DI DamMsg = null;
        DamMsg.setArchInputStruct(ccmn22si.getArchInputStruct());
        rc = ARC_PRFServiceStartTime_TUX(ccmn22si.getArchInputStruct());
        pServiceStatus.severity = FND_SEVERITY_OK;
        pServiceStatus.explan_code = SUCCESS;
        
        if (WtcHelperConstants.REQ_FUNC_CD_UPDATE == ccmn22si.getArchInputStruct().getCReqFuncCd()) {
            //  A change was made to Unit Member Information, so update
            // UNIT EMP LINK
            for (uCount = 0;uCount < ccmn22si.getUlRowQty();uCount++) {
                DamMsg.setUlIdPerson(ccmn22si.getROWCCMN22SIG02_ARRAY().getROWCCMN22SIG02(uCount).getUlIdPerson());
                DamMsg.setUlIdUnit(ccmn22si.getUlIdUnit());
                if (0 == ccmn22si.getROWCCMN22SIG02_ARRAY().getROWCCMN22SIG02(uCount).getSzCdUnitMemberInOut().compareTo(UNIT_MEMBER_IN_ASSIGNED)) {
                    rc = Ccmn05s.CallCCMNG5D(DamMsg, ccmn22so, pServiceStatus);
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            
                            break;
                        case Messages.MSG_CMN_UNIT_APPROVER:
                            ulIdUnit4 = ccmn22so.getArchOutputStruct().getUlRowQty();
                            
                            
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
                if (rc == Messages.MSG_CMN_UNIT_APPROVER) {
                    
                    
                    
                    //  Start Performance Timer
                    rc = CallCCMN36D(ccmn22si, ccmn22so, ulIdUnit4, pServiceStatus);
                    
                    //  Analyze error code
                    switch (rc) {
                            
                            
                        case WtcHelperConstants.ARC_SUCCESS:
                            
                            break;
                            
                        case NO_DATA_FOUND:
                            if (DamMsg.getUlIdPerson() == ccmn22si.getROWCCMN22SIG01().getUlIdPerson()) {
                                pServiceStatus.severity = FND_SEVERITY_WARNING;
                                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            }
                            
                            break;
                        case Messages.MSG_CMN_UNIT_APPROVER:
                            pServiceStatus.severity = FND_SEVERITY_WARNING;
                            pServiceStatus.explan_code = Messages.MSG_CMN_UNIT_APPROVER;
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
                if (rc == WtcHelperConstants.ARC_SUCCESS) {
                    if ((0 == ccmn22si.getROWCCMN22SIG02_ARRAY().getROWCCMN22SIG02(uCount).getSzScrCdUnitMemberInOut().compareTo(UNIT_MEMBER_OUT_ASSIGNED)) && (0 == ccmn22si.getROWCCMN22SIG02_ARRAY().getROWCCMN22SIG02(uCount).getSzCdUnitMemberInOut().compareTo(UNIT_MEMBER_IN_ASSIGNED))) {
                        rc = CallCCMNF4D(DamMsg, ccmn22so, pServiceStatus);
                        switch (rc) {
                            case WtcHelperConstants.ARC_SUCCESS:
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        }
                        rc = CallCCMNE0D(DamMsg, ccmn22so, pServiceStatus);
                        switch (rc) {
                            case WtcHelperConstants.ARC_SUCCESS:
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        }
                    }
                    DamMsg.setUlIdPerson(ccmn22si.getROWCCMN22SIG02_ARRAY().getROWCCMN22SIG02(uCount).getUlIdPerson());
                    DamMsg.setUlIdUnitEmpLink(ccmn22si.getROWCCMN22SIG02_ARRAY().getROWCCMN22SIG02(uCount).getUlIdUnitEmpLink());
                    DamMsg.setSzCdUnitMemberInOut(ccmn22si.getROWCCMN22SIG02_ARRAY().getROWCCMN22SIG02(uCount).getSzCdUnitMemberInOut());
                    DamMsg.setSzCdUnitMemberRole(ccmn22si.getROWCCMN22SIG02_ARRAY().getROWCCMN22SIG02(uCount).getSzCdUnitMemberRole());
                    DamMsg.setTsLastUpdate(ccmn22si.getROWCCMN22SIG02_ARRAY().getROWCCMN22SIG02(uCount).getTsLastUpdate());
                    DamMsg.getArchInputStruct().setCReqFuncCd(ccmn22si.getROWCCMN22SIG02_ARRAY().getROWCCMN22SIG02(uCount).getSzCdScrDataAction());
                    DamMsg.getArchInputStruct().setSzUserId(ccmn22si.getArchInputStruct().getSzUserId());
                    
                    
                    //  Call CSES49D
                    rc = Ccmn05s.CallCCMN49D(DamMsg, ccmn22so, pServiceStatus);
                    
                    // Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.ARC_SUCCESS:
                            break;
                        case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    }
                }
            }
        }
        if (ccmn22si.getROWCCMN22SIG01().getCReqFuncCd() != null) {
            
            rc = CallCCMN48D(ccmn22si, ccmn22so, pServiceStatus);
            switch (rc) {
                case WtcHelperConstants.ARC_SUCCESS:
                    break;
                case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            
            if (ccmn22si.getROWCCMN22SIG01().getCReqFuncCd() == WtcHelperConstants.REQ_FUNC_CD_DELETE) {
                rc = CallCCMNF3D(ccmn22si, ccmn22so, pServiceStatus);
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                        
                    default :
                        
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                
                
                //  Call CCMN44D
                rc = CallCAUDC2D(ccmn22si, ccmn22so, pServiceStatus);
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(ccmn22si.getArchInputStruct() , ccmn22so.getArchOutputStruct());
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                //Do not commit as it will be committed in the called service.
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                
                //  Set rc to MSG_DETAIL_DELETED
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            //Do not commit as it will be committed in the called service.
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccmn22so;
    }

    static int CallCCMN48D(CCMN22SI pInputMsg253, CCMN22SO * pOutputMsg236, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CCMN48DI pCCMN48DInputRec = null;
        CCMN48DO pCCMN48DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN48DInputRec = new CCMN48DI();
        
        pCCMN48DOutputRec = new CCMN48DO();
        pCCMN48DInputRec.setUlIdUnit(pInputMsg253.getUlIdUnit());
        pCCMN48DInputRec.setUlIdPerson(pInputMsg253.getROWCCMN22SIG01().getUlIdPerson());
        pCCMN48DInputRec.setUlIdUnitParent(pInputMsg253.getROWCCMN22SIG01().getUlIdUnitParent());
        pCCMN48DInputRec.setSzNbrUnit(pInputMsg253.getROWCCMN22SIG01().getSzNbrUnit());
        
        
        pCCMN48DInputRec.setSzCdUnitProgram(pInputMsg253.getROWCCMN22SIG01().getSzCdUnitProgram());
        pCCMN48DInputRec.setSzCdUnitRegion(pInputMsg253.getROWCCMN22SIG01().getSzCdUnitRegion());
        pCCMN48DInputRec.setSzCdUnitSpecialization(pInputMsg253.getROWCCMN22SIG01().getSzCdUnitSpecialization());
        pCCMN48DInputRec.setTsLastUpdate(pInputMsg253.getROWCCMN22SIG01().getTsLastUpdate());
        pCCMN48DInputRec.setArchInputStruct(pInputMsg253.getArchInputStruct());
        pCCMN48DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg253.getROWCCMN22SIG01().getCReqFuncCd());
        rc = ccmn48dAUDdam(sqlca, pCCMN48DInputRec, pCCMN48DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                
                
                //  Call CRES13D
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMN49D(CCMN49DI pInputMsg254, CCMN22SO * pOutputMsg237, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CCMN49DO pCCMN49DOutputRec = new CCMN49DO();
        rc = ccmn49dAUDdam(sqlca, pInputMsg254, pCCMN49DOutputRec);
        
        /* analyze error code */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMNE0D(CCMN49DI pInputMsg255, CCMN22SO * pOutputMsg238, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CCMNE0DI pCCMNE0DInputRec = null;
        CCMNE0DO pCCMNE0DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNE0DInputRec = new CCMNE0DI();
        
        pCCMNE0DOutputRec = new CCMNE0DO();
        pCCMNE0DInputRec.setUlIdPerson(pInputMsg255.getUlIdPerson());
        
        //## BEGIN TUX/XML: Declare XML variables 
        pCCMNE0DInputRec.setSzCdUnitMemberInOut(UNIT_MEMBER_IN_ASSIGNED);
        pCCMNE0DInputRec.setArchInputStruct(pInputMsg255.getArchInputStruct());
        pCCMNE0DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_DELETE);
        
        
        /*
        ** Call CSES41D
        */
        rc = ccmne0dAUDdam(sqlca, pCCMNE0DInputRec, pCCMNE0DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMNF3D(CCMN22SI pInputMsg256, CCMN22SO * pOutputMsg239, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CCMNF3DI pCCMNF3DInputRec = null;
        CCMNF3DO pCCMNF3DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNF3DInputRec = new CCMNF3DI();
        
        pCCMNF3DOutputRec = new CCMNF3DO();
        pCCMNF3DInputRec.setUlIdUnit(pInputMsg256.getUlIdUnit());
        pCCMNF3DInputRec.setArchInputStruct(pInputMsg256.getArchInputStruct());
        pCCMNF3DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = ccmnf3dAUDdam(sqlca, pCCMNF3DInputRec, pCCMNF3DOutputRec);
        switch (rc) {
                //  
                // Insert logic to analyze the return code for the DAM here before 
                // calling the error handler.  Remember that the return code is the 
                // sqlcode from the sqlca structure.  Therefore, any sql return codes 
                // that are acceptable to your function, such as SQL_NOT_FOUND, must 
                // be handled individually here.
                // 
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
                // 05/15/03  Srini     SIR# 17294. Not returning proper error when the year is less than 1850.
            case NO_DATA_FOUND:
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMNF4D(CCMN49DI pInputMsg257, CCMN22SO * pOutputMsg240, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CCMNF4DI pCCMNF4DInputRec = null;
        CCMNF4DO pCCMNF4DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNF4DInputRec = new CCMNF4DI();
        
        pCCMNF4DOutputRec = new CCMNF4DO();
        pCCMNF4DInputRec.setUlIdPerson(pInputMsg257.getUlIdPerson());
        pCCMNF4DInputRec.setSzCdUnitMemberInOut(UNIT_MEMBER_IN_ASSIGNED);
        pCCMNF4DInputRec.setArchInputStruct(pInputMsg257.getArchInputStruct());
        pCCMNF4DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = ccmnf4dAUDdam(sqlca, pCCMNF4DInputRec, pCCMNF4DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                
                // Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMNG5D(CCMN49DI pInputMsg258, CCMN22SO pOutputMsg241, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CCMNG5DI pCCMNG5DInputRec = null;
        CCMNG5DO pCCMNG5DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNG5DInputRec = new CCMNG5DI();
        
        pCCMNG5DOutputRec = new CCMNG5DO();
        pCCMNG5DInputRec.setUlIdPerson(pInputMsg258.getUlIdPerson());
        pCCMNG5DInputRec.setArchInputStruct(pInputMsg258.getArchInputStruct());
        
        
        /*
        ** Call CCMN45D
        */
        rc = ccmng5dQUERYdam(sqlca, pCCMNG5DInputRec, pCCMNG5DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                if (pInputMsg258.getUlIdUnit() != pCCMNG5DOutputRec.getUlIdUnit()) {
                    pOutputMsg241.getArchOutputStruct().setUlRowQty(pCCMNG5DOutputRec.getUlIdUnit());
                    rc = Messages.MSG_CMN_UNIT_APPROVER;
                }
                else // (pInputMsg->ulIdUnit == pCCMNG5DOutputRec->ulIdUnit)
                {
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                
                break;
            case NO_DATA_FOUND:
                
                
                
                //  Set CMSC39DI Generic Date to current date
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;// for default CSEC04D
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMN36D(CCMN22SI pInputMsg259, CCMN22SO * pOutputMsg242, int ulIdUnit5, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i147 = 0;
        /* 
        ** Declare local variables
        */
        CCMN36DI pCCMN36DInputRec = null;
        CCMN36DO pCCMN36DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN36DInputRec = new CCMN36DI();
        
        pCCMN36DOutputRec = new CCMN36DO();
        pCCMN36DInputRec.setUlIdUnit(ulIdUnit5);
        pCCMN36DInputRec.setArchInputStruct(pInputMsg259.getArchInputStruct());
        pCCMN36DInputRec.getArchInputStruct().setUsPageNbr(1);
        
        
        pCCMN36DInputRec.getArchInputStruct().setUlPageSizeNbr(2);
        
        
        /*
        ** Call CCMN44D
        */
        rc = ccmn36dQUERYdam(sqlca, pCCMN36DInputRec, pCCMN36DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                if (2 == pCCMN36DOutputRec.getArchOutputStruct().getUlRowQty()) {
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UNIT_APPROVER;
                    
                    
                    //  Call CCMN44D
                    rc = Messages.MSG_CMN_UNIT_APPROVER;
                }
                else if (1 == pCCMN36DOutputRec.getArchOutputStruct().getUlRowQty()) {
                    rc = WtcHelperConstants.ARC_SUCCESS;
                }
                
                break;
            case NO_DATA_FOUND:
                rc = NO_DATA_FOUND;
                
                
                
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCAUDC2D(CCMN22SI pInputMsg260, CCMN22SO * pOutputMsg243, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CAUDC2DI pCAUDC2DInputRec = null;
        CAUDC2DO pCAUDC2DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCAUDC2DInputRec = new CAUDC2DI();
        
        pCAUDC2DOutputRec = new CAUDC2DO();
        pCAUDC2DInputRec.setUlIdUnit(pInputMsg260.getUlIdUnit());
        pCAUDC2DInputRec.setArchInputStruct(pInputMsg260.getArchInputStruct());
        pCAUDC2DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        rc = caudc2dAUDdam(sqlca, pCAUDC2DInputRec, pCAUDC2DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
