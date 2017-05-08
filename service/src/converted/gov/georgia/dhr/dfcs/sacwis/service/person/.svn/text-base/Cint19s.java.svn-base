package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT17DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT17DO;
/**************************************************************************
**
** Module File:   CINT19S.src
** Service Name:  CINT19S
**
**
** Description:   This service will retrieve numbers for a person
**                from the person_id table.  The table contains the id person
**                as its FK.  This will be used in the select clause.
**
**
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/19/95
**
** Programmer:    Steven Elliott
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  05/12/95  ELLIOTSL  The logic to populate the output message with the
**
**                      current system date has been moved to before all
**                      DAM calls from after all DAM calls.  The reason
**                      for this is bcause the PROCESS_TUX_RC_ERROR that
**                      appears immediately after the DAM call may cause
**                      the service to exit even though the system date
**                      is still needed.
**
**  05/12/95  ELLIOTSL  The PROCESS_TUX_RC_ERROR that occures after CallCINT17D
**                      has been moved to the end of this service call in
**                      order to assure that service wrap up logic will
**                      always get excecuted.
**
**  07/26/96   zabihin  sir 21891 : version control code was missing,I
**                      I added the lines.
**
**  04/04/03   Srini    rc set to FND_SUCCESS instead of ARC_ERR_NO_PROC_RC
**						in the case of SQL_NOT_FOUND for impact.
**
**  03/31/05 demoma		Sir23446 added variable bIndValidateByInterface for the
**						new field in table PERSON_ID.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cint19s {
    CINT19SO CINT19S(CINT19SI cint19si) {
        CINT19SO cint19so = new CINT19SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        /*
        ** Declare FOUNDATION variables
        */
        int BegPageRow = 0;
        int EndPageRow = 0;
        int i260 = 0;
        rc = ARC_PRFServiceStartTime_TUX(cint19si.getArchInputStruct());
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /* SIR 21891 - missing versioning */
        /*
        ** Run-time Versioning
        */
        
        /*
        ** Check buffer size
        */
        
        /*
        ** Process error message and return to client
        */
        
        /*
        ** Initialize output message and length
        */
        
        /*
        ** Initialize service status fields
        */
        
        /* The following line will place the current system date into the
        ** output message of the service.
        */
        ARC_UTLGetDateAndTime(cint19so.getDtWCDDtSystemDate() , 0);
        rc = Ccfc14s.CallCINT17D(cint19si, cint19so, pServiceStatus);
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cint19si.getArchInputStruct() , cint19so.getArchOutputStruct());
        
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
                
                
                //  Call CSES80D
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cint19so;
    }

    
    static int CallCINT17D(CINT19SI pInputMsg461, CINT19SO pOutputMsg421, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int ulRowCounter = 0;/* Loop counter */
        
        /*
        ** Declare local variables
        */
        CINT17DI pCINT17DInputRec = null;
        CINT17DO pCINT17DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT17DInputRec = new CINT17DI();
        
        pCINT17DOutputRec = new CINT17DO();
        pCINT17DInputRec.setUlIdPerson(pInputMsg461.getPersonIdInStruct().getUlIdPerson());
        pCINT17DInputRec.setTsSysTsQuery(pInputMsg461.getPersonIdInStruct().getTsSysTsQuery());
        pCINT17DInputRec.setBSysIndIntake(pInputMsg461.getPersonIdInStruct().getBSysIndIntake());
        pCINT17DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg461.getArchInputStruct().getUsPageNbr());
        pCINT17DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg461.getArchInputStruct().getUlPageSizeNbr());
        
        /*
        ** Call CRES54D
        */
        rc = cint17dQUERYdam(sqlca, pCINT17DInputRec, pCINT17DOutputRec);
        if (rc != 0) {
            switch (rc) {
                case NO_DATA_FOUND:
                    pServiceStatus.severity = SUCCESS;
                    pServiceStatus.explan_code = SUCCESS;
                    rc = SUCCESS;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    
            }
        }
        
        else {
            
            //  Populate Output Message
            for (ulRowCounter = 0;ulRowCounter < pCINT17DOutputRec.getArchOutputStruct().getUlRowQty();ulRowCounter++) {
                pOutputMsg421.getCINT14WLB_ARRAY().getCINT14WLB(ulRowCounter).setSzCdPersonIdType(pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(ulRowCounter).getSzCdPersonIdType());
                pOutputMsg421.getCINT14WLB_ARRAY().getCINT14WLB(ulRowCounter).setSzCdScrDataAction((char) (0));
                pOutputMsg421.getCINT14WLB_ARRAY().getCINT14WLB(ulRowCounter).setBIndPersonIDInvalid(pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(ulRowCounter).getBIndPersonIDInvalid());
                pOutputMsg421.getCINT14WLB_ARRAY().getCINT14WLB(ulRowCounter).setSzDescPersonID(pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(ulRowCounter).getSzDescPersonID());
                pOutputMsg421.getCINT14WLB_ARRAY().getCINT14WLB(ulRowCounter).setDtPersonIDStart(pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(ulRowCounter).getDtPersonIDStart());
                pOutputMsg421.getCINT14WLB_ARRAY().getCINT14WLB(ulRowCounter).setDtPersonIDEnd(pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(ulRowCounter).getDtPersonIDEnd());
                pOutputMsg421.getCINT14WLB_ARRAY().getCINT14WLB(ulRowCounter).setSzNbrPersonIdNumber(pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(ulRowCounter).getSzNbrPersonIdNumber());
                pOutputMsg421.getCINT14WLB_ARRAY().getCINT14WLB(ulRowCounter).setUlIdPersonId(pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(ulRowCounter).getUlIdPersonId());
                pOutputMsg421.getCINT14WLB_ARRAY().getCINT14WLB(ulRowCounter).setUlIdPerson(pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(ulRowCounter).getUlIdPerson());
                pOutputMsg421.getCINT14WLB_ARRAY().getCINT14WLB(ulRowCounter).setTsSysTsLastUpdate2(pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(ulRowCounter).getTsSysTsLastUpdate2());
                pOutputMsg421.getCINT14WLB_ARRAY().getCINT14WLB(ulRowCounter).setBIndValidateByInterface(pCINT17DOutputRec.getROWCINT17DO_ARRAY().getROWCINT17DO(ulRowCounter).getBIndValidateByInterface());
            }
            pOutputMsg421.setArchOutputStruct(pCINT17DOutputRec.getArchOutputStruct());
        }
        return rc;
    }

}
