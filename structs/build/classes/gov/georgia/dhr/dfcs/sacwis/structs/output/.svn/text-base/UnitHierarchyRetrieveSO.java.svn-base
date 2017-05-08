package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

@SuppressWarnings("serial")
public class UnitHierarchyRetrieveSO implements Serializable {
  private Set<HierarchicalUnit> units;
  
  public UnitHierarchyRetrieveSO() {
    this.units = new TreeSet<HierarchicalUnit>();
  }

  public Set<HierarchicalUnit> getUnits() {
    return units;
  }
  public boolean addUnit(HierarchicalUnit unit) {
    return units.add(unit);
  }
}
