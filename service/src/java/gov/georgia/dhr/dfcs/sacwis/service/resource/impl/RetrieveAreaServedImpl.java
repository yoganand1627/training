package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceService;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.RetrieveAreaServed;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES05SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCRES05SOG00_ARRAY;

import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RetrieveAreaServedImpl extends BaseServiceImpl implements RetrieveAreaServed {

  private ResourceServiceDAO resourceServiceDAO = null;

  private ContractCountyDAO contractCountyDAO = null;
  
  private CapsResourceDAO capsResourceDAO = null;

  public void setResourceServiceDAO(ResourceServiceDAO resourceServiceDAO) {
    this.resourceServiceDAO = resourceServiceDAO;
  }

  public void setContractCountyDAO(ContractCountyDAO contractCountyDAO) {
    this.contractCountyDAO = contractCountyDAO;
  }
  
  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public CRES05SO retrieveAreaServed(CRES05SI cres05si) throws ServiceException {

    CRES05SO cres05so = new CRES05SO();

    String indRsrcContracted = null;

    ArchInputStruct archInputStruct = cres05si.getArchInputStruct();
    int pageNbr = archInputStruct.getUsPageNbr();
    int pageSize = archInputStruct.getUlPageSizeNbr();
    
    CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResc(cres05si.getUlIdResource());
    String facilityType = capsResource.getCdRsrcFacilType()!= null ? capsResource.getCdRsrcFacilType() : "";
    if("70".equals(facilityType) || "71".equals(facilityType)){
      cres05so.setCIndFadHome(ArchitectureConstants.Y);
    }
    // CallCRES10D
    PaginatedHibernateList<ResourceService> resourceServiceList = resourceServiceDAO.findResourceServiceByIdResource(cres05si.getUlIdResource(),
                                                                                                                     pageNbr,
                                                                                                                     pageSize);

    ArchOutputStruct archOutputStruct = new ArchOutputStruct();
    archOutputStruct.setBMoreDataInd(resourceServiceList.getBMoreDataInd());
    cres05so.setArchOutputStruct(archOutputStruct);

    ROWCRES05SOG00_ARRAY rowcres05sog00_array = new ROWCRES05SOG00_ARRAY();

    for (Iterator<ResourceService> it = resourceServiceList.iterator(); it.hasNext();) {
      ROWCRES05SOG00 rowcres05sog00 = new ROWCRES05SOG00();
      ResourceService resourceService = it.next();
      rowcres05sog00.setUlIdResourceService(resourceService.getIdResourceService() != null ? resourceService.getIdResourceService()
                                                                                          : 0);
      rowcres05sog00.setTsLastUpdate(resourceService.getDtLastUpdate());
      rowcres05sog00.setCIndRsrcSvcShowRow(resourceService.getIndRsrcSvcShowRow());
      rowcres05sog00.setSzScrRsrcSvcCntyCode(resourceService.getCdRsrcSvcCnty());
      rowcres05sog00.setSzCdRsrcSvcProgram(resourceService.getCdRsrcSvcProgram());
      rowcres05sog00.setSzCdRsrcSvcRegion(resourceService.getCdRsrcSvcRegion());
      rowcres05sog00.setSzCdRsrcSvcCategRsrc(resourceService.getCdRsrcSvcCategRsrc());
      rowcres05sog00.setSzCdRsrcSvcService(resourceService.getCdRsrcSvcService());
      rowcres05sog00.setSzCdRsrcSvcServiceType(resourceService.getCdRsrcSvcServiceType());
      rowcres05sog00.setSzCdRsrcSvcState(resourceService.getCdRsrcSvcState());
      rowcres05sog00.setBIndRsrcSvcCntyPartial(resourceService.getIndRsrcSvcCntyPartial());
      rowcres05sog00.setCIndRsrcSvcIncomeBsed(resourceService.getIndRsrcSvcIncomeBsed());

      rowcres05sog00_array.addROWCRES05SOG00(rowcres05sog00);
    }
    cres05so.setROWCRES05SOG00_ARRAY(rowcres05sog00_array);

    // for each row returned, check the contracted status
    rowcres05sog00_array = cres05so.getROWCRES05SOG00_ARRAY();
    Enumeration rowcres05sog00_enum = rowcres05sog00_array.enumerateROWCRES05SOG00();
    // Logic to be performed for every row in the list box
    while (rowcres05sog00_enum.hasMoreElements()) {
      ROWCRES05SOG00 rowcres05sog00 = (ROWCRES05SOG00) rowcres05sog00_enum.nextElement();

      String svcCntyCode = rowcres05sog00.getSzScrRsrcSvcCntyCode();
      String svcRegion = rowcres05sog00.getSzCdRsrcSvcRegion();
      String svcState = rowcres05sog00.getSzCdRsrcSvcState();
      String svcService = rowcres05sog00.getSzCdRsrcSvcService();
      if ((StringHelper.EMPTY_STRING.equals(StringHelper.getNonNullString(svcCntyCode))) && (!CodesTables.CREGOFF_99.equals(svcRegion))&& (CodesTables.CSTATE_GA.equals(svcState))) {
        List<CodeAttributes> codeAttributesList;
        try {
          codeAttributesList = Lookup.getCategoryCollection(CodesTables.CCNTYREG);
          // Scan for codes for the specified region
          for (Iterator<CodeAttributes> it = codeAttributesList.iterator(); it.hasNext();) {
            CodeAttributes codeAttributes = it.next();
            // Skip attributes w/o decode of svcRegion
            String currSvcRegion = codeAttributes.getDecode();
            if (currSvcRegion.length() == 3) {
              currSvcRegion = currSvcRegion.substring(1, 3);
            }

            if (!svcRegion.equals(currSvcRegion)) {
              it.remove();
            }
          }
        } catch (LookupException e) {
          // In an ideal world, this would not be the exception thrown, but to match the existing service, use it.
          throw new ServiceException(Messages.SQL_NOT_FOUND, e);
        }

        for (Iterator<CodeAttributes> it = codeAttributesList.iterator(); it.hasNext();) {
          CodeAttributes codeAttributes = it.next();

          // CallCRES33D
          List<Map> contractCountyMapList = contractCountyDAO.findContractCountyByIdResourceCdRsrcSvcServiceAndcdRsrcSvcCnty(cres05si.getUlIdResource(),
                                                                                                                             svcService,
                                                                                                                             codeAttributes.getCode());

          if ((contractCountyMapList == null) || contractCountyMapList.isEmpty()) {
            rowcres05sog00.setCScrIndRsrcContracted(ArchitectureConstants.N);
            break;
          }

          for (Iterator<Map> contractCountyMapIt = contractCountyMapList.iterator(); contractCountyMapIt.hasNext();) {
            Map contractCountyMap = contractCountyMapIt.next();

            // Populate a date for the compare date function
            Date dtContractEndDate = (Date) contractCountyMap.get("dtCncntyEnd");

            // CINT21D will only be called if the previous DAM call completed
            // successfully. CINT21D will retrieve an entire row from the
            // stage table. Only those cols that are of interest to CINT03W
            // will be copied to the service output message.

            if (DateHelper.isNull(dtContractEndDate)) {
              indRsrcContracted = ArchitectureConstants.Y;
              rowcres05sog00.setCScrIndRsrcContracted(indRsrcContracted);
              break;
            }

            // Compare the current system date with the contract end
            // date. The return code will be negative if the system
            // date is before the end date. In this case, the contract
            // will be active. If the the return code is zero the
            // system date will be equal to the contract date. In this
            // case, the contract will still be active. If the return code
            // is positive, the system date will be after the contract
            // end date and the contract will not be active.
            else {
              GregorianCalendar gc1 = new GregorianCalendar();
              Date sysDate = gc1.getTime();
              if (DateHelper.isBefore(sysDate, dtContractEndDate)) {
                indRsrcContracted = ArchitectureConstants.Y;
                rowcres05sog00.setCScrIndRsrcContracted(indRsrcContracted);
                break;
              } else {
                indRsrcContracted = ArchitectureConstants.N;
                rowcres05sog00.setCScrIndRsrcContracted(indRsrcContracted);
              }

            }
          }
        }
        // Handle case if State is not GA or
        // Region is Statewide Intake or
        // Region is State Ofice

      } else if ((CodesTables.CREGOFF_99.equals(svcRegion))|| (!CodesTables.CSTATE_GA.equals(svcState))) {
        rowcres05sog00.setCScrIndRsrcContracted(ArchitectureConstants.N);
      } else {

        // CallCRES33D
        List<Map> contractCountyMapList = contractCountyDAO.findContractCountyByIdResourceCdRsrcSvcServiceAndcdRsrcSvcCnty(cres05si.getUlIdResource(),
                                                                                                                           svcService,
                                                                                                                           svcCntyCode);

        for (Iterator<Map> contractCountyMapListIt = contractCountyMapList.iterator(); contractCountyMapListIt.hasNext();) {
          Map contractCountyMap = contractCountyMapListIt.next();

          // Populate a date for the compare date function
          Date dtContractEndDate = (Date) contractCountyMap.get("dtCncntyEnd");

          // CINT21D will only be called if the previous DAM call completed
          // successfully. CINT21D will retrieve an entire row from the
          // stage table. Only those cols that are of interest to CINT03W
          // will be copied to the service output message.
          if (DateHelper.isNull(dtContractEndDate)) {
            indRsrcContracted = ArchitectureConstants.Y;
            rowcres05sog00.setCScrIndRsrcContracted(indRsrcContracted);
            break;
          }

          // Compare the current system date with the contract end
          // date. The return code will be negative if the system
          // date is before the end date. In this case, the contract
          // will be active. If the the return code is zero the
          // system date will be equal to the contract date. In this
          // case, the contract will still be active. If the return code
          // is positive, the system date will be after the contract
          // end date and the contract will not be active.
          else {

            GregorianCalendar gc1 = new GregorianCalendar();
            Date sysDate = gc1.getTime();
            if (DateHelper.isBefore(sysDate, dtContractEndDate)) {
              indRsrcContracted = ArchitectureConstants.Y;
              rowcres05sog00.setCScrIndRsrcContracted(indRsrcContracted);
              break;
            } else {
              rowcres05sog00.setCScrIndRsrcContracted(ArchitectureConstants.N);
            }

          }
        }
        rowcres05sog00.setCScrIndRsrcContracted(indRsrcContracted);
      }
    }
    return cres05so;

  }

}
