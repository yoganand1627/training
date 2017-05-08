package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB77SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB77SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN96DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN96DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNB0DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNB0DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
/**************************************************************************
** 
** Module File:    CSUB77S.src
**
** Service Name:   CSUB77S
**
** Description:   This service retrieves a person's current primary address
**                and phone number based on the person's id.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  January 8, 1996 
** 
** Programmer:    Belinda Muse
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 19:20:54  $
**                      $Modtime:   30 Mar 1996 00:28:08  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  02/12/96  DYARGR    Changed the dam calls to retrieve address and phone
**                      number. Dam being used would only retrieve information
**                      if both address and phone number existed. The dams
**                      to replace one will retrieve all the info from
**                      address or phone based on an IdPerson, but we have
**                      to loop through all the rows returned to find the 
**                      current primary for each.
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR 
**						to PROCESS_TUX_RC_ERROR_NOFREE after the 
**						ARC_UTLCheckServiceBatchBlock so that it doesn't free the 
**						input and output objects before they are allocated
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Csub77s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int INITIAL_PAGE = 1;
    public static final int ONE_ROW = 1;
    public static final int NULL_DATE = - 1;
    CSUB77SO CSUB77S(CSUB77SI csub77si) {
        CSUB77SO csub77so = new CSUB77SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_UTLCheckServiceBatchBlock("CSUB77S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        int i437 = 0;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        
        
        CCMN96DI pCCMN96DInputRec = null;
        CCMN96DO pCCMN96DOutputRec = null;
        
        CCMNB0DI pCCMNB0DInputRec = null;
        CCMNB0DO pCCMNB0DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(csub77si.getArchInputStruct());
        
        
        
        /*
        ** Initialize Service Status Fields 
        */
        
        
        
        /*
        ** Perform Main Processing
        */
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCCMN96DInputRec = new CCMN96DI();
        
        pCCMN96DOutputRec = new CCMN96DO();
        pCCMN96DInputRec.setArchInputStruct(csub77si.getArchInputStruct());
        pCCMN96DInputRec.setUlIdPerson(csub77si.getUlIdPerson());
        
        /*
        ** PWO # 1111 - removed STAGE and CASE timestamps
        */
        pCCMN96DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
        pCCMN96DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMN96DO._CCMN96DO__ROWCCMN96DO_SIZE);
        
        /*
        ** Call DAM
        */
        rc = ccmn96dQUERYdam(sqlca, pCCMN96DInputRec, pCCMN96DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                
                //  Populate Output Message
                
                //  Set fields in CSUB77SO to fields in CCMN96DO
                
                for (i437 = 0;i437 < pCCMN96DOutputRec.getArchOutputStruct().getUlRowQty();++i437) {
                    
                    if ((INDICATOR_YES == pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i437).getBIndPersAddrLinkPrimary()) && ((pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i437).getDtDtPersAddrLinkEnd().day == NULL_DATE) && (pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i437).getDtDtPersAddrLinkEnd().month == NULL_DATE) && (pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i437).getDtDtPersAddrLinkEnd().year == NULL_DATE))) {
                        csub77so.setSzAddrPersAddrStLn1(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i437).getSzAddrPersAddrStLn1());
                        csub77so.setSzAddrPersAddrStLn2(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i437).getSzAddrPersAddrStLn2());
                        csub77so.setSzTxtPersAddrCmnts(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i437).getSzTxtPersAddrCmnts());
                        
                        csub77so.setLAddrZip(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i437).getLAddrZip());
                        csub77so.setSzCdAddrCounty(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i437).getSzCdAddrCounty());
                        csub77so.setSzAddrCity(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i437).getSzAddrCity());
                        csub77so.setSzCdAddrState(pCCMN96DOutputRec.getROWCCMN96DO_ARRAY().getROWCCMN96DO(i437).getSzCdAddrState());
                    }
                    
                    
                }
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                //  If rc = SQL_SUCCESS,   ulIdStage will be > 0
                // If rc = SQL_NOT_FOUND, ulIdStage will be = 0
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        
        if (WtcHelperConstants.ARC_SUCCESS == rc) {
            //  Allocate memory for DAM Input and Output Structures
            pCCMNB0DInputRec = new CCMNB0DI();
            
            pCCMNB0DOutputRec = new CCMNB0DO();
            pCCMNB0DInputRec.setArchInputStruct(csub77si.getArchInputStruct());
            pCCMNB0DInputRec.setUlIdPerson(csub77si.getUlIdPerson());
            pCCMNB0DInputRec.getArchInputStruct().setUsPageNbr(INITIAL_PAGE);
            pCCMNB0DInputRec.getArchInputStruct().setUlPageSizeNbr(CCMNB0DO._CCMNB0DO__ROWCCMNB0DO_SIZE);
            rc = ccmnb0dQUERYdam(sqlca, pCCMNB0DInputRec, pCCMNB0DOutputRec);
            
            //  Analyze return code
            switch (rc) {
                    
                case WtcHelperConstants.SQL_SUCCESS:
                    pServiceStatus.severity = FND_SEVERITY_OK;
                    pServiceStatus.explan_code = SUCCESS;
                    
                    
                    
                    //  Populate Output Message
                    
                    //  Set fields in CSUB77SO to fields in CCMNB0DO
                    
                    for (i437 = 0;i437 < pCCMNB0DOutputRec.getArchOutputStruct().getUlRowQty();++i437) {
                        
                        if ((INDICATOR_YES == pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i437).getBIndPersonPhonePrimary()) && ((pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i437).getDtDtPersonPhoneEnd().day == DateHelper.ARC_MAX_DAY) && (pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i437).getDtDtPersonPhoneEnd().month == DateHelper.ARC_MAX_MONTH) && (pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i437).getDtDtPersonPhoneEnd().year == DateHelper.ARC_MAX_YEAR))) {
                            csub77so.setLNbrPhone(pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i437).getLNbrPhone());
                            csub77so.setLNbrPhoneExtension(pCCMNB0DOutputRec.getROWCCMNB0DO_ARRAY().getROWCCMNB0DO(i437).getLNbrPhoneExtension());
                        }
                    }
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
        }
        
        
        /*
        ** Load Translation Map
        */
        
        
        /*
        ** Stop Performance Timer
        */
        ARC_PRFServiceStopTime_TUX(csub77si.getArchInputStruct() , csub77so.getArchOutputStruct());
        
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
        return csub77so;
    }

}
