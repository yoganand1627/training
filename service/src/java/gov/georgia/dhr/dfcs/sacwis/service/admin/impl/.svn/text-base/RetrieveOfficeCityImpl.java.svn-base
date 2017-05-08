package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.MailCodeDAO;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveOfficeCity;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN87SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN87SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.Code1OutStruct_ARRAY;


/*Change History:
  **  Date        User              Description
  **  --------    ----------------  --------------------------------------------------
  **  03/19/2008  Corey Harden      Changed the code so that it would accept more that one
  *                                 county 
  *                                 
  *
*/

public class RetrieveOfficeCityImpl extends BaseServiceImpl implements RetrieveOfficeCity {

  private MailCodeDAO mailCodeDAO = null;

  public void setMailCodeDAO(MailCodeDAO mailCodeDAO) {
    this.mailCodeDAO = mailCodeDAO;
  }

  public CCMN87SO findCountiesLinkedToCity(CCMN87SI ccmn87si) {
    CCMN87SO ccmn87so = new CCMN87SO();
    List<String> countyList = mailCodeDAO.findCdCityGACountyFromCityByNmCity(ccmn87si.getCode1InStruct().getSzAddrCity());
    int size = countyList.size();
    
    //Iterates through the list of counties and saves them in a ccmn87so object
    if (countyList != null) {
      Code1OutStruct_ARRAY code1OutStruct_array = new Code1OutStruct_ARRAY();
      code1OutStruct_array.setUlRowQty(size);
      for (Iterator<String> it = countyList.iterator(); it.hasNext();) {
        Code1OutStruct code1OutStruct = new Code1OutStruct();
        String countyName = it.next();  
        code1OutStruct.setSzSysCode1CntyCode(countyName);
        code1OutStruct_array.addCode1OutStruct(code1OutStruct);
      }
      ccmn87so.setCode1OutStruct_ARRAY(code1OutStruct_array);
    }
    return ccmn87so;
  }
}