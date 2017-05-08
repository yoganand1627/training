package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdminAllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.AdminReviewDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdminReview;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CloseStageCase;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveAdminReview;
import gov.georgia.dhr.dfcs.sacwis.service.admin.TodoCommonFunction;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC44SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC44SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB40UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC44SO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SaveAdminReviewImpl extends BaseServiceImpl implements SaveAdminReview {

  private AdminAllegationDAO adminAllegationDAO = null;

  private AdminReviewDAO adminReviewDAO = null;

  private CheckStageEventStatus checkStageEventStatus = null;

  private CloseStageCase closeStageCase = null;

  private PersonDAO personDAO = null;

  private PostEvent postEvent = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private TodoCommonFunction todoCommonFunction = null;

  private UnitEmpLinkDAO unitEmpLinkDAO = null;
  
  private CpsInvstDetailDAO cpsInvstDetailDAO = null;
  
  private TodoDAO todoDAO = null;

  public static final String TODO_TEXT_CFC014_START = "ARV Decision in ";

  public static final String TODO_TEXT_CFC014_END = " is due ";

  public static final String TODO_TEXT_CFC015_START = "ARV Review for ";

  public static final String TODO_TEXT_CFC015_MIDDLE = " for ";

  public static final String TODO_TEXT_CFC015_END = " near.";

  public static final String TODO_TEXT_CFC013_START = "Findings for ";

  public static final String TODO_TEXT_CFC013_MIDDLE = " in ";

  public static final String TODO_TEXT_CFC013_END = " case reversed.";

  public static final String ROLE_PRINCIPAL = CodesTables.CSTFROLS_PR;

  public static final String STAGE_CD_INV = CodesTables.CSTAGES_INV;

  public static final String TODO_CFC013 = "CFC013";

  public static final String TODO_CFC014 = "CFC014";

  public static final String TODO_CFC015 = "CFC015";

  public static final String CAPS_PROG_APS = CodesTables.CPGRMS_APS;

  public static final String CAPS_PROG_AFC = CodesTables.CPGRMS_AFC;
  
  public static final String STATUS_APPROVED = "APRV";
  
  public static final String TODO_TEXT_1_LEVEL_0 = "1st Level Administrative Review Due for ";
  
  public static final String TODO_TEXT_1_LEVEL_1 = "1st Level Administrative Review for ";
  
  public static final String TODO_TEXT_1_LEVEL_2 = " 20 days since Request Received 10 more days before  Review is due";
  
  public static final String TODO_TEXT_2_LEVEL_0 = "2nd  Level Administrative Review Due for ";
  
  public static final String TODO_TEXT_2_LEVEL_1 = "2nd  Level Administrative Review for ";
  
  public static final String TODO_TEXT_2_LEVEL_2 = " 35 days since Request Received 10 more days before  Review is due";
  
  public static final String TODO_TEXT_3_LEVEL_0 = "3rd  Level Administrative Review Due for ";
  
  public static final String TODO_TEXT_3_LEVEL_1 = "3rd Level Administrative Review for ";
  
  public static final String TODO_TEXT_3_LEVEL_2 = " 20 days since Request Received 10 more days before  Review is due";
  
  

  public void setAdminAllegationDAO(AdminAllegationDAO adminAllegationDAO) {
    this.adminAllegationDAO = adminAllegationDAO;
  }

  public void setAdminReviewDAO(AdminReviewDAO adminReviewDAO) {
    this.adminReviewDAO = adminReviewDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setCloseStageCase(CloseStageCase closeStageCase) {
    this.closeStageCase = closeStageCase;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setTodoCommonFunction(TodoCommonFunction todoCommonFunction) {
    this.todoCommonFunction = todoCommonFunction;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }
  
  public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
    this.cpsInvstDetailDAO = cpsInvstDetailDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public CCFC44SO saveAdminReview(CCFC44SI ccfc44si) throws ServiceException {
    CCFC44SO ccfc44so = new CCFC44SO();
    CCFC44SIG00 ccfc44Sig00 = ccfc44si.getCCFC44SIG00();
    int ccfc44siIdEvent = ccfc44Sig00.getUlIdEvent();
    int ccfc44siIdStage = ccfc44Sig00.getUlIdStage();
    CCMN06UI ccmn06ui = new CCMN06UI();
    ArchInputStruct ccfc44siArchInputStruct = ccfc44si.getArchInputStruct();
    ccmn06ui.setArchInputStruct(ccfc44siArchInputStruct);
    ccmn06ui.getArchInputStruct().setCReqFuncCd(ccfc44siArchInputStruct.getCReqFuncCd());
    ccmn06ui.setUlIdStage(ccfc44siIdStage);
    ROWCCMN01UIG00 rowCcmn01Uig00 = ccfc44si.getROWCCMN01UIG00();
    ccmn06ui.setSzCdTask(rowCcmn01Uig00.getSzCdTask());
    checkStageEventStatus.status(ccmn06ui);
 
    // cses65dQUERYdam
    AdminReview cses65dAdminReview = adminReviewDAO.findAdminReviewByIdEvent(ccfc44siIdEvent);

    if (cses65dAdminReview == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    //AdminReview caud3dAdminReview = new AdminReview();
    AdminReview caud3dAdminReview = (AdminReview) getPersistentObject(AdminReview.class, ccfc44siIdStage);
    caud3dAdminReview.setCdAdminRvReqBy(ccfc44Sig00.getSzCdAdminRvReqBy());
    caud3dAdminReview.setNmAdminRvReqBy(ccfc44Sig00.getSzScrNmReviewReqBy());
    caud3dAdminReview.setIdStage(ccfc44siIdStage);

    int ccfc44sig00IdPersonRequestor = ccfc44Sig00.getUlIdPersonRequestor();

    Person caud3dPerson = (Person) getPersistentObject(Person.class, ccfc44sig00IdPersonRequestor);
    caud3dAdminReview.setPerson(caud3dPerson);

    Event caud3dEvent = (Event) getPersistentObject(Event.class, ccfc44siIdEvent);
    caud3dAdminReview.setEvent(caud3dEvent);

    int ccfc44Sig00IdStageRelated = ccfc44Sig00.getUlIdStageRelated();

    Stage stage = (Stage) getPersistentObject(Stage.class, ccfc44siIdStage);
    caud3dAdminReview.setStage(stage);

    Stage relStage = (Stage) getPersistentObject(Stage.class, ccfc44Sig00IdStageRelated);
    caud3dAdminReview.setStageByIdStageRelated(relStage);

    caud3dAdminReview.setIndAdminRvEmgcyRel(ccfc44Sig00.getCIndAdminRvEmgcyRel());
    caud3dAdminReview.setDtLastUpdate(ccfc44Sig00.getTsLastUpdate());
  //  String ccfc44Sig00CdAdminRvAppealResult = ccfc44Sig00.getSzCdAdminRvAppealResult();
  //  caud3dAdminReview.setCdAdminRvAppealResult(ccfc44Sig00CdAdminRvAppealResult);
    String ccfc44Sig00CdAdminRvAppealResult = "CLD";  // closed
    caud3dAdminReview.setTxtAppealResult(ccfc44Sig00.getSztxtAppealResult());
    caud3dAdminReview.setCdAdminRvAppealType(ccfc44Sig00.getSzCdAdminRvAppealType());
    caud3dAdminReview.setCdAdminRvAuth(ccfc44Sig00.getSzCdAdminRvAuth());
    String ccfc44Sig00CdAdminRvStatus = ccfc44Sig00.getSzCdAdminRvStatus();
    caud3dAdminReview.setCdAdminRvStatus(ccfc44Sig00CdAdminRvStatus);
    caud3dAdminReview.setDtAdminRvAppealNotif(DateHelper.toJavaDate(ccfc44Sig00.getDtDtAdminRvAppealNotif()));
    caud3dAdminReview.setDtAdminRvAppealReview(DateHelper.toJavaDate(ccfc44Sig00.getDtDtAdminRvAppealReview()));
    Date ccfc44Sig00DtAdminRvDue = DateHelper.toJavaDate(ccfc44Sig00.getDtDtAdminRvDue());
    caud3dAdminReview.setDtAdminRvDue(ccfc44Sig00DtAdminRvDue);
    caud3dAdminReview.setDtAdminRvEmgcyRel(DateHelper.toJavaDate(ccfc44Sig00.getDtDtAdminRvEmgcyRel()));
    caud3dAdminReview.setDtAdminRvHearing(DateHelper.toJavaDate(ccfc44Sig00.getDtDtAdminRvHearing()));
    caud3dAdminReview.setDtAdminRvReqAppeal(DateHelper.toJavaDate(ccfc44Sig00.getDtDtAdminRvReqAppeal()));
    //////////// R1 additions
    caud3dAdminReview.setDtDeterminationLtr(DateHelper.toJavaDate(ccfc44Sig00.getDtDtDeterminationLtr()));
    caud3dAdminReview.setIndLglRepresentation(ccfc44Sig00.getBIndLglRepresentation());
    caud3dAdminReview.setIndSaagNotification(ccfc44Sig00.getBIndSaagNotification());
    caud3dAdminReview.setTxtRsnApprvDeny(ccfc44Sig00.getSztxtRsnApprvDeny());
    ///////////////
    
    
    caud3dAdminReview.setIndLevel(ccfc44Sig00.getSzCdAdminRvIndLevel());
    
    //CAPTA 1st level
    caud3dAdminReview.setDt1lRev(DateHelper.toJavaDate(ccfc44Sig00.getDtDt1lvlAdminRvAppealReview()));
    caud3dAdminReview.setDt1lRevBy(DateHelper.toJavaDate(ccfc44Sig00.getDtDt1lvlAdminRvDue()));
    caud3dAdminReview.setDt1lRqRec(DateHelper.toJavaDate(ccfc44Sig00.getDtDt1lvlAdminRvReqAppeal()));
    caud3dAdminReview.setDt1lDeterLrGen(DateHelper.toJavaDate(ccfc44Sig00.getDtDt1lvlDeterminationLtr()));
    caud3dAdminReview.setInd1lLegRep(ccfc44Sig00.getBInd1lvlLglRepresentation());
    caud3dAdminReview.setInd1lSaagNoti(ccfc44Sig00.getBInd1lvlSaagNotification());
    
    caud3dAdminReview.setCd1lDisp(ccfc44Sig00.getSzCd1lvlAdminRvDisp());
    caud3dAdminReview.setCd1lRsDisg(ccfc44Sig00.getSzCd1lvlAdminRsDisg());
    caud3dAdminReview.setTxt1lResult(ccfc44Sig00.getSzTxt1lvlAdminRevResults());
    caud3dAdminReview.setDt1lRevPerNoti(DateHelper.toJavaDate(ccfc44Sig00.getDtDt1lvlAdminRvPersonNotif()));
    caud3dAdminReview.setTxt1lRsAppDen(ccfc44Sig00.getSzTxt1lvlAdminRevResAppDen());
    
    if(("1".equals(ccfc44Sig00.getSzCdAdminRvIndLevel()) == true) && (DateHelper.isNull(ccfc44Sig00.getDtDt1lvlAdminRvDue()) == false) &&
                    (DateHelper.isEqual(ccfc44Sig00.getDtDt1lvlAdminRvDue(), ccfc44Sig00.getDtDt1lvlAdminRvDuePrev()) == false)){
      
      createAdminTodos(rowCcmn01Uig00.getUlIdStage(), rowCcmn01Uig00.getUlIdEvent(), 
                       DateHelper.toJavaDate(DateHelper.addToDate(ccfc44Sig00.getDtDt1lvlAdminRvDue(), 0, 0, -10)), 
                       TODO_TEXT_1_LEVEL_0, TODO_TEXT_1_LEVEL_1, TODO_TEXT_1_LEVEL_2, rowCcmn01Uig00.getUlIdPerson());
      
    }
    
    
    
    //CAPTA 2nd level
    caud3dAdminReview.setId2l1lStage(ccfc44Sig00.getUlAdmRev2lvlPriorStage());
    caud3dAdminReview.setInd2l1lStage(ccfc44Sig00.getBInd1lvlAdmRv21lvlStag());
    caud3dAdminReview.setTxt2lAarOff(ccfc44Sig00.getSzTxt2lvlAdminRevOff());
    caud3dAdminReview.setDt2l1lDlRec(DateHelper.toJavaDate(ccfc44Sig00.getDtDt2lvlAdmRvDecLtr()));
    caud3dAdminReview.setDt2lRqRec(DateHelper.toJavaDate(ccfc44Sig00.getDtDt2lvlAdminRvReqAppeal()));
    caud3dAdminReview.setCd2lRevType(ccfc44Sig00.getSzCd2lvlAdminRvType());
    caud3dAdminReview.setDt2lInterview(DateHelper.toJavaDate(ccfc44Sig00.getDtDt2lvlAdminRvReqIntrv()));
    caud3dAdminReview.setDt2lRev(DateHelper.toJavaDate(ccfc44Sig00.getDtDt2lvlAdminRvAppealReview()));
    caud3dAdminReview.setDt2lRevBy(DateHelper.toJavaDate(ccfc44Sig00.getDtDt2lvlAdminRvDue()));
    caud3dAdminReview.setInd2lLegRep(ccfc44Sig00.getBInd2lvlLglRepresentation());
    caud3dAdminReview.setInd2lSaagNoti(ccfc44Sig00.getBInd2lvlSaagNotification());
    
    caud3dAdminReview.setCd2lDisp(ccfc44Sig00.getSzCd2lvlAdminRvDisp());
    caud3dAdminReview.setCd2lRsDisg(ccfc44Sig00.getSzCd2lvlAdminRsDisg());
    caud3dAdminReview.setTxt2lResult(ccfc44Sig00.getSzTxt2lvlAdminRevResults());
    caud3dAdminReview.setDt2lRevPerNoti(DateHelper.toJavaDate(ccfc44Sig00.getDtDt2lvlAdminRvPersonNotif()));
    caud3dAdminReview.setTxt2lRsAppDen(ccfc44Sig00.getSzTxt2lvlAdminRevResAppDen());
    caud3dAdminReview.setInd2lComp(ccfc44Sig00.getBInd2lvlAdmRvComp());
    
    if(("2".equals(ccfc44Sig00.getSzCdAdminRvIndLevel()) == true) && (DateHelper.isNull(ccfc44Sig00.getDtDt2lvlAdminRvDue()) == false) &&
                    (DateHelper.isEqual(ccfc44Sig00.getDtDt2lvlAdminRvDue(), ccfc44Sig00.getDtDt2lvlAdminRvDuePrev()) == false)){
      
      createAdminTodos(rowCcmn01Uig00.getUlIdStage(), rowCcmn01Uig00.getUlIdEvent(), 
                       DateHelper.toJavaDate(DateHelper.addToDate(ccfc44Sig00.getDtDt2lvlAdminRvDue(), 0, 0, -10)), TODO_TEXT_2_LEVEL_0, 
                       TODO_TEXT_2_LEVEL_1, TODO_TEXT_2_LEVEL_2, rowCcmn01Uig00.getUlIdPerson());
      
    }
    
    //CAPTA 3rd level
    if(ccfc44Sig00.getUlIdCommisDes() > 0) {
      caud3dAdminReview.setId3lDhsCom(ccfc44Sig00.getUlIdCommisDes());
    }
    caud3dAdminReview.setDt3l2lDlRec(DateHelper.toJavaDate(ccfc44Sig00.getDtDt3lvlAdmRvDecLtr()));
    caud3dAdminReview.setDt3lRev(DateHelper.toJavaDate(ccfc44Sig00.getDtDt3lvlAdminRvAppealReview()));
    caud3dAdminReview.setDt3lRevBy(DateHelper.toJavaDate(ccfc44Sig00.getDtDt3lvlAdminRvDue()));
    caud3dAdminReview.setCd3lDisp(ccfc44Sig00.getSzCd3lvlAdminRvDisp());
    caud3dAdminReview.setCd3lFinDec(ccfc44Sig00.getSzCd3lvlAdminRvFnDec());
    caud3dAdminReview.setCd3lRsDisg(ccfc44Sig00.getSzCd3lvlAdminRsDisg());
    caud3dAdminReview.setTxt3lResult(ccfc44Sig00.getSzTxt3lvlAdminRevResults());
    caud3dAdminReview.setDt3lRevPerNoti(DateHelper.toJavaDate(ccfc44Sig00.getDtDt3lvlAdminRvPersonNotif()));
    caud3dAdminReview.setTxt3lRsAppDen(ccfc44Sig00.getSzTxt3lvlAdminRevResAppDen());
    
    if(("2".equals(ccfc44Sig00.getSzCdAdminRvIndLevel()) == true) && (DateHelper.isNull(ccfc44Sig00.getDtDt3lvlAdminRvDue()) == false) &&
                    (DateHelper.isEqual(ccfc44Sig00.getDtDt3lvlAdminRvDue(), ccfc44Sig00.getDtDt3lvlAdminRvDuePrev()) == false) &&
                    ("Y".equals(ccfc44Sig00.getBInd2lvlAdmRvComp()) == true)){
      
      createAdminTodos(rowCcmn01Uig00.getUlIdStage(), rowCcmn01Uig00.getUlIdEvent(), 
                       DateHelper.toJavaDate(DateHelper.addToDate(ccfc44Sig00.getDtDt3lvlAdminRvDue(), 0, 0, -10)), TODO_TEXT_3_LEVEL_0, 
                       TODO_TEXT_3_LEVEL_1, TODO_TEXT_3_LEVEL_2, rowCcmn01Uig00.getUlIdPerson());
      
    }
          
    if(STATUS_APPROVED.equals(rowCcmn01Uig00.getSzCdEventStatus())) {
      if("1".equals(ccfc44Sig00.getSzCdAdminRvIndLevel()) == true){
        
        caud3dAdminReview.setId1lSme(rowCcmn01Uig00.getUlIdPerson());
        
        if("N".equals(ccfc44Sig00.getSzCd1lvlAdminRvDisp()) == true) {
          ccfc44Sig00CdAdminRvStatus = CodesTables.CARVSTAT_060;
          CpsInvstDetail cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly(ccfc44Sig00IdStageRelated);
          if(cpsInvstDetail != null) {
            if(CodesTables.CDISPSTN_SUB.equals(cpsInvstDetail.getCdCpsInvstDtlOvrllDisptn())) {
              throw new ServiceException(Messages.MSG_ARI_OVERALL_INTEG_1);
            }
          }
        } else if ("Y".equals(ccfc44Sig00.getSzCd1lvlAdminRvDisp()) == true) {
          ccfc44Sig00CdAdminRvStatus = CodesTables.CARVSTAT_060;
          CpsInvstDetail cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly(ccfc44Sig00IdStageRelated);
          if(cpsInvstDetail != null) {
            if(CodesTables.CDISPSTN_UNS.equals(cpsInvstDetail.getCdCpsInvstDtlOvrllDisptn())) {
              throw new ServiceException(Messages.MSG_ARI_OVERALL_INTEG_2);
            }
          } else {
            ccfc44Sig00CdAdminRvStatus = CodesTables.CARVSTAT_050;
          }
        }
      } else if("2".equals(ccfc44Sig00.getSzCdAdminRvIndLevel()) == true){
        caud3dAdminReview.setId3lShinesPer(rowCcmn01Uig00.getUlIdPerson());
        
        if("N".equals(ccfc44Sig00.getSzCd3lvlAdminRvDisp()) == true) {
          ccfc44Sig00CdAdminRvStatus = CodesTables.CARVSTAT_060;
          CpsInvstDetail cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly(ccfc44Sig00IdStageRelated);
          if(cpsInvstDetail != null) {
            if(CodesTables.CDISPSTN_SUB.equals(cpsInvstDetail.getCdCpsInvstDtlOvrllDisptn())) {
              throw new ServiceException(Messages.MSG_ARI_OVERALL_INTEG_1);
            }
          }
        } else if ("Y".equals(ccfc44Sig00.getSzCd3lvlAdminRvDisp()) == true) {
          ccfc44Sig00CdAdminRvStatus = CodesTables.CARVSTAT_060;
          CpsInvstDetail cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly(ccfc44Sig00IdStageRelated);
          if(cpsInvstDetail != null) {
            if(CodesTables.CDISPSTN_UNS.equals(cpsInvstDetail.getCdCpsInvstDtlOvrllDisptn())) {
              throw new ServiceException(Messages.MSG_ARI_OVERALL_INTEG_2);
            }
          } else {
            ccfc44Sig00CdAdminRvStatus = CodesTables.CARVSTAT_050;
          }
        }
      }
    } else {
      if(("Y".equals(ccfc44Sig00.getBInd2lvlAdmRvComp()) == true) && "Y".equals(ccfc44Sig00.getBInd2lvlAdmRvCompPrev()) == false) {
        caud3dAdminReview.setId2lShinesPer(rowCcmn01Uig00.getUlIdPerson());
        if("N".equals(ccfc44Sig00.getSzCd2lvlAdminRvDisp()) == true) {
          CpsInvstDetail cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly(ccfc44Sig00IdStageRelated);
          if(cpsInvstDetail != null) {
            if(CodesTables.CDISPSTN_SUB.equals(cpsInvstDetail.getCdCpsInvstDtlOvrllDisptn())) {
              throw new ServiceException(Messages.MSG_ARI_OVERALL_INTEG_1);
            }
          }
        } else if ("Y".equals(ccfc44Sig00.getSzCd2lvlAdminRvDisp()) == true) {
          CpsInvstDetail cpsInvstDetail = cpsInvstDetailDAO.findCpsInvstDetailByIdStageOnly(ccfc44Sig00IdStageRelated);
          if(cpsInvstDetail != null) {
            if(CodesTables.CDISPSTN_UNS.equals(cpsInvstDetail.getCdCpsInvstDtlOvrllDisptn())) {
              throw new ServiceException(Messages.MSG_ARI_OVERALL_INTEG_2);
            }
          } 
        }
        
        caud3dAdminReview.setDt3lRevBy(DateHelper.addToDate(new Date(), 0, 0, 45));
      }
    }
    caud3dAdminReview.setCdAdminRvStatus(ccfc44Sig00CdAdminRvStatus);
    // cauda3dAUDdam
    adminReviewDAO.saveAdminReview(caud3dAdminReview);

    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct ccmn01uiArchInputStruct = ccfc44siArchInputStruct;
    ccmn01ui.setArchInputStruct(ccmn01uiArchInputStruct);
    ccmn01ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    ccmn01ui.setROWCCMN01UIG00(ccfc44si.getROWCCMN01UIG00());
    postEvent.postEvent(ccmn01ui);
    
    List<String> status = new ArrayList<String>();
    status.add(CodesTables.CARVSTAT_040);
    status.add(CodesTables.CARVSTAT_050);
    status.add(CodesTables.CARVSTAT_060);
    
    
    
    if (status.contains(ccfc44Sig00CdAdminRvStatus) && STATUS_APPROVED.equals(rowCcmn01Uig00.getSzCdEventStatus())) { // approved status

      // cint21dQUERYdam
      Stage cint21dStage = stageDAO.findStageByIdStage(ccfc44Sig00IdStageRelated);

      if (cint21dStage == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

      String cint21dCdStageProgram = cint21dStage.getCdStageProgram();
      String cint21dCdStageReasonClosed = cint21dStage.getCdStageReasonClosed();
      String rowCcmn01Uig00CdEventType = rowCcmn01Uig00.getSzCdEventType();

      if ((CAPS_PROG_APS.equals(cint21dCdStageProgram)) && (cint21dCdStageReasonClosed == null)) {
        throw new ServiceException(Messages.MSG_NO_APS_CONCL);
      } else if ((CAPS_PROG_AFC.equals(cint21dCdStageProgram)) && (cint21dCdStageReasonClosed == null)) {
        throw new ServiceException(Messages.MSG_NO_AFC_CONCL);
      } else {

        CCMN02UI ccmn02ui = new CCMN02UI();
        ArchInputStruct ccmn02uiArchInputStruct = ccfc44siArchInputStruct;
        ccmn02ui.setArchInputStruct(ccmn02uiArchInputStruct);
        CCMN02UIG00 ccmn02Uig00 = new CCMN02UIG00();
        ccmn02Uig00.setSzCdStageReasonClosed(ccfc44Sig00CdAdminRvAppealResult);
        ccmn02Uig00.setSzCdStageProgram(cint21dCdStageProgram);
        ccmn02Uig00.setUlIdStage(ccfc44siIdStage);
        ccmn02Uig00.setUlIdPerson(ccfc44si.getUlIdPerson());
        ccmn02Uig00.setSzCdStage(rowCcmn01Uig00CdEventType);
        ccmn02ui.setCCMN02UIG00(ccmn02Uig00);
        closeStageCase.closeStageCase(ccmn02ui);

        if (STAGE_CD_INV.equals(cint21dStage.getCdStage())) {

          // cmsc43dAUDdam
          adminAllegationDAO.insertAdminAllegation(ccfc44siIdStage, ArchitectureConstants.N, ccfc44Sig00IdStageRelated,
                                                   ccfc44sig00IdPersonRequestor);
        }
      }

      if (!CodesTables.CEVNTTYP_ARF.equals(rowCcmn01Uig00CdEventType)) {

        // cinv39dQUERYdam
        StagePersonLink cinv39dStagePersonLink = stagePersonLinkDAO
                .findStagePersonLinkByIdPersonAndIdStage(ccfc44sig00IdPersonRequestor, ccfc44Sig00IdStageRelated);

        if (cinv39dStagePersonLink == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }

        // cinv39dQUERYdam
        StagePersonLink cinv39dStagePersonLink2 = stagePersonLinkDAO
                .findStagePersonLinkByIdPersonAndIdStage(ccfc44sig00IdPersonRequestor, ccfc44siIdStage);

        if (cinv39dStagePersonLink2 == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }

        // cinva6dAUDdam
        int cinva6dRowsUpdated = stagePersonLinkDAO
                .updateStagePersonLinkCdStagePersRole(cinv39dStagePersonLink.getCdStagePersRole(),
                                                      ccfc44sig00IdPersonRequestor, ccfc44siIdStage,
                                                      cinv39dStagePersonLink2.getDtLastUpdate());

        if (cinva6dRowsUpdated == 0) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      }

      if (CodesTables.CARVWRES_060.equals(ccfc44Sig00CdAdminRvAppealResult)) {
        ccfc44Sig00.setSzCdAdminRvAppealResult(CodesTables.CARVWRES_020);
      }

      if (((CodesTables.CARVWRES_020.equals(ccfc44Sig00CdAdminRvAppealResult) && (CodesTables.CARVSTAT_040
              .equals(ccfc44Sig00CdAdminRvStatus))) || (ccfc44Sig00CdAdminRvAppealResult == null
                                                        && (!DateHelper
              .isNull(ccfc44Sig00DtAdminRvDue)) && (!DateHelper
              .isBefore(
                      ccfc44Sig00DtAdminRvDue,
                      cses65dAdminReview
                              .getDtAdminRvDue()))))) {
        // csec02dQUERYdam
        Stage csec02dStage = stageDAO.findStageAndCapsCase(ccfc44siIdStage);
        CapsCase csec02dCapsCase = csec02dStage.getCapsCase();
        String csec02dNmCase = csec02dCapsCase.getNmCase();

        if (csec02dStage == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }

        if (null == ccfc44Sig00CdAdminRvAppealResult) {

          // ccmng2dQUERYdam
          StagePersonLink ccmng2dStagePersonLink = stagePersonLinkDAO
                  .findStagePersonLinkByIdStageCdStagePersRole(ccfc44Sig00
                          .getUlIdStage());

          if (ccmng2dStagePersonLink == null) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }

          Person ccmng2dPerson = ccmng2dStagePersonLink.getPerson();
          int ccmng2dIdPerson = ccmng2dPerson.getIdPerson();

          CSUB40UI csub40ui1 = new CSUB40UI();
          CSUB40UIG00 csub40Uig001 = new CSUB40UIG00();
          csub40Uig001.setSzSysCdTodoCf(TODO_CFC014);
          csub40Uig001.setUlSysIdTodoCfPersAssgn(ccmng2dIdPerson);
          csub40Uig001.setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(ccfc44Sig00DtAdminRvDue));
          csub40Uig001.setUlSysIdTodoCfEvent(ccfc44siIdEvent);
          csub40Uig001.setUlSysIdTodoCfStage(ccfc44siIdStage);
          csub40Uig001.setSzSysTxtTodoCfDesc(TODO_TEXT_CFC014_START);
          csub40Uig001.setSzSysTxtTodoCfDesc(csub40Uig001.getSzSysTxtTodoCfDesc() + csec02dNmCase
                                             + TODO_TEXT_CFC014_END);
          Calendar dtTodoCfDueFrom = GregorianCalendar.getInstance();
          dtTodoCfDueFrom.setTime(DateHelper.toJavaDate(csub40Uig001.getDtSysDtTodoCfDueFrom()));

          String Date_Todo_Due_From_String = dtTodoCfDueFrom.get(Calendar.MONTH) + "/"
                                             + dtTodoCfDueFrom.get(Calendar.DAY_OF_MONTH) + "/"
                                             + dtTodoCfDueFrom.get(Calendar.YEAR);

          csub40Uig001.setSzSysTxtTodoCfDesc(csub40Uig001.getSzSysTxtTodoCfDesc() + Date_Todo_Due_From_String);
          csub40ui1.setCSUB40UIG00(csub40Uig001);
          todoCommonFunction.audTodo(csub40ui1);

          CSUB40UI csub40ui2 = new CSUB40UI();
          CSUB40UIG00 csub40Uig002 = new CSUB40UIG00();
          csub40Uig002.setSzSysCdTodoCf(TODO_CFC015);
          csub40Uig002.setUlSysIdTodoCfPersAssgn(ccmng2dIdPerson);
          csub40Uig002.setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(ccfc44Sig00DtAdminRvDue));
          Calendar csub40UigDtSysDtTodoCfDueFromCal = GregorianCalendar.getInstance();
          csub40UigDtSysDtTodoCfDueFromCal.setTime(DateHelper.toJavaDate(csub40Uig002.getDtSysDtTodoCfDueFrom()));
          csub40UigDtSysDtTodoCfDueFromCal.set(Calendar.YEAR, csub40UigDtSysDtTodoCfDueFromCal.get(Calendar.YEAR) - 7);
          csub40Uig002.setDtSysDtTodoCfDueFrom(DateHelper.toCastorDate(csub40UigDtSysDtTodoCfDueFromCal.getTime()));
          csub40Uig002.setUlSysIdTodoCfEvent(ccfc44siIdEvent);
          csub40Uig002.setUlSysIdTodoCfStage(ccfc44siIdStage);
          csub40Uig002.setSzSysTxtTodoCfDesc(TODO_TEXT_CFC015_START);
          csec02dNmCase = csec02dCapsCase.getNmCase() + TODO_TEXT_CFC015_MIDDLE + csec02dStage.getNmStage()
                          + TODO_TEXT_CFC015_END;
          csub40Uig002.setSzSysTxtTodoCfDesc(csec02dNmCase);
          csub40ui2.setCSUB40UIG00(csub40Uig002);
          todoCommonFunction.audTodo(csub40ui2);

        } else {

          // ccmn19dQUERYdam
          Map ccmn19dPersonMap = personDAO.findNmPersonAndNmStageByIdStage(ccfc44Sig00IdStageRelated, ROLE_PRINCIPAL);
          if (ccmn19dPersonMap == null || ccmn19dPersonMap.isEmpty()) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }

          int ccmn19dIdPerson = (Integer) ccmn19dPersonMap.get("idPerson");

          // ccmn60dQUERYdam
          Map ccmn60dUnitEmpLinkMap = unitEmpLinkDAO
                  .findNmPersonFullAndIdPersonByIdPersonAndCdUnitMemberIn(ccmn19dIdPerson);

          if (ccmn60dUnitEmpLinkMap == null || ccmn60dUnitEmpLinkMap.isEmpty()) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }

          int ccmn60dIdPerson = (Integer) ccmn60dUnitEmpLinkMap.get("idPerson");

          CSUB40UI csub40ui3 = new CSUB40UI();
          CSUB40UIG00 csub40Uig003 = new CSUB40UIG00();
          csub40Uig003.setSzSysCdTodoCf(TODO_CFC013);
          csub40Uig003.setDtSysDtTodoCfDueFrom(DateHelper.getTodayCastorDate());
          csub40Uig003.setUlSysIdTodoCfPersWkr(ccmn19dIdPerson);
          csub40Uig003.setUlSysIdTodoCfEvent(ccfc44siIdEvent);
          csub40Uig003.setUlSysIdTodoCfStage(ccfc44Sig00IdStageRelated);
          csub40Uig003.setSzSysTxtTodoCfDesc(TODO_TEXT_CFC013_START);
          String csec02dNmStage = csec02dStage.getNmStage() + TODO_TEXT_CFC013_MIDDLE + csec02dNmCase
                                  + TODO_TEXT_CFC013_END;
          csub40Uig003.setSzSysTxtTodoCfDesc(csec02dNmStage);
          csub40ui3.setCSUB40UIG00(csub40Uig003);
          todoCommonFunction.audTodo(csub40ui3);

          CSUB40UI csub40ui4 = new CSUB40UI();
          CSUB40UIG00 csub40Uig004 = new CSUB40UIG00();
          csub40Uig004.setSzSysCdTodoCf(TODO_CFC013);
          csub40Uig004.setDtSysDtTodoCfDueFrom(DateHelper.getTodayCastorDate());
          csub40Uig004.setUlSysIdTodoCfPersWkr(ccmn60dIdPerson);
          csub40Uig004.setUlSysIdTodoCfEvent(ccfc44siIdEvent);
          csub40Uig004.setUlSysIdTodoCfStage(ccfc44Sig00IdStageRelated);
          csub40Uig004.setSzSysTxtTodoCfDesc(TODO_TEXT_CFC013_START);
          String csec02dNmStage2 = csec02dStage.getNmStage() + TODO_TEXT_CFC013_MIDDLE + csec02dNmCase
                                   + TODO_TEXT_CFC013_END;
          csub40Uig004.setSzSysTxtTodoCfDesc(csec02dNmStage2);
          csub40ui4.setCSUB40UIG00(csub40Uig004);
          todoCommonFunction.audTodo(csub40ui4);

          // clsc04dQUERYdam
          List<StagePersonLink> clsc04dStagePersonLinkList = stagePersonLinkDAO
                  .findStagePersonLinkByIdCaseCdStagePersTypeDtStageClose(
                          csec02dCapsCase
                                  .getIdCase(),
                          ROLE_PRINCIPAL,
                          null);
          Iterator itClsc04dStagePersonLinkList = clsc04dStagePersonLinkList.iterator();

          while (itClsc04dStagePersonLinkList.hasNext()) {
            StagePersonLink clsc04dStagePersonLink = (StagePersonLink) itClsc04dStagePersonLinkList.next();
            CSUB40UI csub40ui5 = new CSUB40UI();
            CSUB40UIG00 csub40Uig005 = new CSUB40UIG00();
            csub40Uig005.setSzSysCdTodoCf(TODO_CFC014);
            csub40Uig005.setDtSysDtTodoCfDueFrom(DateHelper.getTodayCastorDate());
            Person clsc04dPerson = clsc04dStagePersonLink.getPerson();
            csub40Uig005.setUlSysIdTodoCfPersAssgn(
                    clsc04dPerson.getIdPerson() != null ? clsc04dPerson.getIdPerson() : 0);
            csub40Uig005.setUlSysIdTodoCfEvent(ccfc44siIdEvent);
            csub40Uig005.setUlSysIdTodoCfStage(ccfc44Sig00IdStageRelated);
            csub40Uig005.setSzSysTxtTodoCfDesc(TODO_TEXT_CFC013_START);
            String csub40ui5SysTxtTodoCfDesc =
                    csub40Uig005.getSzSysTxtTodoCfDesc() + csec02dStage.getNmStage() + TODO_TEXT_CFC013_MIDDLE
                    + csec02dCapsCase.getNmCase() + TODO_TEXT_CFC013_END;
            csub40Uig005.setSzSysTxtTodoCfDesc(csub40ui5SysTxtTodoCfDesc);
            csub40ui5.setCSUB40UIG00(csub40Uig005);
            todoCommonFunction.audTodo(csub40ui5);
          }
        }
      }
    }
    return ccfc44so;
  }
  
  private void createAdminTodos(int idStage, int idEvent, Date dueDate, String toDo0, String toDo1, String toDo2, int idPersonSaving) {
    //delete any old admin review todos
    CapsCase capsCase = null;
    Stage tempStage = (Stage) getPersistentObject(Stage.class, idStage);
    if(tempStage != null && tempStage.getIdStage() > 0) {
      capsCase = tempStage.getCapsCase();
    }   
    
    todoDAO.deleteTodoByIdTodoCaseIdStageAndDescrExclusion(capsCase.getIdCase(), idStage, CodesTables.CTODOTYP_A, TODO_TEXT_CFC014_START);
        
    int idPerson = 0;
    StagePersonLink ccmng2dStagePersonLink = stagePersonLinkDAO.findStagePersonLinkByIdStageCdStagePersRole(idStage);
    if (ccmng2dStagePersonLink != null) {
      idPerson = ccmng2dStagePersonLink.getPerson().getIdPerson();
    }
    
    String caseName = "";
    if(capsCase != null && capsCase.getIdCase() > 0) {
      caseName = capsCase.getNmCase();
    }
           
    Todo todo = new Todo();
    String cdTask = "";
    Date dateCreated = new Date();
    todo.setEvent(getPersistentObject(Event.class, idEvent));
    todo.setTxtTodoDesc(toDo0 + caseName);
    todo.setTxtTodoLongDesc(toDo1 + caseName + toDo2);
    todo.setCdTodoTask(cdTask);
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setDtTodoDue(dueDate);
    todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idPerson));
    todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idPersonSaving));
    todo.setDtTodoCreated(dateCreated);
    todo.setCapsCase(capsCase);
    todo.setStage(tempStage);
    todoDAO.saveTodo(todo);
  }
}
