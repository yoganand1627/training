package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveOnCallPhone;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNA1SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNA1SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.LNbrPhone_ARRAY;

public class RetrieveOnCallPhoneImpl extends BaseServiceImpl implements RetrieveOnCallPhone {

  private PersonPhoneDAO personPhoneDAO = null;

  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public CCMNA1SO retrieveOnCallPhone(CCMNA1SI input) {
    CCMNA1SO output = new CCMNA1SO();

    LNbrPhone_ARRAY nbrPhone_array = new LNbrPhone_ARRAY();
    for (Enumeration idPersonEnum = input.getUlIdPerson_ARRAY_CCMNA1SI().enumerateUlIdPerson();
         idPersonEnum.hasMoreElements();) {
      int idPerson = (Integer) idPersonEnum.nextElement();
      // Calling clss76d
      List<Map> personPhoneList = personPhoneDAO.findPersonPhoneByIdPersonAndCdPersonPhoneType(idPerson);

      for (Iterator<Map> it = personPhoneList.iterator(); it.hasNext();) {
        Map map = it.next();
        nbrPhone_array.addLNbrPhone((String) map.get("nbrPersonPhone"));
        nbrPhone_array.addLNbrPhoneExtension((String) map.get("nbrPersonPhoneExtension"));
      }
    }
    output.setLNbrPhone_ARRAY(nbrPhone_array);
    return output;
  }

}
