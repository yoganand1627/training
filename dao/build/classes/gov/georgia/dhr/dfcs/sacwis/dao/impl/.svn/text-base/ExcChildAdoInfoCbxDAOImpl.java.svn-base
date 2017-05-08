package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ExcChildAdoInfoCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ExcChildAdoInfoCbx;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

/**
 * This is the DAO that contains the SQL to save and retrieve ExcChildAdoInfoCbx records to and from the Database. <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *  09/17/08   vdevarak   Initial implementation                
 * </pre>
 */

public class ExcChildAdoInfoCbxDAOImpl extends BaseDAOImpl implements ExcChildAdoInfoCbxDAO {

  @SuppressWarnings( { "unchecked" })
  public List<ExcChildAdoInfoCbx> findExcChildAdoInfoByIdEventByCdInfoCbx(int idChildRegEvent, String cdCbxCodeType) {

    Query query = getSession()
                              .createQuery(
                                           "  from ExcChildAdoInfoCbx ex"
                                                           + "    where ex.exchangeChild.event.idEvent = :idChildRegEvent "
                                                           + "    and ex.cdCbxCodeType = :cdCbxCodeType "
                                                           + " order by ex.dtPerformed desc");
    query.setInteger("idChildRegEvent", idChildRegEvent);
    query.setString("cdCbxCodeType", cdCbxCodeType);
    return (List<ExcChildAdoInfoCbx>) query.list();
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<ExcChildAdoInfoCbx> retrieveExcChildAdoInfoByIdEvent(int idChildRegEvent) {

    Query query = getSession()
                              .createQuery(
                                           " from ExcChildAdoInfoCbx ex " +
                                           " where ex.exchangeChild.event.idEvent = :idChildRegEvent ");
    query.setInteger("idChildRegEvent", idChildRegEvent);
    return (List<ExcChildAdoInfoCbx>) query.list();
  }

  public void deleteExcChildAdoinfoDetail(int idEvent, String cdAdoInfoCbx, Date dtPerformed){
    Query query = getSession().createQuery(
                                           " delete from ExcChildAdoInfoCbx cbx "
                                                           + " where cbx.exchangeChild.idEvent = :idEvent "
                                                           + " and cbx.cdAdoInfoCbx = :cdAdoInfoCbx "
                                                           + " and cbx.dtPerformed = :dtPerformed ");
    query.setInteger("idEvent", idEvent);
    query.setString("cdAdoInfoCbx", cdAdoInfoCbx);
    query.setDate("dtPerformed", dtPerformed);
    query.executeUpdate();
  }

  @SuppressWarnings( { "unchecked" })
  public void saveExcChildAdoInfoDetail(ExcChildAdoInfoCbx excChildAdoInfoCbx) {

    getSession().saveOrUpdate(excChildAdoInfoCbx);

  }

  public void deleteExcChildAdoInfoCbx(int idInfoChar){
    Query query = getSession().createQuery(
                                           " delete from ExcChildAdoInfoCbx cbx "
                                                           + " where cbx.idInfoChar = :idInfoChar ");
    query.setInteger("idInfoChar", idInfoChar);
    query.executeUpdate();
  }

}
