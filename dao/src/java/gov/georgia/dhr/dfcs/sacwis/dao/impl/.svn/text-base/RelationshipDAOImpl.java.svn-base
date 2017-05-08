package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.RelationshipDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Relationship;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
* Change History:
* Date        User              Description
* --------    ----------------  --------------------------------------------------
* 05/25/2010  mxpatel           SMS#50561: added method deleteRelationshipByIdPerson
* 05/25/2010  mxpatel           SMS#50561: added method findIdRelationshipsByStage
* 09/27/2011  schoi             STGAP00017013: MR-095 Added method findIdRelatedPersonByIdStageByIdChildByCdPersonRelationship
* 10/01/0211  schoi             STGAP00017013: MR-095 Added method findRelationshipByIdChildByIdRelatedPersonByCdPersonRelationship
* </pre>
*/

public class RelationshipDAOImpl extends BaseDAOImpl implements RelationshipDAO {

  @SuppressWarnings({"unchecked"})
  public Integer findRelationshipIdRelatedPersonByIdPerson(int idPerson, String cdPersonRelationship) {
    Query query = getSession().createQuery("select r.personByIdRelatedPerson.idPerson " +
                                           "  from Relationship r, " +
                                           "       Person p " +
                                           " where p.idPerson = r.personByIdRelatedPerson.idPerson " +
                                           "  and r.cdPersonRelationship = :cdPersonRelationship " +
                                           "  and r.personByIdPerson.idPerson = :idPerson ");

    query.setString("cdPersonRelationship", cdPersonRelationship);
    query.setInteger("idPerson", idPerson);
    return (Integer) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public Integer findRelationshipIdRelationship(int idPerson, String cdPersonRelationship) {
    Query query = getSession().createQuery("select r.idRelationship " +
                                           "  from Relationship r, " +
                                           "       Person p " +
                                           " where p.idPerson = r.personByIdRelatedPerson.idPerson " +
                                           "  and r.cdPersonRelationship = :cdPersonRelationship " +
                                           "  and r.personByIdPerson.idPerson = :idPerson ");

    query.setString("cdPersonRelationship", cdPersonRelationship);
    query.setInteger("idPerson", idPerson);
    return (Integer) firstResult(query);
  }

  @SuppressWarnings({"unchecked"})
  public int saveRelationship(int idRelationship, int idPerson, int idRelatePerson, String cdPersonRelationship) {
    Relationship relationship = new Relationship();

    if (idRelationship != 0) {
      relationship = (Relationship) getSession().load(Relationship.class, idRelationship);
    }

    relationship.setCdPersonRelationship(cdPersonRelationship);
    Person personByIdPerson = (Person) getSession().load(Person.class, idPerson);
    relationship.setPersonByIdPerson(personByIdPerson);
    Person personByIdRelatedPerson = (Person) getSession().load(Person.class, idRelatePerson);
    relationship.setPersonByIdRelatedPerson(personByIdRelatedPerson);
    getSession().saveOrUpdate(relationship);

    return relationship.getIdRelationship();
  }

  public void deleteRelationship(int idRelationship ) {
    Query query = getSession().createQuery("delete from Relationship r " +
                                           " where r.idRelationship = :idRelationship ");

    query.setInteger("idRelationship", idRelationship);
    query.executeUpdate();
  }

  @SuppressWarnings({"unchecked"})
  public List<Relationship> findRelationshipByIdPerson(int idPerson, Date dteffdate) {
    Query query = getSession().createQuery(" from Relationship " +
                                           "where personByIdPerson.idPerson = :idPerson " +
                                           "  and dtRelationshipStart <= :dteffdate " +
                                           "  and dtRelationshipEnd > :dteffdate");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("dteffdate", dteffdate);
    return (List<Relationship>) query.list();
  }
  
  /**
   * SMS#45718 This method returns the related to person for a child
   * @param idPerson
   * @return
   */
  @SuppressWarnings({"unchecked"})
  public List<Relationship> findRelationshipByIdChildPerson(int idPerson) {
    Query query = getSession().createQuery(" from Relationship r " +
                                           "where r.personByIdPerson.idPerson = :idPerson " +
                                           "and  r.personByIdRelatedPerson.idPerson != 0 " +
                                           "order by r.cdPersonRelationship ");
    query.setInteger("idPerson", idPerson);
    return (List<Relationship>) query.list();
  }
  
  /**
   * SMS#45718 This method returns all the children related to the related person
   * @param idRelatedToPerson
   * @return
   */
  @SuppressWarnings({"unchecked"})
  public List<Relationship> findRelationshipByIdRelatedToPerson(int idRelatedToPerson) {
    Query query = getSession().createQuery("from Relationship r " +
                                           "where r.personByIdRelatedPerson.idPerson = :idRelatedToPerson ");
    query.setInteger("idRelatedToPerson", idRelatedToPerson);
    return (List<Relationship>) query.list();
  }
  
  public int updateRelatedPersonforPersonMerge(int idPersMergeForward, int idPersMergeClosed) {
    Query query = getSession().createQuery(
                                           "update Relationship r set r.personByIdRelatedPerson.idPerson = :idPersMergeForward "
                                                           + " where r.personByIdRelatedPerson.idPerson =  :idPersMergeClosed ");
                                                          
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    return query.executeUpdate();
  }
  
  public void deleteRelationshipByIdPerson(int idPerson) {
    Query query = getSession().createQuery("delete from Relationship r " +
                                           " where r.personByIdPerson.idPerson = :idPerson "
                                           + " or r.personByIdRelatedPerson = :idPerson");

    query.setInteger("idPerson", idPerson);
    query.executeUpdate();
  }
  
   public List<Integer> findIdRelationshipsByStage(int idStage, int idPerson){
     SQLQuery query = getSession().createSQLQuery("SELECT r.id_relationship  "
                                               + " from relationship r  "
                                               + " where r.id_related_person = :idPerson    "
                                               + " and r.id_person in (  "
                                               + " select spl.id_person  "
                                               + " from stage_person_link spl  "
                                               + " where spl.id_stage = :idStage)  "
                                               + " union  "
                                               + " SELECT r.id_relationship  "
                                               + " from relationship r  "
                                               + " where r.id_person = :idPerson    "
                                               + " and r.id_related_person in (  "
                                               + " select spl.id_person  "
                                               + " from stage_person_link spl  "
                                               + " where spl.id_stage = :idStage)");
  query.setInteger("idPerson", idPerson);
  query.addScalar("id_relationship", Hibernate.INTEGER);
  query.setInteger("idStage", idStage);
  return (List<Integer>) query.list();
 }

  // STGAP00017013: MR-095
  /**
   * This method returns all the related person related to the children 
   * 
   * @param idStage
   * @param idPerson
   * @param cdPersonRelationship
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  public List<Relationship> findIdRelatedPersonByIdStageByIdChildByCdPersonRelationship(
                                                                                        int idStage,
                                                                                        int idPerson,
                                                                                        List<String> cdPersonRelationship) {
    Query query = getSession().createQuery(
                                           " from Relationship r "
                                                           + " where r.personByIdPerson.idPerson = :idPerson    "
                                                           + " and r.cdPersonRelationship in (:cdPersonRelationship)"
                                                           + " and r.personByIdRelatedPerson.idPerson in (  "
                                                           + " select spl.person.idPerson  "
                                                           + " from StagePersonLink spl  "
                                                           + " where spl.stage.idStage = :idStage )");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    query.setParameterList("cdPersonRelationship", cdPersonRelationship);
    return (List<Relationship>) query.list();
  } 
  
  // STGAP00017013: MR-095
  /**
   * This method returns all the related person related to the children 
   * 
   * @param idStage
   * @param idPerson
   * @param cdPersonRelationship
   * @return
   */
  @SuppressWarnings( { "unchecked" })
  public List<Relationship> findRelationshipByIdChildByIdRelatedPersonByCdPersonRelationship(
                                                                                             int idPerson,
                                                                                             int idRelatedPerson,
                                                                                             List<String> cdPersonRelationship) {
    Query query = getSession()
                              .createQuery(
                                           " from Relationship r "
                                                           + " where r.personByIdPerson.idPerson = :idPerson    "
                                                           + " and r.cdPersonRelationship in (:cdPersonRelationship)"
                                                           + " and ( r.personByIdRelatedPerson.idPerson  = :idRelatedPerson "
                                                           + " and r.personByIdRelatedPerson.idPerson <> 0 )");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idRelatedPerson", idRelatedPerson);
    query.setParameterList("cdPersonRelationship", cdPersonRelationship);
    return (List<Relationship>) query.list();
  } 
}
