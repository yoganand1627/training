/**
 * Created on Mar 25, 2006 at 3:11:33 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;

public interface PersonPhoneDAO {
  /**
   * This does a full row retrieve of the PersonPhone table given idPerson.
   * <p/>
   * This method is used for updating the CSUP_PERSON_OUTBOUND table
   * @param idPerson
   * @return
   */
  @SuppressWarnings({"unchecked"})
  PersonPhone findDistinctPersonPhoneByIdPerson(int idPerson);
  
  /**
   * This does a full row retrieve of the PersonPhone table given idPerson, dtPersonPhoneStart, and dtPersonPhoneEnd.
   * bSysIndIntake == TRUE
   * <p/>
   *
   * @param idPerson
   * @param dtPersonPhone
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<PersonPhone> findPersonPhoneByIdPersonDtPersonPhone(int idPerson,
                                                           Date dtPersonPhone
  );

  /**
   * This does a full row retrieve of the PersonPhone table given idPerson.
   * <p/>
   *
   * @param idPerson
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<PersonPhone> findPersonPhoneByIdPerson(int idPerson);

  /**
   * This DAM is designed to retrieve a phone number and other information (NBR_PERSON_PHONE, DT_PERSON_PHONE_START,
   * IND_PERSON_PHONE_INVALID, IND_PERSON_PHONE_PRIMARY, NBR_PERSON_PHONE_EXTENSION,TXT_PERSON_PHONE_COMMENTS) from the
   * PERSON_PHONE table given an ID PERSON, a CD PERSON PHONE TYPE, and a DT PERSON PHONE END.
   * <p/>
   *
   * @param idPerson
   * @param cdPersonPhoneType
   * @param dtPersonPhoneEnd
   * @return
   */
  @SuppressWarnings({"unchecked"})
  PersonPhone findPersonPhoneByIdPersonCdPersonPhoneTypeDtPersonPhoneEnd(int idPerson,
                                                                         String cdPersonPhoneType,
                                                                         Date dtPersonPhoneEnd);

  /**
   * This is designed to retrieve the a phone number and other information (NBR_PERSON_PHONE, DT_PERSON_PHONE_START,
   * IND_PERSON_PHONE_INVALID, NBR_PERSON_PHONE_EXTENSION, TXT_PERSON_PHONE_COMMENTS) from the PERSON_PHONE table given
   * an ID PERSON, a CD PERSON PHONE TYPE, an IND PERSON PHONE PRIMARY and a DT PERSON PHONE END.
   * <p/>
   *
   * @param idPerson
   * @param cdPersonPhoneType
   * @param indPersonPhonePrimary
   * @param dtPersonPhoneEnd
   * @return
   */
  @SuppressWarnings({"unchecked"})
  PersonPhone findPersonPhoneAndOtherInfo(int idPerson, String cdPersonPhoneType,
                                          String indPersonPhonePrimary, Date dtPersonPhoneEnd);

  /**
   * Retrieve a List<Map> containing nbrPersonPhone and nbrPersonPhoneExtension attributes.
   *
   * @param idPerson
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findPersonPhoneByIdPersonAndCdPersonPhoneType(int idPerson);

  /**
   * List retrieves all phone info for a specified stage ID, considering closure and end dating.
   * <p/>
   *
   * @param idStage
   * @return keys idPerson, nbrPersonPhone, nbrPersonPhoneExtension, cdPersonPhoneType, txtPersonPhoneComments,
   *         dtPersonPhoneStart, dtPersonPhoneEnd, indPersonPhonePrimary, indPersonPhoneInvalid, idPersonPhone,
   *         dtLastUpdate
   */
  @SuppressWarnings({"unchecked"})
  List<PersonPhone> findPersonPhoneByIdStage(int idStage);

  /**
   * Retrieves a person's name(nmPersonFull) and primary business phone number(nbrPersonPhone) from PersonPhone and
   * Person tables. The select statement does an ORDER BY on dtPersonPhoneEnd so that it will return the non-end-dated
   * primary business phone number, if one exists; otherwise,it will return the most recently end-dated primary business
   * phone number.
   *
   * @param idPerson
   * @param cdPhoneType
   * @param indPersonPhonePrimary
   * @return Map
   */
  Map findNameAndPhoneNumberFromPersonPhoneAndPerson(int idPerson, String cdPhoneType,
                                                     String indPersonPhonePrimary);

  /**
   * This select PersonPhone given idPerson and dtSysTsQuery
   * <p/>
   *
   * @param idPerson
   * @param dtSysTsQuery
   * @return
   */
  @SuppressWarnings({"unchecked"})
  PersonPhone findPersonPhoneByIdPersonDtSysTsQuery(int idPerson, Date dtSysTsQuery);

  /**
   * This gets a count of idPersonPhone.
   *
   * @param idPerson
   * @param dtSysTsQuery
   * @return
   */
  PersonPhone findPrimaryPersonPhoneByIdPersonDtSysTsQuery(int idPerson, Date dtSysTsQuery);

  /**
   * This selects PersonPhone given idPerson and dtSysTsQuery
   *
   * @param idPerson
   * @param dtSysTsQuery
   * @return
   */
  long countPersonPhoneIdPersonPhone(int idPerson, Date dtSysTsQuery);

  /**
   * Retrieve PersonPhone information given idPerson and maxDate.
   * <p/>
   *
   * @param idPerson
   * @param maxDate
   * @return PersonPhone
   */
  PersonPhone findPersonPhoneByIdPersonAndMaxDate(int idPerson, Date maxDate);

  /**
   * This gets a count of idPersonPhone based on idPerson and maxDate.
   *
   * @param idPerson
   * @param maxDate
   * @return Integer
   */
  long countIdPersonPhoneByIdPersonAndMaxDate(int idPerson, Date maxDate);

  /**
   * Return phone number and extension by idPerson and phone types
   *
   * @param cdPersonPhoneType
   * @param idPerson
   * @param bIndPersonPhonePrimary
   * @param bIndPersonPhoneInvalid
   * @return Map
   */
  Map findPersonPhoneAndExtensionbyIdPersonAndTypes(String cdPersonPhoneType,
                                                    int idPerson, String bIndPersonPhonePrimary,
                                                    String bIndPersonPhoneInvalid);

  /**
   * Retrieves dtPersonPhoneEnd from the PersonPhone table given the idPhone.
   *
   * @param idPhone
   * @return Date representing dtPersonPhoneEnd
   */
  Date findPersonPhoneDtPersonPhoneEnd(int idPhone);
  
  /**
   * Finds the latest updated phone number for the person by phone type.  Also checks for phone
   * type as null.
   * 
   * @param idPerson
   * @param phoneType
   * @return
   */
  String findNbrPersonPhoneByIdPersonAndPhoneType(int idPerson, String phoneType);

  /**
   * Updates PERSON_PHONE table
   *
   * @param cdPhoneType
   * @param nbrPhone
   * @param nbrPhoneExtension
   * @param indPersonPhonePrimary
   * @param indPersonPhoneInvalid
   * @param txtPhoneComments
   * @param idPhone
   * @param tsLastUpdate
   * @return
   */
  int updatePersonPhoneByDtPersonPhoneEnd(String cdPhoneType, String nbrPhone, String nbrPhoneExtension,
                                          String indPersonPhonePrimary, String indPersonPhoneInvalid,
                                          String txtPhoneComments, int idPhone, Date tsLastUpdate);

  /**
   * Updates PERSON_PHONE table
   *
   * @param cdPhoneType
   * @param nbrPhone
   * @param nbrPhoneExtension
   * @param indPersonPhonePrimary
   * @param indPersonPhoneInvalid
   * @param txtPhoneComments
   * @param idPhone
   * @param tsLastUpdate
   * @return
   */
  int updatePersonPhone(String cdPhoneType, String nbrPhone, String nbrPhoneExtension,
                        String indPersonPhonePrimary, String indPersonPhoneInvalid, String txtPhoneComments,
                        int idPhone, Date tsLastUpdate);

  /**
   * This function inserts an entire row into PERSON_PHONE but uses a select to get values for insert so it must be
   * written in sql instead of hql
   * <p/>
   * Note that, this is done in straight sql.
   *
   * @param idIncmgPerson
   * @param idPerson
   */
  int insertPersonPhone(int idIncmgPerson, int idPerson);

  /**
   * Updates a {@link gov.georgia.dhr.dfcs.sacwis.db.PersonPhone} object to the database.
   *
   * @param cdPhoneType
   * @param idPhone
   * @return Integer
   */
  int updatePersonPhoneCdPhoneType(String cdPhoneType, int idPhone);

  /**
   * Updates a {@link gov.georgia.dhr.dfcs.sacwis.db.PersonPhone} object to the database.
   *
   * @param nbrPhone
   * @param idPhone
   * @return Integer
   */
  int updatePersonPhoneNbrPhone(String nbrPhone, int idPhone);

  /**
   * Updates a {@link gov.georgia.dhr.dfcs.sacwis.db.PersonPhone} object to the database.
   *
   * @param nbrPhoneExtension
   * @param idPhone
   * @return Integer
   */
  int updatePersonPhoneNbrPhoneExtension(String nbrPhoneExtension, int idPhone);

  /**
   * Inserts into PersonPhone table
   *
   * @param idPerson
   * @param cdPhoneType
   * @param nbrPhone
   * @param nbrPhoneExtension
   */
  void insertPersonPhone(int idPerson, String cdPhoneType, String nbrPhone, String nbrPhoneExtension);

  /**
   * Insert a PersonPhone row. The end date is set to MaxDate.
   *
   * @param idPerson
   * @param idPersonPhone
   * @param cdPhoneType
   * @param cdNbrPhone
   * @param cdNbrPhoneExtension
   * @param indPersonPhonePrimary
   * @param indPersonPhoneInvalid
   * @param cdTxtPhoneComments
   */
  void insertPersonPhonePermanent(int idPerson, int idPersonPhone, String cdPhoneType, String cdNbrPhone,
                                  String cdNbrPhoneExtension, String indPersonPhonePrimary,
                                  String indPersonPhoneInvalid, String cdTxtPhoneComments);

  /**
   * Insert a PersonPhone row. The end date is set to the current date.
   *
   * @param idPerson
   * @param idPersonPhone
   * @param cdPhoneType
   * @param cdNbrPhone
   * @param cdNbrPhoneExtension
   * @param indPersonPhonePrimary
   * @param indPersonPhoneInvalid
   * @param cdTxtPhoneComments
   */
  void insertPersonPhoneNoEndDate(int idPerson, int idPersonPhone, String cdPhoneType, String cdNbrPhone,
                                  String cdNbrPhoneExtension, String indPersonPhonePrimary,
                                  String indPersonPhoneInvalid, String cdTxtPhoneComments);

  /**
   * Select a row based on idPerson and maxDate
   *
   * @param idPerson
   * @return
   */
  public Map findPersonPhoneByIndPersAddrLinkPrimary(int idPerson);

  /**
   * Select a list of personPhone attached to a person, that are active, valid,and of certain phone types 
   *
   * @param idPerson
   * @param cdPhoneType
   * @param dtPersonPhone
   * @param indPersonPhoneInValid
   * @return List<PersonPhone>
   */
  public List<PersonPhone> findPersonPhoneByIdPersonDtPersonPhoneCdPersonPhoneTypes(int idPerson, 
                                                                             Date dtPersonPhone,
                                                                             String indPersonPhoneInValid,
                                                                             Collection<String> personPhoneTypes);
  }
