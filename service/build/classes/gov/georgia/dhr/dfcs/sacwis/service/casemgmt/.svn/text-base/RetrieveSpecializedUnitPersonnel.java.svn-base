package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecializedUnitPersonalBean;

import java.util.List;

public interface RetrieveSpecializedUnitPersonnel {
  
  static final boolean REGIONAL = true; // used as default coverage for retrieval
  static final boolean STATE_WIDE = false;
  static final boolean COUNTY = false;
  /**
   * 
   * @param idStage
   * @param securityAttribute
   * @param specialization
   * @param isRAC: 'true' indicates the role is for one person (this comes from when this services was first designed, to 
   * distinguish between RAC, regional role - one for each region, and SAU - all that are state adoption unit personnel)
   * @return: empty list if not found; only one when found and isRAC; one or more (more likely more) when found and if !isRAC
   */
  public List<Integer> retrieveSpecializedUnitPersonnel(SpecializedUnitPersonalBean spUnitPsnlBean);
  public boolean hasRightByIdPerson(int idPerson, String securityAttribute);
}
