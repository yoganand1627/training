package gov.georgia.dhr.dfcs.sacwis.service.adoexchange;

import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterHomeConversionSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FosterHomeConversionSO;

public interface RetrieveFosterHomeConversion {
  /**
   * This service retrieves information for the Foster Home Conversion
   * 
   * @param FosterHomeConversionSaveSI
   * @return A populated FosterHomeConversionSO object.
   */
  public FosterHomeConversionSO retrieveFosterHomeConversion(FosterHomeConversionSI fosterHomeConversionSI);
  
  /**
   * returns true id the resource has a approved foster home conversion
   * 
   * @param resource id
   * @return Boolean .
   */
  public Boolean hasAprvFosterHomeConversion(Integer idResource);
  
  /**
   * returns true id the fad case resource has a approved foster home conversion
   * 
   * @param resource id
   * @return Boolean .
   */
  public Boolean hasAprvFosterHomeConversionForCase(Integer idCase);
  
}
