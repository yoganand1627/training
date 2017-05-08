package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.output.BLOBStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT42DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT42DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IntNarrBlobRtrvStruct;
/**************************************************************************
**
** Module File:   cint22s.src
**
** Service Name:  CINT22S
**
** Description:   INT NARR BLOB RTRV
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  02/06/1995
**
** Programmer:    Brian Gugliemetti, Andersen Consulting
**
** Archive Information: $Revision:   1.2  $
**                      $Date:   06 Aug 1996 11:22:06  $
**                      $Modtime:   05 Aug 1996 16:49:10  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  06/16/95  gugliebs  Tech review changes.
**
**  07/26/96   zabihin  sir 21891 : version control code was missin, I
**                      added the lines.
**
**  03/19/03   Srini    Commented the marshalling of BLOBStruct as it is not 
**			used any more through services.
**
**  04/21/03   Srini    IMPACT: Commenting rc in the cint42d dam so that error
**						is returned in the case of SQL_NOT_FOUND.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cint22s {
    CINT22SO CINT22S(CINT22SI cint22si) {
        CINT22SO cint22so = new CINT22SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        
        
        
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        
        Pint p = new Pint();
        Pint q = new Pint();
        int size = 0;
        /*
        ** Do nothing, the output message just returns success or
        ** failure.
        **
        ** When SQL_NOT_FOUND is returned, there were no case names
        ** to update.
        */
        rc = ARC_PRFServiceStartTime_TUX(cint22si.ArchInputStruct);
        rc = CallCINT42D(cint22si, cint22so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*********************************************************************
        *  Prepare output message to be returned and return
        **********************************************************************/
        
        /*
        ** Calculate the output message size
        */
        //%$   *pOutputMsgSize = sizeof(_CINT22SO) -
        //%$                     (sizeof(pOutputMsg->BLOBStruct.aSysBlbBLOBData) -
        //%$                      pOutputMsg->BLOBStruct.usSysNbrBLOBLength);
        /*%$******************************************************
        PORT_CHANGE_BEGIN: cawthocw, 26 March 2001 - New msg size calculation
        **********************************************************%$*/
        
        p = (char) cint22so;
        /*
        ** Loop thru both the MergeTo Person and MergeFrom Person
        ** struct. If same Person is found in both the cases
        ** which has a Person role of Primary Child and belongs
        ** to the same stage Than set the Duplicate flag to TRUE.
        */
        q = (char) cint22so.BLOBStruct.getASysBlbBLOBData();
        size = (q - p) + sizeof ();
        /*%$******************************************************
        PORT_CHANGE_END: cawthocw, 26 March 2001 - New msg size calculation
        **********************************************************%$*/
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cint22si.ArchInputStruct, cint22so.ArchOutputStruct);
        
        /* modified if statement for SIR 14113
        if (0 == strcmp(pCMSC39DOutputRec->ROWCMSC39DO[iPlcmtCtr].szCdPlcmtLivArr,
        ADOPTIVE_PLCMT_TYPE) ||
        0 == strcmp(pCMSC39DOutputRec->ROWCMSC39DO[iPlcmtCtr].szCdPlcmtLivArr,
        RSRC_TYPE_PVT_AGENCY))
        */
        
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
        return cint22so;
    }

    static int CallCINT42D(CINT22SI pInputMsg467, CINT22SO pOutputMsg427, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        /*
        ** Declare local variables
        */
        CINT42DI pCINT42DInputRec = null;
        CINT42DO pCINT42DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT42DInputRec = new CINT42DI();
        pCINT42DOutputRec = new CINT42DO();
        
        /*
        ** SIR 3687 - Set Date to MAX_DATE if dtDtRecRtnDstryActual
        ** == NULL_DATE. This is necessary so that the window can display
        ** a maximum date in the Case Destruction field.
        */
        if ((pCINT42DInputRec == null) || (pCINT42DOutputRec == null)) {
            
            
            
            //  Set rc to ARC_SUCCESS
            rc = Arcxmlerrors.ARC_ERR_MALLOC_FAILED;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        pCINT42DInputRec.setUlIdStage(pInputMsg467.IntNarrBlobRtrvStruct.getUlIdStage());
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = cint42dQUERYdam(sqlca, pCINT42DInputRec, pCINT42DOutputRec);
        
        if (rc != 0) {
            
            //  Analyze error code
            switch (rc) {
                    
                case NO_DATA_FOUND:
                    pServiceStatus.severity = FND_WARNING;
                    pServiceStatus.explan_code = rc;
                    break;
                    
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        
        else {
            pOutputMsg427.BLOBStruct = pCINT42DOutputRec.getBLOBStruct();
        }
        return rc;
    }

}
