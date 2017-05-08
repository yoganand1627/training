package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.dao.ResourceAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceAddress;
import org.hibernate.Query;

public class ResourceAddressDAOImpl extends BaseDAOImpl implements ResourceAddressDAO {
  @SuppressWarnings({"unchecked"})
  
  
  public List<ResourceAddress> findResourceAddressByIdResource(int idResource) {
    Query query = getSession().createQuery("from ResourceAddress r" +
                                           "    where r.capsResource.idResource = :idResource");
    query.setInteger("idResource", idResource);
    return (List<ResourceAddress>) query.list();
  }
  
/**
 * Gets Resource Address information based on idRsrcAddress
 */
  public Map findResourceAddressByIdRsrcAddr(int idRsrcAddress) {
    Query query = getSession().createQuery( "select new map( r.addrRsrcAddrStLn1 as  addrRsrcAddrStLn1, "  +
                                                 " r.addrRsrcAddrStLn2 as addrRsrcAddrStLn2, " + 
                                                 " r.addrRsrcAddrCity as addrRsrcAddrCity, " + 
                                                 " r.cdRsrcAddrState as cdRsrcAddrState, " + 
                                                 " r.addrRsrcAddrZip as addrRsrcAddrZip) " +
                                                 "  from ResourceAddress r " + 
                                                 " where r.idRsrcAddress = :idRsrcAddress");
    query.setInteger("idRsrcAddress", idRsrcAddress);
    return (Map) firstResult(query);
   }
  
  
/**
 * Gets VendorID associated with the resource
 */
  public String findResourceAddressVID(int idResource) {
    Query query = getSession().createQuery( "select nbrRsrcAddrVid from ResourceAddress where capsResource.idResource=:idResource " +
                                            " and cdRsrcAddrType='01' and nbrRsrcAddrVid IS NOT NULL");
    query.setInteger("idResource", idResource);
    return (String) firstResult(query);
  }

  public Integer findIdResourceAddressByAddressTypeOnly(int idResource){
    
    Query query = getSession().createQuery( "select ra.idRsrcAddress from ResourceAddress ra where capsResource.idResource=:idResource " +
    " and cdRsrcAddrType='01'");
    query.setInteger("idResource", idResource);
    return (Integer) firstResult(query);   
  }
  
public Integer findIdResourceAddressByAddressType(int idResource){
    
    Query query = getSession().createQuery( "select ra.idRsrcAddress from ResourceAddress ra where capsResource.idResource=:idResource " +
    " and ra.nbrRsrcAddrVid IS NULL and cdRsrcAddrType='01'");
    query.setInteger("idResource", idResource);
    return (Integer) firstResult(query);   
  }

public Integer findIdResourceAddressByAddress(int idResource){
  
  Query query = getSession().createQuery( "select ra.idRsrcAddress from ResourceAddress ra where capsResource.idResource=:idResource  ");
  query.setInteger("idResource", idResource);
  return (Integer) firstResult(query);   
}
  
  

  public void saveResourceAddress(ResourceAddress resourceAddress) {
    getSession().saveOrUpdate(resourceAddress);
  }

  public void deleteResourceAddress(ResourceAddress resourceAddress) {
    getSession().delete(resourceAddress);
  }
  
  public ResourceAddress findRsrcAddressByAddressTypeOnly(int idResource){
    
    Query query = getSession().createQuery( " from ResourceAddress ra where capsResource.idResource=:idResource " +
    " and cdRsrcAddrType='01'");
    query.setInteger("idResource", idResource);
    return (ResourceAddress) firstResult(query);   
  }
  
  public ResourceAddress findRsrcAddressByAddressStrAddress2(String strAddressLn1, String strAddressLn2, String strAddressCity,
                                          String strAddressState, String strAddressZip, String addressType) {
      
    Query query = getSession().createQuery(" from ResourceAddress ra where ra.addrRsrcAddrStLn1 = :strAddressLn1 " +
                                           " and ra.addrRsrcAddrStLn2 = :strAddressLn2 " +
    		                           " and ra.addrRsrcAddrCity = :strAddressCity " +
    		                           " and ra.cdRsrcAddrState = :strAddressState and ra.addrRsrcAddrZip = :strAddressZip " +
    		                           " and cdRsrcAddrType='01'");
    query.setString("strAddressLn1", strAddressLn1);
    query.setString("strAddressLn2", strAddressLn2);
    query.setString("strAddressCity", strAddressCity);
    query.setString("strAddressState", strAddressState);
    query.setString("strAddressZip", strAddressZip);
    
    return (ResourceAddress) firstResult(query);
  }
  
  public ResourceAddress findRsrcAddressByAddress(String strAddressLn1, String strAddressCity,
                                                  String strAddressState, String strAddressZip, String addressType) {
              
            Query query = getSession().createQuery(" from ResourceAddress ra where ra.addrRsrcAddrStLn1 = :strAddressLn1 " +
                                                   " and ra.addrRsrcAddrCity = :strAddressCity " +
                                                   " and ra.cdRsrcAddrState = :strAddressState and ra.addrRsrcAddrZip = :strAddressZip " +
                                                   " and cdRsrcAddrType='01'");
            query.setString("strAddressLn1", strAddressLn1);
            query.setString("strAddressCity", strAddressCity);
            query.setString("strAddressState", strAddressState);
            query.setString("strAddressZip", strAddressZip);
            
            return (ResourceAddress) firstResult(query);
          }
}
