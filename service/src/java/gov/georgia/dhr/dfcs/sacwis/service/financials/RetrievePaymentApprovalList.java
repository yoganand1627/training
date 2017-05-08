package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN19SO;

public interface RetrievePaymentApprovalList {

  /**
   * This service will retrieve selected columns for dynamic search criteria from the Invoice, Contract and Resource
   * tables.  The DAM, CDYN05D - INVO APPVL RTRV, retrieves all columns from the Invoice table where CD CNTRCT REGION is
   * equal to one of the regions that the user has modify access to, that are valid with and without line item
   * rejections.  It will join to the CONTRACT and CAPS RESOURCE tables.  The service will then pull the following
   * attributes from the DAM output message: ID INVOICE, ID CONTRACT, CD INVO APPROVED, CD INVO PHASE, NM RESOURCE, AMT
   * INVO VALID AMOUNT, DT INVO RECEIVED, ID PERSON, SYS TS LAST UPDATE
   *
   * @param cfin19si
   * @return
   */
  CFIN19SO retrievePaymentApprovalList(CFIN19SI cfin19si);

}
