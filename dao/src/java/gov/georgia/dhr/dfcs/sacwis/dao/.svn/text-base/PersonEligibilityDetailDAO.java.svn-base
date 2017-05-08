/**
 * Created on Mar 25, 2006 at 3:13:23 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.PersonEligibilityDetail;

public interface PersonEligibilityDetailDAO {
  /**
   * This retrieves all the PERSON_ELIGIBILITY_DETAIL records associated with the PERSON CLOSED.
   * <p/>
   *
   * @param idPersEligPerson
   * @param idPersEligDtlPerson
   * @return
   */
  List<PersonEligibilityDetail> findPersonEligibilityDtlForPersonClosed(int idPersEligPerson, int idPersEligDtlPerson);

  /**
   * Inserts a new PersonEligiblityDetail row
   *
   * @param idPerson
   * @param idPersonEligDtl
   * @param nMoPersEligDtlMonth
   * @param nYrPersEligDtlYear
   * @param cdPersonEligDtlEligCode
   * @param cdPersonEligDtlTypeCase
   * @param cdPersonEligDtlMedCov
   * @param cdPersonEligDtlStatInGrp
   * @param cdPersonEligDtlCaseStatus
   * @param cdPersonEligDtlProgType
   * @param cdPersonEligDtlCaseCateg
   * @param dtPersonEligDtlCaseCert
   * @param nbrPersEligDtlCaseNbr
   * @return number of rows affected
   */
  int insertPersonEligibilityDetail(int idPerson, int idPersonEligDtl,
                                    int nMoPersEligDtlMonth, int nYrPersEligDtlYear,
                                    String cdPersonEligDtlEligCode, String cdPersonEligDtlTypeCase,
                                    String cdPersonEligDtlMedCov, String cdPersonEligDtlStatInGrp,
                                    String cdPersonEligDtlCaseStatus, String cdPersonEligDtlProgType,
                                    String cdPersonEligDtlCaseCateg, Date dtPersonEligDtlCaseCert,
                                    int nbrPersEligDtlCaseNbr);
}
