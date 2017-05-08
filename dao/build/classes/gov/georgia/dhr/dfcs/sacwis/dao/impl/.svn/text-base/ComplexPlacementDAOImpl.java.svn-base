package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import static gov.georgia.dhr.dfcs.sacwis.core.message.Messages.MSG_SUB_GAP_EXISTS_1;
import static gov.georgia.dhr.dfcs.sacwis.core.message.Messages.MSG_SUB_GAP_EXISTS_2;
import static gov.georgia.dhr.dfcs.sacwis.core.message.Messages.MSG_SUB_GAP_EXISTS_3;
import static gov.georgia.dhr.dfcs.sacwis.core.message.Messages.MSG_SUB_PERIOD_OVERLAP_1;
import static gov.georgia.dhr.dfcs.sacwis.core.message.Messages.MSG_SUB_PERIOD_OVERLAP_2;
import static gov.georgia.dhr.dfcs.sacwis.core.message.Messages.SQL_NOT_FOUND;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*Change History:
  *   Date        User            Description
  *   ----------  --------------  --------------------------------------------------
  *   02/11/2009  mxpatel         STGAP00012392: Added custom validations for new placement type - "Other Adoptive Home"
  *   04/22/09     cwells         STGAP00009847: Removing references to AFCAR widgits.  Since those sections
  *                               Are being removed from the page.  
  *   11/25/2009  bgehlot         41275 MR-057 Added new fields for APPLA in addComplex, insertPlacementRunaway, 
  *                               insertPlacementNoIdContractAgencyFacilNoWaiver,
  *                               insertPlacementNoIdContractAgencyFacil,insertPlacementNoIdContractAgencyNoWaiver, 
  *                               insertPlacementNoIdContractAgency, insertPlacementNoIdContractNoWaiver, 
  *                               insertPlacementNoIdContract,insertPlacement
  *   09/22/2011  charden         STGAP00017058 - adding code to allow certification of placement information page  
  *                               
  *   
*/
public class ComplexPlacementDAOImpl extends BaseDAOImpl implements ComplexPlacementDAO {
  private PlacementDAO placementDAO = null;

  private EventDAO eventDAO = null;

  private StageDAO stageDAO = null;

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  private boolean isSameDay(Date d1, Date d2) {
    GregorianCalendar gc1 = new GregorianCalendar();
    gc1.setTime(d1);
    GregorianCalendar gc2 = new GregorianCalendar();
    gc2.setTime(d2);

    return (gc1.get(Calendar.DAY_OF_MONTH) == gc2.get(Calendar.DAY_OF_MONTH)
            && gc1.get(Calendar.MONTH) == gc2.get(Calendar.MONTH) && gc1.get(Calendar.YEAR) == gc2.get(Calendar.YEAR));
  }

  //MR-057 Added new fields for APPLA
  //STGAP00017058 - added new parameter to track placement log certification and passing this date to all insert statements
  public int addComplex(int idStage, int idCase, Date dtPlcmtPermEff, int idPlcmtEvent, int idPlcmtAdult,
                        int idPlcmtChild, int idContract, int idRsrcAgency, int idRsrcFacil, String cdAddrPlcmtCity,
                        String cdAddrPlcmtCnty, String cdAddrPlcmtLn1, String cdAddrPlcmtLn2, String cdAddrPlcmtSt,
                        String cdAddrPlcmtZip, String cdPlcmtInfo1, String cdPlcmtInfo2, String cdPlcmtInfo3,
                        String cdPlcmtInfo4, String cdPlcmtInfo5, String cdPlcmtInfo6, String cdPlcmtInfo7,
                        String cdPlcmtInfo8, String cdPlcmtInfo9, String cdPlcmtInfo10, String cdPlcmtInfo11,
                        String cdPlcmtInfo12, String cdPlcmtInfo13, String cdPlcmtInfo14, String cdPlcmtInfo15,
                        String cdPlcmtInfo16, String cdPlcmtInfo17, String cdPlcmtLivArr, String cdPlcmtRemovalRsn,
                        String cdPlcmtActPlanned, String cdPlcmtType, String cdPlcmtService,
                        Date dtPlcmtCaregvrDiscuss, Date dtPlcmtChildDiscuss, Date dtPlcmtChildPlan,
                        Date dtPlcmtEducLog, Date dtPlcmtEnd, Date dtPlcmtMeddevHistory, Date dtPlcmtParentsNotif,
                        Date dtPlcmtPreplaceVisit, Date dtPlcmtSchoolRecords, Date dtPlcmtStart,
                        String indPlcmtContCntct, String indPlcmtEducLog, String indPlcmetEmerg,
                        String indPlcmtNotApplic, String indPlcmtSchoolDoc, String cdNbrPlcmtPhoneExt,
                        String cdNbrPlcmtTelephone, String cdNmPlcmtAgency, String cdNmPlcmtContact,
                        String cdNmPlcmtFacil, String cdNmPlcmtPersonFull, String indPlcmtWriteHistory,
                        String cdTxtPlcmtAddrComment, String cdTxtPlcmtDiscussion, String cdTxtPlcmtRemovalRsn,
                        String sysIndPrfrmValidation, String szCdActAtt, String szCdContactedBy, int ulContactedById,
                        String selSzCdMethod, String cbxIndTempReplacement, String szCdTempPlcmtType,
                        String szTxtTempPlcmtCmnts, String cbxIndWaiverRequired, String rbIndCaseHome,
                        int dspUlWaiverId, Date dtDateLastDischarged, String ulMatch, Date dtPermReportDueDate,
                        String cbxBoardingCounty, String cbxIndTrialHomeVisit, Date dtCrtBeginDate, Date dtCrtEndDate,
                        String rbIndPlcmtChPlacedFr, String rbIndPlcmtChPlacedBy, String szCdChildTransitionCmnts,
                        String rbIndPlcmtSafe, String rbIndPlcmtLeastRestrict, String rbIndPlcmtFamilyLike,
                        String rbIndPlcmtAppropriate, String rbIndPlcmtCloseProxPar, String rbIndPlcmtCloseProxSchool,
                        String rbIndConsistent, String szTxtNoExplainCheckList, String rbIndExpTrauma,
                        String szTxtYesExpTrauma, String rbIndStaySiblings, int nbrSibinCare, int nbrSibPlaced,
                        String szCdSibRsn, String szCdCCFARsn, String szCdNoReasonCmnts, String rbIndPlcmtMatchCCFA,
                        String szCdPlcmtMatchCCFAReasonCmnts, String rbIndSuppSupervision,
                        String szCdSuppSupervisionCmnts, Date txtDtPsychInfo, String txtSzNmPsychinfo,
                        Date txtDtCasePsychInfo, String txtSzNmCasePsychinfo, Date txtDtMedInfo, String txtSzNmMedinfo,
                        Date txtDtCaseMedInfo, String txtSzNmCaseMedinfo, Date txtDtEduInfo, String txtSzNmEduinfo,
                        String cbxIndNAEduInfo, Date txtDtCaseEduInfo, String txtSzNmCaseEduinfo,
                        String cbxIndNACaseEduInfo, String txtaSzTxtPlcmtDocuments, String txtaSzTxtPlcmtCmntsDocuments,
                        String indLTFCPlacement, Date dtAgreementSigned, String indConnectedAdult, int idPersonConnected, Date dtLastViewPlcmtLog) {
    if (eventDAO.countEventRowsByIdStage(idStage) == 0) {
      return 0;
    }
    //STGAP00006420: Removed check as part of the overlap sqls clean up
    /*
     * if (!CodesTables.CTMPLTYP_COR.equals(szCdTempPlcmtType) && !CodesTables.CTMPLTYP_REN.equals(szCdTempPlcmtType) &&
     * !CodesTables.CTMPLTYP_RED.equals(szCdTempPlcmtType)) {
     */
    // see if there is any record for this person; if not, no need for validation steps
    List<Integer> listPlcmt = placementDAO.findIdPlcmtEventByPersonByIdPlcmtChild(idCase, idPlcmtChild,
                                                                                  cdPlcmtActPlanned);
    if (listPlcmt != null && listPlcmt.size() > 0) {
      if (CodesTables.CPLCMTAC_A.equals(cdPlcmtActPlanned)) {
      //STGAP00006420: Added check to see if the incoming placement is a temporary type
      //of Concurrent or Respite
        boolean indCurrTemp = false;
        if (CodesTables.CTMPLTYP_COR.equals(szCdTempPlcmtType) || CodesTables.CTMPLTYP_REN.equals(szCdTempPlcmtType)
            || CodesTables.CTMPLTYP_RED.equals(szCdTempPlcmtType)) {
          indCurrTemp = true;
        }

        /***************************************************************************************************************
         * Validation 1. Check if new record overlaps other records on LEFT (works whether new record overlaps 1 or more
         * existing records)
         **************************************************************************************************************/
        //STGAP00006420:Modified the signature of the sql and added code as part of the overlap messages clean up.
        //The return list will now return a map instead of an integer. The map contains placement evnet Id and the temporary type. 
        List<Map> listLeft = placementDAO.findIdPlacmtEventByIdPlcmtChildNoOverlap(idCase, idPlcmtChild,
                                                                                   cdPlcmtActPlanned, dtPlcmtStart,
                                                                                   dtPlcmtEnd);
        if (listLeft != null) {
          for (Iterator<Map> it = listLeft.iterator(); it.hasNext();) {
            Map map = it.next();
            if (map != null) {
              String tempType = (String) map.get("cdTempType");
              int idPlEvent = (Integer) map.get("idPlcmtEvent") == null ? 0 : (Integer) map.get("idPlcmtEvent");
              boolean indtemp = false;
              if (CodesTables.CTMPLTYP_COR.equals(tempType) || CodesTables.CTMPLTYP_REN.equals(tempType)
                  || CodesTables.CTMPLTYP_RED.equals(tempType)) {
                indtemp = true;
              }
              if ((indCurrTemp && indtemp) || (!indCurrTemp && !indtemp)) {
                /*
                 * * Find the number of rows for this * id_plcmnt_event that has open subcare stages that * are not
                 * end-dated. If any found, exit
                 */

                long countStages = stageDAO.countCdStage(idPlEvent);

                if (countStages > 0 && !DateHelper.MAX_JAVA_DATE.equals(dtPlcmtEnd)) {
                  return MSG_SUB_PERIOD_OVERLAP_1;
                }
                //STGAP00007835: Added this condition to give the appropriate message when the 
                //end date is not entered and start date is before the start date of the 
                //existing placement.
                else if(countStages > 0 && DateHelper.MAX_JAVA_DATE.equals(dtPlcmtEnd)){
                  return MSG_SUB_PERIOD_OVERLAP_2;
                }

                /*
                 * * The subcare stage is closed and check if the * placement is end dated. If not, exit.
                 */
                long countPlcmt = placementDAO.countPlacementByIdEvent(idPlEvent);

                if (countPlcmt > 0) {
                  return MSG_SUB_PERIOD_OVERLAP_1;
                }
              }
            }
          }
        }

        // =================================================================
        // VALIDATE 2: Check if new records overlaps other records on RIGHT
        // (works whether new record overlaps 1 or more existing records
        // Placements that start and end on the same day are not included
        // in the overlap/gap validation.
        // =================================================================

        //STGAP00006420:Modified the signature of the sql and added code as part of the overlap messages clean up.
        //The return list will now return a map instead of an integer. The map contains placement evnet Id and the temporary type. 
        Map map = eventDAO.findEventIdPlcmtEventByDtPlcmtStart(idCase, idPlcmtChild, cdPlcmtActPlanned,
                                                                        dtPlcmtStart, dtPlcmtEnd);

        if (map != null) {
          String tempType = (String) map.get("cdTempType");
          int idPlEvent = (Integer) map.get("idPlcmtEvent") == null ? 0 : (Integer) map.get("idPlcmtEvent");
          boolean indtemp = false;
          if (CodesTables.CTMPLTYP_COR.equals(tempType) || CodesTables.CTMPLTYP_REN.equals(tempType)
              || CodesTables.CTMPLTYP_RED.equals(tempType)) {
            indtemp = true;
          }
          if (idPlEvent > 0 && ((indCurrTemp && indtemp) || (!indCurrTemp && !indtemp))) {
            return MSG_SUB_PERIOD_OVERLAP_2;
          }
        }

        // ====================================================================
        // VALIDATE 3: Check if new records is either identical OR within
        // a record
        // ====================================================================

        //STGAP00006420:Modified the signature of the sql and added code as part of the overlap messages clean up.
        //The return list will now return a map instead of an integer. The map contains placement evnet Id and the temporary type. 
        List<Map> listOr = eventDAO.findEventIdPlcmtEventByDtPlcmtStartAndEnd(idCase, idPlcmtChild, cdPlcmtActPlanned,
                                                                              dtPlcmtStart, dtPlcmtEnd);
        if (listOr != null && !listOr.isEmpty() && listOr.size() > 0) {
          for (Iterator<Map> itor = listOr.iterator(); itor.hasNext();) {
            Map mapList = itor.next();
            if (mapList != null) {
              String tempType = (String) mapList.get("cdTempType");
              int idPlEvent = (Integer) mapList.get("idPlcmtEvent") == null ? 0 : (Integer) mapList.get("idPlcmtEvent");
              boolean indtemp = false;
              if (CodesTables.CTMPLTYP_COR.equals(tempType) || CodesTables.CTMPLTYP_REN.equals(tempType)
                  || CodesTables.CTMPLTYP_RED.equals(tempType)) {
                indtemp = true;
              }
              if ((indCurrTemp && indtemp) || (!indCurrTemp && !indtemp)) {
                /*
                 * Check if there are any open placements in open stages. If the stage is closed, it does not matter if
                 * the placement does not have an end-date.
                 */
                long countSub = stageDAO.countCdStage(idPlEvent);
                if (countSub > 0) {
                  return MSG_SUB_PERIOD_OVERLAP_1;
                }
              }
            }
          }
        }
      }
      //STGAP00008741: Added the check to eliminate the concurrent, and respite placements from Gap check.
      boolean indConcur = false;
      if(CodesTables.CTMPLTYP_COR.equals(szCdTempPlcmtType) || CodesTables.CTMPLTYP_REN.equals(szCdTempPlcmtType)
                      || CodesTables.CTMPLTYP_RED.equals(szCdTempPlcmtType)){
        indConcur = true;
      }
      List<String> tempTypeList = new ArrayList<String>();
      tempTypeList.add(CodesTables.CTMPLTYP_COR);
      tempTypeList.add(CodesTables.CTMPLTYP_REN);
      tempTypeList.add(CodesTables.CTMPLTYP_RED);
      //STGAP00006420:Added code to bring back the Gap check functionality
      if (ArchitectureConstants.Y.equals(sysIndPrfrmValidation) && !indConcur) {
        String stDate = DateHelper.toSqlString(dtPlcmtStart);
        Object[] map1 = placementDAO.findIdPlcmtEventDtPlcmtEndByMaxDtPlcmtEnd(idPlcmtChild, idCase, stDate);
        boolean leftGapExists = false;
        if (map1 != null && map1.length > 0) {
          leftGapExists = true; 
        }
        boolean rightGapExists = false;
        if (!DateHelper.MAX_JAVA_DATE.equals(dtPlcmtEnd)) {
          String endDate = DateHelper.toSqlString(dtPlcmtEnd);
          Object[] map2 = placementDAO.findIdPlcmtEventDtPlcmtEndByMinDtPlcmtStart(idPlcmtChild, idCase, endDate);
          if (map2 != null && map2.length > 0) {
            rightGapExists = true;
          }
        }
        if (leftGapExists && rightGapExists) {
          return MSG_SUB_GAP_EXISTS_3;
        } else if (leftGapExists) {
          return MSG_SUB_GAP_EXISTS_1;
        } else if (rightGapExists) {
          return MSG_SUB_GAP_EXISTS_2;
        }
      }
    }
    // }

    if (CodesTables.CPLMNTYP_RNA.equals(cdPlcmtType)
        || ((CodesTables.CPLMNTYP_HOS.equals(cdPlcmtType) || CodesTables.CPLMNTYP_YDC.equals(cdPlcmtType)
             || CodesTables.CPLMNTYP_OTR.equals(cdPlcmtType) || CodesTables.CPLMNTYP_OTA.equals(cdPlcmtType)) && idRsrcFacil == 0))//mxpatel 12392 
    { //MR-057 Added new fields for APPLA
      placementDAO.insertPlacementRunaway(idCase, dtPlcmtPermEff, idPlcmtEvent, idPlcmtChild, cdAddrPlcmtCity, cdAddrPlcmtCnty,
                                          cdAddrPlcmtLn1, cdAddrPlcmtLn2, cdAddrPlcmtSt, cdAddrPlcmtZip, cdPlcmtInfo1,
                                          cdPlcmtInfo2, cdPlcmtInfo3, cdPlcmtInfo4, cdPlcmtInfo5, cdPlcmtInfo6,
                                          cdPlcmtInfo7, cdPlcmtInfo8, cdPlcmtInfo9, cdPlcmtInfo10, cdPlcmtInfo11,
                                          cdPlcmtInfo12, cdPlcmtInfo13, cdPlcmtInfo14, cdPlcmtInfo15, cdPlcmtInfo16,
                                          cdPlcmtInfo17, cdPlcmtLivArr, cdPlcmtRemovalRsn, cdPlcmtActPlanned,
                                          cdPlcmtType, cdPlcmtService, dtPlcmtCaregvrDiscuss, dtPlcmtChildDiscuss,
                                          dtPlcmtChildPlan, dtPlcmtEducLog, dtPlcmtEnd, dtPlcmtMeddevHistory,
                                          dtPlcmtParentsNotif, dtPlcmtPreplaceVisit, dtPlcmtSchoolRecords,
                                          dtPlcmtStart, indPlcmtContCntct, indPlcmtEducLog, indPlcmetEmerg,
                                          indPlcmtNotApplic, indPlcmtSchoolDoc, cdNbrPlcmtPhoneExt,
                                          cdNbrPlcmtTelephone, cdNmPlcmtAgency, cdNmPlcmtContact, cdNmPlcmtFacil,
                                          cdNmPlcmtPersonFull, indPlcmtWriteHistory, cdTxtPlcmtAddrComment,
                                          cdTxtPlcmtDiscussion, cdTxtPlcmtRemovalRsn, szCdActAtt, ulContactedById,
                                          selSzCdMethod, cbxIndTempReplacement, szCdTempPlcmtType, szTxtTempPlcmtCmnts,
                                          cbxIndWaiverRequired, rbIndCaseHome, dtDateLastDischarged, ulMatch,
                                          dtPermReportDueDate, cbxBoardingCounty, cbxIndTrialHomeVisit, dtCrtBeginDate,
                                          dtCrtEndDate, rbIndPlcmtChPlacedFr, rbIndPlcmtChPlacedBy,
                                          szCdChildTransitionCmnts, rbIndPlcmtSafe, rbIndPlcmtLeastRestrict,
                                          rbIndPlcmtFamilyLike, rbIndPlcmtAppropriate, rbIndPlcmtCloseProxPar,
                                          rbIndPlcmtCloseProxSchool, rbIndConsistent, szTxtNoExplainCheckList,
                                          rbIndExpTrauma, szTxtYesExpTrauma, rbIndStaySiblings, nbrSibinCare,
                                          nbrSibPlaced, szCdSibRsn, szCdCCFARsn, szCdNoReasonCmnts,
                                          rbIndPlcmtMatchCCFA, szCdPlcmtMatchCCFAReasonCmnts, rbIndSuppSupervision,
                                          szCdSuppSupervisionCmnts, txtDtPsychInfo, txtSzNmPsychinfo,
                                          txtDtCasePsychInfo, txtSzNmCasePsychinfo, txtDtMedInfo, txtSzNmMedinfo,
                                          txtDtCaseMedInfo, txtSzNmCaseMedinfo, txtDtEduInfo, txtSzNmEduinfo,
                                          cbxIndNAEduInfo, txtDtCaseEduInfo, txtSzNmCaseEduinfo, cbxIndNACaseEduInfo,
                                          txtaSzTxtPlcmtDocuments, txtaSzTxtPlcmtCmntsDocuments,indLTFCPlacement, dtAgreementSigned, 
                                          indConnectedAdult, (idPersonConnected == 0 ? null : idPersonConnected), dtLastViewPlcmtLog );
    } else if (idContract == 0 && idRsrcAgency == 0 && idRsrcFacil == 0 && dspUlWaiverId == 0) {
      //MR-057 Added new fields for APPLA
      placementDAO.insertPlacementNoIdContractAgencyFacilNoWaiver(idCase, dtPlcmtPermEff, idPlcmtEvent, idPlcmtAdult,
                                                                  idPlcmtChild, cdAddrPlcmtCity, cdAddrPlcmtCnty,
                                                                  cdAddrPlcmtLn1, cdAddrPlcmtLn2, cdAddrPlcmtSt,
                                                                  cdAddrPlcmtZip, cdPlcmtInfo1, cdPlcmtInfo2,
                                                                  cdPlcmtInfo3, cdPlcmtInfo4, cdPlcmtInfo5,
                                                                  cdPlcmtInfo6, cdPlcmtInfo7, cdPlcmtInfo8,
                                                                  cdPlcmtInfo9, cdPlcmtInfo10, cdPlcmtInfo11,
                                                                  cdPlcmtInfo12, cdPlcmtInfo13, cdPlcmtInfo14,
                                                                  cdPlcmtInfo15, cdPlcmtInfo16, cdPlcmtInfo17,
                                                                  cdPlcmtLivArr, cdPlcmtRemovalRsn, cdPlcmtActPlanned,
                                                                  cdPlcmtType, cdPlcmtService, dtPlcmtCaregvrDiscuss,
                                                                  dtPlcmtChildDiscuss, dtPlcmtChildPlan,
                                                                  dtPlcmtEducLog, dtPlcmtEnd, dtPlcmtMeddevHistory,
                                                                  dtPlcmtParentsNotif, dtPlcmtPreplaceVisit,
                                                                  dtPlcmtSchoolRecords, dtPlcmtStart,
                                                                  indPlcmtContCntct, indPlcmtEducLog, indPlcmetEmerg,
                                                                  indPlcmtNotApplic, indPlcmtSchoolDoc,
                                                                  cdNbrPlcmtPhoneExt, cdNbrPlcmtTelephone,
                                                                  cdNmPlcmtAgency, cdNmPlcmtContact, cdNmPlcmtFacil,
                                                                  cdNmPlcmtPersonFull, indPlcmtWriteHistory,
                                                                  cdTxtPlcmtAddrComment, cdTxtPlcmtDiscussion,
                                                                  cdTxtPlcmtRemovalRsn, szCdActAtt, ulContactedById,
                                                                  selSzCdMethod, cbxIndTempReplacement,
                                                                  szCdTempPlcmtType, szTxtTempPlcmtCmnts,
                                                                  cbxIndWaiverRequired, rbIndCaseHome,
                                                                  dtDateLastDischarged, ulMatch, dtPermReportDueDate,
                                                                  cbxBoardingCounty, cbxIndTrialHomeVisit,
                                                                  dtCrtBeginDate, dtCrtEndDate, rbIndPlcmtChPlacedFr,
                                                                  rbIndPlcmtChPlacedBy, szCdChildTransitionCmnts,
                                                                  rbIndPlcmtSafe, rbIndPlcmtLeastRestrict,
                                                                  rbIndPlcmtFamilyLike, rbIndPlcmtAppropriate,
                                                                  rbIndPlcmtCloseProxPar, rbIndPlcmtCloseProxSchool,
                                                                  rbIndConsistent, szTxtNoExplainCheckList,
                                                                  rbIndExpTrauma, szTxtYesExpTrauma, rbIndStaySiblings,
                                                                  nbrSibinCare, nbrSibPlaced, szCdSibRsn, szCdCCFARsn,
                                                                  szCdNoReasonCmnts, rbIndPlcmtMatchCCFA,
                                                                  szCdPlcmtMatchCCFAReasonCmnts, rbIndSuppSupervision,
                                                                  szCdSuppSupervisionCmnts, txtDtPsychInfo,
                                                                  txtSzNmPsychinfo, txtDtCasePsychInfo,
                                                                  txtSzNmCasePsychinfo, txtDtMedInfo, txtSzNmMedinfo,
                                                                  txtDtCaseMedInfo, txtSzNmCaseMedinfo, txtDtEduInfo,
                                                                  txtSzNmEduinfo, cbxIndNAEduInfo, txtDtCaseEduInfo,
                                                                  txtSzNmCaseEduinfo, cbxIndNACaseEduInfo,
                                                                  txtaSzTxtPlcmtDocuments,
                                                                  txtaSzTxtPlcmtCmntsDocuments, indLTFCPlacement, dtAgreementSigned, 
                                                                  indConnectedAdult, (idPersonConnected == 0 ? null : idPersonConnected), dtLastViewPlcmtLog);
    } // New added 1
    else if (idContract == 0 && idRsrcAgency == 0 && idRsrcFacil == 0) {
      //MR-057 Added new fields for APPLA
      placementDAO.insertPlacementNoIdContractAgencyFacil(idCase, dtPlcmtPermEff, idPlcmtEvent, idPlcmtAdult, idPlcmtChild,
                                                          cdAddrPlcmtCity, cdAddrPlcmtCnty, cdAddrPlcmtLn1,
                                                          cdAddrPlcmtLn2, cdAddrPlcmtSt, cdAddrPlcmtZip, cdPlcmtInfo1,
                                                          cdPlcmtInfo2, cdPlcmtInfo3, cdPlcmtInfo4, cdPlcmtInfo5,
                                                          cdPlcmtInfo6, cdPlcmtInfo7, cdPlcmtInfo8, cdPlcmtInfo9,
                                                          cdPlcmtInfo10, cdPlcmtInfo11, cdPlcmtInfo12, cdPlcmtInfo13,
                                                          cdPlcmtInfo14, cdPlcmtInfo15, cdPlcmtInfo16, cdPlcmtInfo17,
                                                          cdPlcmtLivArr, cdPlcmtRemovalRsn, cdPlcmtActPlanned,
                                                          cdPlcmtType, cdPlcmtService, dtPlcmtCaregvrDiscuss,
                                                          dtPlcmtChildDiscuss, dtPlcmtChildPlan, dtPlcmtEducLog,
                                                          dtPlcmtEnd, dtPlcmtMeddevHistory, dtPlcmtParentsNotif,
                                                          dtPlcmtPreplaceVisit, dtPlcmtSchoolRecords, dtPlcmtStart,
                                                          indPlcmtContCntct, indPlcmtEducLog, indPlcmetEmerg,
                                                          indPlcmtNotApplic, indPlcmtSchoolDoc, cdNbrPlcmtPhoneExt,
                                                          cdNbrPlcmtTelephone, cdNmPlcmtAgency, cdNmPlcmtContact,
                                                          cdNmPlcmtFacil, cdNmPlcmtPersonFull, indPlcmtWriteHistory,
                                                          cdTxtPlcmtAddrComment, cdTxtPlcmtDiscussion,
                                                          cdTxtPlcmtRemovalRsn, szCdActAtt, ulContactedById,
                                                          selSzCdMethod, cbxIndTempReplacement, szCdTempPlcmtType,
                                                          szTxtTempPlcmtCmnts, cbxIndWaiverRequired, rbIndCaseHome,
                                                          dspUlWaiverId, dtDateLastDischarged, ulMatch,
                                                          dtPermReportDueDate, cbxBoardingCounty, cbxIndTrialHomeVisit,
                                                          dtCrtBeginDate, dtCrtEndDate, rbIndPlcmtChPlacedFr,
                                                          rbIndPlcmtChPlacedBy, szCdChildTransitionCmnts,
                                                          rbIndPlcmtSafe, rbIndPlcmtLeastRestrict,
                                                          rbIndPlcmtFamilyLike, rbIndPlcmtAppropriate,
                                                          rbIndPlcmtCloseProxPar, rbIndPlcmtCloseProxSchool,
                                                          rbIndConsistent, szTxtNoExplainCheckList, rbIndExpTrauma,
                                                          szTxtYesExpTrauma, rbIndStaySiblings, nbrSibinCare,
                                                          nbrSibPlaced, szCdSibRsn, szCdCCFARsn, szCdNoReasonCmnts,
                                                          rbIndPlcmtMatchCCFA, szCdPlcmtMatchCCFAReasonCmnts,
                                                          rbIndSuppSupervision, szCdSuppSupervisionCmnts,
                                                          txtDtPsychInfo, txtSzNmPsychinfo, txtDtCasePsychInfo,
                                                          txtSzNmCasePsychinfo, txtDtMedInfo, txtSzNmMedinfo,
                                                          txtDtCaseMedInfo, txtSzNmCaseMedinfo, txtDtEduInfo,
                                                          txtSzNmEduinfo, cbxIndNAEduInfo, txtDtCaseEduInfo,
                                                          txtSzNmCaseEduinfo, cbxIndNACaseEduInfo,
                                                          txtaSzTxtPlcmtDocuments, txtaSzTxtPlcmtCmntsDocuments, indLTFCPlacement, 
                                                          dtAgreementSigned, indConnectedAdult, 
                                                          (idPersonConnected == 0 ? null : idPersonConnected), dtLastViewPlcmtLog);
    } else if (idContract == 0 && idRsrcAgency == 0 && dspUlWaiverId == 0) {
      //MR-057 Added new fields for APPLA
      placementDAO.insertPlacementNoIdContractAgencyNoWaiver(idCase, dtPlcmtPermEff, idPlcmtEvent, idPlcmtAdult, idPlcmtChild,
                                                             idRsrcFacil, cdAddrPlcmtCity, cdAddrPlcmtCnty,
                                                             cdAddrPlcmtLn1, cdAddrPlcmtLn2, cdAddrPlcmtSt,
                                                             cdAddrPlcmtZip, cdPlcmtInfo1, cdPlcmtInfo2, cdPlcmtInfo3,
                                                             cdPlcmtInfo4, cdPlcmtInfo5, cdPlcmtInfo6, cdPlcmtInfo7,
                                                             cdPlcmtInfo8, cdPlcmtInfo9, cdPlcmtInfo10, cdPlcmtInfo11,
                                                             cdPlcmtInfo12, cdPlcmtInfo13, cdPlcmtInfo14,
                                                             cdPlcmtInfo15, cdPlcmtInfo16, cdPlcmtInfo17,
                                                             cdPlcmtLivArr, cdPlcmtRemovalRsn, cdPlcmtActPlanned,
                                                             cdPlcmtType, cdPlcmtService, dtPlcmtCaregvrDiscuss,
                                                             dtPlcmtChildDiscuss, dtPlcmtChildPlan, dtPlcmtEducLog,
                                                             dtPlcmtEnd, dtPlcmtMeddevHistory, dtPlcmtParentsNotif,
                                                             dtPlcmtPreplaceVisit, dtPlcmtSchoolRecords, dtPlcmtStart,
                                                             indPlcmtContCntct, indPlcmtEducLog, indPlcmetEmerg,
                                                             indPlcmtNotApplic, indPlcmtSchoolDoc, cdNbrPlcmtPhoneExt,
                                                             cdNbrPlcmtTelephone, cdNmPlcmtAgency, cdNmPlcmtContact,
                                                             cdNmPlcmtFacil, cdNmPlcmtPersonFull, indPlcmtWriteHistory,
                                                             cdTxtPlcmtAddrComment, cdTxtPlcmtDiscussion,
                                                             cdTxtPlcmtRemovalRsn, szCdActAtt, ulContactedById,
                                                             selSzCdMethod, cbxIndTempReplacement, szCdTempPlcmtType,
                                                             szTxtTempPlcmtCmnts, cbxIndWaiverRequired, rbIndCaseHome,
                                                             dtDateLastDischarged, ulMatch, dtPermReportDueDate,
                                                             cbxBoardingCounty, cbxIndTrialHomeVisit, dtCrtBeginDate,
                                                             dtCrtEndDate, rbIndPlcmtChPlacedFr, rbIndPlcmtChPlacedBy,
                                                             szCdChildTransitionCmnts, rbIndPlcmtSafe,
                                                             rbIndPlcmtLeastRestrict, rbIndPlcmtFamilyLike,
                                                             rbIndPlcmtAppropriate, rbIndPlcmtCloseProxPar,
                                                             rbIndPlcmtCloseProxSchool, rbIndConsistent,
                                                             szTxtNoExplainCheckList, rbIndExpTrauma,
                                                             szTxtYesExpTrauma, rbIndStaySiblings, nbrSibinCare,
                                                             nbrSibPlaced, szCdSibRsn, szCdCCFARsn, szCdNoReasonCmnts,
                                                             rbIndPlcmtMatchCCFA, szCdPlcmtMatchCCFAReasonCmnts,
                                                             rbIndSuppSupervision, szCdSuppSupervisionCmnts,
                                                             txtDtPsychInfo, txtSzNmPsychinfo, txtDtCasePsychInfo,
                                                             txtSzNmCasePsychinfo, txtDtMedInfo, txtSzNmMedinfo,
                                                             txtDtCaseMedInfo, txtSzNmCaseMedinfo, txtDtEduInfo,
                                                             txtSzNmEduinfo, cbxIndNAEduInfo, txtDtCaseEduInfo,
                                                             txtSzNmCaseEduinfo, cbxIndNACaseEduInfo,
                                                             txtaSzTxtPlcmtDocuments, txtaSzTxtPlcmtCmntsDocuments, 
                                                             indLTFCPlacement, dtAgreementSigned, indConnectedAdult, 
                                                             (idPersonConnected == 0 ? null : idPersonConnected), dtLastViewPlcmtLog);
    }// New Added 2
    else if (idContract == 0 && idRsrcAgency == 0) {
      //MR-057 Added new fields for APPLA
      placementDAO.insertPlacementNoIdContractAgency(idCase, dtPlcmtPermEff, idPlcmtEvent, idPlcmtAdult, idPlcmtChild,
                                                     idRsrcFacil, cdAddrPlcmtCity, cdAddrPlcmtCnty, cdAddrPlcmtLn1,
                                                     cdAddrPlcmtLn2, cdAddrPlcmtSt, cdAddrPlcmtZip, cdPlcmtInfo1,
                                                     cdPlcmtInfo2, cdPlcmtInfo3, cdPlcmtInfo4, cdPlcmtInfo5,
                                                     cdPlcmtInfo6, cdPlcmtInfo7, cdPlcmtInfo8, cdPlcmtInfo9,
                                                     cdPlcmtInfo10, cdPlcmtInfo11, cdPlcmtInfo12, cdPlcmtInfo13,
                                                     cdPlcmtInfo14, cdPlcmtInfo15, cdPlcmtInfo16, cdPlcmtInfo17,
                                                     cdPlcmtLivArr, cdPlcmtRemovalRsn, cdPlcmtActPlanned, cdPlcmtType,
                                                     cdPlcmtService, dtPlcmtCaregvrDiscuss, dtPlcmtChildDiscuss,
                                                     dtPlcmtChildPlan, dtPlcmtEducLog, dtPlcmtEnd,
                                                     dtPlcmtMeddevHistory, dtPlcmtParentsNotif, dtPlcmtPreplaceVisit,
                                                     dtPlcmtSchoolRecords, dtPlcmtStart, indPlcmtContCntct,
                                                     indPlcmtEducLog, indPlcmetEmerg, indPlcmtNotApplic,
                                                     indPlcmtSchoolDoc, cdNbrPlcmtPhoneExt, cdNbrPlcmtTelephone,
                                                     cdNmPlcmtAgency, cdNmPlcmtContact, cdNmPlcmtFacil,
                                                     cdNmPlcmtPersonFull, indPlcmtWriteHistory, cdTxtPlcmtAddrComment,
                                                     cdTxtPlcmtDiscussion, cdTxtPlcmtRemovalRsn, szCdActAtt,
                                                     ulContactedById, selSzCdMethod, cbxIndTempReplacement,
                                                     szCdTempPlcmtType, szTxtTempPlcmtCmnts, cbxIndWaiverRequired,
                                                     rbIndCaseHome, dspUlWaiverId, dtDateLastDischarged, ulMatch,
                                                     dtPermReportDueDate, cbxBoardingCounty, cbxIndTrialHomeVisit,
                                                     dtCrtBeginDate, dtCrtEndDate, rbIndPlcmtChPlacedFr,
                                                     rbIndPlcmtChPlacedBy, szCdChildTransitionCmnts, rbIndPlcmtSafe,
                                                     rbIndPlcmtLeastRestrict, rbIndPlcmtFamilyLike,
                                                     rbIndPlcmtAppropriate, rbIndPlcmtCloseProxPar,
                                                     rbIndPlcmtCloseProxSchool, rbIndConsistent,
                                                     szTxtNoExplainCheckList, rbIndExpTrauma, szTxtYesExpTrauma,
                                                     rbIndStaySiblings, nbrSibinCare, nbrSibPlaced, szCdSibRsn,
                                                     szCdCCFARsn, szCdNoReasonCmnts, rbIndPlcmtMatchCCFA,
                                                     szCdPlcmtMatchCCFAReasonCmnts, rbIndSuppSupervision,
                                                     szCdSuppSupervisionCmnts, txtDtPsychInfo, txtSzNmPsychinfo,
                                                     txtDtCasePsychInfo, txtSzNmCasePsychinfo, txtDtMedInfo,
                                                     txtSzNmMedinfo, txtDtCaseMedInfo, txtSzNmCaseMedinfo,
                                                     txtDtEduInfo, txtSzNmEduinfo, cbxIndNAEduInfo, txtDtCaseEduInfo,
                                                     txtSzNmCaseEduinfo, cbxIndNACaseEduInfo, txtaSzTxtPlcmtDocuments,
                                                     txtaSzTxtPlcmtCmntsDocuments, indLTFCPlacement, dtAgreementSigned, 
                                                     indConnectedAdult, (idPersonConnected == 0 ? null : idPersonConnected), dtLastViewPlcmtLog);
    } else if (idContract == 0 && dspUlWaiverId == 0) {
      //MR-057 Added new fields for APPLA
      placementDAO.insertPlacementNoIdContractNoWaiver(idCase, dtPlcmtPermEff, idPlcmtEvent, idPlcmtAdult, idPlcmtChild,
                                                       idRsrcAgency, idRsrcFacil, cdAddrPlcmtCity, cdAddrPlcmtCnty,
                                                       cdAddrPlcmtLn1, cdAddrPlcmtLn2, cdAddrPlcmtSt, cdAddrPlcmtZip,
                                                       cdPlcmtInfo1, cdPlcmtInfo2, cdPlcmtInfo3, cdPlcmtInfo4,
                                                       cdPlcmtInfo5, cdPlcmtInfo6, cdPlcmtInfo7, cdPlcmtInfo8,
                                                       cdPlcmtInfo9, cdPlcmtInfo10, cdPlcmtInfo11, cdPlcmtInfo12,
                                                       cdPlcmtInfo13, cdPlcmtInfo14, cdPlcmtInfo15, cdPlcmtInfo16,
                                                       cdPlcmtInfo17, cdPlcmtLivArr, cdPlcmtRemovalRsn,
                                                       cdPlcmtActPlanned, cdPlcmtType, cdPlcmtService,
                                                       dtPlcmtCaregvrDiscuss, dtPlcmtChildDiscuss, dtPlcmtChildPlan,
                                                       dtPlcmtEducLog, dtPlcmtEnd, dtPlcmtMeddevHistory,
                                                       dtPlcmtParentsNotif, dtPlcmtPreplaceVisit, dtPlcmtSchoolRecords,
                                                       dtPlcmtStart, indPlcmtContCntct, indPlcmtEducLog,
                                                       indPlcmetEmerg, indPlcmtNotApplic, indPlcmtSchoolDoc,
                                                       cdNbrPlcmtPhoneExt, cdNbrPlcmtTelephone, cdNmPlcmtAgency,
                                                       cdNmPlcmtContact, cdNmPlcmtFacil, cdNmPlcmtPersonFull,
                                                       indPlcmtWriteHistory, cdTxtPlcmtAddrComment,
                                                       cdTxtPlcmtDiscussion, cdTxtPlcmtRemovalRsn, szCdActAtt,
                                                       ulContactedById, selSzCdMethod, cbxIndTempReplacement,
                                                       szCdTempPlcmtType, szTxtTempPlcmtCmnts, cbxIndWaiverRequired,
                                                       rbIndCaseHome, dtDateLastDischarged, ulMatch,
                                                       dtPermReportDueDate, cbxBoardingCounty, cbxIndTrialHomeVisit,
                                                       dtCrtBeginDate, dtCrtEndDate, rbIndPlcmtChPlacedFr,
                                                       rbIndPlcmtChPlacedBy, szCdChildTransitionCmnts, rbIndPlcmtSafe,
                                                       rbIndPlcmtLeastRestrict, rbIndPlcmtFamilyLike,
                                                       rbIndPlcmtAppropriate, rbIndPlcmtCloseProxPar,
                                                       rbIndPlcmtCloseProxSchool, rbIndConsistent,
                                                       szTxtNoExplainCheckList, rbIndExpTrauma, szTxtYesExpTrauma,
                                                       rbIndStaySiblings, nbrSibinCare, nbrSibPlaced, szCdSibRsn,
                                                       szCdCCFARsn, szCdNoReasonCmnts, rbIndPlcmtMatchCCFA,
                                                       szCdPlcmtMatchCCFAReasonCmnts, rbIndSuppSupervision,
                                                       szCdSuppSupervisionCmnts, txtDtPsychInfo, txtSzNmPsychinfo,
                                                       txtDtCasePsychInfo, txtSzNmCasePsychinfo, txtDtMedInfo,
                                                       txtSzNmMedinfo, txtDtCaseMedInfo, txtSzNmCaseMedinfo,
                                                       txtDtEduInfo, txtSzNmEduinfo, cbxIndNAEduInfo, txtDtCaseEduInfo,
                                                       txtSzNmCaseEduinfo, cbxIndNACaseEduInfo,
                                                       txtaSzTxtPlcmtDocuments, txtaSzTxtPlcmtCmntsDocuments, indLTFCPlacement, 
                                                       dtAgreementSigned, indConnectedAdult, 
                                                       (idPersonConnected == 0 ? null : idPersonConnected), dtLastViewPlcmtLog);
    }// New added 3
    else if (idContract == 0) {
      //MR-057 Added new fields for APPLA
      placementDAO.insertPlacementNoIdContract(idCase, dtPlcmtPermEff, idPlcmtEvent, idPlcmtAdult, idPlcmtChild, idRsrcAgency,
                                               idRsrcFacil, cdAddrPlcmtCity, cdAddrPlcmtCnty, cdAddrPlcmtLn1,
                                               cdAddrPlcmtLn2, cdAddrPlcmtSt, cdAddrPlcmtZip, cdPlcmtInfo1,
                                               cdPlcmtInfo2, cdPlcmtInfo3, cdPlcmtInfo4, cdPlcmtInfo5, cdPlcmtInfo6,
                                               cdPlcmtInfo7, cdPlcmtInfo8, cdPlcmtInfo9, cdPlcmtInfo10, cdPlcmtInfo11,
                                               cdPlcmtInfo12, cdPlcmtInfo13, cdPlcmtInfo14, cdPlcmtInfo15,
                                               cdPlcmtInfo16, cdPlcmtInfo17, cdPlcmtLivArr, cdPlcmtRemovalRsn,
                                               cdPlcmtActPlanned, cdPlcmtType, cdPlcmtService, dtPlcmtCaregvrDiscuss,
                                               dtPlcmtChildDiscuss, dtPlcmtChildPlan, dtPlcmtEducLog, dtPlcmtEnd,
                                               dtPlcmtMeddevHistory, dtPlcmtParentsNotif, dtPlcmtPreplaceVisit,
                                               dtPlcmtSchoolRecords, dtPlcmtStart, indPlcmtContCntct, indPlcmtEducLog,
                                               indPlcmetEmerg, indPlcmtNotApplic, indPlcmtSchoolDoc,
                                               cdNbrPlcmtPhoneExt, cdNbrPlcmtTelephone, cdNmPlcmtAgency,
                                               cdNmPlcmtContact, cdNmPlcmtFacil, cdNmPlcmtPersonFull,
                                               indPlcmtWriteHistory, cdTxtPlcmtAddrComment, cdTxtPlcmtDiscussion,
                                               cdTxtPlcmtRemovalRsn, szCdActAtt, ulContactedById, selSzCdMethod,
                                               cbxIndTempReplacement, szCdTempPlcmtType, szTxtTempPlcmtCmnts,
                                               cbxIndWaiverRequired, rbIndCaseHome, dspUlWaiverId,
                                               dtDateLastDischarged, ulMatch, dtPermReportDueDate, cbxBoardingCounty,
                                               cbxIndTrialHomeVisit, dtCrtBeginDate, dtCrtEndDate,
                                               rbIndPlcmtChPlacedFr, rbIndPlcmtChPlacedBy, szCdChildTransitionCmnts,
                                               rbIndPlcmtSafe, rbIndPlcmtLeastRestrict, rbIndPlcmtFamilyLike,
                                               rbIndPlcmtAppropriate, rbIndPlcmtCloseProxPar,
                                               rbIndPlcmtCloseProxSchool, rbIndConsistent, szTxtNoExplainCheckList,
                                               rbIndExpTrauma, szTxtYesExpTrauma, rbIndStaySiblings, nbrSibinCare,
                                               nbrSibPlaced, szCdSibRsn, szCdCCFARsn, szCdNoReasonCmnts,
                                               rbIndPlcmtMatchCCFA, szCdPlcmtMatchCCFAReasonCmnts,
                                               rbIndSuppSupervision, szCdSuppSupervisionCmnts, txtDtPsychInfo,
                                               txtSzNmPsychinfo, txtDtCasePsychInfo, txtSzNmCasePsychinfo,
                                               txtDtMedInfo, txtSzNmMedinfo, txtDtCaseMedInfo, txtSzNmCaseMedinfo,
                                               txtDtEduInfo, txtSzNmEduinfo, cbxIndNAEduInfo, txtDtCaseEduInfo,
                                               txtSzNmCaseEduinfo, cbxIndNACaseEduInfo, txtaSzTxtPlcmtDocuments,
                                               txtaSzTxtPlcmtCmntsDocuments, indLTFCPlacement, dtAgreementSigned, 
                                               indConnectedAdult, (idPersonConnected == 0 ? null : idPersonConnected), dtLastViewPlcmtLog);
    } else {
      //MR-057 Added new fields for APPLA
      placementDAO.insertPlacement(idCase, dtPlcmtPermEff, idPlcmtEvent, idPlcmtAdult, idPlcmtChild, idContract, idRsrcAgency,
                                   idRsrcFacil, cdAddrPlcmtCity, cdAddrPlcmtCnty, cdAddrPlcmtLn1, cdAddrPlcmtLn2,
                                   cdAddrPlcmtSt, cdAddrPlcmtZip, cdPlcmtInfo1, cdPlcmtInfo2, cdPlcmtInfo3,
                                   cdPlcmtInfo4, cdPlcmtInfo5, cdPlcmtInfo6, cdPlcmtInfo7, cdPlcmtInfo8, cdPlcmtInfo9,
                                   cdPlcmtInfo10, cdPlcmtInfo11, cdPlcmtInfo12, cdPlcmtInfo13, cdPlcmtInfo14,
                                   cdPlcmtInfo15, cdPlcmtInfo16, cdPlcmtInfo17, cdPlcmtLivArr, cdPlcmtRemovalRsn,
                                   cdPlcmtActPlanned, cdPlcmtType, cdPlcmtService, dtPlcmtCaregvrDiscuss,
                                   dtPlcmtChildDiscuss, dtPlcmtChildPlan, dtPlcmtEducLog, dtPlcmtEnd,
                                   dtPlcmtMeddevHistory, dtPlcmtParentsNotif, dtPlcmtPreplaceVisit,
                                   dtPlcmtSchoolRecords, dtPlcmtStart, indPlcmtContCntct, indPlcmtEducLog,
                                   indPlcmetEmerg, indPlcmtNotApplic, indPlcmtSchoolDoc, cdNbrPlcmtPhoneExt,
                                   cdNbrPlcmtTelephone, cdNmPlcmtAgency, cdNmPlcmtContact, cdNmPlcmtFacil,
                                   cdNmPlcmtPersonFull, indPlcmtWriteHistory, cdTxtPlcmtAddrComment,
                                   cdTxtPlcmtDiscussion, cdTxtPlcmtRemovalRsn, szCdActAtt, ulContactedById,
                                   selSzCdMethod, cbxIndTempReplacement, szCdTempPlcmtType, szTxtTempPlcmtCmnts,
                                   cbxIndWaiverRequired, rbIndCaseHome, dspUlWaiverId, dtDateLastDischarged, ulMatch,
                                   dtPermReportDueDate, cbxBoardingCounty, cbxIndTrialHomeVisit, dtCrtBeginDate,
                                   dtCrtEndDate, rbIndPlcmtChPlacedFr, rbIndPlcmtChPlacedBy, szCdChildTransitionCmnts,
                                   rbIndPlcmtSafe, rbIndPlcmtLeastRestrict, rbIndPlcmtFamilyLike,
                                   rbIndPlcmtAppropriate, rbIndPlcmtCloseProxPar, rbIndPlcmtCloseProxSchool,
                                   rbIndConsistent, szTxtNoExplainCheckList, rbIndExpTrauma, szTxtYesExpTrauma,
                                   rbIndStaySiblings, nbrSibinCare, nbrSibPlaced, szCdSibRsn, szCdCCFARsn,
                                   szCdNoReasonCmnts, rbIndPlcmtMatchCCFA, szCdPlcmtMatchCCFAReasonCmnts,
                                   rbIndSuppSupervision, szCdSuppSupervisionCmnts, txtDtPsychInfo, txtSzNmPsychinfo,
                                   txtDtCasePsychInfo, txtSzNmCasePsychinfo, txtDtMedInfo, txtSzNmMedinfo,
                                   txtDtCaseMedInfo, txtSzNmCaseMedinfo, txtDtEduInfo, txtSzNmEduinfo, cbxIndNAEduInfo,
                                   txtDtCaseEduInfo, txtSzNmCaseEduinfo, cbxIndNACaseEduInfo, txtaSzTxtPlcmtDocuments,
                                   txtaSzTxtPlcmtCmntsDocuments, indLTFCPlacement, dtAgreementSigned, 
                                   indConnectedAdult, (idPersonConnected == 0 ? null : idPersonConnected), dtLastViewPlcmtLog);

    }
    return 0;
  }

  public int updateComplex(Placement plcmt, String sysIndPrfrmValidation) {
    /*******************************************************************************************************************
     * Update an existing record. New dates (Start, End) could be either 'shrinking' or 'expanding': +-----+
     * +----------+ +-----+ | | <------o---> <---o------> | | +-----+ +----------+ +-----+
     ******************************************************************************************************************/

    // pull a few things out of the object so the dao calls are easier / cleaner
    int idCase = plcmt.getCapsCase().getIdCase();
    int idStage = plcmt.getEvent().getStage().getIdStage();
    Date dtPlcmtStart = plcmt.getDtPlcmtStart();
    Date dtPlcmtEnd = plcmt.getDtPlcmtEnd();
    Date tsLastUpdate = plcmt.getDtLastUpdate();
    int idPlcmtEvent = plcmt.getEvent().getIdEvent();
    int idPlcmtChild = plcmt.getPersonByIdPlcmtChild().getIdPerson();
    String cdPlcmtActPlanned = plcmt.getCdPlcmtActPlanned();
    String tempPlcmtType = plcmt.getCdTempType();
    boolean indCurrTemp = false;
    //STGAP00006420: Added check to see if the incoming placement is a temporary type
    //of Concurrent or Respite
    if (CodesTables.CTMPLTYP_COR.equals(tempPlcmtType) || CodesTables.CTMPLTYP_REN.equals(tempPlcmtType)
        || CodesTables.CTMPLTYP_RED.equals(tempPlcmtType)) {
      indCurrTemp = true;
    }

    // =================================================================
    // Check if there's a record of this Primary Key at all. It should
    // already exist in order to do an update.
    //
    // If existed, gets START and END date for other processing (with
    // timestamp removed.)
    //
    // Also remove timestamp on both input dates: hI_xxx because
    // they are being used a lot. So it's better to remove them once
    // =================================================================

    String dtLastUpdate = DateHelper.toSqlString(tsLastUpdate);
    Object[] placement = placementDAO.findPlacementByIdPlcmtEvent(idPlcmtEvent, dtLastUpdate);
    if (placement == null) {
      return -1;
    }
    Date date1 = (Date) placement[0];
    Date date2 = (Date) placement[1];
    Date dtCurrPlcmtStart = date1;
    Date dtCurrPlcmtEnd = date2;
    //STGAP00009260 - if start date in database is null, retrieve dateEventOccurred from event table to be used in comparison
    if(dtCurrPlcmtStart == null){
      Event event = eventDAO.findEventByIdEvent(idPlcmtEvent);
      if (event == null){
        return SQL_NOT_FOUND;
      }
      Date eventDate = event.getDtEventOccurred();
      dtCurrPlcmtStart = eventDate;
    }

    // =================================================================
    // If the 2 dates (i.e., dtDtPlcmtStart vs dtCurrPlcmtStart) are
    // different then the user wants to change that end (left or right)
    // =================================================================
    boolean bPlcmtStartDiff = isSameDay(dtCurrPlcmtStart, dtPlcmtStart);
    boolean bPlcmtEndDiff = isSameDay(dtCurrPlcmtEnd, dtPlcmtEnd);

    if (CodesTables.CPLCMTAC_A.equals(plcmt.getCdPlcmtActPlanned())) {

      // =================================================================
      // VALIDATE 1: check for LEFT-SIDE OVERLAP
      // If new START_DATE overlaps any of its LEFT record(s)
      // (If its overlaps some, then it must at least overlaps its
      // immediate previous record, and that's what we want to know)
      // =================================================================

      // =================================================================
      // Unlike checking for GAP_EXIST_1 and GAP_EXIST_2 (where we check
      // for these gaps only if the new date for that end is different
      // from the corresponding date in the existing record) we must
      // always check for OVERLAP_1 and OVERLAP_2.
      // =================================================================
      // STGAP00006420: Changed the signature of the sql and added code as part of the overlap
      //functionality clean up.
      List<Map> listPlcmtEventFnd = eventDAO.findEventIdPlcmtEventCurrDtPlcmtStartEqlGrtrDtEnd(idCase, idPlcmtChild,
                                                                                               cdPlcmtActPlanned,
                                                                                               dtPlcmtStart,
                                                                                               dtCurrPlcmtStart,
                                                                                               idPlcmtEvent);
      if (listPlcmtEventFnd != null) {
        for (Iterator<Map> itFnd = listPlcmtEventFnd.iterator(); itFnd.hasNext();) {
          Map map = itFnd.next();

          /*
           * Check if there are any open placements in open stages. If the stage is closed, it does not matter if the
           * placement does not have an end-date.
           */
          if (map != null) {
            String tempType = (String) map.get("cdTempType");
            int idPlEvent = (Integer) map.get("idPlcmtEvent") == null ? 0 : (Integer) map.get("idPlcmtEvent");
            boolean indtemp = false;
            if (CodesTables.CTMPLTYP_COR.equals(tempType) || CodesTables.CTMPLTYP_REN.equals(tempType)
                || CodesTables.CTMPLTYP_RED.equals(tempType)) {
              indtemp = true;
            }
            if ((indCurrTemp && indtemp) || (!indCurrTemp && !indtemp)) {
              long countSubStage = stageDAO.countCdStage(idPlEvent);

              if (countSubStage > 0) {
                return MSG_SUB_PERIOD_OVERLAP_1;
              }

              /*
               * The subcare stage is closed and check if the placement is end dated.
               */

              long countEndDated = placementDAO.countPlacementByMaxDate(idPlEvent);

              if (countEndDated > 0) {
                return MSG_SUB_PERIOD_OVERLAP_1;
              }

            }
          }
        }
      }

      // =================================================================
      // VALIDATE 2: Check for RIGHT-SIDE OVERLAP
      // If new START_DATE overlaps any of its RIGHT record(s)
      // (If its overlaps some, then it must at least overlaps its
      // immediate next record, and that's what we want to know)
      // =================================================================

      // STGAP00006420: Changed the signature of the sql and added code as part of the overlap
      //functionality clean up.
      List<Map> listRt = eventDAO.findIdPlcmtEventByCurrDtPlcmtEnd(idCase, idPlcmtChild, cdPlcmtActPlanned,
                                                                   dtCurrPlcmtEnd, dtPlcmtEnd, idPlcmtEvent);
      if (listRt != null && listRt.size() > 0) {
        for (Iterator<Map> itRtFnd = listRt.iterator(); itRtFnd.hasNext();) {
          Map map = itRtFnd.next();
          if (map != null) {
            String tempType = (String) map.get("cdTempType");
            boolean indtemp = false;
            if (CodesTables.CTMPLTYP_COR.equals(tempType) || CodesTables.CTMPLTYP_REN.equals(tempType)
                || CodesTables.CTMPLTYP_RED.equals(tempType)) {
              indtemp = true;
            }
            if ((indCurrTemp && indtemp) || (!indCurrTemp && !indtemp)) {
              return MSG_SUB_PERIOD_OVERLAP_2;
            }
          }
        }
      }
    }
   //STGAP00006420:Added code to bring back the Gap check functionality
    if (ArchitectureConstants.Y.equals(sysIndPrfrmValidation)&& !indCurrTemp) {
      String startDate = DateHelper.toSqlString(dtPlcmtStart);
      String currStartDate = DateHelper.toSqlString(dtCurrPlcmtStart);
      Object[] tempPlcmt1 = placementDAO.findPlcmtByDtPlcmtStartIdPersonIdCaseAndCurrPlcmtStart(startDate,
                                                                                                idPlcmtChild, idCase,
                                                                                                currStartDate);
      // VALIDATE 4: Check if the gap on LEFT of dtPlcmtStart is
      // bigger than 1 day. SELECT statement will return record if
      // it finds one, which means gap is >= 1.0 day ==> ERROR!
      boolean bLeftGapExists = false;
      if (tempPlcmt1 != null && tempPlcmt1.length > 0) {
        bLeftGapExists = true;
      }
      boolean bRightGapExists = false;
      if (!DateHelper.MAX_JAVA_DATE.equals(dtCurrPlcmtEnd)) {
        String endDate = DateHelper.toSqlString(dtPlcmtEnd);
        String currEndDate = DateHelper.toSqlString(dtCurrPlcmtEnd);
        Object[] tempPlcmt2 = placementDAO.findPlcmtByDtPlcmtEndIdPersonIdCaseDtCurrPlcmtEnd(endDate, idPlcmtChild,
                                                                                             idCase, currEndDate);
        // VALIDATE 5: Check if the gap on RIGHT of dtPlcmtStart is
        // bigger than 1 day. SELECT statement will return record if
        // it finds one, which means gap is >= 1.0 day ==> ERROR!
        if (tempPlcmt2 != null && tempPlcmt2.length > 0) {
          bRightGapExists = true;
        }
      }
      if (bLeftGapExists && bRightGapExists) {
        return MSG_SUB_GAP_EXISTS_3;
      } else if (bLeftGapExists) {
        return MSG_SUB_GAP_EXISTS_1;
      } else if (bRightGapExists) {
        return MSG_SUB_GAP_EXISTS_2;
      }
    }// FND_YES.equals(sysIndPrfrmValidation))
    // can now update the placement
    placementDAO.savePlacement(plcmt);

    return 0;
  }

  public int indicatorYes(Placement plcmt, String sysIndPrfrmValidation) {
    /*
     * UPDATE from PLANNED to ACTUAL * A new case was added specifically to handle the scenario * when a planned
     * placement has already been saved and the * start date remains the same. The problem with using the * Case Update
     * is that if the start date does not change * no date validation will occur. This is due to two incorrect *
     * assumptions 1) that the date would have been validated on the * insert and 2) that unless a change occurred there
     * would be no * reason to validate the date and check for overlap/gap.
     */

    // pull a few things out of the object so the dao calls are easier / cleaner
    int idCase = plcmt.getCapsCase().getIdCase();
    Date dtPlcmtStart = plcmt.getDtPlcmtStart();
    Date dtPlcmtEnd = plcmt.getDtPlcmtEnd();
    // Date tsLastUpdate = plcmt.getDtLastUpdate();
    // int idPlcmtEvent = plcmt.getEvent().getIdEvent();
    int idPlcmtChild = plcmt.getPersonByIdPlcmtChild().getIdPerson();
    String cdPlcmtActPlanned = plcmt.getCdPlcmtActPlanned();

    // check if there's such an ID_STAGE first
    if (placementDAO.countPersonByIdPlcmtChildByIdCase(idCase, idPlcmtChild) == 0) {
      return 0;
    }

    // ************************************************************************
    // Check if there's any record of this ID_EVENT and STAGE. If none, then
    // everything passed. No need to go through all these validation.
    // ************************************************************************

    List<Integer> listStage = placementDAO.findIdPlcmtEventByPersonByIdPlcmtChild(idCase, idPlcmtChild,
                                                                                  cdPlcmtActPlanned);
    if (listStage == null || listStage.size() == 0) {
      return 0;
    }

    if (CodesTables.CPLCMTAC_A.equals(cdPlcmtActPlanned)) {

      // =================================================================
      // VALIDATE 1: Check if new records overlaps other records on LEFT
      // (works whether new record overlaps 1 or more existing records
      // =================================================================

      List<Integer> listLt = placementDAO.findIdPlcmtEventByDtPlcmtEnd(idCase, idPlcmtChild, cdPlcmtActPlanned,
                                                                       dtPlcmtStart, dtPlcmtEnd);
      if (listLt == null) {
        return 0;
      }

      for (Iterator<Integer> itFnd = listLt.iterator(); itFnd.hasNext();) {
        Integer idPlEvent = itFnd.next();

        /*
         * * Select count for the number of rows given a certain * id_plcmnt_event that has open subcare stages that *
         * are not end-dated.
         */

        if (stageDAO.countCdStage(idPlEvent) > 0) {
          return MSG_SUB_PERIOD_OVERLAP_1;
        }

        /*
         * * The subcare stage is closed and check if the * placement is end dated.
         */

        if (placementDAO.countPlacementByMaxDate(idPlEvent) > 0) {
          return MSG_SUB_PERIOD_OVERLAP_1;
        }

      } // interator

      // =================================================================
      // VALIDATE 2: Check if new records overlaps other records on RIGHT
      // (works whether new record overlaps 1 or more existing records
      // =================================================================
      List<Integer> listRt = placementDAO.findIdPlcmtEventByDtPlcmtStart(idCase, idPlcmtChild, cdPlcmtActPlanned,
                                                                         dtPlcmtStart, dtPlcmtEnd);
      if (listRt != null && listRt.size() > 0) {
        return MSG_SUB_PERIOD_OVERLAP_2;
      }

      // ====================================================================
      // VALIDATE 3: Check if new records is either identical OR within
      // a record
      // ====================================================================
      /*****************************************************************************************************************
       * (1) (2) (3) (4) LEFT RIGHT IDENTICAL WITHIN
       * 
       * +-+ +-+ +-+-+-+ +-+-+ +-+ +-+ +-+-+-+ +-+-+ OK OK BAD BAD
       ****************************************************************************************************************/

      List<Integer> listOr = placementDAO.findIdPlcmtEventByDtPlcmtStartAndDtPlcmtEnd(idCase, idPlcmtChild,
                                                                                      cdPlcmtActPlanned, dtPlcmtStart,
                                                                                      dtPlcmtEnd);
      if (listOr == null) {
        return 0;
      }

      for (Iterator<Integer> itOr = listOr.iterator(); itOr.hasNext();) {
        Integer idPlEvent = itOr.next();

        /*
         * * Select count for the number of rows given a certain * idPlEvent that has open subcare stages that * are not
         * end-dated.
         */

        if (stageDAO.countCdStage(idPlEvent) > 0) {
          return MSG_SUB_PERIOD_OVERLAP_1;
        }

        /*
         * * The subcare stage is closed and check if the * placement is end dated.
         */

        if (placementDAO.countPlacementByMaxDate(idPlEvent) > 0) {
          return MSG_SUB_PERIOD_OVERLAP_1;
        }

      }

    }

    if (ArchitectureConstants.Y.equals(sysIndPrfrmValidation)) {

      // =================================================================
      // VALIDATE 4: Check if the gap on LEFT of dtPlcmtStart is
      // bigger than 1 day. SELECT statement will return record if
      // it finds one, which means gap is >= 1.0 day ==> ERROR!
      // =================================================================
      String date = DateHelper.toSqlString(dtPlcmtStart);
      Object[] listLt1 = placementDAO.findIdPlcmtEventDtPlcmtEndByMaxDtPlcmtEnd(idPlcmtChild, idCase, date);
      boolean bLeftGapExists = false;
      if (listLt1 != null && listLt1.length > 0) {
        bLeftGapExists = true;
      }

      // =================================================================
      // VALIDATE 5: Check if the gap on RIGHT of dtPlcmtStart is
      // bigger than 1 day. SELECT statement will return record if
      // it finds one, which means gap is >= 1.0 day ==> ERROR!
      // =================================================================
      String plcmtEndDate = DateHelper.toSqlString(dtPlcmtEnd);
      Object[] listRt1 = placementDAO.findIdPlcmtEventDtPlcmtEndByMinDtPlcmtStart(idPlcmtChild, idCase, plcmtEndDate);
      boolean bRightGapExists = false;
      if (listRt1 != null && listRt1.length > 0) {
        bRightGapExists = true;
      }
      if (bLeftGapExists && bRightGapExists) {
        return MSG_SUB_GAP_EXISTS_3;
      } else if (bLeftGapExists) {
        return MSG_SUB_GAP_EXISTS_1;
      } else if (bRightGapExists) {
        return MSG_SUB_GAP_EXISTS_2;
      }

    } // if (FND_YES.equals (sysIndPrfrmValidation))

    // can now update the placement
    placementDAO.savePlacement(plcmt);

    return 0;
  }
}