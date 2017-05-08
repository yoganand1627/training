package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CodesTablesDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexTodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FCCPFamilyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.WorkloadDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.FccpFamily;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveSpecializedUnitPersonnel;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SaveFCCPFamilyDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCCPFamilyDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCCPFamilyDetailSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FCCPFamilyDetailSO.RowPlanPrincipal;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *  Change History:
 *    Date         User                Description
 *    -----------  ----------------    --------------------------------------------------------------------------------
 *    11/25/2008   charden             STGAP00007503 - changed populate method to take principalsForEventfromRequest since this is a new
 *                                     FCCP being createdand there is no need to delete any person already associated with the event 
 *    06/12/2009   mxpatel             STGAP00012669: added code to find ado stages only for children selected on the and see if they each 
 *                                     have an ADO Info in COMP status
 *    07/22/2009   hjbaptiste          STGAP00014781: Moved the Alert (Child's permanency plan has changed) to SaveApprovalImpl.java class
 *    12/02/2009   bgehlot             41275 MR-057 APPLA changes
 *    01/25/2010   bgehlot             44337 MR-057 Concurrent Permanency Plan Type validation needs to allow court ordered selections
 *    08/03/2010   bgehlot             SMS# 65400 MR-068 Assigned Judge is now a Drop Down has created new column for to store Assigned Judge. Old value still is 
 *                                     retained in nmAssgnJudge.
 *    08/28/2010   bgehlot             SMS 67675 MR-068 Check to see if the text is one of the code in the CJUDGES table
 *                                                              
 * </pre>
 * 
 
 */

public class SaveFCCPFamilyDetailImpl extends BaseServiceImpl implements SaveFCCPFamilyDetail {
  private CheckStageEventStatus checkStageEventStatus = null;

  private ComplexTodoDAO complexTodoDAO = null;

  private EventDAO eventDAO = null;

  private EventPersonLinkDAO eventPersonLinkDAO = null;

  private FCCPFamilyDAO fccpFamilyDAO = null;

  private LegalActionDAO legalActionDAO = null;

  private PersonDAO personDAO = null;

  private PostEvent postEvent = null;

  private RetrieveSpecializedUnitPersonnel retrieveSpecializedUnitPersonnel = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private TodoDAO todoDAO = null;

  private WorkloadDAO workloadDAO = null;
  
  private PlacementDAO placementDAO = null;
  
  private CodesTablesDAO codesTablesDAO = null;

  public FCCPFamilyDetailSaveSO saveFCCPFamilyDetail(List<FCCPFamilyDetailSO.RowPlanPrincipal> principalsForEventfromState,
                                  FCCPFamilyDetailSO fCCPFamilyDetailToSave) {
    FCCPFamilyDetailSaveSO fCCPFamilyDetailSaveSO = new FCCPFamilyDetailSaveSO();
    int idEvent = fCCPFamilyDetailToSave.getEventId();
    int idCase = fCCPFamilyDetailToSave.getCaseId();
    int idStage = fCCPFamilyDetailToSave.getStageId();
    int idUser = fCCPFamilyDetailToSave.getUserId();
    FccpFamily fccpFamily = null;

    List<FCCPFamilyDetailSO.RowPlanPrincipal> principalsForEventfromRequest = fCCPFamilyDetailToSave
                                                                                                    .getPrincipalsForEvent();
    List<Integer> idPersonPrns = new ArrayList<Integer>();
    Iterator itr = principalsForEventfromRequest.iterator();
    // principal list always exists at this point, no need for null check here
    while (itr.hasNext()) {
      int idPerson = ((FCCPFamilyDetailSO.RowPlanPrincipal) itr.next()).getIdPerson();
      idPersonPrns.add(idPerson);
    }

    // Determine whether the stage is open and modifiable.
    callCheckStageEventStatus(fCCPFamilyDetailToSave);

    // For Plan that is created by clicking on Copy/Update and Save and Submit without going through Save
    if (fCCPFamilyDetailToSave.isSaveAndSubmit() && !AFTER_CARE.equals(fCCPFamilyDetailToSave.getSelCrtPlanType())) {
      // If there is child included in plan has sub or adoption stage open for
      List<Integer> idPrimaryChildList = personDAO.findIdPrimacyChildSubAdoFromPrnsList(idCase, idPersonPrns);
      // Sub or adoption stage exists
      if (idPrimaryChildList != null && !idPrimaryChildList.isEmpty()) {
        Iterator idPrimaryListItr = idPrimaryChildList.iterator();
        while (idPrimaryListItr.hasNext()) {
          int idPerson = (Integer) idPrimaryListItr.next();
          Map statusMap = eventDAO.findLatestChildEventStatusByPersonByCase(CodesTables.CEVNTTYP_CSP, idPerson, idCase);
          // one child does not have Child Detail
          if (statusMap == null || statusMap.isEmpty()) {
            fCCPFamilyDetailToSave.setCdEventStatus(CodesTables.CEVTSTAT_PROC);
            throw new ServiceException(Messages.MSG_CHILD_COMP_SUBMIT);
          }
          String status = (String) statusMap.get("CD_EVENT_STATUS");
          if (CodesTables.CEVTSTAT_PROC.equals(status)) {
            fCCPFamilyDetailToSave.setCdEventStatus(CodesTables.CEVTSTAT_PROC);
            throw new ServiceException(Messages.MSG_CHILD_COMP_SUBMIT);
          }
        }

        // WTLP check
        List<Integer> idWtlpCandidateList = personDAO.findIdWtlpCandidateFromPrnsList(idCase, idPrimaryChildList);
        // Exists child over 14
        if (idWtlpCandidateList != null && !idWtlpCandidateList.isEmpty()) {
          Iterator idWtlpCandidateItr = idWtlpCandidateList.iterator();
          while (idWtlpCandidateItr.hasNext()) {
            int idWtlpCandidate = (Integer) idWtlpCandidateItr.next();
            Map wtlpStatusMap = eventDAO.findLatestChildEventStatusByPersonByCase(CodesTables.CEVNTTYP_WTL,
                                                                                  idWtlpCandidate, idCase);
            // caught one child not have WTLP
            if (wtlpStatusMap == null || wtlpStatusMap.isEmpty()) {
              fCCPFamilyDetailToSave.setCdEventStatus(CodesTables.CEVTSTAT_PROC);
              throw new ServiceException(Messages.MSG_WTLP_APRV_SUBMIT);
            }
            String status = (String) wtlpStatusMap.get("CD_EVENT_STATUS");
            // WTLP exists for this child but not approved
            if (!CodesTables.CEVTSTAT_APRV.equals(status)) {
              fCCPFamilyDetailToSave.setCdEventStatus(CodesTables.CEVTSTAT_PROC);
              throw new ServiceException(Messages.MSG_WTLP_APRV_SUBMIT);
            }
          }
        }
      }
    }

    if (fCCPFamilyDetailToSave.isSaveAndSubmit() && !AFTER_CARE.equals(fCCPFamilyDetailToSave.getSelCrtPlanType())) {
      // ensure that the latest adoption information is completed

      // mxpatel added this for defect #STGAP00012669 to find ado stages only for children selected on the and see if
      // they have an ADO Info in COMP status
      String cdStage = CodesTables.CSTAGES_ADO;
      String cdPersonRole = CodesTables.CROLEALL_PC;
      // get the adoption stages for children selected on the plan
      List<Integer> adoptionStages = stagePersonLinkDAO.findIdAdoStageByIdEventIdCase(idEvent, idCase, cdStage,
                                                                                      cdPersonRole);
      if (adoptionStages != null && adoptionStages.size() > 0) {
        Iterator<Integer> adoStageIdIterator = adoptionStages.iterator();
        while (adoStageIdIterator.hasNext()) {
          Integer idAdoStage = adoStageIdIterator.next();
          // find if the stage has an ADO Info with COMP status
          Event latestAdoInfoEvent = eventDAO.findLatestEventByStageAndType(idAdoStage, CodesTables.CSTAGES_ADO);
          if (latestAdoInfoEvent == null || !latestAdoInfoEvent.getCdEventStatus().equals("COMP")) {
            throw new ServiceException(Messages.MSG_ADO_INFO_COMP_SUBMIT);
          }
        }
      }

    }
    
    //MR-057 APPLA Changes
    //Check to see if Placement Questions are answered only when one of the Primary and Secondary Plan is APPLA
    if (fCCPFamilyDetailToSave.isSaveAndSubmit() && !AFTER_CARE.equals(fCCPFamilyDetailToSave.getSelCrtPlanType()) &&
       !((CodesTables.CPERMPLN_FCO.equals(fCCPFamilyDetailToSave.getSelPPP()) && CodesTables.CPERMPLN_FCO.equals(fCCPFamilyDetailToSave.getSelSPP())) &&
         (CodesTables.CPERMPLN_LAE.equals(fCCPFamilyDetailToSave.getSelPPP()) && CodesTables.CPERMPLN_LAE.equals(fCCPFamilyDetailToSave.getSelSPP())))
       ){
      List<FCCPFamilyDetailSO.RowPlanPrincipal> selectedChildren = fCCPFamilyDetailToSave.getPrincipalsForEvent();
      Iterator<FCCPFamilyDetailSO.RowPlanPrincipal> iter = selectedChildren.iterator();

      List<Map<String,Object>> childQuestionList = new ArrayList<Map<String,Object>>();

      while (iter.hasNext()) {
        Map<String,Object> childQuestion = new HashMap<String,Object>();
        FCCPFamilyDetailSO.RowPlanPrincipal rowPlanPrincipal = (FCCPFamilyDetailSO.RowPlanPrincipal) iter.next();
        if(!ArchitectureConstants.Y.equals(rowPlanPrincipal.getIsCaregiver())){
          int idPerson = rowPlanPrincipal.getIdPerson();
          //Get person's name
          Person person = personDAO.findPersonByIdPerson(idPerson);
          String nmPerson = person.getNmPersonFull();
          //Get the Current Placement
          Placement currentPlacement = placementDAO.findMostRecentPlcmtByIdPersonByIdCase(idPerson, idCase);
          if(currentPlacement != null){
            //If the Permanency Plan or Concurrent Plan is 'Another Planned Permanent Living Arrangement Through Long Term Foster Care (04)'
            // and LTFC placement question on the current Placement is unanswered then set the map
            if((CodesTables.CPERMPLN_FCO.equals(fCCPFamilyDetailToSave.getSelPPP()) || CodesTables.CPERMPLN_FCO.equals(fCCPFamilyDetailToSave.getSelSPP()) ) && 
                            currentPlacement.getIndLTFCPlacement() == null){
              childQuestion.put("idPerson", idPerson);
              childQuestion.put("nmPerson", nmPerson);
              childQuestion.put("idPlacementEvent", currentPlacement.getIdPlcmtEvent());
              childQuestion.put("indLTFCQuesAnswered", ArchitectureConstants.N);
              childQuestionList.add(childQuestion);
            }
            //If the Permanency Plan or Concurrent Plan is 'Another Planned Permanent Living Arrangement through Emancipation (05)'
            // and  the question about child's connection to an Adult on the current Placement is unanswered then set the map
            if((CodesTables.CPERMPLN_LAE.equals(fCCPFamilyDetailToSave.getSelPPP()) || CodesTables.CPERMPLN_LAE.equals(fCCPFamilyDetailToSave.getSelSPP())) && 
                            currentPlacement.getIndChildConnectAdult() == null){
              childQuestion.put("idPerson", idPerson);
              childQuestion.put("nmPerson", nmPerson);
              childQuestion.put("idPlacementEvent", currentPlacement.getIdPlcmtEvent());
              childQuestion.put("indAdultConnectionQuesAnswered", ArchitectureConstants.N);
              childQuestionList.add(childQuestion);
            }
          }
          fCCPFamilyDetailSaveSO.setChildQuestionList(childQuestionList);
        }
      }


      //If any of the Questions is unanswered for even one child then return.
      if(fCCPFamilyDetailSaveSO.getChildQuestionList() != null && !fCCPFamilyDetailSaveSO.getChildQuestionList().isEmpty()){
        Iterator<Map<String,Object>> iter1 = fCCPFamilyDetailSaveSO.getChildQuestionList().iterator();
        while (iter1.hasNext()) {
          Map<String,Object> childQuesMap = (Map<String,Object>) iter1.next();
          if(ArchitectureConstants.N.equals(childQuesMap.get("indLTFCQuesAnswered")) ||
                          ArchitectureConstants.N.equals(childQuesMap.get("indAdultConnectionQuesAnswered"))){
            return fCCPFamilyDetailSaveSO;
          }
        }
      }
    }
    
    if (idEvent == 0) {
      String cReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
      // STGAP00007503 - changed populate method to take principalsForEventfromRequest since this is a new FCCP being
      // created
      // and there is no need to delete any person already associated with the event
      ROWCCMN01UIG00 rowccmn01uig00 = populateROWCCMN01UIG00_PostEvent(principalsForEventfromRequest,
                                                                       fCCPFamilyDetailToSave);
      CCMN01UO ccmn01uo = callPostEvent(cReqFuncCd, rowccmn01uig00, principalsForEventfromRequest);
      // New Event creation successful
      // Now populate the rest of data and save to database
      if (ccmn01uo != null) {
        idEvent = ccmn01uo.getUlIdEvent();
        fCCPFamilyDetailToSave.setEventId(idEvent);
        int numRowCareGiverUpdated = callUpdateCareGiverStatus(idEvent, principalsForEventfromRequest);
        if (numRowCareGiverUpdated != principalsForEventfromRequest.size()) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        fccpFamily = populateFCCPFamily_Save(rowccmn01uig00, fCCPFamilyDetailToSave);
        fccpFamilyDAO.saveFccpFamily(fccpFamily);

      }
    } else {

      String cReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
      ROWCCMN01UIG00 rowccmn01uig00 = populateROWCCMN01UIG00_PostEvent(principalsForEventfromState,
                                                                       fCCPFamilyDetailToSave);
      rowccmn01uig00.setUlIdEvent(idEvent);
      rowccmn01uig00.setTsLastUpdate(fCCPFamilyDetailToSave.getDtEventLastUpdate());
      CCMN01UO ccmn01uo = callPostEvent(cReqFuncCd, rowccmn01uig00, principalsForEventfromRequest);

      if (ccmn01uo != null) {
        int numRowCareGiverUpdated = callUpdateCareGiverStatus(idEvent, principalsForEventfromRequest);
        if (numRowCareGiverUpdated != principalsForEventfromRequest.size()) {
          fCCPFamilyDetailToSave.setCdEventStatus(CodesTables.CEVTSTAT_PROC);
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        fccpFamily = populateFCCPFamily_Save(rowccmn01uig00, fCCPFamilyDetailToSave);
        fccpFamily.setIdEvent(idEvent);
        fccpFamily.setDtLastUpdate(fCCPFamilyDetailToSave.getLastUpdate());
        fccpFamilyDAO.saveFccpFamily(fccpFamily);
      }
      // add Todos here after successful save in case rollback can't be completed when save fails
      if (fCCPFamilyDetailToSave.isSaveAndSubmit()
          && !CodesTables.CCTPLNTY_AFC.equals(fCCPFamilyDetailToSave.getSelCrtPlanType())) {
        // Alert when next review date is 15 days away from current date
        addDtNextReviewAlertTodo(idEvent, idCase, idStage, idUser, fCCPFamilyDetailToSave.getDtNextReview(),
                                 CodesTables.CROLEALL_PR, fCCPFamilyDetailToSave.getNmStage());
      }
    }
    fCCPFamilyDetailSaveSO.setIdEvent(fccpFamily.getIdEvent());
    return fCCPFamilyDetailSaveSO;
  }

  /**
   * Insert value of caregiver status after a successful postevent call since can't do it inside PostEvent Intuitively,
   * caregiver should be included in ROWCCMN01UIG01 but there are hundreds of xsd's containing element ROWCCMN01UIG01
   * definition Can't update them all with caregiver
   * 
   * @param idEvent
   * @param principlasForEventFromRequest
   * @return
   */
  private int callUpdateCareGiverStatus(int idEvent,
                                        List<FCCPFamilyDetailSO.RowPlanPrincipal> principlasForEventFromRequest) {
    Iterator iter = principlasForEventFromRequest.iterator();
    int numRowsUpdated = 0;
    while (iter.hasNext()) {
      FCCPFamilyDetailSO.RowPlanPrincipal prn = (FCCPFamilyDetailSO.RowPlanPrincipal) iter.next();
      Integer idPerson = prn.getIdPerson();
      String indCareGiver = prn.getIsCaregiver();
      numRowsUpdated += eventPersonLinkDAO.updateCareGiverStatus(indCareGiver, idPerson, idEvent);
    }
    return numRowsUpdated;
  }

  private CCMN01UO callPostEvent(String cReqFuncCd, ROWCCMN01UIG00 rowccmn01uig00,
                                 List<FCCPFamilyDetailSO.RowPlanPrincipal> principalsForEventfromRequest)
                                                                                                         throws ServiceException {

    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(cReqFuncCd);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);
  }

  private ROWCCMN01UIG00 populateROWCCMN01UIG00_PostEvent(
                                                          List<FCCPFamilyDetailSO.RowPlanPrincipal> principalsForEventfromState,
                                                          FCCPFamilyDetailSO fCCPFamilyDetailToSave) {
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    // The description varies depending on New, New Using or Update mode and plan type
    String desc = "";
    int idEvent = fCCPFamilyDetailToSave.getEventId();
    // New plan
    if (idEvent == 0) {
      desc = null;
    }
    // Existing plan
    else {
      desc = fCCPFamilyDetailToSave.getTxtEventDesc();
    }

    desc = buildEventTxt(fCCPFamilyDetailToSave, desc);

    rowccmn01uig00.setSzCdEventStatus(fCCPFamilyDetailToSave.getCdEventStatus());
    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_PLN);
    rowccmn01uig00.setSzTxtEventDescr(desc);

    rowccmn01uig00.setSzCdTask(fCCPFamilyDetailToSave.getCdTask());
    rowccmn01uig00.setUlIdPerson(fCCPFamilyDetailToSave.getUserId());
    rowccmn01uig00.setUlIdStage(fCCPFamilyDetailToSave.getStageId());

    if (!DateHelper.isNull(fCCPFamilyDetailToSave.getDtEventOccurred()) && fCCPFamilyDetailToSave.getEventId() != 0) {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(fCCPFamilyDetailToSave.getDtEventOccurred()));
    } else {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));

    }

    Iterator iter;
    int numOfPrincipalsInList = 0;
    List<FCCPFamilyDetailSO.RowPlanPrincipal> principalsFromRequestBean;
    Map<Integer, String> principalsFromStateBeanHashmap = new HashMap<Integer, String>();
    Map<Integer, Integer> principalsFromRequestBeanHashmap = new HashMap<Integer, Integer>();

    if (principalsForEventfromState != null) {
      iter = principalsForEventfromState.iterator();
      while (iter.hasNext()) {
        FCCPFamilyDetailSO.RowPlanPrincipal prn = (FCCPFamilyDetailSO.RowPlanPrincipal) iter.next();
        Integer personId = prn.getIdPerson();
        String indCareGiver = prn.getIsCaregiver();
        principalsFromStateBeanHashmap.put(personId, indCareGiver);
      }
    }
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01 rowccmn01uig01;

    if (fCCPFamilyDetailToSave.getPrincipalsForEvent() != null) {
      principalsFromRequestBean = fCCPFamilyDetailToSave.getPrincipalsForEvent();
      iter = principalsFromRequestBean.iterator();
      while (iter.hasNext()) {
        FCCPFamilyDetailSO.RowPlanPrincipal prn = (FCCPFamilyDetailSO.RowPlanPrincipal) iter.next();
        Integer idPerson = prn.getIdPerson();
        // Principals in the request bean, but not in the state bean were newly
        // selected, so ADD them.
        // Or in case of New Using principalsForState is populated with existing data
        // the page first loaded, so ADD them Post Event data
        if (!principalsFromStateBeanHashmap.containsKey(idPerson) || fCCPFamilyDetailToSave.getEventId() == 0) {
          rowccmn01uig01 = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01();
          rowccmn01uig01.setUlIdPerson(idPerson);
          rowccmn01uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
          rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
          numOfPrincipalsInList++;
        }
        principalsFromRequestBeanHashmap.put(idPerson, idPerson);// prn.getIsCaregiver();
      } // end while ( iter.hasNext() )
    } // end if ( familyPlanBeanFromRequest.getPrincipalsForEvent() != null )

    if (principalsForEventfromState != null) { // ADD skip this;
      iter = principalsForEventfromState.iterator();
      while (iter.hasNext()) {
        FCCPFamilyDetailSO.RowPlanPrincipal prn = (FCCPFamilyDetailSO.RowPlanPrincipal) iter.next();
        Integer personId = prn.getIdPerson();
        // Principals in the state bean, but not in the request bean were
        // deselected, so DELETE them.
        if (!principalsFromRequestBeanHashmap.containsKey(personId)) {
          rowccmn01uig01 = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01();
          rowccmn01uig01.setUlIdPerson(personId);
          rowccmn01uig01.setTsLastUpdate(prn.getEventPersonLinkDateLastUpdate());
          rowccmn01uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_DELETE);
          rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
          numOfPrincipalsInList++;
        }
      } // end while ( iter.hasNext() )
    } // end if ( principalsForEventfromState != null )
    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);

    return rowccmn01uig00;
  }

  private FccpFamily populateFCCPFamily_Save(ROWCCMN01UIG00 rowccmn01uig00, FCCPFamilyDetailSO fccpFamilyDetailSO) {
    int idCase = fccpFamilyDetailSO.getCaseId();
    int idEvent = fccpFamilyDetailSO.getEventId();
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    Event event = getPersistentObject(Event.class, idEvent);
    String cdPlanType = fccpFamilyDetailSO.getSelCrtPlanType();
    
    //MR-068
    String nmAssgnJudge = fccpFamilyDetailSO.getNmAssgnJudge();
    String cdAssgnJudge = fccpFamilyDetailSO.getTxtAssnJudge();
    //MR-67675 Check to see if the text is one of the code in the CJUDGES table
    String codeExists = Lookup.simpleDecodeSafe(CodesTables.CJUDGES, cdAssgnJudge);
    //If not then do not set CD_ASSGN_JUDGE to that text rather keep it empty.
    if("".equals(codeExists)){
      cdAssgnJudge = null;
    }
    
    String indInitReview = fccpFamilyDetailSO.getRbDatesType();
    Date dtInitDueCal;
    if (DateHelper.isNull(fccpFamilyDetailSO.getDtInitDue())) {
      dtInitDueCal = DateHelper.addToDate(fccpFamilyDetailSO.getDtRemoval(), 0, 0, 30);
    } else {
      dtInitDueCal = fccpFamilyDetailSO.getDtInitDue();
    }
    Date dtInitDue = dtInitDueCal;
    Date dtOrigSub = fccpFamilyDetailSO.getDtOrigSub();
    Date dtPrevRev = fccpFamilyDetailSO.getDtPrevReview();
    Date dtCurrRev = fccpFamilyDetailSO.getDtCurReview();
    Date dtNextReview = fccpFamilyDetailSO.getDtNextReview();
    String cdPrimPermPlan = fccpFamilyDetailSO.getSelPPP();
    String txtPrimCompRsns = fccpFamilyDetailSO.getTxtPPPRsns();
    String cdSecndPermPlan = fccpFamilyDetailSO.getSelSPP();
    String txtSecndCompRsns = fccpFamilyDetailSO.getTxtSPPRsns();
    String cdRevTyp = fccpFamilyDetailSO.getSelRvwType();
    String txtRsnsProt = fccpFamilyDetailSO.getTxtRsnsChildNotHome();
    String txtHarm = fccpFamilyDetailSO.getTxtHarmChildLeftInHome();
    Date dtPermAchvd = fccpFamilyDetailSO.getDtProjPerm();
    String indPrntPrtcpt = fccpFamilyDetailSO.getRbParentPart();
    String txtPrntPrtcpt = fccpFamilyDetailSO.getTxtNoParentPart();
    String indChildPrtcpt = fccpFamilyDetailSO.getRbChildPart();
    String txtChildPrtcpt = fccpFamilyDetailSO.getTxtNoChildPart();
    String indPrntPresent = fccpFamilyDetailSO.getCbxParentRefuseSign();
    String indHearingSub = fccpFamilyDetailSO.getRbHearReqSub();
    Date dtHearingReqstd = fccpFamilyDetailSO.getDtHearReq();
    String indAsstnc = fccpFamilyDetailSO.getRbHearReqAsst();
    Date dtBeginAftercare = fccpFamilyDetailSO.getDtBeginAft();
    Date dtEndAftercare = fccpFamilyDetailSO.getDtEndAft();
    String txtRsnDschrgAftercare = fccpFamilyDetailSO.getTxtTsnDischg();
    String txtHearingRequestComment = fccpFamilyDetailSO.getTxtHearingRequestComments();
    String indUpdatePlan = fccpFamilyDetailSO.isUpdatedPlan() == true ? ArchitectureConstants.Y
                                                                     : ArchitectureConstants.N;

    return new FccpFamily(event, capsCase, cdPlanType, nmAssgnJudge, indInitReview, dtInitDue, dtOrigSub, dtPrevRev,
                          dtCurrRev, dtNextReview, cdPrimPermPlan, txtPrimCompRsns, cdSecndPermPlan, txtSecndCompRsns,
                          cdRevTyp, txtRsnsProt, txtHarm, dtPermAchvd, indPrntPrtcpt, txtPrntPrtcpt, indChildPrtcpt,
                          txtChildPrtcpt, indPrntPresent, indHearingSub, dtHearingReqstd, indAsstnc, dtBeginAftercare,
                          dtEndAftercare, txtRsnDschrgAftercare, txtHearingRequestComment, indUpdatePlan, cdAssgnJudge);
  }

  private void callCheckStageEventStatus(FCCPFamilyDetailSO fCCPFamilyDetailToSave) {
    String actionCode = ServiceConstants.REQ_FUNC_CD_ADD;
    int idEvent = fCCPFamilyDetailToSave.getEventId();
    int idStage = fCCPFamilyDetailToSave.getStageId();
    int idUser = fCCPFamilyDetailToSave.getUserId();
    String cdTask = fCCPFamilyDetailToSave.getCdTask();

    if (idEvent > 0) {
      actionCode = ServiceConstants.REQ_FUNC_CD_UPDATE;
    }
    CCMN06UI ccmn06ui = populateCCMN06UI_CheckStageEventStatus(idStage, idUser, cdTask, actionCode);
    checkStageEventStatus.status(ccmn06ui);
  }

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

  private int addDtNextReviewAlertTodo(int idEvent, int idCase, int idStage, int idUser, Date dtNextReview,
                                       String cdWkldStagePersRole, String nmStage) {
    Todo todo = new Todo();
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    int idPerson = workloadDAO.findIdWkldPersonByIdStageAndCdWkldStagePersRole(idStage, cdWkldStagePersRole);
    String cdTask = "";
    Date dateCreated = new Date();
    Date todoDueDate = DateHelper.addToDate(dtNextReview, 0, 0, -15);
    String todoDesc = "A Foster Care Case Plan Review is due in 15 days for " + nmStage;
    todo.setEvent(getPersistentObject(Event.class, idEvent));
    todo.setTxtTodoDesc(todoDesc);
    todo.setCdTodoTask(cdTask);
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setDtTodoDue(todoDueDate);
    todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idPerson));
    todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
    todo.setDtTodoCreated(dateCreated);
    todo.setCapsCase(capsCase);
    todo.setStage(getPersistentObject(Stage.class, idStage));
    todoDAO.saveTodo(todo);
    return todo.getIdTodo();
  }

  // STGAP00006699 build event text string
  private String buildEventTxt(FCCPFamilyDetailSO fCCPFamilyDetailToSave, String oldDesc) {
    String eventTxt = "";

    // build the list of caregivers
    String caregivers = " Caregiver[s]: ";
    List<RowPlanPrincipal> rowPlanPrincipalList = fCCPFamilyDetailToSave.getPrincipalsForEvent();
    if (rowPlanPrincipalList != null && rowPlanPrincipalList.size() > 0) {
      StringBuffer caregiversBuff = new StringBuffer();
      Iterator<RowPlanPrincipal> itrRowPlanPrincipal = rowPlanPrincipalList.iterator();
      while (itrRowPlanPrincipal.hasNext()) {
        RowPlanPrincipal principal = itrRowPlanPrincipal.next();
        if ("Y".equalsIgnoreCase(principal.getIsCaregiver())) {
          Person person = personDAO.findPersonByIdPerson(principal.getIdPerson());
          if (person != null) {
            caregiversBuff.append(person.getNmPersonFull());
            if (itrRowPlanPrincipal.hasNext()) {
              caregiversBuff.append("; ");
            }
          }
        }
      }
      caregivers += caregiversBuff.toString();
    }

    // build the up the Plan Type, Prem Plan and Concurrent Plan values
    StringBuffer planTypeBuff = new StringBuffer();
    planTypeBuff.append(fCCPFamilyDetailToSave.getSelCrtPlanType());
    if (fCCPFamilyDetailToSave.getSelPPP() != null && fCCPFamilyDetailToSave.getSelPPP().length() > 0) {
      planTypeBuff.append("-");
      planTypeBuff.append(Lookup.simpleDecodeSafe(CodesTables.CPERMEVT, fCCPFamilyDetailToSave.getSelPPP()));
    }
    if (fCCPFamilyDetailToSave.getSelSPP() != null && fCCPFamilyDetailToSave.getSelSPP().length() > 0) {
      planTypeBuff.append("-");
      planTypeBuff.append(Lookup.simpleDecodeSafe(CodesTables.CPERMEVT, fCCPFamilyDetailToSave.getSelSPP()));
    }
    planTypeBuff.append("; ");

    // new plan just create the new desc
    if (oldDesc == null) {
      if (fCCPFamilyDetailToSave.isUpdatedPlan()) {
        eventTxt = planTypeBuff.toString() + " updated for " + caregivers + " event "
                   + fCCPFamilyDetailToSave.getOldPlanId() + " updated "
                   + DateHelper.toCastorDate(new Date()).toString();
      } else {
        // New plan created from Add or Copy
        eventTxt = planTypeBuff.toString() + " created for " + caregivers;
      }
    } else {
      // existing plan check to use creatd or updates
      int lastIndeEvent = oldDesc.lastIndexOf("event");
      if (lastIndeEvent >= 0) {
        eventTxt = planTypeBuff.toString() + " updated for " + caregivers + " " + oldDesc.substring(lastIndeEvent);
      } else {
        eventTxt = planTypeBuff.toString() + " created for " + caregivers;
      }
    }

    int eventTxtLn = eventTxt.length();
    return eventTxt.substring(0, eventTxtLn > 100 ? 100 : eventTxtLn);
  }

  private boolean listIsValid(List aList) {
    return (aList != null && !aList.isEmpty());
  }

  public EventDAO getEventDAO() {
    return eventDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public FCCPFamilyDAO getFccpFamilyDAO() {
    return fccpFamilyDAO;
  }

  public void setFccpFamilyDAO(FCCPFamilyDAO fccpFamilyDAO) {
    this.fccpFamilyDAO = fccpFamilyDAO;
  }

  public PostEvent getPostEvent() {
    return postEvent;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public EventPersonLinkDAO getEventPersonLinkDAO() {
    return eventPersonLinkDAO;
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

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setWorkloadDAO(WorkloadDAO workloadDAO) {
    this.workloadDAO = workloadDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setLegalActionDAO(LegalActionDAO legalActionDAO) {
    this.legalActionDAO = legalActionDAO;
  }

  public void setRetrieveSpecializedUnitPersonnel(RetrieveSpecializedUnitPersonnel retrieveSpecializedUnitPersonnel) {
    this.retrieveSpecializedUnitPersonnel = retrieveSpecializedUnitPersonnel;
  }

  public void setComplexTodoDAO(ComplexTodoDAO complexTodoDAO) {
    this.complexTodoDAO = complexTodoDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

}
