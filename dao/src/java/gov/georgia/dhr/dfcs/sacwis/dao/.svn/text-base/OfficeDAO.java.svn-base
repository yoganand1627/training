/**
 * Created on Mar 25, 2006 at 3:05:05 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.Office;

public interface OfficeDAO {

  static final String YES_IND = "Y";

  /**
   * This selects a row from Office given the idOffice. <p/>
   * 
   * @param idOffice
   * @return Office
   */
  Office findOfficeByIdOffice(int idOffice);
  
  String findOfficeCityByCdCountyIdOffice(int idOffice);

  /**
   * This DAM returns ID OFFICE and NM OFFICE NAME from the OFFICE table when passed CD OFFICE PROGRAM, CD OFFICE REGION
   * and CD OFFICE MAIL
   * 
   * @param cdOfficeProgram
   * @param cdOfficeRegion
   * @param cdOfficeMail
   * @return keys idOffice, nmOfficeName
   */
  @SuppressWarnings( { "unchecked" })
  Map findOfficeByCdOfficeProgramCdOfficeRegionCdOfficeMail(String cdOfficeProgram, String cdOfficeRegion,
                                                            String cdOfficeMail);

  /**
   * This DAM returns NM OFFICE NAME, OFFICE PHONE AND OFFICE PHONE EXT from the OFFICE table when passed ID STAGE, and
   * IND PRIMARY
   * 
   * @param idStage
   * @param indPrimary
   * @return nmOfficeName, nbrOfficePhone, nbrOfficePhoneExt
   */
  @SuppressWarnings( { "unchecked" })
  Object[] findOfficeByIdStageAndPrimaryPhone(int idStage);
  
  @SuppressWarnings( { "unchecked" })
  Object[] findOfficeByIdStage(int idStage);
  
  /**
   * This query returns the cdMailCode for the given county
   * @param cdCounty
   * @return cdMailCode
   */
  public String findCdMailCodeByCdCounty(String cdCounty);
  
  /**
   * This query returns the addrMailCodeCounty for the given cdMailCode
   * @param cdMailCode
   * @return
   */
  public String findCdCountyByCdMailCode(String cdMailCode);
  
  /**
   * This DAM returns ID OFFICE and NM OFFICE NAME from the OFFICE table when passed CD OFFICE REGION
   * and CD OFFICE MAIL
   * 
   * @param cdOfficeRegion
   * @param cdOfficeMail
   * @return keys idOffice, nmOfficeName
   */
  @SuppressWarnings( { "unchecked" })
  Map findOfficeByCdOfficeRegionCdOfficeMail(String cdOfficeRegion, String cdOfficeMail);
  
  /**
   * This DAM returns ID OFFICE and NM OFFICE NAME from the OFFICE table when passed CD OFFICE MAIL
   * @param cdOfficeMail
   * @return keys idOffice, nmOfficeName
   */
  public Map findOfficeByCdOfficeMail(String cdOfficeMail);
  
  /**
   * Retrieves the Office Address of an employee given the employee Id.
   *
   * @param idPerson
   * @return String 
   */
  public Map findOffcAddressByIdPerson(int idPerson);
}

