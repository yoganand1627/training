package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN23SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04UO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.person.Ccmn04u;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND0DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN36DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN36DO;
/**************************************************************************
** 
** Module File:   CCMN23S.src
**
** Service Name:  CCMN23S - RETRIEVE UNIT DETAIL
**
** Description:   This service is designed to retrieve the list of 
**                employees assigned to a particular unit.  It receives
**                ID UNIT, ID PERSON for the user and the user's designees,
**                and SYS CD WIN MODE.  It returns data from the EMP JOB
**                HISTORY, PERSON, and UNIT EMP LINK tables.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  17 February 1995 
** 
** Programmer:    KRD
**
** Archive Information: $Revision:   1.2  $
**                      $Date:   06 Aug 1996 11:21:28  $
**                      $Modtime:   05 Aug 1996 16:49:04  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  09/15/95    KRD     SIR 1351 - Remove if statement surrounding call to
**                      CallCCMN36D() <see comment below>.  Modified service
**                      to match the Release 1.x service shell.
**  7/26/96    zabihin  sir 21891 : version control code was missing, I
**                      just added the lines.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccmn23s {
    CCMN23SO CCMN23S(CCMN23SI ccmn23si) {
        CCMN23SO ccmn23so = new CCMN23SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int uCount = 0;/* loop variable */
        CCMN04UI pInput = null;
        CCMN04UO pOutput = null;
        rc = ARC_PRFServiceStartTime_TUX(ccmn23si.getArchInputStruct());
        
        
        /*
        ** Start Performance Timer
        */
        rc = CallCCMND0D(ccmn23si, ccmn23so, pServiceStatus);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                break;
                //  All that we care about from the DAM is a TRUE or FALSE statement
                // as to whether the employee is a unit approver.  So, if the DAM
                // returns SQL_SUCCESS, then the employee is a unit approver, so return
                // an error message.  If the DAM returns SQL_NOT_FOUND, then the employee
                // is not an approver, so the modification desired can continue.
            case Messages.MSG_NO_ROWS_RETURNED:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
        }
        
        /*
        ** Determine whether or not a user has access to a unit in inquiry
        ** or modify mode by calling the UnitAccess() common function
        */
        
        /*
        ** Allocate memory for Unit Access Input and Output Structures
        */
        pInput = new CCMN04UI();
        
        pOutput = new CCMN04UO();
        pInput.setUlIdUnit(ccmn23so.getROWCCMN23SOG02().getUlIdUnit());
        
        /*
        ** Check for unit access
        */
        while ((uCount < CCMN23SI._CCMN23SI__ULIDPERSON_SIZE) && (ccmn23si.getUlIdPerson_ARRAY().getUlIdPerson(uCount) != 0)) {
            pInput.getUlIdPerson_ARRAY().setUlIdPerson(uCount, ccmn23si.getUlIdPerson_ARRAY().getUlIdPerson(uCount));
            uCount++;
        }
        rc = Ccmn04u.UnitAccess(pInput, pOutput, pServiceStatus);
        
        /*
        ** Analyze error code
        */
        /*
        ** Analyze error code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        if (pOutput.getBSysIndGeneric() == true) {
            ccmn23so.getROWCCMN23SOG02().setSzSysCdWinMode(WINDOW_MODE_MODIFY);
            
        }
        else {
            ccmn23so.getROWCCMN23SOG02().setSzSysCdWinMode(WINDOW_MODE_INQUIRE);
        }
        rc = CallCCMN36D(ccmn23si, ccmn23so, pServiceStatus);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(ccmn23si.getArchInputStruct() , ccmn23so.getArchOutputStruct());
        
        /*
        ** Analyze error code
        */
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            //  Analyze error code
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                
                //  Initialize rc for loop
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        
        return ccmn23so;
    }

    static int CallCCMND0D(CCMN23SI pInputMsg261, CCMN23SO pOutputMsg244, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CCMND0DI pCCMND0DInputRec = null;
        CCMND0DO pCCMND0DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMND0DInputRec = new CCMND0DI();
        
        pCCMND0DOutputRec = new CCMND0DO();
        
        pCCMND0DInputRec.setArchInputStruct(pInputMsg261.getArchInputStruct());
        pCCMND0DInputRec.setUlIdUnit(pInputMsg261.getUlIdUnit());
        
        rc = ccmnd0dQUERYdam(sqlca, pCCMND0DInputRec, pCCMND0DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg244.getROWCCMN23SOG02().setUlIdUnit(pCCMND0DOutputRec.getUlIdUnit());
                pOutputMsg244.getROWCCMN23SOG02().setUlIdPerson(pCCMND0DOutputRec.getUlIdPerson());
                pOutputMsg244.getROWCCMN23SOG02().setUlIdUnitParent(pCCMND0DOutputRec.getUlIdUnitParent());
                pOutputMsg244.getROWCCMN23SOG02().setSzCdUnitProgram(pCCMND0DOutputRec.getSzCdUnitProgram());
                pOutputMsg244.getROWCCMN23SOG02().setSzCdUnitRegion(pCCMND0DOutputRec.getSzCdUnitRegion());
                pOutputMsg244.getROWCCMN23SOG02().setSzNbrUnit(pCCMND0DOutputRec.getSzNbrUnit());
                pOutputMsg244.getROWCCMN23SOG02().setSzScrNbrUnitParent(pCCMND0DOutputRec.getSzScrNbrUnitParent());
                pOutputMsg244.getROWCCMN23SOG02().setSzCdUnitSpecialization(pCCMND0DOutputRec.getSzCdUnitSpecialization());
                pOutputMsg244.getROWCCMN23SOG02().setTsLastUpdate(pCCMND0DOutputRec.getTsLastUpdate());
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                
                //  Set rc to MSG_DETAIL_DELETED
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCCMN36D(CCMN23SI pInputMsg262, CCMN23SO pOutputMsg245, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i148 = 0;
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
        pCCMN36DInputRec.setArchInputStruct(pInputMsg262.getArchInputStruct());
        pCCMN36DInputRec.setUlIdUnit(pInputMsg262.getUlIdUnit());
        
        
        /*
        ** Call CSEC35D
        */
        rc = ccmn36dQUERYdam(sqlca, pCCMN36DInputRec, pCCMN36DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                //  Populate Output Message
                for (i148 = 0;i148 < pCCMN36DOutputRec.getArchOutputStruct().getUlRowQty();++i148) {
                    pOutputMsg245.getROWCCMN23SOG01_ARRAY().getROWCCMN23SOG01(i148).setSzNmPersonFull(pCCMN36DOutputRec.getROWCCMN36DO_ARRAY().getROWCCMN36DO(i148).getSzNmPersonFull());
                    pOutputMsg245.getROWCCMN23SOG01_ARRAY().getROWCCMN23SOG01(i148).setSzCdUnitMemberRole(pCCMN36DOutputRec.getROWCCMN36DO_ARRAY().getROWCCMN36DO(i148).getSzCdUnitMemberRole());
                    pOutputMsg245.getROWCCMN23SOG01_ARRAY().getROWCCMN23SOG01(i148).setSzCdUnitMemberInOut(pCCMN36DOutputRec.getROWCCMN36DO_ARRAY().getROWCCMN36DO(i148).getSzCdUnitMemberInOut());
                    pOutputMsg245.getROWCCMN23SOG01_ARRAY().getROWCCMN23SOG01(i148).setSzBjnJob(pCCMN36DOutputRec.getROWCCMN36DO_ARRAY().getROWCCMN36DO(i148).getSzBjnJob());
                    pOutputMsg245.getROWCCMN23SOG01_ARRAY().getROWCCMN23SOG01(i148).setUlIdPerson(pCCMN36DOutputRec.getROWCCMN36DO_ARRAY().getROWCCMN36DO(i148).getUlIdPerson());
                    pOutputMsg245.getROWCCMN23SOG01_ARRAY().getROWCCMN23SOG01(i148).setUlIdUnitEmpLink(pCCMN36DOutputRec.getROWCCMN36DO_ARRAY().getROWCCMN36DO(i148).getUlIdUnitEmpLink());
                    pOutputMsg245.getROWCCMN23SOG01_ARRAY().getROWCCMN23SOG01(i148).setTsLastUpdate(pCCMN36DOutputRec.getROWCCMN36DO_ARRAY().getROWCCMN36DO(i148).getTsLastUpdate());
                }
                pOutputMsg245.getArchOutputStruct().setUlRowQty(pCCMN36DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg245.getArchOutputStruct().setBMoreDataInd(pCCMN36DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                
                //  Set rc to ARC_SUCCESS
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            case NO_DATA_FOUND:
                
                
                //  Set rc to ARC_SUCCESS
                rc = WtcHelperConstants.SQL_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
