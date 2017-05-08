package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveNewUnitToBecomeItsOwnParentUnit;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveInitialUnitBeforeBecomingOwnParentSI;

public class SaveNewUnitToBecomeItsOwnParentUnitImpl extends BaseServiceImpl implements
                                                                            SaveNewUnitToBecomeItsOwnParentUnit {
  
  private UnitDAO unitDAO;

  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }


  public int saveInitialUnitBeforeBecomingOwnParent(SaveInitialUnitBeforeBecomingOwnParentSI saveInitialUnitBeforeBecomingOwnParentSI) {
    Unit newParentUnit = new Unit();
    
    newParentUnit.setCdCounty(saveInitialUnitBeforeBecomingOwnParentSI.getCdParentUnitCounty());
    newParentUnit.setCdUnitRegion(saveInitialUnitBeforeBecomingOwnParentSI.getCdParentUnitRegion());
    newParentUnit.setNbrUnit(saveInitialUnitBeforeBecomingOwnParentSI.getNbrParentUnit());
    newParentUnit.setCdUnitProgram(saveInitialUnitBeforeBecomingOwnParentSI.getCdUnitProgram());
    
    unitDAO.saveUnit(newParentUnit);
    int idNewParentUnit = newParentUnit.getIdUnit();
    
    return idNewParentUnit;
  }

}
