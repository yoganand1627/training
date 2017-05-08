package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------------
 *   11/08/2009  Patrick Coogan    Created new service to wrap the standard contact add service in order to 
 *                                 perform overrides of values when adding a new portal contact.  This was done
 *                                 in the service layer to have access to DAO to populate agency name and
 *                                 vendor staff job title.       
 *
 */

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUser;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.service.common.AddPortalContactDetail;
import gov.georgia.dhr.dfcs.sacwis.service.common.ContactDetailRetrieve;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSYS08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSYS08SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContactCbxDisplay;

public class AddPortalContactDetailImpl extends BaseServiceImpl implements AddPortalContactDetail {

  private CapsResourceDAO capsResourceDAO = null;
  private PortalUserDAO portalUserDAO = null;
  private ContactDetailRetrieve contactDetailRetrieve = null;
  
  
  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }
  
  public void setPortalUserDAO(PortalUserDAO portalUserDAO) {
	this.portalUserDAO = portalUserDAO;
  }
  
  public void setContactDetailRetrieve(ContactDetailRetrieve contactDetailRetrieve) {
    this.contactDetailRetrieve = contactDetailRetrieve;
}
  
  
public CSYS08SO addPortalContactDetail(CSYS08SI csys08si, Integer idPortalUser, Integer idResource) throws ServiceException {
  
  //Call standard service
  CSYS08SO csys08so = contactDetailRetrieve.contactDetailRetrieve(csys08si);
  
  //Override for portal
  csys08so.setUlIdPortalUser(idPortalUser);
  csys08so.setSzCdContactedBy(CodesTables.CCCONTBY_CCA);
  csys08so.setSzCdContactNarr(CodesTables.CCONNARR_SPW);
  csys08so.setSzNmPersonFull("");
  csys08so.setSzCdJobTitle("");
  
  //Populate agency name based off of the agency for the current placement passed in request
  CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResourceOnly(idResource);
  
  if (capsResource !=null) {
    csys08so.setSzNmAgencyName(capsResource.getNmResource()!= null ? (capsResource.getNmResource().length() > 20 ? capsResource.getNmResource().substring(0,20) :capsResource.getNmResource()) :"");  
  }
  
  
  //Load portal user information including title
  PortalUser portalUser = portalUserDAO.findPortalUserbyIdUser(idPortalUser);
 
  if (portalUser!= null){
    csys08so.setSzNmContactedBy(portalUser.getNmUserFull()!=null ? portalUser.getNmUserFull() :"");
    csys08so.setSzNmPortalUserFull(portalUser.getNmUserFull()!=null ? portalUser.getNmUserFull() :"");
    csys08so.setSzTitlePortalUser(portalUser.getTxtTitle()!=null ? portalUser.getTxtTitle() :"");  
  }
  
  //Preselect "Case MAnager-Child Visit"
  
  ContactCbxDisplay_Array contactCbxDisplay_Array = new ContactCbxDisplay_Array();
  ContactCbxDisplay contactCbxDisplay = new ContactCbxDisplay();
  
  contactCbxDisplay.setSzCdCbxCodeType(CodesTables.CCNTPURP);
  contactCbxDisplay.setSzCdContactCbx(CodesTables.CCNTPURP_CMC);
  
  contactCbxDisplay_Array.addContactCbxDisplay(contactCbxDisplay);
  contactCbxDisplay_Array.setUlRowQty(1);
  csys08so.setContactCbxDisplay_Array(contactCbxDisplay_Array);
  
  return csys08so;
  
}

}
