package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.AddressPersonLink;

public interface ComplexAddressPersonLinkDAO {
  /**
   * Retrieves a list of AddressPersonLink objects
   *
   * @param intake
   * @param idPerson
   * @param dtSysTsQuery
   * @return
   */
  List<AddressPersonLink> findIntakeOrInvest(boolean intake, int idPerson, Date dtSysTsQuery);

  /**
   * Insert rows into the Address Person Link table.
   *
   * @param dtDtPersAddrLinkEnd
   * @param dtDtPersAddrLinkEnd
   * @param idPerson
   * @param idAddress
   * @param indPersAddrLinkInvalid
   * @param indPersAddrLinkPrimary
   * @param txtPersAddrCmnts
   * @param cdPersAddrLinkType
   */
  int insertAddressPersonLink(Date dtDtPersAddrLinkEnd, int idPerson, int idAddress, String indPersAddrLinkInvalid,
                              String indPersAddrLinkPrimary, String txtPersAddrCmnts, String cdPersAddrLinkType, String indRemovalHome);

  /**
   * Retrieves of a table join consisting the PERSON_ADDRESS Table and the ADDRESS_PERSON_LINK Table.
   *
   * @param dtDtPersAddrLinkEnd
   * @param idAddrPersonLink
   * @param cdPersAddrLinkType
   * @param indPersAddrLinkInvalid
   * @param indPersAddrLinkPrimary
   * @param txtPersAddrCmnts
   * @param tsSysTsLastUpdate2
   */
  int updateAddressPersonLink(Date dtDtPersAddrLinkEnd, int idAddrPersonLink, String cdPersAddrLinkType,
                              String indPersAddrLinkInvalid, String indPersAddrLinkPrimary, String txtPersAddrCmnts,
                              String indRemovalHome,
                              Date tsSysTsLastUpdate2);
}
