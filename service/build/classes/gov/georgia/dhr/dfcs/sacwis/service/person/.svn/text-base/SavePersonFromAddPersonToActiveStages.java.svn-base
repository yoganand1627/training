package gov.georgia.dhr.dfcs.sacwis.service.person;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI_ADD_PERSON_TO_STAGES_ARRAY;

/** @author Seung-eun (Caroline) Choi, September 7, 2011 */

public interface SavePersonFromAddPersonToActiveStages {

  /**
   * This service saves records from the Add Person to Active Stages section on the Person Detail page
   * 
   * @param idPerson
   * @param idStage
   * @param CINV05SI_ADD_PERSON_TO_STAGES_ARRAY
   * 
   */
  public void savePersonFromAddPersonToActiveStages(
                                                    int idPerson,
                                                    int idStage,
                                                    int idCase,
                                                    CINV05SI_ADD_PERSON_TO_STAGES_ARRAY cinv05si_add_person_to_stages_array,
                                                    Date dtAssigned, Date dtUnassigned, String personSearchParameter)
                                                                                                                     throws ServiceException;

}