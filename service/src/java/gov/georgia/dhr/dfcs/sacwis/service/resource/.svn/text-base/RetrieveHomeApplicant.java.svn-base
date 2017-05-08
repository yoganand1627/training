package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.structs.input.HomeApplicantRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.HomeApplicantRetrieveSO;

/**
 * @author ade.odutayo
 *
 */
public interface RetrieveHomeApplicant {
  /**
   * <p>Function codes to indicate what type of retrieval to perform.</p> 
   */
  String RETRIEVE_RESOURCE = "R";
  String RETRIEVE_HISTORY = "H";
  String PRGMSOFINTTYPE = CodesTables.CPRGMINT;
  String SRCOFINQTYPE = CodesTables.CFASRCIN;
  String INFCVRDTYPE = CodesTables.CINFCVRD;
  
  /** 
   *<p></p>
   */
  public HomeApplicantRetrieveSO  retrieveHomeApplicantInfo( HomeApplicantRetrieveSI homeApplicantRetrieveSI);
}
