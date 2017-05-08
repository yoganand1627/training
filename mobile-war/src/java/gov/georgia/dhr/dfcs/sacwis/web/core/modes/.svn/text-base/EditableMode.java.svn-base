package gov.georgia.dhr.dfcs.sacwis.web.core.modes;

// -- civ classes --

import java.io.Serializable;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;

// -- copyright --

/**
 * The <code>EditableMode</code> class provides definitions governing the display of custom JSP tags within a page.  An
 * <code>EditableMode</code> is assigned to the editableMode attribute of custom JSP tag.
 * <p/>
 * Specifically, the <code>EditableMode</code> may be used to override how tags encapsulated within <code>FormTag</code>
 * are displayed.  For a given tag, the <code>editableMode</code> attribute supersedes the definition given by the
 * <code>FormTag</code>'s <code>pageMode</code> attribute.
 *
 * @author Pablo Mitchell, 24 April 2002
 */
public abstract class EditableMode implements Serializable {
  /**
   * The isCompatibleWith method determines whether the current <code>EditableMode</code> is compatible with the parent
   * form's <code>PageMode</code>.
   *
   * @param pageMode the parent form's page mode
   * @param editMode the sum of the editable modes of this widget
   * @return boolean
   */
  public static boolean isCompatibleWith(String pageMode, int editMode) {
    int pageModeInt = EditableMode.getPageModeAsInt(pageMode);
    int compatibility = (pageModeInt & editMode);
    boolean compatible = (compatibility != 0);
    return compatible;
  }

  public static int getPageModeAsInt(String pageMode) {

    int pageModeInt = 0;
    if (pageMode.equals(PageModeConstants.NEW)) {
      pageModeInt = EditableMode.NEW;
    } else if (pageMode.equals(PageModeConstants.NEW_USING)) {
      pageModeInt = EditableMode.NEW_USING;
    } else if (pageMode.equals(PageModeConstants.INQUIRE)) {
      pageModeInt = EditableMode.INQUIRE;
    } else if (pageMode.equals(PageModeConstants.MODIFY)) {
      pageModeInt = EditableMode.MODIFY;
    } else if (pageMode.equals(PageModeConstants.APPROVE)) {
      pageModeInt = EditableMode.APPROVE;
    } else {
      pageModeInt = EditableMode.NONE;
    }
    return pageModeInt;
  }

  // -- static constants --
  private static final String TRACE_TAG = "EditableMode";

  public static final int NONE = 0x0000;

  public static final int NEW = 0x0001;
  public static final int NEW_USING = 0x0002;
  public static final int INQUIRE = 0x0004;
  public static final int MODIFY = 0x0008;
  public static final int APPROVE = 0x0010;
  /*
  public static final int NO_DATA   = 0x0020;
  public static final int CANCEL    = 0x0040;

  public static final int ASSIGN      = 0x0080;
  public static final int NEW_APPRV   = 0x0100;
  public static final int NEXT_APPRV  = 0x0200;
  public static final int APRVR_ADD   = 0x0400;
  public static final int APRVR_FAIL  = 0x0800;
  */

  public static final int ALL = 0xFFFF;

  public static final int DEFAULT =
          EditableMode.NEW + EditableMode.NEW_USING +
          EditableMode.MODIFY + EditableMode.APPROVE;

  //ALIASES -- this is for backward compatibility with C-IV
  public static final int VIEW = EditableMode.INQUIRE;
  public static final int CREATE = EditableMode.NEW;
  public static final int EDIT = EditableMode.MODIFY;
  public static final int CREATE_AND_EDIT = EditableMode.DEFAULT;
}

