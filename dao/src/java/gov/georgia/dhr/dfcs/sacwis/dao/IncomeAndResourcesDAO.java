/**
 * Created on Mar 25, 2006 at 2:59:59 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.ChildSupportInbound;
import gov.georgia.dhr.dfcs.sacwis.db.IncomeAndResources;

/*Change History:
Date         User            Description
-----------  --------------  --------------------------------------------------

05/31/2011   schoi           SMS #109403: MR-082 Added new method findMostRecentInccomeByIdPersonByCdIncRsrcType
06/01/2011   schoi           SMS #109403: MR-082 Updated the name of the method findMostRecentInccomeByIdPersonByCdIncRsrcType
                             to findMostRecentIncomeAsOfTodayByIdPersonByCdIncRsrcType to reflect new Date parameter

*/

public interface IncomeAndResourcesDAO {
  /**
   * The count IncomeAndResource rows for this idPerson for dtIncRsrcFrom / dtIncRsrcTo today.
   *
   * @param idPerson
   * @return The count IncomeAndResource rows for this idPerson for dtIncRsrcFrom / dtIncRsrcTo today.
   */
  long countIncomeAndResourceForToday(int idPerson);
  /**
   * The count IncomeAndResource rows for these idPersMergeForward, idPersMergeClosed for dtIncRsrcFrom / dtIncRsrcTo
   * today.
   *
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @return The count IncomeAndResource rows for these idPersMergeForward, idPersMergeClosed for dtIncRsrcFrom /
   *         dtIncRsrcTo today.
   */
  long countIncomeAndResourceMergeFwdClsdToday(int idPersMergeForward, int idPersMergeClosed);

  /**
   * Retrieves all info from the income_and_resources table given idPerson.
   * <p/>
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   * @param idPerson
   * @return
   */
  @SuppressWarnings({"unchecked"})
  IncomeAndResources findDistinctIncomeAndResourcesInfo(int idPerson);
  
  /**
   * Retrieves all records that have the same cdIncRsrcType and whose effective dates overlap the host effective dates
   * and whose idIncRsrc doesn't equal the host idIncRsrc. Inclusion of cdIncRsrcIncome in the WHERE clause prevents
   * returning a row because OTHER(code:'XXX') exists for both Income and Resource. (Thus a check must be made to see
   * from which table the 'other' is coming)
   *
   * @param cdIncRsrcType
   * @param idIncRsrc
   * @param dtIncRsrcTo
   * @param dtIncRsrcFrom
   * @param idPerson
   * @param cdIncRsrcIncome
   * @return List of retrieved idIncRsrc(Integer object)
   */
  List<Integer> findIdIncRsrcFromIncomeAndResources(String cdIncRsrcType, int idIncRsrc, Date dtIncRsrcTo,
                                                    Date dtIncRsrcFrom, int idPerson, String cdIncRsrcIncome);

  /**
   * Returns an IncomeAndResource record by idPerson along with their full name
   *
   * @param idPerson
   * @return List<Map>
   */
  @SuppressWarnings(("unchecked"))
  List<Map> findIncomeAndResourcesAndNmFull(int idPerson);
  
  /**
   * Retrieves all IncomeAndResources records for idPerson (ID_PERSON) where CD_INC_RSRC_TYPE is one of
   * the values specified in cdIncRsrcType and DT_INC_RSRC_FROM <= dtEffective <= DT_INC_RSRC_TO.
   * 
   * @param idPerson
   * @param cdIncRsrcType
   * @param dtEffective
   * @return
   */
  List<IncomeAndResources> findByIdPersonAndTypeAndDate(int idPerson, String[] cdIncRsrcType, Date dtEffective);

  /**
   * Will Add, Update or Delete rows on the INCOME AND RESOURCES table.  ID INC RSRC and SYS TS LAST UPDATE will be used
   * to identify rows to be updated or deleted.
   *
   * @param incomeAndResources
   */
  void saveIncomeAndResources(IncomeAndResources incomeAndResources);

  /*
   * This method is used for updating the INCOME_AND_RESOURCES table for 
   * Receive Child Support Payment Info Service
  */
  @SuppressWarnings("unchecked")
  public int insertPaymentRecdIncomeAndResources(int idPerson, int idWorker, double amtIncRsrc,
                                      String cdIncRsrcType, String cdIncRsrcIncome, Date dtIncRsrcFrom,
                                      Date dtIncRsrcTo, String txtIncRsrcDesc, String cdIncRsrcFreqType);
  
  /*
   * This method is used for updating the CHILD_SUPPORT_INBOUND audit table for 
   * Receive Child Support Payment Info Service
  */
  @SuppressWarnings("unchecked")
  public void saveChildSupportInbound(ChildSupportInbound childSupportInbound);
  
  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.IncomeAndResources} object.
   *
   * @param incomeAndResources
   */
  public void deleteIncomeAndResources(IncomeAndResources incomeAndResources);

  /**
   * Inserts a record in the IncomeAndResource table
   *
   * @param idPerson
   * @param idIncRsrcWorker
   * @param dtLastUpdate
   * @param amtIncRsrc
   * @param cdIncRsrcType
   * @param cdIncRsrcIncome
   * @param dtIncRsrcFrom
   * @param dtIncRsrcTo
   * @param indIncRsrcNotAccess
   * @param sdsIncRrcsSource
   * @param sdsIncRsrcVerfMethod
   * @param txtIncRsrcDesc
   * @return
   */
  int insertIncomeAndResources(int idPerson, int idIncRsrcWorker, Date dtLastUpdate, double amtIncRsrc,
                               String cdIncRsrcType, String cdIncRsrcIncome, Date dtIncRsrcFrom,
                               Date dtIncRsrcTo, String indIncRsrcNotAccess, String sdsIncRrcsSource,
                               String sdsIncRsrcVerfMethod, String txtIncRsrcDesc);
  /**
   * Finds all of the incomes and resources for a particular person base on a start date and an end date
   * 
   * @param idPerson
   * @param currentMonthStartDate
   * @param currentMonthEndDate
   * @return
   */
  List<Map> findIncomeAndResourcesByIdPerson(int idPerson, Date currentMonthStartDate, Date currentMonthEndDate);
  
  /**
   * 
   * @param cdIncRsrcType
   * @param cdIncRsrcIncome
   * @param dtIncRsrcTo
   * @param dtIncRsrcFrom
   * @param idPerson
   * @param idIncRsrcWorker
   * @param sdsIncRrcsSource
   * @param txtIncRsrcSrcAddrZip
   * @return
   */
  IncomeAndResources findIncomeandResourcesByInboundParamsnZip(String cdIncRsrcType, String cdIncRsrcIncome, Date dtIncRsrcTo,
                                                               Date dtIncRsrcFrom, int idPerson, int idIncRsrcWorker, String sdsIncRrcsSource, 
                                                               String txtIncRsrcSrcAddrZip );
  
  /**
   * 
   * @param cdIncRsrcType
   * @param cdIncRsrcIncome
   * @param dtIncRsrcTo
   * @param dtIncRsrcFrom
   * @param idPerson
   * @param idIncRsrcWorker
   * @param sdsIncRrcsSource
   * @return
   */
  IncomeAndResources findIncomeandResourcesByInboundParams(String cdIncRsrcType, String cdIncRsrcIncome, Date dtIncRsrcTo,
                                                                  Date dtIncRsrcFrom, int idPerson, int idIncRsrcWorker, String sdsIncRrcsSource );
  
  /**
   * Gets the income and resource records for the given person
   * @param idPerson
   * @return
   */
  List<IncomeAndResources> findByIdPerson(int idPerson);

  // SMS #109403: MR-082
  /**
   * Gets the most recent income and resource records as of current date for the given person by cdIncRsrcType
   * @param idPerson
   * @param cdIncRsrcType
   * @param dtCurrentDate
   * @return
   */
 IncomeAndResources findMostRecentIncomeAsOfTodayByIdPersonByCdIncRsrcType(int idPerson, String cdIncRsrcType, Date dtCurrentDate);
}
