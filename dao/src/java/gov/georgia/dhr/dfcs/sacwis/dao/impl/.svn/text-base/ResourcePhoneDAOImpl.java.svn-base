package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.dao.ResourcePhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ResourcePhone;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/*** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 *   02/08/2012  schoi             STGAP00017831: MR-102 Added method findLatestNbrResourcePhoneByIdResourceByCdPhoneType
 */

public class ResourcePhoneDAOImpl extends BaseDAOImpl implements ResourcePhoneDAO {
  @SuppressWarnings({"unchecked"})
  public List<ResourcePhone> findResourcePhoneByIdResource(int idResource) {
    Query query = getSession().createQuery(" from ResourcePhone " +
                                           "where capsResource.idResource = :idResource");
    query.setInteger("idResource", idResource);
    return (List<ResourcePhone>) query.list();
  }

  public void saveResourcePhone(ResourcePhone resourcePhone) {
    getSession().saveOrUpdate(resourcePhone);
  }

  public void deleteResourcePhone(ResourcePhone resourcePhone) {
    getSession().delete(resourcePhone);
  }

  @SuppressWarnings({"unchecked"})
  public List<Object[]> findFaxInformation(int idStage) {
    SQLQuery query = getSession().createSQLQuery("SELECT S.ID_STAGE as idStage, " +
                                                 "       CR.ID_RESOURCE as idResource, " +
                                                 "       CR.NM_RESOURCE as nmResource, " +
                                                 "       CC.ID_CASE as idCase, " +
                                                 "       CC.NM_CASE as nmCase, " +
                                                 "       RP.CD_RSRC_PHONE_TYPE as cdRsrcPhoneType, " +
                                                 "       RP.NBR_RSRC_PHONE as nbrRsrcPhone, " +
                                                 "       RP.NBR_RSRC_PHONE_EXT as nbrRsrcPhoneExt " +
                                                 "  FROM STAGE S, " +
                                                 "       INCOMING_DETAIL ID, " +
                                                 "       CAPS_RESOURCE CR, " +
                                                 "       CAPS_CASE CC, " +
                                                 "       RESOURCE_PHONE RP " +
                                                 " WHERE S.ID_STAGE = :idStage " +
                                                 "   AND S.ID_CASE = CC.ID_CASE " +
                                                 "   AND S.ID_STAGE = ID.ID_STAGE " +
                                                 "   AND ID.ID_RESOURCE = CR.ID_RESOURCE (+) " +
                                                 "   AND CR.ID_RESOURCE = RP.ID_RESOURCE (+) " +
                                                 "   AND RP.CD_RSRC_PHONE_TYPE (+)  = '03'");
    query.setInteger("idStage", idStage);
    query.addScalar("idStage", Hibernate.INTEGER);
    query.addScalar("idResource", Hibernate.INTEGER);
    query.addScalar("nmResource", Hibernate.STRING);
    query.addScalar("idCase", Hibernate.INTEGER);
    query.addScalar("nmCase", Hibernate.STRING);
    query.addScalar("cdRsrcPhoneType", Hibernate.STRING);
    query.addScalar("nbrRsrcPhone", Hibernate.STRING);
    query.addScalar("nbrRsrcPhoneExt", Hibernate.STRING);
    return (List<Object[]>) query.list();
  }
  
  /**
   * Gets Resource Phone information
   * 
   * select rp.nbrRsrcPhone, rp.nbrRsrcPhoneExt from ResourcePhone rp  
     where rp.capsResource.idResource = :idResource and  
     rp.cdRsrcPhoneType =  '01' 
   * 
   * 
   * 
   */
  
  public Map findResourcePhoneInfo(int idResource) {
  Query query = getSession().createQuery( "select new map( rp.nbrRsrcPhone as  nbrRsrcPhone, " +  
                                               " rp.nbrRsrcPhoneExt as nbrRsrcPhoneExt) " +
                                               "  from ResourcePhone rp " + 
                                               " where rp.capsResource.idResource = :idResource and " +
                                               " rp.cdRsrcPhoneType =  '01' ");
  query.setInteger("idResource", idResource);
  return (Map) firstResult(query);
 } 
 
  
  
  /**
   * Gets Resource Fax information
   */
  public Map findResourceFaxInfo(int idResource) {
    Query query = getSession().createQuery( "select new map( rpf.nbrRsrcPhone as  nbrRsrcPhone, " +  
                                                 " rpf.nbrRsrcPhoneExt as nbrRsrcPhoneExt) " +
                                                 "  from ResourcePhone rpf " +
                                                 " where rpf.capsResource.idResource = :idResource and (" +
                                                 " rpf.cdRsrcPhoneType =  '03' or " +
                                                 " rpf.cdRsrcPhoneType =  '08' )");
    query.setInteger("idResource", idResource);
    return (Map) firstResult(query);
   }

  // STGAP00017831: MR-102
  /**
   * Gets the most recently entered Resource phone information by idResource and cdRsrcPhoneType
   */
  public String findLatestNbrResourcePhoneByIdResourceByCdPhoneType(int idResource, String cdRsrcPhoneType){
    Query query = getSession().createQuery(" select rp.nbrRsrcPhone from ResourcePhone rp "
                                           + " where rp.capsResource.idResource = :idResource "
                                           + " and rp.cdRsrcPhoneType = :cdRsrcPhoneType "
                                           + " and rp.dtLastUpdate = (select max(rphone.dtLastUpdate) "
                                           + " from ResourcePhone rphone "
                                           + " where rphone.capsResource.idResource = :idResource "
                                           + " and rphone.cdRsrcPhoneType = :cdRsrcPhoneType )");
    query.setInteger("idResource", idResource);
    query.setString("cdRsrcPhoneType", cdRsrcPhoneType);
    return (String) query.uniqueResult();
  } 
}
