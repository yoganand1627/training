package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.service.common.RetrieveUnitHierarchy;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UnitHierarchyRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.HierarchicalUnit;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UnitHierarchyRetrieveSO;

import java.util.List;

public class RetrieveUnitHierarchyImpl extends BaseServiceImpl implements RetrieveUnitHierarchy {
  
  private UnitDAO unitDAO;
  private UnitEmpLinkDAO unitEmpLinkDAO;

  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }
  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public UnitHierarchyRetrieveSO retrieveUnitHierarchy(UnitHierarchyRetrieveSI si) {
    UnitHierarchyRetrieveSO so = new UnitHierarchyRetrieveSO();
    int idUnitApprover = 0;
    int idUnit = 0;
    
    switch(si.getIdType()) {
    case UnitHierarchyRetrieveSI.UNIT_APPROVER_ID:
      idUnitApprover = si.getId();
      break;
    case UnitHierarchyRetrieveSI.UNIT_ID:
      idUnit = si.getId();
      break;
    }
    
    //-- either this block
    if(idUnitApprover > 0) {
      List<Unit> supervisedUnits = unitEmpLinkDAO.findUnitsByIdSupervisor(idUnitApprover);
      if(supervisedUnits != null && !supervisedUnits.isEmpty()) {
        for(Unit baseUnit : supervisedUnits) {
          HierarchicalUnit hUnit = createHierarchicalUnit(baseUnit);
          Unit parent = baseUnit.getUnit();
          addParent(parent, hUnit);
          so.addUnit(hUnit);
        }
      }
    }
    
    //-- or this block will run
    if(idUnit > 0) {
      Unit unit = unitDAO.findUnitByIdUnit(idUnit);
      if(unit != null) {
        HierarchicalUnit hUnit = createHierarchicalUnit(unit);
        addParent(unit.getUnit(), hUnit);
        so.addUnit(hUnit);
      }
    }
    
    return so;
  }
  
  //-- recursively adds children
  private HierarchicalUnit createHierarchicalUnit(Unit unit) {
    int idUnit = unit.getIdUnit();
    HierarchicalUnit hUnit = createBasicUnit(unit);
    
    //-- get child units
    List<Unit> childUnits = unitDAO.findChildUnitsByIdUnitParent(idUnit);
    if(childUnits != null && !childUnits.isEmpty()) {
      for(Unit childUnit : childUnits) {
        if(idUnit != childUnit.getIdUnit()) {
          hUnit.addChildUnit(createHierarchicalUnit(childUnit));
        }
      }
    }
    
    return hUnit;
  }
  
  private HierarchicalUnit createBasicUnit(Unit unit) {
    int idUnit = unit.getIdUnit();
    HierarchicalUnit hUnit = new HierarchicalUnit(idUnit);
    
    //-- non-null values
    hUnit.setNbrUnit(unit.getNbrUnit());
    hUnit.setCdUnitRegion(unit.getCdUnitRegion());
    hUnit.setCdUnitProgram(unit.getCdUnitProgram());
    
    //-- nullable values
    Person unitApprover = unit.getPerson();
    if(unitApprover != null) {
      hUnit.setIdUnitApprover(unitApprover.getIdPerson());
    }
    hUnit.setCdUnitSpecialization(unit.getCdUnitSpecialization());
    hUnit.setCdCounty(unit.getCdCounty());
    
    return hUnit;
  }
  
  //-- recursively adds parents
  private void addParent(Unit parent, HierarchicalUnit hUnit) {
    if(parent != null && parent.getIdUnit() != hUnit.getIdUnit()) {
      HierarchicalUnit pUnit = createBasicUnit(parent);
      addParent(parent.getUnit(), pUnit);
      hUnit.setParentUnit(pUnit);
    }
  }

}
