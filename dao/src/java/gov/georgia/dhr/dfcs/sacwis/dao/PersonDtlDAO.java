/**
 * Created on Mar 25, 2006 at 3:14:12 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.db.PersonDtl;

/**Change History:
*    Date        User              Description
*    --------    ----------------  --------------------------------------------------
*   06/24/2009   bgehlot           STGAP00014329: Added indPKHouseholdMember parameter in method savePersonDtl
*   09/30/2009   bgehlot           STGAP00015485: Removed indPKHshdMember from savePersonDtl
*   08/29/2010   htvo			   MR-067: added new field email to savePersonDtl
*/

public interface PersonDtlDAO {
  /**
   * Retrieves a row from the PersonDtl table for a given idPerson. From cses31d.pc
   * 
   * @param idPerson
   * @return PersonDtl
   */

  PersonDtl findServiceAuthByIdPerson(int idPerson);

  /**
   * Retrieves a row from the PersonDtl table for a given idPerson. From cses31d.pc
   * 
   * @param idPerson
   * @return int
   */
  Integer findIdPersonDtlByIdPerson(int idPerson);

  /**
   * Adds and updates row from the PERSON DTL table
   * 
   * @param personDtl
   */
  void savePersonDtl(PersonDtl personDtl);

  /**
   * Adds and updates row from the PERSON DTL table
   * 
   * @param idPersonDtl
   * @param idPerson
   * @param szTxtMaidenName   
   * @param lQtyPersonWeight
   * @param sQtyPersonHeightFeet
   * @param sQtyPersonHeightInches
   * @param szCdPersonEyeColor
   * @param szCdPersonHairColor
   * @param szCdPersonHighestEduc
   * @param indVerified
   * @param indRsrcHouseholdMember
   * @param indPaternityEst   
   * @param indLegalCust
   * @return int
   */
  int savePersonDtl(int idPersonDtl, int idPerson, String szTxtMaidenName, int lQtyPersonWeight,
                    int sQtyPersonHeightFeet, int sQtyPersonHeightInches, String szCdPersonEyeColor,
                    String szCdPersonHairColor, String szCdPersonHighestEduc, String indVerified,
                    String indRsrcHouseholdMember, String indPaternityEst, String sideOfFamily, String indLegalCust, String szTxtEmail);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.PersonDtl} object.
   * 
   * @param personDtl
   */
  void deletePersonDtl(PersonDtl personDtl);
  
  
  /**
   * 
   * @param idPerson
   * @param cdPersonCitizenship
   * @param indPersonNoUsBrn
   * @param cdPersonBirthCountry
   * @return
   */
  int updatePersonDtl(int idPerson, String cdPersonCitizenship, String indPersonNoUsBrn,
                String cdPersonBirthCountry);
 
  /**
   * 
   * @param idPerson
   * @param cdPersonCitizenship
   * @param indPersonNoUsBrn
   * @param cdPersonBirthCountry
   * @return
   */
  int insertPersonDtl(int idPerson, String cdPersonCitizenship, String indPersonNoUsBrn,
                      String cdPersonBirthCountry);
  
  /**
   * Retrieves person citizenship status from the PersonDtl table for a given idPerson.
   * 
   * @param idPerson
   * @return String
   */
  
  String findPersonCtznshipByIdPerson(int idPerson);
  
}
