package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.db.FccpChild;
import gov.georgia.dhr.dfcs.sacwis.db.FccpChildCbx;
import gov.georgia.dhr.dfcs.sacwis.dao.FccpChildDAO;

import java.util.List;

import org.hibernate.Query;

public class FccpChildDAOImpl extends BaseDAOImpl implements FccpChildDAO {
  
  
  @SuppressWarnings( { "unchecked" })
  public List<FccpChild> findChildByIdEvent(int idEvent) {
    Query query = getSession().createQuery("     from FccpChild fc" + "    where fc.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return (List<FccpChild>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<FccpChildCbx> findChildCheckBoxByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" from  FccpChildCbx cbx " + " where cbx.fccpChild.idEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);
    return (List<FccpChildCbx>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public List<FccpChildCbx> findchildcheckboxbyIdEventandCbxCodeType(int idEvent, String cdCbxType) {
    Query query = getSession().createQuery(
                                           " from  FccpChildCbx cbx " + " where cbx.fccpChild.idEvent = :idEvent "
                                                           + " and cbx.cdCbxCodeType = :cdCbxType");
    query.setInteger("idEvent", idEvent);
    query.setString("cdCbxType", cdCbxType);
    return (List<FccpChildCbx>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public FccpChild findLatestChildPlanByIdStageByCdEventType(int idStage) {
    String cdEventType = CodesTables.CEVNTTYP_CSP;
    String cdEventStatus = CodesTables.CEVTSTAT_COMP;
    Query query = getSession().createQuery(
                                           " from FccpChild fc " + " where fc.event.idEvent in (select idEvent "
                                                           + "                 from Event e "
                                                           + "                 where e.stage.idStage = :idStage "
                                                           + "                 and e.cdEventType = :cdEventType "
                                                           + "                 and e.cdEventStatus = :cdEventStatus ) "
                                                           + " order by dtLastUpdate desc )");
    query.setInteger("idStage", idStage);
    query.setString("cdEventType", cdEventType);
    query.setString("cdEventStatus", cdEventStatus);
    return (FccpChild) firstResult(query);
  }
  
  @SuppressWarnings( { "unchecked" })
  public FccpChild findLatestChildPlanByIdCaseByIdPersonByCdEventType(int idCase, int idPerson) {
    String cdEventType = CodesTables.CEVNTTYP_CSP;
    String cdEventStatus = CodesTables.CEVTSTAT_COMP;
    String cdPersonRole = CodesTables.CROLEALL_PC;
    Query query = getSession().createQuery(
                                           " from FccpChild fc " + " where fc.event.idEvent in (select e.idEvent "
                                                           + "                 from Event e, StagePersonLink spl "
                                                           + "                 where e.capsCase.idCase = :idCase "
                                                           + "                 and e.cdEventType = :cdEventType "
                                                           + "                 and e.cdEventStatus = :cdEventStatus" 
                                                           + "                 and e.stage.idStage = spl.stage.idStage"
                                                           + "                 and spl.cdStagePersRole = :cdPersonRole " 
                                                           + "                 and spl.person.idPerson = :idPerson) "
                                                           + " order by dtLastUpdate desc )");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventType", cdEventType);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("cdPersonRole", cdPersonRole);
    return (FccpChild) firstResult(query);
  }
  
  public void deleteChildPlanChkBxByIdEvent(int idEvent, String cbxtype) {
    Query query = getSession().createQuery(" delete from FccpChildCbx cbx " +
                                           "       where cbx.fccpChild.idEvent = :idEvent " +
                                           "       and cbx.cdCbxCodeType = :cbxtype");
    query.setInteger("idEvent", idEvent);
    query.setString("cbxtype", cbxtype);
    query.executeUpdate();
  }
  
  public void InsertChildPlanDetail(FccpChild fccpchild) {
    getSession().saveOrUpdate(fccpchild);
  }

  public void InsertChildPlanCheckBox(FccpChildCbx fccpchildcbx) {
    getSession().saveOrUpdate(fccpchildcbx);
  }

  public String findEventCdEventStatus(int idEvent) {
    Query query = getSession().createQuery("select e.cdEventStatus " +
                                           "  from Event e " +
                                           " where e.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return (String) firstResult(query);
  }

  public Integer findPrimaryChildForStage(int idStage) {
    Query query = getSession().createQuery("select sp.person.idPerson " +
                                           "  from StagePersonLink sp " +
                                           " where sp.stage.idStage = :idStage " +
                                           " and sp.cdStagePersRole = 'PC' ");
    query.setInteger("idStage", idStage);
    return (Integer) firstResult(query);
  }
}
