package gov.georgia.dhr.dfcs.sacwis.service.fad.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.service.fad.RetrieveResourceHomeType;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

public class RetrieveResourceHomeTypeImpl extends BaseServiceImpl implements RetrieveResourceHomeType {
  private CapsResourceDAO capsResourceDAO = null;
  
  private static final String DFCS_FA_HOME = "DFCS F/A Home";

  private static final String NON_DFCS_FA_HOME = "Non DFCS F/A Home";
  
  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }
  
  public String retrieveResourceHomeType(int idCase) {
    String homeType = "";
    CapsResource capsResource = capsResourceDAO.findCapsResourceByIdCase(idCase);
    if (capsResource.getIndRsrcNonDfcs() != null && capsResource.getIndRsrcNonDfcs().equals("Y")) {
      homeType = NON_DFCS_FA_HOME;
    } else {
        homeType = DFCS_FA_HOME;
    }
    return homeType;
  }


}
