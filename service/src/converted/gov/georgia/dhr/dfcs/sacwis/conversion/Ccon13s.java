package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC11DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC11DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:   CCON13S.src
**
** Service Name:  County List Rtrv
**
** Description:   This service will retrieve all counties that may be 
**                contracted for a specific service code in the contract
**                service line item.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  October 4, 1995 
** 
** Programmer:    Sandra Wang
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:06:04  $
**                      $Modtime:   28 Mar 1996 22:29:30  $
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






public class Ccon13s {
    CCON13SO CCON13S(CCON13SI ccon13si) {
        CCON13SO ccon13so = new CCON13SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int i196 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  long            rc = 0;
        
        CLSC11DI pCLSC11DInputRec = null;
        CLSC11DO pCLSC11DOutputRec = null;
        
        /* Update NBR_RSRC_OPEN_SLOTS - adds one to the open slots*/
        rc = ARC_PRFServiceStartTime_TUX(ccon13si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSC11DInputRec = new CLSC11DI();
        
        pCLSC11DOutputRec = new CLSC11DO();
        pCLSC11DInputRec.setArchInputStruct(ccon13si.getArchInputStruct());
        pCLSC11DInputRec.setSzCdRsrcSvcService(ccon13si.getSzCdRsrcSvcService());
        
        pCLSC11DInputRec.setDtDtCncntyEffective(ccon13si.getDtDtCncntyEffective());
        pCLSC11DInputRec.setDtDtCncntyEnd(ccon13si.getDtDtCncntyEnd());
        pCLSC11DInputRec.setUlIdContract(ccon13si.getUlIdContract());
        pCLSC11DInputRec.setUlIdResource(ccon13si.getUlIdResource());
        pCLSC11DInputRec.setUlNbrCncntyLineItem(ccon13si.getUlNbrCncntyLineItem());
        pCLSC11DInputRec.setUlNbrCncntyPeriod(ccon13si.getUlNbrCncntyPeriod());
        pCLSC11DInputRec.setUlNbrCncntyVersion(ccon13si.getUlNbrCncntyVersion());
        pCLSC11DInputRec.getArchInputStruct().setUsPageNbr(ccon13si.getArchInputStruct().getUsPageNbr());
        pCLSC11DInputRec.getArchInputStruct().setUlPageSizeNbr(ccon13si.getArchInputStruct().getUlPageSizeNbr());
        rc = clsc11dQUERYdam(sqlca, pCLSC11DInputRec, pCLSC11DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                //  Populate Output Message
                
                //  Set fields in CCON13SOG to fields in CLSC11DOG
                
                for (i196 = 0;i196 < pCLSC11DOutputRec.getArchOutputStruct().getUlRowQty();i196++) {
                    ccon13so.getROWCCON13SOG_ARRAY().getROWCCON13SOG(i196).setUlIdCncnty(pCLSC11DOutputRec.getROWCLSC11DO_ARRAY().getROWCLSC11DO(i196).getUlIdCncnty());
                    ccon13so.getROWCCON13SOG_ARRAY().getROWCCON13SOG(i196).setSzCdCncntyCounty(pCLSC11DOutputRec.getROWCLSC11DO_ARRAY().getROWCLSC11DO(i196).getSzCdRsrcSvcCnty());
                    ccon13so.getROWCCON13SOG_ARRAY().getROWCCON13SOG(i196).setTsLastUpdate(pCLSC11DOutputRec.getROWCLSC11DO_ARRAY().getROWCLSC11DO(i196).getTsLastUpdate());
                }
                ccon13so.getArchOutputStruct().setUlRowQty(pCLSC11DOutputRec.getArchOutputStruct().getUlRowQty());
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CON_NO_COUNTY;
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
        ARC_PRFServiceStopTime_TUX(ccon13si.getArchInputStruct() , ccon13so.getArchOutputStruct());
        
        /*
        **  Set DPS Records Check Incomplete flag from the Records Check
        **  Table for retrieved records which are CdRecCheckType of "10" 
        **  (DPS Criminal History) and the DtRecCheckCompleted
        **  field is "12/31/4712"(max date).
        */
        /* SIR 13855 */
        
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
        return ccon13so;
    }

}
