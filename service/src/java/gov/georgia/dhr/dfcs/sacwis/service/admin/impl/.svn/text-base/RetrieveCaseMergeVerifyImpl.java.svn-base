package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CaseMergeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CaseMerge;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveCaseMergeVerify;
import gov.georgia.dhr.dfcs.sacwis.service.admin.UnitAccess;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC40SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC40SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC40SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC40SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCLSC59DO_ARRAY;

/**
 * 
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   08/04/08  arege    STGAP00007353 -  Modified Code to enable Merge for Cases with Pending
 *                      approvals. The Case that is being merged should be closed.
 *                      When the error is MSG_INV_PEND_APRV_INVALDT, it is not added to the array ,
 *                      but set SzCdCasePendEvent to PEND status in ccfc40so object.
 *   
 * </pre>
 */

public class RetrieveCaseMergeVerifyImpl extends BaseServiceImpl implements RetrieveCaseMergeVerify {

  private CapsCaseDAO capsCaseDAO = null;

  private CaseMergeDAO caseMergeDAO = null;

  private EventDAO eventDAO = null;

  private IncomingDetailDAO incomingDetailDAO = null;

  private PersonDAO personDAO = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private SvcAuthDetailDAO svcAuthDetailDAO = null;

  private TodoDAO todoDAO = null;

  private UnitAccess unitAccess = null;

  private static final String split = "S";

  private static final String merge = "M";

  private static final String todoLeNotifTask = "1047";

  private static final int sizeOfCrsr = 2;

  private static final String CODE_STAGE_CSR = "C-";

  private static final String CODE_STAGE_PAL = CodesTables.CSTAGES_PAL;

  private static final String CODE_STAGE_FAD = CodesTables.CSTAGES_FAD;

  private static final String CODE_STAGE_SPC = CodesTables.CSTAGES_SPC;

  private static final String INFO_AND_REFER = CodesTables.CSTAGES_IR;

  private static final String CODE_STAGE_AOC = CodesTables.CSTAGES_AOC;

  private static final String CODE_STAGE_SUB = CodesTables.CSTAGES_SUB;

  private static final String STAGE_PROGRAM_APS = CodesTables.CSRPGTYP_APS;

  private static final String STAGE_PROGRAM_CPS = CodesTables.CSRPGTYP_CPS;

  private static final String STAGE_PROGRAM_CCL = CodesTables.CSRPGTYP_CCL;

  private static final String STAGE_PROGRAM_RCL = CodesTables.CSRPGTYP_RCL;

  private static final String STAGE_PROGRAM_AFC = CodesTables.CSRPGTYP_AFC;

  private static final String INTAKE = CodesTables.CSTAGES_INT;

  private static final String POST_ADOPT = CodesTables.CSTAGES_PAD;

  private static final String ADOPT = CodesTables.CSTAGES_ADO;

  private static final String INVESTIGATION = CodesTables.CSTAGES_INV;

  private static final String VICTIM = CodesTables.CROLES_VC;

  private static final String VICTIM_PERP = CodesTables.CROLES_VP;

  // private static final String CLIENT = CodesTables.CSECATTR_CL;

  private static final String PRIMARY_CHILD = CodesTables.CROLES_PC;

  private static final String EVENT_STATUS_PEND = CodesTables.CEVTSTAT_PEND;

  private static final String TRUE = "1";

  private static final int SUCCESS = 0;

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setCaseMergeDAO(CaseMergeDAO caseMergeDAO) {
    this.caseMergeDAO = caseMergeDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setUnitAccess(UnitAccess unitAccess) {
    this.unitAccess = unitAccess;
  }

  public CCFC40SO findCaseMergeVerify(CCFC40SI ccfc40si) throws ServiceException {
    CCFC40SO ccfc40so = new CCFC40SO();
    boolean bMFAOC = false;
    boolean bCasePending = false;

    bCasePending = callCheckCasePending(ccfc40si.getUlIdCaseMergeTo(), ccfc40si.getUlIdCaseMergeFrom());

    ROWCCFC40SOG00_ARRAY rowccfc40sog00_array = new ROWCCFC40SOG00_ARRAY();
    ccfc40so.setROWCCFC40SOG00_ARRAY(rowccfc40sog00_array);
    ROWCCFC40SOG00 rowCcfc40Sog00 = new ROWCCFC40SOG00();

    if (bCasePending) {
      //STGAP00007353 Commented out the following lines, as we do not want to add to the array
      // if the error message is MSG_INV_PEND_APRV_INVALDT
      
       /* rowCcfc40Sog00 = new ROWCCFC40SOG00();
        rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_INV_PEND_APRV_INVALDT);
        rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);*/
      
      //STGAP00007353 Added following line. We get this field on JSP and display the
      // error message if the status is pending.
        ccfc40so.setSzCdCasePendEvent(EVENT_STATUS_PEND);      
       }

    boolean bSwitchCases = false;
    bSwitchCases = CallCompareIntakeDate(ccfc40si.getUlIdCaseMergeTo(), ccfc40si.getUlIdCaseMergeFrom());
    int idCaseMergeFrom = ccfc40si.getUlIdCaseMergeFrom();
    int idCaseMergeTo = ccfc40si.getUlIdCaseMergeTo();

//    CapsCase capsCase = capsCaseDAO.findCapsCaseByIdCase(idCaseMergeFrom);
    CapsCase capsCaseFrom = capsCaseDAO.findCapsCaseByIdCase(idCaseMergeFrom);

    if (capsCaseFrom != null) { // 

      if (idCaseMergeFrom == idCaseMergeTo) {
        rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_CFC_CONNECT_BY_LOOP);
        rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);
      }

      if (bSwitchCases) {
        ccfc40si.setUlIdCaseMergeTo(idCaseMergeFrom);
        ccfc40si.setUlIdCaseMergeFrom(idCaseMergeTo);
        rowCcfc40Sog00 = new ROWCCFC40SOG00();
        rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_MERGE_BY_INTAKE_DATE);
        rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);
      }

      if (CheckForReverseMerge(idCaseMergeTo, idCaseMergeFrom) == Messages.MSG_CIRCULAR_MERGE_NOT_ALLOWED) {
        rowCcfc40Sog00 = new ROWCCFC40SOG00();
        rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_CIRCULAR_MERGE_NOT_ALLOWED);
        rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);
      }

      boolean checkedCRSR = false;

      // clss30d
      List<Stage> stageCaseMergeFromList = stageDAO.findStagesByIdCase(idCaseMergeFrom);

      if (stageCaseMergeFromList == null || stageCaseMergeFromList.isEmpty()) {
        throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
      }

      for (Iterator<Stage> it = stageCaseMergeFromList.iterator(); it.hasNext();) {
        Stage stage = it.next();
        String stageType = stage.getCdStageType();

        if ("C-REG".equals(stageType) || "C-GUA".equals(stageType)) {
          rowCcfc40Sog00 = new ROWCCFC40SOG00();
          rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_CRSR_STAGE);
          rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);
          checkedCRSR = true;
          break;
        }
      }

      if (!checkedCRSR) {

        // clss30d
        List<Stage> stageCaseMergeToList = stageDAO.findStagesByIdCase(idCaseMergeTo);

        if (stageCaseMergeToList == null || stageCaseMergeToList.isEmpty()) {
          throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
        }

        for (Iterator<Stage> it = stageCaseMergeToList.iterator(); it.hasNext();) {
          Stage stage = it.next();
          String stageType = stage.getCdStageType();

          if ("C-REG".equals(stageType) || "C-GUA".equals(stageType)) {
            rowCcfc40Sog00 = new ROWCCFC40SOG00();
            rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_CRSR_STAGE);
            rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);
            break;
          }
        }
      }

      // ccmnd9d
      ccfc40so.setSzScrNmCaseMrgFrom(capsCaseFrom.getNmCase());

      if (!DateHelper.isNull(capsCaseFrom.getDtCaseClosed())) {
        ccfc40so.setCScrIndFromCaseCld(ArchitectureConstants.Y);
      } else {
        ccfc40so.setCScrIndFromCaseCld(ArchitectureConstants.N);
      }

      // STGAP00003248 - Cannot merge open case to closed case
      CapsCase capsCaseTo = capsCaseDAO.findCapsCaseByIdCase(idCaseMergeTo);
      if (!DateHelper.isNull(capsCaseTo.getDtCaseClosed()) && DateHelper.isNull(capsCaseFrom.getDtCaseClosed())) {
        rowCcfc40Sog00 = new ROWCCFC40SOG00();
        rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_MERGE_OPN_CLD_NOT_ALLOWED);
        rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);
      }
      // end STGAP00003248

      // This will verify that the From case ID has not been invalidated
      // by being the Merge From ID in a separate merge. If it has been
      // invalidated, the service will return. If it is pending a merge as a
      // merge From case, an Edit will be posted as part of the error list
      // edits.

      // clsc67d
      List<CaseMerge> caseMergeList = caseMergeDAO.findByIdCaseMergeFrom(idCaseMergeFrom);

      boolean bMergeFromInv = false;
      boolean bMergePend = false;
      if (caseMergeList != null && !caseMergeList.isEmpty()) {
        Iterator<CaseMerge> it = caseMergeList.iterator();

        // While more rows are left to process and rc is success,
        // continue loop to check if any of the Merge From case is Pending
        // to be merged, and if any of the Merge From case is to be
        // Invalidated. If so than set the respective flags.

        while (it.hasNext() && ((bMergeFromInv == false) || (bMergePend == false))) {
          CaseMerge caseMerge = it.next();

          if (ArchitectureConstants.Y.equals(caseMerge.getIndCaseMergeInvalid())) {
            if (DateHelper.isNull(caseMerge.getDtCaseMergeSplit())) {
              bMergeFromInv = true;
            }
          }

          String indCaseMergePending = caseMerge.getIndCaseMergePending();
          if ((merge.equals(indCaseMergePending)) || (split.equals(indCaseMergePending))) {
            bMergePend = true;
          }
        }
      }
      if (!ArchitectureConstants.Y.equals(ccfc40si.getCSysIndMergeAccess())
          && ArchitectureConstants.N.equals(ccfc40so.getCScrIndFromCaseCld())) {

        // clsc64d
        ArchInputStruct archInputStruct = ccfc40si.getArchInputStruct();
        List<Map> personMap = personDAO.findPersonByIdCase(idCaseMergeFrom, archInputStruct.getUsPageNbr(),
                                                           archInputStruct.getUlPageSizeNbr());

        if (personMap == null) {
          throw new ServiceException(Messages.MSG_CFC_NO_MERGE_ACCESS);
        }

        if (!ArchitectureConstants.Y.equals(ccfc40so.getCSysIndMergeAccess())) {
          throw new ServiceException(Messages.MSG_CFC_NO_MERGE_ACCESS);
        }

        Iterator<Map> itPersonMap = personMap.iterator();

        // loop thru OutputRec to check if MergeAccess is allowed or not.
        // Once the MergeAccess Indicator is set to Yes the loop will
        // exit, otherwise it will go thru all the rows returned.

        while (itPersonMap.hasNext() && (!ArchitectureConstants.Y.equals(ccfc40so.getCSysIndMergeAccess()))) {
          Map map = itPersonMap.next();
          int idPerson = (Integer) map.get("idPerson");
          int idUnit = (Integer) map.get("idUnit");

          if (ccfc40si.getUlIdPerson() == idPerson) {
            ccfc40so.setCSysIndMergeAccess(ArchitectureConstants.Y);
          } else {

            CCMN04UI ccmn04ui = new CCMN04UI();
            ccmn04ui.setUlIdUnit(idUnit);
            ccmn04ui.getUlIdPerson_ARRAY_CCMN04UI().setUlIdPerson(0, ccfc40si.getUlIdPerson());

            CCMN04UO ccmn04uo = unitAccess.checkForPersonWithUnitAccess(ccmn04ui);

            if (ccmn04uo != null) {
              if (TRUE.equals(ccmn04uo.getBSysIndGeneric())) {
                ccfc40so.setCSysIndMergeAccess(ArchitectureConstants.Y);
              }
            } else {
              throw new ServiceException(Messages.MSG_DATABASE_RETRIEVE_FAIL);
            }
          }
        }
      }
      // To check if another merge is pending for the Merge From case
      // (functioning as a Merge To case) that would be made permanent
      // if this merge was done.
      if (!ArchitectureConstants.Y.equals(ccfc40si.getCSysIndMergePend())) {

        // clsc68d
        List<CaseMerge> caseMergeToList = caseMergeDAO.findByIdCaseMergeTo(idCaseMergeFrom);
        if (caseMergeToList != null && !caseMergeToList.isEmpty()) {
          Iterator<CaseMerge> itCaseMergeTo = caseMergeToList.iterator();
          // If a row is found it has been previously merged

          // While more rows are left to process and rc is success,
          // continue loop to check if any Merge To case is Pending a
          // merge. If so than set the flag and exit service.

          while ((itCaseMergeTo.hasNext()) && (bMergePend == false)) {
            CaseMerge caseMerge = itCaseMergeTo.next();
            String indCaseMergePending = caseMerge.getIndCaseMergePending();
            // if any output rows CaseMergePending Indicator is set to YES
            // set the MergePend flag to true
            if ((merge.equals(indCaseMergePending)) || (split.equals(indCaseMergePending))) {
              bMergePend = true;
            }
          }
          // If MergePend flag is true exit service
          if (bMergePend) {
            rowCcfc40Sog00 = new ROWCCFC40SOG00();
            rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_CFC_MERGE_PEND);
            rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);
          }
        }
      }
      // Retrieve all stage rows for TO case from STAGE table.
      // clsc59d
      List<Stage> stageToList = stageDAO.findStageByIdCase(idCaseMergeTo);

      if (stageToList == null || stageToList.isEmpty()) {
        throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
      }

      Iterator<Stage> itStageTo = stageToList.iterator();
      // Check if PostAdopt Indicator is not set
      if (!ArchitectureConstants.Y.equals(ccfc40si.getCSysIndPostAdopt())) {
        while (itStageTo.hasNext()) {
          Stage stage = itStageTo.next();

          if (POST_ADOPT.equals(stage.getCdStage())) {
            ccfc40si.setCSysIndPostAdopt(ArchitectureConstants.Y);
            rowCcfc40Sog00 = new ROWCCFC40SOG00();
            rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_CFC_POST_ADOPT_STG);
            rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);
          }
        }
      }
      // Retrieve all stage rows for FROM case from STAGE table.
      // clsc59d
      List<Stage> stageFromList = stageDAO.findStageByIdCase(idCaseMergeFrom);

      if (stageFromList == null || stageFromList.isEmpty()) {
        throw new ServiceException(Messages.MSG_CFC_CASE_INVALID);
      }

      Iterator<Stage> itStageFromList = stageFromList.iterator();

      if (!ArchitectureConstants.Y.equals(ccfc40si.getCSysIndPostAdopt())) {

        while (itStageFromList.hasNext()) {
          Stage stage = itStageFromList.next();

          if (POST_ADOPT.equals(stage.getCdStage())) {
            ccfc40si.setCSysIndPostAdopt(ArchitectureConstants.Y);
            rowCcfc40Sog00 = new ROWCCFC40SOG00();
            rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_CFC_POST_ADOPT_STG);
            rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);
          }
        }
      }
      // Person info for the Merge To case. Note that this dao will hit
      // the person Merge table as well as the stage person link table.
      // clsc66d
      List<Map> personToMap = stagePersonLinkDAO.findStagePersonLink(idCaseMergeTo);
      if (personToMap == null || personToMap.isEmpty()) {
        throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
      }
      // Person info for the Merge From case. Note that this dam will hit
      // the person Merge table as well as the stage person link table.
      // clsc66d
      List<Map> personFromMap = stagePersonLinkDAO.findStagePersonLink(idCaseMergeFrom);

      if (bMergePend) {
        rowCcfc40Sog00 = new ROWCCFC40SOG00();
        rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_CFC_ALREADY_PEND);
        rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);
      }

      String cdCaseProgram = ccfc40si.getSzCdCaseProgram();

      if (!(StringHelper.checkForEquality(capsCaseFrom.getCdCaseProgram(), cdCaseProgram))) {
        rowCcfc40Sog00 = new ROWCCFC40SOG00();
        rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_CFC_CMS_PROGRAM);
        rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);
      }
      // Look for matching victims If the Merge To case Program is the same as Adult Protective
      // Service or Adult Facility Care Than check if Merge From case is Closed or not.
      ListIterator<Map> itpersonFromMap = personFromMap.listIterator();
      Iterator<Map> itpersonToMap = personToMap.iterator();
      Iterator<Stage> itStageFrom = stageFromList.iterator();
      boolean bAPSCases = false;
      boolean bAPSVictim = false;

      if (STAGE_PROGRAM_APS.equals(cdCaseProgram) || STAGE_PROGRAM_AFC.equals(cdCaseProgram)) {

        if (!ArchitectureConstants.Y.equals(ccfc40so.getCScrIndFromCaseCld())
            && STAGE_PROGRAM_APS.equals(cdCaseProgram)) {
          bAPSCases = true;
        }

        // loop thru stagePersonToInfo and stagePersonFromInfo.
        // If a same Person is found in both the stagePersonToInfo
        // and stagePersonFromInfo case which has a Stage
        // Person Role of Person Role Victim or Person Role Client or
        // Person Role Both than set the APSVictim flag to TRUE.

        while ((!bAPSVictim) && (itpersonToMap.hasNext())) {
          Map personToInfoMap = itpersonToMap.next();
          int idPersonTo = (Integer) personToInfoMap.get("idPersMergeForward");
          String cdStagePersRoleTo = (String) personToInfoMap.get("cdStagePersRole");

          // if (VICTIM.equals(cdStagePersRoleTo) || VICTIM_PERP.equals(cdStagePersRoleTo)
          // || CLIENT.equals(cdStagePersRoleTo)) {
          if (VICTIM.equals(cdStagePersRoleTo) || VICTIM_PERP.equals(cdStagePersRoleTo)) {

            while ((!bAPSVictim) && (itpersonFromMap.hasNext())) {
              Map personFromInfoMap = itpersonFromMap.next();
              int idPersonFrom = (Integer) personFromInfoMap.get("idPersMergeForward");
              String cdStagePersRoleFrom = (String) personFromInfoMap.get("cdStagePersRole");

              // if ((VICTIM.equals(cdStagePersRoleFrom) || VICTIM_PERP.equals(cdStagePersRoleFrom) || CLIENT
              // .equals(cdStagePersRoleFrom))
              if ((VICTIM.equals(cdStagePersRoleFrom) || VICTIM_PERP.equals(cdStagePersRoleFrom))
                  && idPersonFrom == idPersonTo) {
                bAPSVictim = true;
              }
            }
          }
        }
      }
      // Look for matching principals. If the MergeTo case Program is Licensing or Child Protective
      // Service Than loop through MergeToPersonInfo and MergeFromPersonInfo. If same Person is
      // found in both the cases than set CPSPrincipal flag to TRUE.
      boolean bCPSPrincipal = false;

      if (STAGE_PROGRAM_CPS.equals(cdCaseProgram) || STAGE_PROGRAM_CCL.equals(cdCaseProgram)
          || STAGE_PROGRAM_RCL.equals(cdCaseProgram)) {

        while ((!bCPSPrincipal) && (itpersonToMap.hasNext())) {
          Map personToInfoMap = itpersonToMap.next();
          int idPersonTo = (Integer) personToInfoMap.get("idPersMergeForward");

          while (itpersonFromMap.hasPrevious()) {
            itpersonFromMap.previous();
          }
          while ((!bCPSPrincipal) && (itpersonFromMap.hasNext())) {
            Map personFromInfoMap = itpersonFromMap.next();
            int idPersonFrom = (Integer) personFromInfoMap.get("idPersMergeForward");

            if (idPersonFrom == idPersonTo) {
              bCPSPrincipal = true;
            }
          }
        }
      }

      // loop thru all stages in MergeToCaseInfo and check if it is Case Related Special Request or
      // Info & Referral or Special Stage or FAD stage or Age Out Child Stage or Open Intake Stage.
      // Check for Duplicate Open stages for Subcare stage and Post Adopt Stage and Adopt Stage and
      // Prep Adult stage.
      boolean bSPCStage = false;
      boolean bFAD = false;
      boolean bOpenIntDlg = false;
      boolean bMTOpenInt = false;
      boolean bDupStage = false;
      boolean bMTCRSRTemp = true;
      boolean bMTAOC = false;

      itStageTo = stageToList.iterator();

      while (itStageTo.hasNext() || bMTCRSRTemp == true && bSPCStage == true && bOpenIntDlg == true && bFAD == true
             && bMTAOC == true && bMTOpenInt == true && bDupStage == true) {

        Stage stageTo = itStageTo.next();
        String cdStageTypeTo = stageTo.getCdStageType();
        String cdStageTo = stageTo.getCdStage();
        Date dtStageCloseTo = stageTo.getDtStageClose();
        String cdStageReasonClosedTo = stageTo.getCdStageReasonClosed();
        int idStageTo = stageTo.getIdStage();
        boolean bMTCRSRTemp1 = false;
        // Look for Case Related Special Request Stage Type. CRSRs may be merged if both the
        // Merge To and Merge From cases are CRSRs. If a CRSR is being merged into a case
        // that is not a CRSR, the CRSR must be the Merge From case.
        if (bMTCRSRTemp == true) {
          if ((CODE_STAGE_CSR.substring(0, sizeOfCrsr).equals(cdStageTypeTo.substring(0, sizeOfCrsr)))) {
            bMTCRSRTemp1 = true;

          }
          // If any of the stages is not CRSR then the case is not CRSR.
          if (!bMTCRSRTemp1) {
            bMTCRSRTemp = false;
          }
        }
        // look for I&R or SPC stage and set the Flag.
        if (bSPCStage == false) {
          if ( CodesTables.CSTAGES_INT.equals( cdStageTo )){
            //  if incoming call is a Non-incident Request Type set off error flag
            IncomingDetail incomingDetail = incomingDetailDAO.findIncomingDetailFromAnyIdStage( idStageTo );
            if ( incomingDetail.getCdNonRsdntReqType() != null ){
              bSPCStage = true;
            }
          }
//          if (INFO_AND_REFER.equals(cdStageTypeTo) || CODE_STAGE_SPC.equals(cdStageTypeTo)) {
//            bSPCStage = true;
//          }
        }
        // look for FAD stage and set the Flag.
        if (bFAD == false) {

          if (CODE_STAGE_FAD.equals(cdStageTo)) {
            bFAD = true;
          }
        }
        // look for open AOC stage and set the Flag.
        if (true == bAPSCases && bMTAOC == false) {

          if (CODE_STAGE_AOC.equals(cdStageTo) && DateHelper.isNull(dtStageCloseTo)) {
            bMTAOC = true;
          }
        }
        // look for open intake and set the Open Intake flag. There can be an Open Intake
        // but there cannot be an Open Intake dialog for a Merge can take place.
        if (bMTOpenInt == false) {
          // Look for Open Intake Dialog and set the flag
          if (INTAKE.equals(cdStageTo) && DateHelper.isNull(dtStageCloseTo)) {
            bMTOpenInt = true;
            rowCcfc40Sog00 = new ROWCCFC40SOG00();
            rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_CFC_CMS_MT_INT);
            rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);
            if (null == cdStageReasonClosedTo) {
              bOpenIntDlg = true;
            }
          }
        }
        // Look for Open Duplicate Stages.
        if (bDupStage == false && DateHelper.isNull(dtStageCloseTo)) {
          // If any of the Merge To Stage is SUBCARE than loop thru all the Merge From Stage and
          // check if any SUBCARE Merge From Stage is Open.
          if (CODE_STAGE_SUB.equals(cdStageTo)) {
            while (bDupStage == false && itStageFrom.hasNext()) {
              Stage stageFrom = itStageFrom.next();
              int idStageFrom = stageFrom.getIdStage();

              if (CODE_STAGE_SUB.equals(stageFrom.getCdStage()) && DateHelper.isNull(stageFrom.getDtStageClose())) {
                // Loop thru both the MergeTo Person and MergeFrom Person struct. If same Person
                // is found in both the cases which has a Person role of Primary Child and belongs
                // to the same stage Than set the Duplicate flag to TRUE.
                while (itpersonToMap.hasNext()) {
                  Map personToInfoMap = itpersonToMap.next();
                  String cdStagePersRoleTo = (String) personToInfoMap.get("cdStagePersRole");
                  int stagePersIdStageTo = (Integer) personToInfoMap.get("idStage");
                  int idPersonTo = (Integer) personToInfoMap.get("idPersMergeForward");

                  if (PRIMARY_CHILD.equals(cdStagePersRoleTo) && stagePersIdStageTo == idStageFrom) {
                    while (itpersonFromMap.hasNext()) {
                      Map personFromInfoMap = itpersonFromMap.next();
                      String cdStagePersRoleFrom = (String) personFromInfoMap.get("cdStagePersRole");
                      int stagePersIdStageFrom = (Integer) personFromInfoMap.get("idStage");
                      int idPersonFrom = (Integer) personFromInfoMap.get("idPersMergeForward");

                      if (PRIMARY_CHILD.equals(cdStagePersRoleFrom) && stagePersIdStageFrom == idStageFrom) {
                        if (idPersonTo == idPersonFrom) {
                          bDupStage = true;
                        }
                      }
                    }
                  }
                }
              }
            }

          }
          // If any of the Merge To Stage is POST ADOPT than loop thru all the Merge From Stage
          // and check if any POST ADOPT Merge From Stage is Open.
          if (POST_ADOPT.equals(cdStageTo) && bDupStage == false) {
            while (bDupStage == false && itStageFrom.hasNext()) {
              Stage stageFrom = itStageFrom.next();

              if (POST_ADOPT.equals(stageFrom.getCdStage()) && DateHelper.isNull(stageFrom.getDtStageClose())) {
                // Loop thru both the MergeTo Person and MergeFrom Person object. If same Person
                // is found in both the cases which has a Person role of Primary Child and belongs
                // to the same stage Than set the Duplicate flag to TRUE.
                while (itpersonToMap.hasNext()) {
                  Map personToInfoMap = itpersonToMap.next();
                  String cdStagePersRoleTo = (String) personToInfoMap.get("cdStagePersRole");
                  int stagePersIdStageTo = (Integer) personToInfoMap.get("idStage");
                  int idPersonTo = (Integer) personToInfoMap.get("idPersMergeForward");

                  if (PRIMARY_CHILD.equals(cdStagePersRoleTo) && stagePersIdStageTo == idStageTo) {
                    while (itpersonFromMap.hasNext()) {
                      Map personFromInfoMap = itpersonFromMap.next();
                      String cdStagePersRoleFrom = (String) personFromInfoMap.get("cdStagePersRole");
                      int stagePersIdStageFrom = (Integer) personFromInfoMap.get("idStage");
                      int idPersonFrom = (Integer) personFromInfoMap.get("idPersMergeForward");

                      if (PRIMARY_CHILD.equals(cdStagePersRoleFrom) && stagePersIdStageFrom == stageFrom.getIdStage()) {
                        if (idPersonTo == idPersonFrom) {
                          bDupStage = true;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          // If any of the Merge To Stage is ADOPT than loop thru all the Merge From Stage and
          // check if any ADOPT Merge From Stage is Open.
          if (ADOPT.equals(cdStageTo) && bDupStage == false) {
            while (bDupStage == false && itStageFrom.hasNext()) {
              Stage stageFrom = itStageFrom.next();

              if (ADOPT.equals(stageFrom.getCdStage()) && DateHelper.isNull(stageFrom.getDtStageClose())) {
                // Loop thru both the MergeTo Person and MergeFrom Person object. If same Person
                // is found in both the cases which has a Person role of Primary Child and belongs
                // to the same stage Than set the Duplicate flag to TRUE.
                while (itpersonToMap.hasNext()) {
                  Map personToInfoMap = itpersonToMap.next();
                  String cdStagePersRoleTo = (String) personToInfoMap.get("cdStagePersRole");
                  int stagePersIdStageTo = (Integer) personToInfoMap.get("idStage");
                  int idPersonTo = (Integer) personToInfoMap.get("idPersMergeForward");

                  if (PRIMARY_CHILD.equals(cdStagePersRoleTo) && stagePersIdStageTo == idStageTo) {
                    while (itpersonFromMap.hasNext()) {
                      Map personFromInfoMap = itpersonFromMap.next();
                      String cdStagePersRoleFrom = (String) personFromInfoMap.get("cdStagePersRole");
                      int stagePersIdStageFrom = (Integer) personFromInfoMap.get("idStage");
                      int idPersonFrom = (Integer) personFromInfoMap.get("idPersMergeForward");

                      if (PRIMARY_CHILD.equals(cdStagePersRoleFrom) && stagePersIdStageFrom == stageFrom.getIdStage()) {
                        if (idPersonTo == idPersonFrom) {
                          bDupStage = true;
                        }
                      }
                    }
                  }
                }
              }
            }
          }

          /** *******************Prep Adult Stage ******************** */
          // If any of the Merge To Stage is Prep Adult than loop thru all the Merge From Stage
          // and check if any Prep Adult Merge From Stage is Open.
          if (CODE_STAGE_PAL.equals(cdStageTo) && bDupStage == false) {

            while (bDupStage == false && itStageFrom.hasNext()) {
              Stage stageFrom = itStageFrom.next();
              // Open PAL Merge From Stage.
              if (CODE_STAGE_PAL.equals(stageFrom.getCdStage()) && DateHelper.isNull(stageFrom.getDtStageClose())) {
                // Loop thru both the MergeTo Person and MergeFrom Person object. If same Person is found
                // in both the cases which has a Person role of Primary Child and belongs to the same
                // stage Than set the Duplicate flag to TRUE.
                while (itpersonToMap.hasNext()) {
                  Map personToInfoMap = itpersonToMap.next();
                  String cdStagePersRoleTo = (String) personToInfoMap.get("cdStagePersRole");
                  int stagePersIdStageTo = (Integer) personToInfoMap.get("idStage");
                  int idPersonTo = (Integer) personToInfoMap.get("idPersMergeForward");

                  if (PRIMARY_CHILD.equals(cdStagePersRoleTo) && stagePersIdStageTo == idStageTo) {
                    while (itpersonFromMap.hasNext()) {
                      Map personFromInfoMap = itpersonFromMap.next();
                      String cdStagePersRoleFrom = (String) personFromInfoMap.get("cdStagePersRole");
                      int stagePersIdStageFrom = (Integer) personFromInfoMap.get("idStage");
                      int idPersonFrom = (Integer) personFromInfoMap.get("idPersMergeForward");

                      if (PRIMARY_CHILD.equals(cdStagePersRoleFrom) && stagePersIdStageFrom == stageFrom.getIdStage()) {
                        if (idPersonTo == idPersonFrom) {
                          bDupStage = true;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }

      // Loop thru all the MergeFrom stages and check if any of the stage
      // is Case Related Sprecial Request or
      // Info & Referral or Special stage Type or
      // FAD stage or
      // Open Aging Out Child stage or
      // Open Intake Stage and if LE Notification is completed on it.
      boolean bMFOpenInt = false;

      // while (itStageFrom.hasNext() || bMTCRSRTemp == false && bSPCStage == false && bOpenIntDlg == false && bFAD ==
      // false
      // && bMFAOC == false && bMFOpenInt == false) {
      itStageFrom = stageFromList.iterator();
      while (itStageFrom.hasNext() || (bMTCRSRTemp && bSPCStage && bOpenIntDlg && bFAD && bMFAOC && bMFOpenInt)) {

        Stage stageFrom = itStageFrom.next();

        // if no address rows found and the resource
        // is of type hotline, then continue normal processing
        boolean bCRSR = false;
        String cdStageTypeFrom = stageFrom.getCdStageType();
        // look for CRSR stage type. CRSRs may be merged if both the Merge To and Merge From
        // cases are CRSRs. If a CRSR is being merged into a case that is not a CRSR,
        // the CRSR must be the Merge From case. If any of the Merge From Stage Type is
        // Case Related Special Request than set the flag to TRUE.
        /*
         * if (true == bMTCRSRTemp && !bCRSR) { if (CODE_STAGE_CSR.substring(0,
         * sizeOfCrsr).equals(cdStageTypeFrom.substring(0, sizeOfCrsr))) { bCRSR = true; } }
         */
        // look for I&R or SPC stage type. If any of the Merge From stage type is Info and Refferal or
        // Special stage type set the SPCStage flag to TRUE.
        /*
         * if (bSPCStage == false) { if (INFO_AND_REFER.equals(cdStageTypeFrom) ||
         * CODE_STAGE_SPC.equals(cdStageTypeFrom)) { bSPCStage = true; } }
         */

        // look for FAD stage. If any of the Merge From Stage is FAD set the flag to TRUE.
        String cdStageFrom = stageFrom.getCdStage();

        if (bSPCStage == false) {
          if ( CodesTables.CSTAGES_INT.equals( cdStageFrom )){
            //  if incoming call is a Non-incident Request Type set off error flag
            IncomingDetail incomingDetail = incomingDetailDAO.findIncomingDetailFromAnyIdStage( stageFrom.getIdStage() );
            if ( incomingDetail.getCdNonRsdntReqType() != null ){
              bSPCStage = true;
            }
          }
        } // end if (bSPCStage == false)
        
        if (bFAD == false) {

          if (CODE_STAGE_FAD.equals(cdStageFrom)) {
            bFAD = true;
          }

        }

        Date dtStageCloseFrom = stageFrom.getDtStageClose();
        // look for open AOC stage(It only exists in APS Stage). If any of the Merge From Stage
        // is Aging Out Child stage and that stage is still Open than set the AOC flag to TRUE.
        /*
         * if (true == bAPSCases && bMFAOC == false) { if (CODE_STAGE_AOC.equals(cdStageFrom) &&
         * DateHelper.isNull(dtStageCloseFrom)) { bMFAOC = true; } }
         */

        // look for open Intake
        if (bMFOpenInt == false) {
          // If any of the Merge From Stage is Intake and the stage is Open than set Open Intake flag to TRUE.
          if (INTAKE.equals(cdStageFrom) && DateHelper.isNull(dtStageCloseFrom)) {
            bMFOpenInt = true;
            // See if LE Notification is completed on this intake.
            // cint58d
            Todo todo = todoDAO.findTodoByIdStageAndCdTodoTask(stageFrom.getIdStage(), todoLeNotifTask);

            if (todo == null || DateHelper.isNull(todo.getDtTodoCompleted())) {
              rowCcfc40Sog00 = new ROWCCFC40SOG00();
              rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_CFC_CMS_LE_NOT);
              rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);
            }

            if (null == stageFrom.getCdStageReasonClosed()) {
              bOpenIntDlg = true;
            }
          }
        }
      }

      if (STAGE_PROGRAM_CPS.equals(cdCaseProgram)) {
        itStageTo = stageToList.iterator();
        itStageFrom = stageFromList.iterator();

        while (itStageTo.hasNext()) {
          Stage stageTo = itStageTo.next();

          if (INVESTIGATION.equals(stageTo.getCdStage())) {
            while (itStageFrom.hasNext()) {
              Stage stageFrom = itStageFrom.next();
              String cdStageFrom = stageFrom.getCdStage();

              if ((INVESTIGATION.equals(cdStageFrom) || INTAKE.equals(cdStageFrom))
                  && DateHelper.isNull(stageFrom.getDtStageClose())
                  && STAGE_PROGRAM_CPS.equals(stageFrom.getCdStageProgram())
                  && ArchitectureConstants.N.equals(ccfc40so.getCScrIndFromCaseCld())
                  && ArchitectureConstants.N.equals(ccfc40si.getCScrIndToCaseCld())) {

                // clsc94d
                String cdEventStatusFrom = eventDAO.findEventCdEventStatus(idCaseMergeFrom, null);
                ccfc40so.setSzCdCaseFromCCLStatus(cdEventStatusFrom);

                // clsc94d
                String cdEventStatusTo = eventDAO.findEventCdEventStatus(idCaseMergeTo, null);
                ccfc40so.setSzCdCaseToCCLStatus(cdEventStatusTo);
              }
            }
          }
        }
      }

      boolean bSvcAuth = false;
      // If Merge From Case is Open than look for open service Authorization.
      // Note that all service Authorization must be closed in the
      // Merge From case before the merge can take place.
      if (ArchitectureConstants.N.equals(ccfc40so.getCScrIndFromCaseCld())) {

        // clsc60d - not sure why this is called it does not seem to be used.
        Date dtSvcAuthTerm = svcAuthDetailDAO.findDtSvcAuthTerm(idCaseMergeFrom);
        // If a row is found it has an open service Authorization.
        if (!DateHelper.isNull(dtSvcAuthTerm)) {
          bSvcAuth = true;
        }
      }
      // I&R's and Non Case Related Special Requests cannot be merged.
      if (bSPCStage) {
        rowCcfc40Sog00 = new ROWCCFC40SOG00();
        rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_CFC_CMS_NO_MRG);
        rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);
      }
      // FAD homes cannot be merged.
      if (bFAD) {
        rowCcfc40Sog00 = new ROWCCFC40SOG00();
        rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_CFC_CMS_FAD);
        rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);
      }
      // Cannot merge an open APS case and an open APS case with an open AOC stage.
      // Rational - If its an Open MergeTo AOC stage under an Open MergeFrom APS case OR
      // If its an Open MergeFrom AOC stage under an Open MergeTo APS case than display Error Message.
      // Note that Open MergeTO APS case is checked by two flags bAPSCases and IndToCaseCld.The reason
      // behind this is although the bAPSCases flag tells us that it is MergeTo APS case, it does not
      // guarantees that it is an Open case, which is determined by the IndToCaseCld flag.
      if ((true == bMTAOC && false == bMFAOC) || (false == bMTAOC && true == bMFAOC)) {
        rowCcfc40Sog00 = new ROWCCFC40SOG00();
        rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_CFC_CMS_APS);
        rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);
      }
      // An open intake dialog may not be a part of the Merge From or Merge To case. Note
      // that the dialog must have a status of CLD, but the intake stage can be open.
      if (bOpenIntDlg) {
        rowCcfc40Sog00 = new ROWCCFC40SOG00();
        rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_CFC_CMS_INT_OPN);
        rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);
      }
      // Open Intake stage cannot be in the Merge To case.
      if (true == bMTOpenInt || true == bMFOpenInt) {
        rowCcfc40Sog00 = new ROWCCFC40SOG00();
        rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_CFC_CMS_OPEN_INT);
        rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);
      }
      // All open Service Authorizations in the Merge From case must be closed before the case can be merged.
      if (bSvcAuth) {
        rowCcfc40Sog00 = new ROWCCFC40SOG00();
        rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_CFC_CMS_SA);
        rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);
      }
      // CPS - There must be at least one common principal in the Merge From and Merge To cases.
      if ((STAGE_PROGRAM_CPS.equals(cdCaseProgram) || STAGE_PROGRAM_CCL.equals(cdCaseProgram) || STAGE_PROGRAM_RCL
                                                                                                                  .equals(cdCaseProgram))
          && !bCPSPrincipal) {
        rowCcfc40Sog00 = new ROWCCFC40SOG00();
        rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_CFC_CMS_PRN);
        rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);
      }
      // APS - the ID PERSON in common must be the Victim(VC), Victim
      // Perpetrator(VP), or Client(CL) in both cases.
      if ((STAGE_PROGRAM_APS.equals(cdCaseProgram) || STAGE_PROGRAM_AFC.equals(cdCaseProgram)) && !bAPSVictim) {
        rowCcfc40Sog00 = new ROWCCFC40SOG00();
        rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_CFC_CMS_APS_PRN);
        rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);
      }
      // Multiple Subcare, Adoption, Post Adopt, and PAL stages cannot be open for the same
      // person ID (Note this cannot happen in the current design of the system).
      if (bDupStage) {
        rowCcfc40Sog00 = new ROWCCFC40SOG00();
        rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_CFC_CMS_DUP_STG);
        rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);
      }

      if (true == bMergeFromInv && false == bMergePend) {
        rowCcfc40Sog00 = new ROWCCFC40SOG00();
        rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_CFC_FROM_ID_INV);
        rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);
      }
    } else {
      rowCcfc40Sog00.setSzCdUerrorMsgNbr(Messages.MSG_CFC_FROM_ID_INV);
      rowccfc40sog00_array.addROWCCFC40SOG00(rowCcfc40Sog00);      
    }
    
    ccfc40so.setROWCCFC40SOG00_ARRAY(rowccfc40sog00_array);

    return ccfc40so;

  }

  private int CheckForReverseMerge(int idCaseMergeTo, int idCaseMergeFrom) {
    int RetVal = SUCCESS;

    // clsc67d
    List<CaseMerge> caseMergeList = caseMergeDAO.findByIdCaseMergeFrom(idCaseMergeTo);
    Iterator<CaseMerge> itCaseMergeList = caseMergeList.iterator();

    while (itCaseMergeList.hasNext()) {
      CaseMerge caseMerge = itCaseMergeList.next();

      if (!DateHelper.isNull(caseMerge.getDtCaseMerge())) {

        if ((idCaseMergeFrom == caseMerge.getCapsCaseByIdCaseMergeTo().getIdCase())
            && (idCaseMergeTo == caseMerge.getCapsCaseByIdCaseMergeFrom().getIdCase())) {
          RetVal = Messages.MSG_CIRCULAR_MERGE_NOT_ALLOWED;

          break;
        }
      }
    }
    return RetVal;
  }

  private boolean CallCompareIntakeDate(int idCaseTo, int idCaseFrom) {
    int caseToFlag = -1;
    int caseFromFlag = -1;

    boolean bCaseToInvOpen = false;
    boolean bCaseFromInvOpen = false;
    ROWCLSC59DO_ARRAY rowClsc59DoArrayTo = findRowClsc59DoArray(idCaseTo);
    Enumeration rowClsc59DoArrayTo_enum = rowClsc59DoArrayTo.enumerateROWCLSC59DO();

    while (rowClsc59DoArrayTo_enum.hasMoreElements()) {
      ROWCLSC59DO rowClsc59Do = (ROWCLSC59DO) rowClsc59DoArrayTo_enum.nextElement();
      Date dtStageClose = DateHelper.toJavaDate(rowClsc59Do.getDtDtStageClose());
      String cdStage = rowClsc59Do.getSzCdStage();

      if (!DateHelper.isNull(dtStageClose) && INTAKE.equals(cdStage)) {
        caseToFlag = 1;
      }

      if (DateHelper.isNull(dtStageClose) && INVESTIGATION.equals(cdStage)) {
        bCaseToInvOpen = true;
      }

      if (bCaseToInvOpen && caseToFlag >= 0) {
        break;// Break for success of cinv51d
      }
    }
    ROWCLSC59DO_ARRAY rowClsc59DoArrayFrom = findRowClsc59DoArray(idCaseFrom);
    Enumeration rowClsc59DoArrayFrom_enum = rowClsc59DoArrayFrom.enumerateROWCLSC59DO();
    boolean rowQtyFromGreaterThanZero = false;
    /*
     * There must always be a from-case for case-merge. if there is no row back from this DAO, we let the * validation
     * proccess to throw the right error message for the user.
     */
    while (rowClsc59DoArrayFrom_enum.hasMoreElements()) {
      rowQtyFromGreaterThanZero = true;
      ROWCLSC59DO rowClsc59Do = (ROWCLSC59DO) rowClsc59DoArrayFrom_enum.nextElement();
      Date dtStageClose = DateHelper.toJavaDate(rowClsc59Do.getDtDtStageClose());
      String cdStage = rowClsc59Do.getSzCdStage();

      if (!DateHelper.isNull(dtStageClose) && INTAKE.equals(cdStage)) {
        caseFromFlag = 1;
      }

      if (DateHelper.isNull(dtStageClose) && INVESTIGATION.equals(cdStage)) {
        bCaseFromInvOpen = true;
      }
      if (bCaseFromInvOpen && caseFromFlag >= 0) {
        break;
      }
    }
    boolean bSwitchCases = false;

    if (bCaseFromInvOpen && bCaseToInvOpen && rowQtyFromGreaterThanZero) {
      rowClsc59DoArrayFrom = updateDtIncomingCalAndFindRowClsc59DoArray(rowClsc59DoArrayFrom);
      rowClsc59DoArrayTo = updateDtIncomingCalAndFindRowClsc59DoArray(rowClsc59DoArrayTo);
      rowClsc59DoArrayFrom_enum = rowClsc59DoArrayFrom.enumerateROWCLSC59DO();
      rowClsc59DoArrayTo_enum = rowClsc59DoArrayTo.enumerateROWCLSC59DO();

      while (rowClsc59DoArrayFrom_enum.hasMoreElements() && rowClsc59DoArrayTo_enum.hasMoreElements()) {
        ROWCLSC59DO rowClsc59DoFrom = (ROWCLSC59DO) rowClsc59DoArrayFrom_enum.nextElement();
        ROWCLSC59DO rowClsc59DoTo = (ROWCLSC59DO) rowClsc59DoArrayTo_enum.nextElement();

        // if toStartDate or fromStartDate is not null
        Date dtStageStartTo = DateHelper.toJavaDate(rowClsc59DoTo.getDtDtStageStart());
        Date dtStageStartFrom = DateHelper.toJavaDate(rowClsc59DoFrom.getDtDtStageStart());
        if (!DateHelper.isNull(dtStageStartTo) && !DateHelper.isNull(dtStageStartFrom)) {

          if (DateHelper.isAfter(DateHelper.toJavaDate(rowClsc59DoTo.getDtDtStageStart()),
                                 DateHelper.toJavaDate(rowClsc59DoFrom.getDtDtStageStart()))) {
            bSwitchCases = true;
          }
        }
      }
    }

    return bSwitchCases;
  }

  private ROWCLSC59DO_ARRAY findRowClsc59DoArray(int idCase) {

    // clsc59d
    List<Stage> stageList = stageDAO.findStageByIdCase(idCase);
    ROWCLSC59DO_ARRAY rowClsc59DoArray = new ROWCLSC59DO_ARRAY();
    Iterator<Stage> it = stageList.iterator();

    while (it.hasNext()) {
      Stage stage = it.next();
      ROWCLSC59DO rowClsc59Do = new ROWCLSC59DO();
      CapsCase clscCapsCase = stage.getCapsCase();

      rowClsc59Do.setUlIdCase(clscCapsCase.getIdCase() != null ? clscCapsCase.getIdCase() : 0);
      rowClsc59Do.setUlIdStage(stage.getIdStage() != null ? stage.getIdStage() : 0);
      rowClsc59Do.setDtDtStageClose(DateHelper.toCastorDate(stage.getDtStageClose()));
      rowClsc59Do.setSzCdStage(stage.getCdStage());
      rowClsc59Do.setBIndStageClose(stage.getIndStageClose());
      rowClsc59DoArray.addROWCLSC59DO(rowClsc59Do);
    }

    return rowClsc59DoArray;
  }

  private ROWCLSC59DO_ARRAY updateDtIncomingCalAndFindRowClsc59DoArray(ROWCLSC59DO_ARRAY rowClsc59DoArray) {
    Enumeration rowClsc59DoArray_enum = rowClsc59DoArray.enumerateROWCLSC59DO();

    while (rowClsc59DoArray_enum.hasMoreElements()) {
      ROWCLSC59DO rowClsc59Do = (ROWCLSC59DO) rowClsc59DoArray_enum.nextElement();

      // csec54d
      Date dtIncomingCall = incomingDetailDAO.findIncomingDetailDtByIdStage(rowClsc59Do.getUlIdStage());
      rowClsc59Do.setDtDtStageStart(DateHelper.toCastorDate(dtIncomingCall));
    }

    return rowClsc59DoArray;
  }

  private boolean callCheckCasePending(int idCaseMergeTo, int idCaseMergeFrom) {
    boolean bLocalCasePending = false;

    bLocalCasePending = isCasePending(idCaseMergeTo, STAGE_PROGRAM_CCL, EVENT_STATUS_PEND);

    if (!bLocalCasePending) {
      bLocalCasePending = isCasePending(idCaseMergeFrom, STAGE_PROGRAM_CCL, EVENT_STATUS_PEND);
    }

    return bLocalCasePending;
  }

  private boolean isCasePending(int idCase, String cdEventType, String cdEventStatus) {
    // clss86d
   // Map eventMap = eventDAO.findEventAndStage(idCase, cdEventType, cdEventStatus);
    Map eventMap = eventDAO.findEventAndStageByIdCaseByCdEventStatus( idCase, cdEventStatus);
    boolean pbCasePending;

    if (eventMap != null && !eventMap.isEmpty()) {
      pbCasePending = true;
    } else {
      pbCasePending = false;
    }

    return pbCasePending;
  }

}