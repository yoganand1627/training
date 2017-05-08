package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.RelativeCareAssmtPersonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.RelativeCareAssmt;
import gov.georgia.dhr.dfcs.sacwis.db.RelativeCareAssmtPerson;

import java.util.List;


import org.hibernate.Query;

public class RelativeCareAssmtPersonDAOImpl extends BaseDAOImpl implements RelativeCareAssmtPersonDAO{
  
  @SuppressWarnings({"unchecked"})      
  public List<RelativeCareAssmtPerson> findRelativeCareAssmtPersonByIdRcaEvent(int idRcaEvent){
    Query query = getSession().createQuery("from RelativeCareAssmtPerson where eventByIdRcaEvent.idEvent=:idRcaEvent");
    query.setInteger("idRcaEvent", idRcaEvent);
    return (List<RelativeCareAssmtPerson>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<RelativeCareAssmtPerson> findRelativeCareAssmtPersonByIdRcaEventCdPersonType(int idRcaEvent, String cdPersonIdType){
    Query query = getSession().createQuery("from RelativeCareAssmtPerson where eventByIdRcaEvent.idEvent=:idRcaEvent " +
                                           "      and cdPersonType = :cdPersonIdType " +
                                           "      order by idRcaPerson desc ");
    query.setInteger("idRcaEvent", idRcaEvent);
    query.setString("cdPersonIdType", cdPersonIdType);
    return (List<RelativeCareAssmtPerson>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<Integer> findRelativeCareAssmtPersonByIdRcaEventCdPersonTypes(int idRcaEvent, List<String> cdPersonTypes){
    Query query = getSession().createQuery("select personByIdPerson.idPerson from RelativeCareAssmtPerson rca where rca.eventByIdRcaEvent.idEvent=:idRcaEvent " +
                                           "      and rca.cdPersonType in (:cdPersonTypes )" +
                                           "      order by idRcaPerson desc ");
    query.setInteger("idRcaEvent", idRcaEvent);
    query.setParameterList("cdPersonTypes", cdPersonTypes);
    return (List<Integer>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public void saveOrUpdateRelativeCareAssmtPerson(RelativeCareAssmtPerson personInfo){
    getSession().saveOrUpdate(personInfo);
  }
  
  public int deleteRelativeCareAssmtPersons(int idRcaEvent) {
    Query query = getSession().createQuery("delete from RelativeCareAssmtPerson where eventByIdRcaEvent.idEvent=:idRcaEvent");
    query.setInteger("idRcaEvent", idRcaEvent);
    return query.executeUpdate();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<Integer> findIdPersonByIdEvent(int idEvent) {
    Query query = getSession().createQuery(
                                           " select rcap.personByIdPerson.idPerson" + " from RelativeCareAssmtPerson rcap"
                                                           + " where rcap.eventByIdRcaEvent.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return (List<Integer>) query.list();
  }
  

}
