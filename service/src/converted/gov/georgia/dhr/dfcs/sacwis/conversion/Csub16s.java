package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB16SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN45DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES15DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES15DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
**
** Module File:    CSUB16S.src
**
** Service Name:   CSUB16S
**
** Description:   This service will retrieve an event row using the Event ID
**      as the key.  It will also retrieve a row from the Level of
**        Care table using the Event ID as the key.  This information
**       will be used to populate the Level of Care window.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  9/27/95
**
** Programmer:    Stephen Helmke
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 19:14:58  $
**                      $Modtime:   28 Mar 1996 23:21:52  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**
**  06/23/03  Srini     SIR 18479 - Changed the error handler PROCESS_TUX_RC_ERROR
**						to PROCESS_TUX_RC_ERROR_NOFREE after the
**						ARC_UTLCheckServiceBatchBlock so that it doesn't free the
**						input and output objects before they are allocated
**  12/30/04  CORLEYAN  TPR Enhancement - Retrieve additional fields from the
**                      DB for display on the Person LOC page.
**  02/08/05  CORLEYAN  SIR 23401 - Retrieve the name of the person who last
**                      updated the record.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Csub16s {
    
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int EVENT = 0;
    public static final int LOC = 1;
    
    /*
    ** Declare FOUNDATION variables 
    */
    public static final String STATUS_NEW = "NEW";
    CSUB16SO CSUB16S(CSUB16SI csub16si) {
        CSUB16SO csub16so = new CSUB16SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        
        /*
        ** Call architecture function to retreive the current date.
        */
        rc = ARC_UTLCheckServiceBatchBlock("CSUB16S", pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR_NOFREE();
        int i422 = 0;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        
        CCMN45DI pCCMN45DInputRec = null;
        CCMN45DO pCCMN45DOutputRec = null;
        
        CSES15DI pCSES15DInputRec = null;
        CSES15DO pCSES15DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(csub16si.getArchInputStruct());
        rc = ARC_UTLGetDateAndTime(csub16so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCCMN45DInputRec = new CCMN45DI();
        
        pCCMN45DOutputRec = new CCMN45DO();
        pCCMN45DInputRec.setArchInputStruct(csub16si.getArchInputStruct());
        pCCMN45DInputRec.setUlIdEvent(csub16si.getUlIdEvent());
        rc = ccmn45dQUERYdam(sqlca, pCCMN45DInputRec, pCCMN45DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                csub16so.setSzCdEventStatus(pCCMN45DOutputRec.getROWCCMN45DO().getSzCdEventStatus());
                csub16so.setUlIdEventPerson(pCCMN45DOutputRec.getROWCCMN45DO().getUlIdPerson());
                csub16so.getTsLastUpdate_ARRAY().setTsLastUpdate(EVENT, pCCMN45DOutputRec.getROWCCMN45DO().getTsLastUpdate());
                
                if (0 != STATUS_NEW.compareTo(csub16so.getSzCdEventStatus())) {
                    //  Call CSES15DO to retrieve the row on the Level of Care table
                    // with the passed in IdEvent
                    
                    //  Allocate memory for DAM Input and Output Structures
                    pCSES15DInputRec = new CSES15DI();
                    
                    pCSES15DOutputRec = new CSES15DO();
                    pCSES15DInputRec.setArchInputStruct(csub16si.getArchInputStruct());
                    pCSES15DInputRec.setUlIdPlocEvent(csub16si.getUlIdEvent());
                    rc = cses15dQUERYdam(sqlca, pCSES15DInputRec, pCSES15DOutputRec);
                    
                    //  Analyze return code
                    switch (rc) {
                        case WtcHelperConstants.SQL_SUCCESS:
                            pServiceStatus.severity = FND_SEVERITY_OK;
                            pServiceStatus.explan_code = SUCCESS;
                            csub16so.getTsLastUpdate_ARRAY().setTsLastUpdate(LOC, pCSES15DOutputRec.getTsLastUpdate());
                            csub16so.setSzCdPlocChild(pCSES15DOutputRec.getSzCdPlocChild());
                            csub16so.setSzCdPlocType(pCSES15DOutputRec.getSzCdPlocType());
                            csub16so.setUlIdPerson(pCSES15DOutputRec.getUlIdPerson());
                            csub16so.setDtDtPlocEnd(pCSES15DOutputRec.getDtDtPlocEnd());
                            csub16so.setDtDtPlocStart(pCSES15DOutputRec.getDtDtPlocStart());
                            csub16so.setSzTxtComments(pCSES15DOutputRec.getSzTxtComments());
                            
                            csub16so.setDtDtSubTpr(pCSES15DOutputRec.getDtDtSubTpr());
                            
                            csub16so.setDtDtRevCmplt(pCSES15DOutputRec.getDtDtRevCmplt());
                            csub16so.setSzNmTprCons(pCSES15DOutputRec.getSzNmTprCons());
                            csub16so.setDtDtRevCondct(pCSES15DOutputRec.getDtDtRevCondct());
                            
                            csub16so.setSzCdLvlChg(pCSES15DOutputRec.getSzCdLvlChg());
                            
                            csub16so.setSzCdPlcmtSetting(pCSES15DOutputRec.getSzCdPlcmtSetting());
                            
                            csub16so.setSzCdRevType(pCSES15DOutputRec.getSzCdRevType());
                            
                            csub16so.getCSUB16SOG00().getSzTxtPlcmtRec_ARRAY().setSzTxtPlcmtRec(0, pCSES15DOutputRec.getSzTxtPlcmtRec1());
                            
                            csub16so.getCSUB16SOG00().getSzTxtPlcmtRec_ARRAY().setSzTxtPlcmtRec(1, pCSES15DOutputRec.getSzTxtPlcmtRec2());
                            
                            csub16so.getCSUB16SOG00().getSzTxtPlcmtRec_ARRAY().setSzTxtPlcmtRec(2, pCSES15DOutputRec.getSzTxtPlcmtRec3());
                            csub16so.getCSUB16SOG00().getSzTxtPlcmtRec_ARRAY().setSzTxtPlcmtRec(3, pCSES15DOutputRec.getSzTxtPlcmtRec4());
                            csub16so.getCSUB16SOG00().getSzTxtPlcmtRec_ARRAY().setSzTxtPlcmtRec(4, pCSES15DOutputRec.getSzTxtPlcmtRec5());
                            csub16so.getCSUB16SOG00().getSzTxtPlcmtRec_ARRAY().setSzTxtPlcmtRec(5, pCSES15DOutputRec.getSzTxtPlcmtRec6());
                            csub16so.setSzNmPersUpdt(pCSES15DOutputRec.getSzNmPersUpdt());
                            
                            break;
                            
                        default :
                            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                            
                            
                            break;
                    }
                }
                
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
        ARC_PRFServiceStopTime_TUX(csub16si.getArchInputStruct() , csub16so.getArchOutputStruct());
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
        }
        else 
        
        
        
        
        
        
        
        {
            
            if (tpcommit(0) == - 1) 
            {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                //Do not commit as it will be committed in the called service.
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                //  Call CSES81D:
                // SELECT * FROM   CONTRACT_VERSION C WHERE  C.ID_CONTRACT =
                // AND C.NBR_CNVER_PERIOD =   AND C.DT_CNVER_END >= SYSDATE;
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            //Do not commit as it will be committed in the called service.
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return csub16so;
    }

}
