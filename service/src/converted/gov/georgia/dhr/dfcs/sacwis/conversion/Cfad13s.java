package gov.georgia.dhr.dfcs.sacwis.conversion;
import gov.georgia.dhr.dfcs.sacwis.conversion.*;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSES55DI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSES55DO;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelperConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
/**************************************************************************
**
** Module File:    CFAD13S.src
**
** Service Name:   CFAD13S
**
** Description:   This service will call a DAM to retrieve an entire
**                resource history row given IdResourceHistory.
**
** Environment:   HP-UX V9.0
**                FOUNDATION V2.0 for Unix (Construction, Production)
**                HP-UX Ansi C Compiler
**
** Date Created:  01/02/1996
**
** Programmer:    Ramani Vishnubhotla
**
** Archive Information: $Revision:   1.1  $
**                      $Date:   10 Mar 1999 07:27:28  $
**                      $Modtime:   06 Jan 1999 16:12:46  $
**                      $Author:   pvcs  $
**
** Change History:
**  Date      User      Description
**  --------  --------  --------------------------------------------------
**  03/19/96  VISHNUR   SIR 3911 - To preserve the Date & Time for the History
**                      rows that are created on the same day and to preserve the
**                      current row to be on the TOP always, saved the effective
**                      and end dates times in Generic1 and 5. If efffective
**                      date is changed, the time for it is set to 12:00 AM.
**                      If the End date is changed it's time is set. If any
**                      other field are changed the retrieved time will be
**                      saved.
**  01/06/99  DOUGLACS  SIR#14113 Change NbrRshsOpenSlot to a signed int
**                      so that it negative open slots can be displayed
**                      and user will not get a data access error.
**  03/18/05  Hadjimh   SIR#23327. Add a new field to the Home Information page. This new
**                      field would be stored in the CAPS_RESOURCE table. 1) If the Non-FPS
**                      Adoptive Home checkbox is checked, staff will have to select a
**                      'Certifying Entity'. to indicate the certifying agency
**                      2) This will be a required field when the Non-FPS Adoptive Home
**                      checkbox is checked for a new home. 3) If a user is modifying an
**                      existing Non-FPS Adoptive Home, this new field will be required,
**                      unless the home status is also being changed to 'Pending Closure'
**                      or 'Closed'.
***************************************************************************/

/**************************************************************************
** Service Include Files
***************************************************************************/

/*
** Extern for version control table.
*/






public class Cfad13s {
    CFAD13SO CFAD13S(CFAD13SI cfad13si) {
        CFAD13SO cfad13so = new CFAD13SO();
        ErrorStatus ServiceStatus = null;
        ErrorStatus pServiceStatus = ServiceStatus;
        pServiceStatus.explan_code = 0;
        pServiceStatus.severity = 0;
        int rc = FND_SUCCESS;/* Return code */
        int i210 = 0;
        
        /*
        ** Declare FOUNDATION variables
        */
        
        /*
        ** Declare local variables
        */
        //##  long            rc = 0;
        
        CSES55DI pCSES55DInputRec = null;
        CSES55DO pCSES55DOutputRec = null;
        
        
        /*
        ** Call CSES68D
        */
        rc = ARC_PRFServiceStartTime_TUX(cfad13si.getArchInputStruct());
        
        rc = ARC_UTLGetDateAndTime(cfad13so.getDtWCDDtSystemDate() , 0);
        Arcxmlerrors.PROCESS_TUX_RC_ERROR();
        
        
        /*
        ** Allocate memory for DAM Input and Output Structures
        */
        pCSES55DInputRec = new CSES55DI();
        
        pCSES55DOutputRec = new CSES55DO();
        pCSES55DInputRec.setArchInputStruct(cfad13si.getArchInputStruct());
        pCSES55DInputRec.setUlIdResourceHistory(cfad13si.getUlIdResourceHistory());
        
        /*
        ** Set rc to MSG_DETAIL_DELETED
        */
        rc = cses55dQUERYdam(sqlca, pCSES55DInputRec, pCSES55DOutputRec);
        
        switch (rc) {
            case WtcHelperConstants.SQL_SUCCESS:
                pServiceStatus.severity = FND_SEVERITY_OK;
                pServiceStatus.explan_code = SUCCESS;
                cfad13so.getCCdRshsFaHomeType1()[0] = pCSES55DOutputRec.getCCdRshsFaHomeType1();
                cfad13so.getCCdRshsFaHomeType1()[1] = pCSES55DOutputRec.getCCdRshsFaHomeType2();
                
                cfad13so.getCCdRshsFaHomeType1()[2] = pCSES55DOutputRec.getCCdRshsFaHomeType3();
                cfad13so.getCCdRshsFaHomeType1()[3] = pCSES55DOutputRec.getCCdRshsFaHomeType4();
                cfad13so.getCCdRshsFaHomeType1()[4] = pCSES55DOutputRec.getCCdRshsFaHomeType5();
                cfad13so.getCCdRshsFaHomeType1()[5] = pCSES55DOutputRec.getCCdRshsFaHomeType6();
                cfad13so.getCCdRshsFaHomeType1()[6] = pCSES55DOutputRec.getCCdRshsFaHomeType7();
                cfad13so.setDtDtRshsEffective(pCSES55DOutputRec.getDtDtRshsEffective());
                cfad13so.setDtDtRshsEnd(pCSES55DOutputRec.getDtDtRshsEnd());
                cfad13so.setTmScrTmGeneric1(pCSES55DOutputRec.getTmScrTmGeneric1());
                cfad13so.setTmScrTmGeneric5(pCSES55DOutputRec.getTmScrTmGeneric5());
                cfad13so.setSzCdRshsCategory(pCSES55DOutputRec.getSzCdRshsCategory());
                cfad13so.setSzCdRshsFaHomeStatus(pCSES55DOutputRec.getSzCdRshsFaHomeStatus());
                cfad13so.setUNbrRshsFacilCapacity(pCSES55DOutputRec.getUNbrRshsFacilCapacity());
                cfad13so.setUNbrRshsMaAgeMin(pCSES55DOutputRec.getUNbrRshsMaAgeMin());
                cfad13so.setUNbrRshsMaAgeMax(pCSES55DOutputRec.getUNbrRshsMaAgeMax());
                cfad13so.setUNbrRshsFMAgeMin(pCSES55DOutputRec.getUNbrRshsFMAgeMin());
                cfad13so.setUNbrRshsFMAgeMax(pCSES55DOutputRec.getUNbrRshsFMAgeMax());
                cfad13so.setSzCdRshsClosureRsn(pCSES55DOutputRec.getSzCdRshsClosureRsn());
                cfad13so.setSzCdRshsRecmndReopen(pCSES55DOutputRec.getSzCdRshsRecmndReopen());
                cfad13so.setSzCdRshsInvolClosure(pCSES55DOutputRec.getSzCdRshsInvolClosure());
                
                cfad13so.setSzAddrRshsAttn(pCSES55DOutputRec.getSzAddrRshsAttn());
                
                cfad13so.setSzAddrRshsCity(pCSES55DOutputRec.getSzAddrRshsCity());
                cfad13so.setSzAddrRshsStLn1(pCSES55DOutputRec.getSzAddrRshsStLn1());
                cfad13so.setSzAddrRshsStLn2(pCSES55DOutputRec.getSzAddrRshsStLn2());
                cfad13so.setLAddrRshsZip(pCSES55DOutputRec.getLAddrRshsZip());
                cfad13so.setSzCdRshsCampusType(pCSES55DOutputRec.getSzCdRshsCampusType());
                cfad13so.setSzCdRshsCertBy(pCSES55DOutputRec.getSzCdRshsCertBy());
                cfad13so.setSzCdRshsCnty(pCSES55DOutputRec.getSzCdRshsCnty());
                cfad13so.setSzCdRshsEthnicity(pCSES55DOutputRec.getSzCdRshsEthnicity());
                cfad13so.setSzCdRshsFacilType(pCSES55DOutputRec.getSzCdRshsFacilType());
                cfad13so.setSzCdRshsHub(pCSES55DOutputRec.getSzCdRshsHub());
                cfad13so.setSzCdRshsLanguage(pCSES55DOutputRec.getSzCdRshsLanguage());
                cfad13so.setSzCdRshsMaintainer(pCSES55DOutputRec.getSzCdRshsMaintainer());
                cfad13so.setSzCdRshsMaritalStatus(pCSES55DOutputRec.getSzCdRshsMaritalStatus());
                cfad13so.setSzCdRshsOperBy(pCSES55DOutputRec.getSzCdRshsOperBy());
                cfad13so.setSzCdRshsOwnership(pCSES55DOutputRec.getSzCdRshsOwnership());
                cfad13so.setSzCdRshsPayment(pCSES55DOutputRec.getSzCdRshsPayment());
                cfad13so.setSzCdRshsRegion(pCSES55DOutputRec.getSzCdRshsRegion());
                cfad13so.setSzCdRshsReligion(pCSES55DOutputRec.getSzCdRshsReligion());
                cfad13so.setSzCdRshsRespite(pCSES55DOutputRec.getSzCdRshsRespite());
                cfad13so.setSzCdRshsSchDist(pCSES55DOutputRec.getSzCdRshsSchDist());
                cfad13so.setSzCdRshsSetting(pCSES55DOutputRec.getSzCdRshsSetting());
                cfad13so.setSzCdRshsSourceInquiry(pCSES55DOutputRec.getSzCdRshsSourceInquiry());
                cfad13so.setSzCdRshsState(pCSES55DOutputRec.getSzCdRshsState());
                cfad13so.setSzCdRshsStatus(pCSES55DOutputRec.getSzCdRshsStatus());
                
                cfad13so.setSzCdRshsType(pCSES55DOutputRec.getSzCdRshsType());
                cfad13so.setDtDtRshsCert(pCSES55DOutputRec.getDtDtRshsCert());
                cfad13so.setDtDtRshsClose(pCSES55DOutputRec.getDtDtRshsClose());
                cfad13so.setDtDtRshsMarriage(pCSES55DOutputRec.getDtDtRshsMarriage());
                cfad13so.setUlIdResource(pCSES55DOutputRec.getUlIdResource());
                cfad13so.setUlIdEvent(pCSES55DOutputRec.getUlIdEvent());
                cfad13so.setUlIdStage(pCSES55DOutputRec.getUlIdStage());
                cfad13so.setCIndRshsCareProv(pCSES55DOutputRec.getCIndRshsCareProv());
                cfad13so.setCIndRshsEmergPlace(pCSES55DOutputRec.getCIndRshsEmergPlace());
                cfad13so.setCIndRshsInactive(pCSES55DOutputRec.getCIndRshsInactive());
                cfad13so.setCIndRshsIndivStudy(pCSES55DOutputRec.getCIndRshsIndivStudy());
                
                cfad13so.setCIndRshsNonPrs(pCSES55DOutputRec.getCIndRshsNonPrs());
                cfad13so.setSzCdCertifyEntity(pCSES55DOutputRec.getSzCdCertifyEntity());
                cfad13so.setCIndRshsTransport(pCSES55DOutputRec.getCIndRshsTransport());
                cfad13so.setDNbrRshsAnnualIncome(pCSES55DOutputRec.getDNbrRshsAnnualIncome());
                cfad13so.setLNbrRshsCampusNbr(pCSES55DOutputRec.getLNbrRshsCampusNbr());
                cfad13so.setLNbrRshsFacilAcclaim(pCSES55DOutputRec.getLNbrRshsFacilAcclaim());
                cfad13so.setUNbrRshsIntChildren(pCSES55DOutputRec.getUNbrRshsIntChildren());
                cfad13so.setUNbrRshsIntFeAgeMax(pCSES55DOutputRec.getUNbrRshsIntFeAgeMax());
                cfad13so.setUNbrRshsIntFeAgeMin(pCSES55DOutputRec.getUNbrRshsIntFeAgeMin());
                cfad13so.setUNbrRshsIntMaAgeMax(pCSES55DOutputRec.getUNbrRshsIntMaAgeMax());
                cfad13so.setSNbrRshsOpenSlots(pCSES55DOutputRec.getSNbrRshsOpenSlots());
                
                cfad13so.setSzNbrRshsPhn(pCSES55DOutputRec.getSzNbrRshsPhn());
                
                cfad13so.setLNbrRshsPhoneExtension(pCSES55DOutputRec.getLNbrRshsPhoneExtension());
                cfad13so.setSzNbrRshsVid(pCSES55DOutputRec.getSzNbrRshsVid());
                cfad13so.setSzNmRshsContact(pCSES55DOutputRec.getSzNmRshsContact());
                cfad13so.setSzNmRshsLastUpdate(pCSES55DOutputRec.getSzNmRshsLastUpdate());
                cfad13so.setSzNmRshsResource(pCSES55DOutputRec.getSzNmRshsResource());
                cfad13so.setSzTxtRshsAddrCmnts(pCSES55DOutputRec.getSzTxtRshsAddrCmnts());
                cfad13so.setSzTxtRshsComments(pCSES55DOutputRec.getSzTxtRshsComments());
                cfad13so.setTsLastUpdate(pCSES55DOutputRec.getTsLastUpdate());
                break;
            case NO_DATA_FOUND:
                pServiceStatus.severity = FND_SEVERITY_ERROR;
                pServiceStatus.explan_code = Messages.MSG_DETAIL_DELETED;
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
        ARC_PRFServiceStopTime_TUX(cfad13si.getArchInputStruct() , cfad13so.getArchOutputStruct());
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
                
                
                //  Call CSES68D
                rc = Arcxmlerrors.ARC_ERR_TUX_TPCOMMIT_FAILED;
                Arcxmlerrors.PROCESS_TUX_RC_ERROR();
            }
            userlog("APPL STATUS=%d", pServiceStatus.explan_code);
        }
        return cfad13so;
    }

}
