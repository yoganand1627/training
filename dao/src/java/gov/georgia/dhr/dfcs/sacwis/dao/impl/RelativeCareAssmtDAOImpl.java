package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.RelativeCareAssmtDAO;
import gov.georgia.dhr.dfcs.sacwis.db.RelativeCareAssmt;

import java.util.Map;
import java.util.Collection;

public class RelativeCareAssmtDAOImpl extends BaseDAOImpl implements RelativeCareAssmtDAO {

  public RelativeCareAssmt findRelativeCareAssmtByIdEvent(int idEvent) {
    Query query = getSession().createQuery("   from RelativeCareAssmt rca" + "   where rca.idRcaEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return (RelativeCareAssmt) firstResult(query);
  }

  public void deleteRelativeCareAssmtByIdEvent(int idEvent) {
    Query query = getSession().createQuery(
                                           "   delete from RelativeCareAssmt rca"
                                                           + "   where rca.idRcaEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    query.executeUpdate();
  }

  public void saveOrUpdateRelativeCareAssmt(RelativeCareAssmt rca) {
    getSession().saveOrUpdate(rca);
  }

  public Map findRelativeCareAssmtByIdStageByIdPerson(int idStage, int idPerson) {
    Query query = getSession()
                              .createQuery(
                                           " select new map (rca.dtComplete as dtComplete, "
                                                           + " rca.cdAssmtResults as cdAssmtResults, "
                                                           + " rca.txtComments as txtComments, "
                                                           + " rca.dtDecision as dtDecision, "
                                                           + " rcap.personByIdPerson.idPerson as idPerson, "
                                                           + " spl.person.nmPersonFull as nmPersonFull, "
                                                           + " spl.cdStagePersRelInt as cdStagePersRelInt ) "
                                                           + " from RelativeCareAssmt rca, RelativeCareAssmtPerson rcap, "
                                                           + " StagePersonLink spl "
                                                           + " where rca.event.stage.idStage = :idStage "
                                                           + " and rca.event.cdEventStatus = 'APRV' "
                                                           + " and rca.event.cdEventType = 'ASM'"
                                                           + " and rca.event.idEvent = rcap.eventByIdRcaEvent.idEvent "
                                                           + " and rca.event.stage.idStage = spl.stage.idStage "
                                                           + " and rcap.personByIdPerson.idPerson = spl.person.idPerson "
                                                           + " and rcap.cdPersonType = 'PRC' "
                                                           + " and rcap.personByIdPerson.idPerson = :idPerson "
                                                           + " order by rca.event.dtLastUpdate desc ");

    query.setInteger("idStage", idStage);
    query.setInteger("idPerson", idPerson);
    return (Map) firstResult(query);
  }

  public Map findRelativeCareAssmtByIdStage(int idStage) {
    Query query = getSession()
                              .createQuery(
                                           " select new map (rca.dtComplete as dtComplete, "
                                                           + " rca.cdAssmtResults as cdAssmtResults, "
                                                           + " rca.txtComments as txtComments, "
                                                           + " rca.dtDecision as dtDecision, "
                                                           + " spl.person.nmPersonFull as nmPersonFull, "
                                                           + " spl.cdStagePersType as cdStagePersType, "
                                                           + " spl.cdStagePersRelInt as cdStagePersRelInt ) "
                                                           + " from RelativeCareAssmt rca, "
                                                           + " StagePersonLink spl "
                                                           + " where rca.event.stage.idStage = :idStage "
                                                           + " and rca.event.cdEventStatus = 'APRV' "
                                                           + " and rca.event.cdEventType = 'ASM' "
                                                           + " and rca.event.stage.idStage = spl.stage.idStage "
                                                           + " order by rca.event.dtLastUpdate desc ");

    query.setInteger("idStage", idStage);
    return (Map) firstResult(query);
  }

  public Map findRelativeCareAssmtByIdStageBycdPersonType(int idStage, Collection<String> relativeCodes) {
    Query query = getSession()
                              .createQuery(
                                           " select new map (rca.dtComplete as dtComplete, "
                                                           + " rca.cdAssmtResults as cdAssmtResults, "
                                                           + " rca.txtComments as txtComments, "
                                                           + " rcap.personByIdPerson.idPerson as idPerson, "
                                                           + " spl.person.nmPersonFull as nmPersonFull, "
                                                           + " spl.cdStagePersType as cdStagePersType, "
                                                           + " spl.cdStagePersRelInt as cdStagePersRelInt ) "
                                                           + " from RelativeCareAssmt rca, RelativeCareAssmtPerson rcap, "
                                                           + " StagePersonLink spl "
                                                           + " where rca.event.stage.idStage = :idStage "
                                                           + " and rca.event.cdEventStatus = 'APRV' "
                                                           + " and rca.event.cdEventType = 'ASM' "
                                                           + " and rca.event.idEvent = rcap.eventByIdRcaEvent.idEvent "
                                                           + " and rca.event.stage.idStage = spl.stage.idStage "
                                                           + " and rcap.personByIdPerson.idPerson = spl.person.idPerson "
                                                           + " and spl.cdStagePersRelInt in (:relativeCodes)"
                                                           + " and rcap.cdPersonType = 'PRC' ");

    query.setInteger("idStage", idStage);
    query.setParameterList("relativeCodes", relativeCodes);
    return (Map) firstResult(query);
  }
  
  //STGAP00007630: Modified this method to retrieve the approved relative care assessment for the given stage 
  //which has the child listed as a 'Child to be placed'.
  public RelativeCareAssmt findRelativeApprvByIdStage(int idPerson, int idStage, String personType) {
    Query query = getSession().createQuery(
                                           " select rca" + " from RelativeCareAssmt rca, Event e, RelativeCareAssmtPerson rcap"
                                                           + " where rca.idRcaEvent = e.idEvent " +
                                                                        " and e.stage.idStage = :idStage"
                                                           + " and rcap.personByIdPerson = :idPerson"
                                                           + " and rcap.cdPersonType = :personType"
                                                           + " and e.cdEventStatus = 'APRV' ");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idStage", idStage);
    query.setString("personType", personType);
    return (RelativeCareAssmt) firstResult(query);
  }
  
  //SMS#108265
  public RelativeCareAssmt findRelativeAssmtApprv( int idStage ) {
    Query query = getSession().createQuery(
                                           " select rca" + " from RelativeCareAssmt rca, Event e "
                                                           + " where rca.idRcaEvent = e.idEvent " +
                                                                        " and e.stage.idStage = :idStage"
                                                           + " and rca.cdAssmtResults in ( 'APP', 'AWC' )"
                                                           + " and e.cdEventStatus = 'APRV' ");
    query.setInteger("idStage", idStage);
    return (RelativeCareAssmt) firstResult(query);
  }

  public RelativeCareAssmt findRelativeApprv(int idPerson) {
    Query query = getSession().createQuery(
                                           " select rca" + " from RelativeCareAssmt rca, Event e"
                                                           + " where rca.idRcaEvent = e.idEvent"
                                                           + " and rca.capsResourceByIdResource.idResource = :idPerson"
                                                           + " and e.cdEventStatus = 'APRV' ");
    query.setInteger("idPerson", idPerson);
    return (RelativeCareAssmt) firstResult(query);
  }
}
