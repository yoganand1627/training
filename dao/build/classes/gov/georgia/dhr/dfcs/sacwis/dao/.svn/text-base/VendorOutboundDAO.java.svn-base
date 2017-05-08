/**
 * This class declares the interface for the VendorOutboundDAO and holds the simple
 * methods for accessing the VENDOR_OUTBOUND table in the SACWISIFC schema.
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 01/19/09  Patrick Coogan    STGAP00011971: Added method isCurrentRsrcSntToSmile
 *                             as a part of MR-027 to find when a resource has an outbound
 *                             vendor row that has not yet been accepted or denied by SMILE
 * </pre>
 */


package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Map;
import gov.georgia.dhr.dfcs.sacwis.db.VendorOutbound;

public interface VendorOutboundDAO {
  /**
   * Gets Resource Name information
   * @param idResource
   * @return
   */
 Map findResourceNameInfo(int idResource);
 /**
  * Saves New Vendor Information into VendorOutbound Table
  * @param vendorOutbound
  * @return
  */
 int saveNewVendorInfo(VendorOutbound vendorOutbound);
 /**
  * Finds vendor id based on idResourceAddress
  * @param idRsrcAddress
  * @return
  */
 public String findResourceAddressVID(int idRsrcAddress);
 /**
  * If caseId is tied to resource in Caps.Resource table then it is FAD resource
   * This method finds out whether given resource is FAD resource or Non FAD resource
  * @param idResource
  * @return
  */
 public Integer isFadResource(int idResource); 
 
 public Integer isThisResourceSentAsNew(int idResource, int idResourceAddress , String indNewResource);
 
 public Integer findRsrcAddrId(int idVendorOutbound);
 
 public Integer isRsrcSntToSmile(int idResource);
 
 
 /**
  * This will select the first vendor outbound row that has not yet been responded to
  * based on audit row for the return in vendor inbound
  * 
  * @param idResource
  * @return idResourceAddress for a resource where there are pending interface transactions
  */
 
 public Integer isCurrentRsrcSntToSmile(int idResource);

}
