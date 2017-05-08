package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveUnitID;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN47SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN47SO;

public class RetrieveUnitIDImpl extends BaseServiceImpl implements RetrieveUnitID {

  private UnitDAO unitDAO = null;

  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }

  public CCMN47SO retrieveUnitID(CCMN47SI ccmn47si) throws ServiceException {
    CCMN47SO ccmn47so = new CCMN47SO();
    Unit unit = unitDAO.findUnitFullRowByCdCountyCdUnitRegionNbrUnit(ccmn47si.getSzCdUnitCounty(),
                                                                     ccmn47si.getSzCdUnitRegion(),
                                                                     ccmn47si.getSzNbrUnit());

    if (unit == null) {
        throw new ServiceException(Messages.MSG_NO_UNIT_FOUND);
    }
    
    ccmn47so.setUlIdUnit(unit.getIdUnit());

    return ccmn47so;
  }
}
