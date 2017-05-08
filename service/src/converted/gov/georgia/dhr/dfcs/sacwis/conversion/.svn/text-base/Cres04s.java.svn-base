package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES04SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES16DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES16DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES25DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES25DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CAUDC6DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CAUDC6DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES26DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES26DO;
/**************************************************************************
**
** Module File:   cres04s.src
**
** Service Name:  Resource Detail AUD
**
** Description:   Formats input record and updates the Phone, Address,
**          CAPS Resource and Category tables. If the Resource
**          is of type hotline, then no address records are
**          required.  Therefore, the address input message is
**          checked for records, and if none exist and type is
**          hotline, the Address Table DAM is not called.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  9 May 1995
**
** Programmer:    Kymberly Maxham
**
** Archive Information: $Revision:   1.2  $
**                      $Date:   13 Jul 1998 14:03:16  $
**                      $Modtime:   12 Jul 1998 16:25:06  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  07/20/95  JWG   Modified records,record groups and relevent code.
**  11/7/95   KJM   SIR 1897: added back HUB field
**  12/12/95  KJM   SIR 2284: added error handling for Oracle code
**            6510.  If user tries to modify/delete VID for
**            contracted resource record, this code comes back.
**  04/02/97  CEG   SIR 13618/MHMR Enhancement - copy MHMR component code from
**                  the service input msg to CRES16D input rec.
**  07/01/98  GMS   FINANCIAL ENHANCEMENT--Inserting a DAM call to this service
**            so when a change is made to the vendor ID.  CAUDC6D.PC will be
**            able to update all the invoices that are still pending for the
**            vendor with the correct vendor id.
**  03/26/04  LGR   SIR 22639 - add data element CAPS_RESOURCE.LEGAL_NAME
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cres04s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    
    public static final int ADDR_INDEX = 0;
    /* Index values corresponding to       */
    public static final int PHONE_INDEX = 1;
    CRES04SO CRES04S(CRES04SI cres04si) {
        CRES04SO cres04so = new CRES04SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        
        rc = ARC_PRFServiceStartTime_TUX(cres04si.getArchInputStruct());
        
        /*
        ** Call CAUD08D The Contract County AUD performs a full row insert,
        ** update or delete to the Contract County table.
        */
        rc = CallCRES16D(cres04si, cres04so, pServiceStatus);
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                break;
            case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                
                
                break;
            case Messages.MSG_CMN_UPDATE_FAILED:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        userlog("pOutput->ulIdResource is %d \n", cres04so.getUlIdResource());
        
        userlog("pInputMsg->ulIdResource is %d \n", cres04si.getUlIdResource());
        rc = CallCRES25D(cres04si, cres04so, pServiceStatus);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                break;
            case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
            case Messages.MSG_CMN_UPDATE_FAILED:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                
                break;
            case Messages.MSG_RSRC_CONTRACTED_NO_VID:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        userlog("pOutputMsg->ulIdResource is %d \n", cres04so.getUlIdResource());
        rc = CallCRES26D(cres04si, cres04so, pServiceStatus);
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                
                break;
            case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                break;
            case Messages.MSG_CMN_UPDATE_FAILED:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                
                
        }
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cres04si.getArchInputStruct() , cres04so.getArchOutputStruct());
        
        
        
        /*
        ** Perform edits for APF - Investigation
        ** Stage for a facility
        */
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            //  Set variables and calculate retention
            // date
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                //  Call CAUD01D
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cres04so;
    }

    static int CallCRES16D(CRES04SI pInputMsg812, CRES04SO pOutputMsg757, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;
        
        /*
        ** Declare local variables
        */
        CRES16DI pCRES16DInputRec = null;
        CRES16DO pCRES16DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES16DInputRec = new CRES16DI();
        pCRES16DOutputRec = new CRES16DO();
        pCRES16DInputRec.setSzCdRsrcType(pInputMsg812.getSzCdRsrcType());
        pCRES16DInputRec.setSzCdRsrcMaintainer(pInputMsg812.getSzCdRsrcMaintainer());
        pCRES16DInputRec.setSzCdRsrcOwnership(pInputMsg812.getSzCdRsrcOwnership());
        pCRES16DInputRec.setSzCdRsrcStatus(pInputMsg812.getSzCdRsrcStatus());
        pCRES16DInputRec.setSzNmResource(pInputMsg812.getSzNmResource());
        pCRES16DInputRec.setSzNmRsrcContact(pInputMsg812.getSzNmRsrcContact());
        pCRES16DInputRec.setSzNmRsrcLastUpdate(pInputMsg812.getSzNmRsrcLastUpdate());
        pCRES16DInputRec.setSzTxtRsrcComments(pInputMsg812.getSzTxtRsrcComments());
        pCRES16DInputRec.setTsLastUpdate(pInputMsg812.getTsLastUpdate());
        String elementValue = (pCRES16DInputRec.getTsLastUpdate());
        userlog("pCRES16DInputRec->tsLastUpdate is %02u%02u-%02u-%02uT%02u:%02u:%02u-05:00", (char) (int) elementValue.charAt(0) - 100, (char) (int) elementValue.charAt(1) - 100, (char) elementValue.charAt(2) , (char) elementValue.charAt(3) , (char) elementValue.charAt(4) , (char) elementValue.charAt(5) , (char) elementValue.charAt(6));
        pCRES16DInputRec.setUlIdResource(pInputMsg812.getUlIdResource());
        pCRES16DInputRec.setCIndRsrcTransport(pInputMsg812.getCIndRsrcTransport());
        pCRES16DInputRec.setSzCdRsrcCampusType(pInputMsg812.getSzCdRsrcCampusType());
        pCRES16DInputRec.setSzCdRsrcFacilType(pInputMsg812.getSzCdRsrcFacilType());
        pCRES16DInputRec.setLNbrSchCampusNbr(pInputMsg812.getLNbrSchCampusNbr());
        pCRES16DInputRec.setLNbrRsrcFacilAcclaim(pInputMsg812.getLNbrRsrcFacilAcclaim());
        pCRES16DInputRec.setSzCdRsrcHub(pInputMsg812.getSzCdRsrcHub());
        pCRES16DInputRec.setSzCdMhmrCompCode(pInputMsg812.getSzCdMhmrCompCode());
        pCRES16DInputRec.setSzNmLegal(pInputMsg812.getSzNmLegal());
        pCRES16DInputRec.setArchInputStruct(pInputMsg812.getArchInputStruct());
        rc = cres16dAUDdam(sqlca, pCRES16DInputRec, pCRES16DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                if (!(pInputMsg812.getUlIdResource() != 0)) {
                    pInputMsg812.setUlIdResource(pCRES16DOutputRec.getUlIdResource());
                    pOutputMsg757.setUlIdResource(pCRES16DOutputRec.getUlIdResource());
                }
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                
                //  Call DAM
                rc = Messages.MSG_CMN_UPDATE_FAILED;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCRES25D(CRES04SI pInputMsg813, CRES04SO * pOutputMsg758, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;/* Return code */
        
        /*
        ** Declare local variables
        */
        CRES25DI pCRES25DInputRec = null;
        CRES25DO pCRES25DOutputRec = null;
        CAUDC6DI pCAUDC6DInputRec = null;
        CAUDC6DO pCAUDC6DOutputRec = null;
        int i403 = 0;
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES25DInputRec = new CRES25DI();
        pCRES25DOutputRec = new CRES25DO();
        pCRES25DInputRec.setArchInputStruct(pInputMsg813.getArchInputStruct());
        
        for (i403 = 0;i403 < pInputMsg813.getUlPageSizeNbr_ARRAY().getUlPageSizeNbr(ADDR_INDEX);i403++) {
            pCRES25DInputRec.setSzAddrRsrcAddrAttn(pInputMsg813.getROWCRES04SIG00_ARRAY().getROWCRES04SIG00(i403).getSzAddrRsrcAddrAttn());
            pCRES25DInputRec.setSzAddrRsrcAddrCity(pInputMsg813.getROWCRES04SIG00_ARRAY().getROWCRES04SIG00(i403).getSzAddrRsrcAddrCity());
            pCRES25DInputRec.setSzAddrRsrcAddrStLn1(pInputMsg813.getROWCRES04SIG00_ARRAY().getROWCRES04SIG00(i403).getSzAddrRsrcAddrStLn1());
            pCRES25DInputRec.setSzAddrRsrcAddrStLn2(pInputMsg813.getROWCRES04SIG00_ARRAY().getROWCRES04SIG00(i403).getSzAddrRsrcAddrStLn2());
            pCRES25DInputRec.setSzAddrRsrcAddrZip(pInputMsg813.getROWCRES04SIG00_ARRAY().getROWCRES04SIG00(i403).getSzAddrRsrcAddrZip());
            pCRES25DInputRec.setSzCdFacilityCounty(pInputMsg813.getROWCRES04SIG00_ARRAY().getROWCRES04SIG00(i403).getSzAddrRsrcAddrCounty());
            pCRES25DInputRec.setSzCdRsrcAddrSchDist(pInputMsg813.getROWCRES04SIG00_ARRAY().getROWCRES04SIG00(i403).getSzCdRsrcAddrSchDist());
            pCRES25DInputRec.setSzCdFacilityState(pInputMsg813.getROWCRES04SIG00_ARRAY().getROWCRES04SIG00(i403).getSzCdFacilityState());
            pCRES25DInputRec.setSzCdRsrcAddrType(pInputMsg813.getROWCRES04SIG00_ARRAY().getROWCRES04SIG00(i403).getSzCdRsrcAddrType());
            pCRES25DInputRec.setSzTxtRsrcAddrComments(pInputMsg813.getROWCRES04SIG00_ARRAY().getROWCRES04SIG00(i403).getSzTxtRsrcAddrComments());
            pCRES25DInputRec.setSzNbrRsrcAddrVid(pInputMsg813.getROWCRES04SIG00_ARRAY().getROWCRES04SIG00(i403).getSzNbrRsrcAddrVid());
            pCRES25DInputRec.setUlIdResource(pInputMsg813.getUlIdResource());
            pCRES25DInputRec.setUlIdRsrcAddress(pInputMsg813.getROWCRES04SIG00_ARRAY().getROWCRES04SIG00(i403).getUlIdRsrcAddress());
            pCRES25DInputRec.setTsLastUpdate(pInputMsg813.getROWCRES04SIG00_ARRAY().getROWCRES04SIG00(i403).getTsLastUpdate());
            pCRES25DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg813.getROWCRES04SIG00_ARRAY().getROWCRES04SIG00(i403).getSzCdScrDataAction());
            
            rc = cres25dAUDdam(sqlca, pCRES25DInputRec, pCRES25DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    userlog("success in cres25d");
                    switch (pInputMsg813.getROWCRES04SIG00_ARRAY().getROWCRES04SIG00(i403).getSzCdScrDataAction()) {
                            
                        case WtcHelperConstants.REQ_FUNC_CD_UPDATE:
                            
                            pCAUDC6DInputRec = new CAUDC6DI();
                            pCAUDC6DOutputRec = new CAUDC6DO();
                            pCAUDC6DInputRec.setArchInputStruct(pInputMsg813.getArchInputStruct());
                            pCAUDC6DInputRec.setSzNbrRsrcAddrVid(pCRES25DInputRec.getSzNbrRsrcAddrVid());
                            pCAUDC6DInputRec.setUlIdRsrcAddress(pCRES25DInputRec.getUlIdRsrcAddress());
                            pCAUDC6DInputRec.getArchInputStruct().setCReqFuncCd(pCRES25DInputRec.getArchInputStruct().getCReqFuncCd());
                            rc = caudc6dAUDdam(sqlca, pCAUDC6DInputRec, pCAUDC6DOutputRec);
                            
                            //  Analyze return code
                            switch (rc) {
                                    
                                    //SIR:17091 Srini: Added the error handling to take care of full table scans.
                                case WtcHelperConstants.SQL_SUCCESS:
                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                    
                                    break;
                                case NO_DATA_FOUND:
                                    rc = WtcHelperConstants.ARC_SUCCESS;
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            }
                            
                        default :
                            break;
                    }
                    break;
                    //SIR:17091 Srini: Added the error handling to take care of full table scans.
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                    rc = Messages.MSG_CMN_UPDATE_FAILED;
                    break;
                    
                    //SIR:17091 Srini: Added the error handling to take care of full table scans.
                case - 6510:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_RSRC_CONTRACTED_NO_VID;
                    rc = Messages.MSG_RSRC_CONTRACTED_NO_VID;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

    static int CallCRES26D(CRES04SI pInputMsg814, CRES04SO * pOutputMsg759, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;
        
        /*
        ** Declare local variables
        */
        CRES26DI pCRES26DInputRec = null;
        CRES26DO pCRES26DOutputRec = null;
        int i404 = 0;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES26DInputRec = new CRES26DI();
        pCRES26DOutputRec = new CRES26DO();
        pCRES26DInputRec.setArchInputStruct(pInputMsg814.getArchInputStruct());
        
        for (i404 = 0;i404 < pInputMsg814.getUlPageSizeNbr_ARRAY().getUlPageSizeNbr(PHONE_INDEX);i404++) {
            pCRES26DInputRec.setUlIdRsrcPhone(pInputMsg814.getROWCRES04SIG01_ARRAY().getROWCRES04SIG01(i404).getUlIdRsrcPhone());
            pCRES26DInputRec.setSzCdFacilPhoneType(pInputMsg814.getROWCRES04SIG01_ARRAY().getROWCRES04SIG01(i404).getSzCdFacilPhoneType());
            pCRES26DInputRec.setSzTxtRsrcPhoneComments(pInputMsg814.getROWCRES04SIG01_ARRAY().getROWCRES04SIG01(i404).getSzTxtRsrcPhoneComments());
            pCRES26DInputRec.setLNbrFacilPhoneNumber(pInputMsg814.getROWCRES04SIG01_ARRAY().getROWCRES04SIG01(i404).getLNbrFacilPhoneNumber());
            pCRES26DInputRec.setLNbrFacilPhoneExtension(pInputMsg814.getROWCRES04SIG01_ARRAY().getROWCRES04SIG01(i404).getLNbrFacilPhoneExtension());
            pCRES26DInputRec.setUlIdResource(pInputMsg814.getUlIdResource());
            pCRES26DInputRec.setTsLastUpdate(pInputMsg814.getROWCRES04SIG01_ARRAY().getROWCRES04SIG01(i404).getTsLastUpdate());
            pCRES26DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg814.getROWCRES04SIG01_ARRAY().getROWCRES04SIG01(i404).getSzCdScrDataAction());
            rc = cres26dAUDdam(sqlca, pCRES26DInputRec, pCRES26DOutputRec);
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    rc = WtcHelperConstants.ARC_SUCCESS;
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    break;
                    
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                    //  Do nothing, the output message just returns success or
                    // failure.
                    rc = Messages.MSG_CMN_UPDATE_FAILED;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                    break;
            }
        }
        return rc;
    }

}
