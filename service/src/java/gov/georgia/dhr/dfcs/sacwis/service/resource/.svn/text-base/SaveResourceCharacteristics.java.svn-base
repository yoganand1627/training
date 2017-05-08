package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES08SO;

public interface SaveResourceCharacteristics {

  /**
   * This is an AUD service for a region wide service row that modifies rows on the resource chrctr table.  First the
   * characteristics data is AUDed to the passed row.  If the row is not for a region wide service, the service returns.
   * If the row is for a region wide service the more processing is necessary.  If the data action is add,
   * ResourceServiceDAO is called in order to return all of the resource service ID's from the resource service table.
   * These ID's represent the ID's for each county within the region.  Now ResourceChrctrDAO is called in order to add
   * characteristics to each of the county rows. This is necessary for search purposes.  If the data action code is
   * Update, ResourceChrctrDAO is called passing the new data and the old characteristics data.  Since it is not
   * possible to have the id resource chrctr for the county rows, all of the old data is used in order to act as the key
   * to the table.  All of the county rows for the region will be updated at the same time. If the data action code is
   * Delete, ResourceChrctrDAO is called passing the old characteristics data as the key similar to the Update case. All
   * of the characteristic rows will be deleted at the same time.
   *
   * @param cres08si
   * @return CRES08SO
   */
  CRES08SO saveResourceCharacteristics(CRES08SI cres08si);
}
