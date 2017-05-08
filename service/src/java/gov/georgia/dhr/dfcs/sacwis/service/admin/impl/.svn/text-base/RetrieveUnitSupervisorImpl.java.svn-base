package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveUnitSupervisor;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN08SO;

public class RetrieveUnitSupervisorImpl extends BaseServiceImpl implements RetrieveUnitSupervisor {
  private UnitDAO unitDAO = null;

  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }

  public CCMN08SO findUnitSupervisorName(CCMN08SI ccmn08si) throws ServiceException {

    CCMN08SO ccmn08so = new CCMN08SO();
    //Unit unit = new Unit();
    //Unit unitWithSup;
    //Unit unitNoSup = null;
    // ccmn34dQUERYdam

    if ("".equals(ccmn08si.getSzCdCounty())) {
      ccmn08si.setSzCdCounty("XXX");
    }
    Unit unit = unitDAO.findUnitFromUnitAndPersonByCdCountyCdUnitRegionNbrUnit(ccmn08si.getSzCdCounty(),
                                                                          ccmn08si.getSzCdUnitRegion(),
                                                                             ccmn08si.getSzNbrUnit());
    //unit = unitWithSup;

    // if unitWithSup is null, perform the following. It is possible that
    // no unit was returned because the new unit has no Unit Approver.
    if (unit == null) {
      unit = unitDAO
                    .findUnitFullRowByCdCountyCdUnitRegionNbrUnit(ccmn08si.getSzCdCounty(),
                                                                  ccmn08si.getSzCdUnitRegion(), ccmn08si.getSzNbrUnit());

      //unit = unitNoSup;
      if(unit == null) {
        throw new ServiceException(Messages.MSG_CMN_INVALID_UNIT);
      }
    } 

    ccmn08so.setSzCdUnitProgram(unit.getCdUnitProgram());
    ccmn08so.setSzCdUnitRegion(unit.getCdUnitRegion());
    ccmn08so.setSzNbrUnit(unit.getNbrUnit());
    ccmn08so.setUlIdUnit(unit.getIdUnit());
    Person unitApprover = unit.getPerson();
    if(unitApprover != null) {
      ccmn08so.setUlIdPerson(unitApprover.getIdPerson());
      ccmn08so.setSzNmPersonFull(unitApprover.getNmPersonFull());
    }
    ccmn08so.setTsLastUpdate(unit.getDtLastUpdate());

    return ccmn08so;
  }
}
