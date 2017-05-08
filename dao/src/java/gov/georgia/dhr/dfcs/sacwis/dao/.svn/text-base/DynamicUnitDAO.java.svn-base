/**
 * Created on May 4, 2006 at 12:02:41 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

public interface DynamicUnitDAO {
  /**
   * This DAO retrieves information from the unit table, the number of the parent unit associated with that row and the
   * full name of the approver. The cdUnitProgram and cdUnitRegion parameters are required; the nbrUnit parameter is
   * optional.
   * <p/>
   * The return value is list of Object arrays with the following values:
   * <pre>
   * String nbrUnitParent = szScrNbrUnitParent = row[0];
   * String nmPersonFull = szNmPersonFull = row[1];
   * String nbrUnit = szNbrUnit = row[2];
   * int idUnit = ulIdUnit = row[3];
   * int idPerson = ulIdPerson = row[4]
   * int idUnitParent = ulIdUnitParent = row[5];
   * String cdUnitSpecialization = szCdUnitSpecialization = row[6];
   * </pre>
   *
   * @param cdUnitCounty
   * @param cdUnitRegion
   * @param nbrUnit
   * @return See description..
   */
  List<Object[]> findUnits(String cdUnitCounty, String cdUnitRegion, String nbrUnit);
}
