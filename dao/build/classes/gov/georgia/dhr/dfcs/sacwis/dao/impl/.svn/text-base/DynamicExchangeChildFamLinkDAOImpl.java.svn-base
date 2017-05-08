package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicExchangeChildFamLinkDAO;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;

/**
 * This DAO contains sql that retrieves the code, decode and end date combinations for a given code type from the
 * Database based on the search criteria . <p/>
 * 
 * <pre>
 *    Change History:
 *    Date          User              Description
 *    ----------    ------------      --------------------------------------------------
 *    07/18/2008    vdevarakonda      Initial class creation 
 *    11/17/2009    mxpatel           37440: Modified the method to sort by Decode instead of Code.  
 *    12/15/2009    mxpatel           SMS# 40849: added findExchangeChildFamLinksByResourceEventIdAndCurrentIndByDir method to make
 *                                    sort values of NAC and Date_out on Exchange Home Detail page.       
 * </pre>
 */

public class DynamicExchangeChildFamLinkDAOImpl extends DynamicBaseDAOImpl implements DynamicExchangeChildFamLinkDAO {
  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Object[]> findExchangeChildFamLinks(int idChildRegEvent, String indLinkCurrent, String cdSortBy, int pageNbr,
                                                               int pageSize, boolean sortAscending) {  
  StringBuffer queryBuffer = new StringBuffer(
                                                "  SELECT  ID_RESOURCE AS ID_RESOURCE, "
                                                                + "          NM_RESOURCE AS NM_RESOURCE, "
                                                                + "          CD_NON_AVAIL_CODE AS CD_NON_AVAIL_CODE, "
                                                                + "          CD_NON_SELECTION_RSN AS CD_NON_SELECTION_RSN, "
                                                                + "          CD_RSRC_CNTY AS CD_RSRC_CNTY, "
                                                                + "          ID_EVENT AS ID_EVENT, "
                                                                + "          DT_OUT AS DT_OUT, "
                                                                + "          DT_LAST_UPDATE AS DT_LAST_UPDATE, "
                                                                + "          ID_EXCHANGE_CHILD_FAM_LINK AS ID_EXCHANGE_CHILD_FAM_LINK "
                                                                + "          FROM (SELECT"
                                                                + "                        r.ID_RESOURCE, "
                                                                + "                        r.NM_RESOURCE, "
                                                                + "                        el.CD_NON_AVAIL_CODE, "
                                                                + "                        el.CD_NON_SELECTION_RSN, "
                                                                + "                        r.CD_RSRC_CNTY, "
                                                                + "                        eh.ID_EVENT, "
                                                                + "                        el.DT_OUT, "
                                                                + "                        el.DT_LAST_UPDATE, "
                                                                + "                        el.ID_EXCHANGE_CHILD_FAM_LINK "
                                                                + "                 FROM "
                                                                + "                  CAPS_RESOURCE r, "
                                                                + "                  EXCHANGE_CHILD_FAM_LINK el, "
                                                                + "                  EXCHANGE_HOME eh, "
                                                                + "                  CODES_TABLES CT "
                                                                + "                 WHERE el.ID_EVENT_HOME_REGISTRATION = eh.ID_EVENT "
                                                                + "                 AND eh.ID_RESOURCE = r.ID_RESOURCE "
                                                                + "                 AND el.ID_EVENT_CHILD_REGISTRATION = :idChildRegEvent "
                                                                + "                 AND el.IND_LINK_CURRENT = :indLinkCurrent "
                                                                + "                 AND CT.CODE_TYPE(+) = 'CANONAV' "
                                                                + "                 AND CT.CODE(+) = el.CD_NON_AVAIL_CODE " );

  
  // sort and format the list with the appropriate data type for Hibernate 
  if (SORT_BY_NON_AVAIL_RSN_CODE.equals(cdSortBy)) {
    if (sortAscending) {  
                queryBuffer.append(" ORDER BY CT.DECODE asc ");
    } else {
      queryBuffer.append(" ORDER BY CT.DECODE desc ");
    }
  } else if (SORT_BY_DT_OUT.equals(cdSortBy)) {
    if (sortAscending) {
      queryBuffer.append(" ORDER BY el.DT_OUT asc ");
    } else {
      queryBuffer.append(" ORDER BY el.DT_OUT desc ");
    }
  } 
  queryBuffer.append(" )");
  SQLQuery query = getSession().createSQLQuery(queryBuffer.toString());
  query.setInteger("idChildRegEvent", idChildRegEvent);
  query.setString("indLinkCurrent", indLinkCurrent);
  query.addScalar("ID_RESOURCE", Hibernate.INTEGER);
  query.addScalar("NM_RESOURCE", Hibernate.STRING);
   query.addScalar("CD_NON_AVAIL_CODE", Hibernate.STRING);
  query.addScalar("CD_NON_SELECTION_RSN", Hibernate.STRING);
  query.addScalar("CD_RSRC_CNTY", Hibernate.STRING);
  query.addScalar("ID_EVENT", Hibernate.INTEGER);
  query.addScalar("DT_OUT", Hibernate.DATE);
  query.addScalar("DT_LAST_UPDATE", Hibernate.DATE);
  query.addScalar("ID_EXCHANGE_CHILD_FAM_LINK", Hibernate.INTEGER);
  return (PaginatedHibernateList<Object[]>) this.paginatedList(pageNbr, pageSize, query);
}
  
  @SuppressWarnings( { "unchecked" })
  public List<Map>  findExchangeChildFamLinksByResourceEventIdAndCurrentIndByDir(int idResourceEvent,
                                                                                            String indLinkCurrent, String orderBy,
                                                                                String sortDir) {

    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 "select e.ID_EXCHANGE_CHILD_FAM_LINK as ID_EXCHANGE_CHILD_FAM_LINK, "
                                                                 + " e.ID_EVENT_CHILD_REGISTRATION as ID_EVENT_CHILD_REGISTRATION, "
                                                                 + " e.DT_OUT as DT_OUT, "
                                                                 + " e.DT_LAST_UPDATE as DT_LAST_UPDATE, "
                                                                 + " e.CD_NON_SELECTION_RSN as CD_NON_SELECTION_RSN, "
                                                                 + " e.CD_NON_AVAIL_CODE as CD_NON_AVAIL_CODE  "
                                                                 + " from exchange_child_fam_link e, codes_tables ct "
                                                                 + " where e.id_event_home_registration = :idResourceEvent "
                                                                 + " and ct.code(+) = e.cd_non_avail_code "
                                                                 + " and ct.code_type(+) = 'CANONAV' "
                                                                 + " and e.ind_link_current = :indLinkCurrent "
                                                                 + " order by " + orderBy + " " + sortDir);

    query.setInteger("idResourceEvent", idResourceEvent);
    query.setString("indLinkCurrent", indLinkCurrent);
    query.addScalar("ID_EXCHANGE_CHILD_FAM_LINK", Hibernate.INTEGER);
    query.addScalar("ID_EVENT_CHILD_REGISTRATION", Hibernate.INTEGER);
    query.addScalar("DT_OUT", Hibernate.DATE);
    query.addScalar("DT_LAST_UPDATE", Hibernate.DATE);
    query.addScalar("CD_NON_SELECTION_RSN", Hibernate.STRING);
    query.addScalar("CD_NON_AVAIL_CODE", Hibernate.STRING);
    // return (List<Map>) query.list();
    List<Map> list = new ArrayList<Map>();
    for (Object o : query.list()) {
      Object[] array = (Object[]) o;
      Map map = new HashMap();
      map.put("ID_EXCHANGE_CHILD_FAM_LINK", array[0]);
      map.put("ID_EVENT_CHILD_REGISTRATION", array[1]);
      map.put("DT_OUT", array[2]);
      map.put("DT_LAST_UPDATE", array[3]);
      map.put("CD_NON_SELECTION_RSN", array[4]);
      map.put("CD_NON_AVAIL_CODE", array[5]);
      list.add(map);
    }
    return list;
  }
}
