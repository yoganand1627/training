/**
 * Created on Jul 6, 2006 at 9:54:08 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.constants;

import java.util.HashSet;
import java.util.Set;

public class PageModeConstants {
  /** Equivalent to the CAPS macro WINDOW_MODE_NEW */
  public static final String NEW = "1";
  /** Equivalent to the CAPS macro WINDOW_MODE_NEW_USING */
  public static final String NEW_USING = "2";
  /** Equivalent to the CAPS macro WINDOW_MODE_INQUIRE */
  public static final String INQUIRE = "3";
  /** Equivalent to the CAPS macro WINDOW_MODE_MODIFY */
  public static final String MODIFY = "4";
  /** Equivalent to the CAPS macro CAPS_WIN_MODE_APPRV */
  public static final String APPROVE = "A";
  // Aliases -- deprecated, but used to provide backwards compatibility with architecture
  public static final String VIEW = INQUIRE;
  public static final String EDIT = MODIFY;
  public static final String CREATE = NEW;

  /*
  public static final String DATA      = "5";
  public static final String NO_DATA   = "6";
  public static final String CANCEL    = "7";

  public static final String ASSIGN      = "Z";
  public static final String NEW_APPRV   = "X";
  public static final String NEXT_APPRV  = "Y";
  public static final String APRVR_ADD   = "$";
  public static final String APRVR_FAIL  = "@";
  */

  /** page modes required for the Intake */
  public static class Intake {
    public static final String NEW_USING_APS = "S";
    public static final String NEW_USING_CAR = "R";
    public static final String NEW_USING_CWA = "C";
    public static final String NEW_USING_OPEN = "O";
    public static final String NEW_USING_INTAKE = "G";
  }

  /** page modes required for the PersonDetail */
  public static class PersonDetail {
    public static final String WINDOW_MODE_MNTN_PERSON = "M";
    public static final String WINDOW_MODE_PERSON = "P";
    public static final String WINDOW_MODE_RELATE = "L";
  }

  /** page modes required for the PersonList */
  public static class PersonList {
    public static final String SELECT = "S";
    public static final String CLLTRL_ONLY = "C";
    public static final String PRINC_ONLY = "P";
    public static final String ALLEG_PERP_ONLY = "Z";
  }

  public static Set<String> VALID_PAGE_MODES = new HashSet<String>() {
    {
      add(PageModeConstants.NEW);
      add(PageModeConstants.NEW_USING);
      add(PageModeConstants.INQUIRE);
      add(PageModeConstants.MODIFY);
      add(PageModeConstants.APPROVE);
      add(PageModeConstants.Intake.NEW_USING_INTAKE);
      add(PageModeConstants.Intake.NEW_USING_APS);
      add(PageModeConstants.Intake.NEW_USING_CAR);
      add(PageModeConstants.Intake.NEW_USING_CWA);
      add(PageModeConstants.Intake.NEW_USING_OPEN);
      add(PageModeConstants.PersonDetail.WINDOW_MODE_RELATE);
      add(PageModeConstants.PersonDetail.WINDOW_MODE_MNTN_PERSON);
      add(PageModeConstants.PersonDetail.WINDOW_MODE_PERSON);
      add(PageModeConstants.PersonList.ALLEG_PERP_ONLY);
      add(PageModeConstants.PersonList.CLLTRL_ONLY);
      add(PageModeConstants.PersonList.PRINC_ONLY);
      add(PageModeConstants.PersonList.SELECT);
    }
  };
}
