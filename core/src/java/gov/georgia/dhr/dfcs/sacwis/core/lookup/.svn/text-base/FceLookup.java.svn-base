/**
 * Created on Jul 6, 2006 at 10:23:27 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.lookup;

import java.io.Serializable;

public class FceLookup {
  //private static final String TRACE_TAG = "FceLookup";
  private static FceLookupArrays fceLookupArrays = null;
  public static final int MAX_PARENTS = 2;
  public static final int MAX_NBR_CERTIFIED = 99;

  protected static void setFceLookupArrays(FceLookupArrays fceLookupArrays) {
    FceLookup.fceLookupArrays = fceLookupArrays;
  }

  public static double getFceAfdcIncomeLimit(int nbrParents, int nbrCertifiedGroup) {
    //Kathy Campbell said sometimes they don't know how many/who are the parents
    if (nbrParents > 2) {
      nbrParents = 2;
    }

    if (nbrCertifiedGroup > MAX_NBR_CERTIFIED) {
      nbrCertifiedGroup = MAX_NBR_CERTIFIED;
    }

    return fceLookupArrays.fceAfdcIncomeLimitArray[nbrParents][nbrCertifiedGroup];
  }

  public static double getFceStepparentAllowance(int nbrNotCertifiedGroup) {
    if (nbrNotCertifiedGroup == 0) {
      return 0;
    }

    if (nbrNotCertifiedGroup > MAX_NBR_CERTIFIED) {
      nbrNotCertifiedGroup = MAX_NBR_CERTIFIED;
    }

    return fceLookupArrays.fceStepparentAllowanceArray[nbrNotCertifiedGroup];
  }

  public static double getFcePweUnderemployed(int nbrCertifiedGroup) {
    if (nbrCertifiedGroup > MAX_NBR_CERTIFIED) {
      nbrCertifiedGroup = MAX_NBR_CERTIFIED;
    }
    return fceLookupArrays.fcePweUnderemployedArray[nbrCertifiedGroup];
  }

  protected static class FceLookupArrays implements Serializable {
    // first index is nbrParents
    // second index is nbrCertifiedGroup
    private double[][] fceAfdcIncomeLimitArray = null;

    // index is number NOT in the certified group
    private double[] fceStepparentAllowanceArray = null;

    // index is nbrCertifiedGroup
    private double[] fcePweUnderemployedArray;

    public FceLookupArrays(double[][] fceAfdcIncomeLimitArray, double[] fceStepparentAllowanceArray,
                           double[] fcePweUnderemployedArray) {
      this.fceAfdcIncomeLimitArray = fceAfdcIncomeLimitArray;
      this.fceStepparentAllowanceArray = fceStepparentAllowanceArray;
      this.fcePweUnderemployedArray = fcePweUnderemployedArray;
    }
  }
}
