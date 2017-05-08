package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CharacteristicsDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Characteristics;
import gov.georgia.dhr.dfcs.sacwis.db.PersonRace;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

/*Change History:
  Date      User              Description
  --------  ----------------  ----------------------------------------------
  11/13/09  mxpatel           37257: modified findCdCharacteristicByIdPerson method to only retrieve active 
                              characteristics for a person
  09/12/11  charden           STGAP00017058 - created method findCdCharacteristicsByIdPersons() 
 *                            to find characteristics for each person
*/

public class CharacteristicsDAOImpl extends BaseDAOImpl implements CharacteristicsDAO {
  @SuppressWarnings({"unchecked"})
  public List<Characteristics> findCharacteristicsByIdPerson(int idPerson, Date dtchareffdate) {
    Query query = getSession().createQuery(" from Characteristics " +
                                           "where person.idPerson = :idPerson " +
                                           "  and dtCharStart <= :dtchareffdate " +
                                           "  and dtCharEnd > :dtchareffdate");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtchareffdate", dtchareffdate);
    return (List<Characteristics>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Characteristics> findCharacteristicsByIdPersonAndDtCharEnd(int idPerson, Date dtCharEnd) {
    Query query = getSession().createQuery(" from Characteristics c " +
                                           "where c.person.idPerson = :idPerson " +
                                           "  and dtCharEnd = :dtCharEnd ");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtCharEnd", dtCharEnd);
    return (List<Characteristics>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Characteristics> findCharacteristicsByIdPersonAndEffectiveDate(int idPerson, Date dtCharEffDate) {
    Query query = getSession().createQuery(" from Characteristics c " +
                                           "where c.person.idPerson = :idPerson " +
                                           "  and c.dtCharStart <= :dtCharEffDate " +
                                           "  and c.dtCharEnd   >= :dtCharEffDate ");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtCharEffDate", dtCharEffDate);
    query.setTimestamp("dtCharEffDate", dtCharEffDate);
    return (List<Characteristics>) query.list();
  }

  public long countCharacteristicsByIdPerson(int idPerson) {
    Query query = getSession().createQuery("select count(*) " +
                                           "  from Characteristics c " +
                                           " where c.person.idPerson = :idPerson " +
                                           "   and c.dtCharEnd = :dtMaxDate");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtMaxDate", DateHelper.MAX_JAVA_DATE);
    return (Long) query.uniqueResult();
  }

  public Characteristics countAgedCharacteristicsByIdPerson(int idPerson) {
    Query query = getSession().createQuery("  from Characteristics c " +
                                           " where c.person.idPerson = :idPerson " +
                                           "   and c.cdCharacteristic = '04' " +
                                           "   and c.dtCharEnd = :dtMaxDate");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtMaxDate", DateHelper.MAX_JAVA_DATE);
    return (Characteristics) firstResult(query);
  }

  public int insertCharacteristics(int idPerson, String cdCharCategory, String cdCharacteristic,
                                   Date dtCharStart, Date dtCharEnd) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO CHARACTERISTICS (ID_PERSON, " +
                                                 "                             ID_CHARACTERISTICS, " +
                                                 "                             CD_CHAR_CATEGORY, " +
                                                 "                             CD_CHARACTERISTIC, " +
                                                 "                             DT_CHAR_START, " +
                                                 "                             DT_CHAR_END) " +
                                                 "     VALUES (:idPerson, " +
                                                 "             SEQ_CHARACTERISTICS.NEXTVAL, " +
                                                 "             :cdCharCategory, " +
                                                 "             :cdCharacteristic, " +
                                                 "             :dtCharStart, " +
                                                 "             :dtCharEnd)");
    query.setInteger("idPerson", idPerson);
    query.setString("cdCharCategory", cdCharCategory);
    query.setString("cdCharacteristic", cdCharacteristic);
    query.setTimestamp("dtCharStart", dtCharStart);
    query.setTimestamp("dtCharEnd", dtCharEnd);
    return query.executeUpdate();
  }

  public int updateCharacteristicsEndDate(int idCharacteristics, Date dtCharEnd) {
    Query query = getSession().createQuery("update Characteristics " +
                                           "   set dtCharEnd = :dtCharEnd " +
                                           " where idCharacteristics = :idCharacteristics");
    query.setInteger("idCharacteristics", idCharacteristics);
    query.setTimestamp("dtCharEnd", dtCharEnd);
    return query.executeUpdate();
  }
  
  //STGAP00010006:Gets the list of characteristics for the given person
  @SuppressWarnings({"unchecked"}) 
  public List<String> findCdCharacteristicByIdPerson(Collection personIdsList){
    Query query = getSession().createQuery( 
                                          "select c.cdCharacteristic "
                                           +  " from Characteristics c "
                                           +  " where c.person.idPerson in (:personIdsList)"
                                           + " and c.dtCharEnd > sysdate ");
                                         
    query.setParameterList("personIdsList", personIdsList);
    return (List<String>)query.list();
  }
  
  @SuppressWarnings({"unchecked"}) 
  public List<Map<String, String>> findCdCharacteristicsByIdPersons(Collection personIdsList){
    Query query = getSession().createQuery( 
                                          "select new map(g.decode as characteristic, "
                                           +  " g.id.codeType as characteristic_group) "
                                           +  " from Characteristics c, CodesTables g "
                                           +  " where g.id.codeType in ('DED1', 'EBD1', 'EXB1', 'FHI1', 'HVI1', 'MED1', 'MER1', 'OTH1') "
                                           +  " and c.cdCharacteristic = g.id.code "
                                           +  " and c.person.idPerson in (:personIdsList) "
                                           +  " and c.dtCharEnd > sysdate ");
                                         
    query.setParameterList("personIdsList", personIdsList);
    return query.list();
  }
  
  //STGAP00010749: Gets the Characteristics records for the given person
  @SuppressWarnings({"unchecked"})
  public List<Characteristics> findCharsByIdPerson(int idPerson) {
    Query query = getSession().createQuery(" from Characteristics " +
                                           "where person.idPerson = :idPerson ");
    query.setInteger("idPerson", idPerson);
    return (List<Characteristics>) query.list();
  }
  
  //STGAP00010749: Save or update Charecteristics record
  public void saveCharacteristics(Characteristics characteristics) {
    getSession().saveOrUpdate(characteristics);
  }
  
  public long countPhysicalDevelopmentalDelayCharacteristicsByIdPerson(int idPerson){
    Query query = getSession().createQuery("select count(*) " +
                                           " from Characteristics c " +
                                           " where c.person.idPerson = :idPerson " +
                                           " and c.dtCharEnd = :dtMaxDate" +
                                           " and ( c.cdCharCategory in ('CPM','CHB','CME')" +
                                           "    or ( c.cdCharCategory = 'OTH' " +
                                           "            and c.cdCharacteristic = '90' )) ");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dtMaxDate", DateHelper.MAX_JAVA_DATE);
    return (Long) query.uniqueResult();
  }
}
