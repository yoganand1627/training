package gov.georgia.dhr.dfcs.sacwis.service.common;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;

public interface CheckIfUserHasRight {
  public static final int MAX_NUM_ATTRIBUTES = ArchitectureConstants.MAX_NUM_ATTRIBUTES;
  /**
   * <p>This Interface method determines the User Right prior to approval.  
   * A new security attribute is added for Authorized to Approve
   *This will be given to those profiles of Supervior and above.  Anyone with this attibute
   *or anyone who is a designee of someone with this attribute will be allowed to be selected for 
   *approval  
   *STGAP00004839:  
   * @param IdPerson  securityAttribute
   * @return boolean indicating if USER has approval right attribute
   */
  public boolean determineIfUserHasRight(int idPerson, String securityAttribute);
  /**
   * STGAP00010625 
   * This method retrieves all security attributes from all profile of a user. 
   * @param idPerson
   * @return array of 1s and 0s, each position is mapped to an security attribute in UserProfile.java
   * 1 mean user has that attribute, 0 mean user does not have it
   */
  public int[] retrieveUserRights(int idPerson);  
}
