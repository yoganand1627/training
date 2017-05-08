package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.PersonRaceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class PersonRaceDAOImpl extends BaseDAOImpl implements PersonRaceDAO {
  
  /*
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   */
  public PersonRace findDistinctPersonRaceByIdPerson(int idPerson) {
    Query query = getSession().createQuery(" from PersonRace a " 
                                           + "where "
                                           + "person.idPerson = :idPerson " 
                                           + "order by person.idPerson, " 
                                           + "cdRace, " 
                                           + "dtLastUpdate");

    query.setInteger("idPerson", idPerson);
    return (PersonRace) firstResult(query);
    
  }
  
  public long findPersonRaceByIdPersonCdPersonRace(int idPerson, String cdPersonRace) {
	    Query query = getSession().createQuery( "select count(*) " 
	    									   + "from PersonRace a " 
	                                           + "where "
	                                           + "person.idPerson = :idPerson " 
	                                           + "and cdRace= :cdPersonRace " );

	    query.setInteger("idPerson", idPerson);
	    query.setString("cdPersonRace", cdPersonRace);
	    return (Long) query.uniqueResult();
	  }
  
  @SuppressWarnings({"unchecked"})
  public List<PersonRace> findPersonRaceByIdPerson(int idPerson) {

    Query query = getSession().createQuery("     from PersonRace a" +
                                           "    where person.idPerson = :idPerson" +
                                           " order by cdRace," +
                                           "          person.idPerson," +
                                           "          dtLastUpdate ");

    query.setInteger("idPerson", idPerson);
    return (List<PersonRace>) query.list();
  }

  public void savePersonRace(PersonRace personRace) {
    getSession().saveOrUpdate(personRace);
  }

  public int deletePersonRaceByIdPersonAndCdPersonRace(int idPerson, String cdPersonRace) {
    Query query = getSession().createQuery(" delete from PersonRace" +
                                           "       where person.idPerson = :idPerson" +
                                           "         and cdRace = :cdPersonRace");
    query.setInteger("idPerson", idPerson);
    query.setString("cdPersonRace", cdPersonRace);
    return query.executeUpdate();
  }

  public int insertPersonRaceByIdPersonIdIncmgPerson(int idPerson, int idIncmgPerson) {

    SQLQuery query = getSession().createSQLQuery("INSERT INTO PERSON_RACE (ID_PERSON_RACE,ID_PERSON,CD_RACE ) " +
                                                 " SELECT 0, " +
                                                 "        :idPerson, " +
                                                 "        CD_RACE " +
                                                 "   FROM INCOMING_RACE " +
                                                 "  WHERE ID_PERSON = :idIncmgPerson ");

    query.setInteger("idPerson", idPerson);
    query.setInteger("idIncmgPerson", idIncmgPerson);

    return query.executeUpdate();
  }
}