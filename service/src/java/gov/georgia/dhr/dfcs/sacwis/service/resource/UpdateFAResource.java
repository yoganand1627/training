package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD01UO;

public interface UpdateFAResource {
  //Foster Home Categories
  static final String FA_CATG_ADOPT = CodesTables.CFACATEG_A;
  static final String FA_CATG_REL_ADOPT = CodesTables.CFACATEG_D;
  static final String FA_CATG_FOST_ADOPT_LEG_RISK = CodesTables.CFACATEG_L;
  static final String FA_CATG_FOST = CodesTables.CFACATEG_F;
  static final String FA_CATG_REL_FOST = CodesTables.CFACATEG_O;
  static final String FA_CATG_ICPC = CodesTables.CFACATEG_I;
  
  //foster/adoption service code type/category
  static final String CD_FOSTER_SERVICES = CodesTables.CFOSSVCD;
  static final String CD_ADOPT_SERVICES = CodesTables.CADOSVCD;
  
  
  /**
   * Description:   This common fuction will be used to maintain the Resource Service and Resource Characteristics
   * Tables for Foster Adoptive Homes.  It can be called by the F/A Demographics Save Service as well as the F/A Licence
   * Save Service. Note that in order for this fuction to execuate properly, it must be called AFTER all updates to the
   * caps_resource table have been made.
   * <p/>
   * The four change indicator flags should be set to TRUE or FALSE.  If Characteristics have been added or deleted on
   * the interest window, all characteristics which are checked should be passed along with the DtAdded.  If
   * characteristics were neither checked nor unchecked, nothing should be passed in this group. The four approved ages
   * should always be passed.
   * <p/>
   * If only ages have changed, the function will update the Resource Characteristcs table with the new approved ages.
   * <p/>
   * If the address for a resource has changed, the function will update the Resource Service table with the new
   * county/region/state.
   * <p/>
   * If F/A Home Types have been added or deleted or if the Category of the Home has changed, the following Resource
   * Service Processing will be performed: <ul> <li>Determine what resource services currently exist</li> <li>Determine
   * what resource services need to exist</li> <li>Set a flag if the two differ (bServiceChangeRequired)</li> </ul> If a
   * service change is required or if characteristics where added/deleted: <ul> <li>All characteristics rows are
   * deleted.</li> </ul> If a service change is required: <ul> <li>Resource Service rows are added/deleted as
   * necessary</li> <li>The contract tables are added/maintained as necessary<br/> (**note:  logic to add/maintain the
   * contract tables is a SIR and is not yet included**)</li> </ul> If characteristics have been added or deleted or if
   * Resource Service changes were made: <ul> <li>Characteristics for each resource service are re-built</li> </ul>
   *
   * @param input
   * @return CFAD01UO
   */
  CFAD01UO updateFAResource(CFAD01UI input);
}
