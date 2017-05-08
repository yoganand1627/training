package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.structs.output.AssignmentGroup_ARRAY;

public interface RetrieveAssignmentGroup {
  
  /**
   * Retrieves columns idStage, cdStage, cdStageProgram, cdStageType, cdStageCnty, nmStage and idCase from Stage table;
   * nmPersonFull from Person table;idPerson, cdStagePersRole, idStagePersonLink and dtLastUpdate from StagePersonLink
   * table;nmCase from CapsCase table for the given idStage and ORDER the results BY cdStagePersRole(from
   * StagePersonLink table)
   * 
   * @param idStage
   * @return AssignmentGroup_ARRAY.
   */ 
  public AssignmentGroup_ARRAY retrieveAssignmentGroup(int idStage);

}
