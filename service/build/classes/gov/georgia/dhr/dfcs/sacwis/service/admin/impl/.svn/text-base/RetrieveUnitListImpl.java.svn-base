package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

//import static gov.georgia.dhr.dfcs.sacwis.web.admin.UnitMaintConversation.UNIT_DETAIL_URL;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicUnitDAO;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveUnitList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN24SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN24SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN24SOG01_ARRAY;

public class RetrieveUnitListImpl extends BaseServiceImpl implements RetrieveUnitList {

  private DynamicUnitDAO dynamicUnitDAO = null;

  public void setDynamicUnitDAO(DynamicUnitDAO dynamicUnitDAO) {
    this.dynamicUnitDAO = dynamicUnitDAO;
  }

  public CCMN24SO retrieveUnitList(CCMN24SI ccmn24si) throws ServiceException {
    CCMN24SO ccmn24so = new CCMN24SO();
    // ccmn35d
    List<Object[]> dynamicUnitList = dynamicUnitDAO.findUnits(ccmn24si.getSzCdUnitCounty(),
                                                              ccmn24si.getSzCdUnitRegion(),
                                                              ccmn24si.getSzNbrUnit());

    ROWCCMN24SOG01_ARRAY rowccmn24so_array = new ROWCCMN24SOG01_ARRAY();
    if (dynamicUnitList != null && !dynamicUnitList.isEmpty()) {
      for (Iterator<Object[]> it = dynamicUnitList.iterator(); it.hasNext();) {
        Object[] dynamicUnit = it.next();
        ROWCCMN24SOG01 rowccmn24sog01 = new ROWCCMN24SOG01();
        rowccmn24sog01.setSzCdUnitSpecialization((String) dynamicUnit[6]);
        rowccmn24sog01.setSzNbrUnit((String) dynamicUnit[2]);
        rowccmn24sog01.setUlIdUnit(getIntSafe(dynamicUnit[3]));
        rowccmn24sog01.setUlIdPerson(getIntSafe(dynamicUnit[4]));
        rowccmn24sog01.setSzNmPersonFull((String) dynamicUnit[1]);
        rowccmn24sog01.setSzScrNbrUnitParent((String) dynamicUnit[0]);
        rowccmn24so_array.addROWCCMN24SOG01(rowccmn24sog01);
      }
    } else if (ccmn24si.getSzNbrUnit() == null) {
      throw new ServiceException(Messages.MSG_CMN_INVALID_UNIT);
    } else {
      throw new ServiceException(Messages.MSG_CMN_UNIT_LIST_INV);
    }
    ccmn24so.setROWCCMN24SOG01_ARRAY(rowccmn24so_array);
    return ccmn24so;
  }
  
  private int getIntSafe(Object o) {
    if(o != null && o instanceof Integer) {
      return ((Integer) o).intValue();
    }
    return 0;
  }
}
  