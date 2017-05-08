package gov.georgia.dhr.dfcs.sacwis.core.constants;

import org.grnds.facility.config.GrndsConfiguration;

/**
 * This class serves as the central location to store any architecture-wide constants
 *
 * @author Randy O'Neil, October 23, 2001
 * <pre>
 * Change History:
 * Date           User                Description
 * ----------     ---------------     ------------------------------------------------------
 * 06/22/2011     hjbaptiste          Added N/A and X
 * </pre>
 */
@SuppressWarnings({"AccessOfSystemProperties"})
public abstract class ArchitectureConstants {
  // static contants
  public static final String FILE_SEPARATOR = System.getProperty("file.separator");
  public static final String LINE_BREAK = System.getProperty("line.separator");

  public static final String TRUE = "true";
  public static final String FALSE = "false";

  public static final String YES = "Yes";
  public static final String NO = "No";
  public static final String NA = "N/A";

  public static final String Y = "Y";
  public static final String N = "N";
  public static final String U = "U";
  // Use in the case of N/A
  public static final String X = "X";

  public static final String ERROR_BRANCH_NAME = "error";
  // SMS#97845 MR-074-2 AFCARS: used for generic simple help text window
  public static final String SIMPLE_HELP_TEXT_WIN_NAME = "HELP_TEXT_WIN_NAME";
  public static final String SIMPLE_HELP_TEXT_DISPLAY = "HELP_TEXT_DISPLAY";

  // SMS #116335: ECEM 5.0 Service codes cannot access to the UserProfile.java due to the file location,
  // so use ArchitectureConstants instead 
  public static final int MAX_NUM_ATTRIBUTES = 200;
  
  // Needed for INTAKE:
  public static final String DISPLAY_INCOMING_PERSON_DETAIL = "displayIncomingPersonDetail";

  public static final String SUBMODULE_NAV_AWAY_CHECK_ATTR_NAME = "subNavAwayCk";

  public static final String CONVERSATION = "grnds_conversation";
  public static final String COMMAND = "grnds_command";
  public static final String CHARACTER_ENCODING = "windows-1252";
  public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"" + CHARACTER_ENCODING + "\"?>\n";

  public static final String GRNDS_DOMAIN = "sacwis";
  
  public static final boolean BROWNOUT_MODE =
    Boolean.valueOf(GrndsConfiguration.getInstance().getProperty(GRNDS_DOMAIN,
                                                                 "brownOutMode"));  
  
}

