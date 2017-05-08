/**
 * Created on Mar 25, 2006 at 3:06:56 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.Invoice;

import java.util.Date;
import java.util.List;

public interface InvoiceDAO {
  /**
   * This will select rows from the Invoice, Contract, & Caps Resource tables.
   *
   * @param idInvoice
   * @return An Invoice object with the Contract and the Contract's CapsResource fields already populated.
   */
  Invoice findInvoiceContractResourceIdInvoice(int idInvoice);

  /**
   * Retrieves dtInvoEntryCompleted from the Invoice table given the idInvoice.
   *
   * @param idInvoice
   * @return Date representing dtInvoEntryCompleted
   */
  Date findInvoiceDtInvoEntryCompletedByIdInvoice(int idInvoice);

  /**
   * Retrieves dtLastUpdate from the Invoice table given the idInvoice.
   *
   * @param idInvoice
   * @return Date representing dtLastUpdate
   */
  Date findInvoiceDtLastUpdate(int idInvoice);
  
  /**
   * Counts the number of paid Invoices with specific Delivered Services for a given Primary Child
   * 
   * @param idChild
   * @return
   */
  Long countPaidInvoicesByIdPerson(int idChild);

  /**
   * Partial update of Invoice table using the supplied parameters(column values).
   *
   * @param idInvoInvoice
   * @param cdInvoPhase
   * @param lastUpdate
   */
  int updateInvoice(int idInvoInvoice, String cdInvoPhase, Date lastUpdate);

  /**
   * Partial update of Invoice table using the supplied parameters(column values).
   *
   * @param idInvoInvoice
   * @param cdInvoPhase
   * @param lastUpdate
   */
  int updateInvoiceSetIdInvoiceAndCdInvoPhase(int idInvoInvoice, String cdInvoPhase, Date lastUpdate);

  /**
   * Partial update of Invoice table using the supplied parameters(column values).
   *
   * @param nbrRsrcAddrVid
   * @param idRsrcAddress
   */
  int updateInvoiceNbrInvoVid(String nbrRsrcAddrVid, int idRsrcAddress);

  /**
   * Calls the Hibernate method saveOrUpdate() for the given {@link gov.georgia.dhr.dfcs.sacwis.db.Invoice} object.
   * 
   * @param invoice
   */
  void saveOrUpdate(Invoice invoice);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.Invoice} object.
   *
   * @param invoice
   */
  void deleteInvoice(Invoice invoice);
  
  Invoice findInvoiceByInvoiceId(int idInvoice);
  
  String findCdInvoTypeByInvoiceId(int idInvoice);
  
}
