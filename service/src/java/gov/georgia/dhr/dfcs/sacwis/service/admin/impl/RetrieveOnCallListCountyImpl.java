package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.dao.OnCallCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveOnCallListCounty;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMNH7SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMNH7SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNH7DO_ARRAY;

public class RetrieveOnCallListCountyImpl extends BaseServiceImpl implements RetrieveOnCallListCounty {

  private OnCallCountyDAO onCallCountyDAO = null;

  public void setOnCallCountyDAO(OnCallCountyDAO onCallCountyDAO) {
    this.onCallCountyDAO = onCallCountyDAO;
  }

  public CCMNH7SO retrieveOnCallListCounty(CCMNH7SI ccmnh7si) {
    CCMNH7SO ccmnh7so = new CCMNH7SO();

    List<Map> onCallCountieList =
            onCallCountyDAO.findOnCallCountyByIdOnCallCountyCdOnCallRegion(ccmnh7si.getCdIdOnCall(),
                                                                           ccmnh7si.getSzCdRegion());

    ROWCCMNH7DO_ARRAY ccmnh7do_array = new ROWCCMNH7DO_ARRAY();
    ArchOutputStruct archOutputStruct = new ArchOutputStruct();
    int i = 1;
    for (Iterator<Map> it = onCallCountieList.iterator(); it.hasNext();) {
      Map map = it.next();
      ROWCCMNH7DO rowccmnh7do = new ROWCCMNH7DO();
      rowccmnh7do.setSzCdOnCallCounty((String) map.get("cdOnCallCounty"));
      // Not set in the service, oddly.
      // rowccmnh7do.setDtLastUpdate(DateHelper.toCastorDate((Date) map.get("dtLastUpdate")));
      ccmnh7do_array.addROWCCMNH7DO(rowccmnh7do);
      archOutputStruct.setUlRowQty(i++);
    }
    ccmnh7so.setROWCCMNH7DO_ARRAY(ccmnh7do_array);
    ccmnh7so.setArchOutputStruct(archOutputStruct);
    return ccmnh7so;
  }

  public CCMNH7SO retrieveOnCallRegion(CCMNH7SI ccmnh7si) {
    CCMNH7SO ccmnh7so = new CCMNH7SO();
    String onCallCounty = Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, ccmnh7si.getSzCdOnCallCounty());
    ROWCCMNH7DO rowccmnh7do = new ROWCCMNH7DO();
    ROWCCMNH7DO_ARRAY ccmnh7do_array = new ROWCCMNH7DO_ARRAY();
    if (onCallCounty != null) {
      rowccmnh7do.setSzCdOnCallCounty(onCallCounty);
      ccmnh7do_array.addROWCCMNH7DO(rowccmnh7do);
      ccmnh7so.setROWCCMNH7DO_ARRAY(ccmnh7do_array);
    }
    return ccmnh7so;
  }

}
    


