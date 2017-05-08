package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT11DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT11DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallListInStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
/**************************************************************************
** 
** Module File:   cint07s.src
**
** Service Name:  Call Log Search
**
** Description:   Uses a variable number of parameters to search for a
**                call.  It is a mega-scrolling service.
** 
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX ANSI C Compiler
**
** Date Created:  12/15/94
** 
** Programmer:    Brian Gugliemetti
**
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  07/26/96   zabihin  sir 21891 : version control code was missing,I
**                       added the lines.
**
**  12/17/96  TOPPINTW  Added new element (indicator) for Call Log NewUsing
**			CPS Logic.
**
**	05/15/03  Srini     SIR# 17294. Not returning proper error when the year 
**						in the date field is less than 1850.
**
**
** Sir 22964 -- Added code to allow a search by I&R and I&R Type only.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** DAM Copybooks
*/

/*
** SSANAME-3 header file
*/

/*
** Extern for version control table.
*/






public class Cint07s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final int MAX_WORK_CONCAT_NAME_LEN = 60;
    public static final int MAX_CONCAT_NAME_LEN = 25;
    public static final String TIME_MINIMUM = "12:00 AM";
    public static final String TIME_MAXIMUM = "11:59 PM";
    CINT07SO CINT07S(CINT07SI cint07si) {
        CINT07SO cint07so = new CINT07SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        rc = ARC_PRFServiceStartTime_TUX(cint07si.ArchInputStruct);
        rc = CallCINT11D(cint07si, cint07so, pServiceStatus);
        switch (rc) {
            case SUCCESS:
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_WARNING;
                pServiceStatus.explan_code = NO_DATA_FOUND;
                
                break;
            case Arcxmlerrors.ARC_UTL_YEAR_TOO_SMALL:
                pServiceStatus.severity = FND_WARNING;
                pServiceStatus.explan_code = Arcxmlerrors.ARC_UTL_YEAR_TOO_SMALL;
                break;
            case Messages.MSG_INT_INTERNAL_SQL_ERROR:
                pServiceStatus.severity = FND_WARNING;
                pServiceStatus.explan_code = Messages.MSG_INT_INTERNAL_SQL_ERROR;
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
        }
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(cint07si.ArchInputStruct, cint07so.ArchOutputStruct);
        
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
        return cint07so;
    }

    static int CallCINT11D(CINT07SI pInputMsg404, CINT07SO pOutputMsg370, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/* Return code */
        int i247 = 0;
        
        /*
        ** Declare local variables
        */
        CINT11DI pCINT11DInputRec = null;
        CINT11DO pCINT11DOutputRec = null;
        _SSANAMESTRUCT SSANameStruct;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT11DInputRec = new CINT11DI();
        pCINT11DOutputRec = new CINT11DO();
        
        pCINT11DInputRec.setArchInputStruct(pInputMsg404.ArchInputStruct);
        
        /**************************************************************************
        ** End Call to EVENT STATUS AUD Dam - CAUD64D
        **************************************************************************/
        
        
        
        if (!(pInputMsg404.CallListInStruct.getSzScrTimeFrom().length() != 0)) {
            pInputMsg404.CallListInStruct.setSzScrTimeFrom(TIME_MINIMUM);
        }
        if (!(pInputMsg404.CallListInStruct.getSzScrTmTimeTo().length() != 0)) {
            pInputMsg404.CallListInStruct.setSzScrTmTimeTo(TIME_MAXIMUM);
        }
        pCINT11DInputRec.setNmIncomingCallerFirst(pInputMsg404.CallListInStruct.getNmIncomingCallerFirst());
        pCINT11DInputRec.setNmIncomingCallerMiddle(pInputMsg404.CallListInStruct.getNmIncomingCallerMiddle());
        pCINT11DInputRec.setNmIncomingCallerLast(pInputMsg404.CallListInStruct.getNmIncomingCallerLast());
        pCINT11DInputRec.setSzCdStagePersType(pInputMsg404.CallListInStruct.getSzCdStagePersType());
        
        /**************************************************************************
        ** Function Prototypes
        ***************************************************************************/
        pCINT11DInputRec.setSzCdStageClassification(pInputMsg404.CallListInStruct.getSzCdStageClassification());
        pCINT11DInputRec.setSzCdInfoAndRefrl(pInputMsg404.CallListInStruct.getSzCdInfoAndRefrl());
        pCINT11DInputRec.setUlIdStage(pInputMsg404.CallListInStruct.getUlIdStage());
        
        pCINT11DInputRec.setSzAddrIncomingCallerCity(pInputMsg404.CallListInStruct.getSzAddrIncomingCallerCity());
        pCINT11DInputRec.setSzCdIncomingCallerCounty(pInputMsg404.CallListInStruct.getSzCdIncomingCallerCounty());
        pCINT11DInputRec.setSzCdStageRegion(pInputMsg404.CallListInStruct.getSzCdStageRegion());
        
        //## BEGIN TUX/XML: Declare XML variables 
        pCINT11DInputRec.getDtDtIncomingCall_ARRAY().setDtDtIncomingCall(0, pInputMsg404.CallListInStruct.getSzScrDtRangeFrom());
        pCINT11DInputRec.getDtDtIncomingCall_ARRAY().setDtDtIncomingCall(1, pInputMsg404.CallListInStruct.getSzScrDtRangeTo());
        pCINT11DInputRec.getTmTmIncmgCall_ARRAY().setTmTmIncmgCall(0, pInputMsg404.CallListInStruct.getSzScrTimeFrom());
        pCINT11DInputRec.getTmTmIncmgCall_ARRAY().setTmTmIncmgCall(1, pInputMsg404.CallListInStruct.getSzScrTmTimeTo());
        pCINT11DInputRec.setSzCdStageCurrPriority(pInputMsg404.CallListInStruct.getSzCdStageCurrPriority());
        pCINT11DInputRec.setCdIncmgStatus(pInputMsg404.CallListInStruct.getCdIncmgStatus());
        pCINT11DInputRec.setSzNbrUnit(pInputMsg404.CallListInStruct.getSzNbrUnit());
        SSANameStruct.szNmNameLast = pInputMsg404.CallListInStruct.getNmIncomingCallerLast();
        SSANameStruct.szNmNameFirst = pInputMsg404.CallListInStruct.getNmIncomingCallerFirst();
        if (pInputMsg404.CallListInStruct.getNmIncomingCallerLast().length() != 0) {
            SSANameStruct.szNmNameMiddle = pInputMsg404.CallListInStruct.getNmIncomingCallerMiddle();
        }
        else {
        }
        
        /*
        ** Call SSA-NAME3 to generate search keys
        */
        ARC_SSACreateKeys(SSANameStruct);
        pCINT11DInputRec.getSzNmPhkName_ARRAY().setSzNmPhkName(0, SSANameStruct.szSysNmSSARngFrmPhk[1]);
        pCINT11DInputRec.getSzNmPhkName_ARRAY().setSzNmPhkName(1, SSANameStruct.szSysNmSSARngToPhk[1]);
        pCINT11DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg404.ArchInputStruct.getUsPageNbr());
        pCINT11DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg404.ArchInputStruct.getUlPageSizeNbr());
        rc = cint11dQUERYdam(sqlca, pCINT11DInputRec, pCINT11DOutputRec);
        
        /**************************************************************************
        ** End Call to Primary Staff Simple Dam - CSEC66D
        **************************************************************************/
        
        
        if (rc != 0) {
            
            //  Analyze return code
            
            switch (rc) {
                    
                case NO_DATA_FOUND:
                    
                    break;
                case Arcxmlerrors.ARC_UTL_YEAR_TOO_SMALL:
                    
                    
                    break;
                default :
                    Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
        }
        //##             ARC_ERRHandleSQLError(&sqlca,
        //##				TUX_STATUSPARMS,
        //##				__FILE__,
        //##	                        __LINE__);
        
        else {
            //  Populate Output Message
            for (i247 = 0;i247 < pCINT11DOutputRec.getArchOutputStruct().getUlRowQty();++i247) {
                //  Create concatenated name for passing back to the
                // service.  This is done for both the caller and the
                // inregards to persons.
                CreateConcatName(pCINT11DOutputRec.getROWCINT11DO_ARRAY().getROWCINT11DO(i247).getNmIncomingCallerLast() , pCINT11DOutputRec.getROWCINT11DO_ARRAY().getROWCINT11DO(i247).getNmIncomingCallerFirst() , pCINT11DOutputRec.getROWCINT11DO_ARRAY().getROWCINT11DO(i247).getNmIncomingCallerMiddle() , pOutputMsg370.CallListStruct[i247].getSzScrNmIncmgCaller());
                
                CreateConcatName(pCINT11DOutputRec.getROWCINT11DO_ARRAY().getROWCINT11DO(i247).getSzNmIncmgRegardingLast() , pCINT11DOutputRec.getROWCINT11DO_ARRAY().getROWCINT11DO(i247).getSzNmIncmgRegardingFirst() , null, pOutputMsg370.CallListStruct[i247].getSzScrNmInReName());
                pOutputMsg370.CallListStruct[i247].setSzCdStageClassification(pCINT11DOutputRec.getROWCINT11DO_ARRAY().getROWCINT11DO(i247).getSzCdStageClassification());
                pOutputMsg370.CallListStruct[i247].setSzCdAddrCounty(pCINT11DOutputRec.getROWCINT11DO_ARRAY().getROWCINT11DO(i247).getSzCdIncomingCallerCounty());
                pOutputMsg370.CallListStruct[i247].setSzAddrCity(pCINT11DOutputRec.getROWCINT11DO_ARRAY().getROWCINT11DO(i247).getSzAddrIncomingCallerCity());
                pOutputMsg370.CallListStruct[i247].setCdIncmgStatus(pCINT11DOutputRec.getROWCINT11DO_ARRAY().getROWCINT11DO(i247).getCdIncmgStatus());
                pOutputMsg370.CallListStruct[i247].setDtDtIncomingCall(pCINT11DOutputRec.getROWCINT11DO_ARRAY().getROWCINT11DO(i247).getDtDtIncomingCall());
                pOutputMsg370.CallListStruct[i247].setTmTmIncmgCall(pCINT11DOutputRec.getROWCINT11DO_ARRAY().getROWCINT11DO(i247).getTmTmIncmgCall());
                pOutputMsg370.CallListStruct[i247].setUlIdIncomingWorker(pCINT11DOutputRec.getROWCINT11DO_ARRAY().getROWCINT11DO(i247).getUlIdPerson());
                pOutputMsg370.CallListStruct[i247].setUlIdStage(pCINT11DOutputRec.getROWCINT11DO_ARRAY().getROWCINT11DO(i247).getUlIdStage());
                pOutputMsg370.CallListStruct[i247].setSzCdStageCurrPriority(pCINT11DOutputRec.getROWCINT11DO_ARRAY().getROWCINT11DO(i247).getSzCdStageCurrPriority());
                pOutputMsg370.CallListStruct[i247].setSzScrPersonName(pCINT11DOutputRec.getROWCINT11DO_ARRAY().getROWCINT11DO(i247).getSzNmPersonFull());
                pOutputMsg370.CallListStruct[i247].setBIndIncmgIntInvClsReclss(pCINT11DOutputRec.getROWCINT11DO_ARRAY().getROWCINT11DO(i247).getBIndIncmgIntInvClsReclss());
                pOutputMsg370.CallListStruct[i247].setBIndIncmgSensitive(pCINT11DOutputRec.getROWCINT11DO_ARRAY().getROWCINT11DO(i247).getBIndIncmgSensitive());
            }
            pOutputMsg370.ArchOutputStruct.setUlRowQty(pCINT11DOutputRec.getArchOutputStruct().getUlRowQty());
            pOutputMsg370.ArchOutputStruct.setBMoreDataInd(pCINT11DOutputRec.getArchOutputStruct().getBMoreDataInd());
        }
        return rc;
    }

    void CreateConcatName(String pszLastName, String pszFirstName, String pszMiddleName, String pszConcatName) {
        String szWorkConcatName = "";
        if (pszLastName != null) {
            szWorkConcatName = pszLastName;
        }
        
        if (pszFirstName != null) {
            
            if (pszFirstName.length() != 0) {
                szWorkConcatName += "," + pszFirstName;
            }
        }
        if (pszMiddleName != null) {
            if (pszMiddleName.length() != 0) {
                szWorkConcatName += " " + pszMiddleName;
            }
        }
        pszConcatName = szWorkConcatName;
    }

}
