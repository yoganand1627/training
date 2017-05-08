package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdminReviewDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdminReview;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveAdminReview;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC43SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC43SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC43SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG02_ARRAY;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RetrieveAdminReviewImpl extends BaseServiceImpl implements RetrieveAdminReview {

  private AdminReviewDAO adminReviewDAO = null;
  private EventDAO eventDAO = null;
  private PersonDAO personDAO = null;
  private StageDAO stageDAO = null;
  private StagePersonLinkDAO stagePersonLinkDAO = null;

  public static final String ADMIN_REVIEW_NARRATIVE = "admin_review_narr";

  public void setAdminReviewDAO(AdminReviewDAO adminReviewDAO) {
    this.adminReviewDAO = adminReviewDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
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

  public CCFC43SO retrieveAdminReview(CCFC43SI ccfc43si) throws ServiceException {
    CCFC43SO ccfc43so = new CCFC43SO();
    int ccfc43siIdEvent = ccfc43si.getUlIdEvent();
    int ccfc43siIdStage = ccfc43si.getUlIdStage();
    ROWCCMN01UIG00 rowCcmn01Uig00 = new ROWCCMN01UIG00();
    CCFC43SOG00 ccfc43Sog00 = new CCFC43SOG00();

    ccfc43so.setDtWCDDtSystemDate(DateHelper.getTodayCastorDate());
    if (0 != ccfc43siIdEvent) {

      ccfc43so.setROWCCMN01UIG00(setEventOutput(ccfc43siIdEvent, rowCcmn01Uig00));

      // cses65dQUERYdam
      AdminReview cses65dAdminReview = adminReviewDAO.findAdminReviewByIdEvent(ccfc43siIdEvent);

      if (cses65dAdminReview != null) {
        ccfc43so.setCCFC43SOG00(setAdminReviewOutput(cses65dAdminReview, ccfc43Sog00));
        ccfc43so.setBIndBLOBExistsInDatabase(setBlobExists(ccfc43siIdEvent));
      }
    } else {

      // cses69dQUERYdam
      AdminReview cses69dAdminReview = adminReviewDAO.findAdminReviewByIdStage(ccfc43siIdStage);

      if (cses69dAdminReview != null) {
        ccfc43so.setCCFC43SOG00(setAdminReviewOutput(cses69dAdminReview, ccfc43Sog00));

        int csec69dIdEvent = cses69dAdminReview.getEvent().getIdEvent();
        // ccmn45dQUERYdam
        ccfc43so.setROWCCMN01UIG00(setEventOutput(csec69dIdEvent, rowCcmn01Uig00));
        ccfc43so.setBIndBLOBExistsInDatabase(setBlobExists(ccfc43siIdEvent));
      }
    }

    // cint21dQUERYdam
    Stage cint21dStage = stageDAO.findStageByIdStage(ccfc43siIdStage);

    if (cint21dStage != null) {
      ccfc43so.setSzCdStageProgram(cint21dStage.getCdStageProgram());
    }

    int ccfc43SoIdPerson = ccfc43Sog00.getUlIdPersonRequestor();

    if (ccfc43SoIdPerson > 0) {

      // cinv81dQUERYdam
      Person cinv81dPerson = personDAO.findPersonByIdPerson(ccfc43SoIdPerson);

      if (cinv81dPerson != null) {
        ccfc43so.setSzNmPersonFull(cinv81dPerson.getNmPersonFull());
      }
    }

    return ccfc43so;
  }

  private CCFC43SOG00 setAdminReviewOutput(AdminReview adminReview, CCFC43SOG00 ccfc43Sog00) {
    ccfc43Sog00.setSzCdAdminRvReqBy(adminReview.getCdAdminRvReqBy());
    ccfc43Sog00.setSzScrNmReviewReqBy(adminReview.getNmAdminRvReqBy());
//    ccfc43Sog00.setSzCdAdminRvAppealResult(adminReview.getCdAdminRvAppealResult());
    ccfc43Sog00.setSztxtAppealResult(adminReview.getTxtAppealResult());
    ccfc43Sog00.setSzCdAdminRvAppealType(adminReview.getCdAdminRvAppealType());
    ccfc43Sog00.setSzCdAdminRvAuth(adminReview.getCdAdminRvAuth());
    ccfc43Sog00.setSzCdAdminRvStatus(adminReview.getCdAdminRvStatus());
    ccfc43Sog00.setTsLastUpdate(adminReview.getDtLastUpdate());
    ccfc43Sog00.setDtDtAdminRvAppealNotif(DateHelper.toCastorDate(adminReview.getDtAdminRvAppealNotif()));
    ccfc43Sog00.setDtDtAdminRvAppealReview(DateHelper.toCastorDate(adminReview.getDtAdminRvAppealReview()));
    ccfc43Sog00.setDtDtAdminRvDue(DateHelper.toCastorDate(adminReview.getDtAdminRvDue()));
    ccfc43Sog00.setDtDtAdminRvEmgcyRel(DateHelper.toCastorDate(adminReview.getDtAdminRvEmgcyRel()));
    ccfc43Sog00.setDtDtAdminRvHearing(DateHelper.toCastorDate(adminReview.getDtAdminRvHearing()));
    ccfc43Sog00.setDtDtAdminRvReqAppeal(DateHelper.toCastorDate(adminReview.getDtAdminRvReqAppeal()));
    // R1 additions
    ccfc43Sog00.setDtDtDeterminationLtr(DateHelper.toCastorDate(adminReview.getDtDeterminationLtr()));
    ccfc43Sog00.setBIndLglRepresentation(adminReview.getIndLglRepresentation());
    ccfc43Sog00.setBIndSaagNotification(adminReview.getIndSaagNotification());
    ccfc43Sog00.setSztxtRsnApprvDeny(adminReview.getTxtRsnApprvDeny());
    ccfc43Sog00.setUlIdCase(adminReview.getCapsCase().getIdCase());
    ccfc43Sog00.setSzCdAdminRvIndLevel(adminReview.getIndLevel());
    
    //capta 1st level
    if("1".equals(adminReview.getIndLevel()) == true) {
      ccfc43Sog00.setDtDt1lvlAdminRvAppealReview(DateHelper.toCastorDate(adminReview.getDt1lRev()));
      ccfc43Sog00.setDtDt1lvlAdminRvDue(DateHelper.toCastorDate(adminReview.getDt1lRevBy()));
      ccfc43Sog00.setDtDt1lvlAdminRvReqAppeal(DateHelper.toCastorDate(adminReview.getDt1lRqRec()));
      ccfc43Sog00.setDtDt1lvlDeterminationLtr(DateHelper.toCastorDate(adminReview.getDt1lDeterLrGen()));
      ccfc43Sog00.setBInd1lvlLglRepresentation(adminReview.getInd1lLegRep());
      ccfc43Sog00.setBInd1lvlSaagNotification(adminReview.getInd2lSaagNoti());
      ccfc43Sog00.setSzCd1lvlAdminRvDisp(adminReview.getCd1lDisp());
      ccfc43Sog00.setSzCd1lvlAdminRsDisg(adminReview.getCd1lRsDisg());
      ccfc43Sog00.setSzTxt1lvlAdminRevResults(adminReview.getTxt1lResult());
      ccfc43Sog00.setDtDt1lvlAdminRvPersonNotif(DateHelper.toCastorDate(adminReview.getDt1lRevPerNoti()));
      ccfc43Sog00.setSzTxt1lvlAdminRevResAppDen(adminReview.getTxt1lRsAppDen());
         
      int adminReviewId1lSme = (adminReview.getId1lSme() != null && adminReview.getId1lSme() != 0) ? adminReview.getId1lSme()
                                                                 : stagePersonLinkDAO
                                                                                     .findIdCaseWorkerByIdStageAndCdStagePersRole(adminReview
                                                                                                                                             .getIdStage());
      if (adminReviewId1lSme > 0) {
        Person SME1lvl = personDAO.findPersonByIdPerson(adminReviewId1lSme);
        if (SME1lvl != null) {
          ccfc43Sog00.setSzNmPersonFullAmdRev1lSME(SME1lvl.getNmPersonFull());
        }
      }      
    }
    
    if("2".equals(adminReview.getIndLevel()) == true) {
      
      int idCase = (adminReview.getCapsCase() != null) ? adminReview.getCapsCase().getIdCase() : 0;
      int idPerson = (adminReview.getPerson() != null) ? adminReview.getPerson().getIdPerson() : 0;
      
      List<AdminReview> lstPriorAdm = adminReviewDAO.retrievePrior1lvlAdminReviews(idCase, idPerson);
      
      if(lstPriorAdm != null) {
        Iterator<AdminReview> itPriorAdm = lstPriorAdm.iterator();
        ROWCCMN01UIG02_ARRAY rowccmn01uig02_array = new ROWCCMN01UIG02_ARRAY();
        while(itPriorAdm.hasNext()) {
          AdminReview priorAdm = itPriorAdm.next();
          if(priorAdm.getStage() != null) {
            ROWCCMN01UIG02 rowccmn01uig02 = new ROWCCMN01UIG02();
            Stage stage = priorAdm.getStage();
            rowccmn01uig02.setUlIdStage(stage.getIdStage());
            rowccmn01uig02.setSzNmStage(stage.getNmStage());
            rowccmn01uig02_array.addROWCCMN01UIG02(rowccmn01uig02);
          }
        }
        ccfc43Sog00.setROWCCMN01UIG02_ARRAY(rowccmn01uig02_array);
      }
            
      int Id2l1lStage = (adminReview.getId2l1lStage() != null) ? adminReview.getId2l1lStage() : 0;
      if (Id2l1lStage > 0) {
        ccfc43Sog00.setUlAdmRev2lvlPriorStage(Id2l1lStage);
        ccfc43Sog00.setSzNmStage(stageDAO.findStageByIdStage(Id2l1lStage).getNmStage());
        AdminReview lvl1ARI = adminReviewDAO.findAdminReviewByIdStage(Id2l1lStage);
        if (lvl1ARI != null) {
          ccfc43Sog00.setDtDt1lvlAdminRvAppealReview(DateHelper.toCastorDate(lvl1ARI.getDt1lRev()));
          ccfc43Sog00.setDtDt1lvlAdminRvDue(DateHelper.toCastorDate(lvl1ARI.getDt1lRevBy()));
          ccfc43Sog00.setDtDt1lvlAdminRvReqAppeal(DateHelper.toCastorDate(lvl1ARI.getDt1lRqRec()));
          ccfc43Sog00.setDtDt1lvlDeterminationLtr(DateHelper.toCastorDate(lvl1ARI.getDt1lDeterLrGen()));
          ccfc43Sog00.setBInd1lvlLglRepresentation(lvl1ARI.getInd1lLegRep());
          ccfc43Sog00.setBInd1lvlSaagNotification(lvl1ARI.getInd2lSaagNoti());
          ccfc43Sog00.setSzCd1lvlAdminRvDisp(lvl1ARI.getCd1lDisp());
          ccfc43Sog00.setSzCd1lvlAdminRsDisg(lvl1ARI.getCd1lRsDisg());
          ccfc43Sog00.setSzTxt1lvlAdminRevResults(lvl1ARI.getTxt1lResult());
          ccfc43Sog00.setDtDt1lvlAdminRvPersonNotif(DateHelper.toCastorDate(lvl1ARI.getDt1lRevPerNoti()));
          ccfc43Sog00.setSzTxt1lvlAdminRevResAppDen(lvl1ARI.getTxt1lRsAppDen());
             
          int adminReviewId1lSme = (lvl1ARI.getId1lSme() != null && lvl1ARI.getId1lSme() != 0) ? lvl1ARI.getId1lSme()
                                                                 : stagePersonLinkDAO
                                                                                     .findIdCaseWorkerByIdStageAndCdStagePersRole(lvl1ARI
                                                                                                                                         .getIdStage());
          if (adminReviewId1lSme > 0) {
            Person SME1lvl = personDAO.findPersonByIdPerson(adminReviewId1lSme);
            if (SME1lvl != null) {
              ccfc43Sog00.setSzNmPersonFullAmdRev1lSME(SME1lvl.getNmPersonFull());
            }
          }      
        }
      }
      
      ccfc43Sog00.setBInd1lvlAdmRv21lvlStag(adminReview.getInd2l1lStage());
      ccfc43Sog00.setSzTxt2lvlAdminRevOff(adminReview.getTxt2lAarOff());
      ccfc43Sog00.setDtDt2lvlAdmRvDecLtr(DateHelper.toCastorDate(adminReview.getDt2l1lDlRec()));
      ccfc43Sog00.setDtDt2lvlAdminRvReqAppeal(DateHelper.toCastorDate(adminReview.getDt2lRqRec()));
      ccfc43Sog00.setSzCd2lvlAdminRvType(adminReview.getCd2lRevType());
      ccfc43Sog00.setDtDt2lvlAdminRvReqIntrv(DateHelper.toCastorDate(adminReview.getDt2lInterview()));
      ccfc43Sog00.setDtDt2lvlAdminRvAppealReview(DateHelper.toCastorDate(adminReview.getDt2lRev()));
      ccfc43Sog00.setDtDt2lvlAdminRvDue(DateHelper.toCastorDate(adminReview.getDt2lRevBy()));
      ccfc43Sog00.setBInd2lvlLglRepresentation(adminReview.getInd2lLegRep());
      ccfc43Sog00.setBInd2lvlSaagNotification(adminReview.getInd2lSaagNoti());
      
      ccfc43Sog00.setSzCd2lvlAdminRvDisp(adminReview.getCd2lDisp());
      ccfc43Sog00.setSzCd2lvlAdminRsDisg(adminReview.getCd2lRsDisg());
      ccfc43Sog00.setSzTxt2lvlAdminRevResults(adminReview.getTxt2lResult());
      ccfc43Sog00.setDtDt2lvlAdminRvPersonNotif(DateHelper.toCastorDate(adminReview.getDt2lRevPerNoti()));
      ccfc43Sog00.setSzTxt2lvlAdminRevResAppDen(adminReview.getTxt2lRsAppDen());
      ccfc43Sog00.setBInd2lvlAdmRvComp(adminReview.getInd2lComp());
      
      int adminReviewId2lShinesPer = (adminReview.getId2lShinesPer() != null && adminReview.getId2lShinesPer() != 0) ? adminReview.getId2lShinesPer()
                                                                             : stagePersonLinkDAO
                                                                                                 .findIdCaseWorkerByIdStageAndCdStagePersRole(adminReview
                                                                                                                                                         .getIdStage());
      if (adminReviewId2lShinesPer > 0) {
        Person SHINES2lvl = personDAO.findPersonByIdPerson(adminReviewId2lShinesPer);
        if (SHINES2lvl != null) {
          ccfc43Sog00.setSzNmAdmRvPersonFullAmdComp(SHINES2lvl.getNmPersonFull());
        }
      }  
      
      int adminReviewId3lShinesPer = (adminReview.getId3lShinesPer() != null && adminReview.getId3lShinesPer() != 0) ? adminReview.getId3lShinesPer()
                                                                             : stagePersonLinkDAO
                                                                                                 .findIdCaseWorkerByIdStageAndCdStagePersRole(adminReview
                                                                                                                                                         .getIdStage());
      if (adminReviewId3lShinesPer > 0) {
        Person SHINES3lvl = personDAO.findPersonByIdPerson(adminReviewId3lShinesPer);
        if (SHINES3lvl != null) {
          ccfc43Sog00.setSzTxt3lvlAdminRevCompDoc(SHINES3lvl.getNmPersonFull());
        }
      }  
      
      int adminReviewId3lCommDes = (adminReview.getId3lDhsCom() != null) ? adminReview.getId3lDhsCom() : 0;
      if (adminReviewId3lCommDes > 0) {
        Person SHINES3lvlCommDes = personDAO.findPersonByIdPerson(adminReviewId3lCommDes);
        if (SHINES3lvlCommDes != null) {
          ccfc43Sog00.setSzTxt3lvlAdminRevCommDes(SHINES3lvlCommDes.getNmPersonFull());
        }
      }   
      
      ccfc43Sog00.setDtDt3lvlAdmRvDecLtr(DateHelper.toCastorDate(adminReview.getDt3l2lDlRec()));
      ccfc43Sog00.setDtDt3lvlAdminRvAppealReview(DateHelper.toCastorDate(adminReview.getDt3lRev()));
      ccfc43Sog00.setDtDt3lvlAdminRvDue(DateHelper.toCastorDate(adminReview.getDt3lRevBy()));
      ccfc43Sog00.setSzCd3lvlAdminRvDisp(adminReview.getCd3lDisp());
      ccfc43Sog00.setSzCd3lvlAdminRvFnDec(adminReview.getCd3lFinDec());
      ccfc43Sog00.setSzCd3lvlAdminRsDisg(adminReview.getCd3lRsDisg());
      ccfc43Sog00.setSzTxt3lvlAdminRevResults(adminReview.getTxt3lResult());
      ccfc43Sog00.setDtDt3lvlAdminRvPersonNotif(DateHelper.toCastorDate(adminReview.getDt3lRevPerNoti()));
      ccfc43Sog00.setSzTxt3lvlAdminRevResAppDen(adminReview.getTxt3lRsAppDen());
    }
    
    
    
    Event cses65dEvent = adminReview.getEvent();
    ccfc43Sog00.setUlIdEvent(cses65dEvent.getIdEvent() != null ? cses65dEvent.getIdEvent() : 0);
    Person cses65dPerson = adminReview.getPerson();
    ccfc43Sog00.setUlIdPersonRequestor(cses65dPerson.getIdPerson() != null ? cses65dPerson.getIdPerson() : 0);
    ccfc43Sog00.setUlIdStage(adminReview.getIdStage() != null ? adminReview.getIdStage() : 0);
    Stage csec65dStage = adminReview.getStageByIdStageRelated();
    ccfc43Sog00.setUlIdStageRelated(csec65dStage.getIdStage() != null ? csec65dStage.getIdStage() : 0);
    ccfc43Sog00.setCIndAdminRvEmgcyRel(adminReview.getIndAdminRvEmgcyRel());
    return ccfc43Sog00;
  }

  private ROWCCMN01UIG00 setEventOutput(int idEvent, ROWCCMN01UIG00 rowCcmn01Uig00) throws ServiceException {
    Event event = eventDAO.findEventByIdEvent(idEvent);

    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    rowCcmn01Uig00.setSzCdEventType(event.getCdEventType());
    rowCcmn01Uig00.setSzTxtEventDescr(event.getTxtEventDescr());
    rowCcmn01Uig00.setSzCdTask(event.getCdTask());
    rowCcmn01Uig00.setSzCdEventStatus(event.getCdEventStatus());
    rowCcmn01Uig00.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
    rowCcmn01Uig00.setTsLastUpdate(event.getDtLastUpdate());
    rowCcmn01Uig00.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
    Stage ccmn45dStage = event.getStage();
    rowCcmn01Uig00.setUlIdStage(ccmn45dStage.getIdStage() != null ? ccmn45dStage.getIdStage() : 0);
    Person ccmn45dPerson = event.getPerson();
    rowCcmn01Uig00.setUlIdPerson(ccmn45dPerson.getIdPerson() != null ? ccmn45dPerson.getIdPerson() : 0);
    return rowCcmn01Uig00;
  }

  private String setBlobExists(int idEvent) {
    // csys06dQUERYdam
    Date csys06dDtLastUpdate = commonDAO.findDtLastUpdate(ADMIN_REVIEW_NARRATIVE, idEvent);

    if (csys06dDtLastUpdate == null) {
      return ArchitectureConstants.N;
    }
    return ArchitectureConstants.Y;
  }
}
