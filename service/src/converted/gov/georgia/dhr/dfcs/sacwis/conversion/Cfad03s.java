package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSEC16DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES41DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSS35DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CLSC40DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSEC16DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSS35DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES41DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CLSC40DI;
/**************************************************************************
** 
** Module File:   CFAD03S.src
**
** Service Name:  CFAD03S
**
** Description:   This service will populate the F/A Home Reverification
**                Document.  This form will be used by the F/A Home worker 
**                to reverify the F/A Home is meeting compliance standards.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  11/1/95 
** 
** Programmer:    Robert O'Donnell
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:10:52  $
**                      $Modtime:   08 May 1996 21:39:42  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  05/06/96  FOISTHJ   SIR 20751 & 20752 - Set the declared dam output 
**                      pointers to NULL to prevent memory allocation 
**                      problems.
**
**  04/10/03  Srini D   Modified the error handling to set rc to explan_code 
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfad03s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    
    
    public static final int MAX_DAMS = 99;
    
    public static final String PERSON_TYPE = "PRN";
    public static final String PLOC_TYPE = "ALOC";
    CFAD03SO CFAD03S(CFAD03SI cfad03si) {
        CFAD03SO cfad03so = new CFAD03SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int iNumDAMs = 0;/* Total number of DAMs called */
        void[MAX_DAMS] pDAMPtrs = null;/* Array of pointers to DAM output */
        Pint uFormDataSize = new Pint();/* Total size of service output buffer
        after ARC_FRMProduceFormData */
        Pint ulIdResource6 = new Pint();
        CSEC16DO pCSEC16DOutputRec = null;/* SIR 20751 & 20752 */
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Declare local variables 
        */
        //##   short          rc = FND_SUCCESS;
        
        
        
        
        /*
        ** Declare a DAM output pointer for each DAM output.  Repeat the
        ** following statement for each DAM to be called.
        */
        
        CSES41DO pCSES41DOutputRec = null;
        CLSS35DO pCLSS35DOutputRec = null;
        CLSC40DO pCLSC40DOutputRec = null;
        rc = ARC_PRFServiceStartTime_TUX(cfad03si.getArchInputStruct());
        
        /*
        ** Run-time versioning
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
        
        
        /* Call to the CSEC16D DAM to retrieve Nm Resource, Id Resource, and
        Id Case based on the Id Stage from input */
        
        pCSEC16DOutputRec = new CSEC16DO();
        rc = CallCSEC16D(cfad03si, cfad03so, ulIdResource6, pCSEC16DOutputRec, pServiceStatus);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                pCSEC16DOutputRec.getArchOutputStruct().setUlRowQty(1);
                
                // Call to CLSS35D DAM to retrieve the current placements with all
                // the Person information about the child using Id Resource from 
                // CSEC16D
                
                pCLSS35DOutputRec = new CLSS35DO();
                
                //  Call DAM
                rc = CallCLSS35D(cfad03si, cfad03so, ulIdResource6.value, pCLSS35DOutputRec, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        break;
                        
                        //   PROCESS_TUX_RC_ERROR is called only when there is an unexpected error
                        // returned from the callDAM function.
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
                break;
            case Messages.MSG_NO_ROWS_RETURNED:
                break;
                
                
                //   PROCESS_TUX_RC_ERROR is called only when there is an unexpected error
                // returned from the callDAM function.
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        
        /* Call to CSES41D to retrieve a full row on the CAPS RESOURCE
        table to fill the home address information using Id Stage */
        
        
        pCSES41DOutputRec = new CSES41DO();
        /* PWO 1037: svcshell.src: added setting rc = ARC_SUCCESS */
        rc = CallCSES41D(cfad03si, cfad03so, pCSES41DOutputRec, pServiceStatus);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                pCSES41DOutputRec.getArchOutputStruct().setUlRowQty(1);
                break;
            case Messages.MSG_NO_ROWS_RETURNED:
                break;
                
                
                
                //   PROCESS_TUX_RC_ERROR is called only when there is an unexpected error
                // returned from the callDAM function.
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        
        
        /* Call to CLSC40D to retrieve a list of principals in the home
        and data about these people using Id Stage from input */
        
        pCLSC40DOutputRec = new CLSC40DO();
        rc = CallCLSC40D(cfad03si, cfad03so, pCLSC40DOutputRec, pServiceStatus);
        
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.ARC_SUCCESS:
                break;
                
                
                //   PROCESS_TUX_RC_ERROR is called only when there is an unexpected error
                // returned from the callDAM function.
            default :
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        }
        if (rc == WtcHelperConstants.ARC_SUCCESS) {
            // 
            // Populate the pDAMPtrs structure with the address of the DAM output
            // of each DAM called.
            // Then call ARC_FRMProduceFormData with the output of each DAM to 
            // prepare the service output message with formated form data.
            // 
            
            iNumDAMs = 0;
            
            // Repeat the following 2 statements for each DAM called.  
            // (DO NOT leave out the 2nd iNumDAMs increment when populating 
            // pDAMPtrs with your last DAM output pointer.) 
            // Remember that the order in which the DAM pointers
            // is added to the array must exactly match the sequence number 
            // specified for each DAM when the form was registered in the 
            // database.
            
            pDAMPtrs[iNumDAMs] = pCSEC16DOutputRec;
            iNumDAMs++;
            
            pDAMPtrs[iNumDAMs] = pCSES41DOutputRec;
            iNumDAMs++;
            
            pDAMPtrs[iNumDAMs] = pCLSC40DOutputRec;
            iNumDAMs++;
            
            pDAMPtrs[iNumDAMs] = pCLSS35DOutputRec;
            iNumDAMs++;
            uFormDataSize.value = 0;
            rc = ARC_FRMProduceFormData(QUARTERLY_ASSESSMENT, iNumDAMs, (char * * ) & pDAMPtrs, (char) cfad03so, sizeof () , uFormDataSize);
            
            //  Analyze error code
            if (rc != WtcHelperConstants.ARC_SUCCESS) {
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = rc;
                rc = Arcxmlerrors.ARC_ERR_NO_PROC_RC;
            }
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(cfad03si.getArchInputStruct() , cfad03so.getArchOutputStruct());
        rc = pServiceStatus.explan_code;
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
                
                
                //  Start Performance Timer
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cfad03so;
    }

    static int CallCSEC16D(CFAD03SI pInputMsg379, CFAD03SO * pOutputMsg349, Pint ulIdResource7, CSEC16DO pCSEC16DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CSEC16DI pCSEC16DInputRec = new CSEC16DI();
        pCSEC16DInputRec.setArchInputStruct(pInputMsg379.getArchInputStruct());
        pCSEC16DInputRec.setUlIdRsrcFaHomeStage(pInputMsg379.getUlIdStage());
        
        rc = csec16dQUERYdam(sqlca, pCSEC16DInputRec, pCSEC16DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                ulIdResource7.value = pCSEC16DOutputRec.getUlIdResource();
                
                //  Set rc to MSG_DETAIL_DELETED
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                
                // Set rc to ARC_SUCCESS
                rc = Messages.MSG_NO_ROWS_RETURNED;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCLSS35D(CFAD03SI pInputMsg380, CFAD03SO * pOutputMsg350, int ulIdResource8, CLSS35DO pCLSS35DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        FndInt3date dtCurrDate2 = null;
        int rc = 0;/* Return code */
        int i205 = 0;
        
        /*
        ** Declare local variables
        */
        
        CLSS35DI pCLSS35DInputRec = new CLSS35DI();
        rc = ARC_UTLGetDateAndTime(dtCurrDate2, 0);
        pCLSS35DInputRec.setUlIdResource(ulIdResource8);
        pCLSS35DInputRec.setSzCdPlocType(PLOC_TYPE);
        pCLSS35DInputRec.setDtScrDtCurrentDate(dtCurrDate2);
        pCLSS35DInputRec.setArchInputStruct(pInputMsg380.getArchInputStruct());
        pCLSS35DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCLSS35DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSS35DO._CLSS35DO__ROWCLSS35DO_SIZE);
        rc = clss35dQUERYdam(sqlca, pCLSS35DInputRec, pCLSS35DOutputRec);
        
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                for (i205 = 0;i205 < pCLSS35DOutputRec.getArchOutputStruct().getUlRowQty();++i205) {
                }
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = WtcHelperConstants.ARC_SUCCESS;
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCSES41D(CFAD03SI pInputMsg381, CFAD03SO * pOutputMsg351, CSES41DO pCSES41DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        
        /* 
        ** Declare local variables
        */
        CSES41DI pCSES41DInputRec = new CSES41DI();
        
        pCSES41DInputRec.setArchInputStruct(pInputMsg381.getArchInputStruct());
        pCSES41DInputRec.setUlIdRsrcFaHomeStage(pInputMsg381.getUlIdStage());
        rc = cses41dQUERYdam(sqlca, pCSES41DInputRec, pCSES41DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = Messages.MSG_NO_ROWS_RETURNED;
                
                //  Call CCMN44D
                rc = Messages.MSG_NO_ROWS_RETURNED;
                break;
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCLSC40D(CFAD03SI pInputMsg382, CFAD03SO * pOutputMsg352, CLSC40DO pCLSC40DOutputRec, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i206 = 0;
        
        /*
        ** Declare local variables
        */
        CLSC40DI pCLSC40DInputRec = new CLSC40DI();
        pCLSC40DInputRec.setUlIdStage(pInputMsg382.getUlIdStage());
        pCLSC40DInputRec.setSzCdStagePersType(PERSON_TYPE);
        pCLSC40DInputRec.setArchInputStruct(pInputMsg382.getArchInputStruct());
        pCLSC40DInputRec.getArchInputStruct().setUsPageNbr(1);
        pCLSC40DInputRec.getArchInputStruct().setUlPageSizeNbr(CLSC40DO._CLSC40DO__ROWCLSC40DO_SIZE);
        rc = clsc40dQUERYdam(sqlca, pCLSC40DInputRec, pCLSC40DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                for (i206 = 0;i206 < pCLSC40DOutputRec.getArchOutputStruct().getUlRowQty();++i206) {
                }
                
                
                //  Call CLSS04D
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_WARNING;
                pServiceStatus.explan_code = WtcHelperConstants.ARC_SUCCESS;
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
