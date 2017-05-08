package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDE5DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDE5DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC01DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC01DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSCB4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSCB4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC06DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC06DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS12DO;
/**************************************************************************
**
** Module File:   CARC01S.SRC
**
** Service Name:  CARC01S - GET USER PROFILE
**
** Description:   Retrieves information about the current user based on
**                the user's logon ID.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  December 1, 1994
**
** Programmer:    Belinda L. Muse
**
** Archive Information: $Revision:   1.3  $
**                      $Date:   01 Mar 2002 12:29:16  $
**                      $Modtime:   11 Feb 2002 13:47:08  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  05/25/95  B.Wallace Modified to use new service shell
**  08/31/95    KRD     Modified due to name change of ADDR_OFFICE_CITY to
**                      ADDR_MAIL_CODE_CITY.  Required a change in
**                      CallCARC01D().
**
**  09/04/96  vanderm   SIR 10940 - removed dam carc07d since batch processes
**                      delete all expired records.
**
**  04/19/2001  SLC     SECUIRITY UPGRADE: The service will be modified to
**                      construct a single Security Profile based on all the
**                      profiles assigned to the user as well as the profiles
**                      of staff for which the user is assigned as a
**                      designee.  Several code modifications have been
**                      made to this service in addition to adding a call
**                      to CLSCB4D.PC.  The function, CARC06D, was changed to
**                      CLSCB4D to incorporate these changes.
**
** 11/01/2001   DWW     WARRANTY SIR # 15927: The DAM carc06d originally returned
**                      a list of all the CD_SECURITY_CLASS_NAMEs linked to
**                      all Designators designating the person represented by
**                      the ulPersonId passed to this DAM. In other words,
**                      it returned the results to this query:
**
**                      SELECT ETA.ID_PERSON_EMP,
**                      ECL.CD_SECURITY_CLASS_NAME,
**                      E.CD_EMPLOYEE_CLASS,
**                      ETA.DT_ASSIGN_EXPIRATION
**                      FROM   EMP_TEMP_ASSIGN     ETA,
**                      EMPLOYEE            E,
**                      EMP_SEC_CLASS_LINK  ECL
**                      WHERE  ETA.ID_PERSON_DESIGNEE   = :hI_ulIdPerson:hI_ulIdPerson_i
**                      AND    ETA.DT_ASSIGN_EXPIRATION >= sysdate
**                      AND    E.ID_PERSON              = ETA.ID_PERSON_EMP
**                      AND    ECL.ID_PERSON            = ETA.ID_PERSON_EMP;
**
**                      Instead, it needed to return the information from this query:
**
**                      DECLARE CARC06D_CURSOR CURSOR FOR
**                      SELECT ETA.ID_PERSON_EMP,
**                             ETA.DT_ASSIGN_EXPIRATION
**                      FROM   EMP_TEMP_ASSIGN     ETA
**                      WHERE  ETA.ID_PERSON_DESIGNEE   = :hI_ulIdPerson:hI_ulIdPerson_i
**                      AND    ETA.DT_ASSIGN_EXPIRATION >= sysdate;
**
**                      The changes in this file reflect the changes made to
**                      the DAM carc06d, and the carc06do copybook, which
**                      included the removal of the member szCdEmployeeClass
**
**  02/11/02  Cawthocw  SIR 16037 -- Added call to CAUDE5D to update the EMPLOYEE table
**                      with the date that the employee last logged into CAPS.
**  04/17/02  Hadjimh   SIR WebCaps.
**        Commented out all pABHI stuff
**        Changed STATUSPARMS to TUX_STATUSPARMS
**        Changed DECL_STATUSPARMS to TUX_DECL_STATUSPARMS
**        Added TUX_DECL_STATUSPARMS; to beginning of function
**        Changed PROCESS_RC_ERROR to PROCESS_TUX_RC_ERROR
**        Changed PROCESS_SQL_ERROR to PROCESS_TUX_SQL_ERROR
**        Added #include <atmi.h>
**              #include <expat.h>
**              #include "arcxmlerrors.h"
**              #include "arcxmlmarshal.h"
**              #include "arcxmlunmarshal.h"
**
**  09/26/03  Srini      SIR 19899 - Fixed memory leaks and added memsets to 
**						 unmarshal function
***************************************************************************
/**************************************************************************
** Service Include Files
***************************************************************************/

/* begin webcaps */

public class Carc01s {
    /* end webcaps */
    public static final char LT_ONE = '1';
    CARC01SO CARC01S(CARC01SI carc01si) {
        CARC01SO carc01so = new CARC01SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;// Return code
        //## END TUX/XML: Declare XML variables 
        
        
        int[] errMsg = new int[]{
            0};
        String tmp = null;
        int responseSize = 0;
        int i1 = 0;
        carc01so = new CARC01SO();
        
        
        //  Declare local variables
        
        //##   short    rc = FND_SUCCESS;
        
        CAUDE5DI pCAUDE5DInputRec = null;
        CAUDE5DO pCAUDE5DOutputRec = null;
        pServiceStatus.severity = FND_SEVERITY_OK;
        pServiceStatus.explan_code = SUCCESS;
        rc = CallCARC01D(carc01si, carc01so, pServiceStatus);
        if (rc == WtcHelperConstants.ARC_SUCCESS) {
            
            //  Call Retrieve DAM
            rc = CallCLSCB4D(carc01si, carc01so, pServiceStatus);
        }
        
        
        // 
        // (END): Assign to Worker
        // 
        
        // 
        // (BEGIN): Create/Update CAPS Resource
        // 
        
        if (rc != Messages.MSG_CMN_NOT_CAPS_USER) {
            // Process utility function failure
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        if (rc == WtcHelperConstants.ARC_SUCCESS) {
            pCAUDE5DInputRec = new CAUDE5DI();
            
            pCAUDE5DOutputRec = new CAUDE5DO();
            pCAUDE5DInputRec.setArchInputStruct(carc01si.getArchInputStruct());
            pCAUDE5DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
            pCAUDE5DInputRec.setSzIdEmployeeLogon(carc01si.getSzIdEmployeeLogon());
            //  Call Retrieve DAM
            rc = caude5dAUDdam(sqlca, pCAUDE5DInputRec, pCAUDE5DOutputRec);
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
        return carc01so;
    }

    static int CallCARC01D(CARC01SI pInputMsg1, CARC01SO pOutputMsg1, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;// Return code
        
        //  Declare local variables
        CARC01DI pCARC01DInputRec = null;
        CARC01DO pCARC01DOutputRec = null;
        FndInt3date dtCurrentDate = null;// current date
        char bTempAssign = '\u0000';// temporary assignment indicator
        
        
        // int         i;                      loop variable
        
        //  Allocate memory for Input and Output Structures
        pCARC01DInputRec = new CARC01DI();
        
        
        pCARC01DOutputRec = new CARC01DO();
        pCARC01DInputRec.setArchInputStruct(pInputMsg1.getArchInputStruct());
        pCARC01DInputRec.setSzIdEmployeeLogon(pInputMsg1.getSzIdEmployeeLogon());
        rc = carc01dQUERYdam(sqlca, pCARC01DInputRec, pCARC01DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg1.setSzIdEmployeeLogon(pCARC01DOutputRec.getSzIdEmployeeLogon());
                pOutputMsg1.setUlIdPerson(pCARC01DOutputRec.getUlIdPerson());
                pOutputMsg1.setSzNmPersonFull(pCARC01DOutputRec.getSzNmPersonFull());
                pOutputMsg1.setSzCdUnitRegion(pCARC01DOutputRec.getSzCdUnitRegion());
                pOutputMsg1.setSzAddrMailCodeCity(pCARC01DOutputRec.getSzAddrMailCodeCity());
                pOutputMsg1.setUlIdOffice(pCARC01DOutputRec.getUlIdOffice());
                pOutputMsg1.setSzNbrUnit(pCARC01DOutputRec.getSzNbrUnit());
                pOutputMsg1.setSzCdUnitProgram(pCARC01DOutputRec.getSzCdUnitProgram());
                pOutputMsg1.setSzCdEmployeeClass(pCARC01DOutputRec.getSzCdEmployeeClass());
                
                
                //  Call CSES82D
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_NOT_CAPS_USER;
                rc = Messages.MSG_CMN_NOT_CAPS_USER;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        return rc;
    }

    static int CallCLSCB4D(CARC01SI pInputMsg2, CARC01SO pOutputMsg2, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int // Loop counter
        h = 0;
        int i2 = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        int m = 0;
        
        String TempSecurityProfile = new String();
        
        CLSCB4DI pCLSCB4DInputRec = null;
        CLSCB4DO pCLSCB4DOutputRec = null;
        CARC06DI pCARC06DInputRec = null;
        CARC06DO pCARC06DOutputRec = null;
        
        
        //  4/19/2001 SLC ENDS SECURITY UPGRADE
        
        //   4/19/2001 SLC BEGIN SECURITY UPGRADE
        // Deleted break in FND_SUCCESS function since we now call
        // through the DAM CLSCB4D; also deleted break in SQL_NOT_FOUND
        // and added a call to a CLSCB4D.PC to retrieve all of the logged
        // in user's security and profiles.  Since the breaks were removed
        // this will be executed whether assignees existed or not.
        // Allocate memory for DAM Input and Output Structures
        
        pCLSCB4DInputRec = new CLSCB4DI();
        
        pCLSCB4DOutputRec = new CLSCB4DO();
        pCLSCB4DInputRec.setArchInputStruct(pInputMsg2.getArchInputStruct());
        pCLSCB4DInputRec.setUlIdPerson(pOutputMsg2.getUlIdPerson());
        pCLSCB4DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCLSCB4DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSCB4DO._CLSCB4DO__ROWCLSCB4DO_SIZE);
        rc = clscb4dQUERYdam(sqlca, pCLSCB4DInputRec, pCLSCB4DOutputRec);
        
        //  Analyze return code
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                pOutputMsg2.setSzTxtSecurityClassProfil(pCLSCB4DOutputRec.getROWCLSCB4DO_ARRAY().getROWCLSCB4DO(0).getSzTxtSecurityClassProfil());
                
                //   Consolidate an employee's multiple profile (loop #1)
                for (i2 = 1;i2 < pCLSCB4DOutputRec.getArchOutputStruct().getUlRowQty();i2++) {
                    //   for each character in the profile string
                    for (j = 0;j < CLSS12DO.TXT_SECURITY_CLASS_PROFIL_LEN;j++) {
                        if (LT_ONE == pCLSCB4DOutputRec.getROWCLSCB4DO_ARRAY().getROWCLSCB4DO(i2).getSzTxtSecurityClassProfil()[j]) {
                            pOutputMsg2.getSzTxtSecurityClassProfil()[j] = LT_ONE;
                        }
                    }
                }
                //   end loop #1
                
                
                //  Begin CARC06D -- Retrieve any current temporary assignments
                // held by the current user.
                // Allocate memory for Input and Output Structures
                pCARC06DInputRec = new CARC06DI();
                
                pCARC06DOutputRec = new CARC06DO();
                pCARC06DInputRec.setUlIdPerson(pOutputMsg2.getUlIdPerson());
                pCARC06DInputRec.setArchInputStruct(pInputMsg2.getArchInputStruct());
                pCARC06DInputRec.getArchInputStruct().setUsPageNbr(1);
                pCARC06DInputRec.getArchInputStruct().setUlPageSizeNbr(CARC01SO._CARC01SO__ROWCARC01SO_SIZE);
                
                //  Start Performance Timer
                rc = carc06dQUERYdam(sqlca, pCARC06DInputRec, pCARC06DOutputRec);
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        //  Insert logic to analyze the return code for the DAM here before
                        // calling the error handler.
                        
                        //  Populate Output Message
                        for (h = 0;h < pCARC06DOutputRec.getArchOutputStruct().getUlRowQty();h++) {
                            pOutputMsg2.getROWCARC01SO_ARRAY().getROWCARC01SO(h).setUlIdPerson(pCARC06DOutputRec.getROWCARC06DO_ARRAY().getROWCARC06DO(h).getUlIdPerson());
                            pOutputMsg2.getROWCARC01SO_ARRAY().getROWCARC01SO(h).setDtTempAssignExpir(pCARC06DOutputRec.getROWCARC06DO_ARRAY().getROWCARC06DO(h).getDtTempAssignExpir());
                        }
                        pOutputMsg2.getArchOutputStruct().setUlRowQty(pCARC06DOutputRec.getArchOutputStruct().getUlRowQty());
                        pOutputMsg2.getArchOutputStruct().setBMoreDataInd(pCARC06DOutputRec.getArchOutputStruct().getBMoreDataInd());
                        //   If any assignees were found, call the same DAM again,
                        // once for every assignee and construct the user's profile
                        // string accordingly
                        for (k = 0;k < pOutputMsg2.getArchOutputStruct().getUlRowQty();k++) {
                            pCLSCB4DInputRec.setArchInputStruct(pInputMsg2.getArchInputStruct());
                            
                            pCLSCB4DInputRec.setUlIdPerson(pCARC06DOutputRec.getROWCARC06DO_ARRAY().getROWCARC06DO(k).getUlIdPerson());
                            pCLSCB4DInputRec.getArchInputStruct().setUsPageNbr(1);
                            pCLSCB4DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSCB4DO._CLSCB4DO__ROWCLSCB4DO_SIZE);
                            
                            //  Initialize Service Status Fields
                            
                            //  Set CCON24SO WCD DtSystemDate to current date
                            rc = clscb4dQUERYdam(sqlca, pCLSCB4DInputRec, pCLSCB4DOutputRec);
                            
                            //  Analyze return code
                            switch (rc) {
                                    
                                case WtcHelperConstants.SQL_SUCCESS:
                                    pServiceStatus.severity = FND_SEVERITY_OK;
                                    pServiceStatus.explan_code = SUCCESS;
                                    //   Consolidate employee profile with assignees
                                    // profiles (loop #2)
                                    
                                    //   Loop #2 consolidate assignee profiles
                                    for (l = 0;l < pCLSCB4DOutputRec.getArchOutputStruct().getUlRowQty();l++) {
                                        //   for each character in the assignee profile string
                                        for (m = 0;m < CLSS12DO.TXT_SECURITY_CLASS_PROFIL_LEN;m++) {
                                            if (LT_ONE == pCLSCB4DOutputRec.getROWCLSCB4DO_ARRAY().getROWCLSCB4DO(l).getSzTxtSecurityClassProfil()[m]) {
                                                pOutputMsg2.getSzTxtSecurityClassProfil()[m] = LT_ONE;
                                            }
                                        }
                                    }
                                    break;
                                case NO_DATA_FOUND:
                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    break;
                            }
                        }
                        break;
                    case NO_DATA_FOUND:
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                        
                        
                    default :
                        
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_NOT_CAPS_USER;
                
                //  Call CSES23D
                rc = Messages.MSG_CMN_NOT_CAPS_USER;
                break;
                
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

}
