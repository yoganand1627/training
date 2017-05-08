package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.StageLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StageLink;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

/**
 * This is the DAO class is used for the STAGE_LINK table
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  11/25/09  arege     SMS#37361 Added findStageLinkByIdStageAndCdStage() to find if the previous stage is the given stage  
 *  03/03/10  cwells    Capta Dev: Added method findAllProgressedToStagesByIdStageIdStageType()   
 *  02/07/12  htvo      STGAP00017831: MR-102 - Added method findPriorStageByIdCurrStage(int idStage)
 *  
 * </pre>
 */

public class StageLinkDAOImpl extends BaseDAOImpl implements StageLinkDAO {
  public Map findStageLinkPreviousStage(int idStage) {

    Query query = getSession().createQuery(
                                           " select new map(" + "   s.idStage as idStage,  "
                                                           + "   s.dtLastUpdate as dtLastUpdate,  "
                                                           + "   s.cdStageType as cdStageType,  "
                                                           + "   s.unit.idUnit as idUnit,  "
                                                           + "   s.capsCase.idCase as idCase,  "
                                                           + "   s.dtStageClose as dtStageClose,  "
                                                           + "   s.cdStageClassification as cdStageClassification,  "
                                                           + "   s.cdStageCurrPriority as cdStageCurrPriority,  "
                                                           + "   s.cdStageInitialPriority as cdStageInitialPriority,  "
                                                           + "   s.cdStageRsnPriorityChgd as cdStageRsnPriorityChgd,  "
                                                           + "   s.cdStageReasonClosed as cdStageReasonClosed,  "
                                                           + "   s.indStageClose as indStageClose,  "
                                                           + "   s.txtStagePriorityCmnts as txtStagePriorityCmnts,  "
                                                           + "   s.cdStageCnty as cdStageCnty,  "
                                                           + "   s.nmStage as nmStage,  "
                                                           + "   s.cdStageRegion as cdStageRegion,  "
                                                           + "   s.dtStageStart as dtStageStart,  "
                                                           + "   s.situation.idSituation as idSituation,  "
                                                           + "   s.cdStageProgram as cdStageProgram,  "
                                                           + "   s.cdStage as cdStage,  "
                                                           + "   s.txtStageClosureCmnts as txtStageClosureCmnts,  "
                                                           + "   sl.idStageLink as idStageLink,  "
                                                           + "   sl.stageByIdPriorStage as idPriorStage)"
                                                           + " from StageLink sl " + " join sl.stageByIdPriorStage s"
                                                           + " where sl.stageByIdPriorStage.idStage = :idStage ");

    query.setInteger("idStage", idStage);
    return (Map) firstResult(query);
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<Map> findAllProgressedToStagesByIdStageIdStageType(int idPrevStage, String cdStageTypes) {
    Query query = getSession()
                              .createQuery(
                                           "  select new map(s.capsCase.idCase as idCase, "
                                                           + "                 s.cdStage as cdStage, "
                                                           + "                 s.idStage as idStage, "
                                                           + "                 s.nmStage as nmStage, "
                                                           + "                 s.dtStageStart as dtStageStart) "
                                                           + "    from StageLink sl "
                                                           + "         join sl.stageByIdStage s "
                                                           + "   where sl.stageByIdPriorStage.idStage = :idPrevStage "
                                                           + "     and s.cdStage in (:cdStageTypes) ");
    query.setInteger("idPrevStage", idPrevStage);
    query.setString("cdStageTypes", cdStageTypes);
    return (List<Map>) query.list();
  }
  

  public Integer findStageLinkByIdStage(int idStage) {

    Query query = getSession().createQuery(
                                           "select distinct sl.stageByIdStage.idStage" + "   from StageLink sl"
                                                           + "  where sl.stageByIdStage.cdStage in ('sub',"
                                                           + "                'fsu')"
                                                           + "    and sl.stageByIdPriorStage = :idStage");

    query.setInteger("idStage", idStage);

    return (Integer) firstResult(query);
  }

  public Integer findStageLinkMostRecentlyClosedPreviousIdStage(int idStage) {

    Query query = getSession().createQuery(
                                           "  select l.stageByIdPriorStage.idStage " + "     from StageLink l "
                                                           + "    where l.stageByIdStage.idStage = :idStage " +
                                                           // " and l.stageByIdStage.dtStageClose is null " +
                                                           " order by l.stageByIdStage.dtStageClose desc ");

    query.setInteger("idStage", idStage);

    return (Integer) firstResult(query);
  }

  public Integer findPreviousIdStagebyIdStage(int idStage) {

    Query query = getSession().createQuery(
                                           "  select sl.stageByIdPriorStage.idStage " + "     from StageLink sl "
                                                           + "    where sl.stageByIdStage.idStage = :idStage ");

    query.setInteger("idStage", idStage);

    return (Integer) firstResult(query);
  }

  public void saveStageLink(StageLink stageLink) {
    getSession().saveOrUpdate(stageLink);
  }
  
  //STGAP00010006: Gets the previous stage id if the previous stage is ADO
  public Integer findPreviousIdStageByIdStageByCdStage(int idStage) {
    Query query = getSession().createQuery(
                                           "  select sl.stageByIdPriorStage.idStage " 
                                                     + "     from StageLink sl "
                                                     + "    where sl.stageByIdStage.idStage = :idStage "
                                                     + "    and sl.stageByIdPriorStage.cdStage = :cdStage ");

    query.setInteger("idStage", idStage);
    query.setString("cdStage", CodesTables.CSTAGES_ADO);

    return (Integer) firstResult(query);
  }
  
  public Integer findNewIdPADStageByIdPriorStage(int idPriorStage) {
    Query query = getSession().createQuery(
                                           "  select sl.stageByIdStage.idStage " 
                                                     + "    from StageLink sl "
                                                     + "    where sl.stageByIdPriorStage.idStage = :idPriorStage "
                                                     + "    and sl.stageByIdStage.cdStage = :cdStage ");

    query.setInteger("idPriorStage", idPriorStage);
    query.setString("cdStage", CodesTables.CSTAGES_PAD);

    return (Integer) firstResult(query);
  }
  
  // STGAP00012534 : Gets the new PAD case id based on the prior stage id
  public Integer findNewIdPADCaseByIdPriorStage(int idPriorStage) {
    Query query = getSession().createQuery(
                                           "  select sl.capsCase.idCase " 
                                                     + "    from StageLink sl "
                                                     + "    where sl.stageByIdPriorStage.idStage = :idPriorStage "
                                                     + "    and sl.stageByIdStage.cdStage = :cdStage ");

    query.setInteger("idPriorStage", idPriorStage);
    query.setString("cdStage", CodesTables.CSTAGES_PAD);

    return (Integer) firstResult(query);
  }
  
  
  // STGAP00014341 : Gets the new idStage based on the prior stage id
  public Stage findNewIdStageByIdPriorStage(int idPriorStage) {
    Query query = getSession().createQuery(
                                           "  select sl.stageByIdStage " 
                                         + "    from StageLink sl "
                                         + "    where sl.stageByIdPriorStage.idStage = :idPriorStage ");

    query.setInteger("idPriorStage", idPriorStage);
    return (Stage) firstResult(query);
  }
  
  //SMS#37361 Added this method to find if the Previous stage of the given stageid is one of the given cdstage list.
  // For this defect it will see if the previous stage for the given PAD is an FCC or ADO stage and this will ensure that 
  // the case is incident case if it returns the idStage (PAD)

  public Integer findStageLinkByIdStageAndCdStage(int idStage, Collection<String>  cdStages) {

    Query query = getSession().createQuery(
                                           "select distinct sl.stageByIdStage.idStage" + "   from StageLink sl"
                                                           + "  where sl.stageByIdStage.idStage = :idStage " 
                                                           + "  and sl.stageByIdPriorStage.cdStage in ( :cdStages ) ");
    
    query.setInteger("idStage", idStage);
    query.setParameterList("cdStages", cdStages);
    return (Integer) firstResult(query);
  }
  
  public Stage findPriorStageByIdCurrStage(int idStage) {
    Query query = getSession().createQuery(
                                           "select distinct sl.stageByIdPriorStage" + "   from StageLink sl"
                                                           + "  where sl.stageByIdStage.idStage = :idStage "
                                                           + "  and sl.stageByIdStage.capsCase.idCase = sl.stageByIdPriorStage.capsCase.idCase ");
    
    query.setInteger("idStage", idStage);
    return (Stage) firstResult(query);
  }
}
