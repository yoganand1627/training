package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class EmployeeDAOImpl extends BaseDAOImpl implements EmployeeDAO {
  public Employee findEmployeeByIdPerson(int idPerson) {
    Query query = getSession().createQuery(" from Employee e " +
                                           "where e.idPerson = :idPerson ");
    query.setInteger("idPerson", idPerson);
    return (Employee) firstResult(query);
  }

  public long countEmployeesByIdPerson(int idPerson) {
    Query query = getSession().createQuery("select count(*) " +
                                           "  from Employee e " +
                                           " where e.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (Long) query.uniqueResult();
  }

  public Map findEmployeeLogonDetailByIdEmployeeLogon(String idEmployeeLogon) {
    Query query = getSession().createQuery("select new map (e.idEmployeeLogon as idEmployeeLogon, " +
                                           "                e.cdEmployeeClass as cdEmployeeClass, " +
                                           "                p.idPerson as idPerson, " +
                                           "                p.nmPersonFull as nmPersonFull, " +
                                           "                u.cdUnitRegion as cdUnitRegion, " +
                                           "                m.addrMailCodeCity as addrMailCodeCity, " +
                                           "                o.idOffice as idOffice, " +
                                           "                u.nbrUnit as nbrUnit, " +
                                           "                u.cdUnitProgram as cdUnitProgram, " +
                                           "                u.cdCounty as cdCounty) " +
                                           "   from Employee e, " +
                                           "        Unit u, " +
                                           "        UnitEmpLink uel " +
                                           "   join e.person p " +
                                           "   join e.office o " +
                                           "   join o.mailCode m " +
                                           "  where e.idEmployeeLogon = :idEmployeeLogon " +
                                           "    and uel.person.idPerson = e.person.idPerson " +
                                           "    and uel.cdUnitMemberInOut = 'IN' " +
                                           "    and u.idUnit = uel.unit.idUnit");
    query.setString("idEmployeeLogon", idEmployeeLogon);
    return (Map) firstResult(query);
  }

  public Integer findIdPersonFromEmployee(String cdPersonIdType, String nbrPersonIdNumber, Date maxDate) {
    Query query = getSession().createQuery("select b.person.idPerson " +
                                           "  from PersonId a, " +
                                           "       Employee b " +
                                           " where a.cdPersonIdType = :cdPersonIdType " +
                                           "   and a.nbrPersonIdNumber = :nbrPersonIdNumber " +
                                           "   and b.person.idPerson = a.person.idPerson " +
                                           "   and a.dtPersonIdEnd = :maxDate ");
    query.setString("cdPersonIdType", cdPersonIdType);
    query.setString("nbrPersonIdNumber", nbrPersonIdNumber);
    query.setTimestamp("maxDate", maxDate);
    return (Integer) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<Map> findEmployeeDetailsByStage(int pageNbr, int pageSize,
                                                                Collection<Integer> idStages) {
    Query query = getSession().createQuery("select distinct new map(p.nmPersonFull as nmPersonFull, " +
                                           "                        p.idPerson as idPerson, " +
                                           "                        ejh.cdJobBjn as cdJobBjn, " +
                                           "                        mc.addrMailCodeStLn1 as addrMailCodeStLn1, " +
                                           "                        mc.addrMailCodeStLn2 as addrMailCodeStLn2, " +
                                           "                        mc.addrMailCodeCity as addrMailCodeCity, " +
                                           "                        e.cdEmployeeClass as cdEmployeeClass, " +
                                           "                        e.dtEmpLastAssigned as dtEmpLastAssigned, " +
                                           "                        u.nbrUnit as nbrUnit, " +
                                           "                        u.cdUnitRegion as cdUnitRegion, " +
                                           "                        u.idUnit as idUnit, " +
                                           "                        uel.cdUnitMemberRole as cdUnitMemberRole, " +
                                           "                        o.idOffice as idOffice, " +
                                           "                        mc.cdMailCode as cdMailCode) " +
                                           "  from Person p, " +
                                           "       EmpJobHistory ejh, " +
                                           "       MailCode mc, " +
                                           "       Employee e, " +
                                           "       Event evt, " +
                                           "       Unit u, " +
                                           "       UnitEmpLink uel, " +
                                           "       Office o " +
                                           " where p.idPerson = e.idPerson " +
                                           "   and uel.person.idPerson = e.idPerson " +
                                           "   and ejh.personByIdPerson.idPerson = e.idPerson " +
                                           "   and ejh.idEmpJobHistory = e.empJobHistory.idEmpJobHistory " +
                                           "   and p.idPerson = evt.person.idPerson " +
                                           "   and uel.cdUnitMemberInOut = 'IN' " +
                                           "   and uel.unit.idUnit = u.idUnit " +
                                           "   and o.idOffice = e.office.idOffice " +
                                           "   and mc.cdMailCode = o.mailCode.cdMailCode " +
                                           "   and evt.person.idPerson = p.idPerson " +
                                           "   and evt.stage.idStage in (:idStages)");
    query.setParameterList("idStages", idStages);
    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, query);
  }

  public int updateEmployeeDtLastLogon(String idEmployeeLogon, Date dtLastLogin) {
    // This field does not trigger the audit insert, so idEmployeeModifiedBy is not necessary.
    Query query = getSession().createQuery("update Employee e " +
                                           "   set e.dtLastLogin = :dtLastLogin " +
                                           " where e.idEmployeeLogon = :idEmployeeLogon");
    query.setString("idEmployeeLogon", idEmployeeLogon);
    query.setTimestamp("dtLastLogin", dtLastLogin);
    return query.executeUpdate();
  }

  public int insertEmployee(int idPerson, int nbrEmpActivePct, Date dtEmpHire, int idEmpJobHistory,
                            String idEmployeeLogon, String cdEmployeeClass, int idOffice, Date dtEmpLastAssigned,
                            String cdEmpProgram, String indEmpConfirmedHrmis, String indEmpPendingHrmis,
                            String indActiveStatus, Date dtEmpTermination, int idEmployeeModifiedBy) {
    SQLQuery query = getSession().createSQLQuery(" INSERT INTO EMPLOYEE (ID_PERSON, " +
                                                 "                       NBR_EMP_ACTIVE_PCT, " +
                                                 "                       DT_EMP_HIRE, " +
                                                 "                       ID_EMP_JOB_HISTORY, " +
                                                 "                       ID_EMPLOYEE_LOGON, " +
                                                 "                       CD_EMPLOYEE_CLASS, " +
                                                 "                       ID_EMP_OFFICE, " +
                                                 "                       DT_EMP_LAST_ASSIGNED, " +
                                                 "                       CD_EMP_PROGRAM, " +
                                                 "                       IND_EMP_CONFIRMED_HRMIS, " +
                                                 "                       IND_EMP_PENDING_HRMIS, " +
                                                 "                       IND_EMP_ACTIVE_STATUS, " +
                                                 "                       DT_EMP_TERMINATION, " +
                                                 "                       ID_PERSON_MODIFIED_BY) " +
                                                 "                VALUES(:idPerson, " +
                                                 "                       :nbrEmpActivePct, " +
                                                 "                       :dtEmpHire, " +
                                                 "                       :idEmpJobHistory, " +
                                                 "                       :idEmployeeLogon, " +
                                                 "                       :cdEmployeeClass, " +
                                                 "                       :idOffice, " +
                                                 "                       :dtEmpLastAssigned, " +
                                                 "                       :cdEmpProgram, " +
                                                 "                       :indEmpConfirmedHrmis, " +
                                                 "                       :indEmpPendingHrmis, " +
                                                 "                       :indActiveStatus, " +
                                                 "                       :dtEmpTermination, " +
                                                 "                       :idEmployeeModifiedBy)");
    query.setInteger("idPerson", idPerson);
    query.setInteger("nbrEmpActivePct", nbrEmpActivePct);
    query.setTimestamp("dtEmpHire", dtEmpHire);
    query.setInteger("idEmpJobHistory", idEmpJobHistory);
    query.setString("idEmployeeLogon", idEmployeeLogon);
    query.setString("cdEmployeeClass", cdEmployeeClass);
    query.setInteger("idOffice", idOffice);
    query.setTimestamp("dtEmpLastAssigned", dtEmpLastAssigned);
    query.setString("cdEmpProgram", cdEmpProgram);
    query.setString("indEmpConfirmedHrmis", indEmpConfirmedHrmis);
    query.setString("indEmpPendingHrmis", indEmpPendingHrmis);
    query.setString("indActiveStatus", indActiveStatus);
    query.setTimestamp("dtEmpTermination", dtEmpTermination);
    query.setInteger("idEmployeeModifiedBy", idEmployeeModifiedBy);
    return query.executeUpdate();
  }

  public int updateEmployee(int idPerson, int nbrEmpActivePct, Date dtEmpHire, int idEmpJobHistory,
                            String idEmployeeLogon, String cdEmployeeClass, int idOffice, Date dtEmpLastAssigned,
                            String cdEmpProgram, String indEmpConfirmedHrmis, String indEmpPendingHrmis,
                            String indActiveStatus, Date dtEmpTermination, Date dtLastUpdate,
                            int idEmployeeModifiedBy) {
    Query query = getSession().createQuery("update Employee e " +
                                           "   set e.idPerson = :idPerson, " +
                                           "       e.nbrEmpActivePct = :nbrEmpActivePct, " +
                                           "       e.dtEmpHire = :dtEmpHire, " +
                                           "       e.empJobHistory.idEmpJobHistory = :idEmpJobHistory, " +
                                           "       e.idEmployeeLogon = :idEmployeeLogon, " +
                                           "       e.cdEmployeeClass = :cdEmployeeClass, " +
                                           "       e.office.idOffice = :idOffice, " +
                                           "       e.dtEmpLastAssigned = :dtEmpLastAssigned, " +
                                           "       e.cdEmpProgram = :cdEmpProgram, " +
                                           "       e.indEmpConfirmedHrmis = :indEmpConfirmedHrmis, " +
                                           "       e.indEmpPendingHrmis = :indEmpPendingHrmis, " +
                                           "       e.indEmpActiveStatus = :indActiveStatus, " +
                                           "       e.dtEmpTermination = :dtEmpTermination, " +
                                           "       e.employee.idPerson = :idEmployeeModifiedBy " +
                                           " where e.dtLastUpdate = :dtLastUpdate " +
                                           "   and e.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    query.setInteger("nbrEmpActivePct", nbrEmpActivePct);
    query.setTimestamp("dtEmpHire", dtEmpHire);
    query.setInteger("idEmpJobHistory", idEmpJobHistory);
    query.setString("idEmployeeLogon", idEmployeeLogon);
    query.setString("cdEmployeeClass", cdEmployeeClass);
    query.setInteger("idOffice", idOffice);
    query.setTimestamp("dtEmpLastAssigned", dtEmpLastAssigned);
    query.setString("cdEmpProgram", cdEmpProgram);
    query.setString("indEmpConfirmedHrmis", indEmpConfirmedHrmis);
    query.setString("indEmpPendingHrmis", indEmpPendingHrmis);
    query.setString("indActiveStatus", indActiveStatus);
    query.setTimestamp("dtEmpTermination", dtEmpTermination);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    query.setInteger("idEmployeeModifiedBy", idEmployeeModifiedBy);
    return query.executeUpdate();
  }

  public int updateTerminatedEmployee(int idPerson, int nbrEmpActivePct, Date dtEmpHire, int idEmpJobHistory,
                            String idEmployeeLogon, String cdEmployeeClass, int idOffice, Date dtEmpLastAssigned,
                            String cdEmpProgram, String indEmpConfirmedHrmis, String indEmpPendingHrmis,
                            String indActiveStatus, Date dtEmpTermination, Date dtLastUpdate,
                            int idEmployeeModifiedBy, String indEmpJobAssignCurr) {
    Query query = getSession().createQuery("update Employee e " +
                                           "   set e.idPerson = :idPerson, " +
                                           "       e.nbrEmpActivePct = :nbrEmpActivePct, " +
                                           "       e.dtEmpHire = :dtEmpHire, " +
                                           "       e.empJobHistory.idEmpJobHistory = :idEmpJobHistory, " +
                                           "       e.idEmployeeLogon = :idEmployeeLogon, " +
                                           "       e.cdEmployeeClass = :cdEmployeeClass, " +
                                           "       e.office.idOffice = :idOffice, " +
                                           "       e.dtEmpLastAssigned = :dtEmpLastAssigned, " +
                                           "       e.cdEmpProgram = :cdEmpProgram, " +
                                           "       e.indEmpConfirmedHrmis = :indEmpConfirmedHrmis, " +
                                           "       e.indEmpPendingHrmis = :indEmpPendingHrmis, " +
                                           "       e.indEmpActiveStatus = :indActiveStatus, " +
                                           "       e.dtEmpTermination = :dtEmpTermination, " +
                                           "       e.employee.idPerson = :idEmployeeModifiedBy, " +
                                           "       e.indEmpJobAssignCurr = :indEmpJobAssignCurr " +
                                           " where e.dtLastUpdate = :dtLastUpdate " +
                                           "   and e.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    query.setInteger("nbrEmpActivePct", nbrEmpActivePct);
    query.setTimestamp("dtEmpHire", dtEmpHire);
    query.setInteger("idEmpJobHistory", idEmpJobHistory);
    query.setString("idEmployeeLogon", idEmployeeLogon);
    query.setString("cdEmployeeClass", cdEmployeeClass);
    query.setInteger("idOffice", idOffice);
    query.setTimestamp("dtEmpLastAssigned", dtEmpLastAssigned);
    query.setString("cdEmpProgram", cdEmpProgram);
    query.setString("indEmpConfirmedHrmis", indEmpConfirmedHrmis);
    query.setString("indEmpPendingHrmis", indEmpPendingHrmis);
    query.setString("indActiveStatus", indActiveStatus);
    query.setTimestamp("dtEmpTermination", dtEmpTermination);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    query.setInteger("idEmployeeModifiedBy", idEmployeeModifiedBy);
    query.setString("indEmpJobAssignCurr", indEmpJobAssignCurr);
    return query.executeUpdate();
  }

  public int updateDtEmpLastAssigned(int idPerson, int idEmployeeModifiedBy) {
    Query query = getSession().createQuery("update Employee e " +
                                           "   set e.dtEmpLastAssigned = sysdate, " +
                                           "       e.employee.idPerson = :idEmployeeModifiedBy " +
                                           " where e.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idEmployeeModifiedBy", idEmployeeModifiedBy);
    return query.executeUpdate();
  }

  public int updateDtEmpLastAssigned(int idPerson, Date dtEmpLastAssigned, int idEmployeeModifiedBy) {
    Query query = getSession().createQuery("update Employee e " +
                                           "   set e.dtEmpLastAssigned = :dtEmpLastAssigned, " +
                                           "       e.employee.idPerson = :idEmployeeModifiedBy " +
                                           " where e.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idEmployeeModifiedBy", idEmployeeModifiedBy);
    query.setTimestamp("dtEmpLastAssigned", dtEmpLastAssigned);
    return query.executeUpdate();
  }

  public int updateEmployeeByIdPersonAndDtLastUpdate(String idEmployeeLogon, Date lastUpdate,
                                                     int idPerson,
                                                     int idEmployeeModifiedBy) {
    Query query = getSession().createQuery("update Employee e " +
                                           "   set e.idEmployeeLogon = :idEmployeeLogon, " +
                                           "       e.employee.idPerson = :idEmployeeModifiedBy " +
                                           " where e.dtLastUpdate = :lastUpdate " +
                                           "   and e.person.idPerson = :idPerson ");
    query.setString("idEmployeeLogon", idEmployeeLogon);
    query.setInteger("idEmployeeModifiedBy", idEmployeeModifiedBy);
    query.setTimestamp("lastUpdate", lastUpdate);
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }
  
  public void saveEmployee(Employee employee) {
    getSession().saveOrUpdate(employee);
  }

  public int deleteEmployee(int idPerson) {
    SQLQuery query = getSession().createSQLQuery("CALL COMPLEX_DELETE.DELETE_EMPLOYEE(:idPerson)");
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }

  public Object[] findEmployeeInfoByIdPerson(int idPerson) {
    SQLQuery query = getSession().createSQLQuery("SELECT E.ID_PERSON, " +
                                                 "       E.NBR_EMP_ACTIVE_PCT, " +
                                                 "       E.DT_EMP_HIRE, " +
                                                 "       E.ID_EMP_JOB_HISTORY, " +
                                                 "       E.ID_EMPLOYEE_LOGON, " +
                                                 "       E.CD_EMPLOYEE_CLASS, " +
                                                 "       E.CD_EMP_SECURITY_CLASS_NM, " +
                                                 "       E.ID_EMP_OFFICE, " +
                                                 "       E.DT_EMP_LAST_ASSIGNED, " +
                                                 "       E.CD_EMP_PROGRAM, " +
                                                 "       E.IND_EMP_CONFIRMED_HRMIS, " +
                                                 "       E.IND_EMP_PENDING_HRMIS, " +
                                                 "       E.IND_EMP_ACTIVE_STATUS, " +
                                                 "       E.DT_EMP_TERMINATION, " +
                                                 "       EJH.ID_JOB_PERS_SUPV, " +
                                                 "       EJH.CD_JOB_CLASS, " +
                                                 "       EJH.IND_JOB_ASSIGNABLE, " +
                                                 "       EJH.CD_JOB_FUNCTION, " +
                                                 "       EJH.CD_JOB_BJN, " +
                                                 "       EJH.DT_JOB_END, " +
                                                 "       EJH.DT_JOB_START, " +
                                                 "       O.CD_OFFICE_MAIL, " +
                                                 "       O.CD_OFFICE_PROGRAM, " +
                                                 "       O.CD_OFFICE_REGION, " +
                                                 "       O.NM_OFFICE_NAME, " +
                                                 "       MC.NBR_MAIL_CODE_PHONE, " +
                                                 "       MC.NBR_MAIL_CODE_PHONE_EXT, " +
                                                 "       MC.ADDR_MAIL_CODE_ST_LN_1, " +
                                                 "       MC.ADDR_MAIL_CODE_ST_LN_2, " +
                                                 "       MC.ADDR_MAIL_CODE_CITY, " +
                                                 "       MC.ADDR_MAIL_CODE_ZIP, " +
                                                 "       MC.ADDR_MAIL_CODE_COUNTY, " +
                                                 "       MC.IND_MAIL_CODE_INVALID, " +
                                                 "       PP.ID_PERSON_PHONE, " +
                                                 "       PP.TXT_PERSON_PHONE_COMMENTS, " +
                                                 "       PP.NBR_PERSON_PHONE_EXTENSION, " +
                                                 "       PP.NBR_PERSON_PHONE, " +
                                                 "       PP.DT_PERSON_PHONE_START, " +
                                                 "       PP.DT_PERSON_PHONE_END, " +
                                                 "       PP.IND_PERSON_PHONE_INVALID, " +
                                                 "       PP.IND_PERSON_PHONE_PRIMARY, " +
                                                 "       PP.CD_PERSON_PHONE_TYPE, " +
                                                 "       N.ID_NAME, " +
                                                 "       N.IND_NAME_INVALID, " +
                                                 "       N.NM_NAME_FIRST, " +
                                                 "       N.NM_NAME_MIDDLE, " +
                                                 "       N.NM_NAME_LAST, " +
                                                 "       N.IND_NAME_PRIMARY, " +
                                                 "       N.CD_NAME_SUFFIX, " +
                                                 "       N.DT_NAME_START_DATE, " +
                                                 "       N.DT_NAME_END_DATE " +
                                                 "  FROM NAME N, " +
                                                 "       PERSON_PHONE PP, " +
                                                 "       MAIL_CODE MC, " +
                                                 "       OFFICE O, " +
                                                 "       EMP_JOB_HISTORY EJH, " +
                                                 "       EMPLOYEE E " +
                                                 " WHERE E.ID_PERSON = :idPerson " +
                                                 "   AND E.ID_PERSON = N.ID_PERSON(+) " +
                                                 "   AND N.IND_NAME_PRIMARY = 'Y' " +
                                                 "   AND N.DT_NAME_END_DATE = :maxDate " +
                                                 "   AND E.ID_PERSON = PP.ID_PERSON(+) " +
                                                 "   AND PP.IND_PERSON_PHONE_PRIMARY(+) = 'Y' " +
                                                 "   AND PP.DT_PERSON_PHONE_END (+) = :maxDate " +
                                                 "   AND E.ID_PERSON = EJH.ID_PERSON(+) " +
                                                 "   AND NVL(EJH.DT_JOB_END, :maxDate ) = (SELECT " +
                                                 "                                         NVL(MAX(EJH2.DT_JOB_END), :maxDate ) " +
                                                 "                                         FROM EMP_JOB_HISTORY EJH2 " +
                                                 "                                         WHERE E.ID_PERSON = EJH2.ID_PERSON(+)) " +
                                                 "   AND E.ID_EMP_OFFICE = O.ID_OFFICE (+) " +
                                                 "   AND O.CD_OFFICE_MAIL = MC.CD_MAIL_CODE (+)");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Object[]) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdPersonByJobSecurityRole(String cdCounty, Collection<String> cdSecurityList) {
    Query query = getSession().createQuery("select e.idPerson " +
                                           "  from EmpSecClassLink es , " +
                                           "       Employee e " +
                                           " where e.unit.cdCounty =:cdCounty " +
                                           "   and e.idPerson=es.person.idPerson " +
                                           "   and es.securityClass.cdSecurityClassName in (:cdSecurityList)");
    query.setString("cdCounty", cdCounty);
    query.setParameterList("cdSecurityList", cdSecurityList);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdPersonByJobSecurityRolesAndRegion(String cdRegion, Collection cdSecurityList) {
    Query query = getSession().createQuery("select e.idPerson " +
                                           "  from EmpSecClassLink es , " +
                                           "       Employee e " +
                                           " where e.unit.cdUnitRegion =:cdRegion " +
                                           "   and e.idPerson=es.person.idPerson " +
                                           "   and es.securityClass.cdSecurityClassName in (:cdSecurityList)");
    query.setString("cdRegion", cdRegion);
    query.setParameterList("cdSecurityList", cdSecurityList);
    return (List<Integer>) query.list();
  }

  public Integer findIdPersonByIdCaseAndCdClass(int idCase, String cdEmployeeClass) {
    Query query = getSession().createQuery("select e.person.idPerson "
                                           + "from Employee e "
                                           + "where e.cdEmployeeClass = :cdEmployeeClass "
                                           + "and e.unit.cdCounty = (select c.cdCaseCounty "
                                           + "from CapsCase c where c.idCase = :idCase)");
    query.setInteger("idCase", idCase);
    query.setString("cdEmployeeClass", cdEmployeeClass);
    return (Integer) firstResult(query);
  }

  public Integer findIdPersonByIdStageAndCdClass(int idStage, String cdEmployeeClass) {
    Query query = getSession().createQuery("select e.person.idPerson "
                                           + "from Employee e "
                                           + "where e.cdEmployeeClass = :cdEmployeeClass "
                                           + "and e.unit.cdCounty = (select s.cdStageCnty "
                                           + "from Stage s where s.idStage = :idStage)");
    query.setInteger("idStage", idStage);
    query.setString("cdEmployeeClass", cdEmployeeClass);
    return (Integer) firstResult(query);
  }
  
  public String findEmployeeRacfIdWithLoginId(int loginId) {
    Query query = getSession().createQuery(" select e.idRacf from Employee e "
                                           + "where e.idPerson = :idEmployeeLogon)");
    query.setInteger("idEmployeeLogon", loginId);
    return (String) firstResult(query);
  }
 
  //STGAP00007159: Added new SQLs
  //Begin
  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdPersonByCdRegionAndCdEmpClass(String cdRegion, Collection cdEmployeeClassList) {
    Query query = getSession().createQuery("select e.person.idPerson "
                                           + "from Employee e "
                                           + "where e.unit.cdUnitRegion = :cdRegion "
                                           + "and e.cdEmployeeClass in (:cdEmployeeClassList) ");
    query.setString("cdRegion", cdRegion);
    query.setParameterList("cdEmployeeClassList", cdEmployeeClassList);
    return (List<Integer>) query.list();
  }
  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdPersonBycdCountyAndCdEmpClass(String cdCounty, Collection cdEmployeeClassList) {
    Query query = getSession().createQuery("select e.person.idPerson "
                                           + "from Employee e "
                                           + "where e.unit.cdCounty = :cdCounty "
                                           + "and e.cdEmployeeClass in (:cdEmployeeClassList) ");
    query.setString("cdCounty", cdCounty);
    query.setParameterList("cdEmployeeClassList", cdEmployeeClassList);
    return (List<Integer>) query.list();
  }
  //STGAP00007159:End
  //STGAP00007525:Added new SQL
  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdPersonByAndCdEmpClass(String cdEmployeeClass) {
    Query query = getSession().createQuery("select e.person.idPerson "
                                           + "from Employee e "
                                           + "where e.cdEmployeeClass = :cdEmployeeClass ");
    query.setString("cdEmployeeClass", cdEmployeeClass);
    return (List<Integer>) query.list();
  }

}
