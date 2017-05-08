package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN32DI;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn04u;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN33DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN33DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN67DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN67DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN32DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC79DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC79DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC80DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC80DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSECC3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSECC3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSECC4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSECC4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSECC5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSECC5DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSECC6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSECC6DO;
/**************************************************************************
**
** Module File:   CCMN29S.src
**
** Service Name:  CCMN29S - RETRIEVE UNIT SUMMARY
**
** Description:   This service is designed to retrieve Unit Summary
**                information from the database.  It is sent CD UNIT
**                PROGRAM, CD UNIT REGION, NBR UNIT, ID PERSON for the
**                user, and ID PERSON for the user's designees.  It returns
**                data from the Unit Summary View which is built from the
**                EMPLOYEE, PERSON, STAGE, STAGE PERSON LINK, and UNIT
**                EMP LINK tables.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  09 January 1995
**
** Programmer:    KRD
**
** Archive Information: $Revision:   1.2  $
**                      $Date:   28 Oct 1996 16:31:28  $
**                      $Modtime:   28 Oct 1996 14:17:40  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  05/16/95  KRD       Corrections to meet new error handling standards
**  01/25/96  FOGARTIS  SIR#2108 R1/2#46 - Added FSU, PAD, PAL, ARI, ARF
**                      removed GDN stages to unit summary view to listbox.
**                      affected area: dam67 output to service output.
**  06/26/96  MAXHAMKJ  SIR 21661:  Performance changes - ccmn67d.pc only
**                      gets total stages and total primaries from the
**                      unit summary view now.
**  10/20/96  MAXHAMKJ  SIR 11939: Since creation of workload table, views
**                      (which eat up system resources) are no longer needed.
**                      However, to get all Unit Summary data, two more DAMs
**                      must be added to service (csec79d and csec80d), and
**                      existing ccmn67d must be modified.
**
**  12/17/02  Srini D   Added goto and END statements to accomodate the intermediate
**                      service returns.
**  07/14/05  CASDORJM  SIR 23689 - Added 4 new DAMS in order to retrieve
**                      the number of INV stages assigned that are over 30 days
**                      old and the number of SVC stages that are over 60 days old
**                      these DAMS will only be run if the program selected is APS.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn29s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String UNIT_MEMBER_ROLE_CLERK = "70";
    public static final int INITIAL_PAGE = 1;
    public static final int PAGE_SIZE_NUMBER = 50;
    public static final String APS_PROGRAM = "APS";
    CCMN29SO CCMN29S(CCMN29SI ccmn29si) {
        boolean goto_END = false;
        CCMN29SO ccmn29so = new CCMN29SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int uCount = 0;/* loop counter */
        boolean bIsApprover = false;/* flag to indicate approver status */
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        
        /*
        ** Need an input/output message separate from the Service input
        ** and output messages to pass data between DAMs
        */
        CCMN32DI pDamMsg = null;
        rc = ARC_PRFServiceStartTime_TUX(ccmn29si.getArchInputStruct());
        
        /*
        ** Allocate memory for separate DAM input/output messages
        */
        pDamMsg = new CCMN32DI();
        pDamMsg.setArchInputStruct(ccmn29si.getArchInputStruct());
        rc = CallCCMN33D(ccmn29si, pDamMsg, pServiceStatus);
        
        /* 05/21/2003 mcclaim added; 
        rc gets overwritten in many places after RetVal == FND_FAIL */
        if (rc != SUCCESS) {
            if (rc != Messages.MSG_CMN_INVALID_UNIT) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            goto END;
        }
        
        /*
        ** Unit exists, so check for Approval Responsibility and retrieve
        ** Unit Summary
        **
        ** Check to see if the user or the user's designees is the approver
        */
        while ((uCount < CCMN29SI._CCMN29SI__ULIDPERSON_SIZE) && (ccmn29si.getUlIdPerson_ARRAY().getUlIdPerson(uCount) != 0) && (!bIsApprover)) {
            
            if (ccmn29si.getUlIdPerson_ARRAY().getUlIdPerson(uCount++) == pDamMsg.getUlIdPerson()) {
                bIsApprover = true;
            }
        }
        //## END TUX/XML: Turn the XML buffer into an input message struct
        
        
        
        if (!bIsApprover) {
            
            
            //  Call CSES81D
            rc = Ccmn04u.CallCCMN32D(ccmn29si, pDamMsg, ccmn29so, pServiceStatus);
            
            // SIR 21891 - missing versioning
            //  Run-time Versioning
            
            //  Check buffer size
            //  Process error message and return to client
            
            //  Initialize output message and length
            
            //  Initialize service status fields
            
            // 
            // Call DAMs to retrieve data
            // 
            if (rc != SUCCESS) {
                
                
                // SIR 23815 - Only call this retrieve if we are coming in
                // to an non-filtered workload.
                if (rc != Messages.MSG_CMN_INVALID_ACCESS) //  IMPACT END
                {
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                goto END;
            }
        }
        rc = CallCCMN67D(pDamMsg, ccmn29so, pServiceStatus);
        
        /* ISF 052495 */
        if (rc != SUCCESS) {
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            goto_END = true;
            
            //  Call Common Function to find out if user is a supervisor or not.
            // Only call this the first time the service is invoked.
        }
        
        if (!(goto_END)) {
            
            if (ccmn29si.getCScrIndAsgnTotal() == 1) {
                rc = CallCSEC79D(ccmn29si, ccmn29so, pServiceStatus);
                if (0 == ccmn29si.getSzCdUnitProgram().compareTo(APS_PROGRAM)) {
                    
                    rc = CallCSECC3D(ccmn29si, ccmn29so, pServiceStatus);
                    
                    rc = CallCSECC4D(ccmn29si, ccmn29so, pServiceStatus);
                }
                //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                
                
                
            }
            else if (ccmn29si.getCScrIndAsgnTotal() == 2) {
                
                rc = CallCSEC80D(ccmn29si, ccmn29so, pServiceStatus);
                
                if (0 == ccmn29si.getSzCdUnitProgram().compareTo(APS_PROGRAM)) {
                    
                    
                    rc = CallCSECC5D(ccmn29si, ccmn29so, pServiceStatus);
                    rc = CallCSECC6D(ccmn29si, ccmn29so, pServiceStatus);
                }
            }
            
            //  Setup for service function exit
            
            
            ARC_PRFServiceStopTime_TUX(ccmn29si.getArchInputStruct() , ccmn29so.getArchOutputStruct());
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
        return ccmn29so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;/* Return code */
        pOutputMsgTransMap.map_name = CCMN29S_XLT_OUT;
        pOutputMsgTransMap.map_version = WtcHelperConstants.MAP_VERSION;
        
        /*
        ** Stop performance timer for service
        */
        
        ARC_PRFServiceStopTime_TUX(Csys08s.pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        return SUCCESS;
    }

    static int CallCCMN33D(CCMN29SI pInputMsg277, CCMN32DI pOutputMsg260, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CCMN33DI pCCMN33DInputRec = null;
        CCMN33DO pCCMN33DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN33DInputRec = new CCMN33DI();
        
        pCCMN33DOutputRec = new CCMN33DO();
        pCCMN33DInputRec.setArchInputStruct(pInputMsg277.getArchInputStruct());
        pCCMN33DInputRec.setSzCdUnitProgram(pInputMsg277.getSzCdUnitProgram());
        pCCMN33DInputRec.setSzCdUnitRegion(pInputMsg277.getSzCdUnitRegion());
        pCCMN33DInputRec.setSzNbrUnit(pInputMsg277.getSzNbrUnit());
        /*
        ** Call DAM 19 to get NM STAGE and primary worker 
        */
        rc = ccmn33dQUERYdam(sqlca, pCCMN33DInputRec, pCCMN33DOutputRec);
        if (rc != 0) {
            
            //  Analyze return code for CINV51D (PC)
            switch (rc) {
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_INVALID_UNIT;
                    rc = Messages.MSG_CMN_INVALID_UNIT;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        else {
            pOutputMsg260.setUlIdUnit(pCCMN33DOutputRec.getUlIdUnit());
            
            pOutputMsg260.setSzCdUnitMemberRole(pCCMN33DOutputRec.getSzCdUnitMemberRole());
            
            pOutputMsg260.setUlIdPerson(pCCMN33DOutputRec.getUlIdPerson());
        }
        return rc;
    }

    static int CallCCMN67D(CCMN32DI pInputMsg278, CCMN29SO pOutputMsg261, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** Declare local variables
        */
        int rc = 0;
        int i151 = 0;
        /*
        ** Declare local variables
        */
        CCMN67DI pCCMN67DInputRec = null;
        CCMN67DO pCCMN67DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN67DInputRec = new CCMN67DI();
        
        pCCMN67DOutputRec = new CCMN67DO();
        pCCMN67DInputRec.setArchInputStruct(pInputMsg278.getArchInputStruct());
        pCCMN67DInputRec.setUlIdUnit(pInputMsg278.getUlIdUnit());
        pCCMN67DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCCMN67DInputRec.getArchInputStruct().setUlPageSizeNbr(PAGE_SIZE_NUMBER);
        rc = ccmn67dQUERYdam(sqlca, pCCMN67DInputRec, pCCMN67DOutputRec);
        if (rc != 0) {
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        else {
            //  Populate Output Message
            for (i151 = 0;i151 < pCCMN67DOutputRec.getArchOutputStruct().getUlRowQty();++i151) {
                pOutputMsg261.getROWCCMN29SOG01_ARRAY().getROWCCMN29SOG01(i151).setSzBjnJob(pCCMN67DOutputRec.getROWCCMN67DO_ARRAY().getROWCCMN67DO(i151).getSzBjnJob());
                pOutputMsg261.getROWCCMN29SOG01_ARRAY().getROWCCMN29SOG01(i151).setSzNmPersonFull(pCCMN67DOutputRec.getROWCCMN67DO_ARRAY().getROWCCMN67DO(i151).getSzNmPersonFull());
                pOutputMsg261.getROWCCMN29SOG01_ARRAY().getROWCCMN29SOG01(i151).setSzBjnJob(pCCMN67DOutputRec.getROWCCMN67DO_ARRAY().getROWCCMN67DO(i151).getSzBjnJob());
                
                //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                pOutputMsg261.getROWCCMN29SOG01_ARRAY().getROWCCMN29SOG01(i151).setSzCdUnitMemberInOut(pCCMN67DOutputRec.getROWCCMN67DO_ARRAY().getROWCCMN67DO(i151).getSzCdUnitMemberInOut());
                pOutputMsg261.getROWCCMN29SOG01_ARRAY().getROWCCMN29SOG01(i151).setUlIdPerson(pCCMN67DOutputRec.getROWCCMN67DO_ARRAY().getROWCCMN67DO(i151).getUlIdPerson());
            }
            pOutputMsg261.getArchOutputStruct().setUlRowQty(pCCMN67DOutputRec.getArchOutputStruct().getUlRowQty());
            pOutputMsg261.getArchOutputStruct().setBMoreDataInd(pCCMN67DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return rc;
    }

    static int CallCCMN32D(CCMN29SI pInputMsg279, CCMN32DI pDamMsg, CCMN29SO * pOutputMsg262, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CCMN32DI pCCMN32DInputRec = null;
        CCMN32DO pCCMN32DOutputRec = null;
        int uCount = 0;/* counter */
        boolean bHasAccess = false;/* boolean ("truth") variable */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN32DInputRec = new CCMN32DI();
        
        pCCMN32DOutputRec = new CCMN32DO();
        pCCMN32DInputRec.setArchInputStruct(pInputMsg279.getArchInputStruct());
        pCCMN32DInputRec.setUlIdUnit(pDamMsg.getUlIdUnit());
        
        pCCMN32DInputRec.setSzCdUnitMemberRole(pDamMsg.getSzCdUnitMemberRole());
        
        pCCMN32DInputRec.setSzSysCdUnitMemberRole(UNIT_MEMBER_ROLE_CLERK);
        
        /*
        ** Move the ID PERSON for the employee and designees from the
        ** Service input message to the DAM input message
        **
        ** Assumption:
        **     _CCMN29SI__ULIDPERSON_SIZE == _CCMN32DI__ULIDPERSON_SIZE
        **
        ** Check the number of (user + designees) which have either a
        ** "Clerk" role for the unit or are the approver or are above
        ** the approver in the unit heirarchy
        */
        uCount = 0;
        bHasAccess = false;
        while ((uCount < CCMN29SI._CCMN29SI__ULIDPERSON_SIZE) && (pInputMsg279.getUlIdPerson_ARRAY().getUlIdPerson(uCount) != 0) && (!bHasAccess)) {
            pCCMN32DInputRec.setUlIdPerson(pInputMsg279.getUlIdPerson_ARRAY().getUlIdPerson(uCount++));
            
            //  Call PostEvent
            rc = ccmn32dQUERYdam(sqlca, pCCMN32DInputRec, pCCMN32DOutputRec);
            if (rc != 0) {
                
                
                //  Analyze return code
                switch (rc) {
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.MSG_CMN_INVALID_ACCESS;
                        //  Call TodoCommonFunction
                        rc = Messages.MSG_CMN_INVALID_ACCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
            
            else {
                //  the user has access to the unit
                bHasAccess = true;
                pServiceStatus.severity = SUCCESS;
                pServiceStatus.explan_code = SUCCESS;
            }
        }
        return rc;
    }

    static int CallCSEC79D(CCMN29SI pInputMsg280, CCMN29SO pOutputMsg263, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CSEC79DI pCSEC79DInputRec = null;
        CSEC79DO pCSEC79DOutputRec = null;
        int uCount = 0;/* counter */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSEC79DInputRec = new CSEC79DI();
        
        pCSEC79DOutputRec = new CSEC79DO();
        
        
        /*
        ** Move the ID PERSON for the employee and designees from the
        ** Service input message to the DAM input message
        ** Repeat until all the ID PERSONS returned from CCMN67D
        ** have been passed into DAM.
        */
        
        for (uCount = 0;uCount < pOutputMsg263.getArchOutputStruct().getUlRowQty();uCount++) {
            
            pCSEC79DInputRec.setArchInputStruct(pInputMsg280.getArchInputStruct());
            pCSEC79DInputRec.setUlIdPerson(pOutputMsg263.getROWCCMN29SOG01_ARRAY().getROWCCMN29SOG01(uCount).getUlIdPerson());
            
            //  Call CSEC72D
            rc = csec79dQUERYdam(sqlca, pCSEC79DInputRec, pCSEC79DOutputRec);
            //  If the date string is null, (2 single quotes), the date
            // string is valid, so set the invalid indicator to FALSE.
            if (rc != 0) {
                switch (rc) {
                        
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = SUCCESS;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        // Set rc to ARC_SUCCESS
                        rc = SUCCESS;
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        // 
                        // End Call to Case Reopen Dam - CMSC18D
                        // 
                        
                        break;
                }
            }
            
            else {
                pServiceStatus.severity = SUCCESS;
                pServiceStatus.explan_code = SUCCESS;
                
                pOutputMsg263.getROWCCMN29SOG01_ARRAY().getROWCCMN29SOG01(uCount).setUsScrNbrTotPAssignments(pCSEC79DOutputRec.getUsScrNbrTotalAssignments());
            }
        }
        return rc;
    }

    static int CallCSEC80D(CCMN29SI pInputMsg281, CCMN29SO pOutputMsg264, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CSEC80DI pCSEC80DInputRec = null;
        CSEC80DO pCSEC80DOutputRec = null;
        int uCount = 0;/* counter */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSEC80DInputRec = new CSEC80DI();
        
        pCSEC80DOutputRec = new CSEC80DO();
        
        
        
        /*
        ** Move the ID PERSON for the employee and designees from the
        ** Service input message to the DAM input message
        ** Repeat until all the ID PERSONS returned from CCMN67D
        ** have been passed into DAM.
        */
        
        for (uCount = 0;uCount < pOutputMsg264.getArchOutputStruct().getUlRowQty();uCount++) {
            pCSEC80DInputRec.setArchInputStruct(pInputMsg281.getArchInputStruct());
            pOutputMsg264.getROWCCMN29SOG01_ARRAY().getROWCCMN29SOG01(uCount).getUlIdPerson();
            pCSEC80DInputRec.setUlIdPerson(pOutputMsg264.getROWCCMN29SOG01_ARRAY().getROWCCMN29SOG01(uCount).getUlIdPerson());
            
            
            rc = csec80dQUERYdam(sqlca, pCSEC80DInputRec, pCSEC80DOutputRec);
            
            // 
            // END CAUD08D
            // 
            // End SIR #15787
            
            
            
            
            
            
            // END ADD CODE 
            
            
            // 
            // (END): Contract creation process if the contract does not already
            // exist. SIR 20083
            // 
            
            // 
            // (BEGIN): Contract modification process if the contract already
            // exists and a change has been made to the home's County field.
            // SIR 20083
            // 
            //  UPDATE CODE 
            
            if (rc != 0) {
                
                //  Analyze error code
                // 15028  switch(rc)
                // case SQL_NOT_FOUND:
                // {
                // bRsnDthEdit = TRUE;
                // pOutputMsg->CINV15SOG01.usSysNbrMessageCode[EditWarningRowCtr] =
                // MSG_INV_RSN_DTH_EDIT;
                // Increment counter by 1
                // EditWarningRowCtr++;
                // break;
                // }
                // case SQL_SUCCESS:
                // {
                // rc = ARC_SUCCESS;
                // break;
                // }
                // default:
                // PROCESS_TUX_SQL_ERROR;
                // }  end switch
                
                // SIR 15028
                //  Analyze error code
                switch (rc) {
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = SUCCESS;
                        pServiceStatus.explan_code = SUCCESS;
                        rc = SUCCESS;
                        
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        break;
                }
            }
            
            else {
                pServiceStatus.severity = SUCCESS;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg264.getROWCCMN29SOG01_ARRAY().getROWCCMN29SOG01(uCount).setUsScrNbrTotPAssignments(pCSEC80DOutputRec.getUsScrNbrTotPAssignments());
            }
        }
        return rc;
    }

    static int CallCSECC3D(CCMN29SI pInputMsg282, CCMN29SO pOutputMsg265, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CSECC3DI pCSECC3DInputRec = null;
        CSECC3DO pCSECC3DOutputRec = null;
        int uCount = 0;/* counter */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSECC3DInputRec = new CSECC3DI();
        
        pCSECC3DOutputRec = new CSECC3DO();
        
        
        /*
        ** Move the ID PERSON for the employee and designees from the
        ** Service input message to the DAM input message
        ** Repeat until all the ID PERSONS returned from CCMN67D
        ** have been passed into DAM.
        */
        
        for (uCount = 0;uCount < pOutputMsg265.getArchOutputStruct().getUlRowQty();uCount++) {
            pCSECC3DInputRec.setArchInputStruct(pInputMsg282.getArchInputStruct());
            pCSECC3DInputRec.setUlIdPerson(pOutputMsg265.getROWCCMN29SOG01_ARRAY().getROWCCMN29SOG01(uCount).getUlIdPerson());
            rc = csecc3dQUERYdam(sqlca, pCSECC3DInputRec, pCSECC3DOutputRec);
            
            // Set the CCMN01UI ReqFuncCd to REQ_FUNC_CD_ADD if a NULL value
            // ulIdEvent is passed in
            
            if (rc != 0) {
                
                
                //  Analyze return code
                switch (rc) {
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = SUCCESS;
                        pServiceStatus.explan_code = SUCCESS;
                        rc = SUCCESS;
                        
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        
                        
                        
                        break;
                }
            }
            
            else {
                pServiceStatus.severity = SUCCESS;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg265.getROWCCMN29SOG01_ARRAY().getROWCCMN29SOG01(uCount).setUsScrNbrTotInv30(pCSECC3DOutputRec.getTotalInvAssignments());
            }
        }
        return rc;
    }

    static int CallCSECC4D(CCMN29SI pInputMsg283, CCMN29SO pOutputMsg266, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CSECC4DI pCSECC4DInputRec = null;
        CSECC4DO pCSECC4DOutputRec = null;
        int uCount = 0;/* counter */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSECC4DInputRec = new CSECC4DI();
        
        pCSECC4DOutputRec = new CSECC4DO();
        
        
        /*
        ** Move the ID PERSON for the employee and designees from the
        ** Service input message to the DAM input message
        ** Repeat until all the ID PERSONS returned from CCMN67D
        ** have been passed into DAM.
        */
        
        for (uCount = 0;uCount < pOutputMsg266.getArchOutputStruct().getUlRowQty();uCount++) {
            pCSECC4DInputRec.setArchInputStruct(pInputMsg283.getArchInputStruct());
            pCSECC4DInputRec.setUlIdPerson(pOutputMsg266.getROWCCMN29SOG01_ARRAY().getROWCCMN29SOG01(uCount).getUlIdPerson());
            
            
            //  Call CSES68D
            rc = csecc4dQUERYdam(sqlca, pCSECC4DInputRec, pCSECC4DOutputRec);
            if (rc != 0) {
                
                //  Analyze return code
                switch (rc) {
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = SUCCESS;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        rc = SUCCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
            
            else {
                pServiceStatus.severity = SUCCESS;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg266.getROWCCMN29SOG01_ARRAY().getROWCCMN29SOG01(uCount).setUsScrNbrTotSvc60(pCSECC4DOutputRec.getTotalSvcAssignments());
            }
        }
        return rc;
    }

    static int CallCSECC5D(CCMN29SI pInputMsg284, CCMN29SO pOutputMsg267, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CSECC5DI pCSECC5DInputRec = null;
        CSECC5DO pCSECC5DOutputRec = null;
        int uCount = 0;/* counter */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSECC5DInputRec = new CSECC5DI();
        
        pCSECC5DOutputRec = new CSECC5DO();
        
        
        /*
        ** Move the ID PERSON for the employee and designees from the
        ** Service input message to the DAM input message
        ** Repeat until all the ID PERSONS returned from CCMN67D
        ** have been passed into DAM.
        */
        
        for (uCount = 0;uCount < pOutputMsg267.getArchOutputStruct().getUlRowQty();uCount++) {
            pCSECC5DInputRec.setArchInputStruct(pInputMsg284.getArchInputStruct());
            pCSECC5DInputRec.setUlIdPerson(pOutputMsg267.getROWCCMN29SOG01_ARRAY().getROWCCMN29SOG01(uCount).getUlIdPerson());
            rc = csecc5dQUERYdam(sqlca, pCSECC5DInputRec, pCSECC5DOutputRec);
            if (rc != 0) {
                
                
                //  Analyze return code
                switch (rc) {
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = SUCCESS;
                        pServiceStatus.explan_code = SUCCESS;
                        rc = SUCCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
            
            else {
                pServiceStatus.severity = SUCCESS;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg267.getROWCCMN29SOG01_ARRAY().getROWCCMN29SOG01(uCount).setUsScrNbrTotInv30(pCSECC5DOutputRec.getTotalPInvAssignments());
            }
        }
        return rc;
    }

    static int CallCSECC6D(CCMN29SI pInputMsg285, CCMN29SO pOutputMsg268, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /*
        ** Declare local variables
        */
        int rc = 0;
        /*
        ** Declare local variables
        */
        CSECC6DI pCSECC6DInputRec = null;
        CSECC6DO pCSECC6DOutputRec = null;
        int uCount = 0;/* counter */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSECC6DInputRec = new CSECC6DI();
        
        pCSECC6DOutputRec = new CSECC6DO();
        
        
        /*
        ** Move the ID PERSON for the employee and designees from the
        ** Service input message to the DAM input message
        ** Repeat until all the ID PERSONS returned from CCMN67D
        ** have been passed into DAM.
        */
        
        for (uCount = 0;uCount < pOutputMsg268.getArchOutputStruct().getUlRowQty();uCount++) {
            pCSECC6DInputRec.setArchInputStruct(pInputMsg285.getArchInputStruct());
            pCSECC6DInputRec.setUlIdPerson(pOutputMsg268.getROWCCMN29SOG01_ARRAY().getROWCCMN29SOG01(uCount).getUlIdPerson());
            
            //  Call DAM
            rc = csecc6dQUERYdam(sqlca, pCSECC6DInputRec, pCSECC6DOutputRec);
            if (rc != 0) {
                
                //  Analyze error code
                switch (rc) {
                    case NO_DATA_FOUND:
                        pServiceStatus.severity = SUCCESS;
                        pServiceStatus.explan_code = SUCCESS;
                        rc = SUCCESS;
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
            }
            
            else {
                pServiceStatus.severity = SUCCESS;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg268.getROWCCMN29SOG01_ARRAY().getROWCCMN29SOG01(uCount).setUsScrNbrTotSvc60(pCSECC6DOutputRec.getTotalPSvcAssignments());
            }
        }
        return rc;
    }

}
