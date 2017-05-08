package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.PersonCitizenshipDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PersonCitizenship;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;


/**
 * 
 * <pre>
 *   Change History:
 *   Date         User                  Description
 *   --------     -------------------   --------------------------------------
 *   06/16/2009   bgehlot          STGAP00014279: Added method findCheckboxByIdPerson
 *   11/11/2009   mxpatel          37462: modified findCheckboxByIdPersonCbxCodeType method do only retrieve values 
 *                                 if cdCbx is not null
 *   
 */

public class PersonCitizenshipDAOImpl extends BaseDAOImpl implements PersonCitizenshipDAO {

  @SuppressWarnings( { "unchecked" })
  public List<PersonCitizenship> findCheckboxByIdPersonCbxCodeType(int idPerson, String cdCbxType) {

    Query query = getSession().createQuery(
                                           " from  PersonCitizenship pc " + " where pc.person.idPerson = :idPerson "
                                                           + " and pc.cdCbxCodeType = :cdCbxType "
                                                           + " and pc.cdCbx is not null ");

    query.setInteger("idPerson", idPerson);
    query.setString("cdCbxType", cdCbxType);
    return (List<PersonCitizenship>) query.list();

  }

  @SuppressWarnings( { "unchecked" })
  public void deletePersonCitizenshipChkBxByIdPerson(int idPerson, String cbxType) {
    Query query = getSession().createQuery(
                                           " delete from PersonCitizenship cbx "
                                                           + "       where cbx.person.idPerson = :idPerson "
                                                           + "       and cbx.cdCbxCodeType = :cbxType");
    query.setInteger("idPerson", idPerson);
    query.setString("cbxType", cbxType);
    query.executeUpdate();
  }

  @SuppressWarnings( { "unchecked" })
  public void savePersonCitizenship(PersonCitizenship personCitizenship) {
    getSession().saveOrUpdate(personCitizenship);
  }

  public Integer findPersonCitizenshipIdentityByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
                                           " select p.idPersonCitizenship  from PersonCitizenship p "
                                                           + "where p.person.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (Integer) firstResult(query);
  }

  public int updatePersonCitizenship(int idPerson, String cdCbx, String cdCbxCodeType) {
    Query query = getSession().createSQLQuery(
                                           "update PERSON_CITIZENSHIP pc" 
                                                           + "   set pc.CD_CBX = :cdCbx, "
                                                           + "       pc.CD_CBX_CODE_TYPE = :cdCbxCodeType "
                                                           + " where pc.ID_PERSON = :idPerson");
      

    query.setInteger("idPerson", idPerson);
    query.setString("cdCbx", cdCbx);
    query.setString("cdCbxCodeType", cdCbxCodeType);

    return query.executeUpdate();
  }

  public int insertPersonCitizenship(int idPerson, String cdCbx, String cdCbxCodeType) {
    SQLQuery query = getSession().createSQLQuery(
                                                 "INSERT INTO PERSON_CITIZENSHIP (ID_PERSON, "
                                                                 + "                    CD_CBX, "                                                                                                             
                                                                 + "                    CD_CBX_CODE_TYPE) "                                                                 
                                                                 + "     VALUES (:idPerson, "
                                                                 + "             :cdCbx, "                                                                                                                             
                                                                 + "             :cdCbxCodeType)");
    
    query.setInteger("idPerson", idPerson);
    query.setString("cdCbx", cdCbx);
    query.setString("cdCbxCodeType", cdCbxCodeType);

    return query.executeUpdate();

  }
  
  //STGAP00014279: Gets the person citizenship record for the person
  
  @SuppressWarnings( { "unchecked" })
  public List<PersonCitizenship> findCheckboxByIdPerson(int idPerson) {

    Query query = getSession().createQuery(
                                           " from  PersonCitizenship pc " 
                                         + " where pc.person.idPerson = :idPerson ");

    query.setInteger("idPerson", idPerson);
    return (List<PersonCitizenship>) query.list();

  }

}
