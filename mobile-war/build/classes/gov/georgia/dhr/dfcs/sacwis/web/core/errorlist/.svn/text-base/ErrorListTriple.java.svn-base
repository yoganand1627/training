package gov.georgia.dhr.dfcs.sacwis.web.core.errorlist;

import java.io.Serializable;

/**
 * <p>Title: ErrorListTriple</p> <p>Description: Triple object allows grouping of msg#, program code, and stage code to
 * retrieve tab ID from the tripleToTabId Map</p>
 *
 * @author Stephan Brauchli
 * @version 1.0
 */

public class ErrorListTriple implements Serializable {
  public final int msgId;
  public final String prgmCd;
  public final String stgCd;
  private final int hashCode;

  public ErrorListTriple(int msgId, String prgmCd, String stgCd) {
    this.msgId = msgId;
    this.prgmCd = prgmCd;
    this.stgCd = stgCd;

    this.hashCode = msgId
                    + (prgmCd == null ? 0 : prgmCd.hashCode() * 8675309)
                    + (stgCd == null ? 0 : stgCd.hashCode() * 16661);
  }

  public int hashCode() {
    return this.hashCode;
  }

  public boolean equals(Object other) {
    if (other != null && other.getClass() == ErrorListTriple.class) {
      ErrorListTriple otherTriple = (ErrorListTriple) other;
      return ((msgId == otherTriple.msgId) &&
              (prgmCd == null ? otherTriple.prgmCd == null : prgmCd.equals(otherTriple.prgmCd)) &&
              (stgCd == null ? otherTriple.stgCd == null : stgCd.equals(otherTriple.stgCd)));
    } else {
      return false;
    }
  }
}
