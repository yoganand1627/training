package gov.georgia.dhr.dfcs.sacwis.launcher.dao;

import java.util.List;
import java.util.Map;

public interface StagePersonLinkLnchrDAO {

  public List<Map> findPersonByIdStageIdPersonCdStagePersTypes(int idStage, List cdStagePersTypes);

}
