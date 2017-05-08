package gov.georgia.dhr.dfcs.sacwis.service.common;

import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;

import java.util.Set;

/**
 * Interface for the PersonUtility EJB.
 *
 * @see gov.georgia.dhr.dfcs.sacwis.service.common.PersonUtilityDao
 */
public interface PersonUtility {
  /** @see gov.georgia.dhr.dfcs.sacwis.service.common.PersonUtilityDao */
  public boolean isPersonInOneOfThesePrograms(int personId, Set<String> hashSet);

  public RaceEthnicityBean getPersonRaceEthnicity(int personId);
}