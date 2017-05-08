//*  Service Class  Name:     SaveChildPlanImpl
//*  Created by:   Jacob Vaidyan
//*  Date Created: 1/8/2007
//*
//*  Description:Service Implementation for Saving FCC Child Plan.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**
//**  

package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FccpChildDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.FccpChild;
import gov.georgia.dhr.dfcs.sacwis.db.FccpChildCbx;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SaveChildPlan;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ChildPlanDetailList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ChildPlanDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ChildPlanDetailSaveSO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SaveChildPlanImpl extends BaseServiceImpl implements SaveChildPlan {

  private FccpChildDAO fccpChildDAO = null;

  private PostEvent postEvent = null;

  private EventDAO eventDAO = null;

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setFccpChildDAO(FccpChildDAO fccpChildDAO) {
    this.fccpChildDAO = fccpChildDAO;
  }

  public ChildPlanDetailSaveSO updateChildPlanInformation(ChildPlanDetailSaveSI childplanSaveSI)
                                                                                                throws ServiceException {
    ChildPlanDetailSaveSO childplanSaveSO = new ChildPlanDetailSaveSO();
    saveChildPlan(childplanSaveSI);
    return childplanSaveSO;
  }

  /**
   * saveChildPlan takes care of posting the event and call the method for saving/updating the information into
   * FccpChild Table .
   * 
   * @param context
   *          The ChildPlanDetailSaveSI object.
   */
  public int saveChildPlan(ChildPlanDetailSaveSI childplanSaveSI) throws ServiceException {

    int idEvent = childplanSaveSI.getUlIdEvent();
    CCMN01UO ccmn01uo = new CCMN01UO();
    ROWCCMN01UIG00 childplanEvent = childplanSaveSI.getcpdBean().getROWCCMN01UIG00();
    String eventCompStatus = "COMP";
    int nbreventupdate = 0;
    String eventReqFuncCd = "";
    if (idEvent != 0) {
      eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
    } else {
      eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
    }
    childplanSaveSI.setCdReqFuncCd(eventReqFuncCd);

    if (idEvent == 0) {
      ccmn01uo = callPostEvent(eventReqFuncCd, childplanEvent);
      idEvent = ccmn01uo.getUlIdEvent();
      childplanSaveSI.setUlIdEvent(idEvent);
    }

    if (eventReqFuncCd.equals(ServiceConstants.REQ_FUNC_CD_UPDATE) && (childplanSaveSI.getComplete())) {
      nbreventupdate = eventDAO.updateEventByIdEvent(idEvent, eventCompStatus);
    }
    savechilddetailplan(childplanSaveSI);
    return idEvent;
  }

  /**
   * savechilddetailplan takes care of saving/updating the information into Fccp_Child Table .
   * 
   * @param context
   *          The ChildPlanDetailSaveSI object.
   */
  private void savechilddetailplan(ChildPlanDetailSaveSI childplanSaveSI) throws ServiceException {

    ChildPlanDetailList row = childplanSaveSI.getcpdBean();
    FccpChild fccpchild = new FccpChild();
    int idEvent = childplanSaveSI.getUlIdEvent();
    Event event = getPersistentObject(Event.class, idEvent);
    childplanSaveSI.setUlIdEvent(idEvent);
    String ldTxtSvcOffProvidedDesc = row.getLdTxtSvcOffProvidedDesc();
    Date ldDtCompDate = row.getLdDtCompDate();
    Date ldDtLastUpdate = row.getDtLastUpdate();
    String ldInddilSearchComp = row.getLdInddilSearchComp();
    String ldIndChildAdjInCare = row.getLdIndChildAdjInCare();
    String ldTxtExpChildAdjInCare = row.getLdTxtExpChildAdjInCare();
    Date tsLastUpdate = childplanSaveSI.getDtLastUpdate();
    Date tscbxAsfaLastUpdate = childplanSaveSI.getDtCbxAsfaLastUpdate();
    Date tscbxParLastUpdate = childplanSaveSI.getDtCbxParLastUpdate();
    Date tscbxNruLastUpdate = childplanSaveSI.getDtCbxNruLastUpdate();
    String[] asfaExistingConditions = row.getasfaExistingConditions();
    String[] parentalRtsTerm = row.getparentalRtsTerm();
    String[] nonReunificConditions = row.getnonReunificConditions();
    String ldTxtasfa = row.getLdTxtparentalRightsCmnts();
    String ldIndFilePetition = row.getLdIndFilePetition();
    Date ldDtfilePetitionDate = row.getLdDtfilePetitionDate();
    String ldTxtfilePetitionCmnts = row.getLdTxtfilePetitionCmnts();
    String ldTxtfinalPermPlacementSteps = row.getLdTxtfinalPermPlacementSteps();
    String ldIndPermPlan = row.getLdIndPermPlan();
    String ldTxtadditionalInfo = row.getLdTxtadditionalInfo();
    String ldIndImmunization = row.getLdIndImmunization();
    String ldTxtImmunizationCmnts = row.getLdTxtImmunizationCmnts();
    String ldIndImmunizationOnFile = row.getLdIndImmunizationOnFile();
    String ldTxtImmunizationFileComments = row.getLdTxtImmunizationFileComments();
    String ldIndMedPsychProblems = row.getLdIndMedPsychProblems();
    String ldTxtMedPsychProblemsCmnts = row.getLdTxtMedPsychProblemsCmnts();
    String ldIndMedRecFile = row.getLdIndMedRecFile();
    String ldTxtMedRecFileCmnts = row.getLdTxtMedRecFileCmnts();
    String ldIndPsychRecFile = row.getLdIndPsychRecFile();
    String ldTxtPsychRecFileCmnts = row.getLdTxtPsychRecFileCmnts();
    String ldIndMedPsychTrmnt = row.getLdIndMedPsychTrmnt();
    String ldIndMedPsychDocRecord = row.getLdIndMedPsychDocRecord();
    String ldTxtMedPsychDocRecordCmnts = row.getLdTxtMedPsychDocRecordCmnts();
    String ldTxtOtherMedPsychDocRecordCmnts = row.getLdTxtOtherMedPsychDocRecordCmnts();
    int idFCCPChildCbx = row.getIdFccpChild();
    fccpchild.setEvent(event);
    fccpchild.setIdEvent(idEvent);
    fccpchild.setDtLastUpdate(tsLastUpdate);
    fccpchild.setIndDilgntSrch(ldInddilSearchComp);
    fccpchild.setIndChildAdjCare(ldIndChildAdjInCare);
    fccpchild.setTxtEffrtsRem(ldTxtSvcOffProvidedDesc);
    fccpchild.setDtDilgntComp(ldDtCompDate);
    fccpchild.setTxtChildAdjComm(ldTxtExpChildAdjInCare);
    fccpchild.setTxtAfsa(ldTxtasfa);
    fccpchild.setIndTpr(ldIndFilePetition);
    fccpchild.setDtTpr(ldDtfilePetitionDate);
    fccpchild.setTxtTpr(ldTxtfilePetitionCmnts);
    fccpchild.setTxtSteps(ldTxtfinalPermPlacementSteps);
    fccpchild.setIndPermPlan(ldIndPermPlan);
    fccpchild.setTxtAddtlInfo(ldTxtadditionalInfo);
    fccpchild.setIndImmUtd(ldIndImmunization);
    fccpchild.setTxtImmUtd(ldTxtImmunizationCmnts);
    fccpchild.setIndImmOnfile(ldIndImmunizationOnFile);
    fccpchild.setTxtImmOnfile(ldTxtImmunizationFileComments);
    fccpchild.setIndOngoingProb(ldIndMedPsychProblems);
    fccpchild.setTxtOngoingProb(ldTxtMedPsychProblemsCmnts);
    fccpchild.setIndMedrecOnfile(ldIndMedRecFile);
    fccpchild.setTxtMedrecOnfile(ldTxtMedRecFileCmnts);
    fccpchild.setIndPsychOnfile(ldIndPsychRecFile);
    fccpchild.setTxtPsychOnfile(ldTxtPsychRecFileCmnts);
    //fccpchild.setIndPsychOnfile(ldIndMedPsychTrmnt);
    fccpchild.setIndPsychTreat(ldIndMedPsychTrmnt);
    fccpchild.setIndPsychDoc(ldIndMedPsychDocRecord);
    fccpchild.setTxtEvalDates(ldTxtMedPsychDocRecordCmnts);
    fccpchild.setTxtRelevantMed(ldTxtOtherMedPsychDocRecordCmnts);

    String FuncID = childplanSaveSI.getCdReqFuncCd();
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(childplanSaveSI.getCdReqFuncCd())) {
      fccpChildDAO.InsertChildPlanDetail(fccpchild);
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(childplanSaveSI.getCdReqFuncCd())) {
      fccpChildDAO.InsertChildPlanDetail(fccpchild);
    }

    savechildplanchecks(fccpchild, asfaExistingConditions, idEvent, parentalRtsTerm, nonReunificConditions,
                        idFCCPChildCbx, FuncID, tscbxAsfaLastUpdate, tscbxParLastUpdate, tscbxNruLastUpdate);

  }

  /**
   * callPostEvent takes care of posting the event.
   * 
   * @param context
   *          The ROWCCMN01UIG00 object. String cReqFuncCd Add/Update.
   */

  private CCMN01UO callPostEvent(String cReqFuncCd, ROWCCMN01UIG00 rowccmn01uig00) throws ServiceException {

    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(cReqFuncCd);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);
  }

  /**
   * savechildplanchecks saves the checkboxes selected in ChildPlan Page to FCCP_CHILD_CBX Table.
   * 
   * @param context
   *          The FccpChild object. String Array of ASFA Existing Conditions selected. String Array of Parental Terms
   *          Conditions selected. String Array of NRU Conditions selected. FccpChildCbx ID Last updated for the 3
   *          checkbox sections.
   */
  private void savechildplanchecks(FccpChild child, String[] asfaExistingConditions, int IdEvent,
                                   String[] parentalRtsTerm, String[] nonReunificConditions, int idFCCPChildCbx,
                                   String FuncID, Date tscbxAsfaLastUpdate, Date tscbxParLastUpdate,
                                   Date tscbxNruLastUpdate) throws ServiceException {

    List<String> asfaList = new ArrayList<String>();
    List<String> parTerm = new ArrayList<String>();
    List<String> nruList = new ArrayList<String>();

    // add each element of the array to the list
    for (int i = 0; i < asfaExistingConditions.length; i++) {
      asfaList.add(asfaExistingConditions[i]);
    }
    for (int i = 0; i < parentalRtsTerm.length; i++) {
      parTerm.add(parentalRtsTerm[i]);
    }
    for (int i = 0; i < nonReunificConditions.length; i++) {
      nruList.add(nonReunificConditions[i]);
    }

    Iterator itAsfa = asfaList.iterator();
    Iterator itPar = parTerm.iterator();
    Iterator itNru = nruList.iterator();

    String cbx_asfa_code = "CCPTASF1";
    String cbx_par_code = "CCPTASF2";
    String cbx_nru_code = "CCPTNRUN";

    if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(FuncID)) {
      fccpChildDAO.deleteChildPlanChkBxByIdEvent(IdEvent, cbx_asfa_code);
      fccpChildDAO.deleteChildPlanChkBxByIdEvent(IdEvent, cbx_par_code);
      fccpChildDAO.deleteChildPlanChkBxByIdEvent(IdEvent, cbx_nru_code);
    }

    while (itAsfa.hasNext()) {
      FccpChildCbx fccpchildcbx_asf = new FccpChildCbx();
      fccpchildcbx_asf.setFccpChild(child);
      fccpchildcbx_asf.setDtLastUpdate(tscbxAsfaLastUpdate);
      fccpchildcbx_asf.setCdCbx(itAsfa.next().toString());
      fccpchildcbx_asf.setCdCbxCodeType(cbx_asfa_code);

      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(FuncID)) {
        fccpChildDAO.InsertChildPlanCheckBox(fccpchildcbx_asf);
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(FuncID)) {
        fccpChildDAO.InsertChildPlanCheckBox(fccpchildcbx_asf);
      }

    }

    while (itPar.hasNext()) {
      FccpChildCbx fccpchildcbx_par = new FccpChildCbx();

      fccpchildcbx_par.setFccpChild(child);
      fccpchildcbx_par.setDtLastUpdate(tscbxParLastUpdate);
      fccpchildcbx_par.setCdCbx(itPar.next().toString());
      fccpchildcbx_par.setCdCbxCodeType(cbx_par_code);
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(FuncID)) {
        fccpChildDAO.InsertChildPlanCheckBox(fccpchildcbx_par);
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(FuncID)) {
        fccpChildDAO.InsertChildPlanCheckBox(fccpchildcbx_par);
      }
    }

    while (itNru.hasNext()) {
      FccpChildCbx fccpchildcbx_nru = new FccpChildCbx();
      fccpchildcbx_nru.setFccpChild(child);
      fccpchildcbx_nru.setDtLastUpdate(tscbxNruLastUpdate);
      fccpchildcbx_nru.setCdCbx(itNru.next().toString());
      fccpchildcbx_nru.setCdCbxCodeType(cbx_nru_code);
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(FuncID)) {
        fccpChildDAO.InsertChildPlanCheckBox(fccpchildcbx_nru);
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(FuncID)) {
        fccpChildDAO.InsertChildPlanCheckBox(fccpchildcbx_nru);
      }
    }
  }
}
