package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.db.UnitEmpLink;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 * This is the DAO class for UNIT_EMP_LINK_DAO
 * 
 * 
 * <pre>
 *  Change History:
 *  Date        User           Description
 *  --------    --------       -------------------------------------------------------------------------------------
 *  05/27/2010  bgehlot        SMS#51977 MR-066 Changes  
 *  08/05/2010  bgehlot        SMS #65398 MR-041 Added methods findRegionalAccountingByCdRegion
 *  11/07/2011  hnguyen        STGAP00017011: MR-092 added findMESProgramAssistantByCdRegion.
 *  02/02/2012  arege          STGAP00017827: MR -085 Added findIdUnitIdPersonCdMemberRoleFromUnitEmpLinkAndUnit
 *  01/26/2012  habraham       STGAP00017829: MR-097 - Added a mehod to fild the Field Program Specialist who has the eligibility criteria not true

 * </pre>
 */

public class UnitEmpLinkDAOImpl extends BaseDAOImpl implements UnitEmpLinkDAO {

  public UnitEmpLink findContractAndContractPeriod(int idPerson, String szCdUnitMemberRole) {
    Query query = getSession().createQuery(
                                           " from UnitEmpLink u " + " where u.cdUnitMemberRole = :szCdUnitMemberRole "
                                                           + "  and u.cdUnitMemberInOut = '" + CodesTables.CUMINOUT_IN
                                                           + "' " + "  and u.person.idPerson = :idPerson ");

    query.setInteger("idPerson", idPerson);
    query.setString("szCdUnitMemberRole", szCdUnitMemberRole);
    return (UnitEmpLink) firstResult(query);
  }


  public UnitEmpLink findUnitEmpLink(int idPerson, String cdUnitMemberInOut) {
    Query query = getSession().createQuery(
                                           " from UnitEmpLink u " + "where u.person.idPerson = :idPerson "
                                                           + "  and u.cdUnitMemberInOut = :cdUnitMemberInOut ");

    query.setInteger("idPerson", idPerson);
    query.setString("cdUnitMemberInOut", cdUnitMemberInOut);
    return (UnitEmpLink) firstResult(query);

  }

  public Integer findIdPersonFromUnitEmpLink(int idPerson, int idUnit, String cdUnitMemberRole,
                                             String sysCdUnitMemberRole) {
    Query query = getSession().createQuery(
                                           " select u.person.idPerson " + "   from UnitEmpLink u "
                                                           + "  where (u.cdUnitMemberRole < :cdUnitMemberRole "
                                                           + "         or u.cdUnitMemberRole  = :sysCdUnitMemberRole) "
                                                           + "    and u.person.idPerson = :idPerson "
                                                           + "    and u.unit.idUnit = :idUnit ");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idUnit", idUnit);
    query.setString("cdUnitMemberRole", cdUnitMemberRole);
    query.setString("sysCdUnitMemberRole", sysCdUnitMemberRole);
    return (Integer) firstResult(query);
  }
 
     //Added for STGAP00017827
     //Retrieves list of person ids for all unit members that belong to nbrUnit, cdUnitRegion and cdCounty
   
  public Map findIdUnitIdPersonCdMemberRoleFromUnitEmpLinkAndUnit(String cdCounty, String cdUnitRegion, String nbrUnit) {  
    Query query = getSession()
                              .createQuery(
                                           " select new map(u.unit.idUnit as idUnit, "
                                                           + "                u.unit.person.idPerson as idPerson, "
                                                           + "                u.cdUnitMemberRole as cdUnitMemberRole ) "
                                                           + "   from UnitEmpLink u "
                                                           + "  where u.unit.cdCounty = :cdCounty "
                                                           + "    and u.unit.cdUnitRegion = :cdUnitRegion "
                                                           + "    and u.unit.nbrUnit = :nbrUnit "
                                                           + "    and u.unit.person.idPerson = u.person.idPerson ");
    query.setString("cdCounty", cdCounty);
    query.setString("cdUnitRegion", cdUnitRegion);
    query.setString("nbrUnit", nbrUnit);
    return (Map) firstResult(query);
  }
  
  public Map findIdUnitIdPersonCdUnitSpecializationFromUnitEmpLinkAndUnit(int idPerson) {
    Query query = getSession()
                              .createQuery(
                                           " select new map(u.unit.idUnit as idUnit, "
                                                           + "                u.unit.person.idPerson as idPerson, "
                                                           + "                u.unit.cdUnitSpecialization as cdUnitSpecialization ) "
                                                           + "   from UnitEmpLink u, Unit un "
                                                           + "  where u.person.idPerson = :idPerson " +
                                                                        " and u.unit.idUnit = un.idUnit " +
                                                                        " and u.cdUnitMemberInOut = :cdUnitMemberIn ");
    query.setInteger("idPerson", idPerson);
    query.setString("cdUnitMemberIn", CodesTables.CUMINOUT_IN);
    return (Map) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> findAllEmployeeUnitEmpLinkByIdUnit(int idUnit) {
    Query query = getSession()
                              .createQuery(
                                           "  select new map(l.person.nmPersonFull as nmPersonFull, "
                                                           + "                 l.employee.empJobHistory.cdJobBjn as cdJobBjn, "
                                                           + "                 l.cdUnitMemberRole as cdUnitMemberRole, "
                                                           + "                 l.cdUnitMemberInOut as cdUnitMemberInOut, "
                                                           + "                 l.person.idPerson as idPerson, "
                                                           + "                 l.idUnitEmpLink as idUnitEmpLink, "
                                                           + "                 l.dtLastUpdate as dtLastUpdate)"
                                                           + "    from UnitEmpLink l "
                                                           + "   where l.unit.idUnit = :idUnit "
                                                           + "order by l.cdUnitMemberRole, "
                                                           + "         l.person.nmPersonFull ");
    query.setInteger("idUnit", idUnit);
    return (List<Map>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<Map> findAllEmployeeUnitEmpLinkAndActiveEmployeeByIdUnit(int idUnit) {
    Query query = getSession()
                              .createQuery(
                                           "  select new map(l.person.nmPersonFull as nmPersonFull, "
                                                           + "                 l.employee.empJobHistory.cdJobBjn as cdJobBjn, "
                                                           + "                 l.cdUnitMemberRole as cdUnitMemberRole, "
                                                           + "                 l.cdUnitMemberInOut as cdUnitMemberInOut, "
                                                           + "                 l.person.idPerson as idPerson, "
                                                           + "                 l.idUnitEmpLink as idUnitEmpLink, "
                                                           + "                 l.dtLastUpdate as dtLastUpdate)"
                                                           + "    from UnitEmpLink l , Employee e"
                                                           + "   where l.unit.idUnit = :idUnit "
                                                           + "    and l.person.idPerson = e.idPerson"
                                                           + "    and e.indEmpActiveStatus = 'Y'"
                                                           + "order by l.cdUnitMemberRole, "
                                                           + "         l.person.nmPersonFull ");
    query.setInteger("idUnit", idUnit);
    return (List<Map>) query.list();
  }  
  
  public Integer findUnitEmpLinkByIdPerson(int idPerson) {

    Query query = getSession().createQuery(
                                           " select a.idUnit" + "   from UnitEmpLink b join b.unit as a"
                                                           + "  where a.person.idPerson = :idPerson"
                                                           + "    and b.cdUnitMemberInOut = 'IN'");

    query.setInteger("idPerson", idPerson);
    return (Integer) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public long countUnitEmpLinkByIdUnit(int idUnit) {

    Query query = getSession().createQuery(
                                           " select count(uml.idUnitEmpLink) " + "   from UnitEmpLink uml "
                                                           + "  where uml.unit.idUnit = :idUnit ");

    query.setInteger("idUnit", idUnit);

    return (Long) query.uniqueResult();
  }

  public UnitEmpLink findUnitEmpLinkByIdPersonAndIdUnit(int idPerson, int idUnit) {
    Query query = getSession().createQuery(
                                           "  from UnitEmpLink u " + " where u.person.idPerson = :idPerson "
                                                           + "   and u.unit.idUnit = :idUnit ");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idUnit", idUnit);
    return (UnitEmpLink) firstResult(query);
  }

  public Map findNmPersonFullAndIdPersonByIdPersonAndCdUnitMemberIn(int idPerson) {
    Query query = getSession().createQuery(
                                           "select new map(a.person.idPerson as idPerson, "
                                                           + "               b.nmPersonFull as nmPersonFull) "
                                                           + "  from UnitEmpLink c " + "       join c.unit a "
                                                           + "       join a.person b "
                                                           + " where c.person.idPerson = :idPerson "
                                                           + "   and c.cdUnitMemberInOut = '" + CodesTables.CUMINOUT_IN
                                                           + "'");
    query.setInteger("idPerson", idPerson);
    return (Map) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> findUnitEmpLinkPrimaryBSPhoneByIdUnit(int idUnit) {
    Query query = getSession()
                              .createQuery(
                                           "    select new map(a.unit.nbrUnit as nbrUnit, "
                                                           + "                   a.employee.nmEmployeeLast as nmEmployeeLast, "
                                                           + "                   a.employee.nmEmployeeFirst as nmEmployeeFirst, "
                                                           + "                   a.employee.nmEmployeeMiddle as nmEmployeeMiddle, "
                                                           + "                   a.employee.cdEmpBjnEmp as cdEmpBjnEmp, "
                                                           + "                   a.employee.dtEmpLastAssigned as dtEmpLastAssigned, "
                                                           + "                   f.nbrPersonPhone as nbrPersonPhone, "
                                                           + "                   f.nbrPersonPhoneExtension as nbrPersonPhoneExtension, "
                                                           + "                   a.employee.office.idOffice as idOffice, "
                                                           + "                   a.unit.idUnit as idUnit, "
                                                           + "                   a.person.idPerson as idPerson )"
                                                           + "      from UnitEmpLink a "
                                                           + " left join a.person.personPhones f "
                                                           + "     where a.employee.indEmpJobAssignCurr = 'Y' "
                                                           + "       and (f.indPersonPhonePrimary = 'Y' or f.indPersonPhonePrimary is null) "
                                                           + "       and (f.cdPersonPhoneType = 'BS' or f.cdPersonPhoneType is null) "
                                                           + "       and (f.dtPersonPhoneEnd = :maxDate or f.dtPersonPhoneEnd is null) "
                                                           + "       and a.unit.idUnit = :idUnit  "
                                                           + "  order by a.unit.nbrUnit,  "
                                                           + "           a.cdUnitMemberInOut,  "
                                                           + "           a.cdUnitMemberRole desc, "
                                                           + "           a.employee.dtEmpLastAssigned ");
    query.setInteger("idUnit", idUnit);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (List<Map>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> findUnitEmpLinkByIdUnit(int idUnit) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(u.person.idPerson as idPerson , "
                                                           + "                e.cdEmpBjnEmp as cdEmpBjnEmp, "
                                                           + "                u.cdUnitMemberInOut as cdUnitMemberInOut, "
                                                           + "                e.nmEmployeeFirst as nmEmployeeFirst, "
                                                           + "                e.nmEmployeeMiddle as nmEmployeeMiddle, "
                                                           + "                e.nmEmployeeLast as nmEmployeeLast) "
                                                           + "    from Employee       e , "
                                                           + "         UnitEmpLink  u "
                                                           + "   where u.unit.idUnit = :idUnit "
                                                           + "     and u.person.idPerson = e.person.idPerson "
                                                           + "order by e.cdEmpBjnEmp ");
    query.setInteger("idUnit", idUnit);
    return (List<Map>) query.list();
  }

  public void saveUnitEmpLink(UnitEmpLink unitEmpLink) {
    getSession().saveOrUpdate(unitEmpLink);
  }
  
  public int updateUnitEmpLink(int idPerson, String cdUnitMemberInOut){
    Query query = getSession().createQuery("update UnitEmpLink "  +  "set nbrInt = :one" 
                                                           + "    where person.idPerson = :idPerson"
                                                           + "    and cdUnitMemberInOut = :cdUnitMemberInOut");
    query.setInteger("idPerson", idPerson);
    query.setString("cdUnitMemberInOut", cdUnitMemberInOut);
    query.setInteger("one", 1);
    return query.executeUpdate();
  }

  public void deleteUnitEmpLink(UnitEmpLink unitEmpLink) {
    getSession().delete(unitEmpLink);
  }

  public int deleteUnitEmpLinkByIdPersonCdUnitMemberInOut(int idPerson, String cdUnitMemberInOut) {
    Query query = getSession().createQuery(
                                           "delete UnitEmpLink" + "  where person.idPerson = :idPerson"
                                                           + "    and cdUnitMemberInOut = :cdUnitMemberInOut");
    query.setInteger("idPerson", idPerson);
    query.setString("cdUnitMemberInOut", cdUnitMemberInOut);
    return query.executeUpdate();
  }

  public UnitEmpLink findUnitFromUnitAndUnitEmpLinkByIdPersonCDUnitMemberInOut(int idPerson, String cdUnitMemberInOut) {

    Query query = getSession().createQuery(
                                           " from UnitEmpLink u " + " join fetch u.unit " + " join fetch u.person "
                                                           + " where      u.person.idPerson = :idPerson "
                                                           + "   and      u.cdUnitMemberInOut = :cdUnitMemberInOut ");

    query.setString("cdUnitMemberInOut", cdUnitMemberInOut);
    query.setInteger("idPerson", idPerson);
    return (UnitEmpLink) firstResult(query);
  }
  
  public Integer findUnitSupervisorByIdPerson(int idPerson){
    Query query = getSession().createQuery("select uel.person.idPerson"
                                           + " from UnitEmpLink uel"
                                           + " where uel.cdUnitMemberRole = '" + CodesTables.CUNMBRRL_40 + "'"
                                           + " and uel.unit.idUnit = (select e.unit.idUnit"
                                           + " from Employee e where e.person.idPerson = :idPerson)");
    query.setInteger("idPerson", idPerson);
    return (Integer) firstResult(query);
  }
  
  @SuppressWarnings("unchecked")
  public List<Unit> findUnitsByIdSupervisor(int idSupervisor) {
    Query query = getSession().createQuery("select uel.unit " +
                                           "  from UnitEmpLink uel " + 
                                           " where uel.cdUnitMemberRole = :cdUnitMemberRole " + 
                                           "   and uel.employee.idPerson = :idSupervisor");
    query.setString("cdUnitMemberRole", CodesTables.CUNMBRRL_40);
    query.setInteger("idSupervisor", idSupervisor);
    return (List<Unit>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<Integer> findUnitMembersInOrOut(int idUnit, String cdUnitMemberInOut) {
    Query query = getSession().createQuery("select distinct uel.person.idPerson " +
                                           "  from UnitEmpLink uel " +
                                           " where uel.unit.idUnit = :idUnit " +
                                           "   and uel.cdUnitMemberInOut = :cdUnitMemberInOut");
    query.setInteger("idUnit", idUnit);
    query.setString("cdUnitMemberInOut", cdUnitMemberInOut);
    return (List<Integer>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<Integer> findUnitMembersInAndOut(int idUnit) {
    Query query = getSession().createQuery("select distinct uel.person.idPerson " +
                                           "  from UnitEmpLink uel " +
                                           " where uel.unit.idUnit = :idUnit");
    query.setInteger("idUnit", idUnit);
    return (List<Integer>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<Integer> findSAUAdoptionSpecSupRegionalMembersByIdRegion(String idRegion){
    SQLQuery query = getSession().createSQLQuery(" SELECT distinct uel.ID_PERSON as idPerson" +
                                            " FROM UNIT_EMP_LINK uel,  UNIT ut " +
                                            " WHERE uel.ID_UNIT = ut.ID_UNIT " +
                                            " AND ut.CD_UNIT_REGION = :idRegion " +
                                            " INTERSECT " +
                                            " select empsc.ID_PERSON from EMP_SEC_CLASS_LINK empsc, SECURITY_CLASS sec " +
                                            " where empsc.CD_SECURITY_CLASS_NAME = sec.CD_SECURITY_CLASS_NAME " +
                                            " AND SUBSTR(sec.TXT_SECURITY_CLASS_PROFIL, 64, 1) = 1 " +
                                            " INTERSECT " +
                                            " select empsc.ID_PERSON from EMP_SEC_CLASS_LINK empsc, SECURITY_CLASS sec " +
                                            " where empsc.CD_SECURITY_CLASS_NAME = sec.CD_SECURITY_CLASS_NAME " +
                                            " AND SUBSTR(sec.TXT_SECURITY_CLASS_PROFIL, 70, 1) = 1 " +
                                            " INTERSECT " +
                                            " select empsc.ID_PERSON from EMP_SEC_CLASS_LINK empsc, SECURITY_CLASS sec " +
                                            " where empsc.CD_SECURITY_CLASS_NAME = sec.CD_SECURITY_CLASS_NAME " +
                                            " AND SUBSTR(sec.TXT_SECURITY_CLASS_PROFIL, 60, 1) = 1 ");
    query.setString("idRegion", idRegion);
    query.addScalar("idPerson", Hibernate.INTEGER);
    return (List<Integer>) query.list();
  }
  
  
  
  @SuppressWarnings("unchecked")
  public List<Integer> findFieldProgramSpecialistByIdRegion(String idRegion){
    SQLQuery query = getSession().createSQLQuery(" select distinct uel.id_person as idPerson "+
                                            " from UNIT_EMP_LINK uel, UNIT ut,  emp_job_history ejh " +
                                            " WHERE uel.id_person  = ejh.id_person " +
                                            " AND  uel.ID_UNIT = ut.ID_UNIT "+
                                            " AND ut.CD_UNIT_REGION = :idRegion " +
                                            " AND ejh.cd_job_title = '14074' "+
                                            " INTERSECT " +
                                            " select empsc.ID_PERSON from EMP_SEC_CLASS_LINK empsc, SECURITY_CLASS sec " +
                                            " where empsc.CD_SECURITY_CLASS_NAME = sec.CD_SECURITY_CLASS_NAME " +
                                            " and SUBSTR(sec.TXT_SECURITY_CLASS_PROFIL, 28, 1) != 1 ") ;
                                            
    query.setString("idRegion", idRegion);
    query.addScalar("idPerson", Hibernate.INTEGER);
    return (List<Integer>) query.list();
  }
  @SuppressWarnings("unchecked")
  public List<Integer> findRegionalAdoptionCoordinatorByIdRegion(String idRegion){
    //txtSecurityClassProfil 93 character is for Regional Adoption Coordinator
    Query query = getSession().createQuery(" select distinct uel.person.idPerson " + 
                                           " from    UnitEmpLink uel, " +
                                           " EmpSecClassLink escl, " +
                                           " SecurityClass sc " +
                                           " where uel.unit.cdUnitRegion = :idRegion " +
                                           " and   uel.person.idPerson = escl.person.idPerson " +
                                           " and   escl.securityClass.cdSecurityClassName = sc.cdSecurityClassName " +
                                           " and   substr(sc.txtSecurityClassProfil, 93,1) = 1 " +
                                           " and   substr(sc.txtSecurityClassProfil, 64,1) = 1 ");
    query.setString("idRegion", idRegion);
    return (List<Integer>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<Integer> findRegionalAdoptionExchangeConsultantByCdRegion(String cdRegion){
    //txtSecurityClassProfil 92 character is for Regional Adoption Consultants
    Query query = getSession().createQuery(" select distinct uel.person.idPerson " + 
                                           " from    UnitEmpLink uel, " +
                                           " EmpSecClassLink escl, " +
                                           " SecurityClass sc " +
                                           " where uel.unit.cdUnitRegion = :cdRegion " +
                                           " and   uel.person.idPerson = escl.person.idPerson " +
                                           " and   escl.securityClass.cdSecurityClassName = sc.cdSecurityClassName " +
                                           " and   substr(sc.txtSecurityClassProfil, 92,1) = 1 ");
    query.setString("cdRegion", cdRegion);
    return (List<Integer>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<Integer> findMESWorkersByIdRegion(String idRegion){
    //txtSecurityClassProfil 77&78 characters are for MES Workers (REG_FAM_IND_MGT and REG_FAM_IND_STF)
    String idSpec = "EFC";
    Query query = getSession().createQuery(" select distinct uel.person.idPerson " +
                                           " from    UnitEmpLink uel, " +
                                           " EmpSecClassLink escl, " +
                                           " SecurityClass sc " +
                                           " where uel.unit.cdUnitRegion = :idRegion " +
                                           " and  uel.unit.cdUnitSpecialization = :idSpec " +
                                           " and   uel.person.idPerson = escl.person.idPerson " +
                                           " and   escl.securityClass.cdSecurityClassName = sc.cdSecurityClassName " +
                                           " and   (substr(sc.txtSecurityClassProfil, 77,1) = 1 " +
                                           " or   substr(sc.txtSecurityClassProfil, 78,1) = 1) ");
    query.setString("idRegion", idRegion);
    query.setString("idSpec", idSpec);
    return (List<Integer>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<Integer> findMESProgramAssistantByCdRegion(String cdRegion){
    //txtSecurityClassProfil 84 character is for MES Program Assistant (MES_PROGRAM_ASSIST)
    String idSpec = "EFC";
    Query query = getSession().createQuery(" select distinct uel.person.idPerson " +
                                           " from    UnitEmpLink uel, " +
                                           " EmpSecClassLink escl, " +
                                           " SecurityClass sc " +
                                           " where uel.unit.cdUnitRegion = :cdRegion " +
                                           " and  uel.unit.cdUnitSpecialization = :idSpec " +
                                           " and   uel.person.idPerson = escl.person.idPerson " +
                                           " and   escl.securityClass.cdSecurityClassName = sc.cdSecurityClassName " +
                                           " and   substr(sc.txtSecurityClassProfil, 84,1) = 1 ");
    query.setString("cdRegion", cdRegion);
    query.setString("idSpec", idSpec);
    return (List<Integer>) query.list();
  }
  
  /**
   * MR-066 Get the list of the Employee with cdSecurityClassName
   * @param cdSecurityClassName
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<Integer> findEmployeeByCdSecurityClassName(String cdSecurityClassName){
    Query query = getSession().createQuery(" select distinct uel.person.idPerson " + 
                                           " from    UnitEmpLink uel, " +
                                           " EmpSecClassLink escl, " +
                                           " SecurityClass sc " +
                                           " where uel.person.idPerson = escl.person.idPerson " +
                                           " and   escl.securityClass.cdSecurityClassName = :cdSecurityClassName " );
    query.setString("cdSecurityClassName", cdSecurityClassName);
    return (List<Integer>) query.list();
  }
  
  /**
   * MR-041: Get the list of Regional Accounting persons by region
   * @param cdRegion
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<Integer> findRegionalAccountingByCdRegion(String cdRegion){
    //txtSecurityClassProfil 75 character is for Regional Accounting Staff
    //txtSecurityClassProfil 76 character is for Regional Accounting Management Staff
    Query query = getSession().createQuery(" select distinct uel.person.idPerson " + 
                                           " from    UnitEmpLink uel, " +
                                           " EmpSecClassLink escl, " +
                                           " SecurityClass sc " +
                                           " where uel.unit.cdUnitRegion = :cdRegion " +
                                           " and   uel.person.idPerson = escl.person.idPerson " +
                                           " and   escl.securityClass.cdSecurityClassName = sc.cdSecurityClassName " +
                                           " and   ( substr(sc.txtSecurityClassProfil, 75,1) = 1 " +
                                           " or   substr(sc.txtSecurityClassProfil, 76,1) = 1) ");
    query.setString("cdRegion", cdRegion);
    return (List<Integer>) query.list();
  }
  
  /**
   * 
   * @param nbrUnit
   * @param cdUnitRegion
   * @param cdCounty
   * @return
   */
  //Added for STGAP00017827
  @SuppressWarnings("unchecked")
   public List<Integer> findUnitMembersInAndOutByNbrUnitAndCdRegionAndCdCounty(String nbrUnit, String cdUnitRegion, String cdCounty) {
   Query query = getSession().createQuery("select distinct uel.person.idPerson " +
                                               "  from UnitEmpLink uel " 
                                               + "  where uel.unit.cdCounty = :cdCounty "
                                               + "    and uel.unit.cdUnitRegion = :cdUnitRegion "
                                               + "    and uel.unit.nbrUnit = :nbrUnit " );
    query.setString("cdCounty", cdCounty);
    query.setString("cdUnitRegion", cdUnitRegion);
    query.setString("nbrUnit", nbrUnit);
    return (List<Integer>) query.list();
      }
}
