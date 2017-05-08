package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04UO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN32DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN32DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMND5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMND5DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA1DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNA1DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNC0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNC0DO;
/**************************************************************************
** 
** Module File:   CCMN04U.pc
**
** Service Name:  CCMN04U - UNIT ACCESS
**
** Description:   This is a common function designed to determine whether
**                or not a set of employees (the user + designees) has
**                access for unit modification.  This is performed by 
**                comparing the Unit Member Roles of the set of employees
**                against that of the unit's approver and checks up the
**                unit heirarchy via the Parent Unit, if necessary.  The
**                function receives ID PERSON for the user, ID PERSON for
**                the user's designees and either ID UNIT or CD UNIT PROGRAM,
**                CD UNIT REGION, and NBR UNIT.  It returns either TRUE or
**                FALSE.
**
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  06 March 1995
** 
** Programmer:    Karl R. Dalley / Common Cell
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:42:38  $
**                      $Modtime:   02 Feb 1996 12:57:52  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  09/28/95    KRD     Superficial changes to match the Release 1.x
**                      service shell.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/
public class Ccmn04u {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    /* Comment this line out because it is redundant to the server front end 
    ** EXEC SQL INCLUDE sqlca; */
    
    public static final String UNIT_MEMBER_ROLE_CLERK = "70";
    static int UnitAccess(CCMN04UI pInputMsg177, CCMN04UO pOutputMsg158, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = SUCCESS;
        int uCount = 0;
        char bIsApprover = 0;/* boolean variable */
        
        /*
        ** Need input/output message separates from the Service input
        ** and output messages to pass data between DAMs
        */
        CCMN32DI pDamMsg = new CCMN32DI();
        pDamMsg.setArchInputStruct(pInputMsg177.getArchInputStruct());
        pServiceStatus.severity = SUCCESS;
        pServiceStatus.explan_code = SUCCESS;
        if (pInputMsg177.getUlIdUnit() != 0) {
            
            
            //  Set rc to ARC_SUCCESS
            rc = CallCCMNA1D(pInputMsg177, pDamMsg, pServiceStatus);
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        else {
            rc = Ccmn47s.CallCCMNC0D(pInputMsg177, pDamMsg, pServiceStatus);
            
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        }
        if (pDamMsg.getUlIdPerson() != 0) {
            //  Check to see if the user or the user's designees is the
            // approver
            uCount = 0;
            bIsApprover = 0;
            while ((uCount < CCMN04UI._CCMN04UI__ULIDPERSON_SIZE) && (pInputMsg177.getUlIdPerson_ARRAY().getUlIdPerson(uCount) != 0) && (!bIsApprover)) {
                
                //  checking to see if someone with a division number is trying
                // to save.  if not then delete the leading zero in the region
                // number
                if (pInputMsg177.getUlIdPerson_ARRAY().getUlIdPerson(uCount++) == pDamMsg.getUlIdPerson()) {
                    bIsApprover = 1;
                }
            }
            pOutputMsg158.setBSysIndGeneric(bIsApprover);
            if (!(bIsApprover != 0)) {
                rc = Ccmn05s.CallCCMND5D(pDamMsg, pDamMsg, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
                rc = Ccmn29s.CallCCMN32D(pInputMsg177, pDamMsg, pOutputMsg158, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
            }
        }
        
        
        else {
            pOutputMsg158.setBSysIndGeneric(1);
        }
        return rc;
    }

    static int CallCCMN32D(CCMN04UI pInputMsg178, CCMN32DI pDamMsg, CCMN04UO pOutputMsg159, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /*
        ** Declare local variables
        */
        CCMN32DI pCCMN32DInputRec = null;
        CCMN32DO pCCMN32DOutputRec = null;
        int uCount = 0;/* counter */
        char bHasAccess = '\u0000';/* boolean ("truth") variable */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN32DInputRec = new CCMN32DI();
        pCCMN32DOutputRec = new CCMN32DO();
        pCCMN32DInputRec.setUlIdUnit(pDamMsg.getUlIdUnit());
        pCCMN32DInputRec.setSzCdUnitMemberRole(pDamMsg.getSzCdUnitMemberRole());
        pCCMN32DInputRec.setSzSysCdUnitMemberRole(UNIT_MEMBER_ROLE_CLERK);
        pCCMN32DInputRec.setArchInputStruct(pInputMsg178.getArchInputStruct());
        rc = WtcHelperConstants.ARC_SUCCESS;
        uCount = 0;
        bHasAccess = 0;
        while ((uCount < CCMN04UI._CCMN04UI__ULIDPERSON_SIZE) && (pInputMsg178.getUlIdPerson_ARRAY().getUlIdPerson(uCount) != 0) && (!bHasAccess) && (rc == WtcHelperConstants.ARC_SUCCESS)) {
            pCCMN32DInputRec.setUlIdPerson(pInputMsg178.getUlIdPerson_ARRAY().getUlIdPerson(uCount++));
            rc = ccmn32dQUERYdam(sqlca, pCCMN32DInputRec, pCCMN32DOutputRec);
            
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    //  the user has access to the unit
                    bHasAccess = 1;
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                case NO_DATA_FOUND:
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
                    break;
            }
        }
        pOutputMsg159.setBSysIndGeneric(bHasAccess);
        return rc;
    }

    static int CallCCMND5D(CCMN32DI pInputMsg179, CCMN32DI pOutputMsg160, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /* 
        ** Declare local variables
        */
        CCMND5DI pCCMND5DInputRec = null;
        CCMND5DO pCCMND5DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMND5DInputRec = new CCMND5DI();
        
        pCCMND5DOutputRec = new CCMND5DO();
        pCCMND5DInputRec.setUlIdUnit(pInputMsg179.getUlIdUnit());
        pCCMND5DInputRec.setUlIdPerson(pInputMsg179.getUlIdPerson());
        pCCMND5DInputRec.setArchInputStruct(pInputMsg179.getArchInputStruct());
        rc = ccmnd5dQUERYdam(sqlca, pCCMND5DInputRec, pCCMND5DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
                //  On an INSERT or UPDATE statement, SQL_DUPLICATE_KEY is returned
                // if there is an attempt to store a duplicate primary key value.
                // pServiceStatus->explan_code should be set to the appropriate
                // message by the programmer.
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg160.setSzCdUnitMemberRole(pCCMND5DOutputRec.getSzCdUnitMemberRole());
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCMNA1D(CCMN04UI pInputMsg180, CCMN32DI pOutputMsg161, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        /* 
        ** Declare local variables
        */
        CCMNA1DI pCCMNA1DInputRec = null;
        CCMNA1DO pCCMNA1DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNA1DInputRec = new CCMNA1DI();
        
        pCCMNA1DOutputRec = new CCMNA1DO();
        pCCMNA1DInputRec.setUlIdUnit(pInputMsg180.getUlIdUnit());
        pCCMNA1DInputRec.setArchInputStruct(pInputMsg180.getArchInputStruct());
        rc = ccmna1dQUERYdam(sqlca, pCCMNA1DInputRec, pCCMNA1DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg161.setUlIdUnit(pCCMNA1DOutputRec.getUlIdUnit());
                pOutputMsg161.setUlIdPerson(pCCMNA1DOutputRec.getUlIdPerson());
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

    static int CallCCMNC0D(CCMN04UI pInputMsg181, CCMN32DI pOutputMsg162, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /* 
        ** Declare local variables
        */
        CCMNC0DI pCCMNC0DInputRec = null;
        CCMNC0DO pCCMNC0DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNC0DInputRec = new CCMNC0DI();
        
        pCCMNC0DOutputRec = new CCMNC0DO();
        pCCMNC0DInputRec.setSzCdUnitProgram(pInputMsg181.getSzCdUnitProgram());
        pCCMNC0DInputRec.setSzCdUnitRegion(pInputMsg181.getSzCdUnitRegion());
        pCCMNC0DInputRec.setSzNbrUnit(pInputMsg181.getSzNbrUnit());
        pCCMNC0DInputRec.setArchInputStruct(pInputMsg181.getArchInputStruct());
        
        
        /*
        ** Call CCMN45D
        */
        rc = ccmnc0dQUERYdam(sqlca, pCCMNC0DInputRec, pCCMNC0DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg162.setUlIdUnit(pCCMNC0DOutputRec.getUlIdUnit());
                pOutputMsg162.setUlIdPerson(pCCMNC0DOutputRec.getUlIdPerson());
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR_NOFREE();
        }
        return rc;
    }

}
