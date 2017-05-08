/**
 * Created on Apr 25, 2006 at 9:51:15 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicStageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class DynamicStageDAOImpl extends DynamicBaseDAOImpl implements DynamicStageDAO {
  public long countStages(int idCase, String cdStage, int idStage) {
    if(oneNullArg(idCase, cdStage)) {
      return 0;
    }
    
    Criteria criteria = getSession().createCriteria(Stage.class);
    criteria.setProjection(Projections.count("idStage"));
    criteria.add(Restrictions.eq("capsCase.idCase", idCase));
    criteria.add(Restrictions.eq("cdStage", cdStage));
    criteria.add(Restrictions.ne("idStage", idStage));
    if (CodesTables.CSTAGES_ADO.equals(cdStage)) {
      criteria.add(Restrictions.or(Restrictions.eq("cdStageReasonClosed", CodesTables.CCLOSADO_010),
                                   Restrictions.isNull("cdStageReasonClosed")));
    } else {
      criteria.add(Restrictions.isNull("cdStageReasonClosed"));
    }
    return (Integer) criteria.uniqueResult();
  }
}
