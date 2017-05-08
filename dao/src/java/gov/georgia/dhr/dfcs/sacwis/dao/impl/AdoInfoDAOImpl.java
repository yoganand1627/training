//*  Class  Name:     AdoInfoDAOImpl
//*  Created by:   Jacob Vaidyan
//*  Date Created: 2/18/2007
//*
//*  Description:Provides implementation for AdoInfoDAO Interface .
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**
//**  
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfo;
import gov.georgia.dhr.dfcs.sacwis.db.Event;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

/*
 
   Change History:
   Date      User          Description
   --------  --------      --------------------------------------------------
  03/02/09   mxpatel       STGAP00012533: wrote findDateDocSentByIdEventChildRegistration and 
                           findDatePermFileByIdEventChildRegistration methods to retrieve permission
                           to file and document sent dates.
  03/03/09   cwells        STGAP00012645: adding additional parameter to the findLatestAdoptionInformationByStage
                           and findCurrentAdoptionInformationByIdPerson methods to order by both date event occurred and id event since
                           the dtEventOccurred is not time stamped 
  06/12/09   mxpatel       STGAP00013445: added findLatestAdoInfoByIdChildRegEvent method to retrieve the latest Adoption Information event
  07/24/09   mxpatel       STGAP00014202: added method findDateDecAdoptByIdResource to find the "Foster Parents Notified Agency of Decision to Adopt" 
                           date from adoption information where "Decision Outcome" is "Y".
  10/12/11   hjbaptiste    MR-092: Fostering Connection - Added findLatestCompletedAdoptionInformationByStage to find the most
                           recent completed (COMP) first Best Interest Language legal action
                       
*/

public class AdoInfoDAOImpl extends BaseDAOImpl implements  AdoInfoDAO {
 
  @SuppressWarnings( { "unchecked" })
  
  public List<AdoInfo> findAdoInfoByIdEvent(int idEvent) {

    Query query = getSession().createQuery("     from AdoInfo ai" + "    where ai.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return (List<AdoInfo>) query.list();
  }
  
  // STGAP00014202 - find the "Foster Parents Notified Agency of Decision to Adopt" date from adoption information where
  // "Decision Outcome" is "Y".
  public Date findDateDecAdoptByIdResource(int idResource) {
    
    Query query = getSession().createQuery(
                                           " select a.dtDecAdopt from AdoInfo a, Event e "
                                                           + "   where a.capsResource.idResource = :idResource "
                                                           + " and a.event.idEvent = e.idEvent "
                                                           + " and a.dtDecAdopt is not null "
                                                           + " and a.indFpAdo = :indYes "
                                                           + " order by e.dtEventOccurred Desc, e.idEvent Desc ");
    query.setInteger("idResource", idResource);
    query.setString("indYes", ArchitectureConstants.Y);
    return (Date) firstResult(query);
  }

  public AdoInfo findAdoInfoByIdChildRegEvent(int idChildRegEvent) {

    Query query = getSession().createQuery("     from AdoInfo ai" 
                                                  + "    where ai.eventByIdEventChildRegistration.idEvent = :idChildRegEvent "
                                                  + " order by ai.event.idEvent asc ");
    query.setInteger("idChildRegEvent", idChildRegEvent);
    return (AdoInfo) firstResult(query);
  }

  // mxpatel added this for defect #STGAP00013445 to retrieve the latest Adoption Information event
  public AdoInfo findLatestAdoInfoByIdChildRegEvent(int idChildRegEvent) {      

    Query query = getSession()
                              .createQuery(
                                           "     from AdoInfo ai"
                                                           + "    where ai.eventByIdEventChildRegistration.idEvent = :idChildRegEvent "
                                                           + " order by ai.event.idEvent desc ");
    query.setInteger("idChildRegEvent", idChildRegEvent);
    return (AdoInfo) firstResult(query);
  }
  

  public AdoInfo findAdoInformation(int idEvent) {
    Query query = getSession().createQuery(
                                           "  from AdoInfo a "
                                                   + "  where a.event.idEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);
    return (AdoInfo) firstResult(query);
  }
  
  @SuppressWarnings( { "unchecked" })
  
  public void saveAdoInfoDetail(AdoInfo adoinfo) {

    getSession().saveOrUpdate(adoinfo);

  }
  
  public AdoInfo findLatestAdoptionInformationByStage(int idEventStage) {
	    Query query = getSession().createQuery(
	                                           " select a from Event e, AdoInfo a " + "   where e.stage.idStage = :idEventStage "
	                                                           + "     and e.cdEventType = 'ADO' "
	                                                           + " and e.idEvent = a.event.idEvent "
	                                                           + "order by e.dtEventOccurred desc , e.idEvent desc");
	    query.setInteger("idEventStage", idEventStage);
	    return (AdoInfo) firstResult(query);
  }
  
  public AdoInfo findLatestCompletedAdoptionInformationByStage(int idEventStage) {
    Query query = getSession().createQuery(
                                           " select a from Event e, AdoInfo a " + "   where e.stage.idStage = :idEventStage "
                                                           + "     and e.cdEventType = 'ADO' "
                                                           + " and e.idEvent = a.event.idEvent "
                                                           + " and e.cdEventStatus = 'COMP'"
                                                           + "order by e.dtEventOccurred desc , e.idEvent desc");
    query.setInteger("idEventStage", idEventStage);
    return (AdoInfo) firstResult(query);
}

  public AdoInfo findCurrentAdoptionInformationByIdPerson(int idPerson) {       
	    Query query = getSession().createQuery(
	                                           " select a from Event e, AdoInfo a, StagePersonLink spl " 
	                                                           + "  where e.cdEventType = 'ADO' "
	                                                           + " and e.idEvent = a.event.idEvent "
	                                                           + " and e.cdEventStatus = 'PROC'"
	                                                           + " and spl.stage.idStage = e.stage.idStage"
	                                                           + " and spl.person.idPerson = :idPerson"
	                                                           + " and spl.cdStagePersType = 'PRN'"
	                                                           + " and spl.cdStagePersRole = 'PC'"
	                                                           + "order by e.dtEventOccurred desc, e.idEvent desc");
	    query.setInteger("idPerson", idPerson);
	    return (AdoInfo) firstResult(query);
  }
  
  // mxpatel 12533
  public Date findDateDocSentByIdEventChildRegistration(int idEvent) {
    Query query = getSession().createQuery(
                                           "select a.dtDocSent from AdoInfo a "
                                                           + " where a.eventByIdEventChildRegistration = :idEvent"
                                                           + " order by a.event.idEvent asc");
    query.setLong("idEvent", idEvent);
    return (Date) firstResult(query);

  }

  // mxpatel 12533
  public Date findDatePermFileByIdEventChildRegistration(int idEvent) {
    Query query = getSession().createQuery(
                                           "select a.dtPermFile from AdoInfo a "
                                                           + " where a.eventByIdEventChildRegistration = :idEvent" 
                                                           + " order by a.event.idEvent asc");
    query.setLong("idEvent", idEvent);
    return (Date) firstResult(query);

  }
  
}
