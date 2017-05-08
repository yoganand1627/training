package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES49DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES49DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
/**************************************************************************
**
** Module File:    CFIN26S.src
**
** Service Name:   Acct Tran Retrieve
**
** Description:   This service will retrieve all records from the
**                FIN ACCT TRANSACTION table that have an ID FIN ACCT
**                equal to the one passed into the service.  The user
**                will determine how the records should be sorted, hence
**                the dynamic DAM. Additionally, this service will retrieve
**                a single record from the FINANCIAL ACCOUNT table that has
**                an ID FIN ACCT equal to the one passed into the service.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  December 4, 1995
**
** Programmer:    Kristi D. Bradford
**
** Archive Information: $Revision:   1.0  $
**                      $Date:   27 May 1996 17:54:34  $
**                      $Modtime:   30 Mar 1996 00:14:18  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  02/17/2003  KRD     IMPACT - The Financial Account dialog now supports
**                      accounts for APS.  One of the changes was to add
**                      two new columns to the FIN_ACCT_TRANSACTION table.
**                      Any data in these columns needs to be returned
**                      from the service.
**
**  03/03/2003  KRD     IMPACT - Added another new column to the table.
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfin26s {
    CFIN26SO CFIN26S(CFIN26SI cfin26si) {
        CFIN26SO cfin26so = new CFIN26SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i235 = 0;
        _CDYN15DI * pCDYN15DInputRec;
        
        _CDYN15DO * pCDYN15DOutputRec;
        
        /*
        ** This DAM will retreive a single row from the FINANCIAL ACCOUNT table
        ** using ID FIN ACCT in the WHERE clause.
        */
        CSES49DI pCSES49DInputRec = null;
        CSES49DO pCSES49DOutputRec = null;
        
        rc = ARC_PRFServiceStartTime_TUX(cfin26si.ArchInputStruct);
        rc = ARC_UTLGetDateAndTime( & cfin26so.dtWCDDtSystemDate, 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCDYN15DInputRec = new UNKNOWN_TYPE();
        
        pCDYN15DOutputRec = new UNKNOWN_TYPE();
        
         & pCDYN15DInputRec.ArchInputStruct = & cfin26si.ArchInputStruct;
        pCDYN15DInputRec.ulIdFinAcct = cfin26si.ulIdFinAcct;
        pCDYN15DInputRec.bWcdCdSortBy = cfin26si.bWcdCdSortBy;
        pCDYN15DInputRec.ArchInputStruct.usPageNbr = cfin26si.ArchInputStruct.usPageNbr;
        pCDYN15DInputRec.ArchInputStruct.ulPageSizeNbr = cfin26si.ArchInputStruct.ulPageSizeNbr;
        rc = cdyn15dQUERYdam(sqlca, pCDYN15DInputRec, pCDYN15DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                
                //  Populate Output Message
                
                //  Set fields in CFIN26SO to fields in CDYN15DO
                for (i235 = 0;i235 < pCDYN15DOutputRec.ArchOutputStruct.ulRowQty;i235++) {
                    cfin26so.ROWCFIN26SOG00[i235].szCdAcctTranCategory = pCDYN15DOutputRec.ROWCDYN15DO[i235].szCdAcctTranCategory;
                    cfin26so.ROWCFIN26SOG00[i235].szCdAcctTranType = pCDYN15DOutputRec.ROWCDYN15DO[i235].szCdAcctTranType;
                    cfin26so.ROWCFIN26SOG00[i235].szTxtAcctTranDescr = pCDYN15DOutputRec.ROWCDYN15DO[i235].szTxtAcctTranDescr;
                     & cfin26so.ROWCFIN26SOG00[i235].dtDtAcctTranDate = & pCDYN15DOutputRec.ROWCDYN15DO[i235].dtDtAcctTranDate;
                     & cfin26so.ROWCFIN26SOG00[i235].tsLastUpdate = & pCDYN15DOutputRec.ROWCDYN15DO[i235].tsLastUpdate;
                    cfin26so.ROWCFIN26SOG00[i235].ldAmtAcctTranAmount = pCDYN15DOutputRec.ROWCDYN15DO[i235].ldAmtAcctTranAmount;
                    cfin26so.ROWCFIN26SOG00[i235].dAmtAcctTranBalance = pCDYN15DOutputRec.ROWCDYN15DO[i235].dAmtAcctTranBalance;
                    cfin26so.ROWCFIN26SOG00[i235].ulIdFinAcctTran = pCDYN15DOutputRec.ROWCDYN15DO[i235].ulIdFinAcctTran;
                    cfin26so.ROWCFIN26SOG00[i235].uNbrAcctTranCount = pCDYN15DOutputRec.ROWCDYN15DO[i235].uNbrAcctTranCount;
                    cfin26so.ROWCFIN26SOG00[i235].ulNbrAcctTranWarrantNbr = pCDYN15DOutputRec.ROWCDYN15DO[i235].ulNbrAcctTranWarrantNbr;
                    cfin26so.ROWCFIN26SOG00[i235].szCdSubcategory = pCDYN15DOutputRec.ROWCDYN15DO[i235].szCdSubcategory;
                    cfin26so.ROWCFIN26SOG00[i235].szNmPayee = pCDYN15DOutputRec.ROWCDYN15DO[i235].szNmPayee;
                    cfin26so.ROWCFIN26SOG00[i235].cIndFinAcctReconciled = pCDYN15DOutputRec.ROWCDYN15DO[i235].cIndFinAcctReconciled;
                }
                cfin26so.ArchOutputStruct.bMoreDataInd = pCDYN15DOutputRec.ArchOutputStruct.bMoreDataInd;
                cfin26so.ArchOutputStruct.ulRowQty = pCDYN15DOutputRec.ArchOutputStruct.ulRowQty;
                
                //  Allocate memory for DAM Input and Output Structures
                pCSES49DInputRec = new CSES49DI();
                
                pCSES49DOutputRec = new CSES49DO();
                pCSES49DInputRec.setArchInputStruct( & cfin26si.ArchInputStruct);
                pCSES49DInputRec// SIR #2141 Retreive ID_CASE
                .setUlIdFinAcct(cfin26si.ulIdFinAcct);
                
                
                //  CallCCMNG2D
                rc = cses49dQUERYdam(sqlca, pCSES49DInputRec, pCSES49DOutputRec);
                
                //  Analyze error code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                        
                        
                        //  Calculate output message size
                        
                         & cfin26so.tsLastUpdate = pCSES49DOutputRec.getTsLastUpdate();
                        cfin26so.ldAmtFinAcctBalance = pCSES49DOutputRec.getLdAmtFinAcctBalance();
                        cfin26so.uNbrFinAcctTransCount = pCSES49DOutputRec.getUNbrFinAcctTransCount();
                        break;
                        
                    default :
                        Arcxmlerrors// locally defined output of DAM
                        .PROCESS_TUX_SQL_ERROR();
                        break;
                }
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                
                //  Allocate memory for DAM Input and Output Structures
                pCSES49DInputRec = new CSES49DI();
                
                pCSES49DOutputRec = new CSES49DO();
                
                pCSES49DInputRec.setArchInputStruct( & cfin26si.ArchInputStruct);
                pCSES49DInputRec// SIR #2141 Retreivs rows for
                .setUlIdFinAcct(cfin26si.ulIdFinAcct);
                
                
                rc = cses49dQUERYdam(sqlca, pCSES49DInputRec, pCSES49DOutputRec);
                
                //  Analyze error code
                switch (rc) {
                    case WtcHelperConstants.SQL_SUCCESS:
                        pServiceStatus.severity = FND_SEVERITY_OK;
                        pServiceStatus.explan_code = SUCCESS;
                         & cfin26so.tsLastUpdate = pCSES49DOutputRec.getTsLastUpdate();
                        cfin26so.uNbrFinAcctTransCount = pCSES49DOutputRec.getUNbrFinAcctTransCount();
                        break;
                        
                    default :
                        Arcxmlerrors// CASE_MERGE for retreived case
                        .PROCESS_TUX_SQL_ERROR();
                        break;
                }
                break;
                rc = WtcHelperConstants.ARC_SUCCESS;
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
        ARC_PRFServiceStopTime_TUX(cfin26si.ArchInputStruct, cfin26so.ArchOutputStruct);
        
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
        
        return cfin26so;
    }

}
