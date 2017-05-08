package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC32SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC32SO;

public interface SaveCriminalHistory {

  /**
   * SaveCriminalHistory updates rows in the Criminal History Table (no Add or Delete) for a given IdCrimHist.  It also
   * deletes rows from Crim Hist Narr Table for a given IdCrimHist Note: Although this service is set up to
   * Add/Update/Delete to the Criminal History Table, the Criminal History page only updates this table, never adding or
   * deleting rows (only the Function Code = UPDATE is passed by the window).
   *
   * @param ccfc32si
   * @return {@link CCFC32SO}
   */
  public CCFC32SO saveCriminalHistory(CCFC32SI ccfc32si);
}
