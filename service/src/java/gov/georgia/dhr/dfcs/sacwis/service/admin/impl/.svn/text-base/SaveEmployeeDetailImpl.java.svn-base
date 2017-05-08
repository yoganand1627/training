package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexEmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPersonCategoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpJobHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpOnCallLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpSecClassLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpTempAssignDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonCategoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEthnicityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonRaceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.EmpJobHistory;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.Office;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonCategory;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEthnicity;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.db.UnitEmpLink;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveEmployeeDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG02;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG04;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG05;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG06;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG08_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN05SIG09_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN05SO;

import java.util.Date;
import java.util.Enumeration;

public class SaveEmployeeDetailImpl extends BaseServiceImpl implements SaveEmployeeDetail {

  public static final int MEMBERS_50 = 50;

  public static final String CASE_NM_ET_AL = " et al";

  public static final int NM_MAX_LENGTH = 19;
  
  private CapsCaseDAO capsCaseDAO = null;

  private ComplexPersonCategoryDAO complexPersonCategoryDAO = null;

  private EmployeeDAO employeeDAO = null;
  
  private ComplexEmployeeDAO complexEmployeeDAO = null;

  private EmpJobHistoryDAO empJobHistoryDAO = null;

  private EmpOnCallLinkDAO empOnCallLinkDAO = null;

  private EmpSecClassLinkDAO empSecClassLinkDAO = null;

  private EmpTempAssignDAO empTempAssignDAO = null;

  private NameDAO nameDAO = null;

  private PersonDAO personDAO = null;

  private PersonCategoryDAO personCategoryDAO = null;

  private PersonEthnicityDAO personEthnicityDAO = null;

  private PersonIdDAO personIdDAO = null;

  private PersonRaceDAO personRaceDAO = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private TodoDAO todoDAO = null;

  private UnitDAO unitDAO = null;

  private UnitEmpLinkDAO unitEmpLinkDAO = null;

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setComplexPersonCategoryDAO(ComplexPersonCategoryDAO complexPersonCategoryDAO) {
    this.complexPersonCategoryDAO = complexPersonCategoryDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }
  
  public void setComplexEmployeeDAO(ComplexEmployeeDAO complexEmployeeDAO) {
    this.complexEmployeeDAO = complexEmployeeDAO;
  }

  public void setEmpJobHistoryDAO(EmpJobHistoryDAO empJobHistoryDAO) {
    this.empJobHistoryDAO = empJobHistoryDAO;
  }

  public void setEmpOnCallLinkDAO(EmpOnCallLinkDAO empOnCallLinkDAO) {
    this.empOnCallLinkDAO = empOnCallLinkDAO;
  }

  public void setEmpSecClassLinkDAO(EmpSecClassLinkDAO empSecClassLinkDAO) {
    this.empSecClassLinkDAO = empSecClassLinkDAO;
  }

  public void setEmpTempAssignDAO(EmpTempAssignDAO empTempAssignDAO) {
    this.empTempAssignDAO = empTempAssignDAO;
  }

  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPersonCategoryDAO(PersonCategoryDAO personCategoryDAO) {
    this.personCategoryDAO = personCategoryDAO;
  }

  public void setPersonEthnicityDAO(PersonEthnicityDAO personEthnicityDAO) {
    this.personEthnicityDAO = personEthnicityDAO;
  }

  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }

  public void setPersonRaceDAO(PersonRaceDAO personRaceDAO) {
    this.personRaceDAO = personRaceDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public CCMN05SO saveEmployeeDetail(CCMN05SI ccmn05si) throws ServiceException {
    CCMN05SO ccmn05so = new CCMN05SO();
    int ccmn05siIdPerson = ccmn05si.getUlIdPerson();
    int idEmployeeModifiedBy = ccmn05si.getUlIdEmployee();
    String cReqFuncCd = ccmn05si.getArchInputStruct().getCReqFuncCd();
    org.exolab.castor.types.Date dtEmpTermination = ccmn05si.getROWCCMN05SIG00().getDtDtEmpTermination();
    Date currentDate = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());
    ccmn05si.getROWCCMN05SIG00().setSzCdEmployeeClass(ccmn05si.getROWCCMN05SIG02().getSzCdJobClass());
   // ccmn05si.getROWCCMN05SIG01().set
    if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      // Due to requirements from other windows, a unit approver must
      // exist for all units. As a result, they cannot 1) be deleted, 2) have a
      // Term Date set, or 3) change "IN" units from the unit for which they are
      // the approver. To ensure system integrity, if any of those three
      // modifications are intended to be made, check whether the user is a
      // unit approver. If so, return a message to the window to indicate that
      // the unit approver cannot be modified.
      // The check to be made involves 2 DAMs - CCMNG5D and CCMNG6D. CCMNG6D is
      // used for modifications 1 & 2 and checks all "IN" and "OUT" unit
      // assignments. CCMNG5D is used for #3 and checks only "IN" assignments.
      // Call ccmng6d Determine if the employee is an Unit Approver
      Unit unit = unitDAO.findUnitByIdPerson(ccmn05siIdPerson);
      // If the DAO returns any rows, then the employee is a unit approver, so throw an error.
      // Otherwise then the employee is not an approver, so the modification desired can continue.
      if (unit != null) {
        throw new ServiceException(Messages.MSG_CMN_STF_APPRVR_DEL);
      }
      // Determine if the Employee is On-Call
      // call ccmne6d
      Integer empOnCallLink = empOnCallLinkDAO
                                              .findIdOnCallFromEmpOnCallLinkAndOnCallByIdPersonAndDtOnCallEnd(
                                                                                                              ccmn05siIdPerson,
                                                                                                              currentDate);
      if (empOnCallLink != null) {
        // There are some outstanding OnCalls exist for this employee. Employee can not be terminated.
        throw new ServiceException(Messages.MSG_CMN_ONCALL_OUTSTANDING);
      }
      // If not On-Call, determine if the Employee has To-Dos
      // Call ccmne7d
      // Check ToDOs before deleting an employee. If any rows found throw an error.
      Integer toDoInt = todoDAO.findIdToDoFromToDoByIdPerson(ccmn05siIdPerson);
      if (toDoInt != null) {
        throw new ServiceException(Messages.MSG_CMN_TODO_OUTSTANDING);
      }
      // int ccmn05siIdPerson = idPerson;
      // If there are no To-Dos, determine if the Employee has Stages
      // Check for primary assignments
      // callCCMNE8D
      CheckStagePersonLinkRole(ccmn05siIdPerson, CodesTables.CROLEALL_PR);
      // Check for secondary assignments; Shouldn't be able to terminate an employee
      // with secondary assignments.
      // callCCMNE8D
      CheckStagePersonLinkRole(ccmn05siIdPerson, CodesTables.CROLEALL_SE);
      // Call ccmnf5d
      // this staff member is not only an employee, but is also involved in some case(s),
      // so only delete his/her employee information
      if (0 == employeeDAO.deleteEmployee(ccmn05siIdPerson)) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      // The following has been changed to only delete the person information, not the staff information
      // this staff member is only an employee, remove him/her entirely from the database
      // Call ccmnf7d
      if (0 == personDAO.deletePerson(ccmn05siIdPerson)) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    } else if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      ROWCCMN05SIG05 rowccmn05sig05 = ccmn05si.getROWCCMN05SIG05();
      // call ccmnd6d, check for unique SSN.
      // If an employee exists with the same SSN need to signal error.
      Integer employeeInt = employeeDAO.findIdPersonFromEmployee(rowccmn05sig05.getSzCdPersonIdType(),
                                                                 rowccmn05sig05.getSzNbrPersonIdNumber(),
                                                                 DateHelper.MAX_JAVA_DATE);
      if (employeeInt != null) {
        // SSN was not unique, pass back the NOT UNIQUE SSN error
        throw new ServiceException(Messages.MSG_CMN_SSN_NOT_UNIQUE);
      }
      // call ccmni1d
      // Don't let user add another staff member if the unit is already at or over 50 people
      // get the count of employees in the unit
      ROWCCMN05SIG04 rowccmn05sig04 = ccmn05si.getROWCCMN05SIG04();
      long unitInt = unitEmpLinkDAO.countUnitEmpLinkByIdUnit(rowccmn05sig04.getUlIdUnit());
      if (unitInt >= MEMBERS_50) {
        throw new ServiceException(Messages.MSG_CMN_MORE_THAN_50_MEMBERS);
      }
      // callCCMN71D
      // Save info on the person table.
      int ccmn05soIdPerson = addUpdatePerson(ccmn05siIdPerson, cReqFuncCd, ccmn05si.getROWCCMN05SIG06());
      // int ccmn05soIdPerson = ccmn05so.getUlIdPerson();
      // The idPerson to be updated/created is set into the output structure, ccmn05so.
      ccmn05so.setUlIdPerson(ccmn05soIdPerson);

      // callCCMN78D Update the Job History table
      int returnedIdEmpJobHistory = audEmpJobDescription(ccmn05soIdPerson, ccmn05si.getROWCCMN05SIG00()
                                                                                   .getUlIdEmpJobHistory(),
                                                         ccmn05si.getROWCCMN05SIG02());
      ccmn05si.getROWCCMN05SIG00().setUlIdEmpJobHistory(returnedIdEmpJobHistory);
      // callCCMN70D Update the Employee table
      addUpdateEmployee(idEmployeeModifiedBy, ccmn05soIdPerson, cReqFuncCd, ccmn05si.getROWCCMN05SIG00());
      // callCCMN73D update PERSON ID
      addPersonId(ccmn05soIdPerson, rowccmn05sig05.getSzCdPersonIdType(), rowccmn05sig05.getUlIdPersonId(),
                  rowccmn05sig05.getSzNbrPersonIdNumber(), rowccmn05sig05.getSzDescPersonID(),
                  rowccmn05sig05.getBIndPersonIDInvalid());
      
      int idUnit = rowccmn05sig04.getUlIdUnit();
      if(idUnit < 1) {
        throw new ServiceException(Messages.MSG_CMN_INVALID_UNIT);
      }
      Unit unit = getPersistentObject(Unit.class, idUnit);
      
      // CallCCMN49D
      String unitRole = rowccmn05sig04.getSzCdUnitMemberRole();

      // The following method add a Unit Approver to a Unit that does not have one(New Unit)
      if(CodesTables.CUNMBRRL_40.equals(unitRole)) {
        updateUnitApprover(unit, ccmn05soIdPerson, returnedIdEmpJobHistory);
      } else {
        verifyUnitHasApprover(unit);
      }
      audUnitEmpLink(ccmn05soIdPerson, idUnit, rowccmn05sig04.getSzCdUnitMemberInOut(), unitRole,
                     rowccmn05sig04.getUlIdUnitEmpLink());
      
      //ROWCCMN05SIG03_ARRAY rowccmn05sig03_array = ccmn05si.getROWCCMN05SIG03_ARRAY();
      // CallCCMN98D update skill table
      // addDeleteEmployeeSkill(rowccmn05sig03_array, ccmn05soIdPerson);
      // CallCAUDD5D update race table
      addDeletePersonRace(ccmn05siIdPerson, ccmn05soIdPerson, ccmn05si.getROWCCMN05SIG08_ARRAY());
      // CallCAUDD4D update ethnicity table
      addDeletePersonEthnicity(ccmn05siIdPerson, ccmn05soIdPerson, ccmn05si.getROWCCMN05SIG09_ARRAY());
      // Update NAME table if the Name Data Action flag indicates that a change has been made.
      String cdScrDataAction = ccmn05si.getROWCCMN05SIG01().getSzCdScrDataAction();
      if (cdScrDataAction != null) {
        // callCCMNA0D
        addUpdateName(ccmn05soIdPerson, cReqFuncCd, currentDate, ccmn05si.getROWCCMN05SIG01());
      }
      // call CCMNC2D update person category table
      addUpdatePersonCategory(ccmn05soIdPerson, cReqFuncCd, dtEmpTermination);
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      // Determine if the employee is an Unit Approver if Term Date is set or if the employee changes units (which
      // can only be "IN" when changed from Staff Detail).
      // Call the DAO, CCMNG6D, for Term Date followed by DAO, CCMNG5D, for unit change
      if (!DateHelper.isNull(dtEmpTermination)) {
        // CallCCMNG6D Determine if the employee is the unit approver for any unit.

        Unit unit = unitDAO.findUnitByIdPerson(ccmn05si.getUlIdPerson());

        if (unit != null) {

          // This means the employee is a unit approver, so return an error message.
          throw new ServiceException(Messages.MSG_CMN_STF_APPRVR_DEL);
        }
      }
      int idUnitEmpLink = ccmn05si.getROWCCMN05SIG04().getUlIdUnitEmpLink();
      if (0 == idUnitEmpLink) {
        // CallCCMNG5D Determine if the employee is the unit approver for the unit for
        // which he/she is "IN" assigned.
        Integer nbrRows = unitEmpLinkDAO.findUnitEmpLinkByIdPerson(ccmn05siIdPerson);
        if (nbrRows != null) {
          // Employee is the unit approver. Throw error message
          throw new ServiceException(Messages.MSG_CMN_STF_APPRVR_MOD);
        }
      }
      if (!DateHelper.isNull(dtEmpTermination)) {
        // CallCCMNE6D Determine if the Employee is On-Call
        Integer empOnCallLink = empOnCallLinkDAO
                                                .findIdOnCallFromEmpOnCallLinkAndOnCallByIdPersonAndDtOnCallEnd(
                                                                                                                ccmn05siIdPerson,
                                                                                                                currentDate);
        if (empOnCallLink != null) {
          // There are some outstanding OnCalls exist for this employee. Employee can not be terminated
          throw new ServiceException(Messages.MSG_CMN_ONCALL_OUTSTANDING);
        }
        // If not On-Call, determine if the Employee has To-Dos
        // Call ccmne7d
        Integer toDoInt = todoDAO.findIdToDoFromToDoByIdPerson(ccmn05siIdPerson);
        if (toDoInt != null) {
          // There are some outstanding Todos exist for this employee. Employee can not be terminated
          throw new ServiceException(Messages.MSG_CMN_TODO_OUTSTANDING);
        }
        // callCCMNE8D
        // If there are no To-Dos, determine if the Employee has Stages
        CheckStagePersonLinkRole(ccmn05siIdPerson, CodesTables.CROLEALL_PR);

        // Check for Secondary assignments
        // callCCMNE8D
        CheckStagePersonLinkRole(ccmn05siIdPerson, CodesTables.CROLEALL_SE);
      }
      // callCCMN71D
      // Save info on the person table. the idPerson to be updated/created is
      // set into the ouput object and used for the DAO callss that follow
      int ccmn05soIdPerson = addUpdatePerson(ccmn05siIdPerson, cReqFuncCd, ccmn05si.getROWCCMN05SIG06());
      // The idPerson to be updated/created is set into the output structure, ccmn05so.
      ccmn05so.setUlIdPerson(ccmn05soIdPerson);
      // callCCMN78D Update the Job History table
      int returnedIdEmpJobHistory = audEmpJobDescription(ccmn05soIdPerson, ccmn05si.getROWCCMN05SIG00()
                                                                                   .getUlIdEmpJobHistory(),
                                                         ccmn05si.getROWCCMN05SIG02());
      ccmn05si.getROWCCMN05SIG00().setUlIdEmpJobHistory(returnedIdEmpJobHistory);
      // callCCMN70D Update the Employee table
      addUpdateEmployee(idEmployeeModifiedBy, ccmn05soIdPerson, cReqFuncCd, ccmn05si.getROWCCMN05SIG00());
      if (0 == idUnitEmpLink) {
        // The employee's "IN"-unit has been changed. Delete all other occurences where this employee is "IN".
        // Update UnitEmpLink - Delete the employee from all units where they are "IN" assigned.
        // ccmne0d_in
        unitEmpLinkDAO.deleteUnitEmpLinkByIdPersonCdUnitMemberInOut(ccmn05soIdPerson, CodesTables.CUMINOUT_IN);
        // CallCCMND5D
        findDeleteUnitEmpLink(ccmn05siIdPerson, ccmn05si.getROWCCMN05SIG04().getUlIdUnit());
      }
      // Do not change the employee's unit information if the Termination Date is not NULL.
      // if (true == DateHelper.isNull(ccmn05si.getROWCCMN05SIG00().getDtDtEmpTermination())) {
      if (DateHelper.isNull(dtEmpTermination)) {
        ROWCCMN05SIG04 rowccmn05sig04 = ccmn05si.getROWCCMN05SIG04();
        int idUnit = rowccmn05sig04.getUlIdUnit();
        if(idUnit < 1) {
          throw new ServiceException(Messages.MSG_CMN_INVALID_UNIT);
        }
        Unit unit = getPersistentObject(Unit.class, idUnit);
        
        // CallCCMN49D
        String unitRole = rowccmn05sig04.getSzCdUnitMemberRole();

        // The following method add a Unit Approver to a Unit that does not have one(New Unit)
        if(CodesTables.CUNMBRRL_40.equals(unitRole)) {
          updateUnitApprover(unit, ccmn05soIdPerson, returnedIdEmpJobHistory);
        } else {
          verifyUnitHasApprover(unit);
        }
        audUnitEmpLink(ccmn05soIdPerson, idUnit, rowccmn05sig04.getSzCdUnitMemberInOut(), unitRole,
                       rowccmn05sig04.getUlIdUnitEmpLink());
      }

      // CallCCMN98D
      // Updates are not performed in this method; Listed for consistency with ccmn05s service call.
      // addDeleteEmployeeSkill(ccmn05si, ccmn05so);
      // CallCAUDD5D
      // Updates are not performed in this method; Listed for consistency with ccmn05s service call.
      // addDeletePersonRace(ccmn05si, ccmn05so);
      // CallCAUDD4D
      // Updates are not performed in this method; Listed for consistency with ccmn05s service call.
      // addDeletePersonEthnicity(ccmn05si, ccmn05so);
      // Update NAME table if the Name Data Action flag indicates that a change has been made.
      addDeletePersonRace(ccmn05siIdPerson, ccmn05soIdPerson, ccmn05si.getROWCCMN05SIG08_ARRAY());
      // CallCAUDD4D update ethnicity table
      addDeletePersonEthnicity(ccmn05siIdPerson, ccmn05soIdPerson, ccmn05si.getROWCCMN05SIG09_ARRAY());
      // Update NAME table if the Name Data Action flag indicates that a change has been made.
      String cdScrDataAction = ccmn05si.getROWCCMN05SIG01().getSzCdScrDataAction();
      if (cdScrDataAction != null) {
        // callCCMNA0D
        addUpdateName(ccmn05soIdPerson, cReqFuncCd, currentDate, ccmn05si.getROWCCMN05SIG01());
        // When an employee's name changes, if that employee is involved in any APS cases and/or stages
        // as a victim or client, the Case Name and/or Stage Name should change to reflect the employee's new name.
        // This is done by calling services CCMNH4D and CCMNH5D twice - once for the new name, then again for the
        // new name appended with ", et al." (to handle APS Facility cases)
        // CallCCMNH4D updates Case Name
        // Note: The string 'rowccmn05sig06NmPersonFull' assigned below serves as
        // the 'nmCase', 'nmStage' params in later DAO calls
        String rowccmn05sig06NmPersonFull = ccmn05si.getROWCCMN05SIG06().getSzNmPersonFull();
        String nmPersonFull = ccmn05si.getSzNmPersonFull();
        capsCaseDAO
                   .updateCapsCase(rowccmn05sig06NmPersonFull, nmPersonFull, DateHelper.MAX_JAVA_DATE, ccmn05siIdPerson);
        // Call CCMNH5D updates Stage Name
        stageDAO.updateStage(rowccmn05sig06NmPersonFull, nmPersonFull, ccmn05siIdPerson, DateHelper.MAX_JAVA_DATE);

        // Change the names to include " et al" and call.
        if (nmPersonFull.length() <= NM_MAX_LENGTH) {
          // The name is small enough to append "et al"
          nmPersonFull += CASE_NM_ET_AL;
        } else {
          // The name is too long, so overwrite the end of it.
          String szTempName;
          szTempName = nmPersonFull.substring(0, NM_MAX_LENGTH) + CASE_NM_ET_AL;
          ccmn05si.setSzNmPersonFull(szTempName);
        }
        // String nmPerson;
        if (rowccmn05sig06NmPersonFull.length() <= NM_MAX_LENGTH) {
          // The name is small enough to append "et al"
          ccmn05si.getROWCCMN05SIG06().setSzNmPersonFull(rowccmn05sig06NmPersonFull + CASE_NM_ET_AL);
        } else {
          // The name is too long, so overwrite the end of it.
          String szTempName;
          szTempName = rowccmn05sig06NmPersonFull.substring(0, NM_MAX_LENGTH) + CASE_NM_ET_AL;
          ccmn05si.getROWCCMN05SIG06().setSzNmPersonFull(szTempName);
        }
        rowccmn05sig06NmPersonFull = ccmn05si.getROWCCMN05SIG06().getSzNmPersonFull();
        nmPersonFull = ccmn05si.getSzNmPersonFull();
        // CallCCMNH4D updates Case Name
        capsCaseDAO.updateCapsCase(rowccmn05sig06NmPersonFull, nmPersonFull, new Date(), ccmn05siIdPerson);
        // CallCCMNH5D updates Stage Name
        stageDAO.updateStage(rowccmn05sig06NmPersonFull, nmPersonFull, ccmn05siIdPerson, new Date());
      }
      // CallCCMNC2D update person category table
      addUpdatePersonCategory(ccmn05soIdPerson, cReqFuncCd, dtEmpTermination);
      // When an employee has a Termination Date, some extra cleanup of the
      // database is needed - all UnitEmpLink rows should be deleted and
      // temporary assignments (designees of and designees for) should be deleted.
      if (!DateHelper.isNull(dtEmpTermination)) {
        ccmn05soIdPerson = ccmn05so.getUlIdPerson();
        // Call CCMNE0D_OUT
        // Delete UnitEmpLink references for units to which the employee
        // is OUT-assigned. The IN-assigned units were deleted by the call
        // to CCMNE0D_IN earlier.
        unitEmpLinkDAO.deleteUnitEmpLinkByIdPersonCdUnitMemberInOut(ccmn05soIdPerson, CodesTables.CUMINOUT_OUT);
        // CallCCMNH2D Delete the temporary assignments
        // Delete all temporary assignments (designees for and designees of)
        // from the EmpTempAssign table.
        empTempAssignDAO.deleteEmpTempAssignByIdPerson(ccmn05soIdPerson);
        // CallCAUDE2D Deletes records in EmpSecClassLink for the terminated employee
        empSecClassLinkDAO.deleteEmpSecClassLinkByIdPerson(ccmn05soIdPerson);
      }
    }
    return ccmn05so;
  }

  private void CheckStagePersonLinkRole(int idPerson, String role) throws ServiceException {
    // Call ccmne8d
    Integer stagePersonLinkInt = stagePersonLinkDAO.findIdStagePersonLinkByIdPersonAndCdStagePersRole(idPerson, role);
    if (stagePersonLinkInt != null) {
      // There are some outstanding Stages exist for this employee. Employee can not be terminated
      throw new ServiceException(Messages.MSG_CMN_STAGES_OUTSTANDING);
    }
  }

  // If 'ADD' returns the idPerson of the newly inserted Person, otherwise returns the idPerson
  // contained in the input object, ccmn05s
  private int addUpdatePerson(int ccmn05siIdPerson, String cReqFuncCd, ROWCCMN05SIG06 rowccmn05sig06)
                                                                                                     throws ServiceException {
    int idPerson = ccmn05siIdPerson;
    String cdPersonSex = rowccmn05sig06.getCCdPersonSex();
    String cdNmPersonFull = rowccmn05sig06.getSzNmPersonFull();
    String cdPersonEthnicGroup = rowccmn05sig06.getSzCdPersonEthnicGroup();
    Date dtPersonBirth = DateHelper.toJavaDate(rowccmn05sig06.getDtDtPersonBirth());
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      // The Select Nextval from commonDAO is used since the new ID_PERSON is needed for future processing.
      idPerson = commonDAO.getNextval("SEQ_PERSON");
      // Call ccmn71d
      int nbrRowsAdded = personDAO.insertPerson(idPerson, cdPersonSex, cdNmPersonFull, cdPersonEthnicGroup,
                                                dtPersonBirth);
      if (nbrRowsAdded == 0) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
      // ccmn05so.setUlIdPerson(seqPersonNextVal);
    } else {
      Date dtLastUpdate = rowccmn05sig06.getTsLastUpdate();
      // Call ccmn71d
      int nbrRowsUpdated = personDAO.updatePerson(idPerson, cdPersonSex, cdNmPersonFull, cdPersonEthnicGroup,
                                                  dtPersonBirth, dtLastUpdate);
      if (nbrRowsUpdated == 0) {
        // No data found
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    }
    return idPerson;
  }

  /*
   * Processes the request from the Job Description page based on the requested operation.
   */
  private int audEmpJobDescription(int idPerson, int ccmn05siIdEmpJobHistory, ROWCCMN05SIG02 rowccmn05sig02)
                                                                                                            throws ServiceException {
    //int idEmpJobHistory = rowccmn05sig02.getUlIdEmpJobHistory();
    // Enumeration rowccmn05sig02_array_Enu = rowccmn05sig02_array.enumerateROWCCMN05SIG02();
    // while (rowccmn05sig02_array_Enu.hasMoreElements()) {
    // ROWCCMN05SIG02 rowccmn05sig02 = (ROWCCMN05SIG02) rowccmn05sig02_array_Enu.nextElement();
    // Ensure that rowccmn05sig02 is not null
    if (rowccmn05sig02 != null) {
      String cReqFuncCd = rowccmn05sig02.getSzCdScrDataAction();      
      EmpJobHistory empJobHistory;
      
      if(ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
        empJobHistory = getPersistentObject(EmpJobHistory.class, rowccmn05sig02.getUlIdEmpJobHistory());
        empJobHistoryDAO.deleteEmpJobDescription(empJobHistory);
      } else {
        
        String bjnJob = rowccmn05sig02.getSzBjnJob();
        String cdJobClass = rowccmn05sig02.getSzCdJobClass();
        int idJobPersSupv = rowccmn05sig02.getUlIdJobPersSupv();
        String indJobAssignable = rowccmn05sig02.getBIndJobAssignable();
        String cdJobTitle = rowccmn05sig02.getSzCdJobTitle();
      
        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
          if(idPerson < 1) {
            throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL); //-- fail-fast
          }      
          empJobHistory = new EmpJobHistory();
          empJobHistory.setIdEmpJobHistory(0); //-- not necessary, but I want this to be clear
          empJobHistory.setPersonByIdPerson(getPersistentObject(Person.class, idPerson));
        } else if(ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
          empJobHistory = getPersistentObject(EmpJobHistory.class, rowccmn05sig02.getUlIdEmpJobHistory());
        } else {
          throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
        }
        
        empJobHistory.setCdJobClass(cdJobClass);
        empJobHistory.setIndJobAssignable(indJobAssignable);
        empJobHistory.setCdJobBjn(bjnJob);
        empJobHistory.setCdJobTitle(cdJobTitle);
        
        if(idJobPersSupv > 0) {
          empJobHistory.setPersonByIdJobPersSupv(getPersistentObject(Person.class, idJobPersSupv));
        }
        
        empJobHistoryDAO.saveEmpJobHistory(empJobHistory);
        empJobHistoryDAO.flushEmpJobHistory();
        return empJobHistory.getIdEmpJobHistory();
          
          // The Select Nextval from commonDAO is used since the new ID_EMP_JOB_HISTORY is
          // needed for future processing.
          //int seqEmpJobHistoryNextVal = commonDAO.getNextval("SEQ_EMP_JOB_HISTORY");
          // call ccmn78d
          //nbrRowsAdded = empJobHistoryDAO.insertEmpJobDescription(seqEmpJobHistoryNextVal, idPerson, idJobPersSupv,
          //                                                        cdJobClass, indJobAssignable, bjnJob, cdJobTitle);
          // insertEmpJobDescription(seqEmpJobHistoryNextVal, idPerson, idJobPersSupv,
          // cdJobTitle, indCaseAssignable, textErsNumber);
          //if (nbrRowsAdded == 0) {
          //  throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
          //}
          // if a new employee is being added to the database, the idEmpJobHistory
          // which represents the employee's current status (BJN, End Date = NULL, etc.)
          // needs to be placed in the Employee record group for saving to the
          // EMPLOYEE table in DAO CCMN70D. check to see if the ID in the Employee record
          // group is 0 and that the End date for the current input is NULL.
          // Note1 - Employees can be created (Staff Detail in New mode) with a
          // Term Date set. If this is done, there will be Job History rows which,
          // upon entry to the service, are set to 0. Since DAO 70 requires an
          // idEmpJobHistory (any idEmpJobHistory) one must be stored for future use.
          // (In actuality, since all of the ID's are set to 0, this IF statement will
          // be run for each row; the last one through will be the one that is stored.
          // However, it is unlikely that there will be more than 1 row.)
          //
          // Note2 - The idEmpJobHistory returned from the DAO should only be copied
          // into the Input Message for use by DAO CCMN70D if there was a change
          // to the ID of the most recent job history record for the employee
          // (i.e., a new job history record row was created). Since the Job History
          // window ensures that the top row being displayed in the listbox is the
          // most recent job history record, we only need to copy the value after the
          // first ADD. As a result, the following if-statement has been modified.
          // (Note - once the first ADD has been processed,newIdEmpJobHistory will no
          // longer be NULL/zero.)
          //if (0 == newIdEmpJobHistory) {
          //  newIdEmpJobHistory = seqEmpJobHistoryNextVal;
          //}
      }
    }
    return ccmn05siIdEmpJobHistory;
  }

  // Save Employee information on EMPLOYEE table
  private void addUpdateEmployee(int idEmployeeModifiedBy, int idPerson, String cReqFuncCd,
                                 ROWCCMN05SIG00 rowccmn05sig00) throws ServiceException {
    int nbrRowsUpdated;
    //int nbrRowsAdded;
    Date dtLastUpdate = rowccmn05sig00.getTsLastUpdate();
    int idEmpJobHistory = rowccmn05sig00.getUlIdEmpJobHistory();
    String cdEmpProgram = rowccmn05sig00.getSzCdEmpProgram();
    String cdEmployeeClass = rowccmn05sig00.getSzCdEmployeeClass();
    String idEmployeeLogon = rowccmn05sig00.getSzIdEmployeeLogon();
    Date dtEmpHire = DateHelper.toJavaDate(rowccmn05sig00.getDtDtEmpHire());
    Date dtEmpLastAssigned = DateHelper.toJavaDate(rowccmn05sig00.getDtDtEmpLastAssigned());
    Date dtEmpTermination = DateHelper.toJavaDate(rowccmn05sig00.getDtDtEmpTermination());
    int idOffice = rowccmn05sig00.getUlIdOffice();
    String indActiveStatus = rowccmn05sig00.getBIndActiveStatus();
    String indEmpConfirmedHrmis = rowccmn05sig00.getBIndEmpConfirmedHrmis();
    String indEmpPendingHrmis = rowccmn05sig00.getBIndEmpPendingHrmis();
    int nbrEmpActivePct = rowccmn05sig00.getLNbrEmpActivePct();
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      Employee employee = new Employee();
      employee.setPerson(getPersistentObject(Person.class, idPerson));
      employee.setNbrEmpActivePct(nbrEmpActivePct);
      employee.setDtEmpHire(dtEmpHire);
      employee.setEmpJobHistory(getPersistentObject(EmpJobHistory.class, idEmpJobHistory));
      employee.setIdEmployeeLogon(idEmployeeLogon);
      employee.setCdEmployeeClass(cdEmployeeClass);
      employee.setOffice(getPersistentObject(Office.class, idOffice));
      employee.setDtEmpLastAssigned(dtEmpLastAssigned);
      employee.setCdEmpProgram(cdEmpProgram);
      employee.setIndEmpConfirmedHrmis(indEmpConfirmedHrmis);
      employee.setIndEmpPendingHrmis(indEmpPendingHrmis);
      employee.setIndEmpActiveStatus(indActiveStatus);
      employee.setDtEmpTermination(dtEmpTermination);
      employee.setEmployee(getPersistentObject(Employee.class, idEmployeeModifiedBy));
      employeeDAO.saveEmployee(employee);
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
     
      nbrRowsUpdated = complexEmployeeDAO.updateEmployee(idPerson, nbrEmpActivePct, dtEmpHire, idEmpJobHistory,
                                                  idEmployeeLogon, cdEmployeeClass, idOffice, dtEmpLastAssigned,
                                                  cdEmpProgram, indEmpConfirmedHrmis, indEmpPendingHrmis,
                                                  indActiveStatus, dtEmpTermination, dtLastUpdate, idEmployeeModifiedBy);
      if (nbrRowsUpdated == 0) {
        // No data found
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      // Delete not performed - Person delete trigger should take care of it
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
  }

  // Save Employee information on PERSON ID table. This only occurs for new employees
  private void addPersonId(int ccmn05soIdPerson, String cdPersonIdType, int idPersonId, String nbrPersonIdNumber,
                           String descPersonId, String indPersonIdInvalid) throws ServiceException {
    int nbrRowsAdded;
    Date dtPersonIdStart = new Date();
    // call callCCMN73D
    nbrRowsAdded = personIdDAO.insertPersonId(ccmn05soIdPerson, nbrPersonIdNumber, cdPersonIdType, descPersonId,
                                              indPersonIdInvalid, dtPersonIdStart);
    if (nbrRowsAdded == 0) {
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }
  }

  // Save Employee information on UnitEmpLink table
  private void audUnitEmpLink(int ccmn05soIdPerson, int idUnit, String cdUnitMemberInOut,
                              String cdUnitMemberRole, int idUnitEmpLink) throws ServiceException {
    UnitEmpLink unitEmpLink;
    
    if(idUnitEmpLink < 1) {
      unitEmpLink = new UnitEmpLink();
    } else {
      unitEmpLink = getPersistentObject(UnitEmpLink.class, idUnitEmpLink);
    }
    
    unitEmpLink.setCdUnitMemberInOut(cdUnitMemberInOut);
    unitEmpLink.setCdUnitMemberRole(cdUnitMemberRole);

    if (ccmn05soIdPerson != 0) {
      Employee employee = getPersistentObject(Employee.class, ccmn05soIdPerson);
      unitEmpLink.setEmployee(employee);
    } else {
      //-- fail-fast
      throw new ServiceException(Messages.MSG_DATABASE_SAVE_FAIL);
    }
    if (idUnit != 0) {
      Unit unit = getPersistentObject(Unit.class, idUnit);
      // If this is a new Unit(without Unit Approver), set UnitMemberInOut to In
      if (null == unit.getPerson()) {
        unitEmpLink.setCdUnitMemberInOut(CodesTables.CUMINOUT_IN);
      }
      unitEmpLink.setUnit(unit);
    } else {
      //-- fail-fast
      throw new ServiceException(Messages.MSG_CMN_INVALID_UNIT);
    }
    //if (ccmn05soIdPerson != 0) {
    //  Person person = getPersistentObject(Person.class, ccmn05soIdPerson);
    //  unitEmpLink.setPerson(person);
    //}
    
    unitEmpLinkDAO.saveUnitEmpLink(unitEmpLink);
    
    /*
    if (idUnitEmpLink == 0) {
      // call ccmn49d
      unitEmpLink.setDtLastUpdate(dtLastUpdate);
      try {
        unitEmpLinkDAO.saveUnitEmpLink(unitEmpLink);
      } catch (Exception e) {
        String message = "not-null property references a null or transient value: gov.georgia.dhr.dfcs.sacwis.db.UnitEmpLink.unit";
        if (message.equals(e.getMessage())) {
          throw new ServiceException(Messages.MSG_CMN_INVALID_UNIT);
        }
      }
    } else {
      unitEmpLink.setIdUnitEmpLink(idUnitEmpLink);
      unitEmpLink.setDtLastUpdate(dtLastUpdate);
      try {
        // call ccmn49d
        unitEmpLinkDAO.saveUnitEmpLink(unitEmpLink);
      } catch (Exception e) {
        String message = "not-null property references a null or transient value: gov.georgia.dhr.dfcs.sacwis.db.UnitEmpLink.unit";
        if (message.equals(e.getMessage())) {
          throw new ServiceException(Messages.MSG_CMN_INVALID_UNIT);
        }
      }
    }
    */
  }

  /* Update Unit that has no unit approver.
  private void addUnitApproverToUnit(int ccmn05soIdPerson, int idUnit) throws ServiceException {
    if(idUnit > 0 && ccmn05soIdPerson > 0) {
      Unit unit = getPersistentObject(Unit.class, idUnit);
      unit.setPerson(getPersistentObject(Person.class, ccmn05soIdPerson));
      unitDAO.saveUnit(unit);
    }
    
    /*
    Unit unit = new Unit();

    if (idUnit != 0 && ccmn05soIdPerson != 0) {
      unit = getPersistentObject(Unit.class, idUnit);
      Person person = getPersistentObject(Person.class, ccmn05soIdPerson);
      if (0 == unit.getPerson().getIdPerson()) {
        unit.setPerson(person);
      }
    }

    try {
      unitDAO.saveUnit(unit);
    } catch (Exception e) {
      String message = "not-null property references a null or transient value: gov.georgia.dhr.dfcs.sacwis.db.Unit.unit";
      if (message.equals(e.getMessage())) {
        throw new ServiceException(Messages.MSG_CMN_INVALID_UNIT);
      }
    }
    //
  }
  */

  /*
  private void addDeleteEmployeeSkill(ROWCCMN05SIG03_ARRAY rowccmn05sig03_array, int idPerson) throws ServiceException {
    int nbrRowsAdded;
    int nbrRowsDeleted;
    Enumeration rowccmn05sig03_enum = rowccmn05sig03_array.enumerateROWCCMN05SIG03();
    while (rowccmn05sig03_enum.hasMoreElements()) {
      ROWCCMN05SIG03 rowccmn05sig03 = (ROWCCMN05SIG03) rowccmn05sig03_enum.nextElement();
      String empSkill = rowccmn05sig03.getSzCdEmpSkill();
      String cReqFuncCd = rowccmn05sig03.getSzCdScrDataAction();
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
        // call ccmn98d
        nbrRowsAdded = employeeSkillDAO.insertEmployeeSkill(idPerson, empSkill);
        if (nbrRowsAdded == 0) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
        nbrRowsDeleted = employeeSkillDAO.deleteEmployeeSkillByIdPersonAndCdEmpSkill(idPerson, empSkill);
        if (nbrRowsDeleted == 0) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
        // Do nothing, updates not performed.
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }
  }
  */

  // Adds and deletes a row from the person race table
  private void addDeletePersonRace(int ccmn05siIdPerson, int ccmn05soIdPerson, ROWCCMN05SIG08_ARRAY rowccmn05sig08_array)
                                                                                                                         throws ServiceException {
    int idPerson = ccmn05siIdPerson;
    if (ccmn05siIdPerson == 0) {
      idPerson = ccmn05soIdPerson;
    }
    Enumeration rowccmn05sig08_enum = rowccmn05sig08_array.enumerateROWCCMN05SIG08();
    while (rowccmn05sig08_enum.hasMoreElements()) {
      ROWCCMN05SIG08 rowccmn05sig08 = (ROWCCMN05SIG08) rowccmn05sig08_enum.nextElement();
      String cdPersonRace = rowccmn05sig08.getSzCdPersonRace();
      String cReqFuncCd = rowccmn05sig08.getSzCdScrDataAction();
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
        PersonRace personRace = new PersonRace();
        personRace.setCdRace(cdPersonRace);
        Person person = getPersistentObject(Person.class, idPerson);
        personRace.setPerson(person);

        // call caudd5d
        personRaceDAO.savePersonRace(personRace);
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
        int nbrRowsDeleted = personRaceDAO.deletePersonRaceByIdPersonAndCdPersonRace(idPerson, cdPersonRace);
        if (nbrRowsDeleted == 0) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
        // Do nothing, updates not performed.
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }
  }

  // Adds and deletes a row from the person ethnicity table
  private void addDeletePersonEthnicity(int ccmn05siIdPerson, int ccmn05soIdPerson,
                                        ROWCCMN05SIG09_ARRAY rowccmn05sig09_array) throws ServiceException {
    //int nbrRowsAdded;
    int nbrRowsDeleted;
    int idPerson = ccmn05siIdPerson;
    if (0 == ccmn05siIdPerson) {
      idPerson = ccmn05soIdPerson;
    }
    Enumeration rowccmn05sig09_enum = rowccmn05sig09_array.enumerateROWCCMN05SIG09();
    while (rowccmn05sig09_enum.hasMoreElements()) {
      ROWCCMN05SIG09 rowccmn05sig09 = (ROWCCMN05SIG09) rowccmn05sig09_enum.nextElement();
      String cdPersonEthnicity = rowccmn05sig09.getSzCdPersonEthnicity();
      String cReqFuncCd = rowccmn05sig09.getSzCdScrDataAction();
      if (cdPersonEthnicity != null) {
        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
          // call caudd4d
          PersonEthnicity personEthnicity = new PersonEthnicity();
          personEthnicity.setCdEthnicity(cdPersonEthnicity);
          Person person = getPersistentObject(Person.class, idPerson);
          personEthnicity.setPerson(person);
          personEthnicityDAO.savePersonEthnicity(personEthnicity);
        } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
          nbrRowsDeleted = personEthnicityDAO.deletePersonEthnicity(idPerson);
          if (nbrRowsDeleted == 0) {
            throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
          }
        } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
          // Do nothing, updates not performed.
        } else {
          throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
        }
      }
    }
  }

  // Save Employee information on NAME table
  private void addUpdateName(int ccmn05soIdPerson, String ccmn05siCReqFuncCd, Date currentDate,
                             ROWCCMN05SIG01 rowccmn05sig01) throws ServiceException {
    String cReqFuncCd = ccmn05siCReqFuncCd;
    if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(rowccmn05sig01.getSzCdScrDataAction())) {
      // Name was modified, so close out the old name row by setting the end date.
      int idName = rowccmn05sig01.getUlIdName();
      Date dtLastUpdate = rowccmn05sig01.getTsLastUpdate();
      // call ccmna0d
      int nbrRowsUpdated = nameDAO.updateName(idName, currentDate, dtLastUpdate);
      if (nbrRowsUpdated == 0) {
        // No data found
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
      // After updating the previous row, create a new row with the new name
      cReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
    }
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      String indNameInvalid = rowccmn05sig01.getBIndNameInvalid();
      String indNamePrimary = rowccmn05sig01.getBIndNamePrimary();
      String nmNameFirst = rowccmn05sig01.getSzNmNameFirst();
      String nmNameLast = rowccmn05sig01.getSzNmNameLast();
      String nmNameMiddle = rowccmn05sig01.getSzNmNameMiddle();
      String cdNameSuffix = rowccmn05sig01.getSzCdNameSuffix();
      // call ccmna0d
      int nbrRowsAdded = nameDAO.insertName(ccmn05soIdPerson, indNameInvalid, nmNameFirst, nmNameMiddle, nmNameLast,
                                            indNamePrimary, cdNameSuffix, currentDate);
      if (nbrRowsAdded == 0) {
        throw new ServiceException(Messages.MSG_CMN_UPDATE_FAILED);
      }
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      // Delete not performed - Person delete trigger should take care of it.
    } else {
      // throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
  }

  // Save Employee information on PersonCategory table
  private void addUpdatePersonCategory(int idPerson, String cReqFuncCd, org.exolab.castor.types.Date dtEmpTermination)
                                                                                                                      throws ServiceException {
    int nbrRowsUpdated;
    // int nbrRowsAdded;
    // String cReqFuncCd = ccmn05si.getArchInputStruct().getCReqFuncCd();
    String cdPersonCategory2;
    String cdCategoryCategory;
    if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      // If a staff person is being deleted then their 'EMP' roles should be changed to 'FEM'
      // The service is actually updating an existing person
      cdPersonCategory2 = CodesTables.CPSNDTCT_FEM;
      cdCategoryCategory = CodesTables.CPSNDTCT_EMP;
      cReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
      // call ccmnc2d
      nbrRowsUpdated = personCategoryDAO.updateCdPersonCategoryByIdPersonAndCdPersonCategory(idPerson,
                                                                                             cdCategoryCategory,
                                                                                             cdPersonCategory2);
      if (nbrRowsUpdated == 0) {
        // No data found
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      // Former employees can be rehired, so it is necessary to ensure that the value for the employee in the database
      // reflects that they are a current employee (i.e., their
      // person category is set to PERSON_CATEGORY_EMPLOYEE).
      if (DateHelper.isNull(dtEmpTermination)) {
        cdPersonCategory2 = CodesTables.CPSNDTCT_EMP;
        cdCategoryCategory = CodesTables.CPSNDTCT_FEM;
      } else {
        // the employee has been terminated
        cdPersonCategory2 = CodesTables.CPSNDTCT_FEM;
        cdCategoryCategory = CodesTables.CPSNDTCT_EMP;
      }
      // call ccmnc2d
      nbrRowsUpdated = personCategoryDAO.updateCdPersonCategoryByIdPersonAndCdPersonCategory(idPerson,
                                                                                             cdCategoryCategory,
                                                                                             cdPersonCategory2);
      if (nbrRowsUpdated == 0) {
        // No data found
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    } else if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      PersonCategory personCategory = new PersonCategory();
      Person person = getPersistentObject(Person.class, idPerson);
      // person.setIdPerson();
      personCategory.setPerson(person);
      // If the person is being added to the system and he/she has a
      // termination date, add him/her as a Former Employee not Employee.
      if (!DateHelper.isNull(dtEmpTermination)) {
        // The person has been terminated, add them as a FORMER EMPLOYEE
        cdCategoryCategory = CodesTables.CPSNDTCT_FEM;
        personCategory.setCdPersonCategory(cdCategoryCategory);
      } else {
        // Add them as an employee
        cdCategoryCategory = CodesTables.CPSNDTCT_EMP;
        personCategory.setCdPersonCategory(cdCategoryCategory);
      }
      // call ccmnc2d
      complexPersonCategoryDAO.insertPersonCategory(personCategory);
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
  }

  private void findDeleteUnitEmpLink(int ccmn05siIdPerson, int ccmn05siIdUnit) {
    // call ccmnd5d
    UnitEmpLink unitEmpLink = unitEmpLinkDAO.findUnitEmpLinkByIdPersonAndIdUnit(ccmn05siIdPerson, ccmn05siIdUnit);
    if (unitEmpLink != null) {
      // The employee is currently 'OUT'-assigned to the IdUnit that they are being
      // transferred into; call DAO, ccmn49d to delete this 'OUT' assignment.
      // call ccmn49d
      unitEmpLinkDAO.deleteUnitEmpLink(unitEmpLink);
    }
  }
  
  private void updateUnitApprover(Unit unit, int idPerson, int idEmpJobHistory) {
    //-- if the assigned unit already has a Unit Approver (not a new unit), force user to
    //-- add as Member first and then switch the approver via Unit Maintenance Detail
    Person unitApprover = unit.getPerson();
    if(unitApprover != null && unitApprover.getIdPerson() != idPerson) {
      throw new ServiceException(Messages.MSG_CMN_ADD_TO_UNIT);
    } else if(unitApprover == null) {
      unitApprover = getPersistentObject(Person.class, idPerson);
      unit.setPerson(unitApprover);
      unitDAO.saveUnit(unit);
    }
    //-- update empJobHistory
    EmpJobHistory empJobHistory = getPersistentObject(EmpJobHistory.class, idEmpJobHistory);
    empJobHistory.setPersonByIdJobPersSupv(unitApprover);
    empJobHistoryDAO.saveEmpJobHistory(empJobHistory);
  }
  
  //-- call this method when unit member role is NOT unit approver; this will verify that
  //-- the unit they are assigned to has a unit approver first because the first person
  //-- added to a unit must be the unit approver
  private void verifyUnitHasApprover(Unit unit) {
    Person unitApprover = unit.getPerson();
    if(unitApprover == null) {
      throw new ServiceException(Messages.MSG_CMN_FIRST_UNIT_MBR);
    }
  }
}
