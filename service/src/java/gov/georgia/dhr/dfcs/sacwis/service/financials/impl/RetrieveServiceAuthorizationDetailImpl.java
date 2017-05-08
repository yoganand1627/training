package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ServiceAuthorizationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpecialNeedsDeterminationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContractService;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.SpecialNeedsDetermination;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveServiceAuthorizationDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON22SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON22SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON22SOG02_ARRAY;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* Change History:
Date        User              Description
--------    ----------------  --------------------------------------------------
 02/25/2010  mxpatel           SMS #45293: Modified code so that values can be populated correctly.
 01/31/2012	 vcollooru		   STGAP00017831: MR-102: Modified to make changes to save/retrieve the
 							   comments added in the new field Reason for Referral/Other Comments.
*/

public class RetrieveServiceAuthorizationDetailImpl extends BaseServiceImpl implements
                                                                           RetrieveServiceAuthorizationDetail {

  private ServiceAuthorizationDAO serviceAuthorizationDAO = null;

  private PersonDAO personDAO = null;

  private ContractServiceDAO contractServiceDAO = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  private SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO = null;  
  
  private SvcAuthDetailDAO svcAuthDetailDAO = null;

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setServiceAuthorizationDAO(ServiceAuthorizationDAO serviceAuthorizationDAO) {
    this.serviceAuthorizationDAO = serviceAuthorizationDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setContractServiceDAO(ContractServiceDAO contractServiceDAO) {
    this.contractServiceDAO = contractServiceDAO;
  }
  
  public void setSpecialNeedsDeterminationDAO(SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO) {
    this.specialNeedsDeterminationDAO = specialNeedsDeterminationDAO;
  }
  
  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }

  public CCON22SO retrieveServiceAuthorizationDetail(CCON22SI ccon22si) throws ServiceException {
    CCON22SO ccon22so = new CCON22SO();
    ROWCCON22SOG01 rowccon22sog01 = new ROWCCON22SOG01();
    ROWCCON22SOG00_ARRAY personArray = new ROWCCON22SOG00_ARRAY();
    ROWCCON22SOG02_ARRAY codesArray = new ROWCCON22SOG02_ARRAY();
    String szSysCdWinMode = ccon22si.getSzSysCdWinMode();
    // Pre-compute boolean variables for the if statements below.
    boolean isModify = PageModeConstants.MODIFY.equals(szSysCdWinMode);
    boolean isInquire = PageModeConstants.INQUIRE.equals(szSysCdWinMode);
    boolean isNew = PageModeConstants.NEW.equals(szSysCdWinMode);
    int idSvcAuthDtl = ccon22si.getUlIdSvcAuthDtl();

    if (isModify || isInquire || (isNew && 0 != idSvcAuthDtl)) {
      // cses25d
      rowccon22sog01 = queryServiceAuthorization(idSvcAuthDtl);
    }
    
    Integer idSpNeedsDet = null;
    // MR-52 User associates an approved Adoption Assistance Application to a Special Services Service Authorization
    // <Type> Special Service has been approved for <amount>
    if (isModify || isInquire) {
      idSpNeedsDet = rowccon22sog01.getUlIdAdopAssistAppl();
    } else if (isNew ) {
      idSpNeedsDet = ccon22si.getUlIdAdopAssistAppl();
    }
    SpecialNeedsDetermination snd = null;
    if (idSpNeedsDet != null) {
      snd = specialNeedsDeterminationDAO.findSpecialNeedsDeterminationByIdEvent(idSpNeedsDet);
      if (snd != null) {
        String specialServiceType = snd.getCdSpclSerType();
        double approvedAmount = snd.getNbrApprvAmt();
        ccon22so.setSzCdSplServType(specialServiceType);
        ccon22so.setSzSpcSvcAprvAmt(approvedAmount);
      }
    }
    
    if (isNew || isModify) {
      // clsc19d
      codesArray = findServicesContractedInCounty(ccon22si.getSzCdSvcAuthCounty(), ccon22si.getUlIdContract(),
                                                  ccon22si.getUlNbrCnverVersion(), ccon22si.getUlNbrCnperPeriod());
    }
    if (isNew || isModify) {
      // Calling cses26d
      Stage stage = stageDAO.findStageAndSituation(ccon22si.getUlIdStage());
      if (stage == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      ccon22so.setDtDtSituationOpened(DateHelper.toCastorDate(stage.getSituation().getDtSituationOpened()));
      ccon22so.setDtDtStageClose(DateHelper.toCastorDate(stage.getDtStageClose()));
      ccon22so.setDtDtStageStart(DateHelper.toCastorDate(stage.getDtStageStart()));
    }
    if (isNew && 0 == ccon22si.getUlIdSvcAuthDtl()) {
      // clsc18d
      List<String> stagePersonType = new ArrayList<String>();
      
      if(snd == null) {
        stagePersonType.add(CodesTables.CPRSNALL_COL);
        stagePersonType.add(CodesTables.CPRSNALL_PRN);
        personArray = findStagePersonLink(ccon22si.getUlIdStage(), stagePersonType, true);
      } else {
        //only the primary child for 510 512
        personArray = findStagePersonLink(ccon22si.getUlIdStage(), stagePersonType, false);
        String specialServiceType = snd.getCdSpclSerType();
        //look at 512
        if(specialServiceType != null && specialServiceType.length() > 0) {
          if (CodesTables.CSPLSERV_ORT.equals(specialServiceType)) {
            rowccon22sog01.setSzCdSvcAuthDtlSvc(CodesTables.CSVCCODE_51258C);
          } else if (CodesTables.CSPLSERV_MED.equals(specialServiceType)) {
            rowccon22sog01.setSzCdSvcAuthDtlSvc(CodesTables.CSVCCODE_51258A);
          } else if (CodesTables.CSPLSERV_TCS.equals(specialServiceType)) {
            rowccon22sog01.setSzCdSvcAuthDtlSvc(CodesTables.CSVCCODE_51258B);
          } else if (CodesTables.CSPLSERV_XXX.equals(specialServiceType)) {
            rowccon22sog01.setSzCdSvcAuthDtlSvc(CodesTables.CSVCCODE_51258D);
          } else if (CodesTables.CSPLSERV_DCR.equals(specialServiceType)) {
            rowccon22sog01.setSzCdSvcAuthDtlSvc(CodesTables.CSVCCODE_51217);
          } else if (CodesTables.CSPLSERV_RES.equals(specialServiceType)) {
            rowccon22sog01.setSzCdSvcAuthDtlSvc(CodesTables.CSVCCODE_51260);
          }
          rowccon22sog01.setDtDtSvcAuthDtlBegin(DateHelper.toCastorDate(snd.getDtApprvDate()));
          rowccon22sog01.setDtDtSvcAuthDtlEnd(DateHelper.toCastorDate(snd.getDtExpirationDate()));
          
          List<SvcAuthDetail> lstSvcAuthDetailTrm = svcAuthDetailDAO.findAllServAuthTermByIdSpcNeedsDet(idSpNeedsDet);
          if (lstSvcAuthDetailTrm != null) {
            Date beginDate = null;
            double unitsAva = 0.0;
            double amount = 0.0;
            Iterator<SvcAuthDetail> itSvcAuthDetail = lstSvcAuthDetailTrm.iterator();
            while (itSvcAuthDetail.hasNext()) {
              SvcAuthDetail svcAuthDetail = itSvcAuthDetail.next();
              if (DateHelper.isNull(svcAuthDetail.getDtSvcAuthDtlTerm()) == false) {
                if ((beginDate == null)) {
                  beginDate = svcAuthDetail.getDtSvcAuthDtlTerm();
                  unitsAva = svcAuthDetail.getNbrSvcAuthDtlUnitsReq() - svcAuthDetail.getNbrSvcAuthDtlUnitUsed();
                  amount = svcAuthDetail.getAmtSvcAuthDtlAmtReq() - svcAuthDetail.getAmtSvcAuthDtlAmtUsed();
                }
              }
            }
            if (DateHelper.isNull(beginDate) == false) {
              beginDate = DateHelper.addToDate(beginDate, 0, 0, 1);
              rowccon22sog01.setDtDtSvcAuthDtlBegin(DateHelper.toCastorDate(beginDate));
            }
            rowccon22sog01.setLNbrSvcAuthDtlUnitReq(unitsAva);
            rowccon22sog01.setLAmtSvcAuthDtlAmtReq(amount);
          } else {
            List<SvcAuthDetail> lstSvcAuthDetail = svcAuthDetailDAO.findAllServAuthByIdSpcNeedsDet(idSpNeedsDet);
            if (lstSvcAuthDetail != null) {
              Date beginDate = null;
              double unitsAva = 0.0;
              double amount = 0.0;
              Iterator<SvcAuthDetail> itSvcAuthDetail = lstSvcAuthDetail.iterator();
              while (itSvcAuthDetail.hasNext()) {
                SvcAuthDetail svcAuthDetail = itSvcAuthDetail.next();
                if (DateHelper.isNull(svcAuthDetail.getDtSvcAuthDtlTerm()) == false) {
                  if ((beginDate == null)) {
                    beginDate = svcAuthDetail.getDtSvcAuthDtlTerm();
                    unitsAva = svcAuthDetail.getNbrSvcAuthDtlUnitsReq() - svcAuthDetail.getNbrSvcAuthDtlUnitUsed();
                    amount = svcAuthDetail.getAmtSvcAuthDtlAmtReq() - svcAuthDetail.getAmtSvcAuthDtlAmtUsed();
                  }
                }
              }
              if (DateHelper.isNull(beginDate) == false) {
                beginDate = DateHelper.addToDate(beginDate, 0, 0, 1);
                rowccon22sog01.setDtDtSvcAuthDtlBegin(DateHelper.toCastorDate(beginDate));
              }
              rowccon22sog01.setLNbrSvcAuthDtlUnitReq(unitsAva);
              rowccon22sog01.setLAmtSvcAuthDtlAmtReq(amount);
            }
          }
        }
      }
    }
    ccon22so.setROWCCON22SOG01(rowccon22sog01);
    ccon22so.setROWCCON22SOG02_ARRAY(codesArray);
    ccon22so.setROWCCON22SOG00_ARRAY(personArray);
    return ccon22so;
  }

  public ROWCCON22SOG01 queryServiceAuthorization(int idSvcAuthDtl) throws ServiceException {
    // Calling cses25d
    SvcAuthDetail svcAuthDetail = serviceAuthorizationDAO.findServiceAuthDetail(idSvcAuthDtl);
    if (svcAuthDetail == null) {
      throw new ServiceException(Messages.MSG_DETAIL_DELETED);
    }
    ROWCCON22SOG01 rowccon22sog01 = new ROWCCON22SOG01();
    rowccon22sog01.setSzCdSvcAuthDtlAuthType(svcAuthDetail.getCdSvcAuthDtlAuthType());
    rowccon22sog01.setSzCdSvcAuthDtlPeriod(svcAuthDetail.getCdSvcAuthDtlPeriod());
    rowccon22sog01.setSzCdSvcAuthDtlSvc(svcAuthDetail.getCdSvcAuthDtlSvc());
    rowccon22sog01.setSzCdSvcAuthDtlUnitType(svcAuthDetail.getCdSvcAuthDtlUnitType());
    rowccon22sog01.setDtDtSvcAuthDtl(DateHelper.toCastorDate(svcAuthDetail.getDtSvcAuthDtl()));
    rowccon22sog01.setDtDtSvcAuthDtlBegin(DateHelper.toCastorDate(svcAuthDetail.getDtSvcAuthDtlBegin()));
    rowccon22sog01.setDtDtSvcAuthDtlEnd(DateHelper.toCastorDate(svcAuthDetail.getDtSvcAuthDtlEnd()));
    rowccon22sog01.setDtDtSvcAuthDtlTerm(DateHelper.toCastorDate(svcAuthDetail.getDtSvcAuthDtlTerm()));
    rowccon22sog01.setDtSvcAuthDtlShow(DateHelper.toCastorDate(svcAuthDetail.getDtSvcAuthDtlShow()));
    rowccon22sog01.setTsLastUpdate(svcAuthDetail.getDtLastUpdate());
    rowccon22sog01.setIndServAcpt(svcAuthDetail.getIndServAcpt());
    rowccon22sog01.setIndCasePlanSvc(svcAuthDetail.getIndCasePlnSvc());
    rowccon22sog01.setSzCdSvcQlty(svcAuthDetail.getCdSvcQlty());
    rowccon22sog01.setSzTxtRefQltyCmnts(svcAuthDetail.getTxtCmmts());
    rowccon22sog01.setUlIdPerson(svcAuthDetail.getPerson().getIdPerson() != null ? svcAuthDetail.getPerson()
                                                                                                .getIdPerson() : 0);
    rowccon22sog01.setUlIdSvcAuthDtl(svcAuthDetail.getIdSvcAuthDtl() != null ? svcAuthDetail.getIdSvcAuthDtl() : 0);
    rowccon22sog01.setLAmtSvcAuthDtlAmtReq(svcAuthDetail.getAmtSvcAuthDtlAmtReq());
    Double amtSvcAuthDtlAmtUsed = svcAuthDetail.getAmtSvcAuthDtlAmtUsed();
    rowccon22sog01.setLAmtSvcAuthDtlAmtUsed(amtSvcAuthDtlAmtUsed != null ? amtSvcAuthDtlAmtUsed : 0.0);
    rowccon22sog01
                  .setUNbrSvcAuthDtlFreq(svcAuthDetail.getNbrSvcAuthDtlFreq() != null ? svcAuthDetail
                                                                                                     .getNbrSvcAuthDtlFreq()
                                                                                     : 0);
    rowccon22sog01
                  .setUlNbrSvcAuthDtlLineItm(svcAuthDetail.getNbrSvcAuthDtlLineItm() != null ? svcAuthDetail
                                                                                                            .getNbrSvcAuthDtlLineItm()
                                                                                            : 0);
    rowccon22sog01
                  .setLNbrSvcAuthDtlSugUnit(svcAuthDetail.getNbrSvcAuthDtlSugUnit() != null ? svcAuthDetail
                                                                                                           .getNbrSvcAuthDtlSugUnit()
                                                                                           : 0);
    rowccon22sog01.setLNbrSvcAuthDtlUnitRate(svcAuthDetail.getNbrSvcAuthDtlUnitRate());
    Double nbrSvcAuthDtlUnitUsed = svcAuthDetail.getNbrSvcAuthDtlUnitUsed();
    rowccon22sog01.setLNbrSvcAuthDtlUnitUsed(nbrSvcAuthDtlUnitUsed != null ? nbrSvcAuthDtlUnitUsed : 0.0);
    rowccon22sog01.setLNbrSvcAuthDtlUnitReq(svcAuthDetail.getNbrSvcAuthDtlUnitsReq());
    rowccon22sog01.setSzTxtCommentsAdditional(svcAuthDetail.getTxtCmmtsAdditional());
    SpecialNeedsDetermination specialNeedsDetermination = svcAuthDetail.getSpecialNeedsDetermination();
    if(specialNeedsDetermination != null && specialNeedsDetermination.getIdEvent() > 0) {
      rowccon22sog01.setUlIdAdopAssistAppl(specialNeedsDetermination.getIdEvent());
    }
    
    // Calling cinv81d
    Person person = personDAO.findPersonByIdPerson(svcAuthDetail.getPerson().getIdPerson());
    if (person != null) {
      rowccon22sog01.setSzNmPersonFull(person.getNmPersonFull());
    } else {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return rowccon22sog01;
  }

  public ROWCCON22SOG02_ARRAY findServicesContractedInCounty(String cdSvcAuthCounty, int idContract,
                                                             int nbrCnverVersion, int nbrCnperPeriod)
                                                                                                     throws ServiceException {
    // Calling clsc19d
    List<Object[]> objectArrayList = contractServiceDAO.findServicesContractedInCounty(cdSvcAuthCounty, idContract,
                                                                                       nbrCnverVersion, nbrCnperPeriod);
    if (objectArrayList == null || objectArrayList.isEmpty()) {
      throw new ServiceException(Messages.MSG_CON_CONTRACT_SVC);
    }
    ROWCCON22SOG02_ARRAY rowccon22sogo2_array = new ROWCCON22SOG02_ARRAY();
    for (Iterator<Object[]> it = objectArrayList.iterator(); it.hasNext();) {
      Object[] objArray = it.next();
      ContractService contractService = (ContractService) objArray[0];
      ROWCCON22SOG02 rowccon22sogo2 = new ROWCCON22SOG02();
      rowccon22sogo2.setSzCdCnsvcPaymentType(contractService.getCdCnsvcPaymentType());
      rowccon22sogo2.setSzCdCnsvcService(contractService.getCdCnsvcService());
      rowccon22sogo2.setSzNbrCnsvcUnitType(contractService.getCdCnsvcUnitType());
      rowccon22sogo2
                    .setUlNbrCnsvcLineItem(contractService.getNbrCnsvcLineItem() != null ? contractService
                                                                                                          .getNbrCnsvcLineItem()
                                                                                        : 0);
      rowccon22sogo2
                    .setUlNbrCnsvcUnitRate(contractService.getNbrCnsvcUnitRate() != null ? contractService
                                                                                                          .getNbrCnsvcUnitRate()
                                                                                        : 0);
      rowccon22sogo2_array.addROWCCON22SOG02(rowccon22sogo2);
    }
    return rowccon22sogo2_array;
  }

  public ROWCCON22SOG00_ARRAY findStagePersonLink(int idStage, List<String> stagePersonType, boolean allTypes) throws ServiceException {
    // Calling clsc18d

    List<StagePersonLink> stagePersonLinkList = null
    ;
    if(allTypes == true) {
      stagePersonLinkList = stagePersonLinkDAO.findAnyTypeLinkedToStage(idStage, stagePersonType);
    } else {
      stagePersonLinkList = stagePersonLinkDAO.findPrimaryChildrenByIdStage(idStage);
    }
    
    if (stagePersonLinkList == null || stagePersonLinkList.isEmpty()) {
      throw new ServiceException(Messages.MSG_CON_PRINCIPLE);
    }
    ROWCCON22SOG00_ARRAY rowccon22sogoo_array = new ROWCCON22SOG00_ARRAY();
    for (Iterator<StagePersonLink> it = stagePersonLinkList.iterator(); it.hasNext();) {
      StagePersonLink stagePersonLink = it.next();
      ROWCCON22SOG00 rowccon22sogoo = new ROWCCON22SOG00();
      rowccon22sogoo.setSzCdStagePersRelInt(stagePersonLink.getCdStagePersRelInt());
      rowccon22sogoo.setSzCdStagePersRole(stagePersonLink.getCdStagePersRole());
      rowccon22sogoo.setSzNmPersonFull(stagePersonLink.getPerson().getNmPersonFull());
      rowccon22sogoo.setUlIdPerson(stagePersonLink.getPerson().getIdPerson() != null ? stagePersonLink.getPerson()
                                                                                                      .getIdPerson()
                                                                                    : 0);
      rowccon22sogoo_array.addROWCCON22SOG00(rowccon22sogoo);
    }
    return rowccon22sogoo_array;
  }
}
