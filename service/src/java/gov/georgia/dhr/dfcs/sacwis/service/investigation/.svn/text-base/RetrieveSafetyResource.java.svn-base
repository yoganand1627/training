package gov.georgia.dhr.dfcs.sacwis.service.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FCCPFamilyDetailSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceRetrieveSO;

public interface RetrieveSafetyResource {

  /**
   * Retrieves information for display of the Safety Resource Detail page from the database using 
   * a SafetyResourceRetrieveSI bean.
   *
   * @param safetyResourceChildRetrieveSI bean
   * @return SafetyResourceRetrieveSO bean
   * @author Patrick Coogan
   * @throws ServiceException
   */  
   SafetyResourceRetrieveSO retrieveSafetyResource(SafetyResourceRetrieveSI safetyResourceRetrieveSI);
   
   /**
    * Retrieves the data for Safety Resource Form  
    * @param safetyResourceRetrieveSI
    * @return byte[]
    */
   byte[] retrieveSafetyRsrcForm(SafetyResourceRetrieveSI safetyResourceRetrieveSI);

}