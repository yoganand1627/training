package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES06SO;

public interface SaveAreaServed {
  /**
   * If the row passed is a region wide row, there are three cases.  The first case is for DELETE.  In these cases, the
   * DAM CRES36D is called in order to delete all the necessary population and service rows for the region wide service.
   * The second case is for UPDATE.  Again, CRES36D is called in order to update all of the service rows for the region.
   * The populations are left alone in this case.  The third case is for ADD. CRES36D is called in order to add the
   * Region wide row. If this is successful, the database is searched in order to find populations that are attached to
   * any county rows that may have previously existed within the region.  If the populations exist, they are deleted
   * with CRES34D. Then, any county rows within the region for the particular service that previously existed are
   * deletedusing CRES35D. Now, the county rows for the region selected can be added without any duplication occuring.
   * These county rows are added with a show row of no so that they will not be displayed in the list box on a
   * retrieval. If the row passed is a county row, a statewide intake row, a state office row, or state != TX, their
   * populations are deleted with CRES34D (for the  delete case) and then the necessary row is added, updated, or
   * deleted.
   *
   * @param cres06si
   * @return A populated {@link CRES06SO} object.
   */
  CRES06SO saveAreaServed(CRES06SI cres06si);
}
