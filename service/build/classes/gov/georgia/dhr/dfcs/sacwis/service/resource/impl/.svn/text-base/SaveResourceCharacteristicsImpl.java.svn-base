package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceChrctrDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceChrctr;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.SaveResourceCharacteristics;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES08SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES08SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES08SO;

public class SaveResourceCharacteristicsImpl extends BaseServiceImpl implements SaveResourceCharacteristics {

  private ResourceChrctrDAO resourceChrctrDAO = null;

  private ResourceServiceDAO resourceServiceDAO = null;

  public void setResourceChrctrDAO(ResourceChrctrDAO resourceChrctrDAO) {
    this.resourceChrctrDAO = resourceChrctrDAO;
  }

  public void setResourceServiceDAO(ResourceServiceDAO resourceServiceDAO) {
    this.resourceServiceDAO = resourceServiceDAO;
  }

  public CRES08SO saveResourceCharacteristics(CRES08SI cres08si) throws ServiceException {

    CRES08SO cres08so = new CRES08SO();

    // CallCRES21D

    // This was the null date, but that was almsot certainly wrong based on how it was used.
    Date dtDtRsrcCharDateAdded = new Date();
    // ResourceChrctr resourceChrctr = new ResourceChrctr();

    // Insert the input message information into the dam for each row passed
    for (Enumeration rowcres08sig00Enum = cres08si.getROWCRES08SIG00_ARRAY().enumerateROWCRES08SIG00(); rowcres08sig00Enum
                                                                                                                          .hasMoreElements();) {
      ROWCRES08SIG00 rowcres08sig00 = (ROWCRES08SIG00) rowcres08sig00Enum.nextElement();
      String reqFuncCd = rowcres08sig00.getSzCdScrDataAction();

      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)) {
        // cres21d
        if (0 == resourceChrctrDAO.insertResourceChrctr(cres08si.getUlIdResourceService(),
                                                        rowcres08sig00.getSzCdRsrcCharChrctr(),
                                                        rowcres08sig00.getCCdRsrcCharSex(),
                                                        rowcres08sig00.getUNbrRsrcCharMinMAge(),
                                                        rowcres08sig00.getUNbrRsrcCharMaxMAge(),
                                                        rowcres08sig00.getUNbrRsrcCharMinFAge(),
                                                        rowcres08sig00.getUNbrRsrcCharMaxFAge())) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(reqFuncCd)) {
        // cres21d
        ResourceChrctr resourceChrctr = getPersistentObject(ResourceChrctr.class,
                                                            rowcres08sig00.getUlIdResourceChrctr());
        // CapsResource capsResource = commonDAO.getPersistentObject(CapsResource.class, cres08si.getUlIdResource());
        // set the new values into the object
        resourceChrctr.setCdRsrcCharChrctr(rowcres08sig00.getSzCdRsrcCharChrctr());
        resourceChrctr.setCdRsrcCharSex(rowcres08sig00.getCCdRsrcCharSex());
        resourceChrctr.setDtRsrcCharDtAdded(dtDtRsrcCharDateAdded);
        resourceChrctr.setNbrRsrcCharMinMAge(rowcres08sig00.getUNbrRsrcCharMinMAge());
        resourceChrctr.setNbrRsrcCharMaxMAge(rowcres08sig00.getUNbrRsrcCharMaxMAge());
        resourceChrctr.setNbrRsrcCharMinFAge(rowcres08sig00.getUNbrRsrcCharMinFAge());
        resourceChrctr.setNbrRsrcCharMaxFAge(rowcres08sig00.getUNbrRsrcCharMaxFAge());
        resourceChrctr.setDtLastUpdate(rowcres08sig00.getTsLastUpdate());
        resourceChrctrDAO.saveOrUpdateResourceChrctr(resourceChrctr);
        // retrieve new object to compare if update transaction was completed using the dtLastUpdated
        ResourceChrctr resourceChrctr2 = resourceChrctrDAO
                                                          .findResourceChrctrByIdResourceChrctr(rowcres08sig00
                                                                                                              .getUlIdResourceChrctr());
        if (!resourceChrctr.getDtLastUpdate().equals(resourceChrctr2.getDtLastUpdate())) {
          throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        }
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(reqFuncCd)) {
        // cres21d

        ResourceChrctr resourceChrctr = (ResourceChrctr) getPersistentObject(ResourceChrctr.class,
                                                                             rowcres08sig00.getUlIdResourceChrctr());

        resourceChrctrDAO.deleteResourceChrctr(resourceChrctr);

      } else {
        // cres21d
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
      if (cres08si.getSzCdRsrcCharRegion() != null) {

        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(reqFuncCd)) {

          int idResource = cres08si.getUlIdResource();
          String cdRsrcCharService = cres08si.getSzCdRsrcCharService();
          String cdRsrcCharRegion = cres08si.getSzCdRsrcCharRegion();
          // cres42d
          List<Integer> resourceServiceInfo = resourceServiceDAO
                                                                .findResourceServiceByIdResourceCdRsrcCharServiceCdRsrcCharRegion(
                                                                                                                                  idResource,
                                                                                                                                  cdRsrcCharService,
                                                                                                                                  cdRsrcCharRegion);
          if (resourceServiceInfo == null || resourceServiceInfo.isEmpty()) {
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
          // Loop through each service id returned and add the
          // necessary characteristics row to each service id
          for (Iterator<Integer> it = resourceServiceInfo.iterator(); it.hasNext();) {
            Integer idResourceService = it.next();

            if (idResourceService != cres08si.getUlIdResourceService()) {
              // cres41d
              if (0 == resourceChrctrDAO.insertResourceChrctr(idResourceService,
                                                              rowcres08sig00.getSzCdRsrcCharChrctr(),
                                                              rowcres08sig00.getCCdRsrcCharSex(),
                                                              rowcres08sig00.getUNbrRsrcCharMinMAge(),
                                                              rowcres08sig00.getUNbrRsrcCharMaxMAge(),
                                                              rowcres08sig00.getUNbrRsrcCharMinFAge(),
                                                              rowcres08sig00.getUNbrRsrcCharMaxFAge())) {
                throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
              }
            }
          }
        }
        // Otherwise, the data action code is update or delete
        // In this case, modify or delete all rows where the
        // Id resource, service, region, and the old characteristics are the same.
        else {
          for (Enumeration rowcres08sig01Enum = cres08si.getROWCRES08SIG01_ARRAY().enumerateROWCRES08SIG01(); rowcres08sig01Enum
                                                                                                                                .hasMoreElements();) {
            ROWCRES08SIG01 rowcres08sig01 = (ROWCRES08SIG01) rowcres08sig01Enum.nextElement();
            if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(reqFuncCd)) {
              // cres41d
              if (0 == resourceChrctrDAO.updateResourceChrctr(cres08si.getUlIdResource(),
                                                              rowcres08sig00.getSzCdRsrcCharChrctr(),
                                                              rowcres08sig00.getCCdRsrcCharSex(),
                                                              rowcres08sig00.getUNbrRsrcCharMinMAge(),
                                                              rowcres08sig00.getUNbrRsrcCharMaxMAge(),
                                                              rowcres08sig00.getUNbrRsrcCharMinFAge(),
                                                              rowcres08sig00.getUNbrRsrcCharMaxFAge(),
                                                              cres08si.getSzCdRsrcCharService(),
                                                              cres08si.getSzCdRsrcCharRegion(),
                                                              rowcres08sig01.getUNbrRsrcCharMinMAge(),
                                                              rowcres08sig01.getUNbrRsrcCharMaxMAge(),
                                                              rowcres08sig01.getUNbrRsrcCharMinFAge(),
                                                              rowcres08sig01.getUNbrRsrcCharMaxFAge(),
                                                              rowcres08sig01.getSzCdRsrcCharChrctr())) {
                throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
              }
            } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(reqFuncCd)) {
              // cres41d
              if (0 == resourceChrctrDAO.deleteResourceChrctrByIdResource(cres08si.getUlIdResource(),
                                                                          cres08si.getSzCdRsrcCharService(),
                                                                          cres08si.getSzCdRsrcCharRegion(),
                                                                          rowcres08sig01.getUNbrRsrcCharMinMAge(),
                                                                          rowcres08sig01.getUNbrRsrcCharMaxMAge(),
                                                                          rowcres08sig01.getUNbrRsrcCharMinFAge(),
                                                                          rowcres08sig01.getUNbrRsrcCharMaxFAge(),
                                                                          rowcres08sig01.getSzCdRsrcCharChrctr())) {
                throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
              }
            } else {
              // cres41d
              throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
            }
          }
        }
      }
    }
    return cres08so;
  }

}
