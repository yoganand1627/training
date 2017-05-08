package gov.georgia.dhr.dfcs.sacwis.service.person;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS58DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS58DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CMSC35DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CMSC35DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
**  
** Module File:    ccfc29s.src
**
** Service Name:   ccfc29s
**
** Description:   This service will retrieve all records fro the INCOME
**                AND RESOURCES table that have an ID PERSON equal to the
**                one passed into the service.  Same DAM will retrieve the
**                NM PERSON FULL from the PERSON table for each ID PERSON.
**                The service will also retrieve the system date and the 
**                sum of incomes and resources for the person passed in 
**                for the current month.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  11 December 1995 
** 
** Programmer:    Richard Denton
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 16:39:40  $
**                      $Modtime:   29 Mar 1996 23:58:20  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccfc29s {
    CCFC29SO CCFC29S(CCFC29SI ccfc29si) {
        CCFC29SO ccfc29so = new CCFC29SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int i52 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  long            rc = 0;
        
        CLSS58DI pCLSS58DInputRec = null;
        CLSS58DO pCLSS58DOutputRec = null;
        CMSC35DI pCMSC35DInputRec = null;
        CMSC35DO pCMSC35DOutputRec = null;
        
        
        rc = ARC_PRFServiceStartTime_TUX(ccfc29si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(ccfc29so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        **  Call DAMs to retrieve data
        */
        
        
        /*
        ** Call to DAM CLSS58D to retrieve full row from INCOME AND RESOURCES
        ** based on ID PERSON passed from window.
        */
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSS58DInputRec = new CLSS58DI();
        
        pCLSS58DOutputRec = new CLSS58DO();
        pCLSS58DInputRec.setArchInputStruct(ccfc29si.getArchInputStruct());
        pCLSS58DInputRec.setUlIdPerson(ccfc29si.getUlIdPerson());
        pCLSS58DInputRec.getArchInputStruct().setUsPageNbr(ccfc29si.getArchInputStruct().getUsPageNbr());
        pCLSS58DInputRec.getArchInputStruct().setUlPageSizeNbr(ccfc29si.getArchInputStruct().getUlPageSizeNbr());
        rc = clss58dQUERYdam(sqlca, pCLSS58DInputRec, pCLSS58DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
                //  SQL Not Found Case for Dam CSES68D (ASR)
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Populate Output Message
                
                //  Set fields in CCFC29SO to fields in CLSS58DO
                
                for (i52 = 0;i52 < pCLSS58DOutputRec.getArchOutputStruct().getUlRowQty();i52++) {
                    ccfc29so.getROWCCFC29SOG00_ARRAY().getROWCCFC29SOG00(i52).setLAmtIncRsrc(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i52).getLAmtIncRsrc());
                    ccfc29so.getROWCCFC29SOG00_ARRAY().getROWCCFC29SOG00(i52).setSzCdIncRsrcIncome(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i52).getSzCdIncRsrcIncome());
                    ccfc29so.getROWCCFC29SOG00_ARRAY().getROWCCFC29SOG00(i52).setSzCdIncRsrcType(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i52).getSzCdIncRsrcType());
                    ccfc29so.getROWCCFC29SOG00_ARRAY().getROWCCFC29SOG00(i52).setDtDtIncRsrcFrom(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i52).getDtDtIncRsrcFrom());
                    ccfc29so.getROWCCFC29SOG00_ARRAY().getROWCCFC29SOG00(i52).setDtDtIncRsrcTo(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i52).getDtDtIncRsrcTo());
                    ccfc29so.getROWCCFC29SOG00_ARRAY().getROWCCFC29SOG00(i52).setUlIdPerson(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i52).getUlIdPerson());
                    ccfc29so.getROWCCFC29SOG00_ARRAY().getROWCCFC29SOG00(i52).setUlIdIncRsrcWorker(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i52).getUlIdIncRsrcWorker());
                    ccfc29so.getROWCCFC29SOG00_ARRAY().getROWCCFC29SOG00(i52).setUlIdIncRsrc(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i52).getUlIdIncRsrc());
                    
                    ccfc29so.getROWCCFC29SOG00_ARRAY().getROWCCFC29SOG00(i52).setCIndIncRsrcNotAccess(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i52).getCIndIncRsrcNotAccess());
                    ccfc29so.getROWCCFC29SOG00_ARRAY().getROWCCFC29SOG00(i52).setSzNmPersonFull(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i52).getSzNmPersonFull());
                    ccfc29so.getROWCCFC29SOG00_ARRAY().getROWCCFC29SOG00(i52).setSzSdsIncRrcsSource(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i52).getSzSdsIncRrcsSource());
                    ccfc29so.getROWCCFC29SOG00_ARRAY().getROWCCFC29SOG00(i52).setSzSdsIncRsrcVerfMethod(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i52).getSzSdsIncRsrcVerfMethod());
                    ccfc29so.getROWCCFC29SOG00_ARRAY().getROWCCFC29SOG00(i52).setTsLastUpdate(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i52).getTsLastUpdate());
                    ccfc29so.getROWCCFC29SOG00_ARRAY().getROWCCFC29SOG00(i52).setSzTxtIncRsrcDesc(pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i52).getSzTxtIncRsrcDesc());
                    
                    //  Call DAM
                    rc = ARC_UTLHostToDateAndTime(ccfc29so.getROWCCFC29SOG00_ARRAY().getROWCCFC29SOG00(i52).getDtScrDtLastUpdate() , 0, pCLSS58DOutputRec.getROWCLSS58DO_ARRAY().getROWCLSS58DO(i52).getTsLastUpdate() , 0);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                ccfc29so.getArchOutputStruct().setBMoreDataInd(pCLSS58DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                ccfc29so.getArchOutputStruct().setUlRowQty(pCLSS58DOutputRec.getArchOutputStruct().getUlRowQty());
                
                
                //  Embedded call CMSC35D to retrieve sum of all AMT INC 
                // RSRC from INCOME AND RESOURCES table.
                
                //  Allocate memory for DAM Input and Output Structures
                pCMSC35DInputRec = new CMSC35DI();
                
                pCMSC35DOutputRec = new CMSC35DO();
                pCMSC35DInputRec.setArchInputStruct(ccfc29si.getArchInputStruct());
                pCMSC35DInputRec.setUlIdPerson(ccfc29si.getUlIdPerson());
                rc = cmsc35dQUERYdam(sqlca, pCMSC35DInputRec, pCMSC35DOutputRec);
                
                //  Analyze return code
                switch (rc) {
                        
                        //  SQL Not Found Case for Dam CSES77D
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        ccfc29so.setLAmtIncRsrc(pCMSC35DOutputRec.getLAmtIncRsrc());
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                        break;
                }
                break;
                
                //  Success Case for Dam CSES68D (ASR)
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccfc29si.getArchInputStruct() , ccfc29so.getArchOutputStruct());
        
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
                
                //  Call DAM
                
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        
        return ccfc29so;
    }

}
