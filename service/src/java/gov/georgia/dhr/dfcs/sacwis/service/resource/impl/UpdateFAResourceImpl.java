package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceChrctrDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceChrctr;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceService;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.UpdateFAResource;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD01UIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD01UO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UpdateFAResourceImpl extends BaseServiceImpl implements UpdateFAResource {

  private static final String RSRC_CHAR_SEX_MALE = CodesTables.CRSRCSEX_M;

  private static final String RSRC_CHAR_SEX_FEMALE = CodesTables.CRSRCSEX_F;

  private static final String RSRC_CHAR_SEX_BOTH = CodesTables.CRSRCSEX_B;

  private CapsResourceDAO capsResourceDAO = null;

  private ResourceServiceDAO resourceServiceDAO = null;

  private ResourceChrctrDAO resourceChrctrDAO = null;

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setResourceServiceDAO(ResourceServiceDAO resourceServiceDAO) {
    this.resourceServiceDAO = resourceServiceDAO;
  }

  public void setResourceChrctrDAO(ResourceChrctrDAO resourceChrctrDAO) {
    this.resourceChrctrDAO = resourceChrctrDAO;
  }

  public CFAD01UO updateFAResource(CFAD01UI cfad01ui) throws ServiceException {
    // We use arrays in this service specifically because these 3 arrays, plus dataActions below, are often looped
    // over in parallel. While this can be done with collections, it is cleaner to do it with arrays, in this case.
    // Note also that several methods below update one or more of these arrays when they are used as parameters.
    // Use 0-length arrays by default, as this will allow the service to complete w/o error an mimics the C code's
    // behavior.
    List<String> cdRsrcSvcServices = null;
    List<Integer> idResourceServices = null;
    List<Date> dtLastUpdates = null;

    // Set-Up Section
    int ulIdResource = cfad01ui.getUlIdResource();
    String cSysIndCategoryChange = cfad01ui.getCSysIndCategoryChange();
    String bSysIndAddressChange = cfad01ui.getBSysIndAddressChange();
    // Commented out this line SHINES is not concerned with the changes in
    // foster home types String cSysIndFosterTypeChange = cfad01ui.getCSysIndFosterTypeChange();
    String cSysIndRsrcPrsChg = cfad01ui.getCSysIndRsrcPrsChg();
    CapsResource capsResource = retrieveCapsResource(ulIdResource, cSysIndCategoryChange, bSysIndAddressChange,
                                                     cSysIndRsrcPrsChg);
    // If category or home type(s) have changed or characteristics have been added or deleted on the interest window,
    // retrieve all CdRsrcServService(s) and IdResourceService(s) that currently exist for this resource. These will
    // be held in local variables for subsequent processing.
    // Added condition that if PRS has changed then Retrieve all the Services that currently exist. This is because
    // PRS homes and NonPRS homes have different Service Categories.
    // Removed this line ArchitectureConstants.Y.equals(cSysIndFosterTypeChange) - SHINES is not concerned with
    // changes in the foster home types.
    String cSysIndRsrcCharChg = cfad01ui.getCSysIndRsrcCharChg();
    
    if (ArchitectureConstants.Y.equals(cSysIndCategoryChange) || ArchitectureConstants.Y.equals(cSysIndRsrcCharChg)
        || ArchitectureConstants.Y.equals(cSysIndRsrcPrsChg)) {
      // Determine resource service(s) which currently exist (note: it is o.k. if none currently exist)
      // Note that the original service was limited to 25; this limit may need to be restored when we add pagination.
      // cres37d      
      List<ResourceService> resourceServiceList = resourceServiceDAO.findResourceServiceAll(ulIdResource);
      if (resourceServiceList != null) {
        // Size the arrays now that we know the correct size to use.
        cdRsrcSvcServices = new ArrayList<String>();
        idResourceServices = new ArrayList<Integer>();
        dtLastUpdates = new ArrayList<Date>();
        int i = 0;
        for (Iterator<ResourceService> it = resourceServiceList.iterator(); it.hasNext();) {
          ResourceService resourceService = it.next();
          cdRsrcSvcServices.add(i, resourceService.getCdRsrcSvcService());
          idResourceServices.add(i, resourceService.getIdResourceService());
          dtLastUpdates.add(i, resourceService.getDtLastUpdate());
          i++;
        }
      }
    }

    // Approved Age Change Section
    //
    // If the approved ages have changed AND neither resource service rows nor resource characteristics rows need to be
    // added/deleted, update all resource characteristics rows with the new approved ages
    // Added condition that if the PRS status has changed, then do not enter this logic. If it has changed then
    // Services will need to be changed.
    int nbrRsrcMlAgeMin = cfad01ui.getUNbrRsrcMlAgeMin();
    int nbrRsrcMlAgeMax = cfad01ui.getUNbrRsrcMlAgeMax();
    int nbrRsrcFMAgeMin = cfad01ui.getUNbrRsrcFMAgeMin();
    int nbrRsrcFMAgeMax = cfad01ui.getUNbrRsrcFMAgeMax();
    String bSysIndAgeChange = cfad01ui.getBSysIndAgeChange();
    if (ArchitectureConstants.Y.equals(bSysIndAgeChange) && ArchitectureConstants.N.equals(cSysIndCategoryChange)
        && !ArchitectureConstants.Y.equals(cSysIndRsrcCharChg) && ArchitectureConstants.N.equals(cSysIndRsrcPrsChg)) {
      updateResourceChrctr(nbrRsrcMlAgeMin, nbrRsrcMlAgeMax, nbrRsrcFMAgeMin, nbrRsrcFMAgeMax, ulIdResource);
    }

    // Resource Service Compare Section
    //
    // If F/A Home Types have been added or deleted or if the category of the home has changed, determine what resource
    // services need to exist, compare this with the resource services that currently exist (retrieved earlier),
    // & set a flag if the two differ. If, however, neither the category nor the foster types have changed, indicate
    // that the currently existing resource service(s) need to be kept.
    // Added condition that if the PRS Status has changed, then perform this logic. If it has changed, then Resource
    // Services need to switch from PRS F/A Home to Non PRS F/A Home or vice versa.
    boolean bServiceChangeRequired = false;
    if (ArchitectureConstants.Y.equals(cSysIndCategoryChange) || ArchitectureConstants.Y.equals(cSysIndRsrcPrsChg)
        || ArchitectureConstants.Y.equals(cSysIndRsrcCharChg)) {
      // Note that dataActions and cdRsrcSvcServices are both updated by this method..
      bServiceChangeRequired = compareResourceServices(capsResource, cdRsrcSvcServices);
    }


    // Add/Delete Rsrc Service Section
    // if a service change is required, rebuild services. Also ensure services are built at least once before submitting for approval.
    // So automatically build services if save is clicked and status is Applicant.
    if (bServiceChangeRequired || CodesTables.CFAHMSTA_APP.equals(cfad01ui.getSzCdRshsFaHomeStatus())) {
      // Note that idResourceServices is updated when ResourceService records are added.
      deleteCharacteristics(bServiceChangeRequired, ulIdResource, cSysIndRsrcCharChg);
      idResourceServices = addDeleteRsrcServices(ulIdResource);
      rebuildCharacteristics(ulIdResource, nbrRsrcMlAgeMin, nbrRsrcMlAgeMax, nbrRsrcFMAgeMin, nbrRsrcFMAgeMax,
                             cfad01ui.getCFAD01UIG00_ARRAY());
    }

    // Re-build Characteristics Section
    //
    // Re-build resource characteristics rows for each resource service. CrRsrcCharChrctr[0] will not be null when
    // characteristics where checked or unchecked on the interest window (all chrcts with a check are passed into
    // the function) or when resource changes were made (the chrctrs are retrieved and placed into the InputMsg).
    // It is possible that characteristics will need to be rebuilt not only if Characteristics have changed, but also
    // if Services have changed. Added condition to the if Statement that the characteristics should be rebuilt if
    // a Service Change is required.
    if (ArchitectureConstants.Y.equals(cSysIndRsrcCharChg)) {
      deleteCharacteristics(bServiceChangeRequired, ulIdResource, cSysIndRsrcCharChg);
      rebuildCharacteristics(ulIdResource, nbrRsrcMlAgeMin, nbrRsrcMlAgeMax, nbrRsrcFMAgeMin, nbrRsrcFMAgeMax,
                             cfad01ui.getCFAD01UIG00_ARRAY());
      //if coming from Add Home page, don't build Services, add characteristics not tied to services.
    } else if (ArchitectureConstants.Y.equals(cfad01ui.getCSysIndRsrcCharChgNoSvc())) {
      buildCharacteristics(ulIdResource, cfad01ui.getCFAD01UIG00_ARRAY());
    }
   /**
    *STGAP00009856  
    * removed this code because we are doing new inserts instead in the saveApprovalImpl
    * 
    * 
    // Address Change Section
    //
    // If the address has changed, attempt to update the currently existing resource service rows.
    // (**note: it is not an error if no rows are found when attempting to do this update**)
  //  if (ArchitectureConstants.Y.equals(bSysIndAddressChange)) {
      // cauda9d -- Update is forced and SQL_NOT_FOUND is not an error
    //  resourceServiceDAO.updateResourceServiceSetCdRsrcSvcCnty(capsResource.getCdRsrcCnty(),
      //                                                         capsResource.getCdRsrcRegion(),
        //                                                       capsResource.getCdRsrcState(), ulIdResource);
    //}
    // The output message is empty.
     * 
     */
    return null;
  }

  private void buildCharacteristics(int idResource, CFAD01UIG00_ARRAY cfad01uig00_array) throws ServiceException {
    Enumeration cfad01uig00_enum = cfad01uig00_array.enumerateCFAD01UIG00();
    CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResourceOnly(idResource);
    // Loop through each characteristic and insert it for the resource service being processed
    while (cfad01uig00_enum.hasMoreElements()) {
      CFAD01UIG00 cfad01uig00 = (CFAD01UIG00) cfad01uig00_enum.nextElement();
      if (cfad01uig00.getSzCdRsrcCharChrctr() == null) {
        // We are done if we encounter a null cdRsrcCharChrctr value.
        break;
      }
      ResourceChrctr resourceChrctr = new ResourceChrctr();
      resourceChrctr.setCapsResource(capsResource);
      resourceChrctr.setCdRsrcCharChrctr(cfad01uig00.getSzCdRsrcCharChrctr());

      // cres21d
      resourceChrctrDAO.saveOrUpdateResourceChrctr(resourceChrctr);
      /*
       * if (0 == resourceChrctrDAO.insertResourceChrctrNoServices(cfad01uig00.getSzCdRsrcCharChrctr())) { throw new
       * ServiceException(Messages.SQL_NOT_FOUND); }
       */
    }
  }

  private void rebuildCharacteristics(int idResource, int nbrRsrcMlAgeMin, int nbrRsrcMlAgeMax, int nbrRsrcFMAgeMin, 
                                      int nbrRsrcFMAgeMax, CFAD01UIG00_ARRAY cfad01uig00_array) throws ServiceException {
       
    CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResourceOnly(idResource);
    List<ResourceService> resourceServiceList = resourceServiceDAO.findResourceServiceAll(idResource);
    // SMS 103664 also check for empty object.  This object comes in empty not null. 
    if (resourceServiceList != null && !resourceServiceList.isEmpty()) {
      // Size the arrays now that we know the correct size to use.
      for (Iterator<ResourceService> it = resourceServiceList.iterator(); it.hasNext();) {
        ResourceService resourceService = it.next();        
        Enumeration cfad01uig00_enum = cfad01uig00_array.enumerateCFAD01UIG00();
        // Loop through each characteristic and insert it for the resource service being processed
        while (cfad01uig00_enum.hasMoreElements()) {
          CFAD01UIG00 cfad01uig00 = (CFAD01UIG00) cfad01uig00_enum.nextElement();
          if (cfad01uig00.getSzCdRsrcCharChrctr() == null) {
            // We are done if we encounter a null cdRsrcCharChrctr value.
            break;
          }
          String cdRsrcCharSex = null;
          if (nbrRsrcMlAgeMin > 0 && nbrRsrcFMAgeMin == 0) {
            cdRsrcCharSex = RSRC_CHAR_SEX_MALE;
          } else if (nbrRsrcMlAgeMin == 0 && nbrRsrcFMAgeMin > 0) {
            cdRsrcCharSex = RSRC_CHAR_SEX_FEMALE;
          } else if (nbrRsrcMlAgeMin > 0 && nbrRsrcFMAgeMin > 0) {
            cdRsrcCharSex = RSRC_CHAR_SEX_BOTH;
          }
        // cres21d
          ResourceChrctr resourceChrctr = new ResourceChrctr();
          resourceChrctr.setCapsResource(capsResource);
          resourceChrctr.setCdRsrcCharChrctr(cfad01uig00.getSzCdRsrcCharChrctr());
          resourceChrctr.setResourceService(resourceService);
          resourceChrctr.setCdRsrcCharSex(cdRsrcCharSex);
          resourceChrctr.setNbrRsrcCharMaxFAge(nbrRsrcFMAgeMax);
          resourceChrctr.setNbrRsrcCharMaxMAge(nbrRsrcMlAgeMax);
          resourceChrctr.setNbrRsrcCharMinFAge(nbrRsrcFMAgeMin);
          resourceChrctr.setNbrRsrcCharMinMAge(nbrRsrcMlAgeMin);
        
          resourceChrctrDAO.saveOrUpdateResourceChrctr(resourceChrctr);        
        }
      }
    }else{
      // 103664 Even if the resource has no services. We still need to save the checked values from the page. 
   buildCharacteristics(idResource, cfad01uig00_array);
    }
  }  /**
       * Compares the services with what is expected for the category of the home i.e. if home is of type foster then it
       * compares to ensure that the services saved to the resource service table. For Non-DFCS Homes the services
       * should be deleted cos according to patrick we dont pay them.
       */
  private boolean compareResourceServices(CapsResource capsResource, List<String> cdRsrcSvcServices) {
    boolean bServiceChangeRequired = false;
    // Is the category adopt, foster adopt, Kinship, Legal Risk, or ICPC?
    // removed FA_CATG_FOST_ADOPT and FA_CATG_KIN_FA cos they dont exist in SHINES
    String cdRsrcCategory = capsResource.getCdRsrcCategory();
    if(FA_CATG_FOST_ADOPT_LEG_RISK.equals(cdRsrcCategory)) {
      bServiceChangeRequired = determineServiceChangeActionsForLegalRisk(cdRsrcSvcServices);
    } else if (FA_CATG_ADOPT.equals(cdRsrcCategory) || FA_CATG_REL_ADOPT.equals(cdRsrcCategory)) {
      bServiceChangeRequired = determineServiceChangeActions(CD_ADOPT_SERVICES, cdRsrcSvcServices);
    } else if (FA_CATG_FOST.equals(cdRsrcCategory)
               || FA_CATG_REL_FOST.equals(cdRsrcCategory) || FA_CATG_ICPC.equals(cdRsrcCategory)) {
      bServiceChangeRequired = determineServiceChangeActions(CD_FOSTER_SERVICES, cdRsrcSvcServices);
    }
    return bServiceChangeRequired;
  }

  private List<Integer> addDeleteRsrcServices(int idResource) throws ServiceException {
    // Delete all resource services ...
    resourceServiceDAO.deleteResourceServiceByIdResource(idResource);
    int iCounter = 0;
    List<Integer> idResourceServices = new ArrayList<Integer>();
    // load resource into state
    CapsResource capsResource = getPersistentObject(CapsResource.class, idResource);
    Set<String> serviceCategorySet = new HashSet<String>();
    String cdRsrcCategory = capsResource.getCdRsrcCategory();
    if (FA_CATG_FOST_ADOPT_LEG_RISK.equals(cdRsrcCategory) ||FA_CATG_ADOPT.equals(cdRsrcCategory) || 
    		FA_CATG_REL_ADOPT.equals(cdRsrcCategory)) {
    	serviceCategorySet.add(CD_ADOPT_SERVICES);
    } 
    
    if (FA_CATG_FOST_ADOPT_LEG_RISK.equals(cdRsrcCategory) || FA_CATG_FOST.equals(cdRsrcCategory)
               || FA_CATG_REL_FOST.equals(cdRsrcCategory) || FA_CATG_ICPC.equals(cdRsrcCategory)) {
    	serviceCategorySet.add(CD_FOSTER_SERVICES);
    }
    
    Iterator serviceCategoryIterator = serviceCategorySet.iterator();
    while(serviceCategoryIterator.hasNext()){
    	String serviceCatagory = (String)serviceCategoryIterator.next();
    // and then Add then add the entire package. It may seem inefficient but it is perhaps
    // the most optimal solution that handles all the possibilities.
    List<CodeAttributes> codeAttributesList;
    try {
      codeAttributesList = Lookup.getCategoryCollection(serviceCatagory);
      // Scan for codes for the specified category of service codes
      for (Iterator<CodeAttributes> it = codeAttributesList.iterator(); it.hasNext();) {
        CodeAttributes codeAttributes = it.next();
        // the category is the 1st 3 characters of the service code
        String svcCategory = codeAttributes.getDecode().substring(0, 3);

        ResourceService resourceService = new ResourceService();
        resourceService.setIndRsrcSvcShowRow(ArchitectureConstants.Y);
        resourceService.setCdRsrcSvcCnty(capsResource.getCdRsrcCnty());
        resourceService.setCdRsrcSvcServiceType("F");
        resourceService.setCdRsrcSvcRegion(capsResource.getCdRsrcRegion());
        resourceService.setCdRsrcSvcCategRsrc(svcCategory);
        resourceService.setCapsResource(capsResource);
        resourceService.setIndRsrcSvcCntyPartial(ArchitectureConstants.N);
        resourceService.setIndRsrcSvcIncomeBsed(ArchitectureConstants.N);
        resourceService.setCdRsrcSvcService(codeAttributes.getDecode());
        resourceService.setCdRsrcSvcState(capsResource.getCdRsrcState());

        // cres35d -- add is manually selected in the C service, so the id is unassigned; depend on Hibernate for
        // exceptions
        resourceServiceDAO.saveResourceService(resourceService);
        idResourceServices.add(iCounter, resourceService.getIdResourceService());
        iCounter++;
      }
      if (codeAttributesList.isEmpty()) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    } catch (LookupException e) {
      throw new ServiceException(Messages.SQL_NOT_FOUND, e);
    }
  }
    return idResourceServices;
  }

  private CFAD01UIG00_ARRAY deleteCharacteristics(boolean bServiceChangeRequired, int idResource, String indRsrcCharChg) {
    // If a change to the resource service table is necessary or if characteristics were added or removed on the
    // interest window, delete all characteristics rows. (**note: All characteristics rows are deleted in these two
    // conditions because it is easier to delete all the characteristics rows and rebuild them than it is to attempt
    // to determine which characteristics rows need to be added for each resource service. Also note that if chrctrs
    // where not passed into the function (which indicates chrctrs where neither checked nor uncheck on the interest
    // window) the chrctrs are retrieved and held in the InputMsg so they can be added to each resource service at
    // the end of the function**)
    CFAD01UIG00_ARRAY cfad01uig00_array = new CFAD01UIG00_ARRAY();
    // If resource service changes are required and we do not currently have the chrctrs & DtAdded,
    // obtain them prior to deleting all chrctrs rows.
    if (bServiceChangeRequired && !ArchitectureConstants.Y.equals(indRsrcCharChg)) {
      // clss48d -- No data found is not an error.
      List<Map> resourceChrctrList = resourceChrctrDAO.findResourceChrctrByIdResource(idResource);
      // This service stores data in its input message, which is non-standard, but not wrong
      if (resourceChrctrList != null) {
        for (Iterator<Map> it = resourceChrctrList.iterator(); it.hasNext();) {
          Map row = it.next();
          CFAD01UIG00 cfad01uig00 = new CFAD01UIG00();
          cfad01uig00.setSzCdRsrcCharChrctr((String) row.get("cdRsrcCharChrctr"));
          cfad01uig00.setDtDtRsrcCharDateAdded(DateHelper.toCastorDate((Date) row.get("dtRsrcCharDtAdded")));
          cfad01uig00_array.addCFAD01UIG00(cfad01uig00);
        }
      }
    }

    // Delete All Characteristics for this resource
    // cauda6d -- delete is manually selected in the C and SQL_NOT_FOUND is not an error
    resourceChrctrDAO.deleteResourceChrctrByIdResource(idResource);
    return cfad01uig00_array;
  }

  /**
   * Determines the actions to perform for service codes. If codes exist then it returns false. if however, the service
   * code based on the category is non-existent then it returns true
   */
  private boolean determineServiceChangeActions(String cdRsrcSvcServiceConstant, List<String> cdRsrcSvcServices) {
    boolean bServiceChangeRequired = false;
    int iCounter = 0;
    // if the retrieved services are empty then it is new.
    if (cdRsrcSvcServices.isEmpty() || cdRsrcSvcServices.size() <= 0) {
      bServiceChangeRequired = true;
    } else {
      for (Iterator<String> cdRsrcServiceIter = cdRsrcSvcServices.listIterator(iCounter); cdRsrcServiceIter.hasNext();) {
        String cdRsrcSvcService = cdRsrcServiceIter.next();
        if (!Lookup.isValidCode(cdRsrcSvcServiceConstant, cdRsrcSvcService)) {
          bServiceChangeRequired = true;
          break;
        }
      }
    }
    return bServiceChangeRequired;
  }
  
  private boolean determineServiceChangeActionsForLegalRisk(List<String> cdRsrcSvcServices) {
	  String cdAdoptRsrcSvcServiceConstant=CD_ADOPT_SERVICES;
	  String cdFosterRsrcSvcServiceConstant=CD_FOSTER_SERVICES;
	  
	    boolean bServiceChangeRequired = false;
	    int iCounter = 0;
	    // if the retrieved services are empty then it is new.
	    if (cdRsrcSvcServices.isEmpty() || cdRsrcSvcServices.size() <= 0) {
	      bServiceChangeRequired = true;
	    } else {
	      for (Iterator<String> cdRsrcServiceIter = cdRsrcSvcServices.listIterator(iCounter); cdRsrcServiceIter.hasNext();) {
	        String cdRsrcSvcService = cdRsrcServiceIter.next();
	        if (!Lookup.isValidCode(cdAdoptRsrcSvcServiceConstant, cdRsrcSvcService) && 
	        		!Lookup.isValidCode(cdFosterRsrcSvcServiceConstant, cdRsrcSvcService)
	        ) {
	          bServiceChangeRequired = true;
	          break;
	        }
	      }
	    }
	    
	    return bServiceChangeRequired;
  }

  
  
  private void updateResourceChrctr(int nbrRsrcMlAgeMin, int nbrRsrcMlAgeMax, int nbrRsrcFMAgeMin, int nbrRsrcFMAgeMax,
                                    int idResource) {
    String cdRsrcCharSex = null;
    if (nbrRsrcMlAgeMin > 0 && nbrRsrcFMAgeMin == 0) {
      cdRsrcCharSex = RSRC_CHAR_SEX_MALE;
    } else if (nbrRsrcMlAgeMin == 0 && nbrRsrcFMAgeMin > 0) {
      cdRsrcCharSex = RSRC_CHAR_SEX_FEMALE;
    } else if (nbrRsrcMlAgeMin > 0 && nbrRsrcFMAgeMin > 0) {
      cdRsrcCharSex = RSRC_CHAR_SEX_BOTH;
    }
    // Update is explicitly called for by the service.
    // caud08d -- SQL_NOT_FOUND is explicitly ignored
    resourceChrctrDAO.updateResourceChrctr(nbrRsrcMlAgeMin, nbrRsrcMlAgeMax, nbrRsrcFMAgeMin, nbrRsrcFMAgeMax,
                                           cdRsrcCharSex, idResource);
  }

  private CapsResource retrieveCapsResource(int idResource, String indCategoryChange, String indAddressChange,
                                            String indRsrcPrsChg) throws ServiceException {
    // If the address, category, or home type(s) have changed, retrieve a full row from the caps_resource table.
    // The data needed from this table will be held in local variables & used in subsequent processing.
    CapsResource capsResource = new CapsResource();
    capsResource = null;
    if (ArchitectureConstants.Y.equals(indCategoryChange) || ArchitectureConstants.Y.equals(indAddressChange)
        || ArchitectureConstants.Y.equals(indRsrcPrsChg)) {
      // cres04d
      capsResource = capsResourceDAO.findCapsResourceByIdResourceOnly(idResource);
      if (capsResource == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }
    return capsResource;
  }
}
