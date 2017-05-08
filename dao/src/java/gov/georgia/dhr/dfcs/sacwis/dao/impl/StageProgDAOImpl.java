package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.StageProgDAO;
import gov.georgia.dhr.dfcs.sacwis.db.StageProg;
import org.hibernate.Query;

public class StageProgDAOImpl extends BaseDAOImpl implements StageProgDAO {
  @SuppressWarnings({"unchecked"})
  public List<StageProg> findStageProgByCdStageProgStageCdStageProgProgramCdStageProgRsnClose(String cdStageProgStage,
                                                                                              String cdStageProgProgram,
                                                                                              String cdStageProgRsnClose) {

    Query query = getSession().createQuery("   from StageProg s " +
                                           "  where s.cdStageProgStage = :cdStageProgStage " +
                                           "    and s.cdStageProgProgram = :cdStageProgProgram " +
                                           "    and s.cdStageProgRsnClose = :cdStageProgRsnClose ");

    query.setString("cdStageProgStage", cdStageProgStage);
    query.setString("cdStageProgProgram", cdStageProgProgram);
    query.setString("cdStageProgRsnClose", cdStageProgRsnClose);

    return (List<StageProg>) query.list();
  }
}
