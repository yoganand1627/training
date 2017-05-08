package gov.georgia.dhr.dfcs.sacwis.service.resource;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveFAHomeSupervisorSI;


/**
 * This is a service to save the Home Information page when the supervisor is clicking the save button 
 * during a pending home closure.  It only saves the closure information and the legal home section
 * 
 *   param saveFaHomeSupervisorSI 
 *  * @author courtney.d.wells
 *
 */
public interface SaveFAHomeSupervisor {
  
 public static final String ADOPTION_SUB_FINAL = "AFN";
  
 public static final String ADOPTION_SUB_NOT_FINAL = "AFS";
  
  /**
   * This method is saving the Home Information page by receiving the saveFAHomeSupervisorSI
   * 
   *   @param saveFaHomeSupervisorSI 
   *  * @return int
   *
   */
  public int saveFAHomeSupervisor(SaveFAHomeSupervisorSI saveFAHomeSupervisorSI) throws ServiceException;
}