/**
 * Created on May 4, 2006 at 1:02:14 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;

public interface DynamicWorkloadDAO {
  // These are char values for historical reasons.
  //Added SORT_BY_UNIT, SORT_BY_LEVEL, SORT_BY_RT as per GA specifications
  //public static final String SORT_BY_INITIAL = "2";
  public static final String SORT_BY_STAGENAME = "1";
  public static final String SORT_BY_COUNTY = "2";
  public static final String SORT_BY_SERVICE_STAGE = "3";
  public static final String SORT_BY_DEFAULT = "4";
  public static final String SORT_BY_CASE = "5";
  public static final String SORT_BY_PRIMARY_SECONDARY = "6";
  public static final String SORT_BY_DATE = "7";
  public static final String SORT_BY_UNIT = "8";
  public static final String SORT_BY_LEVEL = "9";
  public static final String SORT_BY_RT = "A";
  public static final String SORT_BY_DATE_START = "B";
  public static final String SORT_BY_RECIDIVISM = "C";
  public static final String SORT_BY_FA_HOME_STATUS = "D";
  public static final String SORT_BY_FAD_IVE = "E";
  public static final String NO_FILTER = "0";
  public static final String FILTER_BY_INV_30 = "1";
  public static final String FILTER_BY_SVC_60 = "2";

  /**
   * Retrieves data for workload list box, dynamically adding the sort order.  Because it is called more than almost any
   * other DAM, and therefore performance is critical, it is implemented in straight SQL to minimize processing
   * overhead.
   * <p/>
   * The return value is list of Object arrays with the following values:
   * <pre>
   * String dtStageStart = dtDtStageStart = row[0]
   * int idStage = ulIdStage = row[1]
   * String nmStage = szNmStage = row[2]
   * String cdStageCnty = szCdStageCnty = row[3]
   * String cdStage = szCdStage = row[4]
   * String cdStageType = szCdStageType = row[5]
   * String cdStageProgram = szCdStageProgram = row[6]
   * String cdStageRegion = szCdStageRegion = row[7]
   * String cdStageReasonClosed = szCdStageReasonClosed = row[8]
   * String cdStagePersRole = szCdStagePersRole = row[9]
   * String cdMobileStatus = szCdMobileStatus = row[10]
   * Date dtStagePersLink = dtDtStagePersLink = row[11]
   * Date dtLastUpdate = tsLastUpdate = row[12]
   * String indStagePersEmpNew = bIndStagePersEmpNew = row[13]
   * int idCase = ulIdCase = row[14]
   * String indCaseSensitive = bIndCaseSensitive = row[15]
   * String nmCase = szNmCase = row[16]
   * String nbrUnit = szNbrUnit = row[17]
   * String indWkldSuperintNotif = cIndWkldSuperintNotif = row[18]
   * String cdRecidivism = szCdRecidivism = row[19]
   * </pre>
   *
   * @param idPerson
   * @param filterType
   * @param sortOrder
   * @param pageNbr
   * @param pageSize
   * @return See description.
   */
  PaginatedHibernateList<Object[]> findWorkload(int idPerson, String filterType, String sortOrder, int pageNbr,
                                                int pageSize);

  String countWorkload(int idPerson);

  String countWorkloadStages(int idPerson, String cdWkldStage);

  String countSpecializedWorkerStages(int idPerson, String cdWkldStage);
}
