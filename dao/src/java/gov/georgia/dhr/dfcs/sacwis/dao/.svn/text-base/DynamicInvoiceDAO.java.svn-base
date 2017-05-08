/**
 * Created on May 21, 2006 at 4:07:34 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.Invoice;

import java.util.Date;

/**
  *                 Change History:
  *        Date      User              Description
  *    --------  ----------------  --------------------------------------------------
  *    04/08/2009   bgehlot        STGAP00013273:  Modified findInvoices, findPymtAprvInvoices to add idClientPerson       
  */

public interface DynamicInvoiceDAO {
  static final String SORT_BY_INITIAL = "2";
  static final String SORT_BY_RESOURCE_NAME = "3";
  static final String SORT_BY_CONTRACT_ID = "4";
  static final int RESOURCE = 1;
  static final int CONTRACT = 2;
  
  /*
  enum SearchId{
    RESOURCE("Resource ID"),
    CONTRACT("Contract ID");
    
    private String alias;
    
    SearchId(String alias){
      this.alias = alias;
    }
    
    public String toString(){
      return alias;
    }
  }
  */

  /**
   * This retreieves invoice information using the given criteria.  No parameters are required.  Use zero's and nulls
   * for parameters that are not used.
   * <p/>
   * It returns a list of object arrays with the following:
   * <pre>
   * String szCdInvoApproved = INVOICE.CD_INVO_APPROVED = row[0]
   * String ulIdInvoice = INVOICE.ID_INVOICE = row[1]
   * String szCdInvoPhase = INVOICE.CD_INVO_PHASE = row[2]
   * String dtDtInvoReceivedDate = INVOICE.DT_INVO_RECEIVED_DATE = row[3]
   * String amtInvoValidAmount = INVOICE.AMT_INVO_VALID_AMOUNT = row[4]
   * String ulIdPerson = INVOICE.ID_PERSON = row[5]
   * String dtDtlastUpdate = INVOICE.DT_LAST_UPDATE = row[6]
   * String dtDtInvoApprovalDate = INVOICE.DT_INVO_APPROVAL_DATE = row[7]
   * String szNmResource = CAPS_RESOURCE.NM_RESOURCE = row[8]
   * String ulIdResource CONTRACT.ID_RESOURCE = row[9]
   * String ulIdContract = CONTRACT.ID_CONTRACT = row[10]
   * </pre>
   *
   * @param cdCountyRegions
   * @param cdSortBy
   * @return See description.
   */
  PaginatedHibernateList<Object[]> findInvoices(String[] cdCountyRegions, String cdSortBy, int pageNbr, int pageSize, boolean sortAscending);

  /**
   * This retreieves invoice information using the given criteria.  No parameters are required.  Use zero's and nulls
   * for parameters that are not used.
   * <p/>
   * It returns a list of object arrays with the following:
   * <p/>
   * Note this method used to have a join hint; it is impossible to exactly duplicate tihs hint in Hibernate, but we are
   * also switching to Oracle 10g's statistical optimizer, so it should be irrelevant, anyway.
   * <pre>
   * String szCdCntrctRegion = C.CD_CNTRCT_REGION = row[0]
   * String ulIdResource = R.ID_RESOURCE = row[1]
   * String szNmResource = R.NM_RESOURCE = row[2]
   * String ulIdInvoice = I.ID_INVOICE = row[3]
   * String dtDtLastUpdate = I.DT_LAST_UPDATE = row[4]
   * String ulIdContract = I.ID_CONTRACT = row[5]
   * String ulIdPerson = I.ID_PERSON = row[6]
   * String szCdInvoAdjustmentRb = I.CD_INVO_ADJUSTMENT_RB = row[7]
   * String szCdInvoInvoApproved = I.CD_INVO_APPROVED = row[8]
   * String szCdInvoInvoGeneration = I.CD_INVO_GENERATION = row[9]
   * String szCdInvoPhase = I.CD_INVO_PHASE = row[10]
   * String szCdInvoType = I.CD_INVO_TYPE = row[11]
   * String szCdInvoApprovalDate = I.DT_INVO_APPROVAL_DATE = row[12]
   * String szCdInvoCreateDate = I.DT_INVO_CREATE_DATE = row[13]
   * String szCdInvoEntryCompleted = I.DT_INVO_ENTRY_COMPLETED = row[14]
   * String szCdInvoEntryStarted = I.DT_INVO_ENTRY_STARTED = row[15]
   * String szCdInvoInvoRecievedDate = I.DT_INVO_RECEIVED_DATE = row[16]
   * String szCdInvoSubmitDate = I.DT_INVO_SUBMIT_DATE = row[17]
   * String szCdInvoWarrantDate = I.DT_INVO_WARRANT_DATE = row[18]
   * String amtInvoClaimedAmount = I.AMT_INVO_CLAIMED_AMOUNT = row[19]
   * String amtInvoValidAmount = I.AMT_INVO_VALID_AMOUNT = row[20]
   * String amtInvoWarrant = I.AMT_INVO_WARRANT = row[21]
   * String intInvoReadyForValid = I.IND_INVO_READY_FOR_VALID = row[22]
   * String intInvoRejItems = I.IND_INVO_REJ_ITEMS = row[23]
   * String uMoInvoMonth I.MO_INVO_MONTH = row[24]
   * String szNbrInvoVid I.NBR_INVO_VID = row[25]
   * String szNbrInvoWarrant I.NBR_INVO_WARRANT = row[26]
   * String uYrInvoYear I.YR_INVO_YEAR = row[27]
   * </pre>
   *
   * @param idInvoInvoice
   * @param idContract
   * @param idResource
   * @param cdCntrctRegion
   * @param moInvoMonth
   * @param cdInvoPhase
   * @param cdInvoType
   * @param yrInvoYear
   * @param idClientPerson
   * @return
   */
  PaginatedHibernateList<Object[]> findInvoices(int idInvoInvoice, int idContract, int idResource, String cdCntrctRegion, 
                                                String cdInvoCounty, int moInvoMonth, String cdInvoPhase, String cdInvoType, 
                                                int yrInvoYear, int pageNbr, int pageSize, int idClientPerson );
  
 
  PaginatedHibernateList<Invoice> findInvoicesBySearchId(int type, int id, Date from, Date to, String region,
                                                         String county, int pageNbr, int pageSize);
  
  Double sumValidAmountBySearchId(int type, int id, Date from, Date to, String region, String county);
  
  //STGAP00004617: Added a new Sql to retrieve only those invoices that are filtered by the search criteria entered on the
  //Payment Approval page. 
  /**
   * This retreieves invoice information using the given criteria. 
   * <p/>
   * It returns a list of object arrays with the following:
   * <p/>
   * <pre>
   * String ulIdResource = R.ID_RESOURCE = row[0]
   * String szNmResource = R.NM_RESOURCE = row[1]
   * String ulIdInvoice = I.ID_INVOICE = row[2]
   * String dtDtLastUpdate = I.DT_LAST_UPDATE = row[3]
   * String ulIdContract = I.ID_CONTRACT = row[4]
   * String ulIdPerson = I.ID_PERSON = row[5]
   * String szCdInvoInvoApproved = I.CD_INVO_APPROVED = row[6]
   * String szCdInvoPhase = I.CD_INVO_PHASE = row[7]
   * String szCdInvoApprovalDate = I.DT_INVO_APPROVAL_DATE = row[8]
   * String szCdInvoInvoRecievedDate = I.DT_INVO_RECEIVED_DATE = row[9]
   * String amtInvoValidAmount = I.AMT_INVO_VALID_AMOUNT = row[10]
   * String nmClient = P.NM_PERSON_FULL = row[11]
   * </pre>
   *
   * @param idContract
   * @param idResource
   * @param cdCntrctRegion
   * @param cdInvoCounty
   * @param moInvoMonth
   * @param cdInvoAprvStatus
   * @param cdInvoType
   * @param yrInvoYear
   * @param pageNbr
   * @param pageSize
   * @param idClientPerson
   * @return
   */
  PaginatedHibernateList<Object[]> findPymtAprvInvoices(int idContract, int idResource, String cdCntrctRegion,
                                                        String cdInvoCounty, int moInvoMonth, String cdInvoAprvStatus,
                                                        String cdInvoType, int yrInvoYear, int pageNbr, int pageSize, int idClientPerson);
}
