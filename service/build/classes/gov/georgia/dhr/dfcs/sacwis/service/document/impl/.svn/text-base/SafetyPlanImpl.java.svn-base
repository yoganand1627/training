package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelationshipDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpPersonsRespnsblDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpSafetyFactorsDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpSafetyPlanDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.Name;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.SpPersonsRespnsbl;
import gov.georgia.dhr.dfcs.sacwis.db.SpSafetyFactors;
import gov.georgia.dhr.dfcs.sacwis.db.SpSafetyPlan;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.service.document.SafetyPlan;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SAFETYPLANSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SAFETYPLANSO;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SafetyPlanImpl extends BaseDocumentServiceImpl implements SafetyPlan {

  private CapsCaseDAO capsCaseDAO;

  private NameDAO nameDAO;

  private StageDAO stageDAO;

  private UnitDAO unitDAO;

  private EmployeeDAO employeeDAO;

  private SpSafetyPlanDAO spSafetyPlanDAO;

  private SpSafetyFactorsDAO spSafetyFactorsDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  private PersonDAO personDAO;

  private SpPersonsRespnsblDAO spPersonsRespnsblDAO;
  
  private RelationshipDAO relationshipDAO; 
  
  private int max;

  public void setSpPersonsRespnsblDAO(SpPersonsRespnsblDAO spPersonsRespnsblDAO) {
    this.spPersonsRespnsblDAO = spPersonsRespnsblDAO;
  }

  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setRelationshipDAO(RelationshipDAO relationshipDAO) {
	    this.relationshipDAO = relationshipDAO;
	  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }

  public void setSpSafetyPlanDAO(SpSafetyPlanDAO spSafetyPlanDAO) {
    this.spSafetyPlanDAO = spSafetyPlanDAO;
  }

  public void setSpSafetyFactorsDAO(SpSafetyFactorsDAO spSafetyFactorsDAO) {
    this.spSafetyFactorsDAO = spSafetyFactorsDAO;
  }

  public SAFETYPLANSO retrieveSafetyPlan(SAFETYPLANSI safetyPlansi) {
    SAFETYPLANSO safetyPlanso = new SAFETYPLANSO();

    int idStage = safetyPlansi.getUlIdStage();

    int idEvent = safetyPlansi.getUlIdEvent();

    String managerId = safetyPlansi.getCreatedBy();

    Stage stage = stageDAO.findStageByIdStage(idStage);

    // get case id with stage id from stage table
    int idCase = stage.getCapsCase().getIdCase();

    // get case name with case id from case table
    String caseName = capsCaseDAO.findNmCaseByIdCase(idCase);

    if (caseName == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }

    PreFillData preFillData = getSafetyPlanHeadings(idCase, caseName);

    createSafetyFactor(idEvent, preFillData);
    createCareTakerInformation(idEvent, preFillData, idStage, managerId);
    safetyPlanso.setPreFillData(preFillData);
    return safetyPlanso;

  }

  /*
   * Gets the Headings consisting of case id and case name
   */
  private PreFillData getSafetyPlanHeadings(int idCase, String caseName) {
    PreFillData preFillData = new PreFillData();

    preFillData.addBookmark(createBookmark(TITLE_CASE_NAME, caseName));
    preFillData.addBookmark(createBookmark(TITLE_CASE_NUMBER, idCase));

    return preFillData;
  }

  /*
   * This is used to cycle through the SafetyFactors
   */
  private void createSafetyFactor(int idEvent, PreFillData preFillData) {
    List<SpSafetyFactors> spSafetyFactors = spSafetyFactorsDAO.findSpSafetyFactors(idEvent);

    if (spSafetyFactors != null && !spSafetyFactors.isEmpty()) {
      for (Iterator<SpSafetyFactors> it = spSafetyFactors.iterator(); it.hasNext();) {
        SpSafetyFactors map = it.next();
        preFillData.addFormDataGroup(displayFactors(map));
      }
    }
  }

  private FormDataGroup displayFactors(SpSafetyFactors map) {
    FormDataGroup group = createFormDataGroup(TMPLAT_SAFTEY_FACTOR, FAS03O00);

    // If statement checks to see if there is a Person Responsible entry
    // added by textfield instead of checkbox
    if (map.getNmFirstOthrResp() != null) {
      group.addFormDataGroup(getOtherRespbl(map, group));
    }

    group.addBookmark(createBookmark(TXT_SAFETY_FACTOR, map.getTxtSftyFctrDesc()));
    group.addBookmark(createBookmark(TXT_CHANGE_TO_MITIGATE, map.getTxtSftyFctrMitigate()));
    int idSafetyFactor = map.getIdSftyFctr();
    getPeopleResponsible(group, idSafetyFactor);

    group.addBookmark(createBookmark(DT_COMPLETED, FormattingHelper.formatDate(map.getDtCompltdBy())));
    group.addBookmark(createBookmark(TXT_DESC_OF_ACTIONS, map.getTxtDescActions()));
    group.addBookmark(createBookmark(TXT_COMMENTS, map.getTxtSftyFctrComments()));
    return group;
  }

  /*
   * This is used to get the Care Takers information
   * 
   */

  private PreFillData createCareTakerInformation(int idEvent, PreFillData preFillData, int idStage, String managerId) {
    SpSafetyPlan spSafetyPlan = spSafetyPlanDAO.findSpSafetyPlan(idEvent);
    // gets the Case Managers id
    Integer idPerson = stagePersonLinkDAO.findIdPersonForCaseManagerByIdStage(idStage);
    Employee employee = null;
    Name caseManagerName = null;
    
    
if(idPerson!= null){
    // gets the Case Managers Name and Employee Name given the personID
    caseManagerName = nameDAO.findNameByPersonPrimary(idPerson.intValue());
    employee = employeeDAO.findEmployeeByIdPerson(idPerson.intValue());
}
   Unit employeeunit = null;
    if(employee != null){
    employeeunit = employee.getUnit();
    }
    Person person = null;
   if(employeeunit != null){
     person = employeeunit.getPerson();
   }
   if(spSafetyPlan != null){
    preFillData.addBookmark(createBookmark(DT_DISCUSSED, FormattingHelper.formatDate(spSafetyPlan.getDtDiscWithCrtkr())));
   }
    if("N".equals(spSafetyPlan.getIndCrtkrAgreesSp())){
    preFillData.addBookmark(createBookmark(ND_CRTKR_AGREES, "No"));
    }
    
    if("Y".equals(spSafetyPlan.getIndCrtkrAgreesSp())){
        preFillData.addBookmark(createBookmark(ND_CRTKR_AGREES, "Yes"));
        }

    // Signature list
    if(caseManagerName != null){
    preFillData.addBookmark(createBookmark(NM_NAME_LAST4, caseManagerName.getNmNameLast()));
    preFillData.addBookmark(createBookmark(NM_NAME_FIRST4, caseManagerName.getNmNameFirst()));
    preFillData.addBookmark(createBookmark(NM_NAME_MIDDLE4, caseManagerName.getNmNameMiddle()));
    }
    if(person != null){
    preFillData.addBookmark(createBookmark(NM_NAME_LAST5, person.getNmPersonLast()));
    preFillData.addBookmark(createBookmark(NM_NAME_FIRST5, person.getNmPersonFirst()));
    preFillData.addBookmark(createBookmark(NM_NAME_MIDDLE5, person.getNmPersonMiddle()));
    }
    createParentsList(preFillData, idStage);

    return preFillData;
  }

  /*
   * Creates the Parent/ Guardian Signature list
   */
  private PreFillData createParentsList(PreFillData preFillData, int idStage) {
    List<Map> StagePersonLink = stagePersonLinkDAO.findAllPrincipalsForStage("PRN", idStage);
     max = 0;
    if (StagePersonLink != null && !StagePersonLink.isEmpty()) {

      // Only will allow 2 signatures for Parent guardian
      for (Iterator<Map> it = StagePersonLink.iterator(); it.hasNext() && max < 3;) {
        Map map = it.next();
        
        if("PK".equals(map.get("CD_REL_INT"))){
          max++;
          
          if (max < 2) {
            // only displays first parent/gaurdian signature if this
            // is the first parent
            preFillData.addFormDataGroup(displayFirstParent(map));
          } 
          else {
            // only displays second parent/gaurdian signature if
            // this is the second parent
            preFillData.addFormDataGroup(displaySecondParent(map));
          }   
        }   
      }
  }
    findOtherGaurdians(max, idStage, preFillData);
    return preFillData;
}

private void findOtherGaurdians(int max, int idStage, PreFillData preFillData){
	 List<StagePersonLink> StagePersonLink = stagePersonLinkDAO.findAllPrincipalsLinkedToStage(idStage, "PRN");
	for (Iterator<StagePersonLink> it = StagePersonLink.iterator(); it.hasNext() && max < 3;) {
        StagePersonLink stagePersonLink = it.next();          
        if("VC".equals(stagePersonLink.getCdStagePersRole()) || "DV".equals(stagePersonLink.getCdStagePersRole())){
            displayOtherGaurd(stagePersonLink, preFillData);
            break; 
      }
    } 

}

private void displayOtherGaurd(StagePersonLink victim, PreFillData preFillData){
	
    int idPerson = victim.getPerson().getIdPerson().intValue();
    Integer secondaryCaretakerId = relationshipDAO.findRelationshipIdRelatedPersonByIdPerson(idPerson, "SC");
    if (secondaryCaretakerId != null && max < 3){
      max++;
      Person otherGuardian = personDAO.findPersonByIdPerson(secondaryCaretakerId);
      if (max < 2) {
        // only displays first parent/gaurdian signature if this
        // is the first parent
        preFillData.addFormDataGroup(displayFirstParent(otherGuardian));
      } 
      else if (max < 3){
        // only displays second parent/gaurdian signature if
        // this is the second parent
        preFillData.addFormDataGroup(displaySecondParent(otherGuardian));
      }
    }	
    Integer legalFatherId = relationshipDAO.findRelationshipIdRelatedPersonByIdPerson(idPerson, "LF");
    if (legalFatherId != null){
        max++;
        Person legalFater = personDAO.findPersonByIdPerson(legalFatherId);
        if (max < 2) {
          // only displays first parent/gaurdian signature if this
          // is the first parent
          preFillData.addFormDataGroup(displayFirstParent(legalFater));
        } 
        else if (max <3){
          // only displays second parent/gaurdian signature if
          // this is the second parent
          preFillData.addFormDataGroup(displaySecondParent(legalFater));
        }
      }	
    
    Integer bioFatherId = relationshipDAO.findRelationshipIdRelatedPersonByIdPerson(idPerson, "BF");
    if (bioFatherId != null){
        max++;
        Person bioFather = personDAO.findPersonByIdPerson(bioFatherId);
        if (max < 2) {
          // only displays first parent/gaurdian signature if this
          // is the first parent
          preFillData.addFormDataGroup(displayFirstParent(bioFather));
        } 
        else if(max < 3) {
          // only displays second parent/gaurdian signature if
          // this is the second parent
          preFillData.addFormDataGroup(displaySecondParent(bioFather));
        }
      }

    Integer putativeId = relationshipDAO.findRelationshipIdRelatedPersonByIdPerson(idPerson, "PF");
    if (putativeId != null){
        max++;
        Person putative = personDAO.findPersonByIdPerson(putativeId);
        if (max < 2) {
          // only displays first parent/gaurdian signature if this
          // is the first parent
          preFillData.addFormDataGroup(displayFirstParent(putative));
        } 
        else if(max < 3){
          // only displays second parent/gaurdian signature if
          // this is the second parent
          preFillData.addFormDataGroup(displaySecondParent(putative));
        }
      }

}

  private FormDataGroup displayFirstParent(Person person) {
	    FormDataGroup group = createFormDataGroup(TMPLAT_FIRST_PERSON, FAS03O00);
	    group.addBookmark(createBookmark(NM_NAME_LAST2, person.getNmPersonLast()));
	    group.addBookmark(createBookmark(NM_NAME_FIRST2, person.getNmPersonFirst()));
	    group.addBookmark(createBookmark(NM_NAME_MIDDLE2, person.getNmPersonMiddle()));

	    return group;
	  }
  
  private FormDataGroup displayFirstParent(Map map) {
    FormDataGroup group = createFormDataGroup(TMPLAT_FIRST_PERSON, FAS03O00);
    String idPersonString = map.get("ID_PERSON").toString();
    int idPerson = Integer.parseInt(idPersonString);
    Person person = personDAO.findPersonByIdPerson(idPerson);
    group.addBookmark(createBookmark(NM_NAME_LAST2, person.getNmPersonLast()));
    group.addBookmark(createBookmark(NM_NAME_FIRST2, person.getNmPersonFirst()));
    group.addBookmark(createBookmark(NM_NAME_MIDDLE2, person.getNmPersonMiddle()));

    return group;
  }

  /*
   * Used to get the list of people responsible
   * 
   */
  private void getPeopleResponsible(FormDataGroup group, int idSafetyFactor) {

    List<SpPersonsRespnsbl> spPersonsRespnsbl = spPersonsRespnsblDAO.findSpPersonsRespnsbl(idSafetyFactor);

    if (spPersonsRespnsbl != null && !spPersonsRespnsbl.isEmpty()) {
      for (Iterator<SpPersonsRespnsbl> it = spPersonsRespnsbl.iterator(); it.hasNext();) {
        SpPersonsRespnsbl map = it.next();
        group.addFormDataGroup(createResponsibleList(map));
      }
    }
  }

  /* Displays the second Parent/Guardian signature list */
  private FormDataGroup displaySecondParent(Map map) {
    FormDataGroup group = createFormDataGroup(TMPLAT_SECOND_PERSON, FAS03O00);
    String idPersonString = map.get("ID_PERSON").toString();
    int idPerson = Integer.parseInt(idPersonString);
    Person person = personDAO.findPersonByIdPerson(idPerson);

    group.addBookmark(createBookmark(NM_NAME_LAST3, person.getNmPersonLast()));
    group.addBookmark(createBookmark(NM_NAME_FIRST3, person.getNmPersonFirst()));
    group.addBookmark(createBookmark(NM_NAME_MIDDLE3, person.getNmPersonMiddle()));

    return group;
  }
  private FormDataGroup displaySecondParent(Person person) {
	    FormDataGroup group = createFormDataGroup(TMPLAT_SECOND_PERSON, FAS03O00);
	    group.addBookmark(createBookmark(NM_NAME_LAST3, person.getNmPersonLast()));
	    group.addBookmark(createBookmark(NM_NAME_FIRST3, person.getNmPersonFirst()));
	    group.addBookmark(createBookmark(NM_NAME_MIDDLE3, person.getNmPersonMiddle()));

	    return group;
	  }

  /* Used to get the list of Responsible people */
  private FormDataGroup createResponsibleList(SpPersonsRespnsbl map) {

    FormDataGroup responsibleGroup = createFormDataGroup(TMPLAT_PERSON_RESPONSIBLE, FAS03O00);
    responsibleGroup.addBookmark(createBookmark(NM_OTHER_LAST, map.getPersonByIdPerson().getNmPersonLast()));
    responsibleGroup.addBookmark(createBookmark(NM_OTHER_FIRST, map.getPersonByIdPerson().getNmPersonFirst()));
    responsibleGroup.addBookmark(createBookmark(NM_OTHER_MIDDLE, map.getPersonByIdPerson().getNmPersonMiddle()));

    return responsibleGroup;
  }

  /*Used to get the names of the other Responsible people */
  private FormDataGroup getOtherRespbl(SpSafetyFactors map, FormDataGroup group) {

    FormDataGroup responsibleGroup = createFormDataGroup(TMPLAT_PERSON_RESPONSIBLE, FAS03O00);
    responsibleGroup.addBookmark(createBookmark(NM_OTHER_LAST, map.getNmLastOthrResp()));
    responsibleGroup.addBookmark(createBookmark(NM_OTHER_FIRST, map.getNmFirstOthrResp()));
    responsibleGroup.addBookmark(createBookmark(NM_OTHER_MIDDLE, map.getNmMiddleOthrResp()));

    return responsibleGroup;
  }

}
