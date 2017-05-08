package gov.georgia.dhr.dfcs.sacwis.service.fad.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.service.fad.CheckDocExistsForNonCompliance;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NonComplianceSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NonComplianceSO;

public class CheckDocExistsForNonComplianceImpl extends BaseServiceImpl implements CheckDocExistsForNonCompliance {

  public NonComplianceSO checkDocExistsForNonCompliance(NonComplianceSI input) {
    NonComplianceSO nonComplianceSO = new NonComplianceSO();
    String sysTxtTableName = Lookup.simpleDecodeSafe(CodesTables.CEVNTTBL, input.getCdNonCompliance());

    Date narrativeDate = commonDAO.findDtLastUpdate(sysTxtTableName, input.getIdEvent());

    if (!DateHelper.isNull(narrativeDate)){
      nonComplianceSO.setDtFormLastDate(narrativeDate);
    }else{
      nonComplianceSO.setDtFormLastDate(null);
    }
    return nonComplianceSO;
  }

}
