/**
 * Created on Feb 19, 2006 at 10:55:11 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Characteristics;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.Name;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/*Change History:
Date        User              Description
--------    ----------------  --------------------------------------------------
12/31/08    charden           rewrote methods findPersonBySsn(), findPersonsByPersonIdByNbrAndType() and
                              findPersonsByPersonIdByNbrMedicaid() as native SQL queries. Called encrypt
                              function on encrypted column values to address code performance issues.
05/15/09    hjbaptiste        STGAP00013455: Removed the gender parameter in findMinAgeMaxAgeInSiblingGrpByIdSiblingGrp()
06/29/2009  bgehlot           STGAP00014329: Added method findCurrentAgeOver18Person
08/05/2009  arege             STGAP00014774: Added this method for Initial Medicaid Application Page
10/25/09    mxpatel           38626: modified findPersonsByIdPersons method to retrieve person data and added
                              findIdPersonAddressByIdPerson method. Changed cdPersonCounty to cdPersonAddrCounty to display 
                              county in the search results.
06/04/2010  mxpatel           MR-066.1:  added code to capture and store SSN number when adding a new person.  
11/10/2010  schoi             SMS #81140: MR-074 Added two new fields in updatePerson method    
06/09/2011  cwells            CAPTA 4.3 Policy changed to view Children 17 and over instead of 18 and over. 
10/08/2011  schoi             STGAP00017013: MR-095 Added new method findMostRecentPersonByIdPerson
10/12/2011  hjbaptiste        MR-092: Fostering Connection - Updated updatePerson to include new column added
                              called indIvePriorAdoption
10/14/2011  schoi             STGAP00017194: MR-095 Added new method findPersonByFirstNameLastName
10/26/2011  hnguyen           STGAP00017378: MR-094 Added findIdPrimaryChildWithOpenSubAdoFromPrnsList.                              
02/03/2012  aavila			  STGAP00017872: MR-072 Added findNmLastFirstByIdPerson.                              
                         
*/

public class PersonDAOImpl extends BaseDAOImpl implements PersonDAO {
  public String findNmFullByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
                                           "select p.nmPersonFull " + "  from Person p "
                                                           + " where p.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (String) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<String> findNmFullByIdPersons(Collection<Integer> idPersons) {
    Query query = getSession().createQuery(
                                           "select p.nmPersonFull " + "  from Person p "
                                                           + " where p.idPerson in (:idPersons)");
    query.setParameterList("idPersons", idPersons);
    return (List<String>) query.list();
  }   

  public String findSMILEClientByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
                                           "select p.cdSmileClient " + "  from Person p "
                                                           + " where p.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (String) firstResult(query);
  }

  public Date findDateOfBirthByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
                                           "select p.dtPersonBirth " + "  from Person p "
                                                           + " where p.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (Date) firstResult(query);
  }



  public String findProofOfCitizenshipByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
                                           "select p.cdPersonProofCitizenship " + "  from Person p "
                                                           + " where p.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (String) firstResult(query);
  }

  public Map findPersonByStagePersonLink(int idStage) {
    Query query = getSession().createQuery(
                                           "select new map(b.idPerson as idPerson, "
                                                           + "               b.nmPersonFull as nmPersonFull, "
                                                           + "               c.cdStage as cdStage, "
                                                           + "               c.cdStageProgram as cdStageProgram) "
                                                           + "   from Person b, " + "        Stage c, "
                                                           + "        StagePersonLink a "
                                                           + "  where a.stage.idStage = :idStage "
                                                           + "    and a.cdStagePersRole = :cdStagePersRole "
                                                           + "    and b.idPerson = a.person.idPerson "
                                                           + "    and c.idStage = a.stage.idStage");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRole", CodesTables.CROLEALL_PR);
    return (Map) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findPersonByPersonCategoryByPersonList(Collection<Integer> idPersons, String cdPersonCategory) {
    Query query = getSession().createQuery(" SELECT p.idPerson FROM Person p " +
                " WHERE p.idPerson IN (:idPersons) AND  " +
                " 0 < (select count (*) from PersonCategory pc " +
                                           " where pc.person.idPerson = p.idPerson " +
                                           " and pc.cdPersonCategory = :cdPersonCategory)");
      query.setString("cdPersonCategory", cdPersonCategory);
      query.setParameterList("idPersons", idPersons);
      return (List<Integer>) query.list();
  }


  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Map> findPersonsByStagePersonLinkByIdStage(int idStage, int pageNbr, int pageSize) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(p.idPerson as idPerson, "
                                                           + "               p.nmPersonFull as nmPersonFull, "
                                                           + "                        p.nmPersonFirst as nmPersonFirst, "
                                                           + "                        p.nmPersonLast as nmPersonLast, "
                                                           + "                        p.nmPersonMiddle as nmPersonMiddle, "
                                                           + "                        p.dtPersonDeath as dtPersonDeath, "
                                                           + "                        p.dtPersonBirth as dtPersonBirth, "
                                                           + "                        p.nbrPersonIdNumber as ssn, "
                                                           + "                        p.cdPersonEthnicGroup as cdPersonEthnicGroup, "
                                                           + "                        p.cdPersonCounty as cdPersonAddrCounty, "
                                                           + "                        p.cdPersonState as cdPersonState, "
                                                           + "                        p.addrPersonStLn1 as addrPersonStLn1, "
                                                           + "                        p.addrPersonCity as addrPersonCity, "
                                                           + "                        p.addrPersonZip as addrPersonZip, "
                                                           + "                        p.cdPersonSex as cdPersonSex,  "
                                                           + "                        p.cdPersonEthnicGroup as cdPersonEthnicGroup,  "
                                                           + "                        p.cdPersonStatus as cdPersonStatus,  "
                                                           + "                        p.indPersonDobApprox as indPersonDobApprox)  "
                                                           + "   from Person p, " + "        StagePersonLink spl "
                                                           + "  where spl.stage.idStage = :idStage "
                                                           + "    and p.idPerson = spl.person.idPerson ");
    query.setInteger("idStage", idStage);
    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, query);
  }

  @SuppressWarnings( { "unchecked" })
  public Query findPersonsByPersonIdByNbrMedicaid(int nbrMedicaid, int pageNbr, int pageSize) {
    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 "select p.id_Person as idPerson, "
                                                                 + "               p.nm_Person_Full as nmPersonFull, "
                                                                 + "               p.nm_Person_First as nmPersonFirst, "
                                                                 + "               p.nm_Person_Last as nmPersonLast, "
                                                                 + "               p.nm_Person_Middle as nmPersonMiddle, "
                                                                 + "               p.dt_Person_Death as dtPersonDeath, "
                                                                 + "               p.dt_Person_Birth as dtPersonBirth, "
                                                                 + "               p.nbr_Person_Id_Number as ssn, "
                                                                 + "               p.cd_Person_Ethnic_Group as cdPersonEthnicGroup, "
                                                                 + "               p.cd_Person_County as cdPersonCounty, "
                                                                 + "               p.cd_Person_State as cdPersonState, "
                                                                 + "               p.addr_Person_St_Ln_1 as addrPersonStLn1, "
                                                                 + "               p.addr_Person_City as addrPersonCity, "
                                                                 + "               p.addr_Person_Zip as addrPersonZip, "
                                                                 + "               p.cd_Person_Sex as cdPersonSex,  "
                                                                 + "               p.cd_Person_Status as cdPersonStatus,  "
                                                                 + "               p.ind_Person_Dob_Approx as indPersonDobApprox  "
                                                                 + "  from Person_Id_enc pi "
                                                                 + "  join person_enc p on pi.id_person = p.id_person "
                                                                 + "  where pi.nbr_Person_Id_Number = encrypt(:nbrMedicaid) "
                                                                 + "  and pi.cd_Person_Id_Type = :cdPersonIdType ");
    query.setString("cdPersonIdType", CodesTables.CNUMTYPE_MEDICAID_NUMBER);
    query.setString("nbrMedicaid", String.valueOf(nbrMedicaid));
    query.addScalar("idPerson", Hibernate.INTEGER);
    query.addScalar("nmPersonFull", Hibernate.STRING);
    query.addScalar("nmPersonFirst", Hibernate.STRING);
    query.addScalar("nmPersonLast", Hibernate.STRING);
    query.addScalar("nmPersonMiddle", Hibernate.STRING);
    query.addScalar("dtPersonDeath", Hibernate.TIMESTAMP);
    query.addScalar("dtPersonBirth", Hibernate.TIMESTAMP);
    query.addScalar("ssn", Hibernate.INTEGER);
    query.addScalar("cdPersonEthnicGroup", Hibernate.STRING);
    query.addScalar("cdPersonCounty", Hibernate.STRING);
    query.addScalar("cdPersonState", Hibernate.STRING);
    query.addScalar("addrPersonStLn1", Hibernate.STRING);
    query.addScalar("addrPersonCity", Hibernate.STRING);
    query.addScalar("addrPersonZip", Hibernate.STRING);
    query.addScalar("cdPersonSex", Hibernate.STRING);
    query.addScalar("cdPersonStatus", Hibernate.STRING);
    query.addScalar("indPersonDobApprox", Hibernate.STRING);
    return query;
  }

  @SuppressWarnings( { "unchecked" })
  public Query findPersonsByPersonIdByNbrAndType(String nbrPersonId, List<String> numTypes, int pageNbr, int pageSize) {
    SQLQuery query = getSession()
                              .createSQLQuery(
                                           "select p.id_Person as idPerson, "
                                                           + "               p.nm_Person_Full as nmPersonFull, "
                                                           + "               p.nm_Person_First as nmPersonFirst, "
                                                           + "               p.nm_Person_Last as nmPersonLast, "
                                                           + "               p.nm_Person_Middle as nmPersonMiddle, "
                                                           + "               p.dt_Person_Death as dtPersonDeath, "
                                                           + "               p.dt_Person_Birth as dtPersonBirth, "
                                                           + "               p.nbr_Person_Id_Number as ssn, "
                                                           + "               p.cd_Person_Ethnic_Group as cdPersonEthnicGroup, "
                                                           + "               p.cd_Person_County as cdPersonAddrCounty, "
                                                           + "               p.cd_Person_State as cdPersonState, "
                                                           + "               p.addr_Person_St_Ln_1 as addrPersonStLn1, "
                                                           + "               p.addr_Person_City as addrPersonCity, "
                                                           + "               p.addr_Person_Zip as addrPersonZip, "
                                                           + "               p.cd_Person_Sex as cdPersonSex,  "
                                                           + "               p.cd_Person_Status as cdPersonStatus,  "
                                                           + "               p.ind_Person_Dob_Approx as indPersonDobApprox  "
                                                           + "  from Person_Id_enc pi "
                                                           + "  join person_enc p on pi.id_person = p.id_person "
                                                           + "  where pi.nbr_Person_Id_Number = encrypt(:nbrPersonId) "
                                                           + "  and (pi.dt_Person_Id_End = null  or pi.dt_Person_Id_End = :maxDate) "
                                                           + "  and pi.cd_Person_Id_Type in (:numTypes) ");
    query.setParameterList("numTypes", numTypes);
    query.setString("nbrPersonId", nbrPersonId);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    query.addScalar("idPerson", Hibernate.INTEGER);
    query.addScalar("nmPersonFull", Hibernate.STRING);
    query.addScalar("nmPersonFirst", Hibernate.STRING);
    query.addScalar("nmPersonLast", Hibernate.STRING);
    query.addScalar("nmPersonMiddle", Hibernate.STRING);
    query.addScalar("dtPersonDeath", Hibernate.TIMESTAMP);
    query.addScalar("dtPersonBirth", Hibernate.TIMESTAMP);
    query.addScalar("ssn", Hibernate.INTEGER);
    query.addScalar("cdPersonEthnicGroup", Hibernate.STRING);
    query.addScalar("cdPersonCounty", Hibernate.STRING);
    query.addScalar("cdPersonState", Hibernate.STRING);
    query.addScalar("addrPersonStLn1", Hibernate.STRING);
    query.addScalar("addrPersonCity", Hibernate.STRING);
    query.addScalar("addrPersonZip", Hibernate.STRING);
    query.addScalar("cdPersonSex", Hibernate.STRING);
    query.addScalar("cdPersonStatus", Hibernate.STRING);
    query.addScalar("indPersonDobApprox", Hibernate.STRING);
    return query;
  }


  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Map> findPersonsByDob(Date dob, int pageNbr, int pageSize) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(p.idPerson as idPerson, "
                                                           + "               p.nmPersonFull as nmPersonFull, "
                                                           + "               p.nmPersonFirst as nmPersonFirst, "
                                                           + "               p.nmPersonLast as nmPersonLast, "
                                                           + "               p.nmPersonMiddle as nmPersonMiddle, "
                                                           + "               p.dtPersonDeath as dtPersonDeath, "
                                                           + "               p.dtPersonBirth as dtPersonBirth, "
                                                           + "               p.nbrPersonIdNumber as ssn, "
                                                           + "               p.cdPersonEthnicGroup as cdPersonEthnicGroup, "
                                                           + "               p.cdPersonCounty as cdPersonAddrCounty, "
                                                           + "               p.cdPersonState as cdPersonState, "
                                                           + "               p.addrPersonStLn1 as addrPersonStLn1, "
                                                           + "               p.addrPersonCity as addrPersonCity, "
                                                           + "               p.addrPersonZip as addrPersonZip, "
                                                           + "               p.cdPersonSex as cdPersonSex,  "
                                                           + "               p.cdPersonEthnicGroup as cdPersonEthnicGroup,  "
                                                           + "               p.cdPersonStatus as cdPersonStatus,  "
                                                           + "               p.indPersonDobApprox as indPersonDobApprox)  "
                                                           + "  from Person p " + " where p.dtPersonBirth = :dob "
                                                           +" and p.cdPersonStatus <> 'M'");//mxpatel added this code
    query.setDate("dob", dob);
    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, query);
  }

  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Map> findPersonsByPhoneNum(String nbrPhoneNumber, int pageNbr, int pageSize) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(p.idPerson as idPerson, "
                                                           + "               p.nmPersonFull as nmPersonFull, "
                                                           + "               p.nmPersonFirst as nmPersonFirst, "
                                                           + "               p.nmPersonLast as nmPersonLast, "
                                                           + "               p.nmPersonMiddle as nmPersonMiddle, "
                                                           + "               p.dtPersonDeath as dtPersonDeath, "
                                                           + "               p.dtPersonBirth as dtPersonBirth, "
                                                           + "               p.nbrPersonIdNumber as ssn, "
                                                           + "               p.cdPersonEthnicGroup as cdPersonEthnicGroup, "
                                                           + "               p.cdPersonCounty as cdPersonAddrCounty, "
                                                           + "               p.cdPersonState as cdPersonState, "
                                                           + "               p.addrPersonStLn1 as addrPersonStLn1, "
                                                           + "               p.addrPersonCity as addrPersonCity, "
                                                           + "               p.addrPersonZip as addrPersonZip, "
                                                           + "               p.cdPersonSex as cdPersonSex,  "
                                                           + "               p.cdPersonEthnicGroup as cdPersonEthnicGroup,  "
                                                           + "               p.cdPersonStatus as cdPersonStatus,  "
                                                           + "               p.indPersonDobApprox as indPersonDobApprox)  "
                                                           + "  from PersonPhone pp join pp.person p  "
                                                           + " where pp.nbrPersonPhone = :nbrPhoneNumber  "
                                                           + "or p.nbrPersonPhone = :nbrPhoneNumber ");
    query.setString("nbrPhoneNumber", nbrPhoneNumber);
    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, query);
  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> findPersonByEventId(int idEvent) {
    Query query = getSession().createQuery(
                                           "select new map(a.nmPersonFull as nmPersonFull, "
                                                           + "               a.idPerson as idPerson) "
                                                           + "  from EventPersonLink b " + "  join b.person a "
                                                           + " where b.event.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return (List<Map>) query.list();
  }

  public Name findPrimaryName(int idPerson) {
    Query query = getSession().createQuery(
                                           "select name " + "  from Name name, PhoneticName phoneticName "
                                                           + " where name.person.idPerson = :idPerson "
                                                           + "   and name.indNamePrimary = 'Y' "
                                                           + "   and name.dtNameEndDate = :dtNameEndDate "
                                                           + "   and name.idName = phoneticName.idPhkNameKey "
                                                           + "   and phoneticName.cdPhkNameType = 'NA'");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtNameEndDate", DateHelper.MAX_JAVA_DATE);
    return (Name) firstResult(query);
  }

  public Integer findIdPersonByIdStageCdUnitSpecialization(int idStage) {
    Session session = getSession();
    Query query = session.createQuery("select u.person.idPerson " + "  from Stage s, " + "       Unit u, "
                                      + "       CodesTables c " + " where c.id.codeType = '" + CodesTables.CCNTYREG
                                      + "' " + "   and u.cdUnitSpecialization = 'PAL' "
                                      + "   and s.cdStageCnty = c.id.code " + "   and '0' + c.decode = u.cdUnitRegion "
                                      + "   and s.idStage = :idStage ");
    query.setInteger("idStage", idStage);
    return (Integer) firstResult(query);
  }

  public String findCdPersonSexByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
                                           "select p.cdPersonSex " + "  from Person p "
                                                           + " where p.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (String) query.uniqueResult();
  }

  public StagePersonLink findStagePersonLinkByIdPersonAndIdStage(int idPerson, int idStage) {
    Query query = getSession().createQuery(
                                           " from StagePersonLink " + "where person.idPerson = :idPerson "
                                                           + "  and stage.idStage = :idStage");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    return (StagePersonLink) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Map> findPersonByIdCase(int idCase, int pageNbr, int pageSize) {
    Query query = getSession().createQuery(
                                           "select new map(spl.person.idPerson as idPerson, "
                                                           + "       s.unit.idUnit as idUnit, "
                                                           + "       s.idStage as idStage) "
                                                           + "  from StagePersonLink spl, " + "       Stage s "
                                                           + " where s.capsCase.idCase = :idCase "
                                                           + "   and spl.cdStagePersRole = 'PR' ");
    query.setInteger("idCase", idCase);
    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, query);
  }

  public Map findYoungestPrimaryByIdStage(int idStage) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(spl1.person.idPerson as idPerson, "
                                                           + "               spl1.person.dtPersonBirth as dtPersonBirth) "
                                                           + "  from StagePersonLink spl1 "
                                                           + " where spl1.stage.idStage = :idStage "
                                                           + "   and spl1.cdStagePersType = 'PRN' "
                                                           + "   and spl1.person.dtPersonBirth = (select max(spl2.person.dtPersonBirth) "
                                                           + "                                      from StagePersonLink spl2 "
                                                           + "                                     where spl2.stage.idStage = :idStage "
                                                           + "                                       and spl2.cdStagePersType = 'PRN')");

    query.setInteger("idStage", idStage);
    return (Map) firstResult(query);
  }

  public Person findPersonByIdPerson(int idPerson) {
    Session session = getSession();
    Query query = session.createQuery("from Person p " + "where p.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (Person) firstResult(query);
  }

  @SuppressWarnings( { "unchecked" })
  public List<Person> findPersonByIdPerson(Collection<Integer> idPersonList) {
    Session session = getSession();
    Query query = session.createQuery("from Person p " + "where p.idPerson in ( :idPersonList )");
    query.setParameterList("idPersonList", idPersonList);
    return (List<Person>) query.list();
  }

  // STGAP00017013: MR-095
  @SuppressWarnings( { "unchecked" })
  public Person findMostRecentPersonByIdPerson(Collection<Integer> idPersonList) {
    Session session = getSession();
    Query query = session.createQuery("from Person p " + "where p.idPerson in ( :idPersonList )"
                                      + " order by p.idPerson desc " );
    query.setParameterList("idPersonList", idPersonList);
    return (Person) firstResult(query);
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<Object[]> findPersonBySsn(String ssn) {
    Session session = getSession();
    SQLQuery query = session.createSQLQuery( "select p.id_Person as idPerson, "
                                             + "               p.nm_Person_Full as nmPersonFull, "
                                             + "               p.dt_Person_Death as dtPersonDeath, "
                                             + "               p.dt_Person_Birth as dtPersonBirth, "
                                             + "               p.nbr_Person_Id_Number as ssn, "
                                             + "               p.cd_Person_Ethnic_Group as cdPersonEthnicGroup, "
                                             + "               p.cd_Person_County as cdPersonCounty, "
                                             + "               p.cd_Person_State as cdPersonState, "
                                             + "               p.addr_Person_St_Ln_1 as addrPersonStLn1, "
                                             + "               p.addr_Person_City as addrPersonCity, "
                                             + "               p.cd_Person_Sex as cdPersonSex  "
                                             + "  from Person_Id_enc pi "
                                             + "  join person p on pi.id_person = p.id_person "
                                             + "  where pi.nbr_Person_Id_Number = encrypt(:ssn) ");
query.setString("ssn", ssn);
query.addScalar("idPerson", Hibernate.INTEGER);
query.addScalar("nmPersonFull", Hibernate.STRING);
query.addScalar("dtPersonDeath", Hibernate.TIMESTAMP);
query.addScalar("dtPersonBirth", Hibernate.TIMESTAMP);
query.addScalar("ssn", Hibernate.STRING);
query.addScalar("cdPersonEthnicGroup", Hibernate.STRING);
query.addScalar("cdPersonCounty", Hibernate.STRING);
query.addScalar("cdPersonState", Hibernate.STRING);
query.addScalar("addrPersonStLn1", Hibernate.STRING);
query.addScalar("addrPersonCity", Hibernate.STRING);
query.addScalar("cdPersonSex", Hibernate.STRING);

    return (List<Object[]>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Map> findPersonsByIdNames(int pageNbr, int pageSize, Collection<Integer> idNames) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(p.nmPersonFull as nmPersonFull, "
                                                           + "                        p.idPerson as idPerson, "
                                                           + "                        p.nmPersonFirst as nmPersonFirst, "
                                                           + "                        p.nmPersonLast as nmPersonLast, "
                                                           + "                        p.nmPersonMiddle as nmPersonMiddle, "
                                                           + "                        p.dtPersonDeath as dtPersonDeath, "
                                                           + "                        p.dtPersonBirth as dtPersonBirth, "
                                                           + "                        p.nbrPersonIdNumber as ssn, "
                                                           + "                        p.cdPersonEthnicGroup as cdPersonEthnicGroup, "
                                                           + "                        p.cdPersonCounty as cdPersonCounty, "
                                                           + "                        p.cdPersonState as cdPersonState, "
                                                           + "                        p.addrPersonStLn1 as addrPersonStLn1, "
                                                           + "                        p.addrPersonCity as addrPersonCity, "
                                                           + "                        p.addrPersonZip as addrPersonZip, "
                                                           + "                        p.cdPersonSex as cdPersonSex,  "
                                                           + "                        p.cdPersonEthnicGroup as cdPersonEthnicGroup,  "
                                                           + "                        p.cdPersonStatus as cdPersonStatus,  "
                                                           + "                        p.indPersonDobApprox as indPersonDobApprox,  "
                                                           + "                        n.idName as idName,  "
                                                           + "                        n.dtNameEndDate as dtNameEndDate, "
                                                           + "                        n.indNamePrimary as indNamePrimary, "
                                                           + "                        n.nmNameFirst as nmIncmgPersonFirst, "
                                                           + "                        n.nmNameLast as nmIncmgPersonLast, "
                                                           + "                        n.nmNameMiddle as nmIncmgPersonMiddle) "
                                                           + "  from Person p, " + "  Name n "
                                                           + " where p.idPerson = n.person.idPerson "
                                                           + " and n.idName in (:idNames)");
    query.setParameterList("idNames", idNames);
    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, query);
  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> findPersonsByIdNames(Collection<Integer> idNames) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(p.nmPersonFull as nmPersonFull, "
                                                           + "                        p.idPerson as idPerson, "
                                                           + "                        p.nmPersonFirst as nmPersonFirst, "
                                                           + "                        p.nmPersonLast as nmPersonLast, "
                                                           + "                        p.nmPersonMiddle as nmPersonMiddle, "
                                                           + "                        p.dtPersonDeath as dtPersonDeath, "
                                                           + "                        p.dtPersonBirth as dtPersonBirth, "
                                                           + "                        p.nbrPersonIdNumber as ssn, "
                                                           + "                        p.cdPersonEthnicGroup as cdPersonEthnicGroup, "
                                                           + "                        p.cdPersonCounty as cdPersonAddrCounty, "
                                                           + "                        p.cdPersonState as cdPersonState, "
                                                           + "                        p.addrPersonStLn1 as addrPersonStLn1, "
                                                           + "                        p.addrPersonCity as addrPersonCity, "
                                                           + "                        p.addrPersonZip as addrPersonZip, "
                                                           + "                        p.cdPersonSex as cdPersonSex,  "
                                                           + "                        p.cdPersonEthnicGroup as cdPersonEthnicGroup,  "
                                                           + "                        p.cdPersonStatus as cdPersonStatus,  "
                                                           + "                        p.indPersonDobApprox as indPersonDobApprox,  "
                                                           + "                        n.idName as idName,  "
                                                           + "                        n.dtNameEndDate as dtNameEndDate, "
                                                           + "                        n.indNamePrimary as indNamePrimary, "
                                                           + "                        n.nmNameFirst as nmIncmgPersonFirst, "
                                                           + "                        n.nmNameLast as nmIncmgPersonLast, "
                                                           + "                        n.nmNameMiddle as nmIncmgPersonMiddle) "
                                                           + "  from Person p, " + "  Name n "
                                                           + " where p.idPerson = n.person.idPerson "
                                                           + " and n.idName in (:idNames)");
    query.setParameterList("idNames", idNames);
    return (List<Map>) query.list();
  }


  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Map> findPersonsPersonIdByIdNames(int pageNbr, int pageSize, Collection<Integer> idNames) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(p.nmPersonFull as nmPersonFull, "
                                                           + "                        p.idPerson as idPerson, "
                                                           + "                        p.nmPersonFirst as nmPersonFirst, "
                                                           + "                        p.nmPersonLast as nmPersonLast, "
                                                           + "                        p.nmPersonMiddle as nmPersonMiddle, "
                                                           + "                        p.dtPersonDeath as dtPersonDeath, "
                                                           + "                        p.dtPersonBirth as dtPersonBirth, "
                                                           + "                        p.nbrPersonIdNumber as ssn, "
                                                           + "                        p.cdPersonEthnicGroup as cdPersonEthnicGroup, "
                                                           + "                        p.cdPersonCounty as cdPersonCounty, "
                                                           + "                        p.cdPersonState as cdPersonState, "
                                                           + "                        p.addrPersonStLn1 as addrPersonStLn1, "
                                                           + "                        p.addrPersonCity as addrPersonCity, "
                                                           + "                        p.addrPersonZip as addrPersonZip, "
                                                           + "                        p.cdPersonSex as cdPersonSex,  "
                                                           + "                        p.cdPersonEthnicGroup as cdPersonEthnicGroup,  "
                                                           + "                        p.cdPersonStatus as cdPersonStatus,  "
                                                           + "                        p.indPersonDobApprox as indPersonDobApprox,  " +
                                                                        " pi.nbrPersonIdNumber as nbrPersonIdNumber"
                                                           + "                        n.idName as idName,  "
                                                           + "                        n.dtNameEndDate as dtNameEndDate, "
                                                           + "                        n.indNamePrimary as indNamePrimary, "
                                                           + "                        n.nmNameFirst as nmIncmgPersonFirst, "
                                                           + "                        n.nmNameLast as nmIncmgPersonLast, "
                                                           + "                        n.nmNameMiddle as nmIncmgPersonMiddle) "
                                                           + "  from Name n, " + "  Person p "
                                                           + "  left join p.personIds pi "
                                                           //  + "  from Person p, " + "  Name n "
                                                           + " where p.idPerson = n.person.idPerson "
                                                           + " and n.idName in (:idNames) " +
                                                                        " and pi.CD_PERSON_ID_TYPE = :cdSsn ");
    query.setParameterList("idNames", idNames);
    query.setString("cdSsn", CodesTables.CNUMTYPE_SSN);
    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, query);
  }

  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Map> findPersonsByIdPersons(int pageNbr, int pageSize, Collection<Integer> idPersons) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(p.nmPersonFull as nmPersonFull, "
                                                           + "              p.idPerson as idPerson, "
                                                           + "              p.dtPersonDeath as dtPersonDeath,  "
                                                           + "              p.dtPersonBirth as dtPersonBirth,  "
                                                           + "              p.nbrPersonIdNumber as ssn,  "
                                                           + "              p.cdPersonEthnicGroup as cdPersonEthnicGroup, "
                                                           + "              p.addrPersonStLn1 as addrPersonStLn1,  "
                                                           + "              p.addrPersonCity as addrPersonCity, "
                                                           + "              p.cdPersonCounty as cdPersonAddrCounty, "
                                                           + "              p.addrPersonZip as addrPersonZip, "
                                                           + "              p.cdPersonSex as cdPersonSex,   "
                                                           + "              p.cdPersonEthnicGroup as cdPersonEthnicGroup,  "
                                                           + "              p.cdPersonStatus as cdPersonStatus,   "
                                                           + "              p.indPersonDobApprox as indPersonDobApprox,  "
                                                           + "              p.nmPersonFirst as nmPersonFirst,  "
                                                           + "              p.nmPersonLast as nmPersonLast,  "
                                                           + "              p.nmPersonMiddle as nmPersonMiddle)  "
                                                           + "   from  " + "   Person p  "
                                                           + "  where  p.idPerson in (:idPersons)");
    query.setParameterList("idPersons", idPersons);
    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, query);
  }
  
  public Integer findIdPersonAddressByIdPerson(int idPerson) {
    Session session = getSession();
    Query query = session.createQuery("select apl.personAddress.idPersonAddr " 
                                      + " from AddressPersonLink apl "
                                      + " where apl.person.idPerson = :idPerson " 
                                      + " and apl.indPersAddrLinkInvalid = :indPersAddrLinkInvalid"
                                      + " order by apl.person.idPerson, "
                                      + " case apl.cdPersAddrLinkType when 'RS' then 0 when 'RM'  "
                                      + " then 1 when 'BS' then 2 when 'BM' then 3 when 'BB' then 4 else 5 end ");
    query.setInteger("idPerson", idPerson);
    query.setString("indPersAddrLinkInvalid", ArchitectureConstants.N);
    return (Integer) firstResult(query);
  }

  public Map findNmPersonAndNmStageByIdStage(int idStage, String cdStagePersRole) {
    Query query = getSession().createQuery(
                                           "select new map(a.nmPersonFull as nmPersonFull, "
                                                           + "               b.person.idPerson as idPerson, "
                                                           + "               c.nmStage as nmStage ) "
                                                           + "   from Person a, " + "        StagePersonLink b, "
                                                           + "        Stage c " + "  where c.idStage = :idStage "
                                                           + "    and b.stage.idStage = c.idStage "
                                                           + "    and b.person.idPerson = a.idPerson "
                                                           + "    and (b.cdStagePersRole = :cdStagePersRole "
                                                           + "         or b.cdStagePersRole = 'HP')");
    query.setInteger("idStage", idStage);
    query.setString("cdStagePersRole", cdStagePersRole);
    return (Map) firstResult(query);
  }

  public int updatePersonCdPersonStatus(int idPerson, String cdPersonStatus) {
    Query query = getSession().createQuery(
                                           "update Person p " + "   set p.cdPersonStatus = :cdPersonStatus "
                                                           + " where p.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    query.setString("cdPersonStatus", cdPersonStatus);
    return query.executeUpdate();
  }

  public int updatePersonNbrPersonAge(int idPerson, int nbrPersonAge) {
    Query query = getSession().createQuery(
                                           "update Person p " + "    set p.nbrPersonAge = :nbrPersonAge "
                                                           + "  where p.idPerson = :idPerson ");

    query.setInteger("idPerson", idPerson);
    query.setInteger("nbrPersonAge", nbrPersonAge);
    return query.executeUpdate();
  }



  public int insertPerson(int idPerson, int idRelatedPerson, int idStage) {
    SQLQuery query = getSession().createSQLQuery(
                                                 "INSERT INTO PERSON (ID_PERSON, "
                                                                 + "                    NBR_PERSON_AGE, "
                                                                 + "                    DT_PERSON_DEATH, "
                                                                 + "                    DT_PERSON_BIRTH, "
                                                                 + "                    CD_PERSON_DEATH, "
                                                                 + "                    CD_PERSON_MARITAL_STATUS, "
                                                                 + "                    CD_PERSON_LANGUAGE, "
                                                                 + "                    CD_PERSON_SEX, "
                                                                 + "                    CD_PERSON_ETHNIC_GROUP, "
                                                                 + "                    IND_PERSON_DOB_APPROX, "
                                                                 + "                    NM_PERSON_FULL, "
                                                                 + "                    CD_PERSON_STATUS ) "
                                                                 + " SELECT :idPerson, "
                                                                 + "        NBR_INCMG_PERS_AGE, "
                                                                 + "        DT_INCMG_PERS_DEATH, "
                                                                 + "        DT_INCMG_PERS_BIRTH, "
                                                                 + "        CD_INCMG_PERS_DEATH, "
                                                                 + "        CD_INCMG_PERS_MARITL_STAT, "
                                                                 + "        CD_INCMG_PERS_LANGUAGE, "
                                                                 + "        CD_INCMG_PERS_SEX, "
                                                                 + "        CD_INCMG_PERS_ETHNIC, "
                                                                 + "        IND_INCMG_PERS_DOB_APPROX, "
                                                                 + "        NM_INCMG_PERS_FULL, " + "        '"
                                                                 + CodesTables.CPERSTAT_A + "' "
                                                                 + "   FROM INCOMING_PERSON "
                                                                 + "  WHERE ID_PERSON = :idRelatedPerson "
                                                                 + "    AND ID_STAGE = :idStage");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idRelatedPerson", idRelatedPerson);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int insertPerson(int seqPersonNextVal, String cdPersonSex, String cdNmPersonFull, String cdPersonEthnicGroup,
                          Date dtPersonBirth) {
    SQLQuery query = getSession().createSQLQuery(
                                                 "INSERT INTO PERSON (ID_PERSON, "
                                                                 + "                    CD_PERSON_SEX, "
                                                                 + "                    NM_PERSON_FULL, "
                                                                 + "                    CD_PERSON_ETHNIC_GROUP, "
                                                                 + "                    DT_PERSON_BIRTH) "
                                                                 + "     VALUES (:seqPersonNextVal, "
                                                                 + "             :cdPersonSex, "
                                                                 + "             :cdNmPersonFull, "
                                                                 + "             :cdPersonEthnicGroup, "
                                                                 + "             :dtPersonBirth)");
    query.setInteger("seqPersonNextVal", seqPersonNextVal);
    query.setString("cdPersonSex", cdPersonSex);
    query.setString("cdNmPersonFull", cdNmPersonFull);
    query.setString("cdPersonEthnicGroup", cdPersonEthnicGroup);
    query.setTimestamp("dtPersonBirth", dtPersonBirth);

    return query.executeUpdate();
  }


  public int updatePerson(int idPerson, String cdPersonSex, String cdNmPersonFull, String cdPersonEthnicGroup,
                          Date dtPersonBirth, Date dtLastUpdate) {
    Query query = getSession().createQuery(
                                           "update Person " + "   set cdPersonSex = :cdPersonSex, "
                                                           + "       nmPersonFull = :cdNmPersonFull, "
                                                           + "       cdPersonEthnicGroup = :cdPersonEthnicGroup, "
                                                           + "       dtPersonBirth = :dtPersonBirth "
                                                           + " where idPerson = :idPerson "
                                                           + "   and dtLastUpdate = :dtLastUpdate ");
    query.setInteger("idPerson", idPerson);
    query.setString("cdPersonSex", cdPersonSex);
    query.setString("cdNmPersonFull", cdNmPersonFull);
    query.setString("cdPersonEthnicGroup", cdPersonEthnicGroup);
    query.setTimestamp("dtPersonBirth", dtPersonBirth);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);

    return query.executeUpdate();
  }

  public int updatePerson(String cdPersonEthnicGroup, String indPersCancelHist, int idPerson) {

    Query query = getSession().createQuery(
                                           "update Person " + "   set cdPersonEthnicGroup = :cdPersonEthnicGroup, "
                                                           + "       indPersCancelHist = :indPersCancelHist "
                                                           + " where idPerson = :idPerson");
    query.setString("cdPersonEthnicGroup", cdPersonEthnicGroup);
    query.setString("indPersCancelHist", indPersCancelHist);
    query.setInteger("idPerson", idPerson);

    return query.executeUpdate();
  }

  public int updatePersonByPerLangAndPerCancelHist(String cdPersonLanguage, String indPersCancelHist, int idPerson) {

    Query query = getSession().createQuery(
                                           "update Person " + "    set cdPersonLanguage = :cdPersonLanguage, "
                                                           + "        indPersCancelHist = :indPersCancelHist "
                                                           + "  where idPerson = :idPerson");
    query.setString("cdPersonLanguage", cdPersonLanguage);
    query.setString("indPersCancelHist", indPersCancelHist);
    query.setInteger("idPerson", idPerson);

    return query.executeUpdate();
  }

  public int insertPerson(int nbrPersonAge, Date dtPersonBirth, Date dtPersonDeath, String personStatus,
                          String cdPersonDeath, String cdPersonMaritalStatus, String cdPersonLanguage,
                          String cdDisasterRlf, String cdPersonSex, String nmPersonFull, String cdPersonEthnicGroup,
                          String indPersonDobApprox, int idPerson, String cdPersonTitle, String cdMatchType,
                          String cdPersonProofCitizenship,
                          String txtPersonOtherRelationships) {

    Person person = new Person();
    person.setNbrPersonAge(nbrPersonAge);
    person.setDtPersonBirth(dtPersonBirth);
    person.setDtPersonDeath(dtPersonDeath);
    person.setCdPersonStatus(personStatus);
    person.setCdPersonDeath(cdPersonDeath);
    person.setCdPersonMaritalStatus(cdPersonMaritalStatus);
    person.setCdPersonLanguage(cdPersonLanguage);
    person.setCdDisasterRlf(cdDisasterRlf);
    person.setCdPersonSex(cdPersonSex);
    person.setNmPersonFull(nmPersonFull);
    person.setCdPersonEthnicGroup(cdPersonEthnicGroup);
    person.setIndPersonDobApprox(indPersonDobApprox);
    person.setIdPerson(idPerson);
    person.setCdPersonTitle(cdPersonTitle);
    person.setTxtPersonOtherRelationships(txtPersonOtherRelationships);
    person.setCdMatchType(cdMatchType);
    //begin RMP added for STGAP00002945
    person.setCdPersonProofCitizenship(cdPersonProofCitizenship);
    //end RMP added for STGAP00002945

    Employee employee = (Employee) getSession().load(Employee.class, idPerson);
    person.setEmployee(employee);
    getSession().save(person);
    return person.getIdPerson();
  }

  public int updatePerson(int nbrPersonAge, Date dtPersonDeath, Date dtPersonBirth, String cdPersonDeath,
                          String cdPersonMaritalStatus, String cdPersonLanguage, String cdDisasterRlf,
                          String cdPersonSex, String nmPersonFull, String cdPersonEthnicGroup,
                          String indPersonDobApprox, String indPersCancelHist, int idPerson, String cdPersonTitle,
                          String cdMatchType, String cdPersonProofCitizenship, String txtPersonOtherRelationships) {
    Query query = getSession()
                              .createQuery(
                                           "update Person p "
                                                           + "   set p.nbrPersonAge = :nbrPersonAge, "
                                                           + "       p.dtPersonDeath = :dtPersonDeath, "
                                                           + "       p.dtPersonBirth = :dtPersonBirth, "
                                                           + "       p.cdPersonDeath = :cdPersonDeath, "
                                                           + "       p.cdPersonMaritalStatus = :cdPersonMaritalStatus, "
                                                           + "       p.cdPersonLanguage = :cdPersonLanguage, "
                                                           + "       p.cdDisasterRlf = :cdDisasterRlf, "
                                                           + "       p.cdPersonSex = :cdPersonSex, "
                                                           + "       p.nmPersonFull = :nmPersonFull, "
                                                           + "       p.cdPersonEthnicGroup = :cdPersonEthnicGroup, "
                                                           + "       p.indPersonDobApprox = :indPersonDobApprox, "
                                                           + "       p.indPersCancelHist = :indPersCancelHist, "
                                                           + "       p.cdPersonTitle = :cdPersonTitle, "
                                                           + "       p.cdMatchType = :cdMatchType, "
                                                           + "       p.cdPersonProofCitizenship = :cdPersonProofCitizenship, "
                                                           + "       p.txtPersonOtherRelationships = :txtPersonOtherRelationships "
                                                           + " where p.idPerson = :idPerson");

    query.setInteger("nbrPersonAge", nbrPersonAge);
    query.setTimestamp("dtPersonDeath", dtPersonDeath);
    query.setTimestamp("dtPersonBirth", dtPersonBirth);
    query.setString("cdPersonDeath", cdPersonDeath);
    query.setString("cdPersonMaritalStatus", cdPersonMaritalStatus);
    query.setString("cdPersonLanguage", cdPersonLanguage);
    query.setString("cdDisasterRlf", cdDisasterRlf);
    query.setString("cdPersonSex", cdPersonSex);
    query.setString("nmPersonFull", nmPersonFull);
    query.setString("cdPersonEthnicGroup", cdPersonEthnicGroup);
    query.setString("indPersonDobApprox", indPersonDobApprox);
    query.setString("indPersCancelHist", indPersCancelHist);
    query.setInteger("idPerson", idPerson);
    query.setString("cdPersonTitle", cdPersonTitle);
    query.setString("cdMatchType", cdMatchType);
    query.setString("cdPersonProofCitizenship", cdPersonProofCitizenship);
    query.setString("txtPersonOtherRelationships", txtPersonOtherRelationships);

    return query.executeUpdate();

  }

  public int updatePersonNmPersonFull(String nmPersonFull, String indPersCancelHist, int idPerson) {

    Query query = getSession().createQuery(
                                           "update Person p " + "   set p.nmPersonFull = :nmPersonFull, "
                                                           + "       p.indPersCancelHist = :indPersCancelHist "
                                                           + " where p.idPerson = :idPerson");
    query.setString("nmPersonFull", nmPersonFull);
    query.setString("indPersCancelHist", indPersCancelHist);
    query.setInteger("idPerson", idPerson);

    return query.executeUpdate();
  }

  public int updatePersonSetCharToOne(int idPerson) {
    Query query = getSession().createQuery(
                                           "update Person p " + "   set p.cdPersonChar = '1'"
                                                           + " where p.idPerson = :idPerson");

    query.setInteger("idPerson", idPerson);

    return query.executeUpdate();
  }



  public int updatePersonSetCharToZero(int idPerson) {
    Query query = getSession().createQuery(
                                           "update Person p " + "   set p.cdPersonChar = '0' "
                                                           + " where p.idPerson = :idPerson");

    query.setInteger("idPerson", idPerson);

    return query.executeUpdate();
  }

  public int updatePersonNamePersonFull(int idPerson, String cdNmPersonFull) {
    Query query = getSession().createQuery(
                                           "update Person p " + "   set p.nmPersonFull = :cdNmPersonFull "
                                                           + " where p.idPerson = :idPerson");

    query.setInteger("idPerson", idPerson);
    query.setString("cdNmPersonFull", cdNmPersonFull);

    return query.executeUpdate();
  }

  public int insertPerson(int nbrPersonAge, Date dtPersonDeath, Date dtPersonBirth, String cdPersonStatus,
                          String cdPersonDeath, String cdPersonMaritalStatus, String cdPersonLanguage,
                          String cdPersonSex, String nmPersonFull, String cdPersonEthnicGroup, String cdPersonReligion,
                          String cdPersonChar, String indPersonDobApprox, String cdPersonLivArr,
                          String txtPersonOccupation, String cdDisasterRlf, String cdPersonTitle, String txtAddlCmnts, String personSsn) {

    Person person = new Person();
    person.setIdPerson(0);
    person.setNbrPersonAge(nbrPersonAge);
    person.setDtPersonDeath(dtPersonDeath);
    person.setDtPersonBirth(dtPersonBirth);
    person.setCdPersonEthnicGroup(cdPersonStatus);
    person.setCdPersonDeath(cdPersonDeath);
    person.setCdPersonMaritalStatus(cdPersonMaritalStatus);
    person.setCdPersonLanguage(cdPersonLanguage);
    person.setCdPersonSex(cdPersonSex);
    person.setCdPersonTitle(cdPersonTitle);
    person.setNmPersonFull(nmPersonFull);
    person.setCdPersonEthnicGroup(cdPersonEthnicGroup);
    person.setCdPersonReligion(cdPersonReligion);
    person.setCdPersonChar(cdPersonChar);
    person.setIndPersonDobApprox(indPersonDobApprox);
    person.setCdPersonLivArr(cdPersonLivArr);
    person.setTxtPersonOccupation(txtPersonOccupation);
    person.setCdDisasterRlf(cdDisasterRlf);
    person.setTxtPersonAddlCmnts(txtAddlCmnts);
    person.setNbrPersonIdNumber(personSsn);
    Employee employee = (Employee) getSession().load(Employee.class, 0);
    person.setEmployee(employee);
    getSession().save(person);
    return person.getIdPerson();
  }

  public int insertPerson(int seqPersonNextVal, int nbrPersonAge, Date dtPersonDeath, Date dtPersonBirth,
                          String cdPersonStatus, String cdPersonDeath, String cdPersonMaritalStatus,
                          String cdPersonLanguage, String cdPersonSex, String nmPersonFull, String cdPersonEthnicGroup,
                          String cdPersonReligion, String cdPersonChar, String indPersonDobApprox,
                          String cdPersonLivArr, String txtPersonOccupation, String cdDisasterRlf, String cdPersonTitle, String txtAddlCmnts, String personSsn) {

    SQLQuery query = getSession().createSQLQuery(
                                                 "INSERT INTO PERSON (ID_PERSON, "
                                                                 + "                    NBR_PERSON_AGE, "
                                                                 + "                    DT_PERSON_DEATH, "
                                                                 + "                    DT_PERSON_BIRTH, "
                                                                 + "                    CD_PERSON_STATUS, "
                                                                 + "                    CD_PERSON_DEATH, "
                                                                 + "                    CD_PERSON_MARITAL_STATUS, "
                                                                 + "                    CD_PERSON_LANGUAGE, "
                                                                 + "                    CD_PERSON_SEX, "
                                                                 + "                    NM_PERSON_FULL,  "
                                                                 + "                    CD_PERSON_ETHNIC_GROUP, "
                                                                 + "                    CD_PERSON_RELIGION, "
                                                                 + "                    CD_PERSON_CHAR, "
                                                                 + "                    IND_PERSON_DOB_APPROX, "
                                                                 + "                    CD_PERSON_LIV_ARR, "
                                                                 + "                    TXT_PERSON_OCCUPATION, "
                                                                 + "                    CD_PERSON_TITLE, "
                                                                 + "                    CD_DISASTER_RLF, " +
                                                                                " TXT_PERSON_ADDL_CMNTS, "
                                                                 + " NBR_PERSON_ID_NUMBER)"
                                                                 + "     VALUES (:seqPersonNextVal, "
                                                                 + "             :nbrPersonAge, "
                                                                 + "             :dtPersonDeath, "
                                                                 + "             :dtPersonBirth, "
                                                                 + "             :cdPersonStatus, "
                                                                 + "             :cdPersonDeath, "
                                                                 + "             :cdPersonMaritalStatus, "
                                                                 + "             :cdPersonLanguage, "
                                                                 + "             :cdPersonSex, "
                                                                 + "             :nmPersonFull, "
                                                                 + "             :cdPersonEthnicGroup, "
                                                                 + "             :cdPersonReligion, "
                                                                 + "             :cdPersonChar, "
                                                                 + "             :indPersonDobApprox, "
                                                                 + "             :cdPersonLivArr, "
                                                                 + "             :txtPersonOccupation, "
                                                                 + "             :cdPersonTitle, "
                                                                 + "             :cdDisasterRlf, " 
                                                                 + "             :txtAddlCmnts,"
                                                                 + "             :personSsn)");

    query.setInteger("seqPersonNextVal", seqPersonNextVal);
    query.setInteger("nbrPersonAge", nbrPersonAge);
    query.setTimestamp("dtPersonDeath", dtPersonDeath);
    query.setTimestamp("dtPersonBirth", dtPersonBirth);
    query.setString("cdPersonStatus", cdPersonStatus);
    query.setString("cdPersonDeath", cdPersonDeath);
    query.setString("cdPersonMaritalStatus", cdPersonMaritalStatus);
    query.setString("cdPersonLanguage", cdPersonLanguage);
    query.setString("cdPersonSex", cdPersonSex);
    query.setString("nmPersonFull", nmPersonFull);
    query.setString("cdPersonEthnicGroup", cdPersonEthnicGroup);
    query.setString("cdPersonReligion", cdPersonReligion);
    query.setString("cdPersonChar", cdPersonChar);
    query.setString("indPersonDobApprox", indPersonDobApprox);
    query.setString("cdPersonLivArr", cdPersonLivArr);
    query.setString("txtPersonOccupation", txtPersonOccupation);
    query.setString("cdPersonTitle", cdPersonTitle);
    query.setString("cdDisasterRlf", cdDisasterRlf);
    query.setString("txtAddlCmnts", txtAddlCmnts);
    query.setString("personSsn", personSsn);

    return query.executeUpdate();

  }

  public int updatePerson(int nbrPersonAge, Date dtPersonDeath, Date dtPersonBirth, String cdPersonStatus,
                          String cdPersonDeath, String cdPersonMaritalStatus, String cdPersonLanguage,
                          String cdPersonSex, String nmPersonFull, String cdPersonEthnicGroup,
                          String txtPersonOccupation, String cdPersonLivArr, String indPersonDobApprox,
                          String cdPersonTitle, String txtPersonOtherRelationships, String cdPersonReligion,
                          String cdDisasterRlf, int idPerson, Date dtLastUpdate, String txtAddlCmnts) {

    Query query = getSession()
                              .createQuery(
                                           "update Person p "
                                                           + "   set p.nbrPersonAge = :nbrPersonAge, "
                                                           + "       p.dtPersonDeath = :dtPersonDeath, "
                                                           + "       p.dtPersonBirth = :dtPersonBirth, "
                                                           + "       p.cdPersonStatus = :cdPersonStatus, "
                                                           + "       p.cdPersonDeath = :cdPersonDeath, "
                                                           + "       p.cdPersonMaritalStatus = :cdPersonMaritalStatus, "
                                                           + "       p.cdPersonLanguage = :cdPersonLanguage, "
                                                           + "       p.cdPersonSex = :cdPersonSex, "
                                                           + "       p.nmPersonFull = :nmPersonFull, "
                                                           + "       p.cdPersonEthnicGroup = :cdPersonEthnicGroup, "
                                                           + "       p.txtPersonOccupation = :txtPersonOccupation, "
                                                           + "       p.cdPersonLivArr = :cdPersonLivArr, "
                                                           + "       p.indPersonDobApprox = :indPersonDobApprox, "
                                                           + "       p.cdPersonReligion = :cdPersonReligion, "
                                                           + "       p.cdDisasterRlf = :cdDisasterRlf, "
                                                           + "       p.cdPersonTitle = :cdPersonTitle, "
                                                           + "       p.txtPersonOtherRelationships = :txtPersonOtherRelationships, " +
                                                                        " p.txtPersonAddlCmnts = :txtAddlCmnts "
                                                           + " where p.idPerson = :idPerson "
                                                           + "   and p.dtLastUpdate = :dtLastUpdate ");

    query.setInteger("nbrPersonAge", nbrPersonAge);
    query.setTimestamp("dtPersonDeath", dtPersonDeath);
    query.setTimestamp("dtPersonBirth", dtPersonBirth);
    query.setString("cdPersonStatus", cdPersonStatus);
    query.setString("cdPersonDeath", cdPersonDeath);
    query.setString("cdPersonMaritalStatus", cdPersonMaritalStatus);
    query.setString("cdPersonLanguage", cdPersonLanguage);
    query.setString("cdPersonSex", cdPersonSex);
    query.setString("nmPersonFull", nmPersonFull);
    query.setString("cdPersonEthnicGroup", cdPersonEthnicGroup);
    query.setString("txtPersonOccupation", txtPersonOccupation);
    query.setString("cdPersonLivArr", cdPersonLivArr);
    query.setString("indPersonDobApprox", indPersonDobApprox);
    query.setString("cdPersonReligion", cdPersonReligion);
    query.setString("cdDisasterRlf", cdDisasterRlf);
    query.setString("cdPersonTitle", cdPersonTitle);
    query.setString("txtPersonOtherRelationships", txtPersonOtherRelationships);
    query.setString("txtAddlCmnts", txtAddlCmnts);
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }

  public int updatePerson(int nbrPersonAge, Date dtPersonDeath, Date dtPersonBirth, String cdPersonStatus,
                          String cdPersonDeath, String cdPersonMaritalStatus, String cdPersonLanguage,
                          String cdPersonSex, String nmPersonFull, String cdPersonEthnicGroup,
                          String txtPersonOccupation, String cdPersonLivArr, String indPersonDobApprox,
                          String cdPersonChar, String cdPersNotYetDiag, String txtCharCmnts, String cdPersonReligion,
                          String cdDisasterRlf, int idPerson, Date dtLastUpdate, String txtAddlCmnts) {
    Query query = getSession()
                              .createQuery(
                                           "update Person p "
                                                           + "   set p.nbrPersonAge = :nbrPersonAge, "
                                                           + "       p.dtPersonDeath = :dtPersonDeath, "
                                                           + "       p.dtPersonBirth = :dtPersonBirth, "
                                                           + "       p.cdPersonStatus =:cdPersonStatus, "
                                                           + "       p.cdPersonDeath = :cdPersonDeath, "
                                                           + "       p.cdPersonMaritalStatus = :cdPersonMaritalStatus, "
                                                           + "       p.cdPersonLanguage = :cdPersonLanguage, "
                                                           + "       p.cdPersonSex = :cdPersonSex, "
                                                           + "       p.nmPersonFull = :nmPersonFull, "
                                                           + "       p.cdPersonEthnicGroup = :cdPersonEthnicGroup, "
                                                           + "       p.txtPersonOccupation = :txtPersonOccupation, "
                                                           + "       p.cdPersonLivArr = :cdPersonLivArr, "
                                                           + "       p.indPersonDobApprox =  :indPersonDobApprox, "
                                                           + "       p.cdPersonChar = :cdPersonChar, "
                                                           + "       p.cdPersNotYetDiag = :cdPersNotYetDiag, "
                                                           + "       p.txtCharCmnts = :txtCharCmnts, "
                                                           + "       p.cdPersonReligion = :cdPersonReligion, "
                                                           + "       p.cdDisasterRlf = :cdDisasterRlf, " +
                                                                        " p.txtPersonAddlCmnts = :txtAddlCmnts "
                                                           + " where p.idPerson = :idPerson "
                                                           + "   and p.dtLastUpdate = :dtLastUpdate");
    query.setInteger("nbrPersonAge", nbrPersonAge);
    query.setTimestamp("dtPersonDeath", dtPersonDeath);
    query.setTimestamp("dtPersonBirth", dtPersonBirth);
    query.setString("cdPersonStatus", cdPersonStatus);
    query.setString("cdPersonDeath", cdPersonDeath);
    query.setString("cdPersonMaritalStatus", cdPersonMaritalStatus);
    query.setString("cdPersonLanguage", cdPersonLanguage);
    query.setString("cdPersonSex", cdPersonSex);
    query.setString("nmPersonFull", nmPersonFull);
    query.setString("cdPersonEthnicGroup", cdPersonEthnicGroup);
    query.setString("txtPersonOccupation", txtPersonOccupation);
    query.setString("cdPersonLivArr", cdPersonLivArr);
    query.setString("indPersonDobApprox", indPersonDobApprox);
    query.setString("cdPersonChar", cdPersonChar);
    query.setString("cdPersNotYetDiag", cdPersNotYetDiag);
    query.setString("txtCharCmnts", txtCharCmnts);
    query.setString("cdPersonReligion", cdPersonReligion);
    query.setString("cdDisasterRlf", cdDisasterRlf);
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    query.setString("txtAddlCmnts", txtAddlCmnts);
    return query.executeUpdate();
  }

  public int updatePerson(int nbrPersonAge, Date dtPersonDeath, Date dtPersonBirth, String cdPersonStatus,
                          String cdPersonDeath, String cdPersonMaritalStatus, String cdPersonLanguage,
                          String cdPersonSex, String nmPersonFull, String cdPersonEthnicGroup,
                          String txtPersonOccupation, String cdPersonLivArr, String indPersonDobApprox,
                          String cdPersonChar, String cdPersNotYetDiag, String txtCharCmnts, String cdPersonReligion,
                          String cdDisasterRlf, int idPerson, Date dtLastUpdate, String indAdptDisln,
                          String indIntlAdoptn, String indPrevAdopt, String indPrivateAdoptn, String indPublicAdoptn,
                          String cdCounty, String cdCntry, String cdState,
                          String szAgency, Date txtDissolutionDate, Date txtPrevAdopt,
                          String indSingleParAdpt, String szCdSngleMomOrFar, String indIVEPriorAdoption) {
    Query query = getSession()
                              .createQuery(
                                           "update Person p "
                                                           + "   set p.nbrPersonAge = :nbrPersonAge, "
                                                           + "       p.dtPersonDeath = :dtPersonDeath, "
                                                           + "       p.dtPersonBirth = :dtPersonBirth, "
                                                           + "       p.cdPersonStatus =:cdPersonStatus, "
                                                           + "       p.cdPersonDeath = :cdPersonDeath, "
                                                           + "       p.cdPersonMaritalStatus = :cdPersonMaritalStatus, "
                                                           + "       p.cdPersonLanguage = :cdPersonLanguage, "
                                                           + "       p.cdPersonSex = :cdPersonSex, "
                                                           + "       p.nmPersonFull = :nmPersonFull, "
                                                           + "       p.cdPersonEthnicGroup = :cdPersonEthnicGroup, "
                                                           + "       p.txtPersonOccupation = :txtPersonOccupation, "
                                                           + "       p.cdPersonLivArr = :cdPersonLivArr, "
                                                           + "       p.indPersonDobApprox =  :indPersonDobApprox, "
                                                           + "       p.cdPersonChar = :cdPersonChar, "
                                                           + "       p.cdPersNotYetDiag = :cdPersNotYetDiag, "
                                                           + "       p.txtCharCmnts = :txtCharCmnts, "
                                                           + "       p.cdPersonReligion = :cdPersonReligion, "
                                                           + "       p.cdDisasterRlf = :cdDisasterRlf, "
                                                           + "       p.indAdoptDisluton = :indAdptDisln ,"
                                                           + "       p.indIntrntl = :indIntlAdoptn,"
                                                           + "       p.txtNameOfAdoAgency = :szAgency,"
                                                           + "       p.dtDissolution = :txtDissolutionDate,"
                                                           + "       p.dtPrevAdoption = :txtPrevAdopt,"
                                                           + "       p.indPrevAdopted = :indPrevAdopt ,"
                                                           + "       p.indPrivate = :indPrivateAdoptn ,"
                                                           + "       p.indPublic = :indPublicAdoptn, "
                                                           + "       p.cdAdoptCntry = :cdCntry ,"
                                                           + "       p.cdAdoptCounty = :cdCounty,"
                                                           + "       p.cdAdoptState = :cdState, "
                                                           + "       p.indSingleParAdopt = :indSingleParAdpt, "
                                                           + "       p.cdSingleMotherFather = :szCdSngleMomOrFar, "
                                                           + "       p.indIvePriorAdoption = :indIVEPriorAdoption "
                                                           + " where p.idPerson = :idPerson "
                                                           + "   and p.dtLastUpdate = :dtLastUpdate");
    query.setInteger("nbrPersonAge", nbrPersonAge);
    query.setTimestamp("dtPersonDeath", dtPersonDeath);
    query.setTimestamp("dtPersonBirth", dtPersonBirth);
    query.setString("cdPersonStatus", cdPersonStatus);
    query.setString("cdPersonDeath", cdPersonDeath);
    query.setString("cdPersonMaritalStatus", cdPersonMaritalStatus);
    query.setString("cdPersonLanguage", cdPersonLanguage);
    query.setString("cdPersonSex", cdPersonSex);
    query.setString("nmPersonFull", nmPersonFull);
    query.setString("cdPersonEthnicGroup", cdPersonEthnicGroup);
    query.setString("txtPersonOccupation", txtPersonOccupation);
    query.setString("cdPersonLivArr", cdPersonLivArr);
    query.setString("indPersonDobApprox", indPersonDobApprox);
    query.setString("cdPersonChar", cdPersonChar);
    query.setString("cdPersNotYetDiag", cdPersNotYetDiag);
    query.setString("txtCharCmnts", txtCharCmnts);
    query.setString("cdPersonReligion", cdPersonReligion);
    query.setString("cdDisasterRlf", cdDisasterRlf);
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    query.setString("indAdptDisln", indAdptDisln);
    query.setString("indIntlAdoptn", indIntlAdoptn);
    query.setString("indPrevAdopt", indPrevAdopt);
    query.setString("indPrivateAdoptn", indPrivateAdoptn);
    query.setString("indPublicAdoptn", indPublicAdoptn);
    query.setString("cdCntry", cdCntry);
    query.setString("cdCounty", cdCounty);
    query.setString("cdState", cdState);
    query.setString("szAgency", szAgency);
    query.setString("indSingleParAdpt", indSingleParAdpt);
    query.setString("szCdSngleMomOrFar", szCdSngleMomOrFar);
    query.setTimestamp("txtDissolutionDate", txtDissolutionDate);
    query.setTimestamp("txtPrevAdopt", txtPrevAdopt);
    query.setString("indIVEPriorAdoption", indIVEPriorAdoption);
    
    return query.executeUpdate();
  }

  public int deleteIntakePerson(int idPerson) {
    SQLQuery query = getSession().createSQLQuery("CALL COMPLEX_DELETE.DELETE_INTAKE_PERSON(:idPerson)");
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }

  public int deletePerson(int idPerson) {
    SQLQuery query = getSession().createSQLQuery("CALL COMPLEX_DELETE.DELETE_PERSON(:idPerson)");
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }

  // R2: REQ_FUNC_CD_PAGE_UP
  public int updatePerson(int nbrPersonAge, Date dtPersonDeath, Date dtPersonBirth, String cdPersonStatus,
                          String cdPersonDeath, String cdPersonMaritalStatus, String cdPersonLanguage,
                          String cdPersonSex, String nmPersonFull, String cdPersonEthnicGroup,
                          String txtPersonOccupation, String cdPersonLivArr, String indPersonDobApprox,
                          String cdPersonChar, String cdPersonReligion, String cdDisasterRlf, int idPerson,
                          Date dtLastUpdate, String szTxtOtherRelationshipsCmnts, String szCdTitle) {
    Query query = getSession()
                              .createQuery(
                                           "update Person p "
                                                           + "   set p.nbrPersonAge = :nbrPersonAge, "
                                                           + "       p.dtPersonDeath = :dtPersonDeath, "
                                                           + "       p.dtPersonBirth = :dtPersonBirth, "
                                                           + "       p.cdPersonStatus =:cdPersonStatus, "
                                                           + "       p.cdPersonDeath = :cdPersonDeath, "
                                                           + "       p.cdPersonMaritalStatus = :cdPersonMaritalStatus, "
                                                           + "       p.cdPersonLanguage = :cdPersonLanguage, "
                                                           + "       p.cdPersonSex = :cdPersonSex, "
                                                           + "       p.nmPersonFull = :nmPersonFull, "
                                                           + "       p.cdPersonEthnicGroup = :cdPersonEthnicGroup, "
                                                           + "       p.txtPersonOccupation = :txtPersonOccupation, "
                                                           + "       p.cdPersonLivArr = :cdPersonLivArr, "
                                                           + "       p.indPersonDobApprox =  :indPersonDobApprox, "
                                                           + "       p.cdPersonChar = :cdPersonChar, "
                                                           + "       p.cdPersonReligion = :cdPersonReligion, "
                                                           + "       p.cdDisasterRlf = :cdDisasterRlf, "
                                                           + "       p.txtPersonOtherRelationships = :szTxtOtherRelationshipsCmnts, "
                                                           + "       p.cdPersonTitle = :szCdTitle "
                                                           + " where p.idPerson = :idPerson "
                                                           + "   and p.dtLastUpdate = :dtLastUpdate");
    query.setInteger("nbrPersonAge", nbrPersonAge);
    query.setTimestamp("dtPersonDeath", dtPersonDeath);
    query.setTimestamp("dtPersonBirth", dtPersonBirth);
    query.setString("cdPersonStatus", cdPersonStatus);
    query.setString("cdPersonDeath", cdPersonDeath);
    query.setString("cdPersonMaritalStatus", cdPersonMaritalStatus);
    query.setString("cdPersonLanguage", cdPersonLanguage);
    query.setString("cdPersonSex", cdPersonSex);
    query.setString("nmPersonFull", nmPersonFull);
    query.setString("cdPersonEthnicGroup", cdPersonEthnicGroup);
    query.setString("txtPersonOccupation", txtPersonOccupation);
    query.setString("cdPersonLivArr", cdPersonLivArr);
    query.setString("indPersonDobApprox", indPersonDobApprox);
    query.setString("cdPersonChar", cdPersonChar);
    query.setString("cdPersonReligion", cdPersonReligion);
    query.setString("cdDisasterRlf", cdDisasterRlf);
    query.setString("szTxtOtherRelationshipsCmnts", szTxtOtherRelationshipsCmnts);
    query.setString("szCdTitle", szCdTitle);
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> findPersonPersonDtlByStagePersonLink(int idStage, int idCase) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(b.idPerson as idPerson, "
                                                           + "               b.nmPersonFull as nmPersonFull, "
                                                           + "               b.dtPersonBirth as dtPersonBirth, "
                                                           + "               b.txtPersonOccupation as txtPersonOccupation, "
                                                           + "               b.cdPersonMaritalStatus as cdPersonMaritalStatus, "
                                                           + "               b.nbrPersonIdNumber as nbrPersonIdNumber, "
                                                           + "               b.cdPersonSex as cdPErsonSex, "
                                                           + "               c.nmStage as nmStage )"
                                                           + "   from Person b, " + "        Stage c, "
                                                           + "        StagePersonLink a "
                                                           + "  where a.stage.idStage = :idStage "
                                                           + "    and a.capsCase.idCase =  :idCase "
                                                           + "    and b.idPerson = a.person.idPerson "
                                                           + "    and c.idStage = a.stage.idStage"
                                                           + "    and a.cdStagePersRole = 'PC' ");
    query.setInteger("idStage", idStage);
    query.setInteger("idCase", idCase);
    // query.setString("cdRace", CodesTables.GRACE_WT);
    return (List<Map>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<Map> findPrinciples(int idStage, int idCase) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(b.idPerson as idPerson, "
                                                           + "               b.nmPersonFull as nmPersonFull, "
                                                           + "               a.cdStagePersRelInt as cdStagePersRelInt, "
                                                           + "               b.dtPersonBirth as dtPersonBirth, "
                                                           + "               b.addrPersonStLn1 as addrPersonStLn1, "
                                                           + "               b.addrPersonCity as addrPersonCity, "
                                                           + "               b.cdPersonState as cdPersonState, "
                                                           + "               b.addrPersonZip as addrPersonZip, "
                                                           + "               b.cdPersonMaritalStatus as cdPersonMaritalStatus, "
                                                           + "               a.cdStagePersType as cdStagePersType ) "
                                                           + "   from Person b, " + "        Stage c, "
                                                           + "        StagePersonLink a "
                                                           + "   where a.stage.idStage = :idStage "
                                                           + "    and a.capsCase.idCase =  :idCase "
                                                           + "    and b.idPerson = a.person.idPerson "
                                                           + "    and c.idStage = a.stage.idStage ");
    query.setInteger("idStage", idStage);
    query.setInteger("idCase", idCase);
    return (List<Map>) query.list();
  }

  public void savePerson(Person person) {
    getSession().saveOrUpdate(person);
  }

  public int updatePersonByCdSmileClient(String cdSmileClient, int idPerson) {

    Query query = getSession().createQuery(
                                           "update Person " + "   set cdSmileClient = :cdSmileClient "
                                                           + " where idPerson = :idPerson");
    query.setString("cdSmileClient", cdSmileClient);
    query.setInteger("idPerson", idPerson);

    return query.executeUpdate();
  }

  public String findcdRaceByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
                                           "select p.cdRace " + "  from PersonRace p "
                                                           + " where p.person.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (String) firstResult(query);
  }

  public String findNbrPersonByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
                                           "select p.nbrPersonIdNumber " + "  from PersonId p "
                                                           + " where p.person.idPerson  = :idPerson "
                                                           + " and p.cdPersonIdType = 'SSN'");
    query.setInteger("idPerson", idPerson);
    return (String) firstResult(query);
  }

  public String findIndPersonPaternityEstByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
                                           "select p.indPersonPaternityEst " + "  from PersonDtl p "
                                                           + " where p.person.idPerson  = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (String) firstResult(query);
  }

  public Date findDtRemovalByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
                                           "select c.dtRemoval " + "  from CnsrvtrshpRemoval c "
                                                           + " where c.person.idPerson  = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (Date) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<Characteristics> findCdCharacteristicByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
                                           " from Characteristics c "
                                                           + " where c.person.idPerson  = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (List<Characteristics>) query.list();
  }

  public Map findCdPersonCitizenshipCdPersonBirthCountyByIdPerson(int idPerson) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(d.cdPersonCitizenship as cdPersonCitizenship, "
                                                           + "               d.cdPersonBirthCounty as cdPersonBirthCounty ) "
                                                           + "  from PersonDtl d "
                                                           + " where d.person.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (Map) firstResult(query);
  }

  public Date findDtPlcmntByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
                                           "select p.dtPlcmtStart " + "  from Placement p "
                                                           + " where p.personByIdPlcmtChild.idPerson  = :idPerson"
                                                           + " order by p.dtPlcmtStart desc");
    query.setInteger("idPerson", idPerson);
    return (Date) firstResult(query);
  }
  
  //STGAP00014774 Added this method for Initial Medicaid Application Page
  @SuppressWarnings({"unchecked"})
  public Date findEarliestAprvDtPlcmntByIdPerson(int idPerson, int idCase) {
    Query query = getSession().createQuery(
                                           "select p.dtPlcmtStart " 
                                           + "  from Placement p , Event e "
                                           + "  where p.idPlcmtEvent = e.idEvent "
                                           + "  and p.capsCase.idCase = e.capsCase.idCase "
                                           + "  and e.cdEventType = '" + CodesTables.CEVNTTYP_PLA + "'"
                                           + "  and e.cdEventStatus = '" + CodesTables.CEVTSTAT_APRV + "'"
                                           + "  and p.personByIdPlcmtChild.idPerson  = :idPerson "
                                           + "  and p.capsCase.idCase = :idCase "
                                           + " order by p.dtPlcmtStart asc");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idCase", idCase);
    return (Date) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdPrimacyChildSubAdoFromPrnsList(int idCase, Collection prnsList) {
    Query query = getSession().createQuery(" select distinct p.idPerson from " +
                " Person p, StagePersonLink spl " +
                " where p.idPerson in (:prnsList) " +
                " and spl.capsCase.idCase = :idCase " +
                " and p.idPerson = spl.person.idPerson " +
                " and spl.cdStagePersRole = :cdStagePersRole " +
                " and (spl.stage.cdStage = :cdStageSUB OR spl.stage.cdStage = :cdStageADO) ");
    query.setInteger("idCase", idCase);
    query.setParameterList("prnsList", prnsList);
    query.setString("cdStageSUB", CodesTables.CSTAGES_SUB);
    query.setString("cdStageADO", CodesTables.CSTAGES_ADO);
    query.setString("cdStagePersRole", CodesTables.CROLEALL_PC);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdPrimaryChildWithOpenSubAdoFromPrnsList(int idCase, Collection prnsList) {
    Query query = getSession().createQuery(" select distinct p.idPerson from " +
                " Person p, StagePersonLink spl " +
                " where p.idPerson in (:prnsList) " +
                " and spl.capsCase.idCase = :idCase " +
                " and p.idPerson = spl.person.idPerson " +
                " and spl.cdStagePersRole = :cdStagePersRole " +
                " and (spl.stage.cdStage = :cdStageSUB OR spl.stage.cdStage = :cdStageADO) " +
                " and spl.stage.dtStageClose is null ");
    query.setInteger("idCase", idCase);
    query.setParameterList("prnsList", prnsList);
    query.setString("cdStageSUB", CodesTables.CSTAGES_SUB);
    query.setString("cdStageADO", CodesTables.CSTAGES_ADO);
    query.setString("cdStagePersRole", CodesTables.CROLEALL_PC);
    return (List<Integer>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdWtlpCandidateFromPrnsList(int idCase, Collection prnsList) {
    Query query = getSession().createQuery(" select distinct p.idPerson from " +
                " Person p, StagePersonLink spl " +
                " where p.idPerson in (:prnsList) " +
                " and spl.capsCase.idCase = :idCase " +
                " and p.idPerson = spl.person.idPerson " +
                " and spl.cdStagePersRole = :cdStagePersRole " +
                " and (spl.stage.cdStage = :cdStageSUB OR spl.stage.cdStage = :cdStageADO) " +
                " and (MONTHS_BETWEEN(SYSDATE, p.dtPersonBirth) >= 168)");
    query.setInteger("idCase", idCase);
    query.setParameterList("prnsList", prnsList);
    query.setString("cdStageSUB", CodesTables.CSTAGES_SUB);
    query.setString("cdStageADO", CodesTables.CSTAGES_ADO);
    query.setString("cdStagePersRole", CodesTables.CROLEALL_PC);
    return (List<Integer>) query.list();
  }

  //STGAP00010006: Added this sql to get the child info for the Exchange Child page
  @SuppressWarnings({"unchecked"})
  public Map findChildInfoByChildId(int idChild){
    Query query = getSession().createQuery(
                                           " select new map( p.nmPersonFull as nmPersonFull, "
                                           + " p.dtPersonBirth as dtPersonBirth, "
                                           + " p.nbrPersonAge as nbrPersonAge, "
                                           + " p.cdPersonSex as cdPersonSex, "
                                           + " p.indAdoptDisluton as indAdoptDisluton, "
                                           + " p.dtDissolution as dtDissolution, "
                                           + " p.personDtl.cdPersonMarriedAtBirth as cdPersonMarriedAtBirth) "
                                           + " from Person p "
                                           + " where p.idPerson = :idChild");
    query.setInteger("idChild", idChild);
    return (Map)query.uniqueResult();
  }

  //
  public Map findMinAgeMaxAgeInSiblingGrpByIdSiblingGrp(int idSiblingGroup){

    Query query = getSession().createQuery(
                                         " select new map ( max(p.dtPersonBirth) as maxPersonDob, " +
                                         " min(p.dtPersonBirth) as minPersonDob) " +
                                         " from Person p, Sibling s " +
                                         " where p.idPerson = s.id.idPerson " +
                                         " and p.idPerson in ( select si.id.idPerson from Sibling si " +
                                         " where si.id.idSiblingGroup = :idSiblingGroup)");
    query.setInteger("idSiblingGroup", idSiblingGroup);
    return (Map) firstResult(query);
  }

  //STGAP00010749: Saves a new person record
  public int saveNewPerson(Person person) {
    getSession().saveOrUpdate(person);
    return person.getIdPerson();
  }

  //STGAP00010749: Updates a person record with the Adopted indicator
  public int updatePersonIndAdopted(int idPerson) {
    Query query = getSession().createQuery(
                                           "update Person p " + "   set p.indAdopted = :indAdopted "
                                                           + " where p.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    query.setString("indAdopted", ArchitectureConstants.Y);
    return query.executeUpdate();
  }

  //CAPTA4.3: check if the person is over 17 years of age
  public Integer findCurrentAgeOver17Person(int idPerson) {
    Query query = getSession()
                              .createQuery(
                                           "select a.idPerson "
                                         + "  from Person a "
                                         + " where a.idPerson = :idPerson "
                                         + "   and months_between(sysdate,nvl(a.dtPersonBirth,sysdate)) >= 204");
    query.setInteger("idPerson", idPerson);
    return (Integer) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public List<Person> findPrimaryChildrenInCase (int idCase) {
    Query query = getSession().createQuery("select distinct p from Person p " +
                                           "where p.idPerson in " +
                                            "(select spl.person.idPerson " +
                                               "from StagePersonLink spl, Stage stg " +
                                               "where spl.stage.idStage = stg.idStage " +
                                               "and spl.cdStagePersRole = 'PC'" +
                                               "and stg.capsCase.idCase = :idCase " +
                                               "and stg.cdStage in ('SUB', 'ADO')" +
                                               "and stg.dtStageClose is null)" +
                                            "order by p.dtPersonBirth");
      query.setInteger("idCase", idCase);
      return (List<Person>) query.list();
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<Person> findPrincipleChildrenInCaseUnder18 (int idStage) {
    Query query = getSession()
                              .createQuery(
                                           "select p from Person p " +
                                           "where p.idPerson in " +
                                                "(select spl.person.idPerson from StagePersonLink spl " + 
                                                "where spl.cdStagePersType = 'PRN' " + 
                                                "and spl.stage.idStage = :idStage " + 
                                                "and months_between(sysdate,spl.person.dtPersonBirth) < 216)");
    query.setInteger("idStage", idStage);
    return (List<Person>) query.list();
  }  
  
  @SuppressWarnings( { "unchecked" })
  public List<Person> findPersonByFirstNameLastNameDob(String firstName, String lastname, Date dob) {
    Query query = getSession().createQuery(
                                           "from Person p " + " where p.nmPersonFirst = :firstName "
                                                           + " and p.nmPersonLast = :lastname "
                                                           + " and p.dtPersonBirth = :dob");
    query.setString("firstName", firstName);
    query.setString("lastname", lastname);
    query.setDate("dob", dob);
    return (List<Person>) query.list();
  }  

  // STGAP00017187: MR-095
  @SuppressWarnings( { "unchecked" })
  public Person findPersonByFirstNameLastName(String firstName, String lastname) {
    Query query = getSession().createQuery(
                                           "from Person p " + " where p.nmPersonFirst = :firstName "
                                                           + " and p.nmPersonLast = :lastname ");
    query.setString("firstName", firstName);
    query.setString("lastname", lastname);
    return (Person) firstResult(query);
  }  
  
  // STGAP00017872:  MR-072
  public String findNmLastFirstByIdPerson(int idPerson) {
	    Query query = getSession().createQuery(
	                                           "select p.nmPersonLast " 
	    									+ "|| ', ' ||"
	    									+ " p.nmPersonFirst as nmPersonFull"
	    									+ "  from Person p "
	                                                           + " where p.idPerson = :idPerson");
	    query.setInteger("idPerson", idPerson);
	    return (String) firstResult(query);
	  } 
}
