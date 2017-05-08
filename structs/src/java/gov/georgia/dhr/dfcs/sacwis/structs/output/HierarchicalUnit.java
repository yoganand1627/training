package gov.georgia.dhr.dfcs.sacwis.structs.output;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

@SuppressWarnings("serial")
public class HierarchicalUnit implements Comparable, Serializable {
  private HierarchicalUnit parentUnit;
  private Set<HierarchicalUnit> childUnits;
  private int idUnit;
  private String nbrUnit;
  private String cdUnitRegion;
  private String cdUnitProgram;
  private int idUnitApprover;
  private String cdUnitSpecialization;
  private String cdCounty;
  
  //-- constructor
  public HierarchicalUnit(int idUnit) {
    this.idUnit = idUnit;
    this.childUnits = new TreeSet<HierarchicalUnit>();
  }
  
  //-- hierarchical units
  public HierarchicalUnit getParentUnit() {
    return parentUnit;
  }
  public void setParentUnit(HierarchicalUnit parentUnit) {
    this.parentUnit = parentUnit;
  }
  public Set<HierarchicalUnit> getChildUnits() {
    return childUnits;
  }
  public boolean addChildUnit(HierarchicalUnit childUnit) {
    return childUnits.add(childUnit);
  }

  //-- getters and setters
  public String getCdCounty() {
    return cdCounty;
  }
  public void setCdCounty(String cdCounty) {
    this.cdCounty = cdCounty;
  }
  public String getCdUnitProgram() {
    return cdUnitProgram;
  }
  public void setCdUnitProgram(String cdUnitProgram) {
    this.cdUnitProgram = cdUnitProgram;
  }
  public String getCdUnitRegion() {
    return cdUnitRegion;
  }
  public void setCdUnitRegion(String cdUnitRegion) {
    this.cdUnitRegion = cdUnitRegion;
  }
  public String getCdUnitSpecialization() {
    return cdUnitSpecialization;
  }
  public void setCdUnitSpecialization(String cdUnitSpecialization) {
    this.cdUnitSpecialization = cdUnitSpecialization;
  }
  public int getIdUnit() {
    return idUnit;
  }
  public int getIdUnitApprover() {
    return idUnitApprover;
  }
  public void setIdUnitApprover(int idUnitApprover) {
    this.idUnitApprover = idUnitApprover;
  }
  public String getNbrUnit() {
    return nbrUnit;
  }
  public void setNbrUnit(String nbrUnit) {
    this.nbrUnit = nbrUnit;
  }
  
  //-- contractual methods
  public int compareTo(Object o) {
    if(o instanceof HierarchicalUnit) {
      HierarchicalUnit other = (HierarchicalUnit) o;
      return Integer.valueOf(this.idUnit).compareTo(other.idUnit);
    }
    return 0;
  }
  
  //-- overrides
  @Override
  public boolean equals(Object obj) {
    if(obj instanceof HierarchicalUnit) {
      HierarchicalUnit other = (HierarchicalUnit) obj;
      return this.idUnit == other.idUnit;
    }
    return false;
  }
  
  @Override
  public int hashCode() {
    return this.idUnit;
  }
}
