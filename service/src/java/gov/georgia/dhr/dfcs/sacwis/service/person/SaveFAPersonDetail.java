package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.FAPersonDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FAPersonDetailSaveSO;

public interface SaveFAPersonDetail {
  /**
   * This service retrieves all information for the FA person detail window
   *
   * @param FAPersonDetailRetrieveSI
   * @return A populated {@link FAPersonDetailRetrieveSO} object.
   */
  public FAPersonDetailSaveSO saveFAPersonDetail(FAPersonDetailSaveSI faPersonDetailSaveSI);
}
