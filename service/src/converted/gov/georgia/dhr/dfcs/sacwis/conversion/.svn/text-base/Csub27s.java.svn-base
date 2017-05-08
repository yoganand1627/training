package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB27SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB27SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS26DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS26DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:    csub27s.src
**
** Service Name:   CSUB27S
**
** Description:   This service will receive Id PPPT Event.  It will retrieve
**                n rows of participants from the PPT PARTICIPANT table.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  10/30/95 
** 
** Programmer:    Nancy Zimmerman
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 19:16:16  $
**                      $Modtime:   28 Mar 1996 23:22:34  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
** 03/19/03   Srini	IMPACT: set the rc value to FND_SUCCESS as we need to 
**			return success in the case of SQL_NOT_FOUND.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Csub27s {
    CSUB27SO CSUB27S(CSUB27SI csub27si) {
        CSUB27SO csub27so = new CSUB27SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int i425 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        
        CLSS26DI pCLSS26DInputRec = null;
        CLSS26DO pCLSS26DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(csub27si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(csub27so.getDtSysDtGenericSysdate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSS26DInputRec = new CLSS26DI();
        
        pCLSS26DOutputRec = new CLSS26DO();
        pCLSS26DInputRec.setArchInputStruct(csub27si.getArchInputStruct());
        pCLSS26DInputRec.setUlIdEvent(csub27si.getUlIdPptEvent());
        pCLSS26DInputRec.getArchInputStruct().setUsPageNbr(csub27si.getArchInputStruct().getUsPageNbr());
        pCLSS26DInputRec.getArchInputStruct().setUlPageSizeNbr(csub27si.getArchInputStruct().getUlPageSizeNbr());
        
        /*
        ** Call CAUD17D.  The Contract Service AUD performs a full row
        ** insert to the Contract Service table.
        */
        rc = clss26dQUERYdam(sqlca, pCLSS26DInputRec, pCLSS26DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                
                //  Populate Output Message
                
                //  Set fields in CSUB27SO to fields in CLSS26DO
                for (i425 = 0;i425 < pCLSS26DOutputRec.getArchOutputStruct().getUlRowQty();i425++) {
                    
                    csub27so.getROWCSUB27SOG00_ARRAY().getROWCSUB27SOG00(i425).setUlIdPerson(pCLSS26DOutputRec.getROWCLSS26DO_ARRAY().getROWCLSS26DO(i425).getUlIdPerson());
                    csub27so.getROWCSUB27SOG00_ARRAY().getROWCSUB27SOG00(i425).setUlIdPptPart(pCLSS26DOutputRec.getROWCLSS26DO_ARRAY().getROWCLSS26DO(i425).getUlIdPptPart());
                    csub27so.getROWCSUB27SOG00_ARRAY().getROWCSUB27SOG00(i425).setSzCdPptPartType(pCLSS26DOutputRec.getROWCLSS26DO_ARRAY().getROWCLSS26DO(i425).getSzCdPptPartType());
                    csub27so.getROWCSUB27SOG00_ARRAY().getROWCSUB27SOG00(i425).setSzNmPptPartFull(pCLSS26DOutputRec.getROWCLSS26DO_ARRAY().getROWCLSS26DO(i425).getSzNmPptPartFull());
                    csub27so.getROWCSUB27SOG00_ARRAY().getROWCSUB27SOG00(i425).setSzSdsPptPartRelationship(pCLSS26DOutputRec.getROWCLSS26DO_ARRAY().getROWCLSS26DO(i425).getSzSdsPptPartRelationship());
                    csub27so.getROWCSUB27SOG00_ARRAY().getROWCSUB27SOG00(i425).setSzCdPptNotifType(pCLSS26DOutputRec.getROWCLSS26DO_ARRAY().getROWCLSS26DO(i425).getSzCdPptNotifType());
                    csub27so.getROWCSUB27SOG00_ARRAY().getROWCSUB27SOG00(i425).setDtDtPptPartDateNotif(pCLSS26DOutputRec.getROWCLSS26DO_ARRAY().getROWCLSS26DO(i425).getDtDtPptPartDateNotif());
                    csub27so.getROWCSUB27SOG00_ARRAY().getROWCSUB27SOG00(i425).setDtDtPptDate(pCLSS26DOutputRec.getROWCLSS26DO_ARRAY().getROWCLSS26DO(i425).getDtDtPptPart());
                    csub27so.getROWCSUB27SOG00_ARRAY().getROWCSUB27SOG00(i425).setTsLastUpdate(pCLSS26DOutputRec.getROWCLSS26DO_ARRAY().getROWCLSS26DO(i425).getTsLastUpdate());
                }
                csub27so.getArchOutputStruct().setBMoreDataInd(pCLSS26DOutputRec.getArchOutputStruct().getBMoreDataInd());
                csub27so.getArchOutputStruct().setUlRowQty(pCLSS26DOutputRec.getArchOutputStruct().getUlRowQty());
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = SUCCESS;
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
        ARC_PRFServiceStopTime_TUX(csub27si.getArchInputStruct() , csub27so.getArchOutputStruct());
        
        
        
        /*
        ** Perform edits for APR - Investigation
        ** Stage for a community with an administrative
        ** review
        */
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            //  Check to see if Admin Review exits for
            // this stage
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
        return csub27so;
    }

    
}
