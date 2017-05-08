package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.OfficeDAO;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN40SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN40SO;
import gov.georgia.dhr.dfcs.sacwis.db.Office;

public class RetrieveOfficeNameImpl extends BaseServiceImpl
        implements gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveOfficeName {

  private OfficeDAO officeDAO = null;

  public void setOfficeDAO(OfficeDAO officeDAO) {
    this.officeDAO = officeDAO;
  }

  public CCMN40SO retrieveOfficeName(CCMN40SI ccmn40si) throws ServiceException {
    CCMN40SO ccmn40so = new CCMN40SO();
    // Call ccmna5d
    Map officeMap = officeDAO.findOfficeByCdOfficeProgramCdOfficeRegionCdOfficeMail(ccmn40si.getSzCdOfficeProgram(),
                                                                                    ccmn40si.getSzCdOfficeRegion(),
                                                                                    ccmn40si.getSzAddrMailCode());
    if (officeMap == null) {
      throw new ServiceException(Messages.MSG_CMN_INVALID_OFFICE);
    }
    ccmn40so.setUlIdOffice((Integer) officeMap.get("idOffice") != null ? (Integer) officeMap.get("idOffice") : 0);
    ccmn40so.setSzNmOfficeName((String) officeMap.get("nmOfficeName"));
    
//    Office office = officeDAO.findOfficeByIdOffice(ccmn40si.getUlIdOffice());
//    if (office == null) {
//          throw new ServiceException(Messages.MSG_CMN_INVALID_OFFICE);
//    }
//    ccmn40so.setUlIdOffice(office.getIdOffice());
//    ccmn40so.setSzNmOfficeName(office.getNmOfficeName());
    return ccmn40so;
  }

}
