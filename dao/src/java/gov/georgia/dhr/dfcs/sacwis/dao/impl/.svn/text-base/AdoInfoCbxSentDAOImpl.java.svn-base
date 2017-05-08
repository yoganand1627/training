package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.AdoInfoCbxSentDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfoCbx;
import gov.georgia.dhr.dfcs.sacwis.db.AdoInfoCbxSent;

/**
 * The AdoInfoCbxSentDAOImpl class is used to perform database operations on the AdoInfoCbxSent table
 * 
 * 
 * @author Ronnie Phelps, October 7, 2008
 * 
 * <PRE>
 * 
 * Date        Updated by                Description
 * ---------   ------------              -------------------------------------
 * 
 * </PRE>
 */
public class AdoInfoCbxSentDAOImpl extends BaseDAOImpl implements AdoInfoCbxSentDAO {

  /**
   * Get AdoInfoCbxSent record by primary key
   * 
   * @param idAdoInfoCbxSent
   * 
   * return AdoInfoCbxSent
   */
  @SuppressWarnings( { "unchecked" })
  public AdoInfoCbxSent findAdoInfoCbxSent(int idAdoInfoCbxSent) {

    Query query = getSession().createQuery(" from  AdoInfoCbxSent cbx "
                                           + " where cbx.idAdoInfoCbxSent = :idAdoInfoCbxSent ");

    query.setInteger("idAdoInfoCbxSent", idAdoInfoCbxSent);
    return (AdoInfoCbxSent) firstResult(query);
  }

  /**
   * Get a list of AdoInfoCbxSent records for the given idInfoChar and IdEvent
   * 
   * @param idInfoChar
   * @param idEvent
   * 
   * return List<AdoInfoCbxSent>
   */
  @SuppressWarnings( { "unchecked" })
  public List<AdoInfoCbxSent> findAdoInfoCbxSentByIdInfoCharIdEvent(int idInfoChar, int idEvent) {

    Query query = getSession().createQuery(
                                           " from  AdoInfoCbxSent cbx "
                                                           + " where cbx.adoInfoCbx.adoInfo.idEvent = :idEvent "
                                                           + " and cbx.adoInfoCbx.idInfoChar = :idInfoChar"
                                                           + " order by cbx.dtAdoInfoCbxSent desc ");

    query.setInteger("idEvent", idEvent);
    query.setInteger("idInfoChar", idInfoChar);
    return (List<AdoInfoCbxSent>) query.list();

  }

  /**
   * find All dates for the given idInfoChar and event
   * 
   * @param idInfoChar
   * @param idEvent
   * 
   * @return List<Date>
   */
  @SuppressWarnings( { "unchecked" })
  public List<Date> findAdoInfoCbxSentDateByIdInfoCharIdEvent(int idInfoChar, int idEvent) {
    Query query = getSession().createQuery(
                                           "select cbx.dtAdoInfoCbxSent from  AdoInfoCbxSent cbx "
                                                           + " where cbx.adoInfoCbx.adoInfo.idEvent = :idEvent "
                                                           + " and cbx.adoInfoCbx.idInfoChar = :idInfoChar"
                                                           + " order by cbx.dtAdoInfoCbxSent desc");

    query.setInteger("idEvent", idEvent);
    query.setInteger("idInfoChar", idInfoChar);
    return (List<Date>) query.list();
  }

  /**
   * Save the AdoInfoCbxSent record to the database
   * 
   * @param AdoInfoCbxSent;
   */
  public void saveAdoInfoCheckBoxSent(AdoInfoCbxSent adoinfocbxSent) {
    getSession().saveOrUpdate(adoinfocbxSent);
  }

  /**
   * delete all all AdoInfoCbxSent records in the given collection
   * 
   * @param idInfoCharTypes
   */
  public void deleteAllAdoInfoCbxSentForcharTypes(Collection idInfoCharTypes) {
    Query query = getSession()
                              .createQuery(
                                           " delete from AdoInfoCbxSent cbx "
                                                           + "       where cbx.adoInfoCbx.idInfoChar in (:idInfoCharTypes )");

    query.setParameterList("idInfoCharTypes", idInfoCharTypes);
    query.executeUpdate();
  }

  /**
   * delete AdoInfoCbxSent record by primary key
   * 
   * @param idAdoInfoCbxSent
   */     
  public void deleteAdoInfoCbxSent(int idAdoInfoCbxSent){
    Query query = getSession().createQuery(" delete from AdoInfoCbxSent cbx "
                                           + " where cbx.idAdoInfoCbxSent = :idAdoInfoCbxSent ");

    query.setInteger("idAdoInfoCbxSent", idAdoInfoCbxSent);
    query.executeUpdate();
  }
  
}
