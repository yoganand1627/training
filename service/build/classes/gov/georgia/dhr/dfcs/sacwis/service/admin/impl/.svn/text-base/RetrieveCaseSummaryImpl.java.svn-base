package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalStatusDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StffAsgnmtHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.LegalStatus;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveCaseSummary;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN37SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN37SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST;
import gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST_ARRAY;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.exolab.castor.types.Date;

/**
 * This is the Service that retrieves Case Summary records from the Database. <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   11/03/08  vdevarak  STGAP00010749 - Added code to retrieve the ADO case
 *                       stages in addition to the PAD case stages when the user
 *                       has SAU Sealed attribute. 
 *   07/17/09  bgehlot   STGAP00014341: MR51- Stage Reopen Changes
 *   08/30/10  wjcochran SMS #66752: Updated to work with the red flag indicator
 *   11/09/2010  arege   SMS#77106: User should be able to reopen a stage if a Legal Status of NAF for the child in the given case does not exist.
 * </pre>
 */
 
public class RetrieveCaseSummaryImpl extends BaseServiceImpl implements RetrieveCaseSummary {

  private static final String STAGE_MERGED = ArchitectureConstants.Y;

  private static final String STAGE_NOT_MERGED = ArchitectureConstants.N;

  private static final String CLOSED_TO_MERGE = CodesTables.CCLOSTYP_97;

  private static final String ADOPTION_FINALIZED = CodesTables.CCLOSADO_ADF;

  private CapsCaseDAO capsCaseDAO = null;

  private StageDAO stageDAO = null;

  private StffAsgnmtHistoryDAO stffAsgnmtHistoryDAO = null;

  private StageLinkDAO stageLinkDAO = null;
  
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  private LegalStatusDAO legalStatusDAO = null;

  public void setStageLinkDAO(StageLinkDAO stageLinkDAO) {
    this.stageLinkDAO = stageLinkDAO;
  }

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStffAsgnmtHistoryDAO(StffAsgnmtHistoryDAO stffAsgnmtHistoryDAO) {
    this.stffAsgnmtHistoryDAO = stffAsgnmtHistoryDAO;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO){
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setLegalStatusDAO(LegalStatusDAO legalStatusDAO){
    this.legalStatusDAO = legalStatusDAO;
  }

  public CCMN37SO retrieveCaseSummary(CCMN37SI ccmn37si) throws ServiceException {
    CCMN37SO ccmn37so = new CCMN37SO();
    int idCase = ccmn37si.getUlIdCase();
    String usrIndSealed = ccmn37si.getCScrIndSealed();
    //STGAP00010749: Get the PAD case indicator, PAD case Id and ADO case ID 
    String indPadCase = ccmn37si.getBIndPadCase();
    int idAdoCase = ccmn37si.getUlIdAdoCase();
    int idPadCase = ccmn37si.getUlIdPadCase();
    // ccmnd9d
    CapsCase capsCase = capsCaseDAO.findCapsCaseByIdCase(idCase);
    if (capsCase == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCCMN37SOG01 rowccmn37sog01 = new ROWCCMN37SOG01();
    rowccmn37sog01.setSzCdCaseRegion(capsCase.getCdCaseRegion());
    rowccmn37sog01.setSzCdCaseCounty(capsCase.getCdCaseCounty());
    rowccmn37sog01.setSzCdCaseSpeclHndlg(capsCase.getCdCaseSpecialHandling());
    rowccmn37sog01.setSzNmCase(capsCase.getNmCase());
    rowccmn37sog01.setDtDtCaseClosed(DateHelper.toCastorDate(capsCase.getDtCaseClosed()));
    rowccmn37sog01.setDtDtCaseOpened(DateHelper.toCastorDate(capsCase.getDtCaseOpened()));
    rowccmn37sog01.setBIndCaseSensitive(capsCase.getIndCaseSensitive());
    rowccmn37sog01.setBIndCaseWorkerSafety(capsCase.getIndCaseWorkerSafety());
    ccmn37so.setROWCCMN37SOG01(rowccmn37sog01);
    ArchInputStruct archInputStruct = ccmn37si.getArchInputStruct();
    // STGAP00010749: Get case sensitive indicator
    String caseIndSensitive = capsCase.getIndCaseSensitive() == null ? ArchitectureConstants.N
                                                                    : capsCase.getIndCaseSensitive();
    // ccmn15d
    ccmn37so.setROWCCMN37SOG02_ARRAY(findCaseSummaryStages(ccmn37si.getSzCdStageProgram(), usrIndSealed,
                                                           caseIndSensitive, idCase, archInputStruct.getUsPageNbr(),
                                                           archInputStruct.getUlPageSizeNbr(), ccmn37so,
                                                           indPadCase, idAdoCase, idPadCase));

    ccmn37so.setSTFFASSGNMTHIST_ARRAY(getStffAsgnmtHistoryArray(idCase));

    return ccmn37so;
  }

  private ROWCCMN37SOG02_ARRAY findCaseSummaryStages(String cdStageProgram, String usrIndSealed,
                                                     String caseIndSensitive, int idCase, int pageNbr, int pageSize,
                                                     CCMN37SO ccmn37so, String indComingFromPadCase, int idAdoCase,
                                                     int idPadCase) throws ServiceException {
    List<Object[]> stageDAOList = null;
    //STGAP00014341
    Map legalStatus = null;
    // ccmn15d
    //if usrIndSealed == 'Y' means, the user has access to the sealed ADO and FCC records
    if (ArchitectureConstants.N.equals(usrIndSealed)){
        //Remove the ADO and FCC stages from the list if the user doesn't have SAU Sealed
        //security attribute which looks for IND_STAGE_SEALED column.
        stageDAOList = stageDAO.findCPSSealedCaseSummaryStages(idCase, CodesTables.CROLEALL_PR, CodesTables.CROLEALL_HP,
                                                       pageNbr, pageSize);
    } else {
      // STGAP00010749 : Check if the case is a PAD case. If it is see if there is a case with prior ADO stage
      // to the PAD stage in the system. If there is than set the Pad case indicator to yes and set the 
      // ADO case Id and the PAD case Ids into the 'SO' object.
      Integer padStageId = stageDAO.findOpenPadStageByIdCaseCdStage(idCase, CodesTables.CSTAGES_PAD);
      Integer idAdoStage = 0;
      boolean indShowAdoStages = false;
      List<Integer> lstCaseId = new ArrayList<Integer>();
      if (padStageId != null && padStageId > 0) {
        idAdoStage = stageLinkDAO.findPreviousIdStagebyIdStage(padStageId);
      }
      if (ArchitectureConstants.Y.equals(usrIndSealed) && idAdoStage != null && idAdoStage > 0) {
        Stage adoStage = stageDAO.findStageAndCapsCase(idAdoStage);
        if (adoStage != null && adoStage.getCapsCase() != null) {
          indShowAdoStages = true;
          lstCaseId.add(idCase);
          lstCaseId.add(adoStage.getCapsCase().getIdCase());
          ccmn37so.setBIndPadCase(ArchitectureConstants.Y);
          ccmn37so.setUlIdAdoCase(adoStage.getCapsCase().getIdCase());
          ccmn37so.setUlIdPadCase(idCase);
        }
      }
      if (ArchitectureConstants.Y.equals(usrIndSealed) && ArchitectureConstants.Y.equals(indComingFromPadCase)) {
        indShowAdoStages = true;
        lstCaseId.add(idAdoCase);
        lstCaseId.add(idPadCase);
      }
      //STGAP00010749: if the user has SAU Sealed attribute and the case is PAD case than get the list of all stages 
      //in the PAD case and the ADO case else just get the stages for the given case.
      if (indShowAdoStages) {
        stageDAOList = stageDAO.findCPSCaseSummaryStagesForPadCase(lstCaseId, CodesTables.CROLEALL_PR,
                                                                   CodesTables.CROLEALL_HP, pageNbr, pageSize);
      } else {
        stageDAOList = stageDAO.findCPSCaseSummaryStages(idCase, CodesTables.CROLEALL_PR, CodesTables.CROLEALL_HP,
                                                         pageNbr, pageSize);
      }
    }
    ROWCCMN37SOG02_ARRAY rowccmn37sog02_array = new ROWCCMN37SOG02_ARRAY();
    if (stageDAOList == null || stageDAOList.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    for (Iterator<Object[]> it = stageDAOList.iterator(); it.hasNext();) {
      Object[] stageDAOListItem = it.next();
      ROWCCMN37SOG02 rowccmn37sog02 = new ROWCCMN37SOG02();
      String nmStage = (String) stageDAOListItem[0];
      String cdStage = (String) stageDAOListItem[1];
      String cdStageCounty = (String) stageDAOListItem[4];
      String damCdStageProgram = (String) stageDAOListItem[5];
      Date dtStageStart = DateHelper.toCastorDate((java.sql.Date) stageDAOListItem[2]);
      Date dtStageClose = DateHelper.toCastorDate((java.sql.Date) stageDAOListItem[3]);
      BigDecimal idSit = (BigDecimal) stageDAOListItem[6];
      Integer idSituation = idSit.intValue();
      BigDecimal idDamStage = (BigDecimal) stageDAOListItem[7];
      String indEcsVer = (String) stageDAOListItem[9];
      Integer damIdStage = idDamStage.intValue();
      String cdStageReasonClosed = (String) stageDAOListItem[8];
      BigDecimal idPer = (BigDecimal) stageDAOListItem[10];
      Integer idPerson = idPer.intValue();
      String nmPersonFull = (String) stageDAOListItem[11];
      String indStageClose = (String) stageDAOListItem[12];
      String indRedFlag = (String) stageDAOListItem[13];
      // ADAM
      Integer idStageCase = idCase;
      if (stageDAOListItem.length > 14) {
        idStageCase = ((BigDecimal) stageDAOListItem[14]).intValue();
      }
      rowccmn37sog02.setSzNmPersonFull(nmPersonFull);

      rowccmn37sog02.setSzNmStage(nmStage);
      rowccmn37sog02.setSzCdStage(cdStage);
      rowccmn37sog02.setBIndEcsVer(indEcsVer);
      rowccmn37sog02.setBIndRedFlag(indRedFlag);
      rowccmn37sog02.setSzCdStageCounty(cdStageCounty);
      rowccmn37sog02.setSzCdStageProgram(damCdStageProgram);
      rowccmn37sog02.setDtDtStageStart(dtStageStart);
      rowccmn37sog02.setDtDtStageClose(dtStageClose);
      rowccmn37sog02.setUlIdSituation(idSituation != null ? idSituation : 0);
      rowccmn37sog02.setUlIdStage(damIdStage != null ? damIdStage : 0);
      rowccmn37sog02.setUlIdPerson(idPerson != null ? idPerson : 0);
      // ADAM
      rowccmn37sog02.setUlIdCase(idStageCase != null ? idStageCase : 0);
      if (CLOSED_TO_MERGE.equals(cdStageReasonClosed)) {
        rowccmn37sog02.setCScrIndStageMerged(STAGE_MERGED);
      } else {
        rowccmn37sog02.setCScrIndStageMerged(STAGE_NOT_MERGED);
      }
      // STGAP00010153-Check for ADO Stage Closure with reason "Adoption Finalized" with close indicator of Y
      // then set the sealed indicator as Y
      if (ADOPTION_FINALIZED.equals(cdStageReasonClosed) && CodesTables.CSTAGES_ADO.equals(cdStage)
          && ArchitectureConstants.Y.equals(indStageClose)) {
        rowccmn37sog02.setCScrIndSealed(ArchitectureConstants.Y);
      } else {
        rowccmn37sog02.setCScrIndSealed(ArchitectureConstants.N);
      }
      
      // STGAP00014341-Check for ADO Stage Closure with reason "Adoption Finalized" with close indicator of Y
      // then set the sealed indicator as Y
      if(CodesTables.CSTAGES_ADO.equals(cdStage) || CodesTables.CSTAGES_SUB.equals(cdStage)){
        Integer idPrimaryChild = stagePersonLinkDAO.findIdPersonForChildByIdStage(damIdStage);
        if(idPrimaryChild != null){
          List<String> cdStages = new ArrayList<String>();
          cdStages.add(CodesTables.CSTAGES_ADO);
          cdStages.add(CodesTables.CSTAGES_SUB);
          cdStages.add(CodesTables.CSTAGES_INV);
          cdStages.add(CodesTables.CSTAGES_PAD);
          int idPrimaryChildInt = idPrimaryChild.intValue();
          legalStatus = legalStatusDAO.findLegalStatusByIdCaseByIdPersonByCdStatusByCdStages(idStageCase, idPrimaryChildInt, CodesTables.CLEGSTAT_NAF, cdStages);
         //legalStatus = legalStatusDAO.findMostRecentLegalStatusbyIdPersonAndLegalStatStatus(idPrimaryChild, CodesTables.CLEGSTAT_NAF);
        }
      }
      if (legalStatus == null && CodesTables.CSTAGES_ADO.equals(cdStage)
          && ArchitectureConstants.Y.equals(indStageClose) && dtStageClose != null) {
        rowccmn37sog02.setBIndStageReopenADO(ArchitectureConstants.Y);
      } else {
        rowccmn37sog02.setBIndStageReopenADO(ArchitectureConstants.N);
      }
      
      // STGAP00014341-Check for ADO Stage Closure with reason "Adoption Finalized" with close indicator of Y
      // then set the sealed indicator as Y
      if (legalStatus == null && CodesTables.CSTAGES_SUB.equals(cdStage)
          && ArchitectureConstants.Y.equals(indStageClose) && dtStageClose != null) {
        rowccmn37sog02.setBIndStageReopenSUB(ArchitectureConstants.Y);
      } else {
        rowccmn37sog02.setBIndStageReopenSUB(ArchitectureConstants.N);
      }
      
      //STGAP00014341: Check for if the DIV has been progressed to INV if it is then it cannot be reopened
      if(CodesTables.CSTAGES_DIV.equals(cdStage) && ArchitectureConstants.Y.equals(indStageClose) && dtStageClose != null){
        Stage stage = stageLinkDAO.findNewIdStageByIdPriorStage( rowccmn37sog02.getUlIdStage());
        if(stage != null && CodesTables.CSTAGES_INV.equals(stage.getCdStage())){
          rowccmn37sog02.setBIndStageReopenDIV(ArchitectureConstants.N);
        }else{
          rowccmn37sog02.setBIndStageReopenDIV(ArchitectureConstants.Y);
        }
        
      }
      
      // STGAP00014341-Check if the stages are INt, INv, FAD, ARI. These stages cannot be reopened
      if (CodesTables.CSTAGES_INT.equals(cdStage) || CodesTables.CSTAGES_INV.equals(cdStage) || CodesTables.CSTAGES_FAD.equals(cdStage)
                      || CodesTables.CSTAGES_ARI.equals(cdStage)) {
        rowccmn37sog02.setBIndStageReopenSUB(ArchitectureConstants.N);
      } 
      
      // STGAP00014341- If the dtStageClose is null stages cannot be reopened as they are already open
      if (dtStageClose == null) {
        rowccmn37sog02.setBIndStageReopenSUB(ArchitectureConstants.N);
      } 
      
      rowccmn37sog02_array.addROWCCMN37SOG02(rowccmn37sog02);
    }
    return rowccmn37sog02_array;
  }

  private STFFASSGNMTHIST_ARRAY getStffAsgnmtHistoryArray(int idCase) throws ServiceException {

    List<Map> stffAssignmentHistoryList = stffAsgnmtHistoryDAO.findStffAsgnmtHistoryByIdCase(idCase);

    if (stffAssignmentHistoryList == null || stffAssignmentHistoryList.isEmpty()) {
      // throw new ServiceException(Messages.SQL_NOT_FOUND);
      return null;
    }

    STFFASSGNMTHIST_ARRAY stffAssgnmtHist_Array = new STFFASSGNMTHIST_ARRAY();

    for (Iterator<Map> it = stffAssignmentHistoryList.iterator(); it.hasNext()
                                                                  && stffAssgnmtHist_Array.getSTFFASSGNMTHISTCount() < 50;) {
      Map stffAssgnmtHistMap = it.next();

      STFFASSGNMTHIST stffAssgnmtHistRow = new STFFASSGNMTHIST();

      stffAssgnmtHistRow.setSzNmFromPerson((String) stffAssgnmtHistMap.get("nmFromPerson"));
      stffAssgnmtHistRow.setSzNmToPerson((String) stffAssgnmtHistMap.get("nmToPerson"));
      stffAssgnmtHistRow.setSzNmEnteredByPerson((String) stffAssgnmtHistMap.get("nmEnteredByPerson"));
      stffAssgnmtHistRow.setSzCdStage((String) stffAssgnmtHistMap.get("cdStage"));
      stffAssgnmtHistRow.setSzCdFromCounty((String) stffAssgnmtHistMap.get("cdFromPersonCounty"));
      stffAssgnmtHistRow.setSzCdToCounty((String) stffAssgnmtHistMap.get("cdToPersonCounty"));
      stffAssgnmtHistRow
                        .setDtDtLastUpdate(DateHelper
                                                     .toCastorDate((java.util.Date) stffAssgnmtHistMap
                                                                                                      .get("dtLastUpdate")));
      stffAssgnmtHistRow.setUlIdStage((Integer) stffAssgnmtHistMap.get("idStage"));

      stffAssgnmtHist_Array.addSTFFASSGNMTHIST(stffAssgnmtHistRow);
    }

    return stffAssgnmtHist_Array;
  }
}
