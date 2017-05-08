package gov.georgia.dhr.dfcs.sacwis.service.common.impl;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.service.common.CheckIfUserWasEverAssigned;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

import java.math.BigDecimal;
import java.util.List;
/**
 * This Service is used to see if the user was ever assigned to a given case also checks to see if they are in the unit Hierarchy. 
 * 
 * <pre>
 *  Change History:
 *  Date        User      Description
 *  ----------  --------  --------------------------------------------------
 *  06/01/09    Cwells    initial Creation 
 * </pre>
 */
public class CheckIfUserWasEverAssignedImpl extends BaseServiceImpl implements CheckIfUserWasEverAssigned{

  private StagePersonLinkDAO stagePersonLinkDAO = null;
  private UnitEmpLinkDAO unitEmpLinkDAO = null;
  private UnitDAO unitDAO = null;
  
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
   this.stagePersonLinkDAO = stagePersonLinkDAO;
 }
  
  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO){
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }
  
  public void setUnitDAO(UnitDAO unitDAO){
    this.unitDAO = unitDAO;
  }
  
  
  
  public boolean determineIfUserWasEverAssigned(int idCase, int idStage, int idPerson){
    boolean userAssigned = false;
   BigDecimal count = stagePersonLinkDAO.countStageAssignedHistory(idPerson, idCase, idStage);
   int timesAssigned = count.intValue();
   // if the user was ever assigned to the stage then just return true 
    if(timesAssigned > 0){
      userAssigned = true;
    }
        // STGAP00013826 Also checking to see if the logged in user is in the unit hierarchy. CaseUtility hasStageAccess does something 
       //  similar but only checks for PR or SE and Not HP(historical case worker).
        List<Integer> unitHierarchy = unitDAO.findSuperiorUnitByIdStageAndIdPerson(idStage, idPerson);
         if(!unitHierarchy.isEmpty() && unitHierarchy != null && unitHierarchy.size() != 0){
           userAssigned = true;
         }
    
    return userAssigned;
  }
  
}
