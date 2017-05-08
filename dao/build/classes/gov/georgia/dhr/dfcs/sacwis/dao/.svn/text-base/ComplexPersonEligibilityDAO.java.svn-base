package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

public interface ComplexPersonEligibilityDAO {
  /**
   * Description:
   * <p/>
   * Insert new EA into PERSON_ELIGIBILITY.
   * <p/>
   * <p/>
   *
   * @param dtPersEligStart
   * @param idPerson
   */
  public void insertPersonEligibility(Date dtPersEligStart, int idPerson);

  /**
   * Description:
   * <p/>
   * Update EA open code in PERSON_ELIGIBILITY.
   * <p/>
   * <p/>
   *
   * @param idPersElig
   * @param cdPersEligPrgOpen
   */
  public void updatePersonEligibility(int idPersElig, String cdPersEligPrgOpen);

  /**
   * Description:
   * <p/>
   * Update Open and Close code in PERSON ELIGIBILITY.
   * <p/>
   * <p/>
   *
   * @param idPersElig
   * @param cdPersEligPrgOpen
   * @param cdPersEligPrgClose
   */
  public void updatePersonEligibility(int idPersElig, String cdPersEligPrgOpen, String cdPersEligPrgClose);

  /**
   * Description:
   * <p/>
   * Update Deny date and Close code in PERSON ELIGIBILITY.
   * <p/>
   * <p/>
   *
   * @param idPersElig
   * @param dtDtPersEligEaDeny
   * @param cdPersEligPrgClose
   */
  public void updatePersonEligibility(int idPersElig, Date dtDtPersEligEaDeny, String cdPersEligPrgClose);

  /**
   * Description:
   * <p/>
   * Update Deny date, Open code, and Close code in PERSON ELIGIBILITY.
   * <p/>
   * <p/>
   *
   * @param idPersElig
   * @param dtDtPersEligEaDeny
   * @param cdPersEligPrgOpen
   * @param cdPersEligPrgClose
   */
  public void updatePersonEligibility(int idPersElig, Date dtDtPersEligEaDeny, String cdPersEligPrgOpen,
                                      String cdPersEligPrgClose);
}
