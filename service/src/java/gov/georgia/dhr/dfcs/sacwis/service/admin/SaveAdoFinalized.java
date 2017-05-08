package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB68SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB68SO;


public interface SaveAdoFinalized {
  public CSUB68SO saveAdoFinalized(CSUB68SI csub68si);
}