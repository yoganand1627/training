package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN03SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN50DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNC3DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNC3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNC4DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNC4DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNF9DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNF9DO;
/**************************************************************************
**
** Module File:   CCMN03S.src
**
** Service Name:  CCMN03S
**
** Description:   Retrieve a list of staff
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.4 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created: 1/16/95
**
** Programmer:  Karl R. Dalley / Partha Sarabu
**
** Archive Information: $Revision:   1.3  $
**                      $Date:   19 Aug 1996 20:11:20  $
**                      $Modtime:   14 Aug 1996 18:42:26  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  04/20/95    KRD     Corrections prior to Technical Code Review to
**                      clean up code and meet standards
**  05/03/95    KRD     Corrections due to Technical Code Review
**  05/09/95    KRD     DAM CCMNF9D added
**  05/16/95    KRD     Corrections to meet new error handling standards
**  05/30/95    KRD     Correction to properly obtain and pass back the
**                      System Date.
**  06/14/95    KRD     Corrections due to Code Review II.
**  06/22/95    KRD     PWO 663 - The System Date should be passed back to
**                      the client even if the search returns no rows.
**  08/31/95    KRD     Modified due to data element name change of
**                      szAddrOfficeCity, szAddrOfficeStreetLn1,
**                      szAddrOfficeStreetLn2, szStaffStages to
**                      szAddrMailCodeCity, szAddrMailCodeStLn1,
**                      szAddrOfficeStreetLn2, szTxtStaffStages.
**                      Required changes to CallCCMN50D() and CallCCMNF9D().
**  10/16/95    KRD     SIR 1265 - General cleanup.
**  7/26/96   zabihin   sir 21891 , version control code was missing, I
**                      added the lines.
**  8/13/96   maxhamkj  SIR 21908: commented out fields no longer being
**                      used: AddrMailCodeStLn1, Ln2, and City. Also
**                      added code to populate CdOfficeMail (mail code)
**                      which is now displayed in Staff List.
**  4/13/2004 gerryc    SIR 16271 - added mail code as an input to the search
**  1/24/2005 gerryc    SIR 233118 - took out szCdUnitMemberRole because it
**                      is not selected in the ccmn50d SQL and not used from
**                      ccmnf9d.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/
/*
** Extern for version control table.
*/






public class Ccmn03s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String PERSON_PHONE_TYPE_HOME = "RS";
    public static final String PERSON_PHONE_TYPE_BUSINESS = "BS";
    public static final char PERSON_PHONE_PRIMARY_TRUE = 'Y';
    CCMN03SO CCMN03S(CCMN03SI ccmn03si) {
        CCMN03SO ccmn03so = new CCMN03SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_PRFServiceStartTime_TUX(ccmn03si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(ccmn03so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        if (ccmn03si.getStageIdInStruct_ARRAY().getStageIdInStruct(0).getUlIdStage() != 0) {
            rc = CallCCMNF9D(ccmn03si, ccmn03so, pServiceStatus);
        }
        
        else {
            rc = CallCCMN50D(ccmn03si, ccmn03so, pServiceStatus);
        }
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                
                
                rc = CallCCMNC3D(ccmn03si, ccmn03so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                rc = CallCCMNC4D(ccmn03si, ccmn03so, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
            case Messages.MSG_CMN_SEARCH_NOT_FOUND:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        
        ARC_PRFServiceStopTime_TUX(ccmn03si.getArchInputStruct() , ccmn03so.getArchOutputStruct());
        
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
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccmn03so;
    }

    static int CallCCMN50D(CCMN03SI pInputMsg98, CCMN03SO pOutputMsg94, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i81 = 0;
        
        /*
        ** Declare local variables
        */
        CCMN50DI pCCMN50DInputRec = null;
        CCMN50DO pCCMN50DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMN50DInputRec = new CCMN50DI();
        
        pCCMN50DOutputRec = new CCMN50DO();
        pCCMN50DInputRec.setSzNmNameLast(pInputMsg98.getStfSrchCrtInStruct().getSzNmNameLast());
        pCCMN50DInputRec.setSzNmNameFirst(pInputMsg98.getStfSrchCrtInStruct().getSzNmNameFirst());
        pCCMN50DInputRec.setSzNmNameMiddle(pInputMsg98.getStfSrchCrtInStruct().getSzNmNameMiddle());
        pCCMN50DInputRec.setSzCdUnitRegion(pInputMsg98.getStfSrchCrtInStruct().getSzCdUnitRegion());
        pCCMN50DInputRec.setSzNbrUnit(pInputMsg98.getStfSrchCrtInStruct().getSzNbrUnit());
        pCCMN50DInputRec.setSzAddrMailCodeCity(pInputMsg98.getStfSrchCrtInStruct().getSzAddrMailCodeCity());
        pCCMN50DInputRec.setSzCdEmpSkill(pInputMsg98.getStfSrchCrtInStruct().getSzCdEmpSkill());
        pCCMN50DInputRec.setSzCdUnitSpecialization(pInputMsg98.getStfSrchCrtInStruct().getSzCdUnitSpecialization());
        pCCMN50DInputRec.setSzCdUnitProgram(pInputMsg98.getStfSrchCrtInStruct().getSzCdUnitProgram());
        pCCMN50DInputRec.setSzCdOfficeCounty(pInputMsg98.getStfSrchCrtInStruct().getSzCdOfficeCounty());
        pCCMN50DInputRec.setSzNbrPersonIdNumber(pInputMsg98.getStfSrchCrtInStruct().getSzNbrPersonIdNumber());
        pCCMN50DInputRec.setCScrIndActive(pInputMsg98.getStfSrchCrtInStruct().getCScrIndActive());
        pCCMN50DInputRec.setUlIdPerson(pInputMsg98.getStfSrchCrtInStruct().getUlIdPerson());
        pCCMN50DInputRec.setBIndJobAssignable(pInputMsg98.getStfSrchCrtInStruct().getBIndJobAssignable());
        pCCMN50DInputRec.setSzAddrMailCode(pInputMsg98.getStfSrchCrtInStruct().getSzAddrMailCode());
        pCCMN50DInputRec.setArchInputStruct(pInputMsg98.getArchInputStruct());
        pCCMN50DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg98.getArchInputStruct().getUsPageNbr());
        pCCMN50DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg98.getArchInputStruct().getUlPageSizeNbr());
        rc = ccmn50dQUERYdam(sqlca, pCCMN50DInputRec, pCCMN50DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                //  Populate Output Message
                for (i81 = 0;i81 < pCCMN50DOutputRec.getArchOutputStruct().getUlRowQty();++i81) {
                    pOutputMsg94.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i81).setSzNmPersonFull(pCCMN50DOutputRec.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i81).getSzNmPersonFull());
                    
                    pOutputMsg94.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i81).setSzCdUnitRegion(pCCMN50DOutputRec.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i81).getSzCdUnitRegion());
                    pOutputMsg94.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i81).setSzNbrUnit(pCCMN50DOutputRec.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i81).getSzNbrUnit());
                    
                    pOutputMsg94.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i81).setSzCdEmployeeClass(pCCMN50DOutputRec.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i81).getSzCdEmployeeClass());
                    pOutputMsg94.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i81).setSzAddrMailCode(pCCMN50DOutputRec.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i81).getSzAddrMailCode());
                    
                    pOutputMsg94.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i81).setSzBjnJob(pCCMN50DOutputRec.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i81).getSzBjnJob());
                    pOutputMsg94.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i81).setSzNmOfficeName(pCCMN50DOutputRec.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i81).getSzNmOfficeName());
                    
                    pOutputMsg94.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i81).setTmScrTmEmpLastAssigned(pCCMN50DOutputRec.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i81).getTmScrTmEmpLastAssigned());
                    pOutputMsg94.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i81).setUlIdPerson(pCCMN50DOutputRec.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i81).getUlIdPerson());
                    
                    pOutputMsg94.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i81).setUlIdUnit(pCCMN50DOutputRec.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i81).getUlIdUnit());
                    pOutputMsg94.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i81).setDtDtEmpLastAssigned(pCCMN50DOutputRec.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i81).getDtDtEmpLastAssigned());
                };
                pOutputMsg94.getArchOutputStruct().setUlRowQty(pCCMN50DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg94.getArchOutputStruct().setBMoreDataInd(pCCMN50DOutputRec.getArchOutputStruct().getBMoreDataInd());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_CMN_SEARCH_NOT_FOUND;
                rc = Messages.MSG_CMN_SEARCH_NOT_FOUND;
                break;
                
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        return rc;
    }

    static int CallCCMNC3D(CCMN03SI pInputMsg99, CCMN03SO pOutputMsg95, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;/* Return code */
        int i82 = 0;
        int s = 0;/* Loop counter */
        
        /*
        ** Declare local variables
        */
        CCMNC3DI pCCMNC3DInputRec = null;
        CCMNC3DO pCCMNC3DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNC3DInputRec = new CCMNC3DI();
        pCCMNC3DOutputRec = new CCMNC3DO();
        
        //## BEGIN TUX/XML: Declare XML variables 
        pCCMNC3DInputRec.setArchInputStruct(pInputMsg99.getArchInputStruct());
        pCCMNC3DInputRec.setSzCdPhoneType(PERSON_PHONE_TYPE_HOME);
        pCCMNC3DInputRec.getTsTsGenericDate_ARRAY().setTsTsGenericDate(0, 147);
        ;
        
        
        for (s = 0;(s < pOutputMsg95.getArchOutputStruct().getUlRowQty()) && (rc == WtcHelperConstants.ARC_SUCCESS);s++) {
            pCCMNC3DInputRec.setUlIdPerson(pOutputMsg95.getROWCCMN50DO_ARRAY().getROWCCMN50DO(s).getUlIdPerson());
            
            //  Call DAM
            rc = ccmnc3dQUERYdam(sqlca, pCCMNC3DInputRec, pCCMNC3DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pOutputMsg95.getROWCCMN50DO_ARRAY().getROWCCMN50DO(s).setLSysNbrPersPhnHome(pCCMNC3DOutputRec.getLNbrPhone());
                    
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
                case NO_DATA_FOUND:
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    // 
                    // END OF CAUDA5D RC ANALYSIS AND CODE, RETURN TO CMSC43D
                    // 
                    
                    break;
            }
        }
        return rc;
    }

    static int CallCCMNC4D(CCMN03SI pInputMsg100, CCMN03SO pOutputMsg96, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;/* Return code */
        int i83 = 0;
        int s = 0;/* Loop counter */
        
        /*
        ** Declare local variables
        */
        CCMNC4DI pCCMNC4DInputRec = null;
        CCMNC4DO pCCMNC4DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNC4DInputRec = new CCMNC4DI();
        pCCMNC4DOutputRec = new CCMNC4DO();
        pCCMNC4DInputRec.setArchInputStruct(pInputMsg100.getArchInputStruct());
        pCCMNC4DInputRec.setSzCdPhoneType(PERSON_PHONE_TYPE_BUSINESS);
        pCCMNC4DInputRec.getTsTsGenericDate_ARRAY().setTsTsGenericDate(0, 147);
        ;
        pCCMNC4DInputRec.setBIndPersonPhonePrimary(PERSON_PHONE_PRIMARY_TRUE);
        
        for (s = 0;(s < pOutputMsg96.getArchOutputStruct().getUlRowQty()) && (rc == WtcHelperConstants.ARC_SUCCESS);s++) {
            pCCMNC4DInputRec.setUlIdPerson(pOutputMsg96.getROWCCMN50DO_ARRAY().getROWCCMN50DO(s).getUlIdPerson());
            rc = ccmnc4dQUERYdam(sqlca, pCCMNC4DInputRec, pCCMNC4DOutputRec);
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    pOutputMsg96.getROWCCMN50DO_ARRAY().getROWCCMN50DO(s).setLSysNbrPersPhoneWork(pCCMNC4DOutputRec.getLNbrPhone());
                    pOutputMsg96.getROWCCMN50DO_ARRAY().getROWCCMN50DO(s).setLNbrPhoneExtension(pCCMNC4DOutputRec.getLNbrPhoneExtension());
                    
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
                case NO_DATA_FOUND:
                    //  Do nothing, the output message just returns success or
                    // failure.
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    //  End of CCMNA5D
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
                    break;
            }
        }
        
        
        return rc;
    }

    static int CallCCMNF9D(CCMN03SI pInputMsg101, CCMN03SO pOutputMsg97, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i84 = 0;
        
        /*
        ** Declare local variables
        */
        CCMNF9DI pCCMNF9DInputRec = null;
        CCMNF9DO pCCMNF9DOutputRec = null;
        String szTempStgId = new String();/* used to convert ulIdStage */
        int uCount = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCCMNF9DInputRec = new CCMNF9DI();
        
        pCCMNF9DOutputRec = new CCMNF9DO();
        szTempStgId = (pInputMsg101.getStageIdInStruct_ARRAY().getStageIdInStruct(0).getUlIdStage());
        pCCMNF9DInputRec.setSzTxtStaffStages(szTempStgId);
        
        /*
        ** Now add any additional ID STAGES to the string
        */
        for (uCount = 1;(uCount < CCMN03SI._CCMN03SI__STAGEIDINSTRUCT_SIZE) && pInputMsg101.getStageIdInStruct_ARRAY().getStageIdInStruct(uCount).getUlIdStage() != 0;uCount++) {
            pCCMNF9DInputRec.getSzTxtStaffStages() += ", ";
            szTempStgId = (pInputMsg101.getStageIdInStruct_ARRAY().getStageIdInStruct(uCount).getUlIdStage());
            pCCMNF9DInputRec.getSzTxtStaffStages() += szTempStgId;
        }
        pCCMNF9DInputRec.setArchInputStruct(pInputMsg101.getArchInputStruct());
        rc = ccmnf9dQUERYdam(sqlca, pCCMNF9DInputRec, pCCMNF9DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i84 = 0;i84 < pCCMNF9DOutputRec.getArchOutputStruct().getUlRowQty();++i84) {
                    pOutputMsg97.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i84).setSzNmPersonFull(pCCMNF9DOutputRec.getROWCCMNF9DO_ARRAY().getROWCCMNF9DO(i84).getSzNmPersonFull());
                    pOutputMsg97.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i84).setSzCdUnitRegion(pCCMNF9DOutputRec.getROWCCMNF9DO_ARRAY().getROWCCMNF9DO(i84).getSzCdUnitRegion());
                    
                    pOutputMsg97.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i84).setSzNbrUnit(pCCMNF9DOutputRec.getROWCCMNF9DO_ARRAY().getROWCCMNF9DO(i84).getSzNbrUnit());
                    pOutputMsg97.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i84).setSzCdEmployeeClass(pCCMNF9DOutputRec.getROWCCMNF9DO_ARRAY().getROWCCMNF9DO(i84).getSzCdEmployeeClass());
                    pOutputMsg97.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i84).setSzBjnJob(pCCMNF9DOutputRec.getROWCCMNF9DO_ARRAY().getROWCCMNF9DO(i84).getSzBjnJob());
                    pOutputMsg97.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i84).setSzNmOfficeName(pCCMNF9DOutputRec.getROWCCMNF9DO_ARRAY().getROWCCMNF9DO(i84).getSzNmOfficeName());
                    pOutputMsg97.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i84).setTmScrTmEmpLastAssigned(pCCMNF9DOutputRec.getROWCCMNF9DO_ARRAY().getROWCCMNF9DO(i84).getTmScrTmEmpLastAssigned());
                    pOutputMsg97.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i84).setUlIdPerson(pCCMNF9DOutputRec.getROWCCMNF9DO_ARRAY().getROWCCMNF9DO(i84).getUlIdPerson());
                    pOutputMsg97.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i84).setUlIdUnit(pCCMNF9DOutputRec.getROWCCMNF9DO_ARRAY().getROWCCMNF9DO(i84).getUlIdUnit());
                    pOutputMsg97.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i84).getDtDtEmpLastAssigned().day = pCCMNF9DOutputRec.getROWCCMNF9DO_ARRAY().getROWCCMNF9DO(i84).getDtDtEmpLastAssigned().day;
                    pOutputMsg97.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i84).getDtDtEmpLastAssigned().month = pCCMNF9DOutputRec.getROWCCMNF9DO_ARRAY().getROWCCMNF9DO(i84).getDtDtEmpLastAssigned().month;
                    pOutputMsg97.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i84).getDtDtEmpLastAssigned().year = pCCMNF9DOutputRec.getROWCCMNF9DO_ARRAY().getROWCCMNF9DO(i84).getDtDtEmpLastAssigned().year;
                    
                    pOutputMsg97.getROWCCMN50DO_ARRAY().getROWCCMN50DO(i84).setSzAddrMailCode(pCCMNF9DOutputRec.getROWCCMNF9DO_ARRAY().getROWCCMNF9DO(i84).getSzAddrMailCode());
                };
                pOutputMsg97.getArchOutputStruct().setUlRowQty(pCCMNF9DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg97.getArchOutputStruct().setBMoreDataInd(pCCMNF9DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_CMN_SEARCH_NOT_FOUND;
                
                rc = Messages.MSG_CMN_SEARCH_NOT_FOUND;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

}
