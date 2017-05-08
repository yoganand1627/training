package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EligibilitySummaryDB;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSupRefOutboundSI;
import java.util.Set;

public interface EligibilitySummary {
  public EligibilitySummaryDB read(long idStage, long idCase, long idEvent, long idLastUpdatePerson)
          throws EjbValidationException;

  public void save(EligibilitySummaryDB eligibilitySummaryDB, Set ignoreMessages) throws EjbValidationException;

  public void saveChildSupReferralOutbound(CSupRefOutboundSI cSupRefOutboundSI);
  
  public void delete(EligibilitySummaryDB eligibilitySummaryDB) throws EjbValidationException;
}