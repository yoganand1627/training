package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;


/*** Change History:
  **  Date        User              Description
  **  --------    ----------------  --------------------------------------------------
  **  03/17/2008  Corey Harden      wrote code to uppercase first letter in addrMailCodeCity 
  *                                 to set the ulRowQty for the struct.
  *
*/
import gov.georgia.dhr.dfcs.sacwis.dao.CityDAO;

import org.hibernate.Query;

/*Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 **  03/19/2008  Corey Harden      Reverted CityDAOImpl back to original code
 *
 *
*/
public class CityDAOImpl extends BaseDAOImpl implements CityDAO {

  @SuppressWarnings({"unchecked"})
  public List<String> findCdCityTexCountyFromCityByNmCity(String nmCity) {

    nmCity = StringHelper.getSafeString(nmCity);
    
    
    Query query = getSession().createQuery("select c.cdCityTexCnty" +
                                           "  from City c " +
                                           " where nmCity = :nmCity");
    query.setString("nmCity", nmCity);
    return (List<String>) query.list();
  }

}
