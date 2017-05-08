package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.db.MailCode;

/**
 * <pre>
 * Change History:
 * Date       User              Description
 * --------   ----------------  --------------------------------------------------
 * 02/09/2012 schoi             STGAP00017831: MR-102 Added new methods findMailCodeByCdCountyForSvcAuthFormPmtCntyField
 *                              and findMailCodeByCdCountyForSvcAuthFormLegalCntyField
 * </pre>
 */

public interface MailCodeDAO {
  
  /**
   * Retrieves the county code of a city (cdCityTexCnty) from City table for the Case Search window.
   *
   * @param addrMailCodeCity
   * @return List of String objects
   */
  @SuppressWarnings({"unchecked"})
  List<String> findCdCityGACountyFromCityByNmCity(String addrMailCodeCity);
  
  /**
   * Find mail code data, which contains office address and phone by county, for offices that handle Adoption forms. This 
   * method retrieves data through a filtered list of offices identified by the SSAU.
   * @param cdCounty
   * @return
   */
  public Object[] findMailCodeByCdCountyForSSAU(String cdCounty);

  
  // STGAP00017831: MR-102
  /**
   * Find Mail Code by cdCounty; this query is for Payment County field on the Service Authorization form
   * @param cdCounty
   * @return
   */
  @SuppressWarnings({"unchecked"})
  Object[] findMailCodeByCdCountyForSvcAuthFormPmtCntyField(String cdCounty);
  
  // STGAP00017831: MR-102
  /**
   * Find Mail Code by cdCounty; this query is for Legal County field on the Service Authorization form
   * @param cdCounty
   * @return
   */
  @SuppressWarnings({"unchecked"})
  Object[] findMailCodeByCdCountyForSvcAuthFormLegalCntyField(String cdCounty);  
  
}



