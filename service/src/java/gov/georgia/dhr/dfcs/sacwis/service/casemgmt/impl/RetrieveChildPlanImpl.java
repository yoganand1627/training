//*  Service Class  Name:     RetrieveChildPlanImpl
//*  Created by:   Jacob Vaidyan
//*  Date Created: 1/8/2007
//*
//*  Description:Service Implementation for retrieving FCC Child Plan.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**
//**  

package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FccpChildDAO;
import gov.georgia.dhr.dfcs.sacwis.db.FccpChild;
import gov.georgia.dhr.dfcs.sacwis.db.FccpChildCbx;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveChildPlan;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ChildPlanDetailList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ChildPlanDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ChildPlanDetailRetrieveSO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RetrieveChildPlanImpl extends BaseServiceImpl implements RetrieveChildPlan {

  private FccpChildDAO fccpChildDAO = null;

  private EventDAO eventDAO = null;

  public void setFccpChildDAO(FccpChildDAO fccpChildDAO) {
    this.fccpChildDAO = fccpChildDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  @SuppressWarnings("unchecked")
  /**
   * retrieveChildPlan takes care of retrieving ChildPlan and associated check boxes
   * 
   * @param context
   *          The ChildPlanDetailRetrieveSI object.
   * 
   * Returns ChildPlanDetailRetrieveSO object.
   */
  public ChildPlanDetailRetrieveSO retrieveChildPlan(ChildPlanDetailRetrieveSI childplanRetrieveSI) {
    ChildPlanDetailRetrieveSO childplanRetrieveSO = new ChildPlanDetailRetrieveSO();
    int idEvent = childplanRetrieveSI.getUlIdEvent();
    List<FccpChild> childplanList = new ArrayList();
    childplanList = fccpChildDAO.findChildByIdEvent(idEvent);
    List<FccpChildCbx> childplancbx1List = new ArrayList();
    List<FccpChildCbx> childplancbx2List = new ArrayList();
    List<FccpChildCbx> childplancbx3List = new ArrayList();
    /* Add the logic for retrieving the check box and code type */
    String cdEventStatus = "";
    cdEventStatus = fccpChildDAO.findEventCdEventStatus(idEvent);
    childplancbx1List = fccpChildDAO.findchildcheckboxbyIdEventandCbxCodeType(idEvent, "CCPTASF1");
    childplancbx2List = fccpChildDAO.findchildcheckboxbyIdEventandCbxCodeType(idEvent, "CCPTASF2");
    childplancbx3List = fccpChildDAO.findchildcheckboxbyIdEventandCbxCodeType(idEvent, "CCPTNRUN");
    Iterator itAsfa = childplancbx1List.iterator();
    Iterator ParTerm = childplancbx2List.iterator();
    Iterator itNru = childplancbx3List.iterator();
    String[] asfaExistingConditions = new String[childplancbx1List.size()];
    String[] parentalRtsTerm = new String[childplancbx2List.size()];
    String[] nonReunificConditions = new String[childplancbx3List.size()];

    if (childplancbx1List != null && !childplancbx1List.isEmpty()) {

      for (int i = 0; itAsfa.hasNext(); i++) {
        FccpChildCbx cb1 = (FccpChildCbx) itAsfa.next();
        asfaExistingConditions[i] = (String) cb1.getCdCbx();
        childplanRetrieveSO.setDtCbxAsfaLastUpdate(cb1.getDtLastUpdate());
      }
    }

    if (childplancbx2List != null && !childplancbx2List.isEmpty()) {

      for (int i = 0; ParTerm.hasNext(); i++) {
        FccpChildCbx cb2 = (FccpChildCbx) ParTerm.next();
        parentalRtsTerm[i] = (String) (cb2.getCdCbx());
        childplanRetrieveSO.setDtCbxParLastUpdate(cb2.getDtLastUpdate());
      }
    }
    if (childplancbx3List != null && !childplancbx3List.isEmpty()) {

      for (int i = 0; itNru.hasNext(); i++) {
        FccpChildCbx cb3 = (FccpChildCbx) itNru.next();
        nonReunificConditions[i] = (String) (cb3.getCdCbx());
        childplanRetrieveSO.setDtCbxNruLastUpdate(cb3.getDtLastUpdate());
      }
    }

    List childplanrowList = new ArrayList();
    childplanRetrieveSO.setUlIdEvent(idEvent);
    if (childplanList != null && !childplanList.isEmpty()) {
      ChildPlanDetailList childplanRow = new ChildPlanDetailList();
      for (Iterator it = childplanList.iterator(); it.hasNext();) {
        FccpChild fccpchild = (FccpChild) it.next();
        childplanRow.setLdIndChildAdjInCare(fccpchild.getIndChildAdjCare());
        childplanRow.setLdDtCompDate(fccpchild.getDtDilgntComp());
        childplanRow.setDtLastUpdate(fccpchild.getDtLastUpdate());
        childplanRetrieveSO.setDtLastUpdate(fccpchild.getDtLastUpdate());
        childplanRow.setLdTxtSvcOffProvidedDesc(fccpchild.getTxtEffrtsRem());
        childplanRow.setLdTxtExpChildAdjInCare(fccpchild.getTxtChildAdjComm());
        childplanRow.setLdInddilSearchComp(fccpchild.getIndDilgntSrch());
        childplanRow.setLdTxtparentalRightsCmnts(fccpchild.getTxtAfsa());
        childplanRow.setLdIndFilePetition(fccpchild.getIndTpr());
        childplanRow.setLdDtfilePetitionDate(fccpchild.getDtTpr());
        childplanRow.setLdTxtfilePetitionCmnts(fccpchild.getTxtTpr());
        childplanRow.setLdTxtfinalPermPlacementSteps(fccpchild.getTxtSteps());
        childplanRow.setLdIndPermPlan(fccpchild.getIndPermPlan());
        childplanRow.setLdTxtadditionalInfo(fccpchild.getTxtAddtlInfo());
        childplanRow.setLdIndImmunization(fccpchild.getIndImmUtd());
        childplanRow.setLdTxtImmunizationCmnts(fccpchild.getTxtImmUtd());
        childplanRow.setLdIndImmunizationOnFile(fccpchild.getIndImmOnfile());
        childplanRow.setLdTxtImmunizationFileComments(fccpchild.getTxtImmOnfile());
        childplanRow.setLdIndMedPsychProblems(fccpchild.getIndOngoingProb());
        childplanRow.setLdTxtMedPsychProblemsCmnts(fccpchild.getTxtOngoingProb());
        childplanRow.setLdIndMedRecFile(fccpchild.getIndMedrecOnfile());
        childplanRow.setLdTxtMedRecFileCmnts(fccpchild.getTxtMedrecOnfile());
        childplanRow.setLdIndPsychRecFile(fccpchild.getIndPsychOnfile());
        childplanRow.setLdTxtPsychRecFileCmnts(fccpchild.getTxtPsychOnfile());
        //childplanRow.setLdIndMedPsychTrmnt(fccpchild.getIndPsychOnfile());
        childplanRow.setLdIndMedPsychTrmnt(fccpchild.getIndPsychTreat());
        childplanRow.setLdIndMedPsychDocRecord(fccpchild.getIndPsychDoc());
        childplanRow.setLdTxtMedPsychDocRecordCmnts(fccpchild.getTxtEvalDates());
        childplanRow.setLdTxtOtherMedPsychDocRecordCmnts(fccpchild.getTxtRelevantMed());

      }
      childplanRow.setasfaExistingConditions(asfaExistingConditions);
      childplanRow.setparentalRtsTerm(parentalRtsTerm);
      childplanRow.setnonReunificConditions(nonReunificConditions);
      childplanRetrieveSO.setcpdList(childplanRow);

      childplanrowList.add(childplanRow);

    }
    childplanRetrieveSO.setCdEventStatus(cdEventStatus);
    childplanRetrieveSO.setcpdBeanList(childplanrowList);
    return childplanRetrieveSO;
  }
}
