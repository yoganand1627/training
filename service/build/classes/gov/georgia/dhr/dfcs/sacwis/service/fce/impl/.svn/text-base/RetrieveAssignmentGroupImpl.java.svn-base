package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.service.fce.RetrieveAssignmentGroup;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup_ARRAY;

public class RetrieveAssignmentGroupImpl extends BaseServiceImpl implements RetrieveAssignmentGroup {
  
  private StageDAO stageDAO = null;
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  @SuppressWarnings( { "unchecked" })
  public AssignmentGroup_ARRAY retrieveAssignmentGroup(int idStage){
    AssignmentGroup_ARRAY assignmentGroupArray = new AssignmentGroup_ARRAY();
    List<Map> stageInfo = stageDAO.findStageByIdStageAndOrderByCdStagePersRole(idStage);
    if (stageInfo == null || stageInfo.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    for (Iterator<Map> it = stageInfo.iterator(); it.hasNext();) {
      Map stageMap = it.next();
      AssignmentGroup assignmentGroup = new AssignmentGroup();
      assignmentGroup.setSzNmStage((String) stageMap.get("nmStage"));
      assignmentGroup.setSzNmPersonFull((String) stageMap.get("nmPersonFull"));
      assignmentGroup.setSzCdStagePersRole((String) stageMap.get("cdStagePersRole"));
      assignmentGroup.setUlIdStage((Integer) stageMap.get("idStage") != null ? (Integer) stageMap.get("idStage") : 0);
      assignmentGroup.setUlIdPerson((Integer) stageMap.get("idPerson") != null ?
                                    (Integer) stageMap.get("idPerson") : 0);
      assignmentGroup.setUlIdStagePerson((Integer) stageMap.get("idStagePersonLink") != null ?
                                         (Integer) stageMap.get("idStagePersonLink") : 0);
      assignmentGroup.setUlIdCase((Integer) stageMap.get("idCase") != null ? (Integer) stageMap.get("idCase") : 0);
      assignmentGroup.setSzCdStage((String) stageMap.get("cdStage"));
      assignmentGroup.setSzCdStageProgram((String) stageMap.get("cdStageProgram"));
      assignmentGroup.setSzCdStageType((String) stageMap.get("cdStageType"));
      assignmentGroup.setSzCdStageCnty((String) stageMap.get("cdStageCnty"));
      assignmentGroup.setTsLastUpdate(((Date) stageMap.get("dtLastUpdate")));
      assignmentGroupArray.addAssignmentGroup(assignmentGroup);
    }
    return assignmentGroupArray;
  }
}
