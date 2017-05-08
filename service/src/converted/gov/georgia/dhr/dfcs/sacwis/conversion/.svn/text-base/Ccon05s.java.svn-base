package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS06DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS06DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:    CCON05S.src
**
** Service Name:   CCON05S
**
** Description:   This service will receive IdContract and retrieve 
**                NbrCnperPeriod, DtCnperStart, DtCnperTerm, DtCnperClosure,
**                CdCnperStatus, IndCnperRenewal, and IndCnperSigned from
**                the Contract Period table.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  10/10/95 
** 
** Programmer:    Diana Feller
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:03:06  $
**                      $Modtime:   28 Mar 1996 22:28:06  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  06/09/05  Ochumd    Sir#23430 - Added a legal identifier field for contracts.
**                      This service will now retrieve NbrLegalIdentifier
**                      as part of this process.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccon05s {
    CCON05SO CCON05S(CCON05SI ccon05si) {
        CCON05SO ccon05so = new CCON05SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code   */
        int i191 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  long            rc = 0;
        
        CLSS06DI pCLSS06DInputRec = null;
        CLSS06DO pCLSS06DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(ccon05si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(ccon05so.getDtSysDtGenericSysdate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSS06DInputRec = new CLSS06DI();
        
        pCLSS06DOutputRec = new CLSS06DO();
        pCLSS06DInputRec.setArchInputStruct(ccon05si.getArchInputStruct());
        pCLSS06DInputRec.setUlIdContract(ccon05si.getUlIdContract());
        pCLSS06DInputRec.getArchInputStruct().setUsPageNbr(ccon05si.getArchInputStruct().getUsPageNbr());
        pCLSS06DInputRec.getArchInputStruct().setUlPageSizeNbr(ccon05si.getArchInputStruct().getUlPageSizeNbr());
        
        rc = clss06dQUERYdam(sqlca, pCLSS06DInputRec, pCLSS06DOutputRec);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                
                //  Populate Output Message
                
                //  Set fields in CCON05SO to fields in CLSS06DO
                
                for (i191 = 0;i191 < pCLSS06DOutputRec.getArchOutputStruct().getUlRowQty();i191++) {
                    ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00(i191).setUlNbrCnperPeriod(pCLSS06DOutputRec.getROWCLSS06DO_ARRAY().getROWCLSS06DO(i191).getUlNbrCnperPeriod());
                    ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00(i191).setDtDtCnperClosure(pCLSS06DOutputRec.getROWCLSS06DO_ARRAY().getROWCLSS06DO(i191).getDtDtCnperClosure());
                    ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00(i191).setDtDtCnperStart(pCLSS06DOutputRec.getROWCLSS06DO_ARRAY().getROWCLSS06DO(i191).getDtDtCnperStart());
                    ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00(i191).setDtDtCnperTerm(pCLSS06DOutputRec.getROWCLSS06DO_ARRAY().getROWCLSS06DO(i191).getDtDtCnperTerm());
                    ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00(i191).setSzCdCnperStatus(pCLSS06DOutputRec.getROWCLSS06DO_ARRAY().getROWCLSS06DO(i191).getSzCdCnperStatus());
                    ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00(i191).setUlNbrLegalIdentifier(pCLSS06DOutputRec.getROWCLSS06DO_ARRAY().getROWCLSS06DO(i191).getUlNbrLegalIdentifier());
                    ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00(i191).setCIndCnperRenewal(pCLSS06DOutputRec.getROWCLSS06DO_ARRAY().getROWCLSS06DO(i191).getCIndCnperRenewal());
                    ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00(i191).setCIndCnperSigned(pCLSS06DOutputRec.getROWCLSS06DO_ARRAY().getROWCLSS06DO(i191).getCIndCnperSigned());
                    ccon05so.getROWCCON05SOG00_ARRAY().getROWCCON05SOG00(i191).setTsLastUpdate(pCLSS06DOutputRec.getROWCLSS06DO_ARRAY().getROWCLSS06DO(i191).getTsLastUpdate());
                }
                ccon05so.getArchOutputStruct().setBMoreDataInd(pCLSS06DOutputRec.getArchOutputStruct().getBMoreDataInd());
                
                //##                          return (FND_SUCCESS);
                ccon05so.getArchOutputStruct().setUlRowQty(pCLSS06DOutputRec.getArchOutputStruct().getUlRowQty());
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                // 
                // SIR 1858: Replaced Record Group
                // "WCD_ROWCCMN01UIG00.ROWCCMN01UIG01" with "ROWCSVC02SIG03"
                // since the PostEvent Structure could only handle 30 people
                // at a time.  This window requires up to 50 people being
                // added to Event Person Link at a time, so a new Record
                // Group had to be added to the Save Service Input Message.
                // Also DAM CCMN68D was added to the save service to handle
                // adding people to Event Person Link instead of the
                // PostEvent Function.
                // 
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                //   Increment usVersRow
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccon05si.getArchInputStruct() , ccon05so.getArchOutputStruct());
        
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
                
                //  Call the AUD DAM for the CONTACT table.
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return ccon05so;
    }

}
