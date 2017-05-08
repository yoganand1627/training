package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT10DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT10DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FacDetailEntStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:   cint11s.src
**
** Service Name:  CINT11S
**
** Description:   AUD service for the Facility Detail window.  Called from
**                the Intake Toolbar when the Facility Detail window is 
**                destroyed.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/13/95 
** 
** Programmer:    Rich Steinle
**
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  06/22/95  ELLIOTSL  SIR #668.  Logic has been added to handle timeouts.
**                      If the service successfully adds a row, but times out,
**                      the client may attempt to add the same row again 
**                      (where same is determined by the primary key ID STAGE).
**                      If this happens then the service will intersept the
**                      the duplicate key error and update the row instead
**                      of adding it.
**  07/26/96   zabihin  sir 21891 : version control code was missing,I 
**                        added the lines.
**  8/20/97	klm	SIR# 14001 - Add Resource ID to the information 
**			copied from pInputMsg to pCINT10DInputRec.
**
**  08/04/03   Srini    SIR 17827 - IMPACT: Made the service transactionaware.
**
***************************************************************************/
/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cint11s {
    static int transactionflag = - 1;
    CINT11SO CINT11S(CINT11SI cint11si) {
        CINT11SO cint11so = new CINT11SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        //## END TUX/XML: Turn the XML buffer into an input message struct 
        
        
        transactionflag = - 1;
        boolean bTransactionStarted = false;
        transactionflag = tpgetlev();
        
        /***********************************************************
        ** SIR 2657:  Added DAM CINT07D to Retrieve CD_INCMG_STATUS
        ** from the Incoming Detail table.  If the STATUS is MFD 
        ** (Marked for Deletion), it is OK not to find a primary 
        ** worker and to ignore this SQL not found error.
        ***********************************************************/
        if (transactionflag == - 1) {
            userlog("ERROR: tpgetlev failed in CINT11S (%s)\n", tpstrerror(tperrno));
            pServiceStatus.severity = FND_SEVERITY_ERROR;
            pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            
            //  Call CCMN44D
            rc = Arcxmlerrors.ARC_ERR_TUX_TPBEGIN_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
        }
        else if (transactionflag == 1) {
            userlog("START: TRANSACTION ALREADY IN PROGRESS in CINT11S\n");
        }
        else if (transactionflag == 0) {
            userlog("TRANSACTION IS STARTED in CINT11S \n");
            bTransactionStarted = true;
        }
        rc = ARC_PRFServiceStartTime_TUX(cint11si.ArchInputStruct);
        rc = CallCINT10D(cint11si, cint11so, pServiceStatus);
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(cint11si.ArchInputStruct, cint11so.ArchOutputStruct);
        
        
        /* 
        ** If the CD TASK not NULL in the output, call DAM 82 
        */
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError_Transact(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber() , transactionflag);
        }
        else if (bTransactionStarted) {
            
            
            //  If the ID STAGE is not zero in the output, call DAM 89
            if (tpcommit(0) == - 1) {
                userlog("ERROR: tpcommit failed in service CINT11S (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                //  Call CINV51D
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR_TRANSACT();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        else {
            userlog("END: TRANSACTION ALREADY IN PROGRESS CINT11S\n");
        }
        return cint11so;
    }

    static int CallCINT10D(CINT11SI pInputMsg437, CINT11SO * pOutputMsg403, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CINT10DI pCINT10DInputRec = null;
        CINT10DO pCINT10DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT10DInputRec = new CINT10DI();
        
        pCINT10DOutputRec = new CINT10DO();
        pCINT10DInputRec.setUlIdResource(pInputMsg437.FacDetailEntStruct.getUlIdResource());
        pCINT10DInputRec.setUlIdStage(pInputMsg437.FacDetailEntStruct.getUlIdStage());
        pCINT10DInputRec.setSzCdIncFacilOperBy(pInputMsg437.FacDetailEntStruct.getSzCdIncFacilOperBy());
        pCINT10DInputRec.setNmIncmgFacilName(pInputMsg437.FacDetailEntStruct.getNmIncmgFacilName());
        pCINT10DInputRec.setSzNmUnitWard(pInputMsg437.FacDetailEntStruct.getSzNmUnitWard());
        pCINT10DInputRec.setSzTxtFacilCmnts(pInputMsg437.FacDetailEntStruct.getSzTxtFacilCmnts());
        pCINT10DInputRec.setSzNmIncmgFacilAffiliated(pInputMsg437.FacDetailEntStruct.getSzNmIncmgFacilAffiliated());
        pCINT10DInputRec.setSzCdIncmgFacilType(pInputMsg437.FacDetailEntStruct.getSzCdIncmgFacilType());
        pCINT10DInputRec.setSzAddrIncmgFacilStLn1(pInputMsg437.FacDetailEntStruct.getSzAddrIncmgFacilStLn1());
        pCINT10DInputRec.setSzAddrIncmgFacilStLn2(pInputMsg437.FacDetailEntStruct.getSzAddrIncmgFacilStLn2());
        pCINT10DInputRec.setSzAddrIncmgFacilCity(pInputMsg437.FacDetailEntStruct.getSzAddrIncmgFacilCity());
        pCINT10DInputRec.setSzAddrIncmgFacilZip(pInputMsg437.FacDetailEntStruct.getSzAddrIncmgFacilZip());
        pCINT10DInputRec.setSzCdIncmgFacilState(pInputMsg437.FacDetailEntStruct.getSzCdIncmgFacilState());
        pCINT10DInputRec.setSzCdIncmgFacilCnty(pInputMsg437.FacDetailEntStruct.getSzCdIncmgFacilCnty());
        pCINT10DInputRec.setSzNbrIncmgFacilPhone(pInputMsg437.FacDetailEntStruct.getSzNbrIncmgFacilPhone());
        pCINT10DInputRec.setSzNbrIncmgFacilPhoneExt(pInputMsg437.FacDetailEntStruct.getSzNbrIncmgFacilPhoneExt());
        pCINT10DInputRec.setSzNmIncmgFacilSuprtdant(pInputMsg437.FacDetailEntStruct.getSzNmIncmgFacilSuprtdant());
        pCINT10DInputRec.setBIndIncmgFacilSearch(pInputMsg437.FacDetailEntStruct.getBIndIncmgFacilSearch());
        pCINT10DInputRec.setBIndIncmgFacilAbSupvd(pInputMsg437.FacDetailEntStruct.getBIndIncmgFacilAbSupvd());
        
        pCINT10DInputRec.setBIndIncmgOnGrnds(pInputMsg437.FacDetailEntStruct.getBIndIncmgOnGrnds());
        
        
        pCINT10DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg437.ArchInputStruct.getCReqFuncCd());
        rc = cint10dAUDdam(sqlca, pCINT10DInputRec, pCINT10DOutputRec);
        if (rc != 0) {
            
            //  Analyze error code
            switch (rc) {
                case NO_DATA_FOUND:
                    
                    //  Call DAM
                    rc = 0;
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    
                    //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                    pCINT10DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
                    
                    rc = cint10dAUDdam(sqlca, pCINT10DInputRec, pCINT10DOutputRec);
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR_TRANSACT();
            }
        }
        return rc;
        
    }

}
