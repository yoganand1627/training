package gov.georgia.dhr.dfcs.sacwis.service.reports;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC19SO;

public interface DeleteReportList {
  /**
   * This service will delete the specified report from the Report List table.
   *
   * @param carc19si {@link CARC19SI}
   * @return {@link CARC19SO} object
   */
  public CARC19SO deleteReportList(CARC19SI carc19si);
}
