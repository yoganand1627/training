/**
 * Created on September 23rd by Vishala Devarakonda
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import java.util.List;
import java.util.Map;

public interface DynamicExchangeChildFamLinkDAO {
  public static final String SORT_BY_NON_AVAIL_RSN_CODE = "1";
  public static final String SORT_BY_DT_OUT = "2";

  /**
   * This DAO will retrieve code, decode and end date from Codes Tables, based on dynamic criteria.  
   * The codeType and sortOrder parameters must be populated.
   * <p/>
   * @param idChildRegEvent
   * @param indLinkCurrent
   * @param sortOrder
   * @param pageNbr
   * @param pageSize
   * @param sortAscending
   * It returns a list of object arrays with the following:
   * <pre>
   * String idResource = RESOURCE.ID_RESOURCE = row[1]
   * String nmResource = RESOURCE.NM_RESOURCE = row[2]
   * String cdNonAvailCode = EXCHANGE_CHILD_FAM_LINK.CD_NON_AVAIL_CODE = row[3]
   * String cdNonSelectionRsn = EXCHANGE_CHILD_FAM_LINK.CD_NON_SELECTION_RSN = row[4]
   * String cdRsrcCnty = RESOURCE.CD_RSRC_CNTY = row[5]
   * Integer idEvent = EXCHANGE_CHILD_FAM_LINK.ID_EVENT_HOME_REGISTRATION = row[6]
   * Date dtOut= EXCHANGE_CHILD_FAM_LINK.DT_OUT = row[7]
   * Date dtlastUpdate = EXCHANGE_CHILD_FAM_LINK.DT_LAST_UPDATE = row[8]
   * </pre> 
   */
  public PaginatedHibernateList<Object[]> findExchangeChildFamLinks(int idChildRegEvent, String indLinkCurrent, String cdSortBy, int pageNbr,
                                                                    int pageSize, boolean sortAscending);
  
  public List<Map> findExchangeChildFamLinksByResourceEventIdAndCurrentIndByDir(int idResourceEvent, String indLinkCurrent,
                                                                         String orderBy, String sortDir);
}