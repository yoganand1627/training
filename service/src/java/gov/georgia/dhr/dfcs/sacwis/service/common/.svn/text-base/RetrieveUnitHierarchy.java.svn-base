package gov.georgia.dhr.dfcs.sacwis.service.common;

import gov.georgia.dhr.dfcs.sacwis.structs.input.UnitHierarchyRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UnitHierarchyRetrieveSO;

public interface RetrieveUnitHierarchy {
  /**
   * This service retrieves a hierarchical structure of existing units.  The units returned
   * are based on the type of ID populated in the input object as follows:
   * (1) when ID type = UnitHierarchyRetrieveSI.UNIT_APPROVER_ID, Set returned = all units the person is Unit Approver for
   * (2) when ID type = UnitHierarchyRetrieveSI.UNIT_ID, Set returned = only the unit represented by the id given
   * 
   * Each unit in the Set returned contains hierarchical references to other units traversing down the unit
   * hierarchy (all children of the unit, each containing references to their children, and so on) and up
   * the unit hierarchy (the parent of the unit, which references its own parent, and so on).  A null value
   * for either a child unit or parent unit represents the bottom and top of the hierarchy, respectively.
   * A null parent means the unit is its own parent.
   * 
   * NOTE: When traversing the hierarchy returned, values will only be given using each unit in the Set of units
   * as a relative starting point for its hierarchy.  Traversal is unilateral in each direction.  For instance,
   * this will not work:
   * - unit.getChild.getChild.getParent
   * - unit.getParent.getChild
   * 
   * But this will:
   * - unit.getChild.getChild.getChild... until null found in child Set
   * - unit.getParent.getParent.getParent... until null
   * 
   * @param si
   * @return
   */
  UnitHierarchyRetrieveSO retrieveUnitHierarchy(UnitHierarchyRetrieveSI si);
}
