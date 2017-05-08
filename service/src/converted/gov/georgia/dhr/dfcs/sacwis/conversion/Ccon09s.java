package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON09SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON09SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC12DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC12DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
**
** Module File:    CCON09S.src
**
** Service Name:   CCON09S
**
** Description:   This service retrieves info. to fill listbox of the Budget
**                Transfer window.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  October 10, 1995
**
** Programmer:    Louise Lee
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:04:16  $
**                      $Modtime:   28 Mar 1996 22:28:54  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  5/17/2003 mcclaim   populated ROWCCON09SOG00[i].ulNbrCnsvcLineItem
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Ccon09s {
    CCON09SO CCON09S(CCON09SI ccon09si) {
        CCON09SO ccon09so = new CCON09SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        int i194 = 0;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        //##  long            rc = 0;
        
        CLSC12DI pCLSC12DInputRec = null;
        CLSC12DO pCLSC12DOutputRec = null;
        
        /* Set rc to ARC_SUCCESS */
        rc = ARC_PRFServiceStartTime_TUX(ccon09si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCLSC12DInputRec = new CLSC12DI();
        
        pCLSC12DOutputRec = new CLSC12DO();
        
        pCLSC12DInputRec.setArchInputStruct(ccon09si.getArchInputStruct());
        pCLSC12DInputRec.setUlIdContract(ccon09si.getUlIdContract());
        pCLSC12DInputRec.setUlNbrCnsvcPeriod(ccon09si.getUlNbrCnverPeriod());
        
        pCLSC12DInputRec.setUlNbrCnsvcVersion(ccon09si.getUlNbrCnverVersion());
        pCLSC12DInputRec.getArchInputStruct().setUsPageNbr(ccon09si.getArchInputStruct().getUsPageNbr());
        pCLSC12DInputRec.getArchInputStruct().setUlPageSizeNbr(ccon09si.getArchInputStruct().getUlPageSizeNbr());
        rc = clsc12dQUERYdam(sqlca, pCLSC12DInputRec, pCLSC12DOutputRec);
        
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                
                //  Populate Output Message
                
                //  Set fields in CCON09SO to fields in CLSC12DO
                
                for (i194 = 0;i194 < pCLSC12DOutputRec.getArchOutputStruct().getUlRowQty();i194++) {
                    
                    ccon09so.getROWCCON09SOG00_ARRAY().getROWCCON09SOG00(i194).setTsLastUpdate(pCLSC12DOutputRec.getROWCLSC12DO_ARRAY().getROWCLSC12DO(i194).getTsLastUpdate());
                    ccon09so.getROWCCON09SOG00_ARRAY().getROWCCON09SOG00(i194).setUlIdCnsvc(pCLSC12DOutputRec.getROWCLSC12DO_ARRAY().getROWCLSC12DO(i194).getUlIdCnsvc());
                    ccon09so.getROWCCON09SOG00_ARRAY().getROWCCON09SOG00(i194).setUlNbrCnsvcLineItem(pCLSC12DOutputRec.getROWCLSC12DO_ARRAY().getROWCLSC12DO(i194).getUlNbrCnsvcLineItem());
                    ccon09so.getROWCCON09SOG00_ARRAY().getROWCCON09SOG00(i194).setUlAmtCnsvcAdminAllUsed(pCLSC12DOutputRec.getROWCLSC12DO_ARRAY().getROWCLSC12DO(i194).getUlAmtCnsvcAdminAllUsed());
                    ccon09so.getROWCCON09SOG00_ARRAY().getROWCCON09SOG00(i194).setUlAmtCnsvcEquip(pCLSC12DOutputRec.getROWCLSC12DO_ARRAY().getROWCLSC12DO(i194).getUlAmtCnsvcEquip());
                    
                    //## BEGIN TUX/XML: Declare XML variables 
                    ccon09so.getROWCCON09SOG00_ARRAY().getROWCCON09SOG00(i194).setUlAmtCnsvcEquipUsed(pCLSC12DOutputRec.getROWCLSC12DO_ARRAY().getROWCLSC12DO(i194).getUlAmtCnsvcEquipUsed());
                    ccon09so.getROWCCON09SOG00_ARRAY().getROWCCON09SOG00(i194).setUlAmtCnsvcFrgBenft(pCLSC12DOutputRec.getROWCLSC12DO_ARRAY().getROWCLSC12DO(i194).getUlAmtCnsvcFrgBenft());
                    ccon09so.getROWCCON09SOG00_ARRAY().getROWCCON09SOG00(i194).setUlAmtCnsvcFrgBenftUsed(pCLSC12DOutputRec.getROWCLSC12DO_ARRAY().getROWCLSC12DO(i194).getUlAmtCnsvcFrgBenftUsed());
                    ccon09so.getROWCCON09SOG00_ARRAY().getROWCCON09SOG00(i194).setUlAmtCnsvcSalary(pCLSC12DOutputRec.getROWCLSC12DO_ARRAY().getROWCLSC12DO(i194).getUlAmtCnsvcSalary());
                    ccon09so.getROWCCON09SOG00_ARRAY().getROWCCON09SOG00(i194).setUlAmtCnsvcSalaryUsed(pCLSC12DOutputRec.getROWCLSC12DO_ARRAY().getROWCLSC12DO(i194).getUlAmtCnsvcSalaryUsed());
                    ccon09so.getROWCCON09SOG00_ARRAY().getROWCCON09SOG00(i194).setUlAmtCnsvcSupply(pCLSC12DOutputRec.getROWCLSC12DO_ARRAY().getROWCLSC12DO(i194).getUlAmtCnsvcSupply());
                    ccon09so.getROWCCON09SOG00_ARRAY().getROWCCON09SOG00(i194).setUlAmtCnsvcSupplyUsed(pCLSC12DOutputRec.getROWCLSC12DO_ARRAY().getROWCLSC12DO(i194).getUlAmtCnsvcSupplyUsed());
                    ccon09so.getROWCCON09SOG00_ARRAY().getROWCCON09SOG00(i194).setUlAmtCnsvcTravel(pCLSC12DOutputRec.getROWCLSC12DO_ARRAY().getROWCLSC12DO(i194).getUlAmtCnsvcTravel());
                    ccon09so.getROWCCON09SOG00_ARRAY().getROWCCON09SOG00(i194).setUlAmtCnsvcTravelUsed(pCLSC12DOutputRec.getROWCLSC12DO_ARRAY().getROWCLSC12DO(i194).getUlAmtCnsvcTravelUsed());
                    ccon09so.getROWCCON09SOG00_ARRAY().getROWCCON09SOG00(i194).setUlAmtCnsvcOther(pCLSC12DOutputRec.getROWCLSC12DO_ARRAY().getROWCLSC12DO(i194).getUlAmtCnsvcOther());
                    ccon09so.getROWCCON09SOG00_ARRAY().getROWCCON09SOG00(i194).setUlAmtCnsvcOtherUsed(pCLSC12DOutputRec.getROWCLSC12DO_ARRAY().getROWCLSC12DO(i194).getUlAmtCnsvcOtherUsed());
                    ccon09so.getROWCCON09SOG00_ARRAY().getROWCCON09SOG00(i194).setUlAmtCnsvcUnitRate(pCLSC12DOutputRec.getROWCLSC12DO_ARRAY().getROWCLSC12DO(i194).getUlAmtCnsvcUnitRate());
                    ccon09so.getROWCCON09SOG00_ARRAY().getROWCCON09SOG00(i194).setUlAmtCnsvcUnitRateUsed(pCLSC12DOutputRec.getROWCLSC12DO_ARRAY().getROWCLSC12DO(i194).getUlAmtCnsvcUnitRateUsed());
                    ccon09so.getROWCCON09SOG00_ARRAY().getROWCCON09SOG00(i194).setSzCdCnsvcService(pCLSC12DOutputRec.getROWCLSC12DO_ARRAY().getROWCLSC12DO(i194).getSzCdCnsvcService());
                    ccon09so.getROWCCON09SOG00_ARRAY().getROWCCON09SOG00(i194).setSzCdCnsvcPaymentType(pCLSC12DOutputRec.getROWCLSC12DO_ARRAY().getROWCLSC12DO(i194).getSzCdCnsvcPaymentType());
                }
                ccon09so.getArchOutputStruct().setUlRowQty(pCLSC12DOutputRec.getArchOutputStruct().getUlRowQty());
                
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
        ARC_PRFServiceStopTime_TUX(ccon09si.getArchInputStruct() , ccon09so.getArchOutputStruct());
        
        /** 6/4/2003, Matthew McClain, remove single quotes **/
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
        
        return ccon09so;
    }

}
