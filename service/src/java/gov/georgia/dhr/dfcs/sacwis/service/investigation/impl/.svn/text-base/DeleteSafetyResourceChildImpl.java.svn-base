package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;

import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

import gov.georgia.dhr.dfcs.sacwis.service.investigation.DeleteSafetyResourceChild;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceChildDeleteSI;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.SafetyResourceChildDAO;

/**
 *This class implements the deleteSafetyResourceChild service to delete records
 *from the SAFETY_RESOURCE_CHILD table
 *
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 06/17/08  PCOOGAN           Creation per Safety Resource enhancement MR-008.
 * 06/24/2009 bgehlot          STGAP0014329: MR-20 changes
 * </pre>
 */


public class DeleteSafetyResourceChildImpl extends BaseServiceImpl implements DeleteSafetyResourceChild {

  private SafetyResourceChildDAO safetyResourceChildDAO = null;

  public void setSafetyResourceChildDAO(SafetyResourceChildDAO safetyResourceChildDAO) {
    this.safetyResourceChildDAO = safetyResourceChildDAO;
  }
  
  /*Implements delete method defined in interface file */
  
  public void deleteSafetyResourceChild(SafetyResourceChildDeleteSI safetyResourceChildDeleteSI)
          throws ServiceException {

    int ulIdSrChild = safetyResourceChildDeleteSI.getUlIdSrChild();
    
    //STGAP00014329: Delete the todo
    safetyResourceChildDAO.deleteSafetyResourceChildTodo(safetyResourceChildDeleteSI.getUlIdEvent());
    safetyResourceChildDAO.deleteSafetyResourceChild(ulIdSrChild);
    
   }

}  