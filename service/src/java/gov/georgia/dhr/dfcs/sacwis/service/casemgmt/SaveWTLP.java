package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.WTLPSaveSI;

public interface SaveWTLP {
  public static final String PRIMARY_CHILD = "PC";
  WTLPSaveSI saveWtlp (WTLPSaveSI wtlpSave);
}