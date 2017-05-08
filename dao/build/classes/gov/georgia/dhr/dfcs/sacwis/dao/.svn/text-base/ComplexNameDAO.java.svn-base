package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ComplexNameDAO {

  /**
   * This gets list of Person ID for the given first, middle and last names and filters
   * out the Adopted Person if the Sealed Indicator attribute of the user is N 
   * @param first
   * @param middle
   * @param last
   * @param indSealed
   * @return List of Person ID
   */
  List<Integer> findPrimaryIdPersonsByFirstLastMiddle(String first, String last, String middle, String indSealed);
  /**
   * This gets list of Person ID for the given first and last names and filters
   * out the Adopted Person if the Sealed Indicator attribute of the user is N 
   * @param first
   * @param last
   * @param indSealed
   * @return List of Person ID
   */
  List<Integer> findPersonsByNmLastNmFirst3(String last, String first, String indSealed);

  /**
   * Typically, DT_NAME_END_DATE will be NULL_DATE when passed into the DAM. This is fine since a trigger will set it to
   * MAX_DATE for us. However, it is possible for us to have end dated the name at the same time it was created. In this
   * case, we want to set DT_NAME_END_DATE to SYSDATE. Consequently, two INSERT statements are needed.
   * </p>
   * 
   * @param idPerson
   * @param nmNameFirst
   * @param nmNameMiddle
   * @param nmNameLast
   * @param cdNameSuffix
   * @param indNamePrimary
   * @param indNameInvalid
   * @param dtNameEndDate
   * @return
   */
  int insertNameCheckDtNameEndDateForNull(String cdNameSuffix, Date dtNameEndDate, int idName, int idPerson,
                                          String indNameInvalid, String indNamePrimary, String nmNameFirst,
                                          String nmNameLast, String nmNameMiddle);

  /**
   * The only time that DT_NAME_END_DATE should be updated is if a non-null value is passed into the DAM and the row
   * does not already have an end-date on the database. To determine this we need to retrieve the value from the
   * database and check to see if it's null.
   * </p>
   * 
   * @param idPerson
   * @param nmNameFirst
   * @param nmNameMiddle
   * @param nmNameLast
   * @param cdNameSuffix
   * @param indNamePrimary
   * @param indNameInvalid
   * @param dtNameEndDate
   * @param lastUpdate
   * @return
   */
  int updateNameCheckDtNameEndDateForNull(String cdNameSuffix, Date dtNameEndDate, int idName, int idPerson,
                                          String indNameInvalid, String indNamePrimary, String nmNameFirst,
                                          String nmNameLast, String nmNameMiddle, Date lastUpdate);
}
