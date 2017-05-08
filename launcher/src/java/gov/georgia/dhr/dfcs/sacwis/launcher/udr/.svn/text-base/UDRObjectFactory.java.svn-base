package gov.georgia.dhr.dfcs.sacwis.launcher.udr;

import java.util.HashMap;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.launcher.udr.impl.UDRCaseWatchActivityHelper;
import gov.georgia.dhr.dfcs.sacwis.launcher.udr.impl.UDRFinancialExceptionHelper;
import gov.georgia.dhr.dfcs.sacwis.launcher.udr.impl.UDRFostCareChildrenHelper;
import gov.georgia.dhr.dfcs.sacwis.launcher.udr.impl.UDRInvAllegHelper;
import gov.georgia.dhr.dfcs.sacwis.launcher.udr.impl.UDROngoingHelper;
import gov.georgia.dhr.dfcs.sacwis.launcher.udr.impl.UDRResourceDevHelper;

/**
 * This factory will return a UDR Helper object based on the type passed
 * into the createUDRObject method.
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   3/25/09  wjcochran  Initial file creation
 *   4/01/09  wjcochran  Moved Report Name static variables to this class and out
 *                       of the helper class which is no longer used.
 *   1/29/10  ssubram    Added Case Watch Activity Report.
 *   6/04/10  vvo        Added Financial Exception report 
 * @author wjcochran
 *
 */
public class UDRObjectFactory {

  // Report Names
  public static final String UDR_INV_ALLEG_REPT = "UDRIntakeAllegationsRept";
  public static final String UDR_FOST_CARE_CHILDREN_REPT = "UDRFosterCareChildrenRept";
  public static final String UDR_ONGOING_REPT = "UDROngoingRept";
  public static final String UDR_RESOURCE_DEV_REPT = "UDRResourceDevRept";
  public static final String UDR_CASE_WATCH_ACT_REPT = "UDRCaseWatchActRept";
  public static final String UDR_FINANCIAL_EXCEPTION_BATCH_REPT = "UDRFinancialExceptionBatchRept";
  // use Map for future update; trying to set the corresponding Helper class as value
  public static final Map<String, String> BATCH_REPORTS = new HashMap<String, String>() {
	  {
		  put(UDR_FINANCIAL_EXCEPTION_BATCH_REPT, UDR_FINANCIAL_EXCEPTION_BATCH_REPT);
	  }
		  
  };
  /**
   * return a UDR Helper object specific to the type
   * passed in. if the type cannot be matched, an
   * IllegalArgumentException is thrown.
   * @param udrType
   * @return
   * @throws IllegalArgumentExeption - when the type is not recognized
   * and no reference to a subclass can be found.
   */
  public static UDRBaseObject createUDRObject(String udrType) {
    if (UDR_INV_ALLEG_REPT.equals(udrType)) {
      return new UDRInvAllegHelper();
    } else if (UDR_FOST_CARE_CHILDREN_REPT.equals(udrType)) {
      return new UDRFostCareChildrenHelper();
    } else if (UDR_RESOURCE_DEV_REPT.equals(udrType)) {
      return new UDRResourceDevHelper();
    } else if (UDR_ONGOING_REPT.equals(udrType)) {
      return new UDROngoingHelper();
    } else if (UDR_CASE_WATCH_ACT_REPT.equals(udrType)) {
      return new UDRCaseWatchActivityHelper();
    } else if (UDR_FINANCIAL_EXCEPTION_BATCH_REPT.equals(udrType)) {
    	return new UDRFinancialExceptionHelper();
    }

    throw new IllegalArgumentException("UDR Type " + udrType + "Not Recognized.");
  }
}
