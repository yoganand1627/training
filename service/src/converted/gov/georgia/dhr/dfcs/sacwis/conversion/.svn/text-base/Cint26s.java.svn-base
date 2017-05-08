package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT05DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT05DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
/**************************************************************************
**
** Module File:   cint26s.src
**
** Service Name:  cint26s
**
** Description:   Retrieve Call Person List Box info
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/12/95
**
** Programmer:    Melanie J Huston
**
** Archive Information: $Revision:   1.5  $
**                      $Date:   20 Jul 1998 15:37:44  $
**                      $Modtime:   20 Jul 1998 11:11:54  $
**                      $Author:   pvcs  $
**
** Change History:
**
** Date      User       Description
** --------- ---------- ---------------------------------------------------
**  __Feb95  hustonmj   Initial check-in.
**  25Apr96  sladewmf   SIR #5190: Within the CallCINT05D function, changed
**                      the value for pCINT05DInputRec->tsSysTsQuery from
**                      MAX_DATE (12/31/4712) to (MAX_DATE - 1 day:
**                      12/30/4712) (when pInputMsg->cdIncmgStatus !=
**                      CLOSED), so that one and only one row will be
**                      retrieved from the four (of nine) SELECT statements
**                      within cint05d.pc which retrieve without a cursor,
**                      directly into host variables.  NOTE: there also was a
**                      change made in cint05d.pc to check for EndDates >
**                      hI_tsSysTsQuery, rather than >=; this change required
**                      cint26s.src to send in MAX_DATE - 1 day rather than
**                      MAX_DATE.
**
**  07/26/96   zabihin  sir 21891 : version control code was missing,I
**                       added the lines.
**  10/29/96    KRD     SIR 2928 - The timestamp version of the Incoming Call
**                      Disposed Date is now being passed into cint05d rather
**                      than the "normal" version.  Required a change to
**                      CallCINT05D().  Other changes to the service have
**                      been made for readability/maintainability purposes.
**  07/08/98  SOHNJJ    SIR 14422 (MHMR ITEM #1): This enhancement allows
**                      intake to record multiple reporters.  A new
**                      column, CD_STAGE_PERS_LST_SORT was added to the
**                      STAGE_PERSON_LINK table to store a code that is
**                      used to identify and sort a person in the Person
**                      List window listbox.  A person can be a "CALLER_SORT",
**                      "REPORTER_SORT", or an "OTHER_SORT".  Each intake
**                      has only one caller, but may have multiple people
**                      categorized as reporters or others.  The caller will
**                      always appear shaded in the first row of the listbox.
**                      All reporters will appear below the caller row and
**                      above the other rows.  In the Person Detail window,
**                      the reporter checkbox will always be enabled and
**                      can be selected or deselected except for the person
**                      in the caller row.
**  09/27/05  dunawakl  SIR 24002 - Added szCdDisasterRlf for disaster relief
**                      field on Call Person Detail
**
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cint26s {
    
    /**************************************************************************
    ** Service Macro Definitions
    ***************************************************************************/
    public static final String CLOSED = "CLD";
    CINT26SO CINT26S(CINT26SI cint26si) {
        CINT26SO cint26so = new CINT26SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        rc = ARC_PRFServiceStartTime_TUX(cint26si.ArchInputStruct);
        
        /*
        ** Call DAM
        */
        rc = CallCINT05D(cint26si, cint26so, pServiceStatus);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        /*
        ** Load translation map with service name and version
        */
        
        /*
        ** Stop performance timer for service
        */
        ARC_PRFServiceStopTime_TUX(cint26si.ArchInputStruct, cint26so.ArchOutputStruct);
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
                
                //  Call DAM
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cint26so;
    }

    static int CallCINT05D(CINT26SI pInputMsg474, CINT26SO pOutputMsg434, Arcxmlerrors.TUX_DECL_STATUSPARMS) {
        int rc = 0;/*Return Code*/
        int i262 = 0;
        int Indicator = 0;
        CINT05DI pCINT05DInputRec = null;
        CINT05DO pCINT05DOutputRec = null;
        
        /*
        ** Allocate memory for Input and Output Structures
        */
        pCINT05DInputRec = new CINT05DI();
        
        pCINT05DOutputRec = new CINT05DO();
        pCINT05DInputRec.setUlIdStage(pInputMsg474.ulIdStage);
        if (0 == CLOSED.compareTo(pInputMsg474.cdIncmgStatus)) {
            pCINT05DInputRec.tsSysTsQuery = pInputMsg474.tsIncmgCallDisp;
        }
        
        else {
            pCINT05DInputRec.getTsSysTsQuery_ARRAY().setTsSysTsQuery(0, 147);
            pCINT05DInputRec.getTsSysTsQuery_ARRAY().setTsSysTsQuery(1, 112);
            
            pCINT05DInputRec.getTsSysTsQuery_ARRAY().setTsSysTsQuery(2, 12);
            pCINT05DInputRec.getTsSysTsQuery_ARRAY().setTsSysTsQuery(3, 30);
            pCINT05DInputRec.getTsSysTsQuery_ARRAY().setTsSysTsQuery(4, 1);
            pCINT05DInputRec.getTsSysTsQuery_ARRAY().setTsSysTsQuery(5, 1);
            pCINT05DInputRec.getTsSysTsQuery_ARRAY().setTsSysTsQuery(6, 1);
        }
        pCINT05DInputRec.setCdIncmgStatus(pInputMsg474.cdIncmgStatus);
        pCINT05DInputRec.getArchInputStruct().setUsPageNbr(pInputMsg474.ArchInputStruct.getUsPageNbr());
        pCINT05DInputRec.getArchInputStruct().setUlPageSizeNbr(pInputMsg474.ArchInputStruct.getUlPageSizeNbr());
        rc = cint05dQUERYdam(sqlca, pCINT05DInputRec, pCINT05DOutputRec);
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pOutputMsg434.ArchOutputStruct = pCINT05DOutputRec.getArchOutputStruct();
                
                for (i262 = 0;i262 < pCINT05DOutputRec.getArchOutputStruct().getUlRowQty();++i262) {
                    pOutputMsg434.PersListRtrvStruct[i262].setSzCdStagePersType(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzCdStagePersType());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzCdStagePersRole(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzCdStagePersRole());
                    pOutputMsg434.PersListRtrvStruct[i262].setDtDtPersonBirth(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getDtDtPersonBirth());
                    pOutputMsg434.PersListRtrvStruct[i262].setBIndPersonDobApprox(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getBIndPersonDobApprox());
                    pOutputMsg434.PersListRtrvStruct[i262].setLNbrPersonAge(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getLNbrPersonAge());
                    pOutputMsg434.PersListRtrvStruct[i262].setCCdPersonSex(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getCCdPersonSex());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzCdStagePersRelInt(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzCdStagePersRelInt());
                    pOutputMsg434.PersListRtrvStruct[i262].setBIndStagePersReporter(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getBIndStagePersReporter());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzCdStagePersSearchInd(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzCdStagePersSearchInd());
                    pOutputMsg434.PersListRtrvStruct[i262].setBIndStagePersInLaw(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getBIndStagePersInLaw());
                    pOutputMsg434.PersListRtrvStruct[i262].setDtDtPersonDeath(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getDtDtPersonDeath());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzCdPersonDeath(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzCdPersonDeath());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzCdPersonMaritalStatus(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzCdPersonMaritalStatus());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzCdPersonLanguage(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzCdPersonLanguage());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzCdDisasterRlf(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzCdDisasterRlf());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzCdPersonEthnicGroup(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzCdPersonEthnicGroup());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzTxtStagePersNotes(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzTxtStagePersNotes());
                    pOutputMsg434.PersListRtrvStruct[i262].setUlIdStage(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getUlIdStage());
                    pOutputMsg434.PersListRtrvStruct[i262].setUlIdPerson(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getUlIdPerson());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzCdStagePersLstSort(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzCdStagePersLstSort());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzNmNameFirst(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzNmNameFirst());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzNmNameMiddle(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzNmNameMiddle());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzNmNameLast(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzNmNameLast());
                    pOutputMsg434.PersListRtrvStruct[i262].setDtDtNameEndDate(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getDtDtNameEndDate());
                    pOutputMsg434.PersListRtrvStruct[i262].setDtDtNameStartDate(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getDtDtNameStartDate());
                    pOutputMsg434.PersListRtrvStruct[i262].setBIndNameInvalid(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getBIndNameInvalid());
                    pOutputMsg434.PersListRtrvStruct[i262].setUlIdName(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getUlIdName());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzNmPersonFull(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzNmPersonFull());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzCdNameSuffix(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzCdNameSuffix());
                    pOutputMsg434.PersListRtrvStruct[i262].setBScrIndAlias(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getBScrIndAlias());
                    pOutputMsg434.PersListRtrvStruct[i262].setUlIdPersonId(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getUlIdPersonId());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzNbrPersonIdNumber(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzNbrPersonIdNumber());
                    pOutputMsg434.PersListRtrvStruct[i262].setBIndPersonIDInvalid(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getBIndPersonIDInvalid());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzDescPersonID(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzDescPersonID());
                    pOutputMsg434.PersListRtrvStruct[i262].setDtPersonIDEnd(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getDtPersonIDEnd());
                    pOutputMsg434.PersListRtrvStruct[i262].setDtPersonIDStart(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getDtPersonIDStart());
                    pOutputMsg434.PersListRtrvStruct[i262].setBScrIndPersIdentifiers(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getBScrIndPersIdentifiers());
                    pOutputMsg434.PersListRtrvStruct[i262].setLdIdAddress(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getLdIdAddress());
                    pOutputMsg434.PersListRtrvStruct[i262].setUlIdAddrPersonLink(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getUlIdAddrPersonLink());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzCdPersAddrLinkType(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzCdPersAddrLinkType());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzAddrPersAddrStLn1(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzAddrPersAddrStLn1());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzAddrPersAddrStLn2(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzAddrPersAddrStLn2());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzAddrCity(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzAddrCity());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzCdAddrState(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzCdAddrState());
                    pOutputMsg434.PersListRtrvStruct[i262].setLAddrZip(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getLAddrZip());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzCdAddrCounty(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzCdAddrCounty());
                    pOutputMsg434.PersListRtrvStruct[i262].setDtDtPersAddrLinkEnd(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getDtDtPersAddrLinkEnd());
                    pOutputMsg434.PersListRtrvStruct[i262].setDtDtPersAddrLinkStart(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getDtDtPersAddrLinkStart());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzTxtPersAddrCmnts(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzTxtPersAddrCmnts());
                    
                    pOutputMsg434.PersListRtrvStruct[i262].setBIndPersAddrLinkInvalid(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getBIndPersAddrLinkInvalid());
                    pOutputMsg434.PersListRtrvStruct[i262].setLScrNbrOfAddrs(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getLScrNbrOfAddrs());
                    pOutputMsg434.PersListRtrvStruct[i262].setUlIdPhone(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getUlIdPhone());
                    pOutputMsg434.PersListRtrvStruct[i262].setLNbrPhone(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getLNbrPhone());
                    pOutputMsg434.PersListRtrvStruct[i262].setLNbrPhoneExtension(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getLNbrPhoneExtension());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzCdPhoneType(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzCdPhoneType());
                    pOutputMsg434.PersListRtrvStruct[i262].setDtDtPersonPhoneEnd(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getDtDtPersonPhoneEnd());
                    pOutputMsg434.PersListRtrvStruct[i262].setDtDtPersonPhoneStart(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getDtDtPersonPhoneStart());
                    pOutputMsg434.PersListRtrvStruct[i262].setSzTxtPhoneComments(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getSzTxtPhoneComments());
                    pOutputMsg434.PersListRtrvStruct[i262].setBIndPersonPhoneInvalid(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getBIndPersonPhoneInvalid());
                    
                    pOutputMsg434.PersListRtrvStruct[i262].setLScrNbrPhoneNbrs(pCINT05DOutputRec.getROWCINT05DO_ARRAY().getROWCINT05DO(i262).getLScrNbrPhoneNbrs());
                }
                pOutputMsg434.ArchOutputStruct.setUlRowQty(pCINT05DOutputRec.getArchOutputStruct().getUlRowQty());
                pOutputMsg434.ArchOutputStruct.setBMoreDataInd(pCINT05DOutputRec.getArchOutputStruct().getBMoreDataInd());
                rc = WtcHelperConstants.ARC_SUCCESS;
                break;
            case NO_DATA_FOUND:
                
                //  Call DAM
                rc = WtcHelperConstants.ARC_SUCCESS;
                
                break;
                
            default :
                Arcxmlerrors.PROCESS_TUX_SQL_ERROR();
                break;
        }
        return rc;
    }

}
