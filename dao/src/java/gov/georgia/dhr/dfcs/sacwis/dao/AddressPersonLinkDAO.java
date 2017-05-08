/**
 * Created on Mar 24, 2006 at 5:32:41 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.AddressPersonLink;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface AddressPersonLinkDAO {
  /**
   * This does a retrieve of a table join consisting the PERSON_ADDRESS Table and the ADDRESS_PERSON_LINK Table for
   * intake.
   *
   * @param idPerson
   * @param dtPersAddrLinkStart
   * @param dtPersAddrLinkEnd
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<AddressPersonLink> findAddressPersonLinkForIntake(int idPerson, Date dtPersAddrLinkStart,
                                                         Date dtPersAddrLinkEnd);

  /**
   * This does a retrieve of a table join consisting the PERSON_ADDRESS Table and the ADDRESS_PERSON_LINK Table for
   * invest.
   *
   * @param idPerson
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<AddressPersonLink> findAddressPersonLinkForInvest(int idPerson);

  /**
   * This does a retrieve of a table join consisting the PERSON_ADDRESS Table and the ADDRESS_PERSON_LINK Table.
   *
   * @param idPerson
   * @param dtSysTsQuery
   * @return
   */
  AddressPersonLink findAddressPersonLinkByIdPersonDtSysTsQuery(int idPerson, Date dtSysTsQuery);

  /**
   * List retrieves all address info for a specified stage ID, considering closure and end dating. <p/>
   *
   * @param idStage
   * @return A list of {@link AddressPersonLink} objects with {@link gov.georgia.dhr.dfcs.sacwis.db.PersonAddress}
   *         information populated.
   */
  @SuppressWarnings({"unchecked"})
  List<AddressPersonLink> findAddressPersonLinkAndPersonAddressByIdStage(int idStage);

  /**
   * Find all the addressPersonLinks given a idPerson and cdPersAddrLinkTypes order by primary first
   *
   * @param idPerson
   * @param cdPersAddrLinkTypes
   * @return List<AddressPersonLink>
   */
  List<AddressPersonLink> findAddressPersonLinkByIdPersonByCdPersAddrLinkType(int idPerson,
                                                                              Collection<String> cdPersAddrLinkTypes);

  /**
   * This gets a count of idPersonAddr.
   *
   * @param idPerson
   * @param dtSysTsQuery
   * @return
   */
  @SuppressWarnings({"unchecked"})
  long countAddressPersonLinkIdPersonAddr(int idPerson, Date dtSysTsQuery);

  /**
   * This gets a count of idPersonAddr given idPerson and maxDate.
   *
   * @param idPerson
   * @param maxDate
   * @return Integer
   */
  @SuppressWarnings({"unchecked"})
  long countAddressPersonLinkByIdPersonAndMaxDate(int idPerson, Date maxDate);

  /**
   * Retrieve Address information for the Person given the idPerson and MaxDate <p/>
   *
   * @param idPerson
   * @param maxDate
   * @return AddressPersonLink
   */
  AddressPersonLink findAddressPersonLinkByIdPersonAndMaxDate(int idPerson, Date maxDate);

  /**
   * This will retrieve addrPersAddrStLn1, addrPersAddrStLn2, addrPersonAddrCity, addrPersonAddrZip, cdPersonAddrCounty,
   * cdPersonAddrState from PersonAddress and nbrPersonPhone and nbrPersonPhoneExtension from EmpSecClassLink given
   * idPerson and maxDate
   *
   * @param idPerson
   * @return
   */
  List<Object[]> findPersonAddressAndPersonPhone(int idPerson);

  /**
   * Retrieves dtPersAddrLinkEnd from the AddressPersonLink table given the idAddrPersonLink.
   *
   * @param idAddrPersonLink
   * @return Date representing dtPersAddrLinkEnd
   */
  Date findAddressPersonLinkDtPersAddrLinkEnd(int idAddrPersonLink);

  /**
   * Insert into AddressPersonLink
   *
   * @param dtDtPersAddrLinkEnd
   * @param idAddrPersonLink
   * @param idPerson
   * @param idAddress
   * @param indPersAddrLinkInvalid
   * @param indPersAddrLinkPrimary
   * @param txtPersAddrCmnts
   * @param cdPersAddrLinkType
   */
  void insertAddressPersonLink(int idAddrPersonLink, Date dtDtPersAddrLinkEnd, int idPerson, int idAddress,
                               String indPersAddrLinkInvalid, String indPersAddrLinkPrimary, String txtPersAddrCmnts,
                               String cdPersAddrLinkType, String indRemovalHome);

  /**
   * Insert into AddressPersonLink
   *
   * @param idAddrPersonLink
   * @param idPerson
   * @param idAddress
   * @param indPersAddrLinkInvalid
   * @param indPersAddrLinkPrimary
   * @param txtPersAddrCmnts
   * @param cdPersAddrLinkType
   */
  void insertAddressPersonLink(int idAddrPersonLink, int idPerson, int idAddress, String indPersAddrLinkInvalid,
                               String indPersAddrLinkPrimary, String txtPersAddrCmnts, String cdPersAddrLinkType, String indRemovalHome);

  /**
   * Inserts an AddressPersonLink with these values
   *
   * @param idPersonAddr
   * @param idPerson
   * @param cdPersAddrLinkType
   * @param indPersAddrLinkInvalid
   * @param indPersAddrLinkPrimary
   * @param dtPersAddrLinkStart
   * @param dtPersAddrLinkEnd
   */
  void insertAddressPersonLinkStartEnd(int idPersonAddr, int idPerson, String cdPersAddrLinkType,
                                       String indPersAddrLinkInvalid, String indPersAddrLinkPrimary,
                                       Date dtPersAddrLinkStart, Date dtPersAddrLinkEnd, String indRemovalHome);

  /**
   * Update AddressPersonLink
   *
   * @param cdPersAddrLinkType
   * @param indPersAddrLinkInvalid
   * @param indPersAddrLinkPrimary
   * @param txtPersAddrCmnts
   * @param idAddrPersonLink
   * @param tsSysTsLastUpdate2
   * @return The number of rows updated.
   */
  int updateAddressPersonLink(String cdPersAddrLinkType, String indPersAddrLinkInvalid, String indPersAddrLinkPrimary,
                              String txtPersAddrCmnts, int idAddrPersonLink,  String indRemovalHome, Date tsSysTsLastUpdate2);

  /**
   * Update AddressPersonLink table
   *
   * @param idAddrPersonLink
   * @param txtPersAddrCmnts
   * @param cdPersAddrLinkType
   * @param indPersAddrLinkInvalid
   * @param indPersAddrLinkPrimary
   * @param tsSysTsLastUpdate2
   * @return
   */
  int updateAddressPersonLinkByCdPersAddrLinkType(String cdPersAddrLinkType, String indPersAddrLinkInvalid,
                                                  String indPersAddrLinkPrimary, String txtPersAddrCmnts,
                                                  int idAddrPersonLink,  String indRemovalHome, Date tsSysTsLastUpdate2);

  /**
   * Updates a {@link gov.georgia.dhr.dfcs.sacwis.db.AddressPersonLink} object to the database.
   *
   * @param cdPersAddrLinkType
   * @param idAddrPersonLink
   * @return Integer
   */

  int updateAddressPersonLink(String cdPersAddrLinkType, int idAddrPersonLink);

  /**
   * Inserts into PersonAddress table
   *
   * @param cdPersAddrLinkType
   * @param idPerson
   * @param idAddress
   * @return
   */
  void insertAddressPersonLink(String cdPersAddrLinkType, int idPerson, int idAddress);
}
