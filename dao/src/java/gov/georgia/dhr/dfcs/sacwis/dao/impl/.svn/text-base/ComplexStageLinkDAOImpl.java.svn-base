package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStageLinkDAO;

public class ComplexStageLinkDAOImpl extends BaseDAOImpl implements ComplexStageLinkDAO {

  public Integer findPreviousIdStageByIdStage(int idStage) {
    Integer idPriorStage = 0;
    Query query = getSession().createQuery(
                                           "  select sl.stageByIdPriorStage.idStage " 
                                                     + "     from StageLink sl "
                                                     + "    where sl.stageByIdStage.idStage = :idStage ");

    query.setInteger("idStage", idStage);
    query.setMaxResults(1);
    List list = query.list();
    if (list.size() > 0) {
      idPriorStage = (Integer) list.get(0);
    }
    return idPriorStage;
  }
  
  public Integer findPreviousIdStageByIdStageByCdStage(int idStage) {
    Integer idPriorStage = 0;
    Query query = getSession().createQuery(
                                           "  select sl.stageByIdPriorStage.idStage " 
                                                     + "     from StageLink sl "
                                                     + "    where sl.stageByIdStage.idStage = :idStage "
                                                     + "    and sl.stageByIdPriorStage.cdStage = :cdStage ");

    query.setInteger("idStage", idStage);
    query.setString("cdStage", CodesTables.CSTAGES_ADO);
    query.setMaxResults(1);
    List list = query.list();
    if (list.size() > 0) {
      idPriorStage = (Integer) list.get(0);
    }
    return idPriorStage;
  }

}
