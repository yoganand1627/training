package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.CsSummaryCompLookup;

import java.util.List;

/**
 * <pre>
 * Change History:
 * Date        User                     Description
 * --------    ----------------         ----------------------------------------------
 * 03/02/2010  hjbaptiste            Initial creation
 * 
 * </pre>
 *
 * @author Herve Jean-Baptiste, March 02, 2010
 */
public interface CsSummaryCompLookupDAO {
  /**
   * Retrieves the CsSummaryCompLookup base on the passed in indFather, indMother and indCaretaker
   * 
   * @param indFather
   * @param indMother
   * @param indCaretaker
   * @return {@link CsSummaryCompLookup}
   */
  CsSummaryCompLookup findCsSummaryCompLookupByMotherFatherCaretaker(String indFather, String indMother, String indCaretaker);
}
