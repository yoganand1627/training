package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

import gov.georgia.dhr.dfcs.sacwis.dao.AddressPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.RetrievePersonAddressPersonPhone;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV30SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV30SO;

public class RetrievePersonAddressPersonPhoneImpl extends BaseServiceImpl implements RetrievePersonAddressPersonPhone {
  private AddressPersonLinkDAO addressPersonLinkDAO = null;

  public void setAddressPersonLinkDAO(AddressPersonLinkDAO addressPersonLinkDAO) {
    this.addressPersonLinkDAO = addressPersonLinkDAO;
  }

  public CINV30SO retrievePersonAddressPersonPhone(CINV30SI cinv30si) {
    CINV30SO cinv30so = new CINV30SO();
    // Calling cinv46d
    List<Object[]> mapList = addressPersonLinkDAO.findPersonAddressAndPersonPhone(cinv30si.getUlIdPerson());
    if (mapList != null) {
      for (Iterator<Object[]> it = mapList.iterator(); it.hasNext();) {
        Object[] map = it.next();
        cinv30so.setSzAddrProfAssmtStLn1((String) map[0]);
        cinv30so.setSzAddrProfAssmtStLn2((String) map[1]);
        cinv30so.setSzAddrProfAssmtCity((String) map[2]);
        cinv30so.setSzAddrProfAssmtZip((String) map[3]);
        cinv30so.setSzCdProfAssmtCounty((String) map[4]);
        cinv30so.setSzAddrProfAssmtState((String) map[5]);
        cinv30so.setLNbrPhone((String) map[6]);
        cinv30so.setLNbrPhoneExtension((String) map[7]);
      }
    }
    return cinv30so;
  }

}
