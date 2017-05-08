package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES06SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES22DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES22DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES32DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES32DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES34DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES35DI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES36DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES36DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES34DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES35DO;
/**************************************************************************
** 
** Module File:   CRES06S.src
**                                                            
** Service Name:  CRES06S
**
** Description:   This is the AUD service for the Area Served (CRES04W)
**                window.
**                
**                If the row passed is a region wide row, there are three
**                cases.  The first case is for DELETE.  In
**                these cases, the DAM CRES36D is called in order to
**                delete all the necessary population and service rows
**                for the region wide service.  The second case is for
**                UPDATE.  Again, CRES36D is called in order to update
**                all of the service rows for the region.  The populations
**                are left alone in this case.  The third case is for ADD.
**                CRES36D is called in order to add the Region wide row.
**                If this is successful, the database is searched in order
**                to find populations that are attached to any county rows 
**                that may have previously existed within the region.  If
**                the populations exist, they are deleted with CRES34D. Then,
**                any county rows within the region for the particular
**                service that previously existed are deletedusing CRES35D.
**                Now, the county rows for the region selected can be
**                added without any duplication occuring.  These county rows
**                are added with a show row of no so that they will not be
**                displayed in the list box on a retrieval.
**
**                If the row passed is a county row, a statewide intake row,
**                a state office row, or state != TX, their populations are
**                deleted with CRES34D (for the  delete case) and then the
**                necessary row is added, updated, or deleted.    
**                
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  5/18/95 
** 
** Programmer:    Jason W. Gloor
**
** Archive Information: $Revision:   1.0.1.4  $
**                      $Date:   21 Aug 1996 08:52:02  $
**                      $Modtime:   20 Aug 1996 17:31:04  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  08/10/95  jwg       Changed to pass out the ID resource service on Add 
**
**  04/09/96  ZIMMERNE  SIR #4187 - Mega-scrolling has been added to this 
**                      window.  The page number, page size, and the 
**                      username in the DAM Input architecture header are  
**                      populated by copying the service input architecture
**                      header message to the DAM Input architecture header.
**
**  08/02/96  ZABIHIN   SIR 21891 - Was missing versioning. Added the lines.
**
**  08/13/96  GLOORJW   SIR #21969 - Due to the Mega-scrolling logic it is
**                      necessary to inform the user if a duplicate row
**                      exists.  If a duplicate row exists, pass back the
**                      duplicate row message and the row #
**
**  08/15/96  VANDERM   SIR 21968 - Database needs to be returned to its
**                      original state when errors are encountered.  
**                      Error handling changed from FND_SEVERITY to
**                      FND_SEVERITY_ERROR.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/* SIR 21891 - added the versioning line below */
/* 
** Extern for version control table
*/






public class Cres06s {
    CRES06SO CRES06S(CRES06SI cres06si) {
        CRES06SO cres06so = new CRES06SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        
        /*
        ** Declare FOUNDATION variables 
        */
        
        /*
        ** Define a temporary input structure
        */
        CRES22DI CRES22DInputRec = null;
        CRES22DO CRES22DOutputRec = null;
        CRES32DI CRES32DInputRec = null;
        CRES32DO CRES32DOutputRec = null;
        CRES34DI CRES34DInputRec = null;
        CRES35DI CRES35DInputRec = null;
        CRES36DI CRES36DInputRec = null;
        CRES36DO CRES36DOutputRec = null;
        int i407 = 0;
        int uCtr = 0;
        char cOriginalDataActionInd = '\u0000';/* Original data action indicator */
        
        
        /*
        ** Call CINV95D
        */
        rc = ARC_PRFServiceStartTime_TUX(cres06si.getArchInputStruct());
        
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
        
        /*
        ** Loop through all of the service rows passed for AUD reasons
        ** in order to determine how to process them
        */
        for (i407 = 0;i407 < cres06si.getUlRowQty();++i407) {
            
            if (cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzScrRsrcSvcCntyCode()[0] == null && (0 != cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcRegion().compareTo(CAPS_UNIT_STATE_OFFICE)) && (0 != cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcRegion().compareTo(CAPS_UNIT_SWI)) && (0 == cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcState().compareTo(CAPS_DEFAULT_STATE_CD))) {
                // Hold original data action indicator
                cOriginalDataActionInd = cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdScrDataAction();
                CRES36DInputRec.setUlIdResourceService(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getUlIdResourceService());
                CRES36DInputRec.setSzCdScrDataAction(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdScrDataAction());
                CRES36DInputRec.setTsLastUpdate(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getTsLastUpdate());
                CRES36DInputRec.setCIndRsrcSvcShowRow(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getCIndRsrcSvcShowRow());
                CRES36DInputRec.setSzCdRsrcSvcCategRsrc(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcCategRsrc());
                CRES36DInputRec.setSzCdRsrcSvcService(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcService());
                CRES36DInputRec.setSzCdRsrcSvcProgram(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcProgram());
                CRES36DInputRec.setSzCdRsrcSvcRegion(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcRegion());
                CRES36DInputRec.setSzScrRsrcSvcCntyCode(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzScrRsrcSvcCntyCode());
                CRES36DInputRec.setBIndRsrcSvcCntyPartial(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getBIndRsrcSvcCntyPartial());
                CRES36DInputRec.setCIndRsrcSvcIncomeBsed(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getCIndRsrcSvcIncomeBsed());
                CRES36DInputRec.setSzCdRsrcSvcState(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcState());
                CRES36DInputRec.setUlIdResource(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getUlIdResource());
                CRES36DInputRec.setArchInputStruct(cres06si.getArchInputStruct());
                
                
                //  Call CSES68D
                rc = CallCRES36D(CRES36DInputRec, CRES36DOutputRec, pServiceStatus);
                
                switch (rc) {
                        
                        //  End Retrieve Contract's Payment History
                    case WtcHelperConstants.ARC_SUCCESS:
                        
                        if (WtcHelperConstants.REQ_FUNC_CD_ADD != cOriginalDataActionInd) {
                            break;
                        }
                        
                        //  else the original indicator was ADD, delete any county
                        // rows for the region that exist and set ShowRow to N.
                        else {
                            cres06so.getROWCRES06SOG00_ARRAY().getROWCRES06SOG00(i407).setUlIdResourceService(CRES36DOutputRec.getUlIdResourceService());
                            
                            CRES32DInputRec.setSzCdRsrcSvcRegion(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcRegion());
                            
                            CRES32DInputRec.getArchInputStruct().setUlPageSizeNbr(CRES32DO._CRES32DO__ROWCRES32DO_SIZE);
                            CRES32DInputRec.getArchInputStruct().setUsPageNbr(1);
                            
                            rc = Cres05s.CallCRES32D(CRES32DInputRec, CRES32DOutputRec, pServiceStatus);
                            Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                            
                            //  Loop through each county returned an process the 
                            // necessary county and population deletions if any
                            // previously existed, and then add the necessary
                            // rows
                            for (uCtr = 0;uCtr < CRES32DOutputRec.getArchOutputStruct().getUlRowQty();uCtr++) {
                                
                                CRES34DInputRec.setUlIdResource(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getUlIdResource());
                                CRES34DInputRec.setSzCdRsrcSvcService(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcService());
                                CRES34DInputRec.setSzCdRsrcSvcState(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcState());
                                CRES34DInputRec.setSzCdRsrcSvcRegion(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcRegion());
                                CRES34DInputRec.setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                                CRES34DInputRec.setSzScrRsrcSvcCntyCode(CRES32DOutputRec.getROWCRES32DO_ARRAY().getROWCRES32DO(uCtr).getSzScrRsrcSvcCntyCode());
                                CRES34DInputRec.setArchInputStruct(cres06si.getArchInputStruct());
                                
                                
                                //  Call CSEC63D
                                rc = CallCRES34D(CRES34DInputRec, cres06so, pServiceStatus);
                                
                                switch (rc) {
                                        //  All that we care about from the DAM is a TRUE or FALSE statement
                                        // as to whether the employee is a unit approver for the unit to which
                                        // they are "IN" assigned.  So, if the DAM returns SQL_SUCCESS, then
                                        // the employee is a unit approver, so return an error message.  If the
                                        // DAM returns SQL_NOT_FOUND, then the employee is not an approver, so
                                        // the modification desired can continue.
                                    case WtcHelperConstants.ARC_SUCCESS:
                                        
                                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                                        
                                        
                                        rc = WtcHelperConstants.ARC_SUCCESS;
                                        CRES35DInputRec.setUlIdResourceService(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getUlIdResourceService());
                                        CRES35DInputRec.setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                                        CRES35DInputRec.setTsLastUpdate(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getTsLastUpdate());
                                        CRES35DInputRec.setCIndRsrcSvcShowRow(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getCIndRsrcSvcShowRow());
                                        CRES35DInputRec.setSzCdRsrcSvcCategRsrc(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcCategRsrc());
                                        CRES35DInputRec.setSzCdRsrcSvcService(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcService());
                                        CRES35DInputRec.setSzCdRsrcSvcProgram(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcProgram());
                                        CRES35DInputRec.setSzCdRsrcSvcRegion(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcRegion());
                                        CRES35DInputRec.setBIndRsrcSvcCntyPartial(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getBIndRsrcSvcCntyPartial());
                                        CRES35DInputRec.setCIndRsrcSvcIncomeBsed(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getCIndRsrcSvcIncomeBsed());
                                        CRES35DInputRec.setSzCdRsrcSvcState(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcState());
                                        CRES35DInputRec.setUlIdResource(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getUlIdResource());
                                        CRES35DInputRec.setSzScrRsrcSvcCntyCode(CRES32DOutputRec.getROWCRES32DO_ARRAY().getROWCRES32DO(uCtr).getSzScrRsrcSvcCntyCode());
                                        CRES35DInputRec.setArchInputStruct(cres06si.getArchInputStruct());
                                        
                                        //  Set rc to MSG_DETAIL_DELETED
                                        rc = CallCRES35D(CRES35DInputRec, cres06so, pServiceStatus);
                                        //  Analyze return code
                                        switch (rc) {
                                            case WtcHelperConstants.ARC_SUCCESS:
                                                
                                            case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                                                
                                                //  Set rc to MSG_DETAIL_DELETED
                                                rc = WtcHelperConstants.ARC_SUCCESS;
                                                CRES22DInputRec.setUlIdResourceService(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getUlIdResourceService());
                                                CRES22DInputRec.setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_ADD);
                                                CRES22DInputRec.setTsLastUpdate(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getTsLastUpdate());
                                                CRES22DInputRec.setCIndRsrcSvcShowRow(Cint14s.INDICATOR_NO);
                                                CRES22DInputRec.setSzCdRsrcSvcCategRsrc(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcCategRsrc());
                                                CRES22DInputRec.setSzCdRsrcSvcService(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcService());
                                                CRES22DInputRec.setSzCdRsrcSvcProgram(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcProgram());
                                                CRES22DInputRec.setSzCdRsrcSvcRegion(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcRegion());
                                                CRES22DInputRec.setBIndRsrcSvcCntyPartial(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getBIndRsrcSvcCntyPartial());
                                                CRES22DInputRec.setCIndRsrcSvcIncomeBsed(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getCIndRsrcSvcIncomeBsed());
                                                CRES22DInputRec.setSzCdRsrcSvcState(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcState());
                                                
                                                CRES22DInputRec.setUlIdResource(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getUlIdResource());
                                                
                                                CRES22DInputRec.setSzScrRsrcSvcCntyCode(CRES32DOutputRec.getROWCRES32DO_ARRAY().getROWCRES32DO(uCtr).getSzScrRsrcSvcCntyCode());
                                                CRES22DInputRec.setArchInputStruct(cres06si.getArchInputStruct());
                                                
                                                // Set rc to ARC_SUCCESS
                                                rc = CallCRES22D(CRES22DInputRec, CRES22DOutputRec, pServiceStatus);
                                                
                                                //  Analyze return code
                                                switch (rc) {
                                                    case WtcHelperConstants.ARC_SUCCESS:
                                                        break;
                                                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                        break;
                                                    case Messages.MSG_DUPLICATE_RECORD:
                                                        
                                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                        break;
                                                        
                                                    default :
                                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                                }
                                                break;
                                                
                                            default :
                                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                        }
                                        break;
                                    default :
                                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                }
                            }
                        }
                        break;
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                    case Messages.MSG_DUPLICATE_RECORD:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            
            
            // 
            // else AUD single county, statewide intake, state office
            // or state != TX as passed (remember to delete population
            // if data action is delete)
            // 
            else if (WtcHelperConstants.REQ_FUNC_CD_DELETE == cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdScrDataAction()) {
                CRES34DInputRec.setUlIdResource(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getUlIdResource());
                CRES34DInputRec.setSzCdRsrcSvcService(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcService());
                CRES34DInputRec.setSzCdRsrcSvcState(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcState());
                CRES34DInputRec.setSzCdRsrcSvcRegion(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcRegion());
                CRES34DInputRec.setSzScrRsrcSvcCntyCode(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzScrRsrcSvcCntyCode());
                CRES34DInputRec.setSzCdScrDataAction(WtcHelperConstants.REQ_FUNC_CD_DELETE);
                CRES34DInputRec.setArchInputStruct(cres06si.getArchInputStruct());
                
                
                //  Call CSES67D
                rc = CallCRES34D(CRES34DInputRec, cres06so, pServiceStatus);
                
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                        
                        
                        //  Call CSES68D
                        rc = WtcHelperConstants.ARC_SUCCESS;
                        CRES22DInputRec.setUlIdResourceService(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getUlIdResourceService());
                        CRES22DInputRec.setSzCdScrDataAction(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdScrDataAction());
                        CRES22DInputRec.setTsLastUpdate(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getTsLastUpdate());
                        CRES22DInputRec.setCIndRsrcSvcShowRow(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getCIndRsrcSvcShowRow());
                        CRES22DInputRec.setSzCdRsrcSvcCategRsrc(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcCategRsrc());
                        CRES22DInputRec.setSzCdRsrcSvcService(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcService());
                        CRES22DInputRec.setSzCdRsrcSvcProgram(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcProgram());
                        CRES22DInputRec.setSzCdRsrcSvcRegion(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcRegion());
                        CRES22DInputRec.setSzScrRsrcSvcCntyCode(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzScrRsrcSvcCntyCode());
                        CRES22DInputRec.setBIndRsrcSvcCntyPartial(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getBIndRsrcSvcCntyPartial());
                        CRES22DInputRec.setCIndRsrcSvcIncomeBsed(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getCIndRsrcSvcIncomeBsed());
                        CRES22DInputRec.setSzCdRsrcSvcState(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcState());
                        CRES22DInputRec.setUlIdResource(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getUlIdResource());
                        CRES22DInputRec.setArchInputStruct(cres06si.getArchInputStruct());
                        
                        rc = CallCRES22D(CRES22DInputRec, CRES22DOutputRec, pServiceStatus);
                        
                        //  Analyze return code
                        switch (rc) {
                                
                            case WtcHelperConstants.ARC_SUCCESS:
                                break;
                            case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                break;
                                
                            case Messages.MSG_DUPLICATE_RECORD:
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                                break;
                                
                            default :
                                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        }
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
            
            //  else original indicator is add or update, add rows
            // not existing, update any rows that
            // already exist
            else {
                CRES22DInputRec.setUlIdResourceService(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getUlIdResourceService());
                CRES22DInputRec.setSzCdScrDataAction(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdScrDataAction());
                CRES22DInputRec.setTsLastUpdate(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getTsLastUpdate());
                CRES22DInputRec.setCIndRsrcSvcShowRow(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getCIndRsrcSvcShowRow());
                CRES22DInputRec.setSzCdRsrcSvcCategRsrc(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcCategRsrc());
                CRES22DInputRec.setSzCdRsrcSvcService(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcService());
                CRES22DInputRec.setSzCdRsrcSvcProgram(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcProgram());
                
                CRES22DInputRec.setSzCdRsrcSvcRegion(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcRegion());
                
                CRES22DInputRec.setSzScrRsrcSvcCntyCode(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzScrRsrcSvcCntyCode());
                CRES22DInputRec.setBIndRsrcSvcCntyPartial(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getBIndRsrcSvcCntyPartial());
                CRES22DInputRec.setCIndRsrcSvcIncomeBsed(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getCIndRsrcSvcIncomeBsed());
                
                CRES22DInputRec.setSzCdRsrcSvcState(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getSzCdRsrcSvcState());
                CRES22DInputRec.setUlIdResource(cres06si.getROWCRES06SIG_ARRAY().getROWCRES06SIG(i407).getUlIdResource());
                CRES22DInputRec.setArchInputStruct(cres06si.getArchInputStruct());
                
                //  Set rc to MSG_DETAIL_DELETED
                rc = CallCRES22D(CRES22DInputRec, CRES22DOutputRec, pServiceStatus);
                
                //  Analyze return code
                switch (rc) {
                    case WtcHelperConstants.ARC_SUCCESS:
                        cres06so.getROWCRES06SOG00_ARRAY().getROWCRES06SOG00(i407).setUlIdResourceService(CRES22DOutputRec.getUlIdResourceService());
                        break;
                    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                        //  SIR 18501 - Since the error handling is different in IMPACT than CAPS, 
                        // in order to have IMPACT function the same as CAPS, we need to trap for 
                        // the case where no rows are found.
                    case Messages.MSG_DUPLICATE_RECORD:
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                        break;
                        
                    default :
                        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
                }
            }
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(cres06si.getArchInputStruct() , cres06so.getArchOutputStruct());
        
        if (Arcxmlerrors.TUX_SUCCESS != rc) {
            userlog("explan_code=%d, rc=%d", pServiceStatus.explan_code, rc);
            ARC_TUXHandleRCError(Math.abs(rc) , pServiceStatus, CSourceUtils.getCurrentFileName() , CSourceUtils.getCurrentLineNumber());
            
            // 
            // END: CINV81D
            // 
            
        }
        else {
            
            //    if (pParserData->bInScope){
            if (tpcommit(0) == - 1) {
                System.err.println("ERROR: tpcommit failed (" + (tpstrerror(tperrno)) + ")");
                userlog("ERROR: tpcommit failed (%s)\n", tpstrerror(tperrno));
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                
                // Set rc to ARC_SUCCESS
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cres06so;
    }

    static int PrepServiceExit(_SERVICE_DATA * pfpb, _RTAF * pRTAF, _ABHI * pABHI) {
        _MSG_PARM_BLOCK * pMsgPB = (_MSG_PARM_BLOCK) pfpb.pTXN_PB;
        _MSG_PARM_BLOCK * pReturnPB = (_MSG_PARM_BLOCK) pRTAF.pReply_txn_pb;
        int rc = 0;/* Return code */
        pOutputMsgTransMap.map_name = CRES05S_XLT_OUT;
        pOutputMsgTransMap.map_version = WtcHelperConstants.MAP_VERSION;
        
        /*
        ** Stop performance timer for service 
        */
        
        ARC_PRFServiceStopTime_TUX(Csys08s.pInputMsg.getArchInputStruct() , Csys08s.pOutputMsg.getArchOutputStruct());
        return SUCCESS;
    }

    static int CallCRES22D(CRES22DI pCRES22DInputMsg, CRES22DO pCRES22DOutputMsg, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CRES22DI pCRES22DInputRec = null;
        CRES22DO pCRES22DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES22DInputRec = new CRES22DI();
        pCRES22DOutputRec = new CRES22DO();
        pCRES22DInputRec.setUlIdResourceService(pCRES22DInputMsg.getUlIdResourceService());
        
        pCRES22DInputRec.setSzCdScrDataAction(pCRES22DInputMsg.getSzCdScrDataAction());
        pCRES22DInputRec.setTsLastUpdate(pCRES22DInputMsg.getTsLastUpdate());
        pCRES22DInputRec.setCIndRsrcSvcShowRow(pCRES22DInputMsg.getCIndRsrcSvcShowRow());
        pCRES22DInputRec.setSzCdRsrcSvcCategRsrc(pCRES22DInputMsg.getSzCdRsrcSvcCategRsrc());
        pCRES22DInputRec.setSzCdRsrcSvcService(pCRES22DInputMsg.getSzCdRsrcSvcService());
        pCRES22DInputRec.setSzCdRsrcSvcProgram(pCRES22DInputMsg.getSzCdRsrcSvcProgram());
        pCRES22DInputRec.setSzCdRsrcSvcRegion(pCRES22DInputMsg.getSzCdRsrcSvcRegion());
        pCRES22DInputRec.setSzScrRsrcSvcCntyCode(pCRES22DInputMsg.getSzScrRsrcSvcCntyCode());
        pCRES22DInputRec.setBIndRsrcSvcCntyPartial(pCRES22DInputMsg.getBIndRsrcSvcCntyPartial());
        pCRES22DInputRec.setCIndRsrcSvcIncomeBsed(pCRES22DInputMsg.getCIndRsrcSvcIncomeBsed());
        pCRES22DInputRec.setSzCdRsrcSvcState(pCRES22DInputMsg.getSzCdRsrcSvcState());
        pCRES22DInputRec.setUlIdResource(pCRES22DInputMsg.getUlIdResource());
        pCRES22DInputRec.setArchInputStruct(pCRES22DInputMsg.getArchInputStruct());
        pCRES22DInputRec.getArchInputStruct().setCReqFuncCd(pCRES22DInputMsg.getSzCdScrDataAction());
        rc = cres22dAUDdam(sqlca, pCRES22DInputRec, pCRES22DOutputRec);
        
        /*
        ** Analyze return code
        */
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pCRES22DOutputMsg.setUlIdResourceService(pCRES22DOutputRec.getUlIdResourceService());
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                break;
                
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                
                
                //  Call CCMNB2D
                rc = Messages.MSG_DUPLICATE_RECORD;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        return rc;
    }

    static int CallCRES32D(CRES32DI pCRES32DInputMsg, CRES32DO pCRES32DOutputMsg, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        int i408 = 0;
        
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
        
        
        /*
        ** Call CSES81D
        */
        rc = cres32dQUERYdam(sqlca, pCRES32DInputRec, pCRES32DOutputRec);
        
        /*
        ** Analyze return code
        **
        ** If DAM was not successful, then evaluate the return code.
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                //  Populate Output Message
                for (i408 = 0;i408 < pCRES32DOutputRec.getArchOutputStruct().getUlRowQty();++i408) {
                    pCRES32DOutputMsg.getROWCRES32DO_ARRAY().getROWCRES32DO(i408).setSzScrRsrcSvcCntyCode(pCRES32DOutputRec.getROWCRES32DO_ARRAY().getROWCRES32DO(i408).getSzScrRsrcSvcCntyCode());
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

    static int CallCRES34D(CRES34DI pCRES34InputMsg, CRES06SO * pOutputMsg761, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CRES34DI pCRES34DInputRec = null;
        CRES34DO pCRES34DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES34DInputRec = new CRES34DI();
        pCRES34DOutputRec = new CRES34DO();
        pCRES34DInputRec.setUlIdResource(pCRES34InputMsg.getUlIdResource());
        
        /* There should always be an Event Status associated
        ** with an ID EVENT on the database.
        */
        pCRES34DInputRec.setSzCdRsrcSvcService(pCRES34InputMsg.getSzCdRsrcSvcService());
        
        pCRES34DInputRec.setSzScrRsrcSvcCntyCode(pCRES34InputMsg.getSzScrRsrcSvcCntyCode());
        
        pCRES34DInputRec.setSzCdRsrcSvcState(pCRES34InputMsg.getSzCdRsrcSvcState());
        pCRES34DInputRec.setSzCdRsrcSvcRegion(pCRES34InputMsg.getSzCdRsrcSvcRegion());
        pCRES34DInputRec.setUlIdResourceChrctr(pCRES34InputMsg.getUlIdResourceChrctr());
        pCRES34DInputRec.setSzCdScrDataAction(pCRES34InputMsg.getSzCdScrDataAction());
        pCRES34DInputRec.setSzCdRsrcCharChrctr(pCRES34InputMsg.getSzCdRsrcCharChrctr());
        pCRES34DInputRec.setCCdRsrcCharSex(pCRES34InputMsg.getCCdRsrcCharSex());
        pCRES34DInputRec.setUlIdResourceService(pCRES34InputMsg.getUlIdResourceService());
        pCRES34DInputRec.setUNbrRsrcCharMinMAge(pCRES34InputMsg.getUNbrRsrcCharMinMAge());
        pCRES34DInputRec.setUNbrRsrcCharMaxMAge(pCRES34InputMsg.getUNbrRsrcCharMaxMAge());
        
        pCRES34DInputRec.setUNbrRsrcCharMinFAge(pCRES34InputMsg.getUNbrRsrcCharMinFAge());
        pCRES34DInputRec.setUNbrRsrcCharMaxFAge(pCRES34InputMsg.getUNbrRsrcCharMaxFAge());
        pCRES34DInputRec.setArchInputStruct(pCRES34InputMsg.getArchInputStruct());
        pCRES34DInputRec.getArchInputStruct().setCReqFuncCd(pCRES34InputMsg.getSzCdScrDataAction());
        
        rc = cres34dAUDdam(sqlca, pCRES34DInputRec, pCRES34DOutputRec);
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
                
            case NO_DATA_FOUND:
                pServiceStatus.severity = SUCCESS;
                pServiceStatus.explan_code = SUCCESS;
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        return rc;
    }

    static int CallCRES35D(CRES35DI pCRES35DInputMsg, CRES06SO * pOutputMsg762, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CRES35DI pCRES35DInputRec = null;
        CRES35DO pCRES35DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES35DInputRec = new CRES35DI();
        pCRES35DOutputRec = new CRES35DO();
        pCRES35DInputRec.setUlIdResourceService(pCRES35DInputMsg.getUlIdResourceService());
        pCRES35DInputRec.setSzCdScrDataAction(pCRES35DInputMsg.getSzCdScrDataAction());
        
        pCRES35DInputRec.setCIndRsrcSvcShowRow(pCRES35DInputMsg.getCIndRsrcSvcShowRow());
        pCRES35DInputRec.setSzCdRsrcSvcCategRsrc(pCRES35DInputMsg.getSzCdRsrcSvcCategRsrc());
        pCRES35DInputRec.setSzCdRsrcSvcService(pCRES35DInputMsg.getSzCdRsrcSvcService());
        pCRES35DInputRec.setSzCdRsrcSvcProgram(pCRES35DInputMsg.getSzCdRsrcSvcProgram());
        pCRES35DInputRec.setSzCdRsrcSvcRegion(pCRES35DInputMsg.getSzCdRsrcSvcRegion());
        pCRES35DInputRec.setSzScrRsrcSvcCntyCode(pCRES35DInputMsg.getSzScrRsrcSvcCntyCode());
        pCRES35DInputRec.setBIndRsrcSvcCntyPartial(pCRES35DInputMsg.getBIndRsrcSvcCntyPartial());
        
        pCRES35DInputRec.setCIndRsrcSvcIncomeBsed(pCRES35DInputMsg.getCIndRsrcSvcIncomeBsed());
        pCRES35DInputRec.setSzCdRsrcSvcState(pCRES35DInputMsg.getSzCdRsrcSvcState());
        pCRES35DInputRec.setUlIdResource(pCRES35DInputMsg.getUlIdResource());
        pCRES35DInputRec.setArchInputStruct(pCRES35DInputMsg.getArchInputStruct());
        pCRES35DInputRec.getArchInputStruct().setCReqFuncCd(pCRES35DInputMsg.getSzCdScrDataAction());
        
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
        /*
        **
        ** Either there is one or more dams called depending upon how the invalid row
        ** indicator is handled.
        **
        */
        rc = cres35dAUDdam(sqlca, pCRES35DInputRec, pCRES35DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = SUCCESS;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Call dam to retrieve the IdUnit.
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                break;// break for success of CINV51D (VC)
                // /*
                // CASE SQL_NOT_FOUND for CINV51D (VC)
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

    static int CallCRES36D(CRES36DI pCRES36DInputMsg, CRES36DO pCRES36DOutputMsg, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;
        
        /*
        ** Declare local variables
        */
        CRES36DI pCRES36DInputRec = null;
        CRES36DO pCRES36DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCRES36DInputRec = new CRES36DI();
        pCRES36DOutputRec = new CRES36DO();
        pCRES36DInputRec.setUlIdResourceService(pCRES36DInputMsg.getUlIdResourceService());
        pCRES36DInputRec.setSzCdScrDataAction(pCRES36DInputMsg.getSzCdScrDataAction());
        pCRES36DInputRec.setTsLastUpdate(pCRES36DInputMsg.getTsLastUpdate());
        pCRES36DInputRec.setCIndRsrcSvcShowRow(pCRES36DInputMsg.getCIndRsrcSvcShowRow());
        pCRES36DInputRec.setSzCdRsrcSvcCategRsrc(pCRES36DInputMsg.getSzCdRsrcSvcCategRsrc());
        pCRES36DInputRec.setSzCdRsrcSvcService(pCRES36DInputMsg.getSzCdRsrcSvcService());
        pCRES36DInputRec.setSzCdRsrcSvcProgram(pCRES36DInputMsg.getSzCdRsrcSvcProgram());
        pCRES36DInputRec.setSzCdRsrcSvcRegion(pCRES36DInputMsg.getSzCdRsrcSvcRegion());
        pCRES36DInputRec.setSzScrRsrcSvcCntyCode(pCRES36DInputMsg.getSzScrRsrcSvcCntyCode());
        pCRES36DInputRec.setBIndRsrcSvcCntyPartial(pCRES36DInputMsg.getBIndRsrcSvcCntyPartial());
        pCRES36DInputRec.setCIndRsrcSvcIncomeBsed(pCRES36DInputMsg.getCIndRsrcSvcIncomeBsed());
        pCRES36DInputRec.setSzCdRsrcSvcState(pCRES36DInputMsg.getSzCdRsrcSvcState());
        pCRES36DInputRec.setUlIdResource(pCRES36DInputMsg.getUlIdResource());
        pCRES36DInputRec.setArchInputStruct(pCRES36DInputMsg.getArchInputStruct());
        pCRES36DInputRec.getArchInputStruct().setCReqFuncCd(pCRES36DInputMsg.getSzCdScrDataAction());
        rc = cres36dAUDdam(sqlca, pCRES36DInputRec, pCRES36DOutputRec);
        
        /*
        ** Analyze error code
        */
        switch (rc) {
                
            case WtcHelperConstants.SQL_SUCCESS:
                pCRES36DOutputMsg.setUlIdResourceService(pCRES36DOutputRec.getUlIdResourceService());
                
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                //  Call DAM
                rc = Messages.MSG_CMN_TMSTAMP_MISMATCH;
                
                break;
            case WtcHelperConstants.SQL_DUPLICATE_KEY:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_DUPLICATE_RECORD;
                
                
                rc = Messages.MSG_DUPLICATE_RECORD;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        return rc;
    }

}
