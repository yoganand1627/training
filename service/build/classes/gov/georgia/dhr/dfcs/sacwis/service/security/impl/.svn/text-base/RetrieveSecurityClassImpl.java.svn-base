package gov.georgia.dhr.dfcs.sacwis.service.security.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.SecurityClassDAO;
import gov.georgia.dhr.dfcs.sacwis.db.SecurityClass;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.security.RetrieveSecurityClass;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC12SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC12SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC12SOG00_ARRAY;

public class RetrieveSecurityClassImpl extends BaseServiceImpl implements RetrieveSecurityClass {
  private SecurityClassDAO securityClassDAO = null;

  public void setSecurityClassDAO(SecurityClassDAO securityClassDAO) {
    this.securityClassDAO = securityClassDAO;
  }

  public CARC12SO retrieveSecurityClass(CARC12SI carc12si) {
    CARC12SO carc12so = new CARC12SO();
    List<SecurityClass> securityClasslist = securityClassDAO.findListAllSecurityClasses();
    ROWCARC12SOG00_ARRAY rowcarc12sogoo_array = new ROWCARC12SOG00_ARRAY();
    for (Iterator<SecurityClass> it = securityClasslist.iterator(); it.hasNext();) {
      SecurityClass securityClass = it.next();
      ROWCARC12SOG00 rowcarc12sogoo = new ROWCARC12SOG00();
      rowcarc12sogoo.setSzNmSecurityClass(securityClass.getCdSecurityClassName());
      rowcarc12sogoo.setSzTxtSecurityClassProfil(securityClass.getTxtSecurityClassProfil());
      rowcarc12sogoo.setTsLastUpdate(securityClass.getDtLastUpdate());
      rowcarc12sogoo.setCIndRestrict(securityClass.getIndRestrict());
      rowcarc12sogoo_array.addROWCARC12SOG00(rowcarc12sogoo);
    }
    carc12so.setROWCARC12SOG00_ARRAY(rowcarc12sogoo_array);
    return carc12so;
  }

}
