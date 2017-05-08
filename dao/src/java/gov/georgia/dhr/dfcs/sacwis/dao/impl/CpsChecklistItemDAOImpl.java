package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.CpsChecklistItemDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CpsChecklistItem;
import org.hibernate.Query;

public class CpsChecklistItemDAOImpl extends BaseDAOImpl implements CpsChecklistItemDAO {
  @SuppressWarnings({"unchecked"})
  public List<CpsChecklistItem> findCpsCheckListItemByIdEvent(int idEvent) {
    Query query = getSession().createQuery("from CpsChecklistItem" +
                                           "  where event.idEvent = :idEvent" +
                                           "  order by cdSrvcReferred"
    );
    query.setInteger("idEvent", idEvent);
    return (List<CpsChecklistItem>) query.list();
  }

  public int deleteCpsChecklistItemByCdSvcReferred(int idChklstItem, Date tsLastUpdate, String cdSvcReferred) {
    Query query = getSession().createQuery(" delete from CpsChecklistItem" +
                                           "       where idCpsChecklistItem = :idChklstItem" +
                                           "         and dtLastUpdate = :tsLastUpdate" +
                                           "         and cdSrvcReferred = :cdSvcReferred");
    query.setInteger("idChklstItem", idChklstItem);
    query.setTimestamp("tsLastUpdate", tsLastUpdate);
    query.setString("cdSvcReferred", cdSvcReferred);
    return query.executeUpdate();
  }

  public void saveCpsChecklistItem(CpsChecklistItem cpsChecklistItem) {
    getSession().saveOrUpdate(cpsChecklistItem);
  }
}
