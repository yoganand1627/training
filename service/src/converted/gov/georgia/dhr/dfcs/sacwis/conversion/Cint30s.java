package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT76DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT76DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchInputStruct;
/**************************************************************************
** 
** Module File:   CINT30S .src
**
** Service Name:  CINT30S 
**
** Description:   Retrieval service for the Allegation Dialogue
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/15/95 
** 
** Programmer:    Paul Bordelon/Andersen Consulting
**                
** Description:   This service calls DAM CINT76D for the retrieval
**                functions of the Allegation windows.  This DAM retrieves 
**                data from the INTAKE_ALLEGATION table and, using person IDs
**                stored on INTAKE_ALLEGATION table, retrieves names from 
**                the PERSON table.  It is called from the Intake
**                Toolbar.
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  07/26/96   zabihin  sir 21891 : version control code was missing, I 
**                       added the line.
**
**  03/18/2003   KRD    IMPACT - need to ensure that the return code is
**                      FND_SUCCESS if no allegations are found.  Required
**                      a change to CallCINT19D().
**
**
** 07/12/2004    Ochumd Sir #22934 - Replaced CallCINT19D() with CallCINT76D().
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cint30s {
    CINT30SO CINT30S(CINT30SI cint30si) {
        CINT30SO cint30so = new CINT30SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_PRFServiceStartTime_TUX(cint30si.ArchInputStruct);
        rc = CallCINT76D(cint30si, cint30so, pServiceStatus);
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(cint30si.ArchInputStruct, cint30so.ArchOutputStruct);
        
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
                
                //  Call CINV51D
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cint30so;
    }

    static int CallCINT76D(CINT30SI pInputMsg476, _CINT30SO pOutputMsg, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i263 = 0;
        
        /*
        ** Declare local variables
        */
        CINT76DI pCINT76DInputRec = null;
        CINT76DO pCINT76DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT76DInputRec = new CINT76DI();
        pCINT76DOutputRec = new CINT76DO();
        
        /**************************************************************************
        ** Function Prototypes
        ***************************************************************************/
        pCINT76DInputRec.setUlIdStage(pInputMsg476.ulIdStage);
        pCINT76DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg476.ArchInputStruct.getUsPageNbr());
        pCINT76DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg476.ArchInputStruct.getUlPageSizeNbr());
        rc = cint76dQUERYdam(sqlca, pCINT76DInputRec, pCINT76DOutputRec);
        if ((rc != 0) && (rc != NO_DATA_FOUND)) {
            
            Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        
        else {
            
            
            //  Call CLSS67D
            rc = SUCCESS;
            //  IMPACT END
            
            //  Populate Output Message
            for (i263 = 0;i263 < pCINT76DOutputRec.getArchOutputStruct().getUlRowQty();++i263) {
                Csys08s.pOutputMsg.getROWCINT76DO()[i263].ulIdAllegation = pCINT76DOutputRec.getROWCINT76DO_ARRAY().getROWCINT76DO(i263).getUlIdAllegation();
                Csys08s.pOutputMsg.getROWCINT76DO()[i263].ulIdVictim = pCINT76DOutputRec.getROWCINT76DO_ARRAY().getROWCINT76DO(i263).getUlIdVictim();
                Csys08s// SIR #2141 Retreive ID_CASE
                .pOutputMsg.getROWCINT76DO()[i263].ulIdAllegedPerpetrator = pCINT76DOutputRec.getROWCINT76DO_ARRAY().getROWCINT76DO(i263).getUlIdAllegedPerpetrator();
                Csys08s// locally defined output of DAM
                .pOutputMsg.getROWCINT76DO()[i263].cTxtIntakeAllegDuration = pCINT76DOutputRec.getROWCINT76DO_ARRAY().getROWCINT76DO(i263).getCTxtIntakeAllegDuration();
                
                Csys08s.pOutputMsg.getROWCINT76DO()[i263].szCdIntakeAllegType = pCINT76DOutputRec.getROWCINT76DO_ARRAY().getROWCINT76DO(i263).getSzCdIntakeAllegType();
                Csys08s// SIR #2141 Retreivs rows for
                .pOutputMsg.getROWCINT76DO()[i263].szScrPersVictim = pCINT76DOutputRec.getROWCINT76DO_ARRAY().getROWCINT76DO(i263).getSzScrPersVictim();
                Csys08s// CASE_MERGE for retreived case
                .pOutputMsg.getROWCINT76DO()[i263].szScrAllegPerp = pCINT76DOutputRec.getROWCINT76DO_ARRAY().getROWCINT76DO(i263).getSzScrAllegPerp();
            };
            
            Csys08s.pOutputMsg.getArchOutputStruct().setUlRowQty(pCINT76DOutputRec.getArchOutputStruct().getUlRowQty());
            Csys08s.pOutputMsg.getArchOutputStruct().setBMoreDataInd(pCINT76DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return rc;
    }

}
