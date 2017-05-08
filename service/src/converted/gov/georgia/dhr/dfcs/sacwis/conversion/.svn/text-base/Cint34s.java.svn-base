package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT34SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT34SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT48DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT48DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT49DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT49DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT50DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT51DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT51DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT52DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT52DO;
/**************************************************************************
** 
** Module File:   cint34s.src
**
** Service Name:  CINT34S
**
** Description:   Retrieve service for CINT16W Incoming Person Detail window.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Function List
** -------------
** CINT34S      Retrieve service for incoming tables.
** CallCINT48D  Retrieves a list of rows from the INCOMING_ADDRESS table.
** CallCINT49D  Retrieves a list of rows from the INCOMING_NAME table.
** CallCINT50D  Retrieves a list of rows from the INCOMING_PERSON_ID table.
** CallCINT51D  Retrieves a row from the INCOMING_PERSON table.
** CallCINT52D  Retrieves a list of rows from the INCOMING_PHONE table.
**
** File History
** ------------
** 02/27/95   laskeyrm   File created.
** 04/16/95   laskeyrm   Code beautified, malloc return checked.
** 04/28/95   laskeyrm   return 0s placed after most PROCESS_TUX_RC_ERROR calls.
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**
**  07/26/96   zabihin  sir 21891 : version control code was missing,I
**                      added the lines.
**  02/10/03   Srini D  Added goto and End statements to take care of the 
**                      intermediate exits.
**  02/17/03   Srini D  check for error(TUX_CHECK_APPL_STATUS) only in case 
**                      of other than FND_SUCESS and SQL_NOT_FOUND.
**  08/05/03 Matthew McClain, updated marshalCINT34SO to return the correct
**                      number of rows for each array
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cint34s {
    
    /* Page number for DAM. */
    public static final int CINT34S_PAGE_ONE = 1;
    CINT34SO CINT34S(CINT34SI cint34si) {
        boolean goto_END = false;
        CINT34SO cint34so = new CINT34SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        
        
        
        int ulNewEventId = 0;
        cint34si.getArchInputStruct().setUsPageNbr(CINT34S_PAGE_ONE);
        cint34si.getArchInputStruct().setUlPageSizeNbr(CINT34S_PAGE_ONE);
        rc = CallCINT51D(cint34si, cint34so, pServiceStatus);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case SUCCESS:
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_WARNING;
                pServiceStatus.explan_code = rc;
                goto END;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                
                break;
        }
        cint34si.getArchInputStruct().setUsPageNbr(CINT34S_PAGE_ONE);
        cint34si.getArchInputStruct().setUlPageSizeNbr(CINT34SO._CINT34SO__ROWCINT48DO_SIZE);
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        
        /*
        ** Start performance timer for service 
        */
        rc = CallCINT48D(cint34si, cint34so, pServiceStatus);
        if ((rc != SUCCESS) && (rc != NO_DATA_FOUND)) {
            goto END;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        cint34si.getArchInputStruct().setUsPageNbr(CINT34S_PAGE_ONE);
        cint34si.getArchInputStruct().setUlPageSizeNbr(CINT34SO._CINT34SO__ROWCINT49DO_SIZE);
        
        /* SIR 21891 - missing versioning */
        /*
        ** Run-time Versioning
        */
        
        /*
        ** Check buffer size 
        */
        
        /*
        ** Process error message and return to client 
        */
        
        /*
        ** Initialize output message and length 
        */
        
        /*
        ** Initialize service status fields 
        */
        
        /*********************************************************************
        *  Call DAMs to retrieve data
        **********************************************************************/
        rc = CallCINT49D(cint34si, cint34so, pServiceStatus);
        /* if current date is only 2 days different from Eff date, then
        ** don't update contract_version and contract-service tables
        * There are 1440 Minutes in One Day
        */
        if ((rc != SUCCESS) && (rc != NO_DATA_FOUND)) {
            //##         return(FND_SUCCESS);
            goto END;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        cint34si.getArchInputStruct().setUsPageNbr(CINT34S_PAGE_ONE);
        cint34si.getArchInputStruct().setUlPageSizeNbr(CINT34SO._CINT34SO__ROWCINT50DO_SIZE);
        
        /*********************************************************************
        *  Prepare output message to be returned and return
        **********************************************************************/
        
        /* Get system date */
        rc = CallCINT50D(cint34si, cint34so, pServiceStatus);
        if ((rc != SUCCESS) && (rc != NO_DATA_FOUND)) {
            // Srini 02/10/03  Added goto for intermediate exit.
            goto END;
            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        cint34si.getArchInputStruct().setUsPageNbr(CINT34S_PAGE_ONE);
        cint34si.getArchInputStruct().setUlPageSizeNbr(CINT34SO._CINT34SO__ROWCINT52DO_SIZE);
        rc = CallCINT52D(cint34si, cint34so, pServiceStatus);
        
        if ((rc != SUCCESS) && (rc != NO_DATA_FOUND)) {
            goto_END = true;
            
            if (!goto_END) {
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
        }
        
        /* Find out the levels of care of the resource */
        if (!(goto_END)) {
            
            // Load translation map with service name and version.
            
            // Stop performance timer for service.
            ARC_PRFServiceStopTime_TUX(cint34si.getArchInputStruct() , cint34so.getArchOutputStruct());
        }
        
        if ((rc != SUCCESS) && (rc != NO_DATA_FOUND)) {
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
        }
        else {
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                
                //  Call DAM
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cint34so;
    }

    static int CallCINT48D(CINT34SI pInputMsg477, CINT34SO pOutputMsg436, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i264 = 0;
        CINT48DI pCINT48DI = null;
        CINT48DO pCINT48DO = null;
        
        /* Allocate memory for Input and Output Structures. */
        pCINT48DI = new CINT48DI();
        pCINT48DO = new CINT48DO();
        
        if (pCINT48DI == (CINT48DI) 0 || pCINT48DO == (CINT48DO) 0) {
            return Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
        }
        
        pCINT48DI.setArchInputStruct(pInputMsg477.getArchInputStruct());
        
        //## BEGIN TUX/XML: Turn OutputMsg into an XML buffer and send back to Tuxedo 
        pCINT48DI.setUlIdIncmgPerson(pOutputMsg436.getROWCINT51DO().getUlIdIncmgPerson());
        rc = cint48dQUERYdam(sqlca, pCINT48DI, pCINT48DO);
        switch (rc) {
            case SUCCESS:
                pOutputMsg436.setArchOutputStruct(pCINT48DO.getArchOutputStruct());
                for (i264 = 0;i264 < pOutputMsg436.getArchOutputStruct().getUlRowQty();i264++) {
                    pOutputMsg436.getROWCINT48DO_ARRAY().setROWCINT48DO(i264, pCINT48DO.getROWCINT48DO_ARRAY().getROWCINT48DO(i264));
                }
                break;
            case NO_DATA_FOUND:
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCINT49D(CINT34SI pInputMsg478, CINT34SO pOutputMsg437, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code   */
        int i265 = 0;
        CINT49DI pCINT49DI = null;
        CINT49DO pCINT49DO = null;
        
        /* Allocate memory for Input and Output Structures. */
        pCINT49DI = new CINT49DI();
        pCINT49DO = new CINT49DO();
        if (pCINT49DI == (CINT49DI) 0 || pCINT49DO == (CINT49DO) 0) {
            return Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
        }
        pCINT49DI.setArchInputStruct(pInputMsg478.getArchInputStruct());
        pCINT49DI.setUlIdIncmgPerson(pOutputMsg437.getROWCINT51DO().getUlIdIncmgPerson());
        
        /*
        ** Call XXXDAMNameXXX
        */
        rc = cint49dQUERYdam(sqlca, pCINT49DI, pCINT49DO);
        switch (rc) {
                
            case SUCCESS:
                pOutputMsg437.setArchOutputStruct(pCINT49DO.getArchOutputStruct());
                for (i265 = 0;i265 < pOutputMsg437.getArchOutputStruct().getUlRowQty();i265++) {
                    pOutputMsg437.getROWCINT49DO_ARRAY().setROWCINT49DO(i265, pCINT49DO.getROWCINT49DO_ARRAY().getROWCINT49DO(i265));
                }
                break;
                
            case NO_DATA_FOUND:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

    static int CallCINT50D(CINT34SI pInputMsg479, CINT34SO pOutputMsg438, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i266 = 0;
        CINT50DI pCINT50DI = null;
        CINT50DO pCINT50DO = null;
        
        /* Allocate memory for Input and Output Structures. */
        pCINT50DI = new CINT50DI();
        pCINT50DO = new CINT50DO();
        
        if (pCINT50DI == (CINT50DI) 0 || pCINT50DO == (CINT50DO) 0) {
            return Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
        }
        pCINT50DI.setArchInputStruct(pInputMsg479.getArchInputStruct());
        pCINT50DI.setUlIdIncmgPerson(pOutputMsg438.getROWCINT51DO().getUlIdIncmgPerson());
        
        
        /*
        ** Set rc to ARC_SUCCESS
        */
        rc = cint50dQUERYdam(sqlca, pCINT50DI, pCINT50DO);
        switch (rc) {
            case SUCCESS:
                
                pOutputMsg438.setArchOutputStruct(pCINT50DO.getArchOutputStruct());
                for (i266 = 0;i266 < pOutputMsg438.getArchOutputStruct().getUlRowQty();i266++) {
                    
                    pOutputMsg438.getROWCINT50DO_ARRAY().setROWCINT50DO(i266, pCINT50DO.getROWCINT50DO_ARRAY().getROWCINT50DO(i266));
                }
                break;
                
            case NO_DATA_FOUND:
                break;
            default :
                
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCINT51D(CINT34SI pInputMsg480, CINT34SO pOutputMsg439, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i267 = 0;
        CINT51DI pCINT51DI = null;
        CINT51DO pCINT51DO = null;
        
        /* Allocate memory for Input and Output Structures. */
        pCINT51DI = new CINT51DI();
        pCINT51DO = new CINT51DO();
        if (pCINT51DI == (CINT51DI) 0 || pCINT51DO == (CINT51DO) 0) {
            return Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
        }
        pCINT51DI.setArchInputStruct(pInputMsg480.getArchInputStruct());
        pCINT51DI.setUlIdStage(pInputMsg480.getUlIdStage());
        pCINT51DI.setUlIdPerson(pInputMsg480.getUlIdPerson());
        
        rc = cint51dQUERYdam(sqlca, pCINT51DI, pCINT51DO);
        switch (rc) {
            case SUCCESS:
                pOutputMsg439.setArchOutputStruct(pCINT51DO.getArchOutputStruct());
                pOutputMsg439.getROWCINT51DO().setUlIdPerson(pCINT51DO.getUlIdPerson());
                pOutputMsg439.getROWCINT51DO().setUlIdStage(pCINT51DO.getUlIdStage());
                pOutputMsg439.getROWCINT51DO().setUlIdIncmgPerson(pCINT51DO.getUlIdIncmgPerson());
                pOutputMsg439.getROWCINT51DO().setUsNbrIncmgPersAge(pCINT51DO.getUsNbrIncmgPersAge());
                pOutputMsg439.getROWCINT51DO().setCIndPersonDobApprox(pCINT51DO.getCIndPersonDobApprox());
                pOutputMsg439.getROWCINT51DO().setDtDtIncmgPersDeath(pCINT51DO.getDtDtIncmgPersDeath());
                
                pOutputMsg439.getROWCINT51DO().setDtDtIncmgPersBirth(pCINT51DO.getDtDtIncmgPersBirth());
                pOutputMsg439.getROWCINT51DO().setSzCdIncmgPersDeath(pCINT51DO.getSzCdIncmgPersDeath());
                pOutputMsg439.getROWCINT51DO().setSzCdIncmgPersMaritlStat(pCINT51DO.getSzCdIncmgPersMaritlStat());
                pOutputMsg439.getROWCINT51DO().setSzCdIncmgPersLanguage(pCINT51DO.getSzCdIncmgPersLanguage());
                pOutputMsg439.getROWCINT51DO().setSzCdIncmgPersSex(pCINT51DO.getSzCdIncmgPersSex());
                pOutputMsg439.getROWCINT51DO().setSzNmIncmgPersFull(pCINT51DO.getSzNmIncmgPersFull());
                pOutputMsg439.getROWCINT51DO().setSzCdIncmgPersEthnic(pCINT51DO.getSzCdIncmgPersEthnic());
                break;
            case NO_DATA_FOUND:// Of Svc Auth Table Add or Update
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                
                break;
        }
        return rc;
    }

    static int CallCINT52D(CINT34SI pInputMsg481, CINT34SO pOutputMsg440, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        
        /* 
        ** Declare local variables
        */
        int rc = 0;
        int i268 = 0;
        CINT52DI pCINT52DI = null;
        CINT52DO pCINT52DO = null;
        
        /* Allocate memory for Input and Output Structures. */
        pCINT52DI = new CINT52DI();
        pCINT52DO = new CINT52DO();
        
        if (pCINT52DI == (CINT52DI) 0 || pCINT52DO == (CINT52DO) 0) {
            return Arcxmlerrors.ARC_ERR_INTERNAL_ERROR;
        }
        pCINT52DI.setArchInputStruct(pInputMsg481.getArchInputStruct());
        
        pCINT52DI.setUlIdIncmgPerson(pOutputMsg440.getROWCINT51DO().getUlIdIncmgPerson());
        
        rc = cint52dQUERYdam(sqlca, pCINT52DI, pCINT52DO);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
            case SUCCESS:
                pOutputMsg440.setArchOutputStruct(pCINT52DO.getArchOutputStruct());
                for (i268 = 0;i268 < pOutputMsg440.getArchOutputStruct().getUlRowQty();i268++) {
                    pOutputMsg440.getROWCINT52DO_ARRAY().setROWCINT52DO(i268, pCINT52DO.getROWCINT52DO_ARRAY().getROWCINT52DO(i268));
                }
                break;
            case NO_DATA_FOUND:
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

}
