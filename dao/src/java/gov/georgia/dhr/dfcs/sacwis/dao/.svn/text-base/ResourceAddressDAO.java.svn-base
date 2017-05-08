/**
 * Created on Mar 25, 2006 at 3:24:20 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.ResourceAddress;

public interface ResourceAddressDAO {
  /**
   * Retrieves all of the Address data given a resource ID
   *
   * @param idResource
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<ResourceAddress> findResourceAddressByIdResource(int idResource);
  
  /**
   * Gets Resource address based on idRsrcAddress
   * @param idRsrcAddress
   * @return
   */
   Map findResourceAddressByIdRsrcAddr(int idRsrcAddress);

  /**
   * Retrieves nbrRsrcAddrVid given idResource
   *
   * @param idResource
   * @return
   */
  String findResourceAddressVID(int idResource);
  
  /**
   * 
   * @param idResource
   * @return
   */
  Integer findIdResourceAddressByAddressType(int idResource);
  
  /**
   * Finds IdRsrcAddress based on Address type
   * @param idResource
   * @return
   */
  Integer findIdResourceAddressByAddressTypeOnly(int idResource);

  /**
   * Insert ResourceAddress
   *
   * @param resourceAddress
   */
  void saveResourceAddress(ResourceAddress resourceAddress);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.ResourceAddress} object.
   *
   * @param resourceAddress
   */
  void deleteResourceAddress(ResourceAddress resourceAddress);
  
  /**
   * Gets Resource Address Id based on idResource
   * @param idResource
   * @return
   */
  Integer findIdResourceAddressByAddress(int idResource);
  
  /**
   * Gets Primary Resource address based on idResource
   * @param idRsrcAddress
   * @return
   */
  public ResourceAddress findRsrcAddressByAddressTypeOnly(int idResource);
  
  /**
   * Check to see if a resource address already exists.
   * @param strAddressLn1
   * @param strAddressLn2
   * @param strAddressCity
   * @param strAddressState
   * @param strAddressZip
   * @return
   */
  public ResourceAddress findRsrcAddressByAddressStrAddress2(String strAddressLn1, String strAddressLn2, String strAddressCity,
                                                  String strAddressState, String strAddressZip, String addressType);
  
  /**
   * Check to see if a resource address already exists.
   * @param strAddressLn1
   * @param strAddressCity
   * @param strAddressState
   * @param strAddressZip
   * @return
   */
  public ResourceAddress findRsrcAddressByAddress(String strAddressLn1, String strAddressCity,
                                                  String strAddressState, String strAddressZip, String addressType);


}
