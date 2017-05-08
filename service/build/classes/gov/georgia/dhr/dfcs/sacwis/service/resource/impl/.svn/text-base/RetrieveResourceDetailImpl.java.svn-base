package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Corsopft;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Corsopst;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FacilityDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourcePhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RsrcLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Facility;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceAddress;
import gov.georgia.dhr.dfcs.sacwis.db.ResourcePhone;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.RetrieveResourceDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES03SOG02_ARRAY;

import java.util.Iterator;
import java.util.List;

/**
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  05/24/10  bgehlot   SMS#51977 MR-066 Changes
 *                         
 *                      
 * </pre>
 */

public class RetrieveResourceDetailImpl extends BaseServiceImpl implements RetrieveResourceDetail {

  private CapsResourceDAO capsResourceDAO = null;

  private ContractCountyDAO contractCountyDAO = null;

  private ContractDAO contractDAO = null;

  private ResourceAddressDAO resourceAddressDAO = null;

  private ResourcePhoneDAO resourcePhoneDAO = null;

  private RsrcLinkDAO rsrcLinkDAO = null;

  private FacilityDAO facilityDAO = null;
  
  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setContractCountyDAO(ContractCountyDAO contractCountyDAO) {
    this.contractCountyDAO = contractCountyDAO;
  }

  public void setContractDAO(ContractDAO contractDAO) {
    this.contractDAO = contractDAO;
  }

  public void setResourceAddressDAO(ResourceAddressDAO resourceAddressDAO) {
    this.resourceAddressDAO = resourceAddressDAO;
  }

  public void setResourcePhoneDAO(ResourcePhoneDAO resourcePhoneDAO) {
    this.resourcePhoneDAO = resourcePhoneDAO;
  }

  public void setRsrcLinkDAO(RsrcLinkDAO rsrcLinkDAO) {
    this.rsrcLinkDAO = rsrcLinkDAO;
  }
  
  public void setFacilityDAO(FacilityDAO facilityDAO) {
    this.facilityDAO = facilityDAO;
  }

  public CRES03SO retrieveResourceDetail(CRES03SI cres03si) throws ServiceException {
    int idResource = cres03si.getUlIdResource();
    // Call CAPS Resource to retrieve Resource data
    // cres04d
    CRES03SO cres03so = retrieveResourceInformation(idResource);

    // Call Resource Phone to retrieve the phone data
    // cres14d
    cres03so.setROWCRES03SOG01_ARRAY(retrievePhoneInformation(idResource));

    // Check to see if a resource ID is found in either the parent or child columns of the resource link table. These
    // retrieves determine the contracted status of a resource, reflected on the window by the checkboxes prime and sub.

    // Call Resource Link in order to determine sub status.
    // cres15d
    if (null != rsrcLinkDAO.findIdRsrcLinkByIdRsrcLinkChildAndCdRsrcPrimeSubLink(idResource)) {
      cres03so.setCScrIndRsrcSub(ArchitectureConstants.Y);
    } else {
      cres03so.setCScrIndRsrcSub(ArchitectureConstants.N);

    }

    // Call Resource Link in order to determine prime status.
    // cres38d
    if (null != rsrcLinkDAO.findIdRsrcLinkByIdRsrcLinkParentCdRsrcPrimeSubLink(idResource)) {
      cres03so.setCScrIndRsrcPrime(ArchitectureConstants.Y);
    } else {
      cres03so.setCScrIndRsrcPrime(ArchitectureConstants.N);
    }

    // Call Contract County table to determine if the resource is contracted.
    // cres39d
    if (0l != contractCountyDAO.countContractCountyByIdResource(idResource)) {
      cres03so.setCScrIndRsrcContracted(ArchitectureConstants.Y);
    } else {
      cres03so.setCScrIndRsrcContracted(ArchitectureConstants.N);
    }

    // Call Resource Address table to retrieve addresses if they exist
    ROWCRES03SOG00_ARRAY rowcres03sog00_array = getResourceAddressInformation(idResource, cres03so);
    cres03so.setROWCRES03SOG00_ARRAY(rowcres03sog00_array);
    
    ROWCRES03SOG02_ARRAY owcres03sog02_array = retrieveORSFacilities(idResource);
    cres03so.setROWCRES03SOG02_ARRAY(owcres03sog02_array);
    
    return cres03so;
  }

  private ROWCRES03SOG00_ARRAY getResourceAddressInformation(int idResource, CRES03SO cres03so) {
    // cres13d
    List<ResourceAddress> resourceAddressList = resourceAddressDAO.findResourceAddressByIdResource(idResource);
    if ((resourceAddressList == null || resourceAddressList.isEmpty())
        && !TYPE_HOTLINE.equals(cres03so.getSzCdRsrcType())) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCRES03SOG00_ARRAY rowcres03sog00_array = new ROWCRES03SOG00_ARRAY();
    if (resourceAddressList != null) {
      // For each Id returned from the Resource Address table, call a DAO to find out whether that address ID is linked
      // to any contracts (status of contract irrelevant).
      for (Iterator<ResourceAddress> resourceAddressIt = resourceAddressList.iterator(); resourceAddressIt.hasNext();) {
        ResourceAddress resourceAddress = resourceAddressIt.next();
        ROWCRES03SOG00 rowcres03sog00 = new ROWCRES03SOG00();
        int idRsrcAddress = resourceAddress.getIdRsrcAddress() != null ? resourceAddress.getIdRsrcAddress() : 0;
        rowcres03sog00.setUlIdRsrcAddress(idRsrcAddress);
        rowcres03sog00.setUlIdResource(idResource);
        rowcres03sog00.setSzNbrRsrcAddrVid(resourceAddress.getNbrRsrcAddrVid());
        rowcres03sog00.setSzCdRsrcAddrType(resourceAddress.getCdRsrcAddrType());
        rowcres03sog00.setSzCdRsrcAddrSchDist(resourceAddress.getCdRsrcAddrSchDist());
        rowcres03sog00.setSzAddrRsrcAddrStLn1(resourceAddress.getAddrRsrcAddrStLn1());
        rowcres03sog00.setSzAddrRsrcAddrStLn2(resourceAddress.getAddrRsrcAddrStLn2());
        rowcres03sog00.setSzAddrRsrcAddrAttn(resourceAddress.getAddrRsrcAddrAttn());
        rowcres03sog00.setSzAddrRsrcAddrCity(resourceAddress.getAddrRsrcAddrCity());
        rowcres03sog00.setSzCdFacilityState(resourceAddress.getCdRsrcAddrState());
        rowcres03sog00.setSzAddrRsrcAddrZip(resourceAddress.getAddrRsrcAddrZip());
        rowcres03sog00.setSzCdFacilityCounty(resourceAddress.getCdRsrcAddrCounty());
        rowcres03sog00.setSzTxtRsrcAddrComments(resourceAddress.getTxtRsrcAddrComments());
        rowcres03sog00.setTsLastUpdate(resourceAddress.getDtLastUpdate());
        rowcres03sog00_array.addROWCRES03SOG00(rowcres03sog00);
        // cres44d
        if (contractDAO.countContractByIdRsrcAddress(idRsrcAddress) > 0) {
          // find the primary one, which has the school district code used in the Sch Dist retrieval. If the primary
          // address record has no sch dist code, then the sch dist DAM is not called.
          rowcres03sog00.setCScrIndRsrcContracted(ArchitectureConstants.Y);
        } else {
          rowcres03sog00.setCScrIndRsrcContracted(ArchitectureConstants.N);
        }
      }
    }
    return rowcres03sog00_array;
  }

  private CRES03SO retrieveResourceInformation(int idResource) {
    // cres04d
    CRES03SO cres03so = new CRES03SO();
    CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResourceOnly(idResource);
    if (capsResource == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    cres03so.setUlIdResource(idResource);
    cres03so.setSzNmResource(capsResource.getNmResource());
    cres03so.setSzCdRsrcCategory(capsResource.getCdRsrcCategory());
    cres03so.setSzNmAgencyName(capsResource.getNdfcsCertEntity());
    cres03so.setSzTxtRsrcComments(capsResource.getTxtRsrcComments());
    cres03so.setSzCdRsrcCampusType(capsResource.getCdRsrcCampusType());
    cres03so
            .setLNbrSchCampusNbr(capsResource.getNbrRsrcCampusNbr() != null ? capsResource.getNbrRsrcCampusNbr() : ZERO);
    cres03so.setSzCdRsrcStatus(capsResource.getCdRsrcStatus());
    cres03so
            .setLNbrRsrcFacilAcclaim(capsResource.getNbrRsrcFacilAcclaim() != null ? capsResource
                                                                                                 .getNbrRsrcFacilAcclaim()
                                                                                  : ZERO);
    cres03so.setSzCdRsrcType(capsResource.getCdRsrcType());
    cres03so.setSzCdRsrcOwnership(capsResource.getCdRsrcOwnership());
    cres03so.setSzNmRsrcContact(capsResource.getNmRsrcContact());
    cres03so.setSzCdRsrcFacilType(capsResource.getCdRsrcFacilType());
    cres03so.setSzCdRsrcMaintainer(capsResource.getCdRsrcMaintainer());
    cres03so.setCIndRsrcTransport(capsResource.getIndRsrcTransport());
    cres03so.setSzNmRsrcLastUpdate(capsResource.getNmRsrcLastUpdate());
    cres03so.setSzCdRsrcHub(capsResource.getCdRsrcHub());
    cres03so.setSzCdMhmrCompCode(capsResource.getCdRsrcMhmrCompCode());
    cres03so.setSzCdIncFacilOperBy(capsResource.getCdRsrcOperBy());
    cres03so.setSzNmLegal(capsResource.getNmLegal());
    cres03so.setTsLastUpdate(capsResource.getDtLastUpdate());
    cres03so.setDtScrDtRsrcLastUpdate(DateHelper.toCastorDate(capsResource.getDtLastUpdate()));

    cres03so.setSzNmRsrcContactTitle(capsResource.getNmRsrcContactTitle());
    cres03so.setSzNbrRsrcNtnlProvider(capsResource.getNbrRsrcNtnlProvider());
    cres03so.setSzAddrRsrcEmail(capsResource.getAddrRsrcEmail());
    cres03so.setSzAddrRsrcWebsite(capsResource.getAddrRsrcWebsite());
    cres03so.setSzCdSchoolType(capsResource.getCdSchoolType());
    cres03so.setSzCdSchoolDistrict(capsResource.getCdSchDist());
    cres03so.setSzCdPaymentDelivery(capsResource.getCdPaymentDelivery());
     //SMS#51977 MR-066
    if(capsResource.getStage() != null){
      cres03so.setUlIdHomeStage(capsResource.getStage().getIdStage());
    }

    return cres03so;
  }

  private ROWCRES03SOG01_ARRAY retrievePhoneInformation(int idResource) {
    // cres14d
    List<ResourcePhone> resourcePhoneList = resourcePhoneDAO.findResourcePhoneByIdResource(idResource);
    if (resourcePhoneList == null || resourcePhoneList.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCRES03SOG01_ARRAY rowcres03sog01_array = new ROWCRES03SOG01_ARRAY();
    for (Iterator<ResourcePhone> resourcePhoneIt = resourcePhoneList.iterator(); resourcePhoneIt.hasNext();) {
      ROWCRES03SOG01 rowcres03sog01 = new ROWCRES03SOG01();
      ResourcePhone resourcePhone = resourcePhoneIt.next();
      rowcres03sog01.setUlIdRsrcPhone(resourcePhone.getIdRsrcPhone() != null ? resourcePhone.getIdRsrcPhone() : ZERO);
      rowcres03sog01.setUlIdResource(idResource);
      rowcres03sog01.setSzCdFacilPhoneType(resourcePhone.getCdRsrcPhoneType());
      rowcres03sog01.setLNbrFacilPhoneNumber(resourcePhone.getNbrRsrcPhone());
      rowcres03sog01.setLNbrFacilPhoneExtension(resourcePhone.getNbrRsrcPhoneExt());
      rowcres03sog01.setSzTxtRsrcPhoneComments(resourcePhone.getTxtRsrcPhoneComments());
      rowcres03sog01.setTsLastUpdate(resourcePhone.getDtLastUpdate());
      rowcres03sog01_array.addROWCRES03SOG01(rowcres03sog01);
    }
    return rowcres03sog01_array;
  }
  
  private ROWCRES03SOG02_ARRAY retrieveORSFacilities(int idResource) {
    ROWCRES03SOG02_ARRAY rowcres03sog02_array = new ROWCRES03SOG02_ARRAY();
    List<Facility> faclist = facilityDAO.findFacilitiesByResourceId(idResource);
    if(faclist != null && faclist.size() > 0) {
      Iterator<Facility> itr = faclist.iterator();
      while(itr.hasNext()) {
        Facility fac = itr.next();
        ROWCRES03SOG02 rowcres03sog02 = new ROWCRES03SOG02();
        rowcres03sog02.setSzNbrOrsRsrcId(fac.getFacid());
        rowcres03sog02.setSzNmOrsFacilName(fac.getName());
        rowcres03sog02.setSzNmOrsFacType(Lookup.simpleDecodeSafe(Corsopft.CORSOPFT, fac.getFactype()));
        rowcres03sog02.setSzTxtOrsFacStatus(Lookup.simpleDecodeSafe(Corsopst.CORSOPST, fac.getOperstat()));
        rowcres03sog02_array.addROWCRES03SOG02(rowcres03sog02);
      }
    }
    
    return rowcres03sog02_array;
  }
}
