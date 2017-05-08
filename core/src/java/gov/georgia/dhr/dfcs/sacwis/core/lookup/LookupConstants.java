/**
 * Created on Apr 10, 2006 at 10:38:12 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.lookup;

import org.grnds.facility.config.GrndsConfiguration;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

public interface LookupConstants {
  public static final int HOUR_OF_DAY =
          Integer.parseInt(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                        "codesTableLookup.hourOfDay"));
  public static final int MINUTE_OF_DAY =
          Integer.parseInt(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                        "codesTableLookup.minuteOfDay"));
}
