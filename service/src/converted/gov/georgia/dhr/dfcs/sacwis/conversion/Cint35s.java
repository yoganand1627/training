package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT53DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT53DO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MUpdStruct;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
/**************************************************************************
** 
** Module File:   CINT35Ss.src
**
** Service Name:  CINT35S
**
** Description:   Person List Multiple Update service
**                Updates common information for rows selected on the Call 
**                Person List
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  4/1/95 
** 
** Programmer:    MJH
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  11/28/95  ELLIOTSL  ERR #233: bIndPersCancelHist indicator added.  
**
**  07/26/96   zabihin  sir 21891 : version control code was missing, I
**                       added the lines.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cint35s {
    CINT35SO CINT35S(CINT35SI cint35si) {
        CINT35SO cint35so = new CINT35SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;
        
        rc = ARC_PRFServiceStartTime_TUX(cint35si.ArchInputStruct);
        rc = CallCINT53D(cint35si, cint35so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Load translation map with service name and version 
        */
        
        /*
        ** Stop performance timer for service 
        */
        ARC_PRFServiceStopTime_TUX(cint35si.ArchInputStruct, cint35so.ArchOutputStruct);
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
        return cint35so;
    }

    static int CallCINT53D(CINT35SI pInputMsg482, _CINT35SO pOutputMsg, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int Indicator = 0;
        FndInt3date dtMaxDate = null;
        int rc = 0;
        int row = 0;
        CINT53DI pCINT53DInputRec = null;
        CINT53DO pCINT53DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT53DInputRec = new CINT53DI();
        
        pCINT53DOutputRec = new CINT53DO();
        pCINT53DInputRec.setBIndStagePersInLaw(pInputMsg482.MUpdStruct.getBIndStagePersInLaw());
        pCINT53DInputRec.setSzCdPersonEthnicGroup(pInputMsg482.MUpdStruct.getSzCdPersonEthnicGroup());
        pCINT53DInputRec.setSzCdPersonLanguage(pInputMsg482.MUpdStruct.getSzCdPersonLanguage());
        pCINT53DInputRec.setSzCdStagePersRelInt(pInputMsg482.MUpdStruct.getSzCdStagePersRelInt());
        pCINT53DInputRec.setSzCdStagePersRole(pInputMsg482.MUpdStruct.getSzCdStagePersRole());
        pCINT53DInputRec.setSzCdStagePersType(pInputMsg482.MUpdStruct.getSzCdStagePersType());
        pCINT53DInputRec.setSzNmNameLast(pInputMsg482.MUpdStruct.getSzNmNameLast());
        pCINT53DInputRec.setSzAddrPersAddrStLn1(pInputMsg482.MUpdStruct.getSzAddrPersAddrStLn1());
        pCINT53DInputRec.setSzAddrPersAddrStLn2(pInputMsg482.MUpdStruct.getSzAddrPersAddrStLn2());
        pCINT53DInputRec.setSzAddrCity(pInputMsg482.MUpdStruct.getSzAddrCity());
        pCINT53DInputRec.setLAddrZip(pInputMsg482.MUpdStruct.getLAddrZip());
        pCINT53DInputRec.setSzCdAddrCounty(pInputMsg482.MUpdStruct.getSzCdAddrCounty());
        pCINT53DInputRec.setSzCdAddrState(pInputMsg482.MUpdStruct.getSzCdAddrState());
        pCINT53DInputRec.setSzCdPersAddrLinkType(pInputMsg482.MUpdStruct.getSzCdPersAddrLinkType());
        pCINT53DInputRec.setLNbrPhone(pInputMsg482.MUpdStruct.getLNbrPhone());
        pCINT53DInputRec.setLNbrPhoneExtension(pInputMsg482.MUpdStruct.getLNbrPhoneExtension());
        pCINT53DInputRec.setSzCdPhoneType(pInputMsg482.MUpdStruct.getSzCdPhoneType());
        pCINT53DInputRec.setBIndPersCancelHist(pInputMsg482.MUpdStruct.getBIndPersCancelHist());
        pCINT53DInputRec.getArchInputStruct().setCReqFuncCd(WtcHelperConstants.REQ_FUNC_CD_UPDATE);
        
        /*
        ** Populate input structure with all row IDs 
        */
        while ((0 != pInputMsg482.MUpdIDInStruct[row].getUlIdPerson()) && (row < CINT35SI._MUPDINREC__MUPDIDINSTRUCT_SIZE)) {
            pCINT53DInputRec.setSzNmPersonFull(pInputMsg482.MUpdStruct.getSzNmPersonFull_ARRAY().getSzNmPersonFull(row));
            pCINT53DInputRec.setUlIdStage(pInputMsg482.MUpdIDInStruct[row].getUlIdStage());
            pCINT53DInputRec.setUlIdPerson(pInputMsg482.MUpdIDInStruct[row].getUlIdPerson());
            pCINT53DInputRec.setUlIdName(pInputMsg482.MUpdIDInStruct[row].getUlIdName());
            pCINT53DInputRec.setLdIdAddress(pInputMsg482.MUpdIDInStruct[row].getLdIdAddress());
            pCINT53DInputRec.setUlIdPhone(pInputMsg482.MUpdIDInStruct[row].getUlIdPhone());
            pCINT53DInputRec.setUlIdAddrPersonLink(pInputMsg482.MUpdIDInStruct[row].getUlIdAddrPersonLink());
            rc = cint53dAUDdam(sqlca, pCINT53DInputRec, pCINT53DOutputRec);
            if (WtcHelperConstants.SQL_SUCCESS != rc) {
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
            }
            else {
                //  SIR 13618 performs a full row retrieval from the allegation,
                // facility_allegation and person tables.
                rc = WtcHelperConstants.ARC_SUCCESS;
                Csys08s.pOutputMsg.getMUpdIDInStruct()[row].ulIdPerson = pCINT53DOutputRec.getUlIdPerson();
                Csys08s.pOutputMsg.getMUpdIDInStruct()[row].ulIdStage = pCINT53DOutputRec.getUlIdStage();
                Csys08s.pOutputMsg.getMUpdIDInStruct()[row].ulIdName = pCINT53DOutputRec.getUlIdName();
                Csys08s.pOutputMsg.getMUpdIDInStruct()[row].ulIdPhone = pCINT53DOutputRec.getUlIdPhone();
                Csys08s.pOutputMsg.getMUpdIDInStruct()[row].ldIdAddress = pCINT53DOutputRec.getLdIdAddress();
                Csys08s.pOutputMsg.getMUpdIDInStruct()[row].ulIdAddrPersonLink = pCINT53DOutputRec.getUlIdAddrPersonLink();
                Csys08s.pOutputMsg.getMUpdIDInStruct()[row].ulSysNbrUlongKey = pInputMsg482.MUpdIDInStruct[row].getUlSysNbrUlongKey();
            }
            row++;
        }
        return rc;
    }

}
