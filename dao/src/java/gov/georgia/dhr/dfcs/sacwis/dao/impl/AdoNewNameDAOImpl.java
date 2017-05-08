package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoNewNameDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoNewName;

import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 * This is the DAO that contains the SQL to save and retrieve Exchange Child records to and from the Database. <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *  10/28/08   vdevarak  STGAP00010749: Creation of the DAO      
 *  07/28/09   bhgehlot  STGAP00014341: MR-51 Reopen Stage Changes        
 * </pre>
 */
public class AdoNewNameDAOImpl extends BaseDAOImpl implements AdoNewNameDAO{
  
  @SuppressWarnings( { "unchecked" })
  public Map findNameByStage(int idStage){
    Query query = getSession().createQuery(
                                           " select new map( a.nmPersonLast as nmPersonLast, " +
                                           " a.nmPersonFirst as nmPersonFirst, " +
                                           " a.nmPersonMiddle as nmPersonMiddle) " +
                                           " from AdoNewName a " +
                                           " where a.idAdoStage = :idStage" );
    query.setInteger("idStage", idStage);
    return (Map)query.uniqueResult();
  }
  
  public int insertAdoNewName(int idStage, String nmFirst, String nmLast, String nmMiddle){
    SQLQuery query = getSession().createSQLQuery("INSERT INTO ADO_NEW_NAME " +
                                                 "       (ID_ADO_STAGE, " +
                                                 "        NM_PERSON_FIRST, " +
                                                 "        NM_PERSON_LAST, " +
                                                 "        NM_PERSON_MIDDLE) " +
                                                 " VALUES (:idStage, " +
                                                 "        :nmFirst, " +
                                                 "        :nmLast, " +
                                                 "        :nmMiddle)");

    query.setInteger("idStage", idStage);
    query.setString("nmFirst", nmFirst);
    query.setString("nmLast", nmLast);
    query.setString("nmMiddle", nmMiddle);

    return query.executeUpdate();
  }
 
  public int updateAdoNewName(int idStage, String nmFirst, String nmLast, String nmMiddle){
    SQLQuery query = getSession().createSQLQuery("UPDATE ADO_NEW_NAME " +
                                                 " SET NM_PERSON_FIRST = :nmFirst, " +
                                                 "     NM_PERSON_LAST = :nmLast, " +
                                                 "     NM_PERSON_MIDDLE = :nmMiddle " +
                                                 " WHERE ID_ADO_STAGE = :idStage ");

    query.setInteger("idStage", idStage);
    query.setString("nmFirst", nmFirst);
    query.setString("nmLast", nmLast);
    query.setString("nmMiddle", nmMiddle);

    return query.executeUpdate();
  }
  

  public AdoNewName findAdoNewNameByIdStage(int idStage) {

    Query query = getSession().createQuery("  from AdoNewName a " +
                                           "  where a.idAdoStage = :idStage ");

    query.setInteger("idStage", idStage);

    return (AdoNewName) firstResult(query);
  }
  
  public void saveOrUpdateAdoNewName(AdoNewName adoNewName) {
    getSession().saveOrUpdate(adoNewName);
  } 
  
  //STGAP00014341: Delete AdoNewName
  public int deleteAdoNewNameByIdStage(int idStage) {
    Query query = getSession().createQuery(" delete from AdoNewName a " +
                                                 "  where a.idAdoStage = :idStage ");
    query.setInteger("idStage", idStage);
    return query.executeUpdate();
  }
  
}