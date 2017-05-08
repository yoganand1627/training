package gov.georgia.dhr.dfcs.sacwis.structs.input;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UnitHierarchyRetrieveSI implements Serializable {
  public static final int UNIT_APPROVER_ID = 1;
  public static final int UNIT_ID = 2;
  
  private int idType;
  private int id;
  
  public UnitHierarchyRetrieveSI(int idType, int id) {
    this.idType = filterIdType(idType);
    this.id = id;
  }
  
  public int getId() {
    return id;
  }
  public int getIdType() {
    return idType;
  }
  
  private int filterIdType(int idType) {
    switch(idType) {
    case UNIT_ID:
    case UNIT_APPROVER_ID:
      return idType;
    default:
      return UNIT_APPROVER_ID;
    }
  }
}
