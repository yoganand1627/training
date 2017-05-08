package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CDYN01DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CDYN01DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:   CCON01S.src 
**
** Service Name:  CCON01S
**
** Description:   Contract List Retrieve - This service will retrieve a 
**                list of contract records matching a set of dynamic search 
**                criteria.  The columns it retrieves are Contract ID, 
**                Region, Function Type, Program Type, Budget Limit Indicator,
**                and Contract Manager Name from the Contracts table and 
**                Resource ID, Resource Name and Resource VID from the 
**                Resource Address table.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  09/14/95 
** 
** Programmer:    Diana Feller
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccon01s {
    CCON01SO CCON01S(CCON01SI ccon01si) {
        CCON01SO ccon01so = new CCON01SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i187 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  long            rc = 0;
        
        CDYN01DI pCDYN01DInputRec = null;
        CDYN01DO pCDYN01DOutputRec = null;
        
        
        
        rc = ARC_PRFServiceStartTime_TUX(ccon01si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        ** Perform Main Processing:
        ** Retrieve DAM CDYN01D - CONTRACT DYNAMIC LST
        */
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCDYN01DInputRec = new CDYN01DI();
        
        pCDYN01DOutputRec = new CDYN01DO();
        pCDYN01DInputRec.setArchInputStruct(ccon01si.getArchInputStruct());
        pCDYN01DInputRec.setSzCdCntrctFuncType(ccon01si.getSzCdCntrctFuncType());
        pCDYN01DInputRec.setSzCdCntrctProgramType(ccon01si.getSzCdCntrctProgramType());
        pCDYN01DInputRec.setSzCdCntrctRegion(ccon01si.getSzCdCntrctRegion());
        pCDYN01DInputRec.setCIndCntrctBudgLimit(ccon01si.getCIndCntrctBudgLimit());
        pCDYN01DInputRec.setUlIdContract(ccon01si.getUlIdContract());
        pCDYN01DInputRec.setUlIdResource(ccon01si.getUlIdResource());
        pCDYN01DInputRec.setDtDtCnperStart(ccon01si.getDtDtCnperStart());
        pCDYN01DInputRec.setDtDtCnperTerm(ccon01si.getDtDtCnperTerm());
        pCDYN01DInputRec.getArchInputStruct().setUsPageNbr(ccon01si.getArchInputStruct().getUsPageNbr());
        pCDYN01DInputRec.getArchInputStruct().setUlPageSizeNbr(ccon01si.getArchInputStruct().getUlPageSizeNbr());
        /*
        ** We don't care if no rows were found here so just
        ** exit switch
        */
        rc = cdyn01dQUERYdam(sqlca, pCDYN01DInputRec, pCDYN01DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                
                //  Populate Output Message
                
                //  Set fields in CCON01SO to fields in CDYN01DO for all rows
                
                for (i187 = 0;i187 < pCDYN01DOutputRec.getArchOutputStruct().getUlRowQty();i187++) {
                    ccon01so.getROWCCON01SOG00_ARRAY().getROWCCON01SOG00(i187).setSzCdCntrctFuncType(pCDYN01DOutputRec.getROWCDYN01DO_ARRAY().getROWCDYN01DO(i187).getSzCdCntrctFuncType());
                    ccon01so.getROWCCON01SOG00_ARRAY().getROWCCON01SOG00(i187).setSzCdCntrctProgramType(pCDYN01DOutputRec.getROWCDYN01DO_ARRAY().getROWCDYN01DO(i187).getSzCdCntrctProgramType());
                    ccon01so.getROWCCON01SOG00_ARRAY().getROWCCON01SOG00(i187).setSzCdCntrctRegion(pCDYN01DOutputRec.getROWCDYN01DO_ARRAY().getROWCDYN01DO(i187).getSzCdCntrctRegion());
                    ccon01so.getROWCCON01SOG00_ARRAY().getROWCCON01SOG00(i187).setSzNmResource(pCDYN01DOutputRec.getROWCDYN01DO_ARRAY().getROWCDYN01DO(i187).getSzNmResource());
                    ccon01so.getROWCCON01SOG00_ARRAY().getROWCCON01SOG00(i187).setSzNbrRsrcAddrVid(pCDYN01DOutputRec.getROWCDYN01DO_ARRAY().getROWCDYN01DO(i187).getSzNbrRsrcAddrVid());
                    ccon01so.getROWCCON01SOG00_ARRAY().getROWCCON01SOG00(i187).setSzNmPersonFull(pCDYN01DOutputRec.getROWCDYN01DO_ARRAY().getROWCDYN01DO(i187).getSzNmPersonFull());
                    ccon01so.getROWCCON01SOG00_ARRAY().getROWCCON01SOG00(i187).setUlIdContract(pCDYN01DOutputRec.getROWCDYN01DO_ARRAY().getROWCDYN01DO(i187).getUlIdContract());
                    ccon01so.getROWCCON01SOG00_ARRAY().getROWCCON01SOG00(i187).setCIndCntrctBudgLimit(pCDYN01DOutputRec.getROWCDYN01DO_ARRAY().getROWCDYN01DO(i187).getCIndCntrctBudgLimit());
                    ccon01so.getROWCCON01SOG00_ARRAY().getROWCCON01SOG00(i187).setUlIdResource(pCDYN01DOutputRec.getROWCDYN01DO_ARRAY().getROWCDYN01DO(i187).getUlIdResource());
                }
                
                ccon01so.getArchOutputStruct().setBMoreDataInd(pCDYN01DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                ccon01so.getArchOutputStruct().setUlRowQty(pCDYN01DOutputRec.getArchOutputStruct().getUlRowQty());
                break;
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
        ARC_PRFServiceStopTime_TUX(ccon01si.getArchInputStruct() , ccon01so.getArchOutputStruct());
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
                
                //  Call CAUD36D
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccon01so;
    }

}
