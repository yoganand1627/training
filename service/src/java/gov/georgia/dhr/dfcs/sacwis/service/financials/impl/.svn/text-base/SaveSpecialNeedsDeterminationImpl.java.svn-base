package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoSubsidyRateDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpecialNeedsDeterminationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoSubsidyRate;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.SpecialNeedsDetermination;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveSpecialNeedsDetermination;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecialNeedsDeterminationBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecialNeedsDeterminationSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpecialNeedsDeterminationSaveSO;
import java.util.Date;
import java.util.Map;

/**
 * The SaveSpecialNeedsDeterminationImpl class is the service for saving the Adoption
 * Assistance Application Page (formerly known as Special Needs Determination).
 * 
 * @see gov.georgia.dhr.dfcs.sacwis.service.financials.SaveSpecialNeedsDetermination
 * 
 * 
 * @author Stephen Roberts, October 1, 2008
 * 
 * <PRE>
 * 
 * &lt;U&gt;Updated by:&lt;/U&gt; &lt;U&gt;Description:&lt;/U&gt; Update description
 * 
 * </PRE>
 * 
 * Change History:
 *   Date         User                  Description
 *   --------     -------------------   --------------------------------------
 *   07/01/2009   bgehlot               STGAP00014563: Added new fields to the Application Page
 *   10/27/2009   mxpatel               37437: added the code to make sure "Entered By" field does not get updated when event is approved
 *   01/15/2010   arege                 SMS#43647 Fixed event description for NEW Adoption Assistance Applications i.e when idEvent = 0    
 *   02/01/2010   bgehlot               SMS#44783: MR-60 Changes, Pre Post radio buttons added, Special Needs Type and Approval Type
 *                                                 radio buttons changed to the drop down, new types added.
 *   03/04/2010  mxpatel                SMS #46736: added new validations to prevent SAU from approving more than one Child Care or Respite 
 *                                      Special Service Application within the same approval period.     
 *   03/09/2011   htvo                  SMS#97845 MR-074-2 AFCARS: save new column indIncidentChild
 *   02/08/2012   vcollooru				STGAP00017878: (Break-fix defect for 5.1) Modified to persist the Agreement Type Selection value.
 */

public class SaveSpecialNeedsDeterminationImpl extends BaseServiceImpl implements SaveSpecialNeedsDetermination {
  private static final int AGE_18 = 18;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private CheckStageEventStatus checkStageEventStatus = null;

  private PostEvent postEvent = null;

  private SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO = null;
  
  private PersonDAO personDAO = null;
  
  private EventPersonLinkDAO eventPersonLinkDAO = null;
  
  private AdoSubsidyRateDAO adoSubsidyRateDAO = null;

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public CheckStageEventStatus getCheckStageEventStatus() {
    return checkStageEventStatus;
  }

  public PostEvent getPostEvent() {
    return postEvent;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setSpecialNeedsDeterminationDAO(SpecialNeedsDeterminationDAO specialNeedsDeterminationDAO) {
    this.specialNeedsDeterminationDAO = specialNeedsDeterminationDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setAdoSubsidyRateDAO(AdoSubsidyRateDAO adoSubsidyRateDAO) {
    this.adoSubsidyRateDAO = adoSubsidyRateDAO;
  }

  @SuppressWarnings("unchecked")
  public SpecialNeedsDeterminationSaveSO saveSpecialNeedsDetermination(SpecialNeedsDeterminationSaveSI spNdsDetermSaveSI)
                                                                                                                         throws ServiceException {
    int idEvent = spNdsDetermSaveSI.getSpNdsDetBean().getIdEvent();
    int idStage = spNdsDetermSaveSI.getIdStage();
    int idUser = spNdsDetermSaveSI.getIdUser();
    String PRIMARY_CHILD = "PC";
    Event event = new Event();
    String cdTask = spNdsDetermSaveSI.getCdTask();
    String actionCode = ServiceConstants.REQ_FUNC_CD_ADD;
    if (idEvent != 0) {
      actionCode = ServiceConstants.REQ_FUNC_CD_UPDATE;
    }
    
    if (ArchitectureConstants.Y.equals(spNdsDetermSaveSI.getIndModeApproval())) {
      int idPerson = eventPersonLinkDAO.findIPersonByIdEpl(idEvent);
      String cdSpclServType = spNdsDetermSaveSI.getSpNdsDetBean().getCdSpclSerType();
      if ((CodesTables.CSPLSERV_DCR.equals(cdSpclServType)) || (CodesTables.CSPLSERV_RES.equals(cdSpclServType))) {
        Long count = specialNeedsDeterminationDAO
                                                 .findCountAprvSpecServByIdPerosnIdStageType(
                                                                                             idPerson,
                                                                                             idEvent,
                                                                                             spNdsDetermSaveSI
                                                                                                              .getDtAprvDate(),
                                                                                             spNdsDetermSaveSI
                                                                                                              .getDtExpDate(),
                                                                                             idStage, cdSpclServType);
        int specNeedsCount = count.intValue();
        if (specNeedsCount >= 1) {
          if (CodesTables.CSPLSERV_RES.equals(cdSpclServType)) {
            throw new ServiceException(Messages.MSG_SPECSVC_RESP_OVERLAP);
          } else if (CodesTables.CSPLSERV_DCR.equals(cdSpclServType)) {
            throw new ServiceException(Messages.MSG_SPECSVC_CHILD_CARE_OVERLAP);
          }
        }
      }
    }
    CCMN06UI ccmn06ui = populateCCMN06UI_CheckStageEventStatus(idStage, idUser, cdTask, actionCode);
    checkStageEventStatus.status(ccmn06ui);
    SpecialNeedsDeterminationBean spNdsDetermBean = spNdsDetermSaveSI.getSpNdsDetBean();
    SpecialNeedsDetermination spNdsDetermination = new SpecialNeedsDetermination();
    Map stagePersonLinkInfo = stagePersonLinkDAO.findStagePersonLinkByIdPerson(idStage, PRIMARY_CHILD);
    spNdsDetermSaveSI
                     .setIdPerson((Integer) stagePersonLinkInfo.get("idPerson") != null ? (Integer) stagePersonLinkInfo
                                                                                                                       .get("idPerson")
                                                                                       : 0);
    spNdsDetermination = populateSpecialNeeds(spNdsDetermBean, spNdsDetermSaveSI);
    if (idEvent != 0) {
      spNdsDetermination.setIdEvent(idEvent);
      spNdsDetermination.setDtLastUpdate(spNdsDetermSaveSI.getSpNdsDetBean().getDtLastUpdate());
    }
    CCMN01UO ccmn01uo = callPostEvent(spNdsDetermSaveSI, actionCode);
    if (ccmn01uo != null) {
      idEvent = ccmn01uo.getUlIdEvent();
      spNdsDetermination.setIdEvent(idEvent);
    }
    event = (Event) getPersistentObject(Event.class, idEvent);
    spNdsDetermination.setEvent(event);
    // SMS#97845 MR-074-2 AFCARS: new column
    spNdsDetermination.setIndIncidentChild(spNdsDetermSaveSI.getIndIncidentChild());
    
    SpecialNeedsDeterminationSaveSO spNdsDetermSO = new SpecialNeedsDeterminationSaveSO();
    specialNeedsDeterminationDAO.saveSpecialNeedsDetermination(spNdsDetermination);
    spNdsDetermSO.setUlIdEvent(spNdsDetermination.getIdEvent());
    return spNdsDetermSO;
  }

  /**
   * Populates the bean necessary to run the CheckStageEventStatus service
   * 
   * @param idStage
   * @param idUser
   * @param cdTask
   * @param actionCode
   * @return Populated CheckStageEventStatus Bean
   */
  private CCMN06UI populateCCMN06UI_CheckStageEventStatus(int idStage, int idUser, String cdTask, String actionCode) {

    CCMN06UI ccmn06ui = new CCMN06UI();
    ArchInputStruct input = new ArchInputStruct();

    ccmn06ui.setUlIdStage(idStage);
    ccmn06ui.setSzCdTask(cdTask);

    input.setSzUserId(String.valueOf(idUser));
    input.setCReqFuncCd(actionCode);

    ccmn06ui.setArchInputStruct(input);

    return ccmn06ui;
  }

  /**
   * Creates/updates the event for Special Needs/Adoption Assist App
   * 
   * @param spNdsDetermSaveSI
   * @param actionCode
   * @return Post Event Output Bean
   */
  private CCMN01UO callPostEvent(SpecialNeedsDeterminationSaveSI spNdsDetermSaveSI, String actionCode) {
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    String desc = "";

    int idEvent = spNdsDetermSaveSI.getSpNdsDetBean().getIdEvent();
    // New plan
    if (idEvent == 0) {
      desc = "Adoption Assistance Application in process for child " + spNdsDetermSaveSI.getIdPerson();
    } else if (CodesTables.CEVTSTAT_PROC.equals(spNdsDetermSaveSI.getCdEventStatus())) {
      rowccmn01uig00.setUlIdEvent(idEvent);
      rowccmn01uig00.setTsLastUpdate(spNdsDetermSaveSI.getDtEventLastUpdate());
      desc = "Adoption Assistance Application in process for child " + spNdsDetermSaveSI.getIdPerson();
    } else if (CodesTables.CEVTSTAT_PEND.equals(spNdsDetermSaveSI.getCdEventStatus())) {
      rowccmn01uig00.setUlIdEvent(idEvent);
      rowccmn01uig00.setTsLastUpdate(spNdsDetermSaveSI.getDtEventLastUpdate());
      desc = "Adoption Assistance Application pending for child " + spNdsDetermSaveSI.getIdPerson();
    }

    rowccmn01uig00.setSzCdEventStatus(spNdsDetermSaveSI.getCdEventStatus());
    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_SND);
    rowccmn01uig00.setSzTxtEventDescr(desc);
    rowccmn01uig00.setSzCdTask(spNdsDetermSaveSI.getCdTask());
    //added the code to make sure "Entered By" field does not get updated when event is approved.
    if(idEvent == 0){
    rowccmn01uig00.setUlIdPerson(spNdsDetermSaveSI.getIdUser());
    }
    rowccmn01uig00.setUlIdStage(spNdsDetermSaveSI.getIdStage());

    if (!DateHelper.isNull(spNdsDetermSaveSI.getDtEventOccurred()) && idEvent != 0) {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(spNdsDetermSaveSI.getDtEventOccurred()));
    } else {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));

    }
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01 rowccmn01uig01;
    if (spNdsDetermSaveSI.getIdPerson() != 0) {
      Integer idPerson = spNdsDetermSaveSI.getIdPerson();
      rowccmn01uig01 = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01();
      rowccmn01uig01.setUlIdPerson(idPerson);
      rowccmn01uig01.setSzCdScrDataAction(actionCode);
      rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
    }
    if (idEvent != 0) {
      rowccmn01uig01_array = null;
    }
    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(actionCode);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);

  }

  /**
   * Populates the Special Needs Hibernate object to prepare it for saving
   * 
   * @param spNdsDetermBean
   * @return Populated Special Needs Hibernate Bean.
   */
  private SpecialNeedsDetermination populateSpecialNeeds(SpecialNeedsDeterminationBean spNdsDetermBean, SpecialNeedsDeterminationSaveSI spNdsDetermSaveSI) {
    SpecialNeedsDetermination spNdsDetermination = new SpecialNeedsDetermination();
    if (spNdsDetermBean != null) {
      spNdsDetermination.setIndAllSpecialDocAttached(spNdsDetermBean.getIndAllSpecialDocAttached());
      spNdsDetermination.setIndApprvMntRetarded(spNdsDetermBean.getIndApprvMntRetarded());
      spNdsDetermination.setIndApprvEmotionalDist(spNdsDetermBean.getIndApprvEmotionalDist());
      spNdsDetermination.setIndApprvHearingImpaired(spNdsDetermBean.getIndApprvHearingImpaired());
      spNdsDetermination.setIndApprvOther(spNdsDetermBean.getIndApprvOther());
      spNdsDetermination.setIndApprvPhysicallyDisabled(spNdsDetermBean.getIndApprvPhysicallyDisabled());
      spNdsDetermination.setIndAprType(spNdsDetermBean.getIndAprType());
      spNdsDetermination.setIndChildEmotionallyDisabled(spNdsDetermBean.getIndChildEmotionallyDisabled());
      spNdsDetermination.setIndChildMntRetarded(spNdsDetermBean.getIndChildMntRetarded());
      spNdsDetermination.setIndChildOtherMedical(spNdsDetermBean.getIndChildOtherMedical());
      spNdsDetermination.setIndChildPhysicallyDisabled(spNdsDetermBean.getIndChildPhysicallyDisabled());
      spNdsDetermination.setIndChildVisHearingImpaired(spNdsDetermBean.getIndChildVisHearingImpaired());
      spNdsDetermination.setIndDocDevelopmentalAssmt(spNdsDetermBean.getIndDocDevelopmentalAssmt());
      spNdsDetermination.setIndDocMentalAssmt(spNdsDetermBean.getIndDocMentalAssmt());
      spNdsDetermination.setIndDocPsychological(spNdsDetermBean.getIndDocPsychological());
      spNdsDetermination.setIndDocTrtmntPrvdr(spNdsDetermBean.getIndDocTrtmntPrvdr());
      spNdsDetermination.setIndDocSSI(spNdsDetermBean.getIndDocSSI());
      spNdsDetermination.setIndReasonSpecialRequest(spNdsDetermBean.getIndReasonSpecialRequest());
      spNdsDetermination.setIndSpclRateAdoAppr(spNdsDetermBean.getIndSpclRateAdoAppr());
      spNdsDetermination.setIndBasicRateReqChild(spNdsDetermBean.getIndBasicRateReq());
      spNdsDetermination.setIndSfcRbwoRcvd(spNdsDetermBean.getIndSFCorRBWO());
      spNdsDetermination.setIndSpclRateReqChild(spNdsDetermBean.getIndSpecializedRateReq());
      spNdsDetermination.setIndSpclReqApproved(spNdsDetermBean.getIndSpclReqApproved());
      spNdsDetermination.setIndSpclSerReqChild(spNdsDetermBean.getIndSpclServiceReq());
      spNdsDetermination.setIndAgrmtType(spNdsDetermBean.getIndAgrmtType());
      spNdsDetermination.setIndSpcNeedsApproved(spNdsDetermBean.getIndSpcNeedsApproved());
      spNdsDetermination.setCdApprvSpclTypeFunding(spNdsDetermBean.getCdApprvSpclTypeFunding());
      spNdsDetermination.setCdFundingType(spNdsDetermBean.getCdFundingType());
      spNdsDetermination.setCdSpclSerType(spNdsDetermBean.getCdSpclSerType());
      spNdsDetermination.setCdPaymentMthd(spNdsDetermBean.getCdPaymentMethod());
      spNdsDetermination.setDtApprvDate(spNdsDetermBean.getDtApprvDate());
      spNdsDetermination.setDtExpirationDate(spNdsDetermBean.getDtExpirationDate());
      spNdsDetermination.setIdEvent(spNdsDetermBean.getIdEvent());
      spNdsDetermination.setNbrApprvAmt(spNdsDetermBean.getNbrApprvAmt());
      spNdsDetermination.setNbrIvbAmt(spNdsDetermBean.getNbrIvbAmt());
      spNdsDetermination.setNbrIveAmt(spNdsDetermBean.getNbrIveAmt());
      spNdsDetermination.setNbrReqAmt(spNdsDetermBean.getNbrReqAmt());
      spNdsDetermination.setNbrTotalIveIvbAmt(spNdsDetermBean.getNbrTotalIveIvbAmt());
      spNdsDetermination.setTxtApprvOtherCmt(spNdsDetermBean.getTxtApprvOtherCmt());
      spNdsDetermination.setTxtCmntsEmotionallyDisabled(spNdsDetermBean.getTxtCmntsEmotionallyDisabled());
      spNdsDetermination.setTxtCmntsMntRetarded(spNdsDetermBean.getTxtCmntsMntRetarded());
      spNdsDetermination.setTxtCmntsOtherMedical(spNdsDetermBean.getTxtCmntsOtherMedical());
      spNdsDetermination.setTxtCmntsPhysicallyDisabled(spNdsDetermBean.getTxtCmntsPhysicallyDisabled());
      spNdsDetermination.setTxtCmntsSpecialRequest(spNdsDetermBean.getTxtCmntsSpecialRequest());
      spNdsDetermination.setTxtCmntsVisHearingImpaired(spNdsDetermBean.getTxtCmntsVisHearingImpaired());
      spNdsDetermination.setTxtComments(spNdsDetermBean.getTxtComments());
      spNdsDetermination.setTxtPleaseSpecify(spNdsDetermBean.getTxtPleaseSpecify());
      spNdsDetermination.setIndNonRecApproved(spNdsDetermBean.getIndNonRecApproved());
      spNdsDetermination.setNbrNonRecAprvAmt(spNdsDetermBean.getNbrNonRecAprvAmt());
      spNdsDetermination.setIndNonRecRequested(spNdsDetermBean.getIndNonRecRequested());
      spNdsDetermination.setNbrNonRecAmt(spNdsDetermBean.getNbrNonRecAmt());
      spNdsDetermination.setNbrSpNeedsChildrenRequest(spNdsDetermBean.getNbrSpNeedsChildrenRequest());
      spNdsDetermination.setIndNonRecOnly(spNdsDetermBean.getIndNonRecOnly());
      
      //STGAP00014563: New fields added
      spNdsDetermination.setTxtAdditionalComments(spNdsDetermBean.getAddComments());
      spNdsDetermination.setDtSpclNeedsApprvd(spNdsDetermBean.getDtSpecialNeedsApproved());
      spNdsDetermination.setCdBasicRateType(spNdsDetermBean.getCdBasicRateType());
      spNdsDetermination.setNbrCountyAddonAmt(spNdsDetermBean.getNbrCountyAddonAmt());
      
      //STGAP00014563: Set the Custom basic rate
      spNdsDetermination.setNbrBasicRateAmt(spNdsDetermBean.getNbrBasicAmt());
      
      //MR-60
      spNdsDetermination.setCdSpcNdsPrePosReq(spNdsDetermBean.getCdSpcNdsPrePosReq());
      spNdsDetermination.setCdSpcNdsPrePosApr(spNdsDetermBean.getCdSpcNdsPrePosApr());
    }
    return spNdsDetermination;
  }
}
