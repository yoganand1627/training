package gov.georgia.dhr.dfcs.sacwis.service.adoexchange.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FosterHomeConvPerLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.RemoveChildFromFosterHomeConversion;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterHomeConversionChildBean;

public class RemoveChildFromFosterHomeConversionImpl extends BaseServiceImpl implements RemoveChildFromFosterHomeConversion {

  private FosterHomeConvPerLinkDAO fosterHomeConvPerLinkDAO;
  
  public FosterHomeConvPerLinkDAO getFosterHomeConvPerLinkDAO() {
    return fosterHomeConvPerLinkDAO;
  }

  public void setFosterHomeConvPerLinkDAO(FosterHomeConvPerLinkDAO fosterHomeConvPerLinkDAO) {
    this.fosterHomeConvPerLinkDAO = fosterHomeConvPerLinkDAO;
  }

  public int removeChildFromFosterHomeConversion(FosterHomeConversionChildBean fosterHomeConversionChildBean) {
    
    int  idFosterHomeConvPerLink = fosterHomeConversionChildBean.getIdFosterHomeConvPerLink();
    
    fosterHomeConvPerLinkDAO.deleteFosterHomeConvPerLinkByIdFosterHomeConvPerLink(idFosterHomeConvPerLink);
    
     return 1;
  }

}
