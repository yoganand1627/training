package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.PsaPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PsaPersonLink;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class PsaPersonLinkDAOImpl extends BaseDAOImpl implements PsaPersonLinkDAO {
  @SuppressWarnings( { "unchecked" })
  public List<Object[]> findPersonsAbsconded(int idStage) {
    SQLQuery query = getSession().createSQLQuery(  "SELECT ppl.ID_PERSON, "
                                                 + "       p.NM_PERSON_FULL, "
                                                 + "       p.DT_PERSON_BIRTH, "
                                                 + "       p.NBR_PERSON_ID_NUMBER, "
                                                 + "       p.CD_PERSON_ETHNIC_GROUP, "
                                                 + "       eth.CD_ETHNICITY, "
                                                 + "       p.CD_PERSON_SEX, "
                                                 + "       p.CD_PERSON_STATUS "
                                                 + "  FROM PSA_PERSON_LINK ppl "
                                                 + "    inner join PROTECTIVE_SERVICE_ALERT psa "
                                                 + "      ON ppl.ID_PROTECTIVE_SERVICE_ALERT=psa.ID_PROTECTIVE_SERVICE_ALERT "
                                                 + "    inner join PERSON p "
                                                 + "      ON ppl.ID_PERSON=p.ID_PERSON "
                                                 + "    left join PERSON_ETHNICITY eth "
                                                 + "      ON (eth.ID_PERSON=ppl.ID_PERSON "
                                                 + "          OR eth.id_person IS NULL) "
                                                 + " WHERE psa.ID_STAGE=:idStage "
                                                 + "   AND (ppl.DT_DEACTIVATED IS NULL "
                                                 + "        OR ppl.DT_DEACTIVATED='') "
                                                 + "   AND (eth.ID_PERSON_ETHNICITY=(SELECT e.id_person_ethnicity "
                                                 + "                                   FROM PERSON_ETHNICITY e "
                                                 + "                                  WHERE e.id_person=ppl.id_person "
                                                 + "                                    AND e.dt_last_update=(SELECT MAX(pe.dt_last_update) "
                                                 + "                                                            FROM PERSON_ETHNICITY pe "
                                                 + "                                                           WHERE pe.id_person=ppl.id_person)) "
                                                 + "        OR eth.ID_PERSON_ETHNICITY IS NULL)");
    query.setInteger("idStage", idStage);
    return (List<Object[]>) query.list();
  }
  
  public void savePsaPersonLink(PsaPersonLink psaPersonLink) {
    getSession().saveOrUpdate(psaPersonLink);
  }

  @SuppressWarnings( { "unchecked" })
  public List<PsaPersonLink> findActivePsaPersonLinksByIdPerson(int idPerson){
    Query query = getSession().createQuery("select ppl "
                                           + "from PsaPersonLink ppl "
                                           + "where ppl.person.idPerson = :idPerson "
                                           + "and (ppl.dtDeactivated is null "
                                           + "or ppl.dtDeactivated = '')");
    query.setInteger("idPerson", idPerson);
    return (List<PsaPersonLink>) query.list();
  }
  
  public long countActivePsa(int idPerson) {
    Query query = getSession().createQuery("select count(*) from PsaPersonLink ppl " +
                " where ppl.person.idPerson = :idPerson " +
                " and (ppl.dtDeactivated is null " +
                " or ppl.dtDeactivated = '')"); 
    
    query.setInteger("idPerson", idPerson);                                       
    return (Long) query.uniqueResult();
  }
  
  public Integer findIdStageForEarliestPSAByIdPerson(int idPerson){
    Query query = getSession().createQuery("select ppl.psa.stage.idStage "
                                           + "from PsaPersonLink ppl "
                                           + "where ppl.person.idPerson = :idPerson "
                                           + "and (ppl.dtDeactivated is null "
                                           + "or ppl.dtDeactivated = '') "
                                           + "and ppl.dtActivated = (select min(p.dtActivated) "
                                           + "from PsaPersonLink p "
                                           + "where p.person.idPerson = :idPerson "
                                           + "and (p.dtDeactivated is null "
                                           + "or p.dtDeactivated = ''))");
    query.setInteger("idPerson", idPerson);
    return (Integer) query.uniqueResult();
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<Integer> findActivePsaByPersonList(Collection<Integer> idPersons) {
    Query query = getSession().createQuery(" SELECT p.idPerson FROM Person p " +
                " WHERE p.idPerson IN (:idPersons) AND " +
                " 0 < (SELECT COUNT (*) FROM PsaPersonLink ppl  " +
                " WHERE ppl.person.idPerson = p.idPerson AND " +
                " (ppl.dtDeactivated IS NULL or ppl.dtDeactivated = '')) ");
    query.setParameterList("idPersons", idPersons);
    return (List<Integer>) query.list();
  }
}
