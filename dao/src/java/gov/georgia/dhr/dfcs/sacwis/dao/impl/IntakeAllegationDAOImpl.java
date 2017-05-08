package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.IntakeAllegationDAO;
import gov.georgia.dhr.dfcs.sacwis.db.IntakeAllegation;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class IntakeAllegationDAOImpl extends BaseDAOImpl implements IntakeAllegationDAO {
  @SuppressWarnings( { "unchecked" })
  public List<Map> findIntakeAllegationsByIdStage(int idStage) {

    Query query = getSession()
                              .createQuery(
                                           "    select new map(c.idAllegation as idAllegation, "
                                                           + "                   c.stage.idStage as idStage, "
                                                           + "                   c.dtLastUpdate as dtLastUpdate, "
                                                           + "                   c.personByIdVictim.idPerson as personByIdVictim, "
                                                           + "                   c.personByIdAllegedPerpetrator.idPerson as personByIdAllegedPerpetrator, "
                                                           + "                   c.cdIntakeAllegType as cdIntakeAllegType, "
                                                           + "                   c.cdAllegedMalLocation as cdAllegedMalLocation, "
                                                           + "                   c.cdAllegedMalCode as cdAllegedMalCode, "
                                                           + "                   c.dtAllegedIncident as dtAllegedIncident, "
                                                           + "                   c.txtIntakeAllegDuration as txtIntakeAllegDuration, "
                                                           + "                   c.cdMaltreatorRel as cdMaltreatorRel, "
                                                           + "                   c.indMaltreatInCare as indMaltreatInCare, "
                                                           + "                   b.nmPersonFull as nmPersVictim, "
                                                           + "                   a.nmPersonFull as nmPersAllegPerp ) "
                                                           + "      from Person a "
                                                           + "right join a.intakeAllegationsForIdAllegedPerpetrator c  "
                                                           + "      join c.personByIdVictim b  "
                                                           + "     where c.stage.idStage = :idStage "
                                                           + "  order by c.idAllegation");

    query.setInteger("idStage", idStage);

    return (List<Map>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<IntakeAllegation> findAllegationsByMaltreatmentInCare (int idStage, String indMaltreatInCare) {
    Query query = getSession().createQuery(" from IntakeAllegation a, " + "        Stage s " +
                                           "where a.stage.idStage = :idStage " +
                                           " and s.idStage = :idStage " +
                                           "  and a.indMaltreatInCare = :indMaltreatInCare ");
    query.setInteger("idStage", idStage);
    query.setString("indMaltreatInCare", indMaltreatInCare);
    return (List<IntakeAllegation>) query.list();
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<Map> findIntakeAllegationByPersonByIdVictimAndIdStage(int idStage) {
    Query query = getSession()
                              .createQuery(
                                           "   select new map(b.nmPersonFull as  bnmPersonFull, "
                                                           + "                  c.nmPersonFull as nmPersonFull, "
                                                           + "                  a.personByIdVictim.idPerson as personByIdVictim, "
                                                           + "                  a.cdIntakeAllegType as cdIntakeAllegType, "
                                                           + "                  a.personByIdAllegedPerpetrator.idPerson as idPerson, "
                                                           + "                  d.cdStage as cdStage, "
                                                           + "                  a.idAllegation  as idAllegation ) "
                                                           + "     from IntakeAllegation a "
                                                           + "     join a.personByIdVictim b "
                                                           + "     join a.stage d  "
                                                           + "left join a.personByIdAllegedPerpetrator c "
                                                           + "    where a.stage.idStage = :idStage");
    query.setInteger("idStage", idStage);
    return (List<Map>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<IntakeAllegation> findAllegationAfterRemovalByIdPersonAndDtRemoval(int idPerson,  Date dtRemoval) {
    Query query = getSession().createQuery(" from IntakeAllegation a, " + "        Stage s " +
                                           "where a.personByIdVictim.idPerson = :idPerson " +
                                           "  and a.dtAllegedIncident > :dtRemoval " +
                                           "  and a.stage.idStage = s.idStage " +
                                           "  and (s.dtStageClose is null or s.dtStageClose = :maxJavaDate)");
    query.setInteger("idPerson", idPerson);
    query.setDate("dtRemoval", dtRemoval);
    query.setDate("maxJavaDate", DateHelper.MAX_JAVA_DATE);
    return (List<IntakeAllegation>) query.list();
  }
  
  public long countIntakeAllegations(int idVictimPerson, int idAllegPerpPerson, int idStage, String cdAllegType, Date dtAllegedIncident,
		                             String cdAllegedMalCode, String cdAllegedMalLocation, String cdMaltreatorRel) {
    Query query = getSession()
                              .createQuery(
                                           "select count(*) "
                                                           + "  from IntakeAllegation "
                                                           + " where personByIdVictim.idPerson = :idVictimPerson "
                                                           + "   and personByIdAllegedPerpetrator.idPerson = :idAllegPerpPerson "
                                                           + "   and stage.idStage = :idStage "
                                                           + "   and cdIntakeAllegType = :cdAllegType "
                                                           + "   and dtAllegedIncident = :dtAllegedIncident "
                                                           + "   and cdAllegedMalCode = :cdAllegedMalCode "
                                                           + "   and cdAllegedMalLocation = :cdAllegedMalLocation "
                                                           + "   and cdMaltreatorRel = :cdMaltreatorRel ");

    query.setInteger("idVictimPerson", idVictimPerson);
    query.setInteger("idAllegPerpPerson", idAllegPerpPerson);
    query.setInteger("idStage", idStage);
    query.setString("cdAllegType", cdAllegType);
    query.setDate("dtAllegedIncident", dtAllegedIncident);
    query.setString("cdAllegedMalCode", cdAllegedMalCode);
    query.setString("cdAllegedMalLocation", cdAllegedMalLocation);
    query.setString("cdMaltreatorRel", cdMaltreatorRel);
    return (Long) query.uniqueResult();
  }

  public int insertIntakeAllegation(String cdAllegType, int idStage, String cdTxtAllegDuration, int idVictim,
                                    int idAllegedPerpetrator, String indIncmgMaltreatInCare, String cdNmVictim, String cdNmPerpetrator,
                                    String cdAllegedMalLocation, String cdAllegedMalCode, Date dtAllegedIncident, String cdMaltreatorRel) {

    SQLQuery query = getSession().createSQLQuery(
                                                 "INSERT INTO INTAKE_ALLEGATION " + "     (ID_ALLEGATION, "
                                                                 + "      CD_INTAKE_ALLEG_TYPE, "
                                                                 + "      ID_ALLEGATION_STAGE, "
                                                                 + "      TXT_INTAKE_ALLEG_DURATION, "
                                                                 + "      ID_VICTIM, "
                                                                 + "      ID_ALLEGED_PERPETRATOR, "
                                                                 + "      NM_VICTIM, " + "      NM_PERPETRATOR, "
                                                                 + "      CD_ALLEGED_MAL_LOCATION, "
                                                                 + "      IND_MALTREAT_IN_CARE, "
                                                                 + "      CD_ALLEGED_MAL_CODE, "
                                                                 + "      DT_ALLEGED_INCIDENT, "
                                                                 + "      CD_MALTREATOR_REL) " + " VALUES ( "
                                                                 + "      SEQ_INTAKE_ALLEGATION.NEXTVAL, "
                                                                 + "      :cdAllegType, " + "      :idStage, "
                                                                 + "      :cdTxtAllegDuration, " + "      :idVictim, "
                                                                 + "      :idAllegedPerpetrator, "
                                                                 + "      :cdNmVictim, " + "      :cdNmPerpetrator, "
                                                                 + "      :cdAllegedMalLocation, "
                                                                 + "      :indIncmgMaltreatInCare, "
                                                                 + "      :cdAllegedMalCode, "
                                                                 + "      :dtAllegedIncident, "
                                                                 + "      :cdMaltreatorRel)");

    query.setString("cdAllegType", cdAllegType);
    query.setInteger("idStage", idStage);
    query.setString("cdTxtAllegDuration", cdTxtAllegDuration);
    query.setInteger("idVictim", idVictim);
    query.setInteger("idAllegedPerpetrator", idAllegedPerpetrator);
    query.setString("cdNmVictim", cdNmVictim);
    query.setString("cdNmPerpetrator", cdNmPerpetrator);
    query.setString("cdAllegedMalLocation", cdAllegedMalLocation);
    query.setString("indIncmgMaltreatInCare", indIncmgMaltreatInCare);
    query.setString("cdAllegedMalCode", cdAllegedMalCode);
    query.setDate("dtAllegedIncident", dtAllegedIncident);
    query.setString("cdMaltreatorRel", cdMaltreatorRel);

    return query.executeUpdate();
  }

  public int insertIntakeAllegation(String cdAllegType, int idStage, String cdTxtAllegDuration, int idVictim,
                                    String indIncmgMaltreatInCare, String cdNmVictim, String cdAllegedMalLocation,
                                    String cdAllegedMalCode, Date dtAllegedIncident, String cdMaltreatorRel) {

    SQLQuery query = getSession().createSQLQuery(
                                                 "INSERT INTO INTAKE_ALLEGATION " + "     (ID_ALLEGATION, "
                                                                 + "      CD_INTAKE_ALLEG_TYPE, "
                                                                 + "      ID_ALLEGATION_STAGE, "
                                                                 + "      TXT_INTAKE_ALLEG_DURATION, "
                                                                 + "      ID_VICTIM, " + "      NM_VICTIM, "
                                                                 + "      CD_ALLEGED_MAL_LOCATION, "
                                                                 + "      IND_MALTREAT_IN_CARE, "
                                                                 + "      CD_ALLEGED_MAL_CODE, "
                                                                 + "      DT_ALLEGED_INCIDENT, "
                                                                 + "      CD_MALTREATOR_REL) " + " VALUES ( "
                                                                 + "      SEQ_INTAKE_ALLEGATION.NEXTVAL, "
                                                                 + "      :cdAllegType, " + "      :idStage, "
                                                                 + "      :cdTxtAllegDuration, " + "      :idVictim, "
                                                                 + "      :cdNmVictim, "
                                                                 + "      :cdAllegedMalLocation, "
                                                                 + "      :indIncmgMaltreatInCare, "
                                                                 + "      :cdAllegedMalCode, "
                                                                 + "      :dtAllegedIncident, "
                                                                 + "      :cdMaltreatorRel)");

    query.setString("cdAllegType", cdAllegType);
    query.setInteger("idStage", idStage);
    query.setString("cdTxtAllegDuration", cdTxtAllegDuration);
    query.setInteger("idVictim", idVictim);
    query.setString("cdNmVictim", cdNmVictim);
    query.setString("cdAllegedMalLocation", cdAllegedMalLocation);
    query.setString("indIncmgMaltreatInCare", indIncmgMaltreatInCare);
    query.setString("cdAllegedMalCode", cdAllegedMalCode);
    query.setDate("dtAllegedIncident", dtAllegedIncident);
    query.setString("cdMaltreatorRel", cdMaltreatorRel);

    return query.executeUpdate();
  }

  public int updateIntakeAllegationIdVictimNmVictim(int idRelatedPerson, String nmPersonFull, int idPerson, int idStage) {
    Query query = getSession().createQuery(
                                           "update IntakeAllegation "
                                                           + "   set personByIdVictim.idPerson = :idRelatedPerson, "
                                                           + "       nmVictim = :nmPersonFull "
                                                           + " where personByIdVictim.idPerson = :idPerson "
                                                           + "   and stage.idStage = :idStage");
    query.setInteger("idRelatedPerson", idRelatedPerson);
    query.setString("nmPersonFull", nmPersonFull);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateIntakeAllegationIdAllegedPerpNmPerpetrator(int idRelatedPerson, String nmPersonFull, int idPerson,
                                                              int idStage) {
    Query query = getSession()
                              .createQuery(
                                           "update IntakeAllegation i "
                                                           + "   set i.personByIdAllegedPerpetrator.idPerson = :idRelatedPerson, "
                                                           + "       i.nmPerpetrator = :nmPersonFull "
                                                           + " where i.personByIdAllegedPerpetrator.idPerson = :idPerson "
                                                           + "   and i.stage.idStage = :idStage");
    query.setInteger("idRelatedPerson", idRelatedPerson);
    query.setString("nmPersonFull", nmPersonFull);
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateIntakeAllegationByPersonByIdAllegedPerpetratorIdStage(String nmPersonFull,
                                                                         int personByIdAllegedPerpetrator, int idStage) {
    Query query = getSession()
                              .createQuery(
                                           "update IntakeAllegation i "
                                                           + "   set i.nmPerpetrator = :nmPersonFull "
                                                           + " where i.personByIdAllegedPerpetrator.idPerson = :personByIdAllegedPerpetrator "
                                                           + "   and i.stage.idStage = :idStage ");
    query.setString("nmPersonFull", nmPersonFull);
    query.setInteger("personByIdAllegedPerpetrator", personByIdAllegedPerpetrator);
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }

  public int updateIntakeAllegationByPersonByIdVictimIdStage(String nmPersonFull, int personByIdVictim, int idStage) {
    Query query = getSession().createQuery(
                                           "update IntakeAllegation i " + "   set nmVictim = :nmPersonFull "
                                                           + " where i.personByIdVictim.idPerson = :personByIdVictim "
                                                           + "   and i.stage.idStage = :idStage ");
    query.setString("nmPersonFull", nmPersonFull);
    query.setInteger("personByIdVictim", personByIdVictim);
    query.setInteger("idStage", idStage);

    return query.executeUpdate();
  }

  public int updateIntakeAllegationDetails(String cdIntakeAllegType, int idStage, String cdTxtAllegDuration,
                                           int idVictim, int idAllegedPerpetrator, String cdNmVictim, String cdNmPerpetrator, 
                                           int idAllegation, String cdAllegedMalLocation, String indIncmgMaltreatInCare, 
                                           String cdAllegedMalCode, Date dtAllegedIncident, String cdMaltreatorRel) {
    Query query = getSession()
                              .createQuery(
                                           "update IntakeAllegation i "
                                                           + "   set i.cdIntakeAllegType = :cdIntakeAllegType, "
                                                           + "       i.stage.idStage = :idStage, "
                                                           + "       i.txtIntakeAllegDuration = :cdTxtAllegDuration, "
                                                           + "       i.personByIdVictim.idPerson = :idVictim, "
                                                           + "       i.personByIdAllegedPerpetrator.idPerson = :idAllegedPerpetrator, "
                                                           + "       i.nmVictim = :cdNmVictim, "
                                                           + "       i.nmPerpetrator = :cdNmPerpetrator, "
                                                           + "       i.cdAllegedMalLocation = :cdAllegedMalLocation, "
                                                           + "       i.indMaltreatInCare = :indIncmgMaltreatInCare, "
                                                           + "       i.cdAllegedMalCode = :cdAllegedMalCode, "
                                                           + "       i.dtAllegedIncident = :dtAllegedIncident, "
                                                           + "       i.cdMaltreatorRel = :cdMaltreatorRel "
                                                           + " where i.idAllegation = :idAllegation");

    query.setString("cdIntakeAllegType", cdIntakeAllegType);
    query.setInteger("idStage", idStage);
    query.setString("cdTxtAllegDuration", cdTxtAllegDuration);
    query.setInteger("idVictim", idVictim);
    query.setInteger("idAllegedPerpetrator", idAllegedPerpetrator);
    query.setString("cdNmVictim", cdNmVictim);
    query.setString("cdNmPerpetrator", cdNmPerpetrator);
    query.setInteger("idAllegation", idAllegation);
    query.setString("cdAllegedMalLocation", cdAllegedMalLocation);
    query.setString("indIncmgMaltreatInCare", indIncmgMaltreatInCare);
    query.setString("cdAllegedMalCode", cdAllegedMalCode);
    query.setDate("dtAllegedIncident", dtAllegedIncident);
    query.setString("cdMaltreatorRel", cdMaltreatorRel);
    return query.executeUpdate();
  }

  public int updateIntakeAllegationDetails(String cdIntakeAllegType, int idStage, String cdTxtAllegDuration,
                                           int idVictim, String cdNmVictim, int idAllegation, String cdAllegedMalLocation, 
                                           String indIncmgMaltreatInCare, String cdAllegedMalCode, 
                                           Date dtAllegedIncident, String cdMaltreatorRel) {
    Query query = getSession().createQuery(
                                           "update IntakeAllegation i "
                                                           + "   set i.cdIntakeAllegType = :cdIntakeAllegType, "
                                                           + "       i.stage.idStage = :idStage, "
                                                           + "       i.txtIntakeAllegDuration = :cdTxtAllegDuration, "
                                                           + "       i.personByIdVictim.idPerson = :idVictim, "
                                                           + "       i.nmVictim = :cdNmVictim, "
                                                           + "       i.cdAllegedMalLocation = :cdAllegedMalLocation, "
                                                           + "       i.indMaltreatInCare = :indIncmgMaltreatInCare, "
                                                           + "       i.cdAllegedMalCode = :cdAllegedMalCode, "
                                                           + "       i.dtAllegedIncident = :dtAllegedIncident, "
                                                           + "       i.cdMaltreatorRel = :cdMaltreatorRel "
                                                           + " where i.idAllegation = :idAllegation");

    query.setString("cdIntakeAllegType", cdIntakeAllegType);
    query.setInteger("idStage", idStage);
    query.setString("cdTxtAllegDuration", cdTxtAllegDuration);
    query.setInteger("idVictim", idVictim);
    query.setString("cdNmVictim", cdNmVictim);
    query.setInteger("idAllegation", idAllegation);
    query.setString("cdAllegedMalLocation", cdAllegedMalLocation);
    query.setString("indIncmgMaltreatInCare", indIncmgMaltreatInCare);
    query.setString("cdAllegedMalCode", cdAllegedMalCode);
    query.setDate("dtAllegedIncident", dtAllegedIncident);
    query.setString("cdMaltreatorRel", cdMaltreatorRel);
    return query.executeUpdate();
  }

  public int deleteIntakeAllegation(int idAllegation) {
    Query query = getSession().createQuery(
                                           "delete from IntakeAllegation i "
                                                           + "      where i.idAllegation = :idAllegation ");
    query.setInteger("idAllegation", idAllegation);
    return query.executeUpdate();
  }

  @SuppressWarnings( { "unchecked" })
  public List<String> findDistinctAllegationTypesByIdStage(int idStage) {
    Query query = getSession().createQuery(
                                           "select distinct cdIntakeAllegType " + "from IntakeAllegation ia "
                                                           + "where ia.stage.idStage = :idStage");
    query.setInteger("idStage", idStage);
    return (List<String>) query.list();

  }

}
