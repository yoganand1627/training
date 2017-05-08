/**
 * Created on Mar 25, 2006 at 3:15:25 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;

public interface PersonAddressDAO {
  
  
  /**
   * Finds email address based on IdPerson
   * @param idPerson
   * @return
   */
  public String findPersonEmailAddressByIdPerson(int idPerson);
  /**
   * Inserts into PersonAddress table
   * 
   * @param addrPersAddrStLn1
   * @param aAddrPersAddrStLn2
   * @param addrCity
   * @param addrZip
   * @param addrPersAddrAttn
   * @param txtPersonEmail
   * @param cdAddrCounty
   * @param cdAddrState
   * @param idAddress
   * @return
   */
  int insertPersonAddressWithSeqPersonAddress(String addrPersAddrStLn1, String aAddrPersAddrStLn2, String addrCity,
                                              String addrZip, String addrPersAddrAttn, String txtPersonEmail,
                                              String cdAddrCounty, String cdAddrState);

  /**
   * Update PersonAddress table
   * 
   * @param tsLastUpdate
   * @param addrPersAddrStLn1
   * @param addrPersAddrStLn2
   * @param addrCity
   * @param addrZip
   * @param addrPersAddrAttn
   * @param txtPersonEmail
   * @param cdAddrCounty
   * @param cdAddrState
   * @param idAddress
   * @return
   */
  int updatePersonAddress(Date tsLastUpdate, String addrPersAddrStLn1, String addrPersAddrStLn2, String addrCity,
                          String addrZip, String addrPersAddrAttn, String txtPersonEmail, String cdAddrCounty,
                          String cdAddrState, int idAddress);

  /**
   * Updates a {@link PersonAddress} object to the database.
   * 
   * @param addrPersAddrStLn1
   * @param idAddress
   * @return Integer
   */
  int updatePersonAddress(String addrPersAddrStLn1, int idAddress);

  /**
   * Updates a {@link PersonAddress} object to the database.
   * 
   * @param addrPersAddrStLn2
   * @param idAddress
   * @return Integer
   */
  int updatePersonAddressAddrPersAddrStLn2(String addrPersAddrStLn2, int idAddress);

  /**
   * Updates a {@link PersonAddress} object to the database.
   * 
   * @param addrCity
   * @param idAddress
   * @return Integer
   */
  int updatePersonAddressAddrCity(String addrCity, int idAddress);

  /**
   * Updates a {@link PersonAddress} object to the database.
   * 
   * @param addrZip
   * @param idAddress
   * @return Integer
   */
  int updatePersonAddressAddrZip(String addrZip, int idAddress);

  /**
   * Updates a {@link PersonAddress} object to the database.
   * 
   * @param cdAddrCounty
   * @param idAddress
   * @return Integer
   */
  int updatePersonAddressCdAddrCounty(String cdAddrCounty, int idAddress);

  /**
   * Updates a {@link PersonAddress} object to the database.
   * 
   * @param cdAddrState
   * @param idAddress
   * @return Integer
   */
  int updatePersonAddressCdAddrState(String cdAddrState, int idAddress);

  /**
   * Inserts into PersonAddress table
   * 
   * @param addrPersAddrStLn1
   * @param addrPersAddrStLn2
   * @param addrCity
   * @param addrZip
   * @param cdAddrCounty
   * @param cdAddrState
   * @return Integer
   */
  int insertPersonAddress(String addrPersAddrStLn1, String addrPersAddrStLn2, String addrCity, String addrZip,
                          String cdAddrCounty, String cdAddrState);

  /**
   * Join the Person Merge Table to retrieve the Id Person Forward for the given input variable. It joins will the
   * Address, Id, Name and Person table to retrieve demographic information for the Id Pers Merge Forward.
   * 
   * @param idPerson
   * @return
   */
  Map findPersonAddressByIdPersonAddr(int idPerson);
  /**
   * Find the Primary address of a person give the person id 
   * @param idPerson
   * @return
   */
  public PersonAddress findPrimaryPersonAddressByIdPerson(int idPerson);

  /**
   * Find the Primary address of a list of persons give their person id 
   * @param idPersons
   * @returnList<Map>
   */
  public List<Map> findPrimaryPersonAddressByIdPerson(Collection<Integer> idPersons);

    /**
   * Selects an entire PersonAddress Record
   * 
   * @param idStage
   * @return 
   */
  Object[] findPersonAddressByIdStage(int idStage);
  
  /**
   * Find the current Primary address of a person give the person id 
   * @param idPerson
   * @return
   */
  public PersonAddress findCurrentPrimaryPersonAddressByIdPerson(int idPerson);
  PersonAddress findPersonAddressByIdPersonAddress(int idPersonAddress);//mxpatel
}
