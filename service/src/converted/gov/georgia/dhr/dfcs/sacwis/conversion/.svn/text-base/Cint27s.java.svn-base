package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT09DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT09DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FacilRtrvStruc;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct;
/**************************************************************************
** 
** Module File:   cint27s.src
**
** Service Name:  CINT27S  
**
** Description:   This is the retrieval service for the Facility Detail window.
**                It is called from the Intake Toolbar.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/13/95 
** 
** Programmer:    Rich Steinle
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  07/26/96   zabihin  sir 21891 : version control code was missing,I
**                       added the lines.
**  8/20/97	klm	SIR# 14001 - Add Resource ID to the information
**			copied from pCINT09DOutputRec to pOutputMsg.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cint27s {
    CINT27SO CINT27S(CINT27SI cint27si) {
        CINT27SO cint27so = new CINT27SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_PRFServiceStartTime_TUX(cint27si.ArchInputStruct);
        
        /*     COPYSZ(pCINT56DInputRec->szCdIncomingCallType,
        CALL_TYPE_WKR_ID);
        */
        
        /* Populate Input Structure for DAM */
        rc = Ccmn03u.CallCINT09D(cint27si, cint27so, pServiceStatus);
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(cint27si.ArchInputStruct, cint27so.ArchOutputStruct);
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            // sir# 23617. added szCdStageProgram_IND case.
            if (tpcommit(0) == - 1) 
            
            {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                //  Call dam to carry out the New Using functionality.
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cint27so;
    }

    static int CallCINT09D(CINT27SI pInputMsg475, CINT27SO pOutputMsg435, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CINT09DI pCINT09DInputRec = null;
        CINT09DO pCINT09DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT09DInputRec = new CINT09DI();
        
        pCINT09DOutputRec = new CINT09DO();
        pCINT09DInputRec.setUlIdStage(pInputMsg475.FacilRtrvStruc.getUlIdStage());
        rc = cint09dQUERYdam(sqlca, pCINT09DInputRec, pCINT09DOutputRec);
        if (SUCCESS == rc) {
            pOutputMsg435.FacDetailEntStruct.setUlIdResource(pCINT09DOutputRec.getUlIdResource());
            pOutputMsg435.FacDetailEntStruct.setSzAddrIncmgFacilCity(pCINT09DOutputRec.getSzAddrIncmgFacilCity());
            pOutputMsg435.FacDetailEntStruct.setSzCdIncFacilOperBy(pCINT09DOutputRec.getSzCdIncFacilOperBy());
            pOutputMsg435.FacDetailEntStruct.setBIndIncmgFacilAbSupvd(pCINT09DOutputRec.getBIndIncmgFacilAbSupvd());
            pOutputMsg435.FacDetailEntStruct.setBIndIncmgFacilSearch(pCINT09DOutputRec.getBIndIncmgFacilSearch());
            pOutputMsg435.FacDetailEntStruct.setSzAddrIncmgFacilStLn1(pCINT09DOutputRec.getSzAddrIncmgFacilStLn1());
            pOutputMsg435.FacDetailEntStruct.setSzAddrIncmgFacilStLn2(pCINT09DOutputRec.getSzAddrIncmgFacilStLn2());
            pOutputMsg435.FacDetailEntStruct.setSzAddrIncmgFacilZip(pCINT09DOutputRec.getSzAddrIncmgFacilZip());
            pOutputMsg435.FacDetailEntStruct.setSzCdIncmgFacilCnty(pCINT09DOutputRec.getSzCdIncmgFacilCnty());
            pOutputMsg435.FacDetailEntStruct.setSzCdIncmgFacilState(pCINT09DOutputRec.getSzCdIncmgFacilState());
            pOutputMsg435.FacDetailEntStruct.setSzCdIncmgFacilType(pCINT09DOutputRec.getSzCdIncmgFacilType());
            pOutputMsg435.FacDetailEntStruct.setSzNbrIncmgFacilPhone(pCINT09DOutputRec.getSzNbrIncmgFacilPhone());
            pOutputMsg435.FacDetailEntStruct.setSzNbrIncmgFacilPhoneExt(pCINT09DOutputRec.getSzNbrIncmgFacilPhoneExt());
            pOutputMsg435.FacDetailEntStruct.setSzNmUnitWard(pCINT09DOutputRec.getSzNmUnitWard());
            pOutputMsg435.FacDetailEntStruct.setSzNmIncmgFacilAffiliated(pCINT09DOutputRec.getSzNmIncmgFacilAffiliated());
            pOutputMsg435.FacDetailEntStruct.setNmIncmgFacilName(pCINT09DOutputRec.getNmIncmgFacilName());
            pOutputMsg435.FacDetailEntStruct.setBIndIncmgOnGrnds(pCINT09DOutputRec.getBIndIncmgOnGrnds());
            pOutputMsg435.FacDetailEntStruct.setSzTxtFacilCmnts(pCINT09DOutputRec.getSzTxtFacilCmnts());
            
            pOutputMsg435.FacDetailEntStruct.setSzNmIncmgFacilSuprtdant(pCINT09DOutputRec.getSzNmIncmgFacilSuprtdant());
        }
        
        
        else {
            switch (rc) {
                case NO_DATA_FOUND:
                    pServiceStatus.explan_code = NO_DATA_FOUND;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

}
