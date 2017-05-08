package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------------
 *   11/17/09    Patrick Coogan    Created new service to resolve SMS 39520 and verify that contacts
 *                                 are not added by portal users at a date prior to their being assigned
 *                                 to a resource.
 *   5/25/10     Courtney Wells    45545: Setting the portalUserVendor link by using the id from the agency if there is none then check to see if 
 *                                 there is a link using the id from the Facility.  there should not be a situation where there is no link 
 *                                 but if there is then the result is being set to true so the application will not be stopped with a 
 *                                 application error message.
 *
 */

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserVendorLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUserVendorLink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.common.ValidateContactDate;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ValidateContactDateSI;

import java.util.Date;


public class ValidateContactDateImpl extends BaseServiceImpl implements ValidateContactDate {

  private PortalUserVendorLinkDAO portalUserVendorLinkDAO = null;
  
  public void setPortalUserVendorLinkDAO(PortalUserVendorLinkDAO portalUserVendorLinkDAO) {
	this.portalUserVendorLinkDAO = portalUserVendorLinkDAO;
  }
  

  public boolean validateContactDate(ValidateContactDateSI validateContactDateSI) throws ServiceException {

    boolean result = true;

    int idUser = validateContactDateSI.getUlIdUser();
    Date dtContact = validateContactDateSI.getDtContactDate();
    int idRsrcAgency = validateContactDateSI.getUlIdAgcyResource();
    int idRsrcFacil = validateContactDateSI.getUlIdFacilResource();
    // 45545: Setting the portalUserVendor link by using the id from the agency if there is none then check to see if 
    // there is a link using the id from the Facility.  there should not be a situation where there is no link
    // but if there is then the result is being set to true so the application will not be stopped with a 
    // application error message.
    PortalUserVendorLink portalUserVendorLink = portalUserVendorLinkDAO
                                                                       .findPortalUserVendorLinkByIdUserAndIdResource(
                                                                                                                      idUser,
                                                                                                                      idRsrcAgency) != null ? portalUserVendorLinkDAO
                                                                                                                                                                     .findPortalUserVendorLinkByIdUserAndIdResource(
                                                                                                                                                                                                                    idUser,
                                                                                                                                                                                                                    idRsrcAgency)
                                                                                                                                           : portalUserVendorLinkDAO
                                                                                                                                                                    .findPortalUserVendorLinkByIdUserAndIdResource(
                                                                                                                                                                                                                   idUser,
                                                                                                                                                                                                                   idRsrcFacil);  
    if(portalUserVendorLink != null){
    
    Date dtStart = portalUserVendorLink.getDtStart();

    if (dtStart != null) {
      result = dtStart.before(dtContact);

      if (!result) {
        result = dtStart.equals(dtContact);
      }
    }
    }else{
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    return result;
  }

}
