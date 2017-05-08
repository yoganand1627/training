/**
 * Created on Mar 25, 2006 at 3:05:20 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.Name;

/*** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 **  04/01/2008  Corey Harden      STGAP00006396: made new method updateNmNamefstMddlLast() 
 *                                 to update the first, middle and last name in the name table
 
                                                              
 **/

public interface NameDAO {
  /**
   * Retrieves all names from the Name table given idPerson and for Parent.
   * <p/>
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   * @param idPerson
   * @return
   */
  @SuppressWarnings({"unchecked"})
  Object[] findDistinctNameByIdPersonAndRelPA(int idPerson);

  /**
   * Retrieves all names from the Name table given idPerson.
   * <p/>
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   * @param idPerson
   * @return
   */
  @SuppressWarnings({"unchecked"})
  Name findDistinctNameByIdPerson(int idPerson);
  
  /**
   * This selects a row from Name where indNamePrimary = 'Y'
   *
   * @param idPerson
   * @return
   */
  Name findNameByPersonPrimary(int idPerson);

  /**
   * Gets dtNameEndDate field given idName.
   * <p/>
   *
   * @param idName
   * @return
   */
  Date findNameDtNameEndDateByIdName(int idName);

  /**
   * Retrieves the rows from Name and PhoneticName tables for the given idPerson and for indNamePrimary = 'Y' and
   * cdPhkNameType = 'NA'
   *
   * @param idPerson
   * @return List of objects/rows
   */
  @SuppressWarnings({"unchecked"})
  Map findNameFromNameAndPhoneticNameByIdPerson(int idPerson);

  /**
   * Retrieves all aliases for a specified stage ID, considering closure and end dating.
   * <p/>
   *
   * @param idStage
   * @return keys idPerson, nmNameFirst, nmNameMiddle, nmNameLast, cdNameSuffix, dtNameEndDate, dtNameStartDate, idName,
   *         indNameInvalid, indNamePrimary, dtLastUpdate
   */
  @SuppressWarnings({"unchecked"})
  List<Name> findNameByIdStage(int idStage);

  /**
   * Gets name fields given idPerson and dtSysTsQuery.
   * <p/>
   *
   * @param idPerson
   * @param dtSysTsQuery
   * @return
   */
  @SuppressWarnings({"unchecked"})
  Name findNameByIdPersonDtSysTsQuery(int idPerson, Date dtSysTsQuery);

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
  *
  * @param first
  * @param last
  * @return List of Person ID
  */
  @SuppressWarnings({"unchecked"})
 List<Integer> findPrimaryIdPersonsByFirstLast(String first, String last, String indSealed);
 
 /**
  * Counts the number of Name ID for the given ID Person and dtSysTsQuery.
  *
  * @param idPerson
  * @param dtSysTsQuery
  * @return
  */
  @SuppressWarnings({"unchecked"}) 
  long countNameIdName(int idPerson, Date dtSysTsQuery);

  /**
   * Retrieve Name information given idPerson and maxDate.
   * <p/>
   *
   * @param idPerson
   * @param maxDate
   * @return Name
   */
  Name findNameByIdPersonAndMaxDate(int idPerson, Date maxDate);

  /**
   * This gets a count of idName based on idPerson and maxDate.
   *
   * @param idPerson
   * @param maxDate
   * @return Integer
   */
  long countIdNameByIdPersonAndMaxDate(int idPerson, Date maxDate);

  long countNameIdNameByNmFull(String first, String mid, String last);

  /**
   * Retrieves valid names from the Name table given idPerson and dtSysTsQuery.
   * <p/>
   *
   * @param idPerson
   * @param dtSysTsQuery
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<Name> findNameByIdPersonAndDtNameStartDate(int idPerson, Date dtSysTsQuery);

  /**
   * Retrieves all names from the Name table given idPerson.
   * <p/>
   *
   * @param idPerson
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<Name> findNameByIdPerson(int idPerson);

  /**
   * Inserts into Name table
   *
   * @param idName
   * @param idPerson
   * @param indNameInvalid
   * @param nmNameFirst
   * @param nmNameMiddle
   * @param nmNameLast
   * @param indNamePrimary
   * @param cdNameSuffix
   * @param dtDtNameStartDate
   * @return
   */
  int insertName(int idPerson, String indNameInvalid, String nmNameFirst, String nmNameMiddle, String nmNameLast,
                 String indNamePrimary, String cdNameSuffix, Date dtDtNameStartDate);

  /**
   * Updates Name table
   *
   * @param idName
   * @param dtDtNameEndDate
   * @param tsLastUpdate
   * @return
   */
 
  int updateName(int idName, Date dtDtNameEndDate, Date tsLastUpdate);

  /**
   * Updates table Name field nmNameLast given idName and idPerson
   * <p/>
   *
   * @param nmNameLast
   * @param idName
   * @param idPerson
   */
  
  
  int updateNameNmNameLast(String nmNameLast, int idName, int idPerson);

  /**
   * Inserts into Name table
   *
   * @param nmNameLast
   * @param idPerson
   * @return
   */
  int insertName(String nmNameLast, int idPerson);

  /**
   * Insert a row into the Name table.The primary key used is SEQ_NAME.
   *
   * @param idPerson
   * @param nmNameFirst
   * @param nmNameMiddle
   * @param nmNameLast
   * @param cdNameSuffix
   * @param indNamePrimary
   * @param indNameInvalid
   * @param dtNameStartDate
   * @param dtNameEndDate
   * @return
   */
  int insertName(int idPerson, String nmNameFirst, String nmNameMiddle, String nmNameLast,
                 String cdNameSuffix, String indNamePrimary, String indNameInvalid,
                 Date dtNameStartDate, Date dtNameEndDate
  );

  /**
   * Partial insert of Name table using the supplied parameters(column values). (Note that the insert is done using
   * straight SQL)
   *
   * @param cdNameSuffix
   * @param dtNameEndDate
   * @param idName
   * @param idPerson
   * @param indNameInvalid
   * @param indNamePrimary
   * @param nmNameFirst
   * @param nmNameLast
   * @param nmNameMiddle
   * @return int The number of entities effected by the 'insert' operation.
   */
  int insertName(String cdNameSuffix, Date dtNameEndDate, int idName, int idPerson, String indNameInvalid,
                 String indNamePrimary, String nmNameFirst, String nmNameLast, String nmNameMiddle);

  /**
   * Partial insert of Name table using the supplied parameters(column values). (Note that the insert is done using
   * straight SQL)
   *
   * @param cdNameSuffix
   * @param idName
   * @param idPerson
   * @param indNameInvalid
   * @param indNamePrimary
   * @param nmNameFirst
   * @param nmNameLast
   * @param nmNameMiddle
   * @return int The number of entities effected by the 'insert' operation.
   */
  int insertName(String cdNameSuffix, int idName, int idPerson, String indNameInvalid, String indNamePrimary,
                 String nmNameFirst, String nmNameLast, String nmNameMiddle);

  /**
   * Partial update of Name table using the supplied parameters(column values).
   *
   * @param cdNameSuffix
   * @param idPerson
   * @param indNameInvalid
   * @param indNamePrimary
   * @param nmNameFirst
   * @param nmNameLast
   * @param nmNameMiddle
   * @param idName
   * @param lastUpdate
   * @return int The number of entities effected by the 'update' operation.
   */
  int updateNameIncludingDtNameEndDate(String cdNameSuffix, int idPerson, String indNameInvalid,
                                       String indNamePrimary,
                                       String nmNameFirst, String nmNameLast, String nmNameMiddle, int idName,
                                       Date lastUpdate);

  /**
   * Partial update of Name table using the supplied parameters(column values).
   *
   * @param cdNameSuffix
   * @param idPerson
   * @param indNameInvalid
   * @param indNamePrimary
   * @param nmNameFirst
   * @param nmNameLast
   * @param nmNameMiddle
   * @param idName
   * @param lastUpdate
   * @return int The number of entities effected by the 'update' operation.
   */
  int updateName(String cdNameSuffix, int idPerson, String indNameInvalid, String indNamePrimary,
                 String nmNameFirst, String nmNameLast, String nmNameMiddle, int idName, Date lastUpdate);

  /**
   * Delete {@link gov.georgia.dhr.dfcs.sacwis.db.Name} objects.
   *
   * @param idName
   * @param dtLastUpdate
   * @return The number of rows deleted.
   */
  int deleteName(int idName, Date dtLastUpdate);
  /**
   * This gets a count of idName.
   *
   * @param idPerson
   * @return
   */
  long countNameIdNameByIdPerson(int idPerson);
  
  /**
   * Inserts or updates a Name record
   * @param name
   * @return
   */
  int saveOrUpdateName(Name name) ;
}
