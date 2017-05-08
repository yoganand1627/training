package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON11SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON11SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS11DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS11DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS14DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS14DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES95DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES95DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
** 
** Module File:    CCON11S.src
**
** Service Name:   CCON11S
**
** Description:   This service will receive IDContract, NbrCnperPeriod, and 
**                NbrCnverVersion and will return multiple rows to populate 
**                the listbox of CCON07W and the BFCD CCON01CB.  In addition, 
**                this service will receive Id Resource and will retrieve the
**                services maintained for the resource in the resource 
**                directory which are found on the Resource Service table.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  October 2, 1995 
** 
** Programmer:    Tyler L. Chessman
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   30 Jul 1997 16:24:20  $
**                      $Modtime:   30 Jul 1997 11:56:14  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**   07/27/97   saravigm    Financial Enhancement:Chages for the Equivalency
**                      check on the contract dialogue.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccon11s {
    CCON11SO CCON11S(CCON11SI ccon11si) {
        CCON11SO ccon11so = new CCON11SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i195 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##  long            rc = 0;
        
        CLSS11DI pCLSS11DInputRec = null;
        CLSS11DO pCLSS11DOutputRec = null;
        CLSS14DI pCLSS14DInputRec = null;
        CLSS14DO pCLSS14DOutputRec = null;
        CSES95DI pCSES95DInputRec = null;/* Financial Enhancement */
        CSES95DO pCSES95DOutputRec = null;
        
        rc = ARC_PRFServiceStartTime_TUX(ccon11si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        
        
        /**************************************************************************
        ** OPTIONAL CODE NOTE (BEGIN): Generic Retrieve DAM 1
        **************************************************************************/
        /* Financial Enhancement begins */
        /* Call to DAM CSES95D begins SIR#00000 */
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCSES95DInputRec = new CSES95DI();
        pCSES95DOutputRec = new CSES95DO();
        pCSES95DInputRec.setArchInputStruct(ccon11si.getArchInputStruct());
        pCSES95DInputRec.setUlIdContract(ccon11si.getUlIdContract());
        
        /*
        ** Set rc to MSG_DETAIL_DELETED
        */
        rc = cses95dQUERYdam(sqlca, pCSES95DInputRec, pCSES95DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                ccon11so.setUlNbrCnsvcLineItem(pCSES95DOutputRec.getUlNbrCnsvcLineItem());
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        if (rc == WtcHelperConstants.SQL_SUCCESS) {
            //  Allocate memory for DAM Input and Output Structures
            pCLSS14DInputRec = new CLSS14DI();
            
            pCLSS14DOutputRec = new CLSS14DO();
            pCLSS14DInputRec.setArchInputStruct(ccon11si.getArchInputStruct());
            pCLSS14DInputRec.setUlIdResource(ccon11si.getUlIdResource());
            pCLSS14DInputRec.getArchInputStruct().setUsPageNbr(ccon11si.getArchInputStruct().getUsPageNbr());
            
            pCLSS14DInputRec.getArchInputStruct().setUlPageSizeNbr(ccon11si.getUlPageSizeNbr());
            
            
            //  Call CSES68D
            rc = clss14dQUERYdam(sqlca, pCLSS14DInputRec, pCLSS14DOutputRec);
            
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    
                    //  Populate Output Message
                    
                    //  Set fields in CCON11SO to fields in CLSS14DO
                    
                    
                    
                    for (i195 = 0;i195 < pCLSS14DOutputRec.getArchOutputStruct().getUlRowQty();i195++) {
                        ccon11so.getROWCCON11SOG01_ARRAY().getROWCCON11SOG01(i195).setSzCdRsrcSvcService(pCLSS14DOutputRec.getROWCLSS14DO_ARRAY().getROWCLSS14DO(i195).getSzCdRsrcSvcService());
                    }
                    ccon11so.getArchOutputStruct().setBMoreDataInd(pCLSS14DOutputRec.getArchOutputStruct().getBMoreDataInd());
                    ccon11so.setUlRowQty(pCLSS14DOutputRec.getArchOutputStruct().getUlRowQty());
                    
                    
                    // Call DAM CLSS11D
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCLSS11DInputRec = new CLSS11DI();
                    
                    pCLSS11DOutputRec = new CLSS11DO();
                    pCLSS11DInputRec.setArchInputStruct(ccon11si.getArchInputStruct());
                    pCLSS11DInputRec.setUlIdContract(ccon11si.getUlIdContract());
                    pCLSS11DInputRec.setUlNbrCnsvcPeriod(ccon11si.getUlNbrCnperPeriod());
                    pCLSS11DInputRec.setUlNbrCnsvcVersion(ccon11si.getUlNbrCnverVersion());
                    pCLSS11DInputRec.getArchInputStruct().setUsPageNbr(ccon11si.getArchInputStruct().getUsPageNbr());
                    pCLSS11DInputRec.getArchInputStruct().setUlPageSizeNbr(ccon11si.getArchInputStruct().getUlPageSizeNbr());
                    
                    rc = clss11dQUERYdam(sqlca, pCLSS11DInputRec, pCLSS11DOutputRec);
                    
                    
                    //  Analyze return code
                    switch (rc) {
                            
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            
                            
                            
                            //  Populate Output Message
                            
                            //  Set fields in CCON11SO to fields in CLSS11DO
                            
                            
                            
                            for (i195 = 0;i195 < pCLSS11DOutputRec.getArchOutputStruct().getUlRowQty();i195++) {
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setCIndCnsvcNewRow(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getCIndCnsvcNewRow());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setSzCdCnsvcPaymentType(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getSzCdCnsvcPaymentType());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setSzCdCnsvcService(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getSzCdCnsvcService());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setSzNbrCnsvcUnitType(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getSzNbrCnsvcUnitType());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setTsLastUpdate(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getTsLastUpdate());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setUlAmtCnsvcAdminAllUsed(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getUlAmtCnsvcAdminAllUsed());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setUlAmtCnsvcEquip(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getUlAmtCnsvcEquip());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setUlAmtCnsvcEquipUsed(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getUlAmtCnsvcEquipUsed());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setUlAmtCnsvcFrgBenft(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getUlAmtCnsvcFrgBenft());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setUlAmtCnsvcFrgBenftUsed(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getUlAmtCnsvcFrgBenftUsed());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setUlAmtCnsvcOffItemUsed(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getUlAmtCnsvcOffItemUsed());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setUlAmtCnsvcOther(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getUlAmtCnsvcOther());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setUlAmtCnsvcOtherUsed(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getUlAmtCnsvcOtherUsed());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setUlAmtCnsvcSalary(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getUlAmtCnsvcSalary());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setUlAmtCnsvcSalaryUsed(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getUlAmtCnsvcSalaryUsed());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setUlAmtCnsvcSupply(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getUlAmtCnsvcSupply());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setUlAmtCnsvcSupplyUsed(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getUlAmtCnsvcSupplyUsed());
                                
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setUlAmtCnsvcTravel(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getUlAmtCnsvcTravel());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setUlAmtCnsvcTravelUsed(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getUlAmtCnsvcTravelUsed());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setUlAmtCnsvcUnitRate(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getUlAmtCnsvcUnitRate());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setUlAmtCnsvcUnitRateUsed(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getUlAmtCnsvcUnitRateUsed());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setUlIdCnsvc(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getUlIdCnsvc());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setUlNbrCnsvcFedMatch(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getUlNbrCnsvcFedMatch());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setUlNbrCnsvcLineItem(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getUlNbrCnsvcLineItem());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setUlNbrCnsvcLocalMatch(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getUlNbrCnsvcLocalMatch());
                                ccon11so.getROWCCON11SOG00_ARRAY().getROWCCON11SOG00(i195).setUlNbrCnsvcUnitRate(pCLSS11DOutputRec.getROWCLSS11DO_ARRAY().getROWCLSS11DO(i195).getUlNbrCnsvcUnitRate());
                            }
                            ccon11so.getArchOutputStruct().setBMoreDataInd(pCLSS11DOutputRec.getArchOutputStruct().getBMoreDataInd());
                            ccon11so.getArchOutputStruct().setUlRowQty(pCLSS11DOutputRec.getArchOutputStruct().getUlRowQty());
                            break;
                        case NO_DATA_FOUND:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                            
                            //  Set rc to MSG_DETAIL_DELETED
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            
                            break;
                    }
                    break;
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CON_NO_SVC_CODE;
                    
                    
                    //  Call CSES68D
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(ccon11si.getArchInputStruct() , ccon11so.getArchOutputStruct());
        
        /*
        ** Analyze error code
        */
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            //## END TUX/XML: Turn the XML buffer into an input message struct
            
            
            
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
        return ccon11so;
    }

}
