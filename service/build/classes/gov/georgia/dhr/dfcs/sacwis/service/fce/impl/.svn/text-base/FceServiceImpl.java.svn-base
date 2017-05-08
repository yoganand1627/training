package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexFceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpSecClassLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceApplicationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceEligibilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceExpendituresDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceIncomeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FcePersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceReasonNotEligibleDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceReviewDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FceThirdPartyInsuranceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.InitialMedicaidAppDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceExpendituresDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceIncomeDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReasonNotEligibleDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReviewDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.ThirdPartyHealthInsuranceDB;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.FceAfdcIncomeLimit;
import gov.georgia.dhr.dfcs.sacwis.db.FceApplication;
import gov.georgia.dhr.dfcs.sacwis.db.FceEligibility;
import gov.georgia.dhr.dfcs.sacwis.db.FceExpenditures;
import gov.georgia.dhr.dfcs.sacwis.db.FceIncome;
import gov.georgia.dhr.dfcs.sacwis.db.FceIveIncomeLimit;
import gov.georgia.dhr.dfcs.sacwis.db.FcePerson;
import gov.georgia.dhr.dfcs.sacwis.db.FceReasonNotEligible;
import gov.georgia.dhr.dfcs.sacwis.db.FceReview;
import gov.georgia.dhr.dfcs.sacwis.db.FceThirdPartyInsurance;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.fce.FceService;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup_ARRAY;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FceServiceImpl extends BaseServiceImpl implements FceService {
  public static final int NBR_AGE_CHILD = 13;

  private FceApplicationDAO fceApplicationDAO = null;

  private FceEligibilityDAO fceEligibilityDAO = null;
  private FcePersonDAO fcePersonDAO = null;

  private ComplexFceDAO complexFceDAO = null;

  private FceReviewDAO fceReviewDAO = null;

  private FceIncomeDAO fceIncomeDAO = null;

  private FceExpendituresDAO fceExpendituresDAO = null;

  private FceThirdPartyInsuranceDAO fceThirdPartyInsuranceDAO = null;

  private FceReasonNotEligibleDAO fceReasonNotEligibleDAO = null;
  
  private TodoDAO todoDAO = null;
  
  private StageDAO stageDAO = null;
  
  private UnitDAO unitDAO = null;
  
  private PersonDAO personDAO = null;
  
  private UnitEmpLinkDAO unitEmpLinkDAO = null;
  
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  private EmpSecClassLinkDAO empSecClassLinkDAO = null;
  
  private InitialMedicaidAppDAO initialMedicaidAppDAO = null;

  public void setFceApplicationDAO(FceApplicationDAO fceApplicationDAO) {
    this.fceApplicationDAO = fceApplicationDAO;
  }

  public void setFceEligibilityDAO(FceEligibilityDAO fceEligibilityDAO) {
    this.fceEligibilityDAO = fceEligibilityDAO;
  }

  public void setFcePersonDAO(FcePersonDAO fcePersonDAO) {
    this.fcePersonDAO = fcePersonDAO;
  }

  public void setFceExpendituresDAO(FceExpendituresDAO fceExpendituresDAO) {
    this.fceExpendituresDAO = fceExpendituresDAO;
  }

  public void setFceIncomeDAO(FceIncomeDAO fceIncomeDAO) {
    this.fceIncomeDAO = fceIncomeDAO;
  }

  public void setFceReasonNotEligibleDAO(FceReasonNotEligibleDAO fceReasonNotEligibleDAO) {
    this.fceReasonNotEligibleDAO = fceReasonNotEligibleDAO;
  }

  public void setFceReviewDAO(FceReviewDAO fceReviewDAO) {
    this.fceReviewDAO = fceReviewDAO;
  }

  public void setFceThirdPartyInsuranceDAO(FceThirdPartyInsuranceDAO fceThirdPartyInsuranceDAO) {
    this.fceThirdPartyInsuranceDAO = fceThirdPartyInsuranceDAO;
  }

  public void setComplexFceDAO(ComplexFceDAO complexFceDAO) {
    this.complexFceDAO = complexFceDAO;
  }
  
  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }
  
  public void setEmpSecClassLinkDAO(EmpSecClassLinkDAO empSecClassLinkDAO) {
    this.empSecClassLinkDAO = empSecClassLinkDAO;
  }

  public void setInitialMedicaidAppDAO(InitialMedicaidAppDAO initialMedicaidAppDAO) {
    this.initialMedicaidAppDAO = initialMedicaidAppDAO;
  }

  public FceApplicationDB findApplicationByApplicationEvent(long idApplicationEvent) {
    FceApplication fceApplication = fceApplicationDAO.findFceApplicationByIdApplicationEvent(idApplicationEvent);
    if (fceApplication == null) {
      return null;
    }
    return PopulateFceUtility.populateFceApplicationDB(fceApplication);
  }

  // FIXME: BREAK THIS INTO IT'S OWN SERVICE - RetrieveFceEligibility
  public FceEligibilityDB retrieveFceEligibilityByIdFceEligibility(long idFceEligibility) throws ServiceException {
    FceEligibility fceEligibility = fceEligibilityDAO.findFceEligibilityByIdFceEligibility(idFceEligibility);
    if (fceEligibility == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return PopulateFceUtility.populateFceEligibilityDB(fceEligibility);
  }

  // FIXME: BREAK THIS INTO IT'S OWN SERVICE - saveInitialFceEligibility
  public int saveInitialFceEligibility(FceEligibilityDB fceEligibilityDB) {
    FceEligibility fceEligibility = new FceEligibility();
    CapsCase capsCase = getPersistentObject(CapsCase.class, (int) fceEligibilityDB.getIdCase());
    fceEligibility.setCapsCase(capsCase);
    Stage stage = getPersistentObject(Stage.class, (int) fceEligibilityDB.getIdStage());
    fceEligibility.setStage(stage);
    Person lastUpdatePerson = getPersistentObject(Person.class, (int) fceEligibilityDB.getIdLastUpdatePerson());
    fceEligibility.setPersonByIdLastUpdatePerson(lastUpdatePerson);
    fceEligibilityDAO.saveFceEligibility(fceEligibility);

    return fceEligibility.getIdFceEligibility();
  }

  public FceApplicationDB retrieveFceApplicationByIdFceApplication(long idFceApplication) throws ServiceException {
    FceApplication fceApplication = fceApplicationDAO.findFceApplicationByIdFceApplication(idFceApplication);
    if (fceApplication == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return PopulateFceUtility.populateFceApplicationDB(fceApplication);
  }
  
  
  /*
   * The following function updates the personCitizenship value in Fce_Eligibility table (non-Javadoc)
   * 
   * @see gov.georgia.dhr.dfcs.sacwis.service.fce.FceService#updateFceEligibilityCdPersonCitizenship(long,
   *      java.lang.String)
   */
  public void updateFceEligibilityCdPersonCitizenship(long idFceEligibility, String cdPersonCitizenship) {
    fceEligibilityDAO.updateFceEligibilityByCdPersonCitizenship(idFceEligibility, cdPersonCitizenship);
  }

  public void updateFceApplicationIndEvalConclusion(long idFceApplication, String indEvaluationConclusion) {

    fceApplicationDAO.updateFceApplicationByIndEvalConclusion(idFceApplication, indEvaluationConclusion);
  }

  // FIXME: BREAK THIS INTO IT'S OWN SERVICE - saveInitialFceApplication
  public int saveInitialFceApplication(FceApplicationDB fceApplicationDB) {
    FceApplication fceApplication = new FceApplication();
    CapsCase capsCase = getPersistentObject(CapsCase.class, (int) fceApplicationDB.getIdCase());
    fceApplication.setCapsCase(capsCase);
    Stage stage = getPersistentObject(Stage.class, (int) fceApplicationDB.getIdStage());
    fceApplication.setStage(stage);
    Person lastUpdatePerson = getPersistentObject(Person.class, (int) fceApplicationDB.getIdLastUpdatePerson());
    fceApplication.setPersonByIdLastUpdatePerson(lastUpdatePerson);
    Event event = getPersistentObject(Event.class, (int) fceApplicationDB.getIdEvent());
    fceApplication.setEvent(event);
    fceApplication.setCdApplication(fceApplicationDB.getCdApplication());
    FceEligibility fceEligibility = getPersistentObject(FceEligibility.class,
                                                        (int) fceApplicationDB.getIdFceEligibility());
    fceApplication.setFceEligibility(fceEligibility);
    Person person = getPersistentObject(Person.class, (int) fceApplicationDB.getIdPerson());
    fceApplication.setPersonByIdPerson(person);
    fceApplicationDAO.saveFceApplication(fceApplication);
    return fceApplication.getIdFceApplication();
  }

  // FIXME: BREAK THIS INTO IT'S OWN SERVICE - saveFceApplication
  public int saveFceApplication(FceApplicationDB fceApplicationDB) {
    FceApplication fceApplication = new FceApplication();
    if (fceApplicationDB.hasIdFceApplication()) {
      fceApplication = getPersistentObject(FceApplication.class, (int) fceApplicationDB.getIdFceApplication());
    }
    if (fceApplicationDB.hasIdCase()) {
      CapsCase capsCase = getPersistentObject(CapsCase.class, (int) fceApplicationDB.getIdCase());
      fceApplication.setCapsCase(capsCase);
    }
    if (fceApplicationDB.hasIdStage()) {
      Stage stage = getPersistentObject(Stage.class, (int) fceApplicationDB.getIdStage());
      fceApplication.setStage(stage);
    }
    if (fceApplicationDB.hasIdLastUpdatePerson()) {
      Person lastUpdatePerson = getPersistentObject(Person.class, (int) fceApplicationDB.getIdLastUpdatePerson());
      fceApplication.setPersonByIdLastUpdatePerson(lastUpdatePerson);
    }
    if (fceApplicationDB.hasIdEvent()) {
      Event event = getPersistentObject(Event.class, (int) fceApplicationDB.getIdEvent());
      fceApplication.setEvent(event);
    }
    if (fceApplicationDB.hasIdFceEligibility()) {
      FceEligibility fceEligibility = getPersistentObject(FceEligibility.class,
                                                          (int) fceApplicationDB.getIdFceEligibility());
      fceApplication.setFceEligibility(fceEligibility);
    }
    if (fceApplicationDB.hasIdPerson()) {
      Person person = getPersistentObject(Person.class, (int) fceApplicationDB.getIdPerson());
      fceApplication.setPersonByIdPerson(person);
    }
    if (fceApplicationDB.hasIdMngngCvsPerson()) {
      Person personByIdMngngCvsPerson = getPersistentObject(Person.class, (int) fceApplicationDB.getIdMngngCvsPerson());
      fceApplication.setPersonByIdMngngCvsPerson(personByIdMngngCvsPerson);
    }
    if (fceApplicationDB.hasIdOtherRelativePerson()) {
      Person personByIdOtherRelativePerson = getPersistentObject(Person.class,
                                                                 (int) fceApplicationDB.getIdOtherRelativePerson());
      fceApplication.setPersonByIdOtherRelativePerson(personByIdOtherRelativePerson);
    }
    fceApplication = PopulateFceUtility.populateFceApplication(fceApplicationDB, fceApplication);
    fceApplicationDAO.saveFceApplication(fceApplication);
    return fceApplication.getIdFceApplication();
  }

  public FcePersonDB retrieveFcePersonByIdFcePerson(long idFcePerson) throws ServiceException {
    FcePerson fcePerson = fcePersonDAO.findFcePersonByIdFceEPerson(idFcePerson);
    if (fcePerson == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return PopulateFceUtility.populateFcePersonDB(fcePerson);
  }

  public FcePersonDB retrieveFcePersonByIdPerson(long idPerson) throws ServiceException {
    FcePerson fcePerson = fcePersonDAO.findFcePersonByIdPerson(idPerson);
    if (fcePerson == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return PopulateFceUtility.populateFcePersonDB(fcePerson);
  }

  public int saveInitialFcePerson(long idFceEligibility, long idPerson, String cdRelInt) {
    return complexFceDAO.saveFcePersonByIdPersonIdFceEligAndCdRelInt(idFceEligibility, idPerson, cdRelInt);
  }

  // FIXME: BREAK THIS INTO IT'S OWN SERVICE - saveFceEligibility
  public int saveFceEligibility(FceEligibilityDB fceEligibilityDB) {
    FceEligibility fceEligibility = new FceEligibility();
    if (fceEligibilityDB.hasIdFceEligibility()) {
      fceEligibility = (FceEligibility) getPersistentObject(FceEligibility.class, (int) fceEligibilityDB.getIdFceEligibility());
    }
    if (fceEligibilityDB.hasIdCase()) {
      CapsCase capsCase = (CapsCase) getPersistentObject(CapsCase.class, (int) fceEligibilityDB.getIdCase());
      fceEligibility.setCapsCase(capsCase);
    }
    if (fceEligibilityDB.hasIdStage()) {
      Stage stage = (Stage) getPersistentObject(Stage.class, (int) fceEligibilityDB.getIdStage());
      fceEligibility.setStage(stage);
    }
    if (fceEligibilityDB.hasIdLastUpdatePerson()) {
      Person lastUpdatePerson = (Person) getPersistentObject(Person.class, (int) fceEligibilityDB.getIdLastUpdatePerson());
      fceEligibility.setPersonByIdLastUpdatePerson(lastUpdatePerson);
    }
    if (fceEligibilityDB.hasIdFcePerson()) {
      FcePerson fcePerson = (FcePerson) getPersistentObject(FcePerson.class, (int) fceEligibilityDB.getIdFcePerson());
      fceEligibility.setFcePerson(fcePerson);
    }
    if (fceEligibilityDB.hasIdPerson()) {
      Person person = (Person) getPersistentObject(Person.class, (int) fceEligibilityDB.getIdPerson());
      fceEligibility.setPersonByIdPerson(person);
    }
    if (fceEligibilityDB.hasIdPersonAllocMutual1()) {
      Person personAllocMutual1 = (Person) getPersistentObject(Person.class, (int) fceEligibilityDB.getIdPersonAllocMutual1());
      fceEligibility.setPersonAllocMutual1(personAllocMutual1);
    }
    if (fceEligibilityDB.hasIdPersonAllocMutual2()) {
      Person personAllocMutual2 = (Person) getPersistentObject(Person.class, (int) fceEligibilityDB.getIdPersonAllocMutual2());
      fceEligibility.setPersonAllocMutual2(personAllocMutual2);
    }
    if (fceEligibilityDB.hasIdPersonAllocSngl1()) {
      Person personAllocSngl1 = (Person) getPersistentObject(Person.class, (int) fceEligibilityDB.getIdPersonAllocSngl1());
      fceEligibility.setPersonAllocSngl1(personAllocSngl1);
    }
    if (fceEligibilityDB.hasIdPersonAllocSngl2()) {
      Person personAllocSngl2 = (Person) getPersistentObject(Person.class, (int) fceEligibilityDB.getIdPersonAllocSngl2());
      fceEligibility.setPersonAllocSngl2(personAllocSngl2);
    }
    if (fceEligibilityDB.hasIdPersonDeemIndiv1()) {
      Person personDeemIndiv1 = (Person) getPersistentObject(Person.class, (int) fceEligibilityDB.getIdPersonDeemIndiv1());
      fceEligibility.setPersonDeemIndiv1(personDeemIndiv1);
    }
    if (fceEligibilityDB.hasIdPersonDeemIndiv2()) {
      Person personDeemIndiv2 = (Person) getPersistentObject(Person.class, (int) fceEligibilityDB.getIdPersonDeemIndiv2());
      fceEligibility.setPersonDeemIndiv2(personDeemIndiv2);
    }
    if (fceEligibilityDB.hasIdEligibilityEvent()) {
      Event event = (Event) getPersistentObject(Event.class, (int) fceEligibilityDB.getIdEligibilityEvent());
      fceEligibility.setEvent(event);
    }
    if (fceEligibilityDB.hasIdFceReview()) {
      FceReview fceReview = (FceReview) getPersistentObject(FceReview.class, (int) fceEligibilityDB.getIdFceReview());
      fceEligibility.setFceReview(fceReview);
    }
    if (fceEligibilityDB.hasIdFceApplication()) {
      FceApplication fceApplication = (FceApplication) getPersistentObject(FceApplication.class,
                                                          (int) fceEligibilityDB.getIdFceApplication());
      fceEligibility.setFceApplication(fceApplication);
    }
    fceEligibility = PopulateFceUtility.populateFceEligibility(fceEligibilityDB, fceEligibility);
    fceEligibilityDAO.saveFceEligibility(fceEligibility);
    return fceEligibility.getIdFceEligibility();
  }

  public void updateInitialFceEligibility(FceEligibilityDB fceEligibilityDB) {
    FceEligibility fceEligibility = getPersistentObject(FceEligibility.class,
                                                        (int) fceEligibilityDB.getIdFceEligibility());
    FceApplication fceApplication = getPersistentObject(FceApplication.class,
                                                        (int) fceEligibilityDB.getIdFceApplication());
    fceEligibility.setFceApplication(fceApplication);
    Person person = getPersistentObject(Person.class, (int) fceEligibilityDB.getIdPerson());
    fceEligibility.setPersonByIdPerson(person);
    FcePerson fcePerson = getPersistentObject(FcePerson.class, (int) fceEligibilityDB.getIdFcePerson());
    fceEligibility.setFcePerson(fcePerson);

    String indEligible = toCharIndicator(fceEligibilityDB.getIndEligibleObject());
    fceEligibility.setIndEligible(indEligible);
    fceEligibilityDAO.saveFceEligibility(fceEligibility);
  }

  public void updateFceApplicationPersonAddress(FceApplicationDB fceApplicationDB) {
    FceApplication fceApplication = getPersistentObject(FceApplication.class,
                                                        (int) fceApplicationDB.getIdFceApplication());
    fceApplication.setAddrRemovalAddrZip(fceApplicationDB.getAddrRemovalAddrZip());
    fceApplication.setAddrRemovalCity(fceApplicationDB.getAddrRemovalCity());
    fceApplication.setAddrRemovalStLn1(fceApplicationDB.getAddrRemovalStLn1());
    fceApplication.setCdRemovalAddrCounty(fceApplicationDB.getCdRemovalAddrCounty());
    fceApplication.setCdRemovalAddrState(fceApplicationDB.getCdRemovalAddrState());
    fceApplication.setCdState(fceApplicationDB.getCdState());
    fceApplicationDAO.saveFceApplication(fceApplication);
  }

  public void updateFceApplicationCdApplication(FceApplicationDB fceApplicationDB) {
    FceApplication fceApplication = getPersistentObject(FceApplication.class,
                                                        (int) fceApplicationDB.getIdFceApplication());
    fceApplication.setCdApplication(fceApplicationDB.getCdApplication());
    fceApplicationDAO.saveFceApplication(fceApplication);
  }

  // FIXME: BREAK THIS INTO IT'S OWN SERVICE - saveInitialFceIncome
  public int saveInitialFceIncome(FceIncomeDB fceIncomeDB) {
    FceIncome fceIncome = new FceIncome();
    FceEligibility fceEligibility = getPersistentObject(FceEligibility.class, (int) fceIncomeDB.getIdFceEligibility());
    fceIncome.setFceEligibility(fceEligibility);
    Person person = getPersistentObject(Person.class, (int) fceIncomeDB.getIdPerson());
    fceIncome.setPerson(person);
    FcePerson fcePerson = getPersistentObject(FcePerson.class, (int) fceIncomeDB.getIdFcePerson());
    fceIncome.setFcePerson(fcePerson);
    String indChild = null;
    if (fceIncomeDB.getIndChild() == true) {
      indChild = ArchitectureConstants.Y;
    } else if (fceIncomeDB.getIndChild() == false) {
      indChild = ArchitectureConstants.N;
    }
    fceIncome.setIndChild(indChild);
    String indFamily = null;
    if (fceIncomeDB.getIndFamily() == true) {
      indFamily = ArchitectureConstants.Y;
    } else if (fceIncomeDB.getIndFamily() == false) {
      indFamily = ArchitectureConstants.N;
    }
    fceIncome.setIndFamily(indFamily);
    String indIncomeSource = null;
    if (fceIncomeDB.getIndIncomeSource() == true) {
      indIncomeSource = ArchitectureConstants.Y;
    } else if (fceIncomeDB.getIndIncomeSource() == false) {
      indIncomeSource = ArchitectureConstants.N;
    }
    fceIncome.setIndIncomeSource(indIncomeSource);
    String indResourceSource = null;
    if (fceIncomeDB.getIndResourceSource() == true) {
      indResourceSource = ArchitectureConstants.Y;
    } else if (fceIncomeDB.getIndResourceSource() == false) {
      indResourceSource = ArchitectureConstants.N;
    }
    fceIncome.setIdIncRsrc((int) fceIncomeDB.getIdIncRsrc());
    fceIncome.setIndResourceSource(indResourceSource);
    fceIncome.setCdType(fceIncomeDB.getCdType());
    fceIncome.setAmtIncome(fceIncomeDB.getAmtIncome());
    fceIncome.setTxtSource(fceIncomeDB.getTxtSource());
    if (fceIncomeDB.getIndNotAccessible() == true) {
      fceIncome.setIndNotAccessible(ArchitectureConstants.Y);
    } else if (fceIncomeDB.getIndNotAccessible() == false) {
      fceIncome.setIndNotAccessible(ArchitectureConstants.N);
    }
    fceIncomeDAO.saveFceIncome(fceIncome);
    return fceIncome.getIdFceIncome();
  }

  // FIXME: BREAK THIS INTO IT'S OWN SERVICE - saveFceIncome
  public int saveFceIncome(FceIncomeDB fceIncomeDB) {
    FceIncome fceIncome = new FceIncome();
    if (fceIncomeDB.hasIdFceIncome()) {
      fceIncome = fceIncomeDAO.findFceIncomeByIdFceIncome(fceIncomeDB.getIdFceIncome());
    }
    if (fceIncomeDB.hasIdFceEligibility()) {

      FceEligibility fceEligibility = getPersistentObject(FceEligibility.class,
                                                          (int) fceIncomeDB.getIdFceEligibility());
      fceIncome.setFceEligibility(fceEligibility);
    }
    if (fceIncomeDB.hasIdFcePerson()) {
      FcePerson fcePerson = getPersistentObject(FcePerson.class, (int) fceIncomeDB.getIdFcePerson());
      fceIncome.setFcePerson(fcePerson);
    }
    if (fceIncomeDB.hasIdIncRsrc()) {
      fceIncome.setIdIncRsrc(fceIncomeDB.getIdIncRsrc() == 0 ? null : (int) fceIncomeDB.getIdIncRsrc());
    }
    if (fceIncomeDB.hasIdPerson()) {
      Person person = getPersistentObject(Person.class, (int) fceIncomeDB.getIdPerson());
      fceIncome.setPerson(person);
    }
    fceIncome = PopulateFceUtility.populateFceIncome(fceIncomeDB, fceIncome);
    fceIncomeDAO.saveFceIncome(fceIncome);
    int idFceIncome = fceIncome.getIdFceIncome();
    return idFceIncome;
  }

  // FIXME: BREAK THIS INTO IT'S OWN SERVICE - saveFcePerson
  public int saveFcePerson(FcePersonDB fcePersonDB) {
    FcePerson fcePerson = null;
    //FcePerson fcePerson = new FcePerson();
    /*if (fcePersonDB.hasIdFcePerson()) {
      fcePerson = getPersistentObject(FcePerson.class, (int) fcePersonDB.getIdFcePerson());
    }*/
    fcePerson = fcePersonDAO.findFcePersonByIdFceEPerson(fcePersonDB.getIdFcePerson());
    if(fcePerson == null){
      fcePerson = new FcePerson();
    }
    if (fcePersonDB.hasIdFceEligibility()) {
      FceEligibility fceEligibility = getPersistentObject(FceEligibility.class,
                                                          (int) fcePersonDB.getIdFceEligibility());
      fcePerson.setFceEligibility(fceEligibility);
    }
    if (fcePersonDB.hasIdPerson()) {
      Person person = getPersistentObject(Person.class, (int) fcePersonDB.getIdPerson());
      fcePerson.setPerson(person);
    }
    fcePerson = PopulateFceUtility.populateFcePerson(fcePersonDB, fcePerson);
    fcePersonDAO.saveFcePerson(fcePerson);
    return fcePerson.getIdFcePerson();
  }

  public void updateFcePersonBirthday(FcePersonDB fcePersonDB) {
    FcePerson fcePerson = getPersistentObject(FcePerson.class, (int) fcePersonDB.getIdFcePerson());
    fcePerson.setDtBirth(fcePersonDB.getDtBirth());
    fcePerson.setNbrAge((int) fcePersonDB.getNbrAge());
    String indDobApprox = null;
    if (fcePersonDB.getIndDobApprox() == true) {
      indDobApprox = ArchitectureConstants.Y;
    } else if (fcePersonDB.getIndDobApprox() == false) {
      indDobApprox = ArchitectureConstants.N;
    }
    fcePerson.setIndDobApprox(indDobApprox);
    fcePersonDAO.saveFcePerson(fcePerson);
  }

  public FcePersonDB findFcePersonByIdFceEligibilityAndIdPerson(long idFceEligibility, long idPerson) {
    FcePerson fcePerson = fcePersonDAO.findFcePersonByIdFceEligibilityAndIdPerson(idFceEligibility, idPerson);
    if (fcePerson == null) {
      return null;
    }
    return PopulateFceUtility.populateFcePersonDB(fcePerson);
  }

  public void updateCdRelIntandLegalCustodian(long idFcePerson, String cdRelInt, boolean indLegalCustodian) {
    String isLegalCustodian = toCharIndicator(indLegalCustodian);
    fcePersonDAO.updateByCdRelIntandLegalCustodian(idFcePerson, cdRelInt, isLegalCustodian);
  }

  // FIXME: BREAK THIS INTO IT'S OWN SERVICE - saveFceThirdPartyHealthInsurance
  public int saveFceThirdPartyHealthInsurance(ThirdPartyHealthInsuranceDB thirdPartyHealthInsuranceDB) {
    FceThirdPartyInsurance fceThirdPartyInsurance = null;

    if (thirdPartyHealthInsuranceDB.hasIdFceApplication()) {
      fceThirdPartyInsurance = fceThirdPartyInsuranceDAO.findFceThirdPartyHealthInsuranceByIdFceApplication(thirdPartyHealthInsuranceDB.getIdFceApplication());
      if (fceThirdPartyInsurance == null) {
        fceThirdPartyInsurance = new FceThirdPartyInsurance();
        fceThirdPartyInsurance.setIdFceApplication((int) thirdPartyHealthInsuranceDB.getIdFceApplication());
      }
      FceApplication fceApplication = getPersistentObject(FceApplication.class, (int) thirdPartyHealthInsuranceDB.getIdFceApplication());
      fceThirdPartyInsurance.setFceApplication(fceApplication);
    }

    fceThirdPartyInsurance = PopulateFceUtility.populateThirdPartyHealthInsurance(thirdPartyHealthInsuranceDB, fceThirdPartyInsurance);
    fceThirdPartyInsuranceDAO.saveFceThirdPartyInsurance(fceThirdPartyInsurance);
    return fceThirdPartyInsurance.getIdFceApplication();
  }



  // FIXME: BREAK THIS INTO IT'S OWN SERVICE - saveFceExpenditures
  public int saveFceExpenditures(FceExpendituresDB fceExpendituresDB) {
    FceExpenditures fceExpenditures = new FceExpenditures();
    if (fceExpendituresDB.hasIdFceEligibility()) {
      FceEligibility fceEligibility = getPersistentObject(FceEligibility.class,
                                                          (int) fceExpendituresDB.getIdFceEligibility());
      fceExpenditures.setFceEligibility(fceEligibility);
    }
    if (fceExpendituresDB.hasIdFcePerson()) {
      FcePerson fcePerson = getPersistentObject(FcePerson.class, (int) fceExpendituresDB.getIdFcePerson());
      fceExpenditures.setFcePerson(fcePerson);
    }
    if (fceExpendituresDB.hasIdPerson()) {
      Person person = getPersistentObject(Person.class, (int) fceExpendituresDB.getIdPerson());
      fceExpenditures.setPerson(person);
    }
    if (fceExpendituresDB.hasIdPersonCareReceive()) {
      Person person = null;
      person = getPersistentObject(Person.class, (int) fceExpendituresDB.getIdPersonCareReceive());
      fceExpenditures.setPersonCareReceive(person);
    }
    fceExpenditures = PopulateFceUtility.populateFceExpenditures(fceExpendituresDB, fceExpenditures);
    fceExpendituresDAO.saveFceExpenditures(fceExpenditures);
    return fceExpenditures.getIdFceExpenditures();
  }

  public ThirdPartyHealthInsuranceDB findFceThirdPartyHealthInsuranceByIdFceApplication(long idFceApplication) {
    FceThirdPartyInsurance fceThirdPartyInsurance =
            fceThirdPartyInsuranceDAO.findFceThirdPartyHealthInsuranceByIdFceApplication(idFceApplication);
    if (fceThirdPartyInsurance == null) {
      return null;
    }
    return PopulateFceUtility.populateThirdPartyHealthInsuranceDB(fceThirdPartyInsurance);
  }

  public FceExpendituresDB retrieveFceExpendituresByIdFceExpenditures(long idFceExpenditures) throws ServiceException {
    FceExpenditures fceExpenditures = fceExpendituresDAO.findFceExpendituresByIdFceExpenditures(idFceExpenditures);
    if (fceExpenditures == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return PopulateFceUtility.populateFceExpendituresDB(fceExpenditures);
  }

  public FceExpendituresDB retrieveFceExpendituresByIdFceEligibilityByIdFcePersonByIdPerson(long idFceExpenditures,
                                                                                            long idFcePerson,
                                                                                            long idPerson) {
    FceExpendituresDB fceExpendituresDB = null;
    FceExpenditures fceExpenditures = fceExpendituresDAO.findFceExpendituresByIdFceEligibilityByIdFcePersonByIdPerson(
            idFceExpenditures, idFcePerson,
            idPerson);
    if (fceExpenditures == null) {
      return fceExpendituresDB;
    }
    return PopulateFceUtility.populateFceExpendituresDB(fceExpenditures);
  }

  // FIXME: BREAK THIS INTO IT'S OWN SERVICE - saveInitialFceExpenditures
  public int saveInitialFceExpenditures(FceExpendituresDB fceExpendituresDB) {
    FceExpenditures fceExpenditures = new FceExpenditures();
    Person person = getPersistentObject(Person.class, (int) fceExpendituresDB.getIdPerson());
    fceExpenditures.setPerson(person);
    FcePerson fcePerson = getPersistentObject(FcePerson.class, (int) fceExpendituresDB.getIdFcePerson());
    fceExpenditures.setFcePerson(fcePerson);
    FceEligibility fceEligibility = getPersistentObject(FceEligibility.class,
                                                        (int) fceExpendituresDB.getIdFceEligibility());
    fceExpenditures.setFceEligibility(fceEligibility);
    fceExpendituresDAO.saveFceExpenditures(fceExpenditures);

    return fceExpenditures.getIdFceExpenditures();
  }

  public void deleteFceExpenditures(long idFceEligibility) {
    fceExpendituresDAO.deleteFceExpenditures(idFceEligibility);
  }

  public void updateFcePerson(FcePersonDB fcePersonDB) {
    fcePersonDAO.updateFcePersonIndThirdPartyIns(fcePersonDB.getIdPerson(), "Y");
  }

  public FceEligibilityDB retrieveEligibilityForEligibilityEvent(long idEligibilityEvent) {
    FceEligibility fceEligibility = fceEligibilityDAO.findFceEligibilityByIdEligibilityEvent(idEligibilityEvent);
    if (fceEligibility == null) {
      return null;
    }
    return PopulateFceUtility.populateFceEligibilityDB(fceEligibility);
  }

  // FIXME: BREAK THIS INTO IT'S OWN SERVICE - saveFceReasonNotEligible
  public int saveFceReasonNotEligible(FceReasonNotEligibleDB fceReasonNotEligibleDB) {
    FceReasonNotEligible fceReasonNotEligible = new FceReasonNotEligible();
    FceEligibility fceEligibility = getPersistentObject(FceEligibility.class, (int) fceReasonNotEligibleDB.getIdFceEligibility());
    fceReasonNotEligible.setFceEligibility(fceEligibility);
    if (fceReasonNotEligibleDB.hasCdReasonNotEligible()) {
      fceReasonNotEligible.setCdReasonNotEligible(fceReasonNotEligibleDB.getCdReasonNotEligible());
    }
    fceReasonNotEligibleDAO.saveFceReasonNotEligible(fceReasonNotEligible);
    return fceReasonNotEligible.getIdFceReasonNotEligible();
  }
  
  // BREAK THIS INTO IT'S OWN SERVICE - retrieveAFDCIncomeLimit
  public Integer[] retrieveAFDCIncomeLimit(long nbrCertifiedGroup) {
    Integer amtAfdcImcomeLimit[] = new Integer[2];
    FceAfdcIncomeLimit fceAdfcIncomeLimit = fceIncomeDAO.findAFDCIncomeLimitByNbrCertifiedGroup(nbrCertifiedGroup);
    amtAfdcImcomeLimit[0]= fceAdfcIncomeLimit.getAmtGrossIncomeCeiling();
    amtAfdcImcomeLimit[1]= fceAdfcIncomeLimit.getAmtStandardOfNeed();
    return amtAfdcImcomeLimit;
  }
  
  public FceIncomeDB retrieveFceIncomeByIdFceIncome(long idFceIncome) throws ServiceException {
    FceIncome fceIncome = fceIncomeDAO.findFceIncomeByIdFceIncome(idFceIncome);
    if (fceIncome == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return PopulateFceUtility.populateFceIncomeDB(fceIncome);
  }
  
  // FIXME: BREAK THIS INTO IT'S OWN SERVICE - retrieveIVEIncomeLimit
  public Double[] retrieveIVEIncomeLimit(long nbrAge){
    Double amtIVEImcomeLimit[] = new Double[2];
    FceIveIncomeLimit fceIVEIncomeLimit = null;
    if(nbrAge <=13){
      fceIVEIncomeLimit = fceIncomeDAO.findIVEIncomeLimitByNbrAge(nbrAge);
    }else{
      fceIVEIncomeLimit = fceIncomeDAO.findIVEIncomeLimitByNbrAge(NBR_AGE_CHILD);
    }
    amtIVEImcomeLimit[0]= fceIVEIncomeLimit.getAmtGrossIncomeCeiling();
    amtIVEImcomeLimit[1]= fceIVEIncomeLimit.getAmtStandardOfNeed();
    return amtIVEImcomeLimit;
    
  }
  
  // FIXME: BREAK THIS INTO IT'S OWN SERVICE - SaveEligibilityAlert
  public void saveAlert(int idPerson, int idStage, int idCase ){
  //  Eligibility needs to be redetermined for <Stage Name> by <Current Date + 6 Months>. 
    Todo todo = new Todo();
    CapsCase capsCase;
    capsCase = getPersistentObject(CapsCase.class, idCase);
    Stage stage = getPersistentObject(Stage.class, idStage);
    String cdTask = "";
    Date todaysDate = new Date();
    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
    String todoDesc = "Eligibility needs to be redetermined for " + stage.getNmStage() 
                    + " by " + DateHelper.toString(DateHelper.addToDate(todaysDate, 0, 6, 0), DATE_FORMAT) + ".";
    Date dateCreated = new Date();
    todo.setDtTodoDue(null);
    todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idPerson));
    todo.setTxtTodoDesc(todoDesc);
    todo.setCdTodoTask(cdTask);
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idPerson));
    todo.setDtTodoCreated(dateCreated);
    todo.setCapsCase(capsCase);
    todo.setStage(stage);
    todoDAO.saveTodo(todo);
  }

  public int updateFceEligibilityIndChildSupportOrdered(long idFceEligibility, String indChildSupportOrdered) {
    return fceEligibilityDAO.updateFceEligibilityByIndChildSupportOrdered(idFceEligibility, indChildSupportOrdered);
  }

  public FceEligibilityDB retrieveEligibilityByIdFceApplication(long idFceApplication) {
    long idFceEligibility = fceEligibilityDAO.findFceEligibilityByIdFceApplication(idFceApplication);
    FceEligibility fceEligibility = fceEligibilityDAO.findFceEligibilityByIdFceEligibility(idFceEligibility);
    if (fceEligibility == null) {
      return null;
    }
    return PopulateFceUtility.populateFceEligibilityDB(fceEligibility);
  }

  public int updateFceEligibilityCdBlocChild(long idFceEligibility, String cdBlocChild) {
    return fceEligibilityDAO.updateFceEligibilityByCdBlocChild(idFceEligibility, cdBlocChild);
  }

  public int updateFceEligibilityCdBlocAmtSsi(long idFceEligibility, String cdBlocChild, double amtSsi) {
    return fceEligibilityDAO.updateFceEligibilityByCdBlocChild(idFceEligibility, cdBlocChild, amtSsi);
  }
  
  public String retrieveStageCountyByStageId(int idStage){
    Stage stage = stageDAO.findStageByIdStage(idStage);
    return stage.getCdStageCnty();
  }
  
  public long findPrimaryChildForStage (long idStage, String cdStagePersonRole){
    int idPerson = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole((int) idStage, cdStagePersonRole);
    return (long) idPerson;
  }
  
  public int retrieveIdUnitFromUnitByCdStageCntyAndCdSpecialization(String cdStageCounty){
    int idUnit = Integer.parseInt(unitDAO.findIdUnitFromUnitByCdStageCntyAndCdSpecialization(cdStageCounty).toString());
    return idUnit;
  }
  
  public String retrieveNmPersonFullByIdPerson(int idPerson){
    String nmPersonFull= personDAO.findNmFullByIdPerson(idPerson);
    return nmPersonFull;
  }
  
  // FIXME: BREAK THIS INTO IT'S OWN SERVICE - RetrieveAssignmentGroup
  @SuppressWarnings( { "unchecked" })
  public AssignmentGroup_ARRAY retrieveStageByIdStageAndOrderByCdStagePersRole(int idStage){
    AssignmentGroup_ARRAY assignmentGroupArray = new AssignmentGroup_ARRAY();
    List<Map> stageInfo = stageDAO.findStageByIdStageAndOrderByCdStagePersRole(idStage);
    if (stageInfo == null || stageInfo.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    for (Iterator<Map> it = stageInfo.iterator(); it.hasNext();) {
      Map stageMap = it.next();
      AssignmentGroup assignmentGroup = new AssignmentGroup();
      assignmentGroup.setSzNmStage((String) stageMap.get("nmStage"));
      assignmentGroup.setSzNmPersonFull((String) stageMap.get("nmPersonFull"));
      assignmentGroup.setSzCdStagePersRole((String) stageMap.get("cdStagePersRole"));
      assignmentGroup.setUlIdStage((Integer) stageMap.get("idStage") != null ? (Integer) stageMap.get("idStage") : 0);
      assignmentGroup.setUlIdPerson((Integer) stageMap.get("idPerson") != null ?
                                    (Integer) stageMap.get("idPerson") : 0);
      assignmentGroup.setUlIdStagePerson((Integer) stageMap.get("idStagePersonLink") != null ?
                                         (Integer) stageMap.get("idStagePersonLink") : 0);
      assignmentGroup.setUlIdCase((Integer) stageMap.get("idCase") != null ? (Integer) stageMap.get("idCase") : 0);
      assignmentGroup.setSzCdStage((String) stageMap.get("cdStage"));
      assignmentGroup.setSzCdStageProgram((String) stageMap.get("cdStageProgram"));
      assignmentGroup.setSzCdStageType((String) stageMap.get("cdStageType"));
      assignmentGroup.setSzCdStageCnty((String) stageMap.get("cdStageCnty"));
      assignmentGroup.setTsLastUpdate(((Date) stageMap.get("dtLastUpdate")));
      assignmentGroupArray.addAssignmentGroup(assignmentGroup);
    }
    return assignmentGroupArray;
  }
  
  public List<Integer> findIdPersonByIdStageAndCdStagePersRoleAsSE(int idStage){
    List<Integer> idPersonList = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRoleAsSE(idStage);
    return idPersonList;
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<Map> retrieveUnitEmpLinkByIdUnit(int idUnit){
    List<Map> personMap = unitEmpLinkDAO.findUnitEmpLinkByIdUnit(idUnit);
    return personMap;
  }
  
  public List<Map> retrieveEmpSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(int idPerson){
    List<Map> securityMap = empSecClassLinkDAO.findEmpSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(idPerson);
    return securityMap;
  }
   
  public FceReviewDB findReviewByReviewEvent(long idReviewEvent) {
    FceReview fceReview = fceReviewDAO.findFceReviewByIdReviewEvent(idReviewEvent);
    if (fceReview == null) {
      return null;
    }
    return PopulateFceUtility.populateFceReviewDB(fceReview);
  }
  
  // FIXME: BREAK THIS INTO IT'S OWN SERVICE - RetrieveFceReview
  public FceReviewDB retrieveFceReviewByIdFceReview(long idFceReview) {
    FceReview fceReview = fceReviewDAO.findFceReviewByIdFceReview(idFceReview);
    if (fceReview == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return PopulateFceUtility.populateFceReviewDB(fceReview);
  }
  
  // FIXME: BREAK THIS INTO IT'S OWN SERVICE - SaveInitialFceReview
  public int saveInitialFceReview(FceReviewDB fceReviewDB){
    FceReview fceReview = new FceReview();
    CapsCase capsCase = getPersistentObject(CapsCase.class, (int) fceReviewDB.getIdCase());
    fceReview.setCapsCase(capsCase);
    Event event1 = getPersistentObject(Event.class, (int) fceReviewDB.getIdCurrentPlacementEvent());
    fceReview.setEventByIdCurrentPlacementEvent(event1);
    Event event2 = getPersistentObject(Event.class, (int) fceReviewDB.getIdEvent());
    fceReview.setEventByIdEvent(event2);
    FceApplication fceApplication = getPersistentObject(FceApplication.class,
                                                          (int) fceReviewDB.getIdFceApplication());
    fceReview.setFceApplication(fceApplication);
    FceEligibility fceEligibility = getPersistentObject(FceEligibility.class,
                                                          (int) fceReviewDB.getIdFceEligibility());
    fceReview.setFceEligibility(fceEligibility);
    Person person = getPersistentObject(Person.class, (int) fceReviewDB.getIdLastUpdatePerson());
    fceReview.setPerson(person);
    Event event3 = getPersistentObject(Event.class, (int) fceReviewDB.getIdPlacementRateEvent());
    fceReview.setEventByIdPlacementRateEvent(event3);
    Stage stage = getPersistentObject(Stage.class, (int) fceReviewDB.getIdStage());
    fceReview.setStage(stage);
    fceReviewDAO.saveFceReview(fceReview);
    return fceReview.getIdFceReview();
  }
  
  // FIXME: BREAK THIS INTO IT'S OWN SERVICE - SaveFceReview
  public int saveFceReview(FceReviewDB fceReviewDB) {
    FceReview fceReview = new FceReview();
    if (fceReviewDB.hasIdCase()) {
      CapsCase capsCase = getPersistentObject(CapsCase.class, (int) fceReviewDB.getIdCase());
      fceReview.setCapsCase(capsCase);
    }
    if (fceReviewDB.hasIdCurrentPlacementEvent()) {
      Event event = getPersistentObject(Event.class, (int) fceReviewDB.getIdCurrentPlacementEvent());
      fceReview.setEventByIdCurrentPlacementEvent(event);
    }
    if (fceReviewDB.hasIdEvent()) {
      Event event = getPersistentObject(Event.class, (int) fceReviewDB.getIdEvent());
      fceReview.setEventByIdEvent(event);
    }
    if (fceReviewDB.hasIdFceApplication()) {
      FceApplication fceApplication = getPersistentObject(FceApplication.class,
                                                          (int) fceReviewDB.getIdFceApplication());
      fceReview.setFceApplication(fceApplication);
    }
    if (fceReviewDB.hasIdFceEligibility()) {
      FceEligibility fceEligibility = getPersistentObject(FceEligibility.class,
                                                          (int) fceReviewDB.getIdFceEligibility());
      fceReview.setFceEligibility(fceEligibility);
    }
    if (fceReviewDB.hasIdFceReview()) {
      fceReview = getPersistentObject(FceReview.class, (int) fceReviewDB.getIdFceReview());
    }
    if (fceReviewDB.hasIdLastUpdatePerson()) {
      Person person = getPersistentObject(Person.class, (int) fceReviewDB.getIdLastUpdatePerson());
      fceReview.setPerson(person);
    }
    if (fceReviewDB.hasIdPlacementRateEvent()) {
      Event event = getPersistentObject(Event.class, (int) fceReviewDB.getIdPlacementRateEvent());
      fceReview.setEventByIdPlacementRateEvent(event);
    }
    if (fceReviewDB.hasIdStage()) {
      Stage stage = getPersistentObject(Stage.class, (int) fceReviewDB.getIdStage());
      fceReview.setStage(stage);
    }
    fceReview = PopulateFceUtility.populateFceReview(fceReviewDB, fceReview);
    fceReviewDAO.saveFceReview(fceReview);
    return fceReview.getIdFceReview();
  }

  private static String toCharIndicator(Boolean value) {
    if (value == null) {
      return null;
    }
    if (value.booleanValue()) {
      return "Y";
    }
    return "N";
  }
  
  // FIXME: BREAK THIS INTO IT'S OWN SERVICE - RetrieveSuccessMedAssistance
  public Map retrieveSuccessMedAssistanceByCaseAndStage (long idCase, long idStage){
    String eventType = CodesTables.CEVNTTYP_IMA;
    Map medAssistance = initialMedicaidAppDAO.findSuccessMedAssistanceByCaseAndStage(idCase, idStage, eventType);
    return medAssistance;
  }

}

