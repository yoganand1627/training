package gov.georgia.dhr.dfcs.sacwis.service.assessment.impl;

/**
 * This is the Service for retrieving the Safety Plan
 * 
 * 
 * <pre>
 *  Change History:
 *  Date        User           Description
 *  --------    --------       -------------------------------------------------------------------------------------
 *  10/02/2009  hjbaptiste     STGAP00015485: Calling new method findAllPrincipalsForStageInPKHshld() to retrieve the 
 *                             principals that are members of the primary caretaker's household
 *  
 **/

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpSafetyFactorsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.SpPersonsRespnsbl;
import gov.georgia.dhr.dfcs.sacwis.db.SpSafetyFactors;
import gov.georgia.dhr.dfcs.sacwis.db.SpSafetyPlan;
import gov.georgia.dhr.dfcs.sacwis.service.assessment.RetrieveSafetyPlan;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyPlanRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonResonsibleSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyFactorSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyPlanRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyPlanRetrieveSO.RowCasePersonResponsible;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RetrieveSafetyPlanImpl extends BaseServiceImpl implements RetrieveSafetyPlan {

  private SpSafetyFactorsDAO spSafetyFactorsDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private EventDAO eventDAO = null;

  public void setSpSafetyFactorsDAO(SpSafetyFactorsDAO spSafetyFactorsDAO) {
    this.spSafetyFactorsDAO = spSafetyFactorsDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public EventDAO getEventDAO() {
    return eventDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  @SuppressWarnings("unchecked")
  public SafetyPlanRetrieveSO retrieveSafetyPlan(SafetyPlanRetrieveSI safetyPlaneRetrieveSI) {

    SafetyPlanRetrieveSO safetyPlanRetrieveSO = new SafetyPlanRetrieveSO();
    int idEvent = safetyPlaneRetrieveSI.getUlIdEvent();
    // Person Responsible List
    // Retrieve all persons in this stage
    List<RowCasePersonResponsible> casePersonResponsibleList = new ArrayList<RowCasePersonResponsible>();
    List<Map> stagePrincipalList = stagePersonLinkDAO.findAllPrincipalsForStageInPKHshld(CodesTables.CPRSNTYP_PRN,
                                                                                safetyPlaneRetrieveSI.getUlIdStage());
    if (stagePrincipalList != null && !stagePrincipalList.isEmpty() && stagePrincipalList.size() != 0) {
      Iterator itr = stagePrincipalList.iterator();
      while (itr.hasNext()) {
        Map prn = (Map) (itr.next());
        Date dob = (Date) prn.get("DT_PERSON_BIRTH");
        Integer wrappedAge = (Integer) prn.get("NBR_PERSON_AGE");
        
        //-- start with age, but use dob if present
        int age = wrappedAge != null ? wrappedAge : 0;
        if(!DateHelper.isNull(dob)) {
          age = DateHelper.getAge(dob);
        }
        
        if (age >= 18) {
          RowCasePersonResponsible casePersonResponsible = safetyPlanRetrieveSO.new RowCasePersonResponsible();
          casePersonResponsible.setName((String) prn.get("NM_PERSON_FULL"));
          casePersonResponsible.setIdPerson((Integer) prn.get("ID_PERSON"));
          casePersonResponsibleList.add(casePersonResponsible);
        }
      }
    }

    safetyPlanRetrieveSO.setCasePersonResponsibleList(casePersonResponsibleList);

    if (idEvent == 0) {
      return safetyPlanRetrieveSO;
    } else {
      // retrieve event
      safetyPlanRetrieveSO.setRowccmn45do(processEventDAO(idEvent));

      SpSafetyPlan spSafetyPlan = null;
      List<SpSafetyFactors> spSafetyfactor = spSafetyFactorsDAO
                                                               .findSpSafetyFactors(safetyPlaneRetrieveSI
                                                                                                         .getUlIdEvent());
      Iterator spSafetyPlanIt = spSafetyfactor.iterator();
      ArrayList<SafetyFactorSO> safetyFactorList = new ArrayList();
      while (spSafetyPlanIt.hasNext()) {
        SpSafetyFactors spSafetyFactors = (SpSafetyFactors) spSafetyPlanIt.next();

        SafetyFactorSO safetyFactorSO = new SafetyFactorSO();

        safetyFactorSO.setDtCompltdBy(spSafetyFactors.getDtCompltdBy());
        safetyFactorSO.setDtLastUpdate(spSafetyFactors.getDtLastUpdate());
        safetyFactorSO.setIdSftyFctr(spSafetyFactors.getIdSftyFctr());
        safetyFactorSO.setNmFirstOthrResp(spSafetyFactors.getNmFirstOthrResp());
        safetyFactorSO.setNmLastOthrResp(spSafetyFactors.getNmLastOthrResp());
        safetyFactorSO.setNmMiddleOthrResp(spSafetyFactors.getNmMiddleOthrResp());
        safetyFactorSO.setSzTxtDescActions(spSafetyFactors.getTxtDescActions());
        safetyFactorSO.setSzTxtSftyFctrComments(spSafetyFactors.getTxtSftyFctrComments());
        safetyFactorSO.setSzTxtSftyFctrDesc(spSafetyFactors.getTxtSftyFctrDesc());
        safetyFactorSO.setSzTxtSftyFctrMitigate(spSafetyFactors.getTxtSftyFctrMitigate());

        ArrayList<PersonResonsibleSO> personResonsibleList = new ArrayList();
        List<SpPersonsRespnsbl> spPersonsRespnsblList = (List<SpPersonsRespnsbl>) spSafetyFactors
                                                                                                 .getSpPersonsRespnsblsForIdSftyFctr();
        Iterator spPersonsRespnsblIt = spPersonsRespnsblList.iterator();
        while (spPersonsRespnsblIt.hasNext()) {

          SpPersonsRespnsbl spPersonsRespnsbl = (SpPersonsRespnsbl) spPersonsRespnsblIt.next();

          PersonResonsibleSO personResonsibleSO = new PersonResonsibleSO();
          personResonsibleSO.setDtLastUpdate(spPersonsRespnsbl.getDtLastUpdate());
          personResonsibleSO.setIdPerson(spPersonsRespnsbl.getPersonByIdPerson().getIdPerson());
          personResonsibleSO.setIdSpPersRespnsbl(spPersonsRespnsbl.getIdSpPersRespnsbl());
          personResonsibleList.add(personResonsibleSO);
        }

        spSafetyPlan = spSafetyFactors.getSpSafetyPlan();

        safetyFactorSO.setPersonResonsibleList(personResonsibleList);
        safetyFactorList.add(safetyFactorSO);

      }

      if (spSafetyPlan != null) {
        safetyPlanRetrieveSO.setDtDiscWithCrtkr(spSafetyPlan.getDtDiscWithCrtkr());
        safetyPlanRetrieveSO.setDtLastUpdate(spSafetyPlan.getDtLastUpdate());
        safetyPlanRetrieveSO.setIndCrtkrAgreesSp(spSafetyPlan.getIndCrtkrAgreesSp());
      }

      safetyPlanRetrieveSO.setSafetyFactorList(safetyFactorList);
    }
    return safetyPlanRetrieveSO;
  }

  private ROWCCMN45DO processEventDAO(int idEvent) throws ServiceException {

    // Calling ccmn45d
    Event event = eventDAO.findEventByIdEvent(idEvent);
    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCCMN45DO rowccmn45do = new ROWCCMN45DO();
    rowccmn45do.setSzCdEventType(event.getCdEventType());
    rowccmn45do.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
    rowccmn45do.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
    rowccmn45do.setUlIdStage(event.getStage() != null ? event.getStage().getIdStage() : 0);
    rowccmn45do.setUlIdPerson(event.getPerson() != null ? event.getPerson().getIdPerson() : 0);
    rowccmn45do.setSzTxtEventDescr(event.getTxtEventDescr());
    rowccmn45do.setSzCdTask(event.getCdTask());
    rowccmn45do.setSzCdEventStatus(event.getCdEventStatus());
    rowccmn45do.setTsLastUpdate(event.getDtLastUpdate());
    return rowccmn45do;
  }

}
