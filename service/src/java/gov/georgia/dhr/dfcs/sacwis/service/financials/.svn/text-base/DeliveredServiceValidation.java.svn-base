package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN29SO;

import java.util.HashSet;
import java.util.Set;

public interface DeliveredServiceValidation {

  @SuppressWarnings("serial")
  public static final Set<String> ADOPTION_INVOICES = new HashSet<String>() {
    {
      add(CodesTables.CINVTYPE_ADS);
      add(CodesTables.CINVTYPE_EAA);
    }
  };
  public static final int NINETY_SIX = 1996;
  public static final int NINETY_FIVE = 1995;
  public static final int SEPTEMBER = 9;
  public static final int JUNE = 6;

  /**
   * This service will retrieve the Name Person Full for a given Person ID and the Unit Rate, Contract Service Line Item
   * Unit Type and Payment Type from Contract and Service Auth Dtl ID from the Service Auth Dtl table.
   *
   * @param cfin29si
   * @return
   */
  CFIN29SO retrieveDeliveredServiceValidation(CFIN29SI cfin29si);
}
