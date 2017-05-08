/**
 * Created on October 02, 2009 at 4:25:59 PM by Herve Jean-Baptiste
 */
package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

/**
 * Retrieves persons that are principals on a stage where it's unknown if they are
 * a member of the primary caretaker's household. This field is a dropdown on the Person Detail 
 * Page named Member of Primary Caretaker's Household. If Unknown has been selected for a principal
 * for the particular stage passed, then the person's ID, full name, role and relationship will be 
 * added to the list to be returned
 * <pre>
 *  Change History:
 *  Date        User           Description
 *  --------    --------       -------------------------------------------------------------------------------------
 *  
 *   
 */
/**
 * a member of the primary caretaker's household. This field is a dropdown on the Person Detail 
 * Page named Member of Primary Caretaker's Household. If Unknown has been selected for a principal
 * for the particular stage passed, then the person's ID, full name, role and relationship will be 
 * added to the list to be returned.
 * 
 * <pre>
 *  Change History:
 *  Date        User           Description
 *  --------    --------       -------------------------------------------------------------------------------------
 *  10/02/2009  hjbaptiste     STGAP00015485: Initial Creation
 *                             Calling the method findUnknownMbrPkHshldIdPersonByIdStageAndCdStagePersType() to retrieve any 
 *                             principals who are unknown if they are members of the primary caretaker's household
 *
 **/


import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrievePRNUnknownIfMmbrOfPKHsehold;

import java.util.List;
import java.util.Map;

public class RetrievePRNUnknownIfMmbrOfPKHseholdImpl extends BaseServiceImpl implements
                                                               RetrievePRNUnknownIfMmbrOfPKHsehold {

  private static final String PRINCIPAL = CodesTables.CPRSNALL_PRN;
 
  public StagePersonLinkDAO stagePersonLinkDAO = null;
  
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  
  @SuppressWarnings( { "unchecked" })
  public List<Map> retrievePRNUnknownIfMmbrOfPKHsehold(int idStage, String cdPersonType) {
    List<Map> unKnownIfMemberOfPKHshld = null;
    
    unKnownIfMemberOfPKHshld = stagePersonLinkDAO.findUnknownMbrPkHshldIdPersonByIdStageAndCdStagePersType(idStage, PRINCIPAL);
    return unKnownIfMemberOfPKHshld;
  }

}
