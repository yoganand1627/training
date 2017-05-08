package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpJobHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeSkillDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.OfficeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonEthnicityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonIdDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonRaceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.EmployeeSkill;
import gov.georgia.dhr.dfcs.sacwis.db.Office;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEthnicity;
import gov.georgia.dhr.dfcs.sacwis.db.PersonId;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;
import gov.georgia.dhr.dfcs.sacwis.db.UnitEmpLink;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveEmployeeDetail;
import gov.georgia.dhr.dfcs.sacwis.service.admin.UnitAccess;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UlIdPerson_ARRAY_CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG07_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04SOG08_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG03;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG03_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG04;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG05;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN04SOG06;

public class RetrieveEmployeeDetailImpl extends BaseServiceImpl implements RetrieveEmployeeDetail {

  private EmpJobHistoryDAO empJobHistoryDAO = null;
  private EmployeeDAO employeeDAO = null;
  private EmployeeSkillDAO employeeSkillDAO = null;
  private NameDAO nameDAO = null;
  private OfficeDAO officeDAO = null;
  private PersonDAO personDAO = null;
  private PersonIdDAO personIdDAO = null;
  private PersonRaceDAO personRaceDAO = null;
  private PersonEthnicityDAO personEthnicityDAO = null;
  private UnitAccess unitAccess = null;
  private UnitEmpLinkDAO unitEmpLinkDAO = null;

  public void setEmpJobHistoryDAO(EmpJobHistoryDAO empJobHistoryDAO) {
    this.empJobHistoryDAO = empJobHistoryDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setEmployeeSkillDAO(EmployeeSkillDAO employeeSkillDAO) {
    this.employeeSkillDAO = employeeSkillDAO;
  }

  public void setNameDAO(NameDAO nameDAO) {
    this.nameDAO = nameDAO;
  }

  public void setOfficeDAO(OfficeDAO officeDAO) {
    this.officeDAO = officeDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setPersonIdDAO(PersonIdDAO personIdDAO) {
    this.personIdDAO = personIdDAO;
  }

  public void setPersonRaceDAO(PersonRaceDAO personRaceDAO) {
    this.personRaceDAO = personRaceDAO;
  }

  public void setPersonEthnicityDAO(PersonEthnicityDAO personEthnicityDAO) {
    this.personEthnicityDAO = personEthnicityDAO;
  }

  public void setUnitAccess(UnitAccess unitAccess) {
    this.unitAccess = unitAccess;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public CCMN04SO retrieveEmployeeDetail(CCMN04SI ccmn04si) throws ServiceException {

    CCMN04SO ccmn04so = new CCMN04SO();
    ccmn04so.setDtWCDDtSystemDate(DateHelper.getTodayCastorDate());

    int idPerson = ccmn04si.getUlIdPerson_ARRAY_CCMN04SI().getUlIdPerson()[0];
    // ccmn69d
    ccmn04so.setROWCCMN04SOG00(retrieveEmployee(idPerson));

    // ccmn40d
    ccmn04so.setROWCCMN04SOG01(retrieveName(idPerson));

    // ccmn44d
    ccmn04so.setROWCCMN04SOG06(retrievePerson(idPerson));

    // ccmn72d
    ccmn04so.setROWCCMN04SOG05(retrievePersonId(idPerson));

    // ccmn76d
    ccmn04so.setROWCCMN04SOG02(retrieveEmpJobDescription(idPerson));

    // ccmn31d
    ccmn04so.setROWCCMN04SOG03_ARRAY(retrieveEmployeeSkill(idPerson));

    // clss79d
    ccmn04so.setCCMN04SOG07_ARRAY(retrievePersonRace(idPerson));

    // clss80d
    ccmn04so.setCCMN04SOG08_ARRAY(retrievePersonEthnicity(idPerson));

    // Default the returned window mode to INQUIRE and only call UnitAccess() and DAMs CCMN39D and CCMN41D if the
    //   employee is an active employee (since inactive employees do not have unit or office links).
    if (ArchitectureConstants.Y.equals(ccmn04so.getROWCCMN04SOG00().getBIndActiveStatus())) {
      // ccmn39d
      ROWCCMN04SOG04 rowccmn04sog04 = retrieveUnit(idPerson);
      ccmn04so.setROWCCMN04SOG04(rowccmn04sog04);

      // ccmn41d
      Office office = officeDAO.findOfficeByIdOffice(ccmn04so.getROWCCMN04SOG00().getUlIdOffice());
      if (office == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      // ccmn04so.setSzAddrMailCode(office.getMailCode().getCdMailCode());
      ccmn04so.setSzNmOfficeName(office.getIdOffice().toString());
      ccmn04so.setUlIdOffice(office.getIdOffice());
      Employee employee = employeeDAO.findEmployeeByIdPerson(idPerson);
      if (employee == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      ccmn04so.setSzCdCounty(ccmn04so.getROWCCMN04SOG04().getSzCdCounty());
      
      String officeCity = officeDAO.findOfficeCityByCdCountyIdOffice(ccmn04so.getUlIdOffice());
      ccmn04so.setSzAddrMailCodeCity(officeCity); 
      //Check Unit Access
      rowccmn04sog04.setSzSysCdWinMode(checkUnitAccess(ccmn04si.getUlIdPerson_ARRAY_CCMN04SI(),
                                                       rowccmn04sog04.getUlIdUnit()));
    }
    return ccmn04so;
  }

  public ROWCCMN04SOG00 retrieveEmployee(int idPerson) throws ServiceException {
    // ccmn69d
    Employee employee = employeeDAO.findEmployeeByIdPerson(idPerson);
    if (employee == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCCMN04SOG00 rowccmn04sog00 = new ROWCCMN04SOG00();
    rowccmn04sog00.setUlIdPerson(employee.getIdPerson() != null ? employee.getIdPerson() : 0);
    rowccmn04sog00.setSzCdEmpProgram(employee.getCdEmpProgram());
    rowccmn04sog00.setSzIdEmployeeLogon(employee.getIdEmployeeLogon());
    rowccmn04sog00.setDtDtEmpHire(DateHelper.toCastorDate(employee.getDtEmpHire()));
    rowccmn04sog00.setDtDtEmpLastAssigned(DateHelper.toCastorDate(employee.getDtEmpLastAssigned()));
    org.exolab.castor.types.Date castorDtEmpTermination = DateHelper.toCastorDate(employee.getDtEmpTermination());
    rowccmn04sog00.setDtDtEmpTermination(castorDtEmpTermination);
    rowccmn04sog00.setSzCdEmployeeClass(employee.getCdEmployeeClass());

    int idOffice = 0;
    if (employee.getOffice() != null) {
      idOffice = employee.getOffice().getIdOffice();
    }

    rowccmn04sog00.setUlIdOffice(idOffice);
    rowccmn04sog00.setUlIdEmpJobHistory(employee.getEmpJobHistory().getIdEmpJobHistory() != null ?
                                        employee.getEmpJobHistory().getIdEmpJobHistory() : 0);
    rowccmn04sog00.setBIndActiveStatus(employee.getIndEmpActiveStatus());
    rowccmn04sog00.setBIndEmpConfirmedHrmis(employee.getIndEmpConfirmedHrmis());
    rowccmn04sog00.setBIndEmpPendingHrmis(employee.getIndEmpPendingHrmis());
    rowccmn04sog00.setLNbrEmpActivePct(employee.getNbrEmpActivePct() != null ? employee.getNbrEmpActivePct() : 0);
    rowccmn04sog00.setTsLastUpdate(employee.getDtLastUpdate());
    //rowccmn04sog00.setSzCdEmployeeClass(employee.getCdEmployeeClass());
    return rowccmn04sog00;
  }

  public ROWCCMN04SOG01 retrieveName(int idPerson) throws ServiceException {
    // ccmn40d
    Map nameMap = nameDAO.findNameFromNameAndPhoneticNameByIdPerson(idPerson);
    if (nameMap == null || nameMap.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCCMN04SOG01 rowccmn04sog01 = new ROWCCMN04SOG01();
    rowccmn04sog01.setUlIdPerson((Integer) nameMap.get("idPerson") != null ? (Integer) nameMap.get("idPerson") : 0);
    rowccmn04sog01.setSzCdNameSuffix((String) nameMap.get("cdNameSuffix"));
    Date dtNameEndDate = (Date) nameMap.get("dtNameEndDate");
    rowccmn04sog01.setDtDtNameEndDate(DateHelper.toCastorDate(dtNameEndDate));
    Date dtNameStartDate = (Date) nameMap.get("dtNameStartDate");
    rowccmn04sog01.setDtDtNameStartDate(DateHelper.toCastorDate(dtNameStartDate));
    rowccmn04sog01.setUlIdName((Integer) nameMap.get("idName") != null ? (Integer) nameMap.get("idName") : 0);
    rowccmn04sog01.setBIndNameInvalid((String) nameMap.get("indNameInvalid"));
    rowccmn04sog01.setBIndNamePrimary((String) nameMap.get("indNamePrimary"));
    rowccmn04sog01.setSzNmNameFirst((String) nameMap.get("nmNameFirst"));
    rowccmn04sog01.setSzNmNameLast((String) nameMap.get("nmNameLast"));
    rowccmn04sog01.setSzNmNameMiddle((String) nameMap.get("nmNameMiddle"));
    rowccmn04sog01.setTsLastUpdate((Date) nameMap.get("dtLastUpdate"));
    return rowccmn04sog01;
  }

  public ROWCCMN04SOG06 retrievePerson(int idPerson) throws ServiceException {
    // ccmn44d
    Person person = personDAO.findPersonByIdPerson(idPerson);
    if (person == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCCMN04SOG06 rowccmn04sog06 = new ROWCCMN04SOG06();
    rowccmn04sog06.setCCdPersonSex(person.getCdPersonSex());
    rowccmn04sog06.setSzNmPersonFull(person.getNmPersonFull());
    rowccmn04sog06.setTsLastUpdate(person.getDtLastUpdate());
    rowccmn04sog06.setSzCdPersonEthnicGroup(person.getCdPersonEthnicGroup());
    rowccmn04sog06.setDtDtPersonBirth(DateHelper.toCastorDate(person.getDtPersonBirth()));
    return rowccmn04sog06;
  }

  public ROWCCMN04SOG05 retrievePersonId(int idPerson) throws ServiceException {
    // ccmn72d
    PersonId personId =
            personIdDAO.findPersonIdByIdPersonCdPersonIdTypeIndPersonIdInvalidDtPersonIdEnd(idPerson,
                                                                                            CodesTables.CNUMTYPE_SSN,
                                                                                            ArchitectureConstants.N,
                                                                                            DateHelper.MAX_JAVA_DATE);
    if (personId == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCCMN04SOG05 rowccmn04sog05 = new ROWCCMN04SOG05();
    rowccmn04sog05.setUlIdPerson(personId.getPerson().getIdPerson() != null ? personId.getPerson().getIdPerson() : 0);
    rowccmn04sog05.setSzCdPersonIdType(personId.getCdPersonIdType());
    rowccmn04sog05.setUlIdPersonId(personId.getIdPersonId() != null ? personId.getIdPersonId() : 0);
    rowccmn04sog05.setSzNbrPersonIdNumber(personId.getNbrPersonIdNumber());
    rowccmn04sog05.setTsLastUpdate(personId.getDtLastUpdate());
    return rowccmn04sog05;
  }

  public ROWCCMN04SOG02_ARRAY retrieveEmpJobHistory(int idPerson) throws ServiceException {
    // ccmn76d
    List<Map> empJobHistoryList = empJobHistoryDAO.findEmpJobHistoryByIdPerson(idPerson);
    if (empJobHistoryList == null || empJobHistoryList.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCCMN04SOG02_ARRAY rowccmn04sog02_array = new ROWCCMN04SOG02_ARRAY();
    for (Iterator<Map> it = empJobHistoryList.iterator(); it.hasNext();) {
      Map empJobHistoryMap = it.next();
      ROWCCMN04SOG02 row = new ROWCCMN04SOG02();
      row.setUlIdPerson((Integer) empJobHistoryMap.get("personByIdPerson") != null ? (Integer) empJobHistoryMap.get(
              "personByIdPerson") : 0);
      row.setSzBjnJob((String) empJobHistoryMap.get("cdJobBjn"));
      row.setSzCdJobClass((String) empJobHistoryMap.get("cdJobClass"));
      row.setSzCdJobFunction((String) empJobHistoryMap.get("cdJobFunction"));
      Date dtJobEnd = (Date) empJobHistoryMap.get("dtJobEnd");
      row.setDtDtJobEnd(DateHelper.toCastorDate(dtJobEnd));
      Date dtJobStart = (Date) empJobHistoryMap.get("dtJobStart");
      row.setDtDtJobStart(DateHelper.toCastorDate(dtJobStart));
      row.setUlIdEmpJobHistory((Integer) empJobHistoryMap.get("idEmpJobHistory") != null ?
                               (Integer) empJobHistoryMap.get("idEmpJobHistory") : 0);
      row.setUlIdJobPersSupv((Integer) empJobHistoryMap.get("personByIdJobPersSupv") != null ?
                             (Integer) empJobHistoryMap.get("personByIdJobPersSupv") : 0);
      row.setSzNmPersonFull((String) empJobHistoryMap.get("nmPersonFull"));
      row.setBIndJobAssignable((String) empJobHistoryMap.get("indJobAssignable"));
      Date dtLastUpdate = (Date) empJobHistoryMap.get("dtLastUpdate");
      row.setTsLastUpdate(dtLastUpdate);
      rowccmn04sog02_array.addROWCCMN04SOG02(row);
    }
    return rowccmn04sog02_array;
  }

  public ROWCCMN04SOG02 retrieveEmpJobDescription(int idPerson) throws ServiceException {
    // ccmn76d
    Map empJobDescriptionMap = empJobHistoryDAO.findEmpJobDescriptionByIdPerson(idPerson);
    if (empJobDescriptionMap == null || empJobDescriptionMap.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    //ROWCCMN04SOG02_ARRAY rowccmn04sog02_array = new ROWCCMN04SOG02_ARRAY();
    //using key objects to retireve their values
    ROWCCMN04SOG02 row = new ROWCCMN04SOG02();
    row.setUlIdPerson((Integer) empJobDescriptionMap.get("personByIdPerson") != null ?
                      (Integer) empJobDescriptionMap.get(
                              "personByIdPerson") : 0);
    row.setSzBjnJob((String) empJobDescriptionMap.get("cdJobBjn"));
    row.setSzCdJobClass((String) empJobDescriptionMap.get("cdJobClass"));
    row.setSzCdJobTitle((String) empJobDescriptionMap.get("cdJobTitle"));
    row.setUlIdEmpJobHistory((Integer) empJobDescriptionMap.get("idEmpJobHistory") != null ?
                             (Integer) empJobDescriptionMap.get("idEmpJobHistory") : 0);
    int idJobPersSupv = empJobDescriptionMap.get("personByIdJobPersSupv") != null ?
                        (Integer) empJobDescriptionMap.get("personByIdJobPersSupv") : 0;
    if(idJobPersSupv > 0) {
      row.setUlIdJobPersSupv(idJobPersSupv);
      row.setSzNmPersonFull(getPersistentObject(Person.class, idJobPersSupv).getNmPersonFull());
    }
    row.setBIndJobAssignable((String) empJobDescriptionMap.get("indJobAssignable"));
    Date dtLastUpdate = (Date) empJobDescriptionMap.get("dtLastUpdate");
    row.setTsLastUpdate(dtLastUpdate);
    //rowccmn04sog02_array.addROWCCMN04SOG02(row);

    return row;
  }

  private ROWCCMN04SOG03_ARRAY retrieveEmployeeSkill(int idPerson) {
    // ccmn31d
    List<EmployeeSkill> employeeSkill = employeeSkillDAO.findCdEmpSkillFromEmployeeSkillByIdPerson(idPerson);
    ROWCCMN04SOG03_ARRAY rowccmn04sog03_array = new ROWCCMN04SOG03_ARRAY();
    if (employeeSkill != null && !employeeSkill.isEmpty()) {
      Iterator itEmployeeSkill = employeeSkill.iterator();
      while (itEmployeeSkill.hasNext()) {
        EmployeeSkill employeeSkillInfo = (EmployeeSkill) itEmployeeSkill.next();
        ROWCCMN04SOG03 rowccmn04sog03 = new ROWCCMN04SOG03();
        rowccmn04sog03.setSzCdEmpSkill(employeeSkillInfo.getCdEmpSkill());
        rowccmn04sog03_array.addROWCCMN04SOG03(rowccmn04sog03);
      }
    }
    return rowccmn04sog03_array;
  }

  private CCMN04SOG07_ARRAY retrievePersonRace(int idPerson) {
    // Call clss79d
    List<PersonRace> personRace = personRaceDAO.findPersonRaceByIdPerson(idPerson);

    CCMN04SOG07_ARRAY ccmn04sog07_array = new CCMN04SOG07_ARRAY();
    if (personRace != null && !personRace.isEmpty()) {
      for (Iterator<PersonRace> it = personRace.iterator(); it.hasNext();) {
        PersonRace personRaceInfo = it.next();
        CCMN04SOG07 ccmn04sog07 = new CCMN04SOG07();
        ccmn04sog07.setSzCdPersonRace(personRaceInfo.getCdRace());
        ccmn04sog07_array.addCCMN04SOG07(ccmn04sog07);
      }
    }
    return ccmn04sog07_array;
  }

  private CCMN04SOG08_ARRAY retrievePersonEthnicity(int idPerson) {

    // Call clss80d
    List<PersonEthnicity> personEthnicity = personEthnicityDAO.findPersonEthnicityByIdPerson(idPerson);

    CCMN04SOG08_ARRAY ccmn04sog08_array = new CCMN04SOG08_ARRAY();
    if (personEthnicity != null && !personEthnicity.isEmpty()) {
      int personEthnicitySize = 0;
      for (Iterator<PersonEthnicity> it = personEthnicity.iterator(); it.hasNext();) {
        PersonEthnicity personEthnicityInfo = it.next();
        personEthnicitySize++;
        if (personEthnicitySize <= 10) {
          CCMN04SOG08 ccmn04sog08 = new CCMN04SOG08();
          ccmn04sog08.setSzCdPersonEthnicity(personEthnicityInfo.getCdEthnicity());
          ccmn04sog08_array.addCCMN04SOG08(ccmn04sog08);
        }
      }
    }
    return ccmn04sog08_array;
  }

  public ROWCCMN04SOG04 retrieveUnit(int idPerson) throws ServiceException {

    // ccmn39d
    UnitEmpLink unitEmpLink =
            unitEmpLinkDAO.findUnitFromUnitAndUnitEmpLinkByIdPersonCDUnitMemberInOut(idPerson, CodesTables.CUMINOUT_IN);

    if (unitEmpLink == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCCMN04SOG04 rowccmn04sog04 = new ROWCCMN04SOG04();
    rowccmn04sog04.setSzCdUnitMemberInOut(unitEmpLink.getCdUnitMemberInOut());
    rowccmn04sog04.setSzCdUnitMemberRole(unitEmpLink.getCdUnitMemberRole());
    rowccmn04sog04.setSzCdUnitProgram(unitEmpLink.getUnit().getCdUnitProgram());
    rowccmn04sog04.setSzCdCounty(unitEmpLink.getUnit().getCdCounty());
    rowccmn04sog04.setSzCdUnitRegion(unitEmpLink.getUnit().getCdUnitRegion());
    rowccmn04sog04.setUlIdUnit(unitEmpLink.getUnit() != null ? unitEmpLink.getUnit().getIdUnit() : 0);
    rowccmn04sog04.setUlIdUnitEmpLink(unitEmpLink.getIdUnitEmpLink() != null ? unitEmpLink.getIdUnitEmpLink() : 0);
    rowccmn04sog04.setSzNbrUnit(unitEmpLink.getUnit().getNbrUnit());
    // Supervisor information
    rowccmn04sog04.setUlIdPerson(
            unitEmpLink.getPerson() != null ? unitEmpLink.getPerson().getIdPerson() : 0);
    rowccmn04sog04.setSzNmPersonFull(unitEmpLink.getPerson().getNmPersonFull());
    rowccmn04sog04.setTsLastUpdate(unitEmpLink.getDtLastUpdate());

    return rowccmn04sog04;
  }

  private String checkUnitAccess(UlIdPerson_ARRAY_CCMN04SI ulIdPerson_array_ccmn04si, int idUnit) {
    CCMN04UI ccmn04ui = new CCMN04UI();
    // Defualt window mode to inquire
    String szSysCdWinMode = PageModeConstants.INQUIRE;

    UlIdPerson_ARRAY_CCMN04UI ulIdPerson_array_ccmn04ui = new UlIdPerson_ARRAY_CCMN04UI();
    ulIdPerson_array_ccmn04ui.setUlIdPerson(ulIdPerson_array_ccmn04si.getUlIdPerson());
    ulIdPerson_array_ccmn04ui.removeUlIdPerson(0);
    ccmn04ui.setUlIdPerson_ARRAY_CCMN04UI(ulIdPerson_array_ccmn04ui);

    ccmn04ui.setUlIdUnit(idUnit);

    // Determine whether or not a user has access to a unit in inquiry
    //   or modify mode by calling the UnitAccess() common function
    CCMN04UO ccmn04uo = unitAccess.checkForPersonWithUnitAccess(ccmn04ui);
    if (ArchitectureConstants.Y.equals(ccmn04uo.getBSysIndGeneric())) {
      szSysCdWinMode = PageModeConstants.MODIFY;
    }
    return szSysCdWinMode;
  }
  
  public Employee retrieveEmployeeObj(int idPerson) throws ServiceException{
    Employee employee = employeeDAO.findEmployeeByIdPerson(idPerson);
    if (employee == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return employee;
  }

}
