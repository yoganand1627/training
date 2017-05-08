package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES08SO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES21DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES21DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES41DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES41DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES42DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES42DO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
/**************************************************************************
** 
** Module File:   CRES08S.src
**
** Service Name:  CRES08S
**
** Description:   This is an AUD service for a region wide service row that
**                modifies rows on the resource chrctr table.  First the 
**                characteristics data is AUDed to the passed row.  If the
**                row is not for a region wide service, the service returns.
**                If the row is for a region wide service the more processing
**                is necessary.  If the data
**                action is add, CRES42D is called in order to return all
**                of the resource service ID's from the resource service
**                table.  These ID's represent the ID's for each county
**                within the region.  Now CRES41D is called in order to
**                add characteristics to each of the county rows.  This
**                is necessary for search purposes.  If the data action code
**                is Update, CRES41D is called passing the new data and
**                the old characteristics data.  Since it is not possible
**                to have the id resource chrctr for the county rows, all
**                of the old data is used in order to act as the key to 
**                the table.  All of the county rows for the region will
**                be updated at the same time.  If the data action code is 
**                Delete, CRES41D is called passing the  old characteristics
**                data as the key similar to the Update case.  All of the 
**                characteristic rows will be deleted at the same time.    
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  07/27/95 
** 
** Programmer:    Jason W. Gloor
**
** Archive Information: $Revision:   1.4  $
**                      $Date:   08 Oct 1996 16:06:46  $
**                      $Modtime:   08 Oct 1996 16:01:00  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  07/15/96  DYARGR    SIR 21753 - Performance timers for 3 dams either
**                      missing or misplaced. Corrected this.
**  07/26/96   zabihin  sir 21891 : version control code was missing, I
**                       added the lines.
**  10/08/96  ODONNERJ  SIR #21795 - All Dates must be set to NULL_DATE after 
**      a structure containing an array has been memset to NULL
**      Remember this on YOUR NEXT PROJECT. WE HAVE HAD TO CLEAN
**      UP OVER A DOZEN SERVICES!!!!
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cres08s {
    CRES08SO CRES08S(CRES08SI cres08si) {
        CRES08SO cres08so = new CRES08SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        //## END TUX/XML: Declare XML variables 
        
        int rc = FND_SUCCESS;
        rc = ARC_PRFServiceStartTime_TUX(cres08si.getArchInputStruct());
        rc = CallCRES21D(cres08si, cres08so, pServiceStatus);
        switch (rc) {
                
            case WtcHelperConstants.ARC_SUCCESS:
                break;
            case Messages.MSG_CMN_UPDATE_FAILED:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
                
            case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(cres08si.getArchInputStruct() , cres08so.getArchOutputStruct());
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else {
            
            // if service code is a foster code
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
        return cres08so;
    }

    static int CallCRES21D(CRES08SI pInputMsg817, CRES08SO * pOutputMsg764, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = WtcHelperConstants.ARC_SUCCESS;
        int i410 = 0;
        int uCtr = 0;
        
        CRES21DI pCRES21DInputRec = null;
        CRES21DO pCRES21DOutputRec = null;
        CRES41DI pChrAddInputRec = null;/* Chrctr data to add */
        CRES41DO pChrAddOutputRec = null;
        CRES42DI pSvcRetrvInputRec = null;/* Input to get svc id's */
        CRES42DO pSvcRetrvOutputRec = null;/* Svc id output         */
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES21DInputRec = new CRES21DI();
        pCRES21DOutputRec = new CRES21DO();
        pChrAddInputRec = new CRES41DI();
        pChrAddOutputRec = new CRES41DO();
        pSvcRetrvInputRec = new CRES42DI();
        pSvcRetrvOutputRec = new CRES42DO();
        pCRES21DInputRec.getDtDtRsrcCharDateAdded().year = DateHelper.NULL_DATE;
        pCRES21DInputRec.getDtDtRsrcCharDateAdded().day = DateHelper.NULL_DATE;
        
        pCRES21DInputRec.getDtDtRsrcCharDateAdded().month = DateHelper.NULL_DATE;
        
        
        /*
        ** Insert the input message information into the dam for each
        ** row passed
        */
        for (i410 = 0;i410 < pInputMsg817.getUlRowQty();i410++) {
            pCRES21DInputRec.setUlIdResourceService(pInputMsg817.getUlIdResourceService());
            pCRES21DInputRec.setUlIdResourceChrctr(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getUlIdResourceChrctr());
            pCRES21DInputRec.setSzCdScrDataAction(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getSzCdScrDataAction());
            pCRES21DInputRec.setSzCdRsrcCharChrctr(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getSzCdRsrcCharChrctr());
            pCRES21DInputRec.setCCdRsrcCharSex(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getCCdRsrcCharSex());
            pCRES21DInputRec.setUNbrRsrcCharMinMAge(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getUNbrRsrcCharMinMAge());
            pCRES21DInputRec.setUNbrRsrcCharMaxMAge(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getUNbrRsrcCharMaxMAge());
            pCRES21DInputRec.setUNbrRsrcCharMinFAge(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getUNbrRsrcCharMinFAge());
            pCRES21DInputRec.setUNbrRsrcCharMaxFAge(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getUNbrRsrcCharMaxFAge());
            pCRES21DInputRec.setTsLastUpdate(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getTsLastUpdate());
            pCRES21DInputRec.setArchInputStruct(pInputMsg817.getArchInputStruct());
            pCRES21DInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getSzCdScrDataAction());
            
            
            //  Call CSYS06D
            rc = cres21dAUDdam(sqlca, pCRES21DInputRec, pCRES21DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                case WtcHelperConstants.SQL_SUCCESS:
                    
                    if (pInputMsg817.getSzCdRsrcCharRegion()[0] != null) {
                        
                        if (WtcHelperConstants.REQ_FUNC_CD_ADD == pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getSzCdScrDataAction()) {
                            pSvcRetrvInputRec.setUlIdResource(pInputMsg817.getUlIdResource());
                            pSvcRetrvInputRec.setSzCdRsrcCharService(pInputMsg817.getSzCdRsrcCharService());
                            pSvcRetrvInputRec.setSzCdRsrcCharRegion(pInputMsg817.getSzCdRsrcCharRegion());
                            pSvcRetrvInputRec.setArchInputStruct(pInputMsg817.getArchInputStruct());
                            pSvcRetrvInputRec.getArchInputStruct().setUlPageSizeNbr(CRES42DO._CRES42DO__ROWCRES42DO_SIZE);
                            pSvcRetrvInputRec.getArchInputStruct().setUsPageNbr(1);
                            
                            //  Set rc to ARC_SUCCESS
                            rc = cres42dQUERYdam(sqlca, pSvcRetrvInputRec, pSvcRetrvOutputRec);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            pChrAddInputRec.setSzCdRsrcCharChrctr(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getSzCdRsrcCharChrctr());
                            pChrAddInputRec.setCCdRsrcCharSex(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getCCdRsrcCharSex());
                            pChrAddInputRec.setUNbrRsrcCharMinMAge(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getUNbrRsrcCharMinMAge());
                            pChrAddInputRec.setUNbrRsrcCharMaxMAge(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getUNbrRsrcCharMaxMAge());
                            pChrAddInputRec.setUNbrRsrcCharMinFAge(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getUNbrRsrcCharMinFAge());
                            pChrAddInputRec.setUNbrRsrcCharMaxFAge(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getUNbrRsrcCharMaxFAge());
                            pChrAddInputRec.setArchInputStruct(pInputMsg817.getArchInputStruct());
                            
                            pChrAddInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getSzCdScrDataAction());
                            
                            //  Loop through each service id returned and add
                            // the necessary characteristics row to each service
                            // id
                            for (uCtr = 0;uCtr < pSvcRetrvOutputRec.getArchOutputStruct().getUlRowQty();uCtr++) {
                                pChrAddInputRec.setUlIdResourceService(pSvcRetrvOutputRec.getROWCRES42DO_ARRAY().getROWCRES42DO(uCtr).getUlIdResourceService());
                                
                                if (pChrAddInputRec.getUlIdResourceService() != pInputMsg817.getUlIdResourceService()) {
                                    
                                    //  Set rc to ARC_SUCCESS
                                    rc = cres41dAUDdam(sqlca, pChrAddInputRec, pChrAddOutputRec);
                                    
                                    
                                    //  Analyze return code
                                    switch (rc) {
                                            
                                        case WtcHelperConstants.SQL_SUCCESS:
                                            
                                            
                                            //  End of CCMN00D - Office Smp
                                            
                                            break;
                                        case WtcHelperConstants.SQL_DUPLICATE_KEY:
                                            pServiceStatus.severity = FND_SEVERITY_ERROR;
                                            pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                                            rc = Messages.MSG_CMN_UPDATE_FAILED;
                                            
                                            break;
                                            
                                        default :
                                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                                    }
                                }
                            }
                        }
                        
                        
                        
                        
                        
                        //  Otherwise, the data action code is update or delete
                        // In this case, modify or delete all rows where the 
                        // Id resource, service, region, and the old characteristics
                        // are the same.
                        else {
                            pChrAddInputRec.setSzCdRsrcCharChrctr(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getSzCdRsrcCharChrctr());
                            pChrAddInputRec.setCCdRsrcCharSex(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getCCdRsrcCharSex());
                            pChrAddInputRec.setUNbrRsrcCharMinMAge(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getUNbrRsrcCharMinMAge());
                            pChrAddInputRec.setUNbrRsrcCharMaxMAge(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getUNbrRsrcCharMaxMAge());
                            pChrAddInputRec.setUNbrRsrcCharMinFAge(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getUNbrRsrcCharMinFAge());
                            pChrAddInputRec.setUNbrRsrcCharMaxFAge(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getUNbrRsrcCharMaxFAge());
                            pChrAddInputRec.setSzScrCdRsrcCharChrOld(pInputMsg817.getROWCRES08SIG01_ARRAY().getROWCRES08SIG01(i410).getSzCdRsrcCharChrctr());
                            pChrAddInputRec.setUScrNbrRsrcCharMinMO(pInputMsg817.getROWCRES08SIG01_ARRAY().getROWCRES08SIG01(i410).getUNbrRsrcCharMinMAge());
                            pChrAddInputRec.setUScrNbrRsrcCharMaxMO(pInputMsg817.getROWCRES08SIG01_ARRAY().getROWCRES08SIG01(i410).getUNbrRsrcCharMaxMAge());
                            pChrAddInputRec.setUScrNbrRsrcCharMinFO(pInputMsg817.getROWCRES08SIG01_ARRAY().getROWCRES08SIG01(i410).getUNbrRsrcCharMinFAge());
                            pChrAddInputRec.setUScrNbrRsrcCharMaxFO(pInputMsg817.getROWCRES08SIG01_ARRAY().getROWCRES08SIG01(i410).getUNbrRsrcCharMaxFAge());
                            pChrAddInputRec.setUlIdResource(pInputMsg817.getUlIdResource());
                            
                            pChrAddInputRec.setSzCdRsrcCharService(pInputMsg817.getSzCdRsrcCharService());
                            pChrAddInputRec.setSzCdRsrcCharRegion(pInputMsg817.getSzCdRsrcCharRegion());
                            pChrAddInputRec.setArchInputStruct(pInputMsg817.getArchInputStruct());
                            pChrAddInputRec.getArchInputStruct().setCReqFuncCd(pInputMsg817.getROWCRES08SIG00_ARRAY().getROWCRES08SIG00(i410).getSzCdScrDataAction());
                            
                            //  Start performance timer for service
                            rc = cres41dAUDdam(sqlca, pChrAddInputRec, pChrAddOutputRec);
                            
                            //  Analyze return code
                            switch (rc) {
                                    
                                case WtcHelperConstants.SQL_SUCCESS:
                                    
                                    break;
                                    
                                default :
                                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            }
                        }
                    }
                    
                    //  End of CSES57D - Case File Management Rtrv
                    
                    break;
                case WtcHelperConstants.SQL_DUPLICATE_KEY:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_UPDATE_FAILED;
                    rc = Messages.MSG_CMN_UPDATE_FAILED;
                    
                    break;
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_SEVERITY_ERROR;
                    pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                    
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        return rc;
    }

}
