package gov.georgia.dhr.dfcs.sacwis.service.document.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.DaoException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RiskAssessmentDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.common.EventValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.person.PersonValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanItemValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanTaskValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanValueBean;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.MailCode;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.db.RiskArea;
import gov.georgia.dhr.dfcs.sacwis.db.RiskAssessment;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.service.document.FamilyPlanFRM;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * This Form Service is used to populate the Family Plan Form. The Corresponding Html template is cfsd0500.
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  ----------  --------  --------------------------------------------------
 *  10/17/08    Cwells     After talking to SME changed the Court Mandated Closure field 
 *                         to only display the date in Date of Court Action field if its not 
 *                         null and the court mandated closure button is selected.  The Court 
 *                         Mandated field will continue to display Yes or No.  
 *              
 * 
 */

public class FamilyPlanFrmImpl extends BaseDocumentServiceImpl implements FamilyPlanFRM {

  private StageDAO stageDAO;

  private PersonDAO personDAO;

  private UnitDAO unitDAO;

  private EventDAO eventDAO;

  private EmployeeDAO employeeDAO;

  private StagePersonLinkDAO stagePersonLinkDAO;

  private RiskAssessmentDAO riskAssessmentDAO;

  private PersonPhoneDAO personPhoneDAO;

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setRiskAssessmentDAO(RiskAssessmentDAO riskAssessmentDAO) {
    this.riskAssessmentDAO = riskAssessmentDAO;
  }

  public CSVC08SO retrieveFamilyPlanFRM(CSVC08SI csvc08si) {
    CSVC08SO Csvc08so = new CSVC08SO();
    FamilyPlanValueBean searchBean = new FamilyPlanValueBean();
    FamilyPlanItemValueBean searchItemBean = new FamilyPlanItemValueBean();
    Collection<PersonValueBean> famEventBean = new ArrayList<PersonValueBean>();
    EventValueBean searchEventBean = new EventValueBean();

    // Get and set stage and event Ids from the input object
    int idStage = csvc08si.getUlIdStage();
    int idEvent = csvc08si.getUlIdEvent();

    // get the case name and event id
    Stage stage = stageDAO.findStageAndCapsCase(idStage);
    CapsCase capsCase = stage.getCapsCase();
    Event event = eventDAO.findEventByIdEvent(idEvent);
    int idCase = stage.getCapsCase().getIdCase();
    // The searchbeans for the FamilyPlanValueBean
    searchBean.setCaseId(idCase);
    searchBean.getFamilyPlanEvent().setEventId(idEvent);

    // call for the connection to the familyplanDAO
    FamilyPlanValueBean famPlanBean;
    try {
      famPlanBean = getFamPlanBean(searchBean);
    } catch (SQLException e) {
      // FIXME: Handle this exception properly.
      throw new RuntimeException(e);
    } catch (DaoException e) {
      throw new RuntimeException(e);
      // FIXME: Handle this exception properly.
    }
    if (famPlanBean == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }

    // Call to the FamilyPlanDAO to retrieve the risk evaluation data
    // FIXME: Never used!
    // FamilyPlanValueBean famPlanRiskBean = getFamPlanRiskBean(searchBean);

    // The search critiera for the FamilyPalnItemBean
    searchItemBean.setCaseId(stage.getCapsCase().getIdCase());
    searchItemBean.setFamilyPlanItemId(famPlanBean.getFamilyPlanId());
    searchItemBean.setStageId(idStage);

    // FIXME: Never used!
    // FamilyPlanItemValueBean famPlanItemBean = getFamPlanItemBean(searchItemBean);

    // The searchbeans for the EventValueBean
    searchEventBean.setEventId(idEvent);
    searchEventBean.setStageId(idStage);
    searchEventBean.setDateLastUpdate(event.getDtLastUpdate());

    // STGAP00010568: Information on the selected principals are found in this bean.
    try {
      famEventBean = getfameEventBean(searchEventBean);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    PreFillData preFillData = getFamilyPlanFields(capsCase, famPlanBean, idStage, idCase);
    getPrincipalNames(preFillData, idStage, famEventBean);
    getPlanGoals(capsCase, famPlanBean, preFillData, idStage);
    Csvc08so.setPreFillData(preFillData);
    return Csvc08so;
  }

  // Fill all the individual fields with data.
  private PreFillData getFamilyPlanFields(CapsCase capsCase, FamilyPlanValueBean famPlanBean, int idStage, int idCase) {

    PreFillData preFillData = new PreFillData();
    preFillData.addBookmark(createBookmark(COUNTNAME, Lookup.simpleDecodeSafe("CCOUNT", capsCase.getCdCaseCounty())));
    preFillData.addBookmark(createBookmark(DATE_RT_PREPARED,
                                           FormattingHelper.formatDate(famPlanBean.getDatePlanPrepared())));
    preFillData.addBookmark(createBookmark(DATE_PLAN_CMPLT,
                                           FormattingHelper.formatDate(famPlanBean.getDatePlanCompleted())));
    preFillData.addBookmark(createBookmark(CASENAME, capsCase.getNmCase()));
    preFillData.addBookmark(createBookmark(CASEID, idCase));
    preFillData.addBookmark(createBookmark(DATE_CURR_REV,
                                           FormattingHelper.formatDate(famPlanBean.getDateCurrentEvalCompleted())));
    preFillData.addBookmark(createBookmark(DATE_FAM_REVIEW,
                                           FormattingHelper.formatDate(famPlanBean.getFamilyPlanDateLastUpdate())));
    preFillData.addBookmark(createBookmark(DATE_REVIEW_NEXT,
                                           FormattingHelper.formatDate(famPlanBean.getDateNextEvalDue())));
    preFillData.addBookmark(createBookmark(FAMILY_STRENGHT_RESOURCES, famPlanBean.getStrengthsAndResources()));
    preFillData.addBookmark(createBookmark(OUTCOME, Lookup.simpleDecodeSafe(CodesTables.CFAMOUT,
                                                                            famPlanBean.getCdOutcome())));
    String isCourtMandated;
    boolean isCrtMandated = famPlanBean.getIndCourtOrdered();
    if (!isCrtMandated) {
      isCourtMandated = "No";
    } else {
      isCourtMandated = "Yes";
    }

    preFillData.addBookmark(createBookmark(COURT_MANDATED, isCourtMandated));
    preFillData.addBookmark(createBookmark(CPS_RSNS_INVOLV, famPlanBean.getReasonForCPSInvolvement()));
    preFillData.addBookmark(createBookmark(COVER_PARENT_NO_PART, famPlanBean.getExplanationOfClientNonParticipation()));

    // get the Case manager's id
    int idPerson = stagePersonLinkDAO.findIdPersonForCaseManagerByIdStage(idStage);
    Person person = personDAO.findPersonByIdPerson(idPerson);
    preFillData.addBookmark(createBookmark(CASE_MANAGER, person.getNmPersonFull()));
    Employee employee = employeeDAO.findEmployeeByIdPerson(idPerson);

    // get the DFCS office address
    MailCode mail = employee.getMailCode();
    preFillData.addBookmark(createBookmark(STR_LN_1, mail.getAddrMailCodeStLn1()));
    preFillData.addBookmark(createBookmark(STR_LN_2, mail.getAddrMailCodeStLn2()));
    preFillData.addBookmark(createBookmark(OFFICE_CITY, mail.getAddrMailCodeCity()));
    preFillData.addBookmark(createBookmark(OFFICE_STATE, "Georgia"));
    preFillData.addBookmark(createBookmark(OFFICE_ZIP, mail.getAddrMailCodeZip()));

    String personPhone = getPersonOfficePhone(idPerson);
    preFillData.addBookmark(createBookmark(PHONE, personPhone));

    // get case manager's unit in order to retrieve the Supervisor's name and number.
    Unit employeeunit = employee.getUnit();
    Integer idUnit = employeeunit.getIdUnit();
    Unit unit = unitDAO.findUnitByIdUnit(idUnit);
    Person supervisor = unit.getPerson();
    preFillData.addBookmark(createBookmark(SUPERVISOR, supervisor.getNmPersonFull()));
    String supervisorOfficePhone = getPersonOfficePhone(supervisor.getIdPerson());
    preFillData.addBookmark(createBookmark(SUPERVISOR_PHONE_NUMBER, supervisorOfficePhone));

    RiskAssessment riskAssessment = riskAssessmentDAO.findRiskAssessmentLatestByIdStage(idStage);
    if (riskAssessment != null) {
      preFillData.addBookmark(createBookmark(DATE_EVAL, FormattingHelper.formatDate(riskAssessment.getDtResponse())));
    }
    return preFillData;
  }

  // Retrieve the Family Plan items from the the FamilyPlanItemValueBean
  @SuppressWarnings("unchecked")
  private void getPlanGoals(CapsCase capsCase, FamilyPlanValueBean famPlanBean, PreFillData preFillData, int idStage) {
    List<FamilyPlanItemValueBean> allItemsList = (List<FamilyPlanItemValueBean>) famPlanBean.getFamilyPlanItemList();
    setAllItemsCurrRiskAssemt(famPlanBean, allItemsList);
    if (allItemsList != null && !allItemsList.isEmpty()) {
      for (Iterator<FamilyPlanItemValueBean> goalsIterator = allItemsList.iterator(); goalsIterator.hasNext();) {
        FamilyPlanItemValueBean goalItems = goalsIterator.next();
        FormDataGroup goalsGroup = createGoalsInfo(goalItems);
        getTasks(goalItems, goalsGroup);
        preFillData.addFormDataGroup(goalsGroup);
      }
      Collection<RiskArea> riskEvents = capsCase.getRiskAreas();
      int counter = 0;
      RiskAssessment riskAssessment = riskAssessmentDAO.findRiskAssessmentLatestByIdStage(idStage);
      if (riskAssessment != null) {
        if (riskAssessment.getIdEvent() != null) {
          if (riskEvents != null && !riskEvents.isEmpty()) {
            for (Iterator<RiskArea> riskIterator = riskEvents.iterator(); riskIterator.hasNext();) {
              FormDataGroup group = createFormDataGroup(TMPLAT_EVAL, CFSD0500);
              RiskArea riskAreaList = riskIterator.next();
              Event event = riskAreaList.getEvent();
              int idEvent = event.getIdEvent();
              if (riskAssessment.getIdEvent() == idEvent) {
                FamilyPlanItemValueBean items = allItemsList.get(counter);
                group.addBookmark(createBookmark(EVAL_AREA, items.getAreaOfConcernText()));
                group.addBookmark(createBookmark(EVAL_RESPONSE, riskAreaList.getTxtRiskAreaJustification()));
                preFillData.addFormDataGroup(group);
                counter++;
              }
            }
          }
        }
      }
    }
  }

  private List<FamilyPlanItemValueBean> setAllItemsCurrRiskAssemt(FamilyPlanValueBean famPlanBean,
                                                                  List<FamilyPlanItemValueBean> allItemsList) {
    int currentIdRiskAssmt = famPlanBean.getRiskAssessmentEventId();
    Event currentEventRiskAssmt = eventDAO.findEventByIdEvent(currentIdRiskAssmt);
    if (currentEventRiskAssmt != null) {
      Collection<RiskArea> riskAreas = currentEventRiskAssmt.getRiskAreas();
      int i = 0;
      if (riskAreas != null && !riskAreas.isEmpty()) {
        for (Iterator<RiskArea> riskIterator = riskAreas.iterator(); riskIterator.hasNext();) {
          RiskArea riskArea = riskIterator.next();
          String currentLevel = riskArea.getCdRiskAreaConcernScale();
          FamilyPlanItemValueBean item = allItemsList.get(i++);
          item.setCurrentLevelOfConcernScale(currentLevel);
          if (item.getCurrentLevelOfConcernScale() != null && item.getInitialLevelOfConcernScale() == null) {
            item.setInitialLevelOfConcernScale(currentLevel);
          }

        }

      }
    }
    return allItemsList;
  }

  private FormDataGroup createGoalsInfo(FamilyPlanItemValueBean items) {

    FormDataGroup group = createFormDataGroup(TMPLAT_GOALS_All, CFSD0500);
    group.addBookmark(createBookmark("GOALS_CONCERN_AREA", items.getAreaOfConcernText()));
    String goals = items.getGoals();
    if (goals == null) {
      group.addBookmark(createBookmark("GOALS", "Not Addressed"));
      // group.addBookmark(createBookmark(CNCRN_INITIAL_LEVEL, " "));
    } else {
      group.addBookmark(createBookmark("GOALS", goals));
    }

    if (items.getDateGoalsCompleted() == null) {
      group.addBookmark(createBookmark(GOAL_CMPLT_DATE, " N/A "));
    } else {
      group.addBookmark(createBookmark(GOAL_CMPLT_DATE, items.getDateGoalsCompleted()));
    }

    if (items.getInitialLevelOfConcernScale() == null) {
      group.addBookmark(createBookmark(CNCRN_INITIAL_LEVEL, "  "));
    } else {
      group.addBookmark(createBookmark(CNCRN_INITIAL_LEVEL,
                                       Lookup.simpleDecodeSafe("CRISKSOC", items.getInitialLevelOfConcernScale())));
    }
    if (items.getCurrentLevelOfConcernScale() == null) {
      group.addBookmark(createBookmark(CURR_LVL_CNCRN, "  "));
    }
    group.addBookmark(createBookmark(CURR_LVL_CNCRN, Lookup.simpleDecodeSafe("CRISKSOC",
                                                                             items.getCurrentLevelOfConcernScale())));
    return group;
  }

  private FormDataGroup getTasks(FamilyPlanItemValueBean items, FormDataGroup goalsGroup) {
    Collection<FamilyPlanTaskValueBean> stepList = items.getTasks();
    // send the individual task to the createTask fucntion
    if (stepList != null && !stepList.isEmpty()) {
      for (Iterator<FamilyPlanTaskValueBean> it = stepList.iterator(); it.hasNext();) {
        FamilyPlanTaskValueBean tasks = it.next();
        FormDataGroup stepsGroup = createTasks(tasks);
        goalsGroup.addFormDataGroup(stepsGroup);
      }
    }
    return goalsGroup;
  }

  private FormDataGroup createTasks(FamilyPlanTaskValueBean task) {

    FormDataGroup group = createFormDataGroup(TMPLAT_STEPS, CFSD0500);
    if (task.getTask() == null) {
      group.addBookmark(createBookmark(STEP, " "));
    } else {
      group.addBookmark(createBookmark(STEP, task.getTask()));
    }
    if (task.getProgress() == null) {
      group.addBookmark(createBookmark(PROGRESS, "N/A"));
    } else {
      group.addBookmark(createBookmark(PROGRESS, task.getProgress()));
    }
    group.addBookmark(createBookmark(DATE_TASK_CREATED, FormattingHelper.formatDate(task.getDateTaskCreated())));

    if (!task.isCourtOrderedTask()) {
      group.addBookmark(createBookmark(COURT, "No"));
    } else {
      group.addBookmark(createBookmark(COURT, "Yes"));
    }

    if (task.getDateTaskCompleted() == null) {
      group.addBookmark(createBookmark(DATE_TASK_COMPLETED, "   "));
    } else {
      group.addBookmark(createBookmark(DATE_TASK_COMPLETED, FormattingHelper.formatDate(task.getDateTaskCompleted())));
    }

    if (!task.isCourtMandatedClosure()) {
      group.addBookmark(createBookmark(COURT_CLSR, "    "));
    } else if (task.isCourtMandatedClosure() && task.getDateCourtAction() != null) {
      group.addBookmark(createBookmark(COURT_CLSR, FormattingHelper.formatDate(task.getDateCourtAction())));
    }
    return group;
  }

  // Individual names will be sent to the createPrcnplNames function to create the bookmarks
  private void getPrincipalNames(PreFillData preFillData, int idStage, Collection<PersonValueBean> famPlanBean) {
    StringBuffer caretakerNameBuffer = new StringBuffer();
    StringBuffer childNameBuffer = new StringBuffer();
    if (famPlanBean != null && !famPlanBean.isEmpty()) {

      Iterator iter = famPlanBean.iterator();
      while (iter.hasNext()) {
        PersonValueBean person = (PersonValueBean) iter.next();
        if (person.getDateOfBirth() != null) {
          int age = DateHelper.getAge(person.getDateOfBirth(), DateHelper.toJavaDate(DateHelper.getTodayCastorDate()));

          // STGAP00008206 Removed the check to see if age != 0 bc children under the age 1 are displayed as 0. And
          // A principal must have a age entered(DOB)
          if (age < 18) {
            childNameBuffer.append(person.getFirstName());
            childNameBuffer.append(" ");
            if (person.getMiddleName() != null) {
              childNameBuffer.append(person.getMiddleName());
              childNameBuffer.append(" ");
            }
            childNameBuffer.append(person.getLastName());
            if (iter.hasNext()) {
              childNameBuffer.append(" , ");
            }
          } else if (age > 17) {
            caretakerNameBuffer.append(person.getFirstName());
            caretakerNameBuffer.append(" ");
            if (person.getMiddleName() != null) {
              caretakerNameBuffer.append(person.getMiddleName());
              caretakerNameBuffer.append(" ");
            }
            caretakerNameBuffer.append(person.getLastName());
            if (iter.hasNext()) {
              caretakerNameBuffer.append(" , ");
            }
          }

        }
      }
    }
    preFillData.addBookmark(createBookmark(NAME_CHILD, childNameBuffer.toString()));
    preFillData.addBookmark(createBookmark(CARETAKER_FULL_NAME, caretakerNameBuffer.toString()));
  }

  private String getPersonOfficePhone(int idPerson) {
    String indPersonPhoneInValid = "N";
    String indPersonPhonePrimary = "Y";

    List<String> phoneTypes = new ArrayList<String>();
    phoneTypes.add(CodesTables.CPHNTYP_BC); // Business Cell
    phoneTypes.add(CodesTables.CPHNTYP_BP); // Business Pager
    phoneTypes.add(CodesTables.CPHNTYP_BS); // Business

    Date maxDate = DateHelper.toJavaDate(DateHelper.MAX_CASTOR_DATE);
    List<PersonPhone> personPhones = personPhoneDAO
                                                   .findPersonPhoneByIdPersonDtPersonPhoneCdPersonPhoneTypes(
                                                                                                             idPerson,
                                                                                                             maxDate,
                                                                                                             indPersonPhoneInValid,
                                                                                                             phoneTypes);
    StringBuffer phoneBuffer = new StringBuffer();
    for (Iterator<PersonPhone> it = personPhones.iterator(); it.hasNext();) {
      PersonPhone personPhone = it.next();
      if (indPersonPhonePrimary.equals(personPhone.getIndPersonPhonePrimary())) {
        if (personPhone.getNbrPersonPhone() != null) {
          String primPersonPhone = FormattingHelper.formatPhone(personPhone.getNbrPersonPhone());
          String primPersonExt = personPhone.getNbrPersonPhoneExtension();
          phoneBuffer.append(primPersonPhone);
          if (primPersonExt != null) {
            phoneBuffer.append(" Ext ");
            phoneBuffer.append(primPersonExt);
          }
          break;
        }
      } else {
        if (personPhone.getNbrPersonPhone() != null) {
          String primPersonPhone = FormattingHelper.formatPhone(personPhone.getNbrPersonPhone());
          String primPersonExt = personPhone.getNbrPersonPhoneExtension();
          phoneBuffer.append(primPersonPhone);
          if (primPersonExt != null) {
            phoneBuffer.append(" Ext ");
            phoneBuffer.append(primPersonExt);
          }
          break;
        }
      }
    }
    return phoneBuffer.toString();
  }

  // create a connection to the FamilyPlanDAO
  private FamilyPlanValueBean getFamPlanBean(FamilyPlanValueBean searchBean) throws SQLException, DaoException {
    @SuppressWarnings("unused")
    Connection connection = null;
    FamilyPlanValueBean famPlanInfo = null;
    try {
      connection = JdbcHelper.getConnection();
      FamilyPlanDAO familyPlanDAO = new FamilyPlanDAO(connection);
      famPlanInfo = familyPlanDAO.queryFamilyPlan(searchBean);
    } finally {
      if (connection != null) {
        connection.close();
      }
    }
    return famPlanInfo;

  }

  // FIXME: Never used!
  /*
   * private FamilyPlanItemValueBean getFamPlanItemBean(FamilyPlanItemValueBean searchItemBean) throws SQLException { //
   * create a connection to the FamilyPlanDAO to get the Family Plan Items data Connection connection = null;
   * FamilyPlanItemValueBean famPlanItem = null; try { connection = JdbcHelper.getConnection(); FamilyPlanDAO
   * familyPlanDAO = new FamilyPlanDAO(connection); famPlanItem = familyPlanDAO.queryFamilyPlanItem(searchItemBean); }
   * finally { if(connection != null) { connection.close(); } } return famPlanItem; }
   */

  // FIXME: Never used!
  private Collection<PersonValueBean> getfameEventBean(EventValueBean searchEventBean) throws SQLException {
    // Create connection to FamilyPlanDAO to get the principals in the event
    Connection connection = null;
    Collection<PersonValueBean> famEvents = null;
    try {
      connection = JdbcHelper.getConnection();
      FamilyPlanDAO familyPlanDAO = new FamilyPlanDAO(connection);
      famEvents = familyPlanDAO.queryPrincipalsForEvent(searchEventBean);
    } finally {
      if (connection != null) {
        connection.close();
      }
    }
    return famEvents;
  }

  // FIXME: Never used!
  /*
   * private FamilyPlanValueBean getFamPlanRiskBean(FamilyPlanValueBean searchBean) throws DaoException, SQLException { //
   * Create connection to FamilyPlanDAO to get the family plan evaluation items Connection connection = null;
   * FamilyPlanValueBean famPlanRiskArea = null; try { connection = JdbcHelper.getConnection(); FamilyPlanDAO
   * familyPlanDAO = new FamilyPlanDAO(connection); famPlanRiskArea =
   * familyPlanDAO.queryFamilyPlanEvaluations(searchBean); } finally { if(connection != null) { connection.close(); } }
   * return famPlanRiskArea; }
   */
}
