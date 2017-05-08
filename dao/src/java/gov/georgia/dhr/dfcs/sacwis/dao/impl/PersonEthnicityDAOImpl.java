package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.PersonEthnicityDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PersonEthnicity;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class PersonEthnicityDAOImpl extends BaseDAOImpl implements PersonEthnicityDAO {
  @SuppressWarnings({"unchecked"})
  public List<PersonEthnicity> findPersonEthnicityByIdPerson(int idPerson) {
    //STGAP00004054 added order by to get latest ethnicity first
    Query query = getSession().createQuery(" from PersonEthnicity a " +
                                           "where a.person.idPerson = :idPerson order by dtLastUpdate desc");
    query.setInteger("idPerson", idPerson);
    return (List<PersonEthnicity>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public PersonEthnicity findLatestPersonEthnicityByIdPerson(int idPerson) {
    Query query = getSession().createQuery(" from PersonEthnicity a " +
                                           "where a.idPersonEthnicity in " +
                                           "      (select max(idPersonEthnicity) " +
                                           "         from PersonEthnicity b " +
                                           "        where b.person.idPerson = :idPerson)");
    query.setInteger("idPerson", idPerson);
    return (PersonEthnicity) firstResult(query);
  }

  public void savePersonEthnicity(PersonEthnicity personEthnicity) {
    getSession().saveOrUpdate(personEthnicity);
  }

  public int insertPersonEthnicity(int idPerson, String cdPersonEthnicity) {
    PersonEthnicity personEthnicity = new PersonEthnicity();

    Person person = (Person) getSession().load(Person.class, idPerson);
    personEthnicity.setPerson(person);

    personEthnicity.setCdEthnicity(cdPersonEthnicity);
    getSession().saveOrUpdate(personEthnicity);
    //    
    // SQLQuery query = getSession().createSQLQuery(
    // "insert into PERSON_ETHNICITY (ID_PERSON_ETHNICITY,ID_PERSON,CD_ETHNICITY ) " +
    // " values(SEQ_PERSON_ETHNICITY.NEXTVAL, " +
    // " :idPerson, " +
    // " :cdPersonEthnicity)");
    // query.setInteger("idPerson", idPerson);
    // query.setString("cdPersonEthnicity", cdPersonEthnicity);

    return personEthnicity.getIdPersonEthnicity();
  }

  public int insertPersonEthnicityByIdPersonIdIncmgPerson(int idPerson, int idIncmgPerson) {

    SQLQuery query = getSession().createSQLQuery("INSERT INTO PERSON_ETHNICITY " +
                                                 "           (ID_PERSON_ETHNICITY, " +
                                                 "            ID_PERSON, " +
                                                 "            CD_ETHNICITY) " +
                                                 "SELECT 0, " +
                                                 "       :idPerson, " +
                                                 "       CD_ETHNICITY " +
                                                 "  FROM INCOMING_ETHNICITY " +
                                                 " WHERE ID_PERSON = :idIncmgPerson");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idIncmgPerson", idIncmgPerson);
    return query.executeUpdate();
  }

  public int deletePersonEthnicity(int idPerson) {
    Query query = getSession().createQuery("delete PersonEthnicity pe " +
                                           " where pe.person.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    return query.executeUpdate();
  }
}
