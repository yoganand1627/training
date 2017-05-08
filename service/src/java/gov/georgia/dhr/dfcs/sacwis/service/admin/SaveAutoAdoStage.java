package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN35SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN35SO;

public interface SaveAutoAdoStage {
  CCMN35SO saveAutoAdoStage(CCMN35SI ccmn35si);
}
