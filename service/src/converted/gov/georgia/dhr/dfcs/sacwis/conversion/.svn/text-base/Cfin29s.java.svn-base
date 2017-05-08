package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN29SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC27DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC27DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC28DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC28DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV81DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV81DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:    CFIN29S.src
**
** Service Name:   CFIN29S
**
** Description:   This service will retrieve the Name Person Full for a given
**                Person ID and the Unit Rate, Contract Service Line Item
**                Unit Type and Payment Type from Contract and Service Auth
**                Dtl ID from the Service Auth Dtl table.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  December 18, 1995
**
** Programmer:    Danny Gillespie
**
** Archive Information: $Revision:   1.2.1.0  $
**                      $Date:   10 Mar 1997 16:34:10  $
**                      $Modtime:   10 Mar 1997 15:37:52  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**
**  02/20/96  MCRAEBS   SIR 3193 - This service should not validate the Service
**                      Authorization for an Adoption Subsidy Invoice.
**                      Placed the DAM that validates the SA in an if statement
**                      that will check the Invoice Type.  If the type is
**                      'ADS', the DAM will not be called.  BSM
**
**  03/06/96  MCRAEBS   SIR 3596 - Call CIN81D to retrieve the NmPersonFull.
**                      CSEC27 also retrieves NmPersonFull, but CSEC27 is
**                      not called if the Invoice Type is Adoption Subsidy.
**
**  03/18/96  ADKINSMC  SIR 3987 - Coded the case SQL_NOT_FOUND for CIN81D
**                      to return a System Status Message that Person ID is
**                      invalid.
**
**  01/20/97  durang    SIR 11813 - Modified CFIN29S to prevent from
**                      retrieving incorrect service auth dtl numbers.
**
**  02/18/97  durang    SIR 13369 - Modified CFIN29S to accomodate
**                      AE converted data.
**  03/10/97  durang    SIR 13369b - Modified CFIN29S to accomodate
**                      AE converted data.  Since invoices prior to
**                      01/01/1996 did not require a svc auth id #
**                      (i.e., in certain cases), this edit will be
**                      relaxed in the delivered service detail
**                      on-line validation.
**   1/23/03   DWW      Added following line for error handling:
**                      if (RetVal == FND_SUCESS)  { rc=FND_SUCCESS; }
**  10/19/03  CORLEYAN  SIR 	 Set the Severity to Error if an error
**                      needs to be returned.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfin29s {
    
    /*
    ** Declare FOUNDATION variables
    */
    
    /*
    ** Declare local variables
    */
    
    static final String ADOPTION_INVOICE = "ADS";
    static final int NINETY_SIX = 1996;
    static final int NINETY_FIVE = 1995;
    static final int SEPTEMBER = 9;
    static final int JUNE = 6;
    CFIN29SO CFIN29S(CFIN29SI cfin29si) {
        CFIN29SO cfin29so = new CFIN29SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i236 = 0;
        
        public public public public public CSEC27DI pCSEC27DInputRec = null;
        CSEC27DO pCSEC27DOutputRec = null;
        
        CSEC28DI pCSEC28DInputRec = null;
        CSEC28DO pCSEC28DOutputRec = null;
        CINV81DI pCINV81DInputRec = null;/* SIR 3596 - Add Retrieve Person Info */
        CINV81DO pCINV81DOutputRec = null;/* to Service.  */
        int RetVal = 0;/* RetVal if DAM is successful */
        /* Call DAM */
        rc = ARC_PRFServiceStartTime_TUX(cfin29si.getArchInputStruct());
        
        /*
        ** Analyze error code
        */
        if ((0 != cfin29si.getSzCdInvoType().compareTo(ADOPTION_INVOICE)) && (Cint14s.INDICATOR_NO == cfin29si.getCIndRsrcTransport())) {
            
            //  Allocate memory for DAM Input and Output Structures
            pCSEC27DInputRec = new CSEC27DI();
            
            pCSEC27DOutputRec = new CSEC27DO();
            pCSEC27DInputRec.setArchInputStruct(cfin29si.getArchInputStruct());
            pCSEC27DInputRec.setUlIdPerson(cfin29si.getUlIdPerson());
            pCSEC27DInputRec.setUlIdContract(cfin29si.getUlIdContract());
            pCSEC27DInputRec.setSzCdSvcDtlCounty(cfin29si.getSzCdSvcDtlCounty());
            pCSEC27DInputRec.setSzCdSvcDtlService(cfin29si.getSzCdSvcDtlService());
            
            pCSEC27DInputRec.setUMoSvcDtlSvcMonth(cfin29si.getUMoSvcDtlSvcMonth());
            pCSEC27DInputRec.setUYrSvcDtlServiceYear(cfin29si.getUYrSvcDtlServiceYear());
            
            // Call DAM
            rc = csec27dQUERYdam(sqlca, pCSEC27DInputRec, pCSEC27DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    cfin29so.setSzNmPersonFull(pCSEC27DOutputRec.getSzNmPersonFull());
                    cfin29so.setUlIdSvcAuthDtl(pCSEC27DOutputRec.getUlIdSvcAuthDtl());
                    //  Set RetVal to FND_SUCCESS
                    
                    RetVal = SUCCESS;
                    break;
                    
                case NO_DATA_FOUND:
                    if (((cfin29si.getUMoSvcDtlSvcMonth() < SEPTEMBER) && (cfin29si.getUYrSvcDtlServiceYear() <= NINETY_SIX) && (true == cfin29si.getCIndSvcAuthComplete())) || ((cfin29si.getUMoSvcDtlSvcMonth() < JUNE) && (cfin29si.getUYrSvcDtlServiceYear() <= NINETY_SIX) && (false == cfin29si.getCIndSvcAuthComplete())) || (cfin29si.getUYrSvcDtlServiceYear() <= NINETY_FIVE)) {
                        //  Call CIN81D to retrieve the NmPersonFull.
                        
                        //  Allocate memory for DAM Input and Output Structures
                        pCINV81DInputRec = new CINV81DI();
                        
                        pCINV81DOutputRec = new CINV81DO();
                        
                        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
                        pCINV81DInputRec.setArchInputStruct(cfin29si.getArchInputStruct());
                        pCINV81DInputRec.setUlIdPerson(cfin29si.getUlIdPerson());
                        rc = cinv81dQUERYdam(sqlca, pCINV81DInputRec, pCINV81DOutputRec);
                        
                        //  Analyze return code
                        switch (rc) {
                            case WtcHelperConstants.SQL_SUCCESS:
                                pServiceStatus.severity = FND_SEVERITY_OK;
                                pServiceStatus.explan_code = SUCCESS;
                                cfin29so.setSzNmPersonFull(pCINV81DOutputRec.getSzNmPersonFull());
                                
                                //  Set RetVal to FND_SUCCESS
                                
                                RetVal = SUCCESS;
                                break;
                            case NO_DATA_FOUND:
                                pServiceStatus.severity = FND_SEVERITY_ERROR;
                                pServiceStatus.explan_code = Messages.SSM_FIN_INVALID_PRSN_ID;
                                rc = Messages.SSM_FIN_INVALID_PRSN_ID;
                                
                                //   Set RetVal to SSM_FIN_INVALID_PRSN_ID
                                
                                RetVal = Messages.SSM_FIN_INVALID_PRSN_ID;
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                break;
                        }
                    }
                    else {
                        pServiceStatus.severity = FND_SEVERITY_ERROR;
                        pServiceStatus.explan_code = Messages.SSM_FIN_NO_SVC_AUTH_DTL;
                        // Call DAM
                        rc = Messages.SSM_FIN_NO_SVC_AUTH_DTL;
                        
                        //  Set RetVal to SSM_FIN_NO_SVC_AUTH_DTL
                        
                        RetVal = Messages.SSM_FIN_NO_SVC_AUTH_DTL;
                    }
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        /**************************************************************************
        ** END: CSEC27D
        **************************************************************************/
        else {
            
            //  SIR 3596 - Call CIN81D to retrieve the NmPersonFull.  CSEC27
            // also retrieved NmPersonFull, but CSEC27 is not called if
            // the Invoice Type is Adoption Subsidy.  BSM
            
            //  Allocate memory for DAM Input and Output Structures
            pCINV81DInputRec = new CINV81DI();
            
            pCINV81DOutputRec = new CINV81DO();
            pCINV81DInputRec.setArchInputStruct(cfin29si.getArchInputStruct());
            pCINV81DInputRec.setUlIdPerson(cfin29si.getUlIdPerson());
            rc = cinv81dQUERYdam(sqlca, pCINV81DInputRec, pCINV81DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    cfin29so.setSzNmPersonFull(pCINV81DOutputRec.getSzNmPersonFull());
                    
                    //  Set RetVal to FND_SUCCESS
                    
                    RetVal = SUCCESS;
                    break;
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.SSM_FIN_INVALID_PRSN_ID;
                    rc = Messages.SSM_FIN_INVALID_PRSN_ID;
                    
                    //  SIR 3987 - Set RetVal to SSM_FIN_INVALID_PRSN_ID
                    
                    RetVal = Messages.SSM_FIN_INVALID_PRSN_ID;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        
        if (SUCCESS == RetVal) {
            // 
            // BEGIN: CSEC28D
            // 
            
            //  Allocate memory for DAM Input and Output Structures
            pCSEC28DInputRec = new CSEC28DI();
            
            pCSEC28DOutputRec = new CSEC28DO();
            pCSEC28DInputRec.setArchInputStruct(cfin29si.getArchInputStruct());
            pCSEC28DInputRec.setUlIdContract(cfin29si.getUlIdContract());
            pCSEC28DInputRec.setSzCdCncntyCounty(cfin29si.getSzCdSvcDtlCounty());
            pCSEC28DInputRec.setSzCdCnsvcService(cfin29si.getSzCdSvcDtlService());
            pCSEC28DInputRec.setUMoSvcDtlSvcMonth(cfin29si.getUMoSvcDtlSvcMonth());
            
            // 
            // Service Macro Definitions
            // 
            
            // 
            // Function Prototypes
            // 
            
            pCSEC28DInputRec.setUYrSvcDtlServiceYear(cfin29si.getUYrSvcDtlServiceYear());
            rc = csec28dQUERYdam(sqlca, pCSEC28DInputRec, pCSEC28DOutputRec);
            
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    cfin29so.setSzCdSvcDtlUnitType(pCSEC28DOutputRec.getSzNbrCnsvcUnitType());
                    cfin29so.setSzCdCnsvcPaymentType(pCSEC28DOutputRec.getSzCdCnsvcPaymentType());
                    cfin29so.setDAmtSvcDtlUnitRate(pCSEC28DOutputRec.getUlNbrCnsvcUnitRate());
                    cfin29so.setUsNbrSvcDtlCsli(pCSEC28DOutputRec.getUlNbrCnsvcLineItem());
                    cfin29so.setUlNbrCnverNoShowPct(pCSEC28DOutputRec.getUlNbrCnverNoShowPct());
                    break;
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.SSM_FIN_NO_UNIT_RATE;
                    rc = Messages.SSM_FIN_NO_UNIT_RATE;
                    
                    //  SIR 22316 - Set RetVal to SSM_FIN_NO_UNIT_RATE
                    
                    RetVal = Messages.SSM_FIN_NO_UNIT_RATE;
                    
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
        ARC_PRFServiceStopTime_TUX(cfin29si.getArchInputStruct() , cfin29so.getArchOutputStruct());
        if (RetVal == SUCCESS) {
            
            //  Call DAM
            rc = SUCCESS;
        }
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            //  Populate Input Structure for DAM
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
        return cfin29so;
    }

}
