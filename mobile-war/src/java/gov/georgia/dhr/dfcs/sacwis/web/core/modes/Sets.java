package gov.georgia.dhr.dfcs.sacwis.web.core.modes;

import javax.servlet.http.HttpServletRequest;

import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;

/**
 * This class is designed to be a general helper for enabling and disabling widgets on a page beyond that ability
 * provided by EditableMode and PageMode. The primary use of this field will be to provide specific modes (here called
 * Sets, so as not to be confused with PageMode and EditableMode) in which different fields are enabled and disabled,
 *
 * @author Dann Webster
 * @version 1.0
 */
public abstract class Sets {
  public static final int NONE = 0x00000;

  public static final int A = 0x00001;
  public static final int B = 0x00002;
  public static final int C = 0x00004;
  public static final int D = 0x00008;
  public static final int E = 0x00010;
  public static final int F = 0x00020;
  public static final int G = 0x00040;
  public static final int H = 0x00080;
  public static final int I = 0x00100;
  public static final int J = 0x00200;
  public static final int K = 0x00400;
  public static final int L = 0x00800;
  public static final int M = 0x01000;
  public static final int N = 0x02000;
  public static final int O = 0x04000;
  public static final int P = 0x08000;

  public static final int ALL = 0xFFFFFF;

  public static final String REQUEST_NAME = "DISABLER_REQUEST_NAME";

  public static String isInSetStr(int sets, HttpServletRequest request) {
    boolean inSet = isInSet(sets, request);
    return "" + inSet;
  }

  public static String isNotInSetStr(int sets, HttpServletRequest request) {
    boolean notInSet = !isInSet(sets, request);
    return "" + notInSet;
  }

  public static boolean isInSet(int sets, HttpServletRequest request) {
    int pageSet = getPageSetInt(request);
    int disableInt = (sets & pageSet);
    boolean inSet = (disableInt != 0);
    return inSet;
  }

  public static void setPageSet(int pageSet, HttpServletRequest request) {
    BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(
            BaseSessionStateManager.STATE_MANAGER_KEY);
    state.setAttribute(REQUEST_NAME, "" + pageSet, request);
  }

  protected static int getPageSetInt(HttpServletRequest request) {
    BaseSessionStateManager state = (BaseSessionStateManager) request.getAttribute(
            BaseSessionStateManager.STATE_MANAGER_KEY);
    int pageSet = 0;
    try {
      pageSet = Integer.parseInt(
              (String) state.getAttribute(REQUEST_NAME, request));
    }
    catch (Exception e) {
      pageSet = 0;
    }
    return pageSet;
  }

  public static String getPageSet(HttpServletRequest request) {
    int pageSetInt = getPageSetInt(request);
    switch (pageSetInt) {
      case NONE:
        return "NONE";
      case A:
        return "A";
      case B:
        return "B";
      case C:
        return "C";
      case D:
        return "D";
      case E:
        return "E";
      case F:
        return "F";
      case G:
        return "G";
      case H:
        return "H";
      case I:
        return "I";
      case J:
        return "J";
      case K:
        return "K";
      case L:
        return "L";
      case M:
        return "M";
      case N:
        return "N";
      case O:
        return "O";
      case P:
        return "P";
      case ALL:
        return "ALL";
      default:
        return "OTHER";
    }
  }

}