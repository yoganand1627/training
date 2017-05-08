package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import java.util.Enumeration;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.RsrcLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.RsrcLink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.SaveSubcontractorList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON16SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON16SO;

public class SaveSubcontractorListImpl extends BaseServiceImpl implements SaveSubcontractorList {

  private RsrcLinkDAO rsrcLinkDAO = null;

  public void setRsrcLinkDAO(RsrcLinkDAO rsrcLinkDAO) {
    this.rsrcLinkDAO = rsrcLinkDAO;
  }

  public CCON16SO saveUpdateOrDeleteRscrcLink(CCON16SI ccon16si) throws ServiceException {
    for (Enumeration rowccon16sig00Enum = ccon16si.getROWCCON16SIG00_ARRAY().enumerateROWCCON16SIG00(); rowccon16sig00Enum
                                                                                                                           .hasMoreElements();) {
      ROWCCON16SIG00 rowccon16sig00 = (ROWCCON16SIG00) rowccon16sig00Enum.nextElement();
      // populationg the object to be passed in to RsrcLinkDAO
      RsrcLink rsrcLink = new RsrcLink();
      String cReqFuncCd = rowccon16sig00.getSzCdScrDataAction();
      // Call DAO CAUD26D
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd) || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
        if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)){
          rsrcLink = getPersistentObject(RsrcLink.class, rowccon16sig00.getUIdRsrcLink());
        }
        rsrcLink.setCdRsrcLinkService(rowccon16sig00.getSzCdRsrcLinkService());
        rsrcLink.setCdRsrcLinkType(rowccon16sig00.getSzCdRsrcLinkType());

        if (rowccon16sig00.getUIdRsrcLinkChild() != 0) {
          // capsResourceChild.setIdResource(rowccon16sig00.getUIdRsrcLinkChild());
          CapsResource capsResourceChild = getPersistentObject(CapsResource.class, rowccon16sig00.getUIdRsrcLinkChild());

          rsrcLink.setCapsResourceByIdRsrcLinkChild(capsResourceChild);
        }

        if (rowccon16sig00.getUIdRsrcLinkParent() != 0) {
          // capsResourceChild.setIdResource(rowccon16sig00.getUIdRsrcLinkChild());
          CapsResource capsResourceParent = getPersistentObject(CapsResource.class,
                                                                rowccon16sig00.getUIdRsrcLinkParent());

          rsrcLink.setCapsResourceByIdRsrcLinkParent(capsResourceParent);
        }

        rsrcLinkDAO.saveRsrcLink(rsrcLink);
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
        rsrcLink = getPersistentObject(RsrcLink.class, rowccon16sig00.getUIdRsrcLink());
        rsrcLink.setDtLastUpdate(rowccon16sig00.getTsLastUpdate());
        rsrcLinkDAO.deleteRsrcLink(rsrcLink);
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }
    return new CCON16SO();
  }
}
