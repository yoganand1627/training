package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import gov.georgia.dhr.dfcs.sacwis.dao.VendorOutboundDAO;
import gov.georgia.dhr.dfcs.sacwis.db.VendorOutbound;
import java.util.Map;
import org.hibernate.Query;

public class VendorOutboundDAOImpl extends BaseDAOImpl implements VendorOutboundDAO{ 

  /**
   * Gets Resource Name information
   */
  public Map findResourceNameInfo(int idResource) {
    Query query = getSession().createQuery( "select new map( cr.nmLegal as  nmLegal, " +
                                                 " cr.idResource as idResource, " +
                                                 " cr.nmRsrcContact as nmRsrcContact) " +
                                                 "  from CapsResource cr " +
                                                 " where cr.idResource = :idResource"); 
    query.setInteger("idResource", idResource);
    return (Map) firstResult(query);
   }
 
  /**
   * Saves New Vendor Information into VendorOutbound Table
   */
  public int saveNewVendorInfo(VendorOutbound vendorOutbound){
    
    getSession().saveOrUpdate(vendorOutbound);
    return vendorOutbound.getIdVendorOutbound();
    }
  /**
   *  Finds vendor id based on idResourceAddress
   */
   public String findResourceAddressVID(int idRsrcAddress) {
    Query query = getSession().createQuery(
            "select ra.nbrRsrcAddrVid from ResourceAddress ra where ra.idRsrcAddress=:idRsrcAddress ");
    query.setInteger("idRsrcAddress", idRsrcAddress);
    return (String) firstResult(query);
  }
  
   /**
    * If caseId is tied to resource in Caps.Resource table then it is FAD resource
    *  This method finds out whether given resource is FAD resource or Non FAD resource
    */
  public Integer isFadResource(int idResource){
    Query query = getSession().createQuery(" select cr.capsCase.idCase from CapsResource cr where cr.idResource = :idResource ");
    query.setInteger("idResource", idResource);
    return (Integer) firstResult(query);
    
  }
  
  public Integer findRsrcAddrId(int idVendorOutbound){
    Query query = getSession().createQuery(" select vo.idResourceAddress from VendorOutbound vo where vo.idVendorOutbound = :idVendorOutbound ");
    query.setInteger("idVendorOutbound", idVendorOutbound);
    return (Integer) firstResult(query);
    
  }
   
  
  public Integer isThisResourceSentAsNew(int idResource, int idResourceAddress , String indNewResource){
    Query query = getSession().createQuery(" select vo.idResource from VendorOutbound vo " +
                                           " where vo.idResource = :idResource " +
                                           " and vo.idResourceAddress = :idResourceAddress " +
                                           " and vo.indNewResource = :indNewResource ");
    query.setInteger("idResource", idResource);
    query.setInteger("idResourceAddress", idResourceAddress);
    query.setString("indNewResource", indNewResource);    
    return (Integer) firstResult(query);
    
  }
  
  public Integer isRsrcSntToSmile(int idResource){
    
    Query query = getSession().createQuery(" select vo.idResourceAddress from VendorOutbound vo where vo.idResource = :idResource ");
    query.setInteger("idResource", idResource);
    return (Integer) firstResult(query); 
    
    
  }
  
public Integer isCurrentRsrcSntToSmile(int idResource){
    
    Query query = getSession().createQuery(
                                           " select vo.idResourceAddress from VendorOutbound vo " +
                                           " where vo.idResource = :idResource and vo.idVendorOutbound " +
                                           " not in (select vi.idVendorOutbound from VendorInbound vi where vi.idResource = vo.idResource))");
    query.setInteger("idResource", idResource);
    return (Integer) firstResult(query); 
    
    
  }
  

}
