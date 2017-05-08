package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexResourceChrctrDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexResourceServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceService;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.SaveAreaServed;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES06SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES06SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES06SOG00_ARRAY;

public class SaveAreaServedImpl extends BaseServiceImpl implements SaveAreaServed {

  private ResourceServiceDAO resourceServiceDAO = null;

  private ComplexResourceServiceDAO complexResourceServiceDAO = null;

  private ComplexResourceChrctrDAO complexResourceChrctrDAO = null;

  public void setResourceServiceDAO(ResourceServiceDAO resourceServiceDAO) {
    this.resourceServiceDAO = resourceServiceDAO;
  }

  public void setComplexResourceServiceDAO(ComplexResourceServiceDAO complexResourceServiceDAO) {
    this.complexResourceServiceDAO = complexResourceServiceDAO;
  }

  public void setComplexResourceChrctrDAO(ComplexResourceChrctrDAO complexResourceChrctrDAO) {
    this.complexResourceChrctrDAO = complexResourceChrctrDAO;
  }

  public CRES06SO saveAreaServed(CRES06SI cres06si) throws ServiceException {
    CRES06SO cres06so = new CRES06SO();
    ROWCRES06SOG00_ARRAY rowcres06sog00_array = new ROWCRES06SOG00_ARRAY();
    ROWCRES06SIG_ARRAY rowcres06sig_array = cres06si.getROWCRES06SIG_ARRAY();
    Enumeration rowcres06sig_enum = rowcres06sig_array.enumerateROWCRES06SIG();
    // Logic to be performed for every row in the list box
    while (rowcres06sig_enum.hasMoreElements()) {
      ROWCRES06SIG rowcres06sig = (ROWCRES06SIG) rowcres06sig_enum.nextElement();
      String rsrcSvcCntyCode = rowcres06sig.getSzScrRsrcSvcCntyCode();
      String cdRsrcSvcRegion = rowcres06sig.getSzCdRsrcSvcRegion();
      String cdRsrcSvcService = rowcres06sig.getSzCdRsrcSvcService();
      int idResource = rowcres06sig.getUlIdResource();
      int idResourceService = rowcres06sig.getUlIdResourceService();
      Date tsLastUpdate = rowcres06sig.getTsLastUpdate();
      String dataAction = rowcres06sig.getSzCdScrDataAction();
      String indRsrcSvcShowRow = rowcres06sig.getCIndRsrcSvcShowRow();
      String cdRsrcSvcCategRsrc = rowcres06sig.getSzCdRsrcSvcCategRsrc();
      String cdRsrcSvcProgram = rowcres06sig.getSzCdRsrcSvcProgram();
      String cdRsrcSvcState = rowcres06sig.getSzCdRsrcSvcState();
      String indRsrcSvcCntyPartial = rowcres06sig.getBIndRsrcSvcCntyPartial();
      String indRsrcSvcIncomeBsed = rowcres06sig.getCIndRsrcSvcIncomeBsed();
      String szCdRsrcServiceType = rowcres06sig.getSzCdRsrcSvcServiceType();

      ROWCRES06SOG00 rowcres06sog00;
    // Checking to see if all counties has been selected within a certian region
      if ((StringHelper.EMPTY_STRING.equals(StringHelper.getNonNullString(rsrcSvcCntyCode))) && !CodesTables.CREGOFF_99.equals(cdRsrcSvcRegion) && CodesTables.CSTATE_GA.equals(cdRsrcSvcState)) {
        rowcres06sog00 = audResourceService(dataAction, indRsrcSvcShowRow, cdRsrcSvcCategRsrc, cdRsrcSvcService,
                                            cdRsrcSvcProgram, cdRsrcSvcRegion, rsrcSvcCntyCode, indRsrcSvcCntyPartial,
                                            indRsrcSvcIncomeBsed, cdRsrcSvcState, idResource, rowcres06sig,
                                            idResourceService, tsLastUpdate, szCdRsrcServiceType);
      } else {
        rowcres06sog00 = new ROWCRES06SOG00();
        if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(dataAction)) {
          // else AUD single county, statewide intake, state office or state != TX as passed
          // (remember to delete population if data action is delete)
          // cres34d -- errors are ignored
          // TODO update method with appropriate column after columns has been added
          complexResourceChrctrDAO.deleteResourceChrctr(idResource, cdRsrcSvcState, cdRsrcSvcService, cdRsrcSvcRegion,
                                                        rsrcSvcCntyCode, szCdRsrcServiceType);
          // cres22d
          if (0 == resourceServiceDAO.deleteResourceServiceByIdResourceIdResourceServiceDtLastUpdate(idResource, idResourceService, tsLastUpdate)) {
            throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
          }
        } else {
          // The indicator is add or update, add rows not existing, update any rows that already exist; since delete
          // has already been processed, we do not need to check for it here.
          if (ServiceConstants.REQ_FUNC_CD_ADD.equals(dataAction)) {
            // STGAP00017562: Removed this logic as client was not updated on this enhanced message. Code left for reuse if later client agrees to implement it.
            // The exact dup would be caught by MSG_CON_COUNTY_VIOLATION as currently is.
            // Validate whether there exist a region wide row containing this county/service combination as conversation validate this on paginated list
            // and would miss duplicate in other pages.
            ResourceService rsDup = resourceServiceDAO.findDuplicateResourceServiceByRegionWide(cdRsrcSvcService, cdRsrcSvcRegion, idResource);
            if (rsDup != null) {
              throw new ServiceException(Messages.MSG_RES_ROW_EXISTS);
            }
            // STGAP00017212: validate duplicate against all existing records as data in state (accessible at conversation)
            // is paginated and does not hold all existing data
            // ResourceService rsDup = resourceServiceDAO.findDuplicateResourceServiceByCountyRow(cdRsrcSvcService, cdRsrcSvcRegion, rsrcSvcCntyCode, idResource);
            /*if (rsDup != null) {
              // override the generic error message and 
              // throw custom error message due to its dynamic nature, to at least let user know which combination was failing.
              String serviceDup = "service " + cdRsrcSvcService + ", region " + cdRsrcSvcRegion + ", county " + Lookup.simpleDecodeSafe(CodesTables.CCOUNT, rsrcSvcCntyCode); 
              final String errMsg = "The row " + serviceDup + " could not be added. A similar service/region/county combination already exists.";
               throw new ServiceException() {
                @Override
                public int getErrorCode() {
                  return Messages.MSG_RES_ROW_EXISTS;
                }

                @Override
                public String getErrorMessage() {
                  return errMsg;
                }
              };
            }*/

            // We need to set the idResourceService created into the output message here, so use CommonDAO to manually
            // retrieve the value for this field.
            idResourceService = commonDAO.getNextval("SEQ_RESOURCE_SERVICE");
            // cres22d
            // TODO change insert to new insert method with service type included
            try
            {
              if (0 == resourceServiceDAO.insertResourceService(idResourceService, indRsrcSvcShowRow, cdRsrcSvcCategRsrc,
                                                              rsrcSvcCntyCode, cdRsrcSvcProgram, cdRsrcSvcRegion,
                                                              cdRsrcSvcService, cdRsrcSvcState, indRsrcSvcCntyPartial,
                                                              indRsrcSvcIncomeBsed, idResource, szCdRsrcServiceType))
              {
                throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
              }
            }
            catch(Exception ex)
            {
              throw new ServiceException(Messages.MSG_CON_COUNTY_VIOLATION);
              
            }
            rowcres06sog00.setUlIdResourceService(idResourceService);
            
          } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(dataAction)) {
            // cres22d
            if (0 == complexResourceServiceDAO.updateResourceServiceDAO(indRsrcSvcShowRow, cdRsrcSvcCategRsrc,
                                                                        rsrcSvcCntyCode, cdRsrcSvcProgram,
                                                                        cdRsrcSvcRegion, cdRsrcSvcService,
                                                                        cdRsrcSvcState, indRsrcSvcCntyPartial,
                                                                        indRsrcSvcIncomeBsed, idResource,
                                                                        idResourceService, tsLastUpdate,
                                                                        szCdRsrcServiceType)) {
              throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
            }
          } else {
            throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
          }
        }
      }
      rowcres06sog00_array.addROWCRES06SOG00(rowcres06sog00);
    }
    cres06so.setROWCRES06SOG00_ARRAY(rowcres06sog00_array);
    return cres06so;
  }

  private ROWCRES06SOG00 audResourceService(String dataAction, String indRsrcSvcShowRow, String cdRsrcSvcCategRsrc,
                                            String cdRsrcSvcService, String cdRsrcSvcProgram, String cdRsrcSvcRegion,
                                            String rsrcSvcCntyCode, String indRsrcSvcCntyPartial,
                                            String indRsrcSvcIncomeBsed, String cdRsrcSvcState, int idResource,
                                            ROWCRES06SIG rowcres06sig, int idResourceService, Date tsLastUpdate,
                                            String szCdRsrcServiceType) throws ServiceException {
    ROWCRES06SOG00 rowcres06sog00 = new ROWCRES06SOG00();
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(dataAction)) {
      // STGAP00017212: validate duplicate against all existing records as data in state (accessible at conversation)
      // is paginated and does not hold all existing data
      ResourceService rsDup = resourceServiceDAO.findDuplicateResourceServiceByRegionWide(cdRsrcSvcService, cdRsrcSvcRegion, idResource);
      if (rsDup != null) {
        throw new ServiceException(Messages.MSG_RES_ROW_EXISTS);
      }
      // STGAP00017562: Removed this custom message as client was not updated on the wording. Code left for reuse if later client agrees to implement it.
/*      if (rsDup != null) {
        // override the generic error message and 
        // throw custom error message due to its dynamic nature, to at least let user know which combination was failing.
        String serviceDup = "service " + cdRsrcSvcService + ", region " + cdRsrcSvcRegion; 
        final String errMsg = "The row " + serviceDup + " could not be added. A similar service/region/county combination already exists.";
         throw new ServiceException() {
          @Override
          public int getErrorCode() {
            return Messages.MSG_RES_ROW_EXISTS;
          }

          @Override
          public String getErrorMessage() {
            return errMsg;
          }
        };
      }
*/            
      ResourceService resourceService = new ResourceService();
      resourceService.setCdRsrcSvcServiceType(szCdRsrcServiceType);
      resourceService.setIndRsrcSvcShowRow(indRsrcSvcShowRow);
      resourceService.setCdRsrcSvcCategRsrc(cdRsrcSvcCategRsrc);
      resourceService.setCdRsrcSvcService(cdRsrcSvcService);
      resourceService.setCdRsrcSvcProgram(cdRsrcSvcProgram);
      resourceService.setCdRsrcSvcRegion(cdRsrcSvcRegion);
      resourceService.setCdRsrcSvcCnty(rsrcSvcCntyCode);
      resourceService.setIndRsrcSvcCntyPartial(indRsrcSvcCntyPartial);
      resourceService.setIndRsrcSvcIncomeBsed(indRsrcSvcIncomeBsed);
      resourceService.setCdRsrcSvcState(cdRsrcSvcState);
      CapsResource capsResource = commonDAO.getPersistentObject(CapsResource.class, idResource);
      resourceService.setCapsResource(capsResource);
      // cres36d
      resourceServiceDAO.saveResourceService(resourceService);

      // The insert case in the service requires additional logic, which is merged here with the DAM case check.

      // The indicator was ADD; delete any county rows for the region that exist and set ShowRow to N.
      rowcres06sig.setUlIdResourceService(resourceService.getIdResourceService() != null ? resourceService.getIdResourceService()
                                                                                        : 0);

      // Retreive necessary counties for the region
      List<CodeAttributes> codeAttributesList;
      try {
        codeAttributesList = Lookup.getCategoryCollection(CodesTables.CCNTYREG);
        // Scan for codes for the specified region
        for (Iterator<CodeAttributes> it = codeAttributesList.iterator(); it.hasNext();) {
          CodeAttributes codeAttributes = it.next();
          // Skip attributes w/o decode of svcRegion
          if (!cdRsrcSvcRegion.equals(codeAttributes.getDecode())) {
            it.remove();	
          }
        }
        if (codeAttributesList.isEmpty()) {
          // In an ideal world, this would not be the exception thrown, but to match the existing service, use it.
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
      } catch (LookupException e) {
        // In an ideal world, this would not be the exception thrown, but to match the existing service, use it.
        throw new ServiceException(Messages.SQL_NOT_FOUND, e);
      }

      for (Iterator<CodeAttributes> it = codeAttributesList.iterator(); it.hasNext();) {
        CodeAttributes codeAttributes = it.next();
        // Attempt to Delete the population that would be attached to the service county combination
        // (no time stamp is available)
        // Delete the population for the county row
        // cres34d -- it is not an error for no rows to be deleted
        // TODO update method after column is created
        complexResourceChrctrDAO.deleteResourceChrctr(idResource, cdRsrcSvcState, cdRsrcSvcService, cdRsrcSvcRegion,
                                                      codeAttributes.getCode(), szCdRsrcServiceType);
        // Now attempt to delete the service/county row that may exist based on the county retrieved above
        // cres35d
        resourceServiceDAO.deleteResourceServiceByIdResourceCdRsrcSvcCntyCode(cdRsrcSvcService,
                                                                              codeAttributes.getCode(), idResource);
        // add individual county
        // cres22d
        // TODO replace insert with new insert method
        if (0 == resourceServiceDAO.insertResourceService(0, ArchitectureConstants.N, cdRsrcSvcCategRsrc,
                                                          codeAttributes.getCode(), cdRsrcSvcProgram,
                                                          codeAttributes.getDecode(), cdRsrcSvcService, cdRsrcSvcState,
                                                          indRsrcSvcCntyPartial, indRsrcSvcIncomeBsed, idResource,
                                                          szCdRsrcServiceType)) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      }
    } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(dataAction)) {
      // Call CallCRES36D
      if (0 == complexResourceServiceDAO.updateResourceServiceDAO(indRsrcSvcShowRow, cdRsrcSvcCategRsrc,
                                                                  rsrcSvcCntyCode, cdRsrcSvcProgram, cdRsrcSvcRegion,
                                                                  cdRsrcSvcService, cdRsrcSvcState,
                                                                  indRsrcSvcCntyPartial, indRsrcSvcIncomeBsed,
                                                                  idResource, idResourceService, tsLastUpdate,
                                                                  szCdRsrcServiceType)) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
      rowcres06sog00.setUlIdResourceService(idResourceService);
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(dataAction)) {
      // Call CallCRES36D
      // TODO fix possible issue with delete process because of existence of child element
      if (0 == complexResourceServiceDAO.deleteResourceServiceDAO(idResource, cdRsrcSvcRegion, cdRsrcSvcService,
                                                                  idResourceService, tsLastUpdate, szCdRsrcServiceType)) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
    return rowcres06sog00;
  }
}
