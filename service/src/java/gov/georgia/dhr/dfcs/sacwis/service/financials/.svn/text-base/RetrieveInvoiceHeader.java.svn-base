package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CFIN02SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFIN02SO;

public interface RetrieveInvoiceHeader {

  /**
   * Retrieves the information for the entry fields for CFIN03W - INVOICE HEADER.  If the window is in NEW mode, the
   * service will call ContractDAO to retrieve information specific to the contract from CONTRACT, CAPS RESOURCE, AND
   * RESOURCE ADDRESS tables. In modify or BROWSE mode, the DAM will retrieve invoice information from INVOICE, in
   * addition to the former information from InvoiceDAO.
   *
   * @param cfin02si Input object containing the method parameters.
   * @return CFIN02SO Output object containing the retrieved row/column values.
   */
  public CFIN02SO findInvoiceHeaderInformation(CFIN02SI cfin02si);
}
