package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES32DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES32DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES33DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES33DO;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES10DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES10DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
/**************************************************************************
** 
** Module File:   CRES05S.src
**
** Service Name:  CRES05S
**
** Description:   This is the retrieval service for the Area Served window
**        in order to populate the Area Served list in the 
**        predisplay.  Rows will only be returned if the show
**        indicator is set to yes.  In addition, it will be
**        determined if the service is contracted and stored in
**        the contracted indicator for each row returned.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  4/26/95 
** 
** Programmer:    Jason W. Gloor
**
** Archive Information: $Revision:   1.0.1.1  $
**                      $Date:   06 Aug 1996 11:23:22  $
**                      $Modtime:   05 Aug 1996 16:49:22  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  -------------------------------------------------- 
**  4/26/96   MAXHAMKJ  SIR 20150: Changed CRES33D to an array fetch.
**                      Corresponding changes to CallCRES33D made.
**
**  08/02/96  ZABIHIN   SIR 21891 - Was missing versioning. Added the lines.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/* SIR 21891 - added the versioning line below */
/* 
** Extern for version control table
*/






public class Cres05s {
    CRES05SO CRES05S(CRES05SI cres05si) {
        CRES05SO cres05so = new CRES05SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int ulCtr = 0;/* Counter */
        int ulCtr1 = 0;/* Counter */
        int ulServiceRowsRtnd = 0;/* Temp service rows returned */
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##   short            rc      = FND_SUCCESS;
        
        /*
        ** Define a temporary input structure
        */
        CRES32DI CRES32DInputRec = null;
        CRES32DO CRES32DOutputRec = null;
        CRES33DI CRES33DInputRec = null;
        CRES33DO CRES33DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cres05si.getArchInputStruct());
        rc = CallCRES10D(cres05si, cres05so, pServiceStatus);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case Messages.MSG_NO_ROWS_RETURNED:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        
        /*
        ** Store the row quantity returned in a temp variable
        */
        ulServiceRowsRtnd = cres05so.getArchOutputStruct().getUlRowQty();
        
        /*
        ** for each row returned, check the contracted status
        */
        for (ulCtr1 = 0;ulCtr1 < ulServiceRowsRtnd;ulCtr1++) {
            
            if (cres05so.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(ulCtr1).getSzScrRsrcSvcCntyCode()[0] == null && (0 != cres05so.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(ulCtr1).getSzCdRsrcSvcRegion().compareTo(CAPS_UNIT_STATE_OFFICE)) && (0 != cres05so.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(ulCtr1).getSzCdRsrcSvcRegion().compareTo(CAPS_UNIT_SWI)) && (0 == cres05so.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(ulCtr1).getSzCdRsrcSvcState().compareTo(CAPS_DEFAULT_STATE_CD))) {
                CRES32DInputRec.setSzCdRsrcSvcRegion(cres05so.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(ulCtr1).getSzCdRsrcSvcRegion());
                CRES32DInputRec.setArchInputStruct(cres05si.getArchInputStruct());
                CRES32DInputRec.getArchInputStruct().setUlPageSizeNbr(CRES32DO._CRES32DO__ROWCRES32DO_SIZE);
                CRES32DInputRec.getArchInputStruct().setUsPageNbr(1);
                rc = Cres06s.CallCRES32D(CRES32DInputRec, CRES32DOutputRec, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                CRES33DInputRec.setUlIdResource(cres05si.getUlIdResource());
                CRES33DInputRec.setSzCdRsrcSvcService(cres05so.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(ulCtr1).getSzCdRsrcSvcService());
                cres05so.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(ulCtr1).setCScrIndRsrcContracted(Cint14s.INDICATOR_NO);
                
                for (ulCtr = 0;ulCtr < CRES32DOutputRec.getArchOutputStruct().getUlRowQty();ulCtr++) {
                    CRES33DInputRec.setSzCdRsrcSvcCnty(CRES32DOutputRec.getROWCRES32DO_ARRAY().getROWCRES32DO(ulCtr).getSzScrRsrcSvcCntyCode());
                    
                    //  Call DAM
                    rc = CallCRES33D(CRES33DInputRec, CRES33DOutputRec, pServiceStatus);
                    Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                    cres05so.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(ulCtr1).setCScrIndRsrcContracted(CRES33DOutputRec.getCScrIndRsrcContracted());
                    if (INDICATOR_YES == CRES33DOutputRec.getCScrIndRsrcContracted()) {
                        break;
                    }
                }
            }
            
            
            //  Handle case if State is not TX or
            // Region is Statewide Intake or
            // Region is State Ofice
            else if ((0 == cres05so.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(ulCtr1).getSzCdRsrcSvcRegion().compareTo(CAPS_UNIT_STATE_OFFICE)) || (0 == cres05so.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(ulCtr1).getSzCdRsrcSvcRegion().compareTo(CAPS_UNIT_SWI)) || (0 != cres05so.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(ulCtr1).getSzCdRsrcSvcState().compareTo(CAPS_DEFAULT_STATE_CD))) {
                cres05so.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(ulCtr1).setCScrIndRsrcContracted(Cint14s.INDICATOR_NO);
            }
            
            //  Handle regular Region/County row
            else {
                CRES33DInputRec.setUlIdResource(cres05si.getUlIdResource());
                CRES33DInputRec.setSzCdRsrcSvcService(cres05so.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(ulCtr1).getSzCdRsrcSvcService());
                CRES33DInputRec.setSzCdRsrcSvcCnty(cres05so.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(ulCtr1).getSzScrRsrcSvcCntyCode());
                rc = CallCRES33D(CRES33DInputRec, CRES33DOutputRec, pServiceStatus);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                cres05so.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(ulCtr1).setCScrIndRsrcContracted(CRES33DOutputRec.getCScrIndRsrcContracted());
            }
        }
        cres05so.getArchOutputStruct().setUlRowQty(ulServiceRowsRtnd);
        
        /* Setup for service function exit */
        
        
        ARC_PRFServiceStopTime_TUX(cres05si.getArchInputStruct() , cres05so.getArchOutputStruct());
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
        return cres05so;
    }

    
    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;
        pOutputMsgTransMap.map_name = CRES05S_XLT_OUT;
        pOutputMsgTransMap.map_version = WtcHelperConstants.MAP_VERSION;
        
        /*
        ** Stop performance timer for service 
        */
        
        ARC_PRFServiceStopTime_TUX(Csys08s.pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        return SUCCESS;
    }

    static int CallCRES10D(CRES05SI pInputMsg815, CRES05SO pOutputMsg760, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i405 = 0;
        
        /*
        ** Declare local variables
        */
        CRES10DI pCRES10DInputRec = null;
        CRES10DO pCRES10DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES10DInputRec = new CRES10DI();
        pCRES10DOutputRec = new CRES10DO();
        pCRES10DInputRec.setUlIdResource(pInputMsg815.getUlIdResource());
        pCRES10DInputRec.setArchInputStruct(pInputMsg815.getArchInputStruct());
        rc = cres10dQUERYdam(sqlca, pCRES10DInputRec, pCRES10DOutputRec);
        if (rc != 0) {
            switch (rc) {
                case NO_DATA_FOUND:
                    pServiceStatus.severity = SUCCESS;
                    pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                    rc = Messages.MSG_NO_ROWS_RETURNED;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            
            //  Populate Output Message
            for (i405 = 0;i405 < pCRES10DOutputRec.getArchOutputStruct().getUlRowQty();++i405) {
                pOutputMsg760.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(i405).setUlIdResourceService(pCRES10DOutputRec.getROWCRES10DO_ARRAY().getROWCRES10DO(i405).getUlIdResourceService());
                pOutputMsg760.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(i405).setTsLastUpdate(pCRES10DOutputRec.getROWCRES10DO_ARRAY().getROWCRES10DO(i405).getTsLastUpdate());
                pOutputMsg760.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(i405).setCIndRsrcSvcShowRow(pCRES10DOutputRec.getROWCRES10DO_ARRAY().getROWCRES10DO(i405).getCIndRsrcSvcShowRow());
                pOutputMsg760.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(i405).setSzScrRsrcSvcCntyCode(pCRES10DOutputRec.getROWCRES10DO_ARRAY().getROWCRES10DO(i405).getSzScrRsrcSvcCntyCode());
                pOutputMsg760.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(i405).setSzCdRsrcSvcProgram(pCRES10DOutputRec.getROWCRES10DO_ARRAY().getROWCRES10DO(i405).getSzCdRsrcSvcProgram());
                pOutputMsg760.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(i405).setSzCdRsrcSvcRegion(pCRES10DOutputRec.getROWCRES10DO_ARRAY().getROWCRES10DO(i405).getSzCdRsrcSvcRegion());
                pOutputMsg760.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(i405).setSzCdRsrcSvcCategRsrc(pCRES10DOutputRec.getROWCRES10DO_ARRAY().getROWCRES10DO(i405).getSzCdRsrcSvcCategRsrc());
                pOutputMsg760.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(i405).setSzCdRsrcSvcService(pCRES10DOutputRec.getROWCRES10DO_ARRAY().getROWCRES10DO(i405).getSzCdRsrcSvcService());
                pOutputMsg760.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(i405).setSzCdRsrcSvcState(pCRES10DOutputRec.getROWCRES10DO_ARRAY().getROWCRES10DO(i405).getSzCdRsrcSvcState());
                pOutputMsg760.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(i405).setBIndRsrcSvcCntyPartial(pCRES10DOutputRec.getROWCRES10DO_ARRAY().getROWCRES10DO(i405).getBIndRsrcSvcCntyPartial());
                pOutputMsg760.getROWCRES05SOG00_ARRAY().getROWCRES05SOG00(i405).setCIndRsrcSvcIncomeBsed(pCRES10DOutputRec.getROWCRES10DO_ARRAY().getROWCRES10DO(i405).getCIndRsrcSvcIncomeBsed());
            };
            pOutputMsg760.getArchOutputStruct().setUlRowQty(pCRES10DOutputRec.getArchOutputStruct().getUlRowQty());
            pOutputMsg760.getArchOutputStruct().setBMoreDataInd(pCRES10DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return rc;
    }

    static int CallCRES32D(CRES32DI pCRES32DInputMsg, CRES32DO pCRES32DOutputMsg, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        //## END TUX/XML: Declare XML variables 
        
        int rc = 0;
        int i406 = 0;
        
        /*
        ** Declare local variables
        */
        CRES32DI pCRES32DInputRec = null;
        CRES32DO pCRES32DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES32DInputRec = new CRES32DI();
        pCRES32DOutputRec = new CRES32DO();
        pCRES32DInputRec.setSzCdRsrcSvcRegion(pCRES32DInputMsg.getSzCdRsrcSvcRegion());
        pCRES32DInputRec.setArchInputStruct(pCRES32DInputMsg.getArchInputStruct());
        rc = cres32dQUERYdam(sqlca, pCRES32DInputRec, pCRES32DOutputRec);
        
        /*
        ** Analyze error code
        */
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i406 = 0;i406 < pCRES32DOutputRec.getArchOutputStruct().getUlRowQty();++i406) {
                    pCRES32DOutputMsg.getROWCRES32DO_ARRAY().getROWCRES32DO(i406).setSzScrRsrcSvcCntyCode(pCRES32DOutputRec.getROWCRES32DO_ARRAY().getROWCRES32DO(i406).getSzScrRsrcSvcCntyCode());
                    //## END TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo
                    
                    
                    
                };
                pCRES32DOutputMsg.getArchOutputStruct().setUlRowQty(pCRES32DOutputRec.getArchOutputStruct().getUlRowQty());
                pCRES32DOutputMsg.getArchOutputStruct().setBMoreDataInd(pCRES32DOutputRec.getArchOutputStruct().getBMoreDataInd());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCRES33D(CRES33DI pCRES33DInputMsg, CRES33DO pCRES33DOutputMsg, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /* 
        ** Declare local variables
        */
        CRES33DI pCRES33DInputRec = null;
        CRES33DO pCRES33DOutputRec = null;
        int f = 0;/* SIR 20150 */
        FndInt3date dtSystemDate = null;
        FndInt3date dtContractEndDate = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES33DInputRec = new CRES33DI();
        
        
        pCRES33DOutputRec = new CRES33DO();
        pCRES33DInputRec.setArchInputStruct(pCRES33DInputMsg.getArchInputStruct());
        pCRES33DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCRES33DInputRec.getArchInputStruct().setUlPageSizeNbr(CRES33DO._CRES33DO__ROWCRES33DO_SIZE);
        pCRES33DInputRec.setUlIdResource(pCRES33DInputMsg.getUlIdResource());
        pCRES33DInputRec.setSzCdRsrcSvcService(pCRES33DInputMsg.getSzCdRsrcSvcService());
        pCRES33DInputRec.setSzCdRsrcSvcCnty(pCRES33DInputMsg.getSzCdRsrcSvcCnty());
        rc = cres33dQUERYdam(sqlca, pCRES33DInputRec, pCRES33DOutputRec);
        
        switch (rc) {
                
                
            case WtcHelperConstants.SQL_SUCCESS:
                rc = ARC_UTLGetDateAndTime(dtSystemDate, 0);
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                //  SIR 20150: If multiple versions of a contract exist,
                // then this DAM will return several rows for a given
                // service/county/resource combination.  In this case, you
                // have to check all the returned end dates to see if there's an
                // active contract. Previously only one date was checked, 
                // so the contracted indicator would incorrectly appear as 'N'.
                
                for (f = 0;f < pCRES33DOutputRec.getArchOutputStruct().getUlRowQty();f++) {
                    
                    //  Populate a date for the compare date function
                    dtContractEndDate = pCRES33DOutputRec.getROWCRES33DO_ARRAY().getROWCRES33DO(f).getDtDtCncntyEnd();
                    
                    
                    //  CINT21D will only be called if the previous DAM call completed 
                    // successfully.  CINT21D will retrieve an entire row from the 
                    // stage table.  Only those cols that are of interest to CINT03W 
                    // will be copied to the service output message.
                    if ((DateHelper.NULL_DATE == dtContractEndDate.day) || (DateHelper.NULL_DATE == dtContractEndDate.month) || (DateHelper.NULL_DATE == dtContractEndDate.year)) {
                        pCRES33DOutputMsg.setCScrIndRsrcContracted(INDICATOR_YES);
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        break;
                    }
                    
                    
                    //  Compare the current system date with the contract end
                    // date.  The return code will be negative if the system
                    // date is before the end date.  In this case, the contract
                    // will be active.  If the the return code is zero the 
                    // system date will be equal to the contract date.  In this
                    // case, the contract will still be active.  If the return code
                    // is positive, the system date will be after the contract
                    // end date and the contract will not be active.
                    else {
                        rc = ARC_UTLCompareDateAndTime(dtSystemDate, 0, dtContractEndDate, 0);
                        
                        
                        //  Retrieve determination factors and descriptors.
                        if ((0 > rc) || (0 == rc)) {
                            pCRES33DOutputMsg.setCScrIndRsrcContracted(INDICATOR_YES);
                            rc = WtcHelperConstants.ARC_SUCCESS;
                            break;
                        }
                        
                        else {
                            
                            pCRES33DOutputMsg.setCScrIndRsrcContracted(Cint14s.INDICATOR_NO);
                            rc = WtcHelperConstants.ARC_SUCCESS;
                        }
                    }
                }
                break;
            case NO_DATA_FOUND:
                pCRES33DOutputMsg.setCScrIndRsrcContracted(Cint14s.INDICATOR_NO);
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
