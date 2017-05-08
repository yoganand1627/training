/**
 * Created on Mar 25, 2006 at 2:12:06 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.City;

public interface CityDAO {

  /**
   * Retrieves the county code of a city (cdCityTexCnty) from City table for the Case Search window.
   *
   * @param addrMailCodeCity
   * @return List of String objects
   */
  @SuppressWarnings({"unchecked"})
  List<String> findCdCityTexCountyFromCityByNmCity(String addrMailCodeCity);

}
