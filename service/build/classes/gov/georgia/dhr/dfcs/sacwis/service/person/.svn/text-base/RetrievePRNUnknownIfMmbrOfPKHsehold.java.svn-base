/**
 * Created on October 02, 2009 at 4:22:19 PM by Herve Jean-Baptiste
 */
package gov.georgia.dhr.dfcs.sacwis.service.person;

import java.util.List;
import java.util.Map;

public interface RetrievePRNUnknownIfMmbrOfPKHsehold {
  /**
   * Retrieves persons that are principals on a stage where it's unknown if they are
   * a member of the primary caretaker's household. This field is a dropdown on the Person Detail 
   * Page named Member of Primary Caretaker's Household. If Unknown has been selected for a principal
   * for the particular stage passed, then the person's ID, full name, role and relationship will be 
   * added to the list to be returned
   *
   * @param idStage 
   * @return List<Map>
   */
  
  List<Map> retrievePRNUnknownIfMmbrOfPKHsehold(int idStage, String cdPersonType);
}
