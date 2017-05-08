/**
 * Created on Mar 25, 2006 at 2:32:39 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.DelvrdSvcDtl;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * <pre>
 *    Change History:
 *    Date      User      Description
 *    --------  --------  --------------------------------------------------
 *   04/09/2009 bgehlot   STGAP00013273: Added the method findSvcAuthDtlByIdInvoice
 *                        
 * </pre>
 */

public interface DelvrdSvcDtlDAO {
  static final String CD_SVC_DTL_A = "18A";
  static final String CD_SVC_DTL_B = "18B";
  static final String CD_SVC_DTL_C = "18C";
  static final String CD_SVC_DTL_D = "18D";
  static final String CD_SVC_DTL_E = "18E";
  static final String CD_SVC_DTL_F = "18F";
  static final String CD_PAL_SERVICE_CATGORY = "TRN";
  
  /**
   * Retrieves a single record using the primary key.
   * 
   * @param idSvcDtl
   * @return
   */
  DelvrdSvcDtl findDelvrdSvcDtlByPrimaryKey(int idSvcDtl);

  /**
   * This will retrieve all the rows from DelvrdSvcDtl given idInvoice.
   *
   * @param idInvoice *
   * @return
   */
  DelvrdSvcDtl findDelvrdSvcDtl(int idInvoice);

  /**
   * This will retrieve a list of Delivered Service Detail records from DelvrdSvcDtl 
   * for a given idInvoice.
   * @param idInvoice 
   * @return List<DelvrdSvcDtl>
   */
  public List<DelvrdSvcDtl> findIdSvcAuthDtlByIdInvoice(int idInvoice);
  /**
   * This will retrieve all the rows from DelvrdSvcDtl given idInvoice and cdSvcDtlLiType.
   *
   * @param idInvoice
   * @param cdSvcDtlLiType
   * @return
   */
  long countDelvrdSvcDtlByIdInvoiceCdSvcDtlLiType(int idInvoice, String cdSvcDtlLiType);

  /**
   * This dam will retrieve two sums, and three other elements particular to a contract service line item. It will
   * search DELVRD SVC DTL table by IdInovice.
   *
   * @param idInvoice
   * @param cdCnsvcPaymentType
   * @return keys nbrSvcDtlCsli, nbrSvcDtlUnitQty, cdSvcDtlLiType, cdSvcDtlService, amtSvcDtlFeePaid
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findDelvrdSvcDtlByIdInvoiceCdCnsvcPaymentType(int idInvoice, String cdCnsvcPaymentType);
  
  /**
   * Returns all idSvcAuthDtl values from DelvrdSvcDtl for the given parameters.  This method was
   * built for the DeliveredServiceValidation service.
   * 
   * @param idPerson
   * @param moSvcDtlSvcMonth
   * @param yrSvcDtlServiceYear
   * @param cdSvcDtlCounty
   * @param cdSvcDtlService
   * @return
   */
  List<Integer> findIdSvcAuthDtl(int idPerson, int moSvcDtlSvcMonth, int yrSvcDtlServiceYear,
                                 String cdSvcDtlCounty, String cdSvcDtlService);

  /**
   * Partial insert of DelvrdSvcDtl table using the supplied parameters(column values). (Note that the insert is done
   * using straight SQL)
   *
   * @param lastUpdate
   * @param idInvoInvoice
   * @param idPerson
   * @param idResource
   * @param amtSvcDtlFeePaid
   * @param amtSvcDtlIncome
   * @param amtSvcDtlUnitRate
   * @param cdSvcDtlInvoDisptn
   * @param cdSvcDtlLiType
   * @param cdSvcDtlService
   * @param cdSvcDtlUnitType
   * @param indSvcDtlRejItem
   * @param moSvcDtlSvcMonth
   * @param nbrSvcDtlCsli
   * @param nbrSvcDtlFromDay
   * @param nbrSvcDtlToDay
   * @param nbrSvcDtlUnitQty
   * @param yrSvcDtlServiceYear
   * @return int The number of entities effected by the 'insert' operation.
   */
  int insertDelvrdSvcDtl(Date lastUpdate, int idInvoInvoice, int idPerson, int idResource,
                         double amtSvcDtlFeePaid, double amtSvcDtlIncome, double amtSvcDtlUnitRate,
                         String cdSvcDtlInvoDisptn, String cdSvcDtlLiType, String cdSvcDtlService,
                         String cdSvcDtlUnitType, String indSvcDtlRejItem, int moSvcDtlSvcMonth, int nbrSvcDtlCsli,
                         int nbrSvcDtlFromDay, int nbrSvcDtlToDay, double nbrSvcDtlUnitQty, int yrSvcDtlServiceYear);

  /**
   * Partial update of DelvrdSvcDtl table using the supplied parameters(column values).
   *
   * @param idSvcDtl
   * @param idInvoInvoice
   * @param idPerson
   * @param idResource
   * @param amtSvcDtlFeePaid
   * @param amtSvcDtlIncome
   * @param amtSvcDtlUnitRate
   * @param cdSvcDtlInvoDisptn
   * @param cdSvcDtlLiType
   * @param cdSvcDtlService
   * @param cdSvcDtlUnitType
   * @param indSvcDtlRejItem
   * @param moSvcDtlSvcMonth
   * @param nbrSvcDtlCsli
   * @param nbrSvcDtlFromDay
   * @param nbrSvcDtlToDay
   * @param nbrSvcDtlUnitQty
   * @param yrSvcDtlServiceYear
   * @param lastUpdate
   * @return int The number of entities effected by the 'update' operation.
   */
  int updateDelvrdSvcDtl(int idSvcDtl, int idInvoInvoice, int idPerson, int idResource, //int idSvcAuthDtl,
                         double amtSvcDtlFeePaid, double amtSvcDtlIncome, double amtSvcDtlUnitRate,
                         String cdSvcDtlInvoDisptn, String cdSvcDtlLiType, String cdSvcDtlService,
                         String cdSvcDtlUnitType, String indSvcDtlRejItem, int moSvcDtlSvcMonth, int nbrSvcDtlCsli,
                         int nbrSvcDtlFromDay, int nbrSvcDtlToDay, double nbrSvcDtlUnitQty, int yrSvcDtlServiceYear,
                         Date lastUpdate);

  /**
   * Partial update of DelvrdSvcDtl given idSvcDtlRevrsalOrig.
   *
   * @param idSvcDtlRevrsalOrig return
   */
  int updateDelvrdSvcDtlCdSvcDtlInvoDisptn(int idSvcDtlRevrsalOrig);

  /**
   * Partial update of DelvrdSvcDtl given idSvcDtlRevrsalOrig.
   *
   * @param idSvcDtlRevrsalOrig return
   */
  int updateDelvrdSvcDtlIdSvcDtlRevrsalOrig(int idSvcDtlRevrsalOrig);

  /**
   * Partial update of DelvrdSvcDtl using the supplied parameters(column values).
   *
   * @param amtSvcDtlUnitRate
   * @param idInvoice
   * @param nbrSvcDtlCsli
   * @param cdSvcDtlLiType
   * @param tsLastUpdate
   * @return # rows affected
   */
  int updateDelvrdSvcDtlamtSvcDtlUnitRate(double amtSvcDtlUnitRate, int idInvoice, int nbrSvcDtlCsli,
                                          String cdSvcDtlLiType, Date tsLastUpdate);
  
  /**
   * Updates the DelvrdSvcDtl record's nbrCheck, amtSmilePaid, and dtPaid values.
   * 
   * @param idSvcDtl
   * @param nbrCheck
   * @param amtSmilePaid
   * @param dtPaid
   * @return
   */
  int updateDelvrdSvcDtlAsPaid(int idSvcDtl, int nbrCheck, double amtSmilePaid, Date dtPaid);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.DelvrdSvcDtl} object.
   *
   * @param delvrdSvcDtl
   */
  void deleteDelvrdSvcDtl(DelvrdSvcDtl delvrdSvcDtl);
  
  /**
   * Calls Session#saveOrUpdate() to either insert or update the given DelvrdSvcDtl object.
   * 
   * @param delvrdSvcDtl
   */
  void saveDelvrdSvcDtl(DelvrdSvcDtl delvrdSvcDtl);
  /**
   * 
   * @param idSvcDtl
   * @param idInvoice
   * @return
   */
  DelvrdSvcDtl findDelvrdSvcDtlByInvoiceIdnIdSvcDtl(int idSvcDtl,int idInvoice);
  
   /**
   * 
   * @param idSvcAuthDtl
   * @return
   */
  List<DelvrdSvcDtl> findDlvrdDtlByIdSvcAuth(int idSvcAuthDtl);
  
  //STGAP00007737: The next 4 sqls are defined to be used in the validation of
  //the Person Id, Resource Id, To and From date fields on the Invoice line items 
  //and the perdiem services.
  /**
   * This will retrieve a list of Delivered Service Detail records from DelvrdSvcDtl 
   * where the person id do not match the idPerson passed for a given idInvoice.
   *
   * @param idInvoice 
   * @param idPerson
   * @return List<DelvrdSvcDtl>
   */
  List<DelvrdSvcDtl> findDelvrdSvcDtlByIdInvoiceAndIdPerson(int idInvoice, int idPerson);
  
  /**
   * This will retrieve a list of Delivered Service Detail records from DelvrdSvcDtl 
   * where the resource Id do not match the idResource passed for a given idInvoice.
   *
   * @param idInvoice 
   * @param idResource
   * @return List<DelvrdSvcDtl>
   */
  List<DelvrdSvcDtl> findDelvrdSvcDtlByIdInvoiceAndIdResource(int idInvoice, int idResource);
  
  /**
   * This will retrieve a list of Delivered Service Detail records from DelvrdSvcDtl 
   * where the to day or from day do not match with the toDay or fromDay passed for a given idInvoice.
   *
   * @param idInvoice 
   * @param toDay
   * @param fromDay
   * @return List<DelvrdSvcDtl>
   */
  List<DelvrdSvcDtl> findDelvrdSvcDtlByIdInvoiceAndToDay(int idInvoice, int toDay, int fromDay);
  
 /** 
   * This will retrieve a list of Delivered Service Detail records from DelvrdSvcDtl 
   * where the to day or from day do not match with the toDay or fromDay passed for a given idInvoice.
   *
   * @param idInvoice 
   * @param toDay
   * @param fromDay
   * @return List<DelvrdSvcDtl>
   */
  List<DelvrdSvcDtl> findDelvrdSvcDtlByIdInvoiceAndToDayAndCdSvcDtlService(int idInvoice, int toDay, int fromDay, int idSvcDtl);
  
  /**
   * This will retrieve a list of Delivered Service Detail records from DelvrdSvcDtl 
   * where the service is in the restricted fund services list and the item total is 0.0.
   *
   * @param idInvoice 
   * @param restrictedFundList
   * @return List<DelvrdSvcDtl>
   */
  List<DelvrdSvcDtl> findDlvrdDtlByIdInvoice(int idInvoice, Collection<String> restrictedFundList);
  
  /**
   *  STGAP00013273: Added this method to retrieve Service
   * @param idInvoice
   * @return List<DelvrdSvcDtl>
   */

  public List<DelvrdSvcDtl> findSvcAuthDtlByIdInvoice(int idInvoice);
}
