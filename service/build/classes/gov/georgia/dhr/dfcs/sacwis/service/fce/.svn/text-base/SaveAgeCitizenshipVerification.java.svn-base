package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AgeCitizenshipSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AgeCitizenshipSaveSO;

import java.io.IOException;

public interface SaveAgeCitizenshipVerification {
  
  /**
   * This method updates the FCE_ELIGIBILITY table with all of the checked method of verification
   * on the Citizenship Identity page. It creates a list of all the codes tables for each
   * verification section. it gets the list of checked codes for each section and map it to a 
   * method in the FceApplicationDB and FceEligibilityDB objects and invoke those methods.
   * It removes the checked codes from the map containing all codes and iterate thru the remainder
   * of the codes and sets them to an empty string
   *
   * @param ageCitizenshipSaveSI the input object 
   * 
   * @return AgeCitizenshipSaveSO
   */
  public AgeCitizenshipSaveSO saveCheckedAgeCitizenshipVerification (AgeCitizenshipSaveSI ageCitizenshipSaveSI) throws IOException, LookupException;

}
