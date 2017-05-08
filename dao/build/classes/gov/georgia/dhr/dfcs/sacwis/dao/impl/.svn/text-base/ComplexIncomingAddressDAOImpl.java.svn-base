package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.AddressPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexIncomingAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingAddress;

public class ComplexIncomingAddressDAOImpl extends BaseDAOImpl implements ComplexIncomingAddressDAO {
  private IncomingAddressDAO incomingAddressDAO = null;
  private PersonAddressDAO personAddressDAO = null;
  private AddressPersonLinkDAO addressPersonLinkDAO = null;

  public void setIncomingAddressDAO(IncomingAddressDAO incomingAddressDAO) {
    this.incomingAddressDAO = incomingAddressDAO;
  }

  public void setPersonAddressDAO(PersonAddressDAO personAddressDAO) {
    this.personAddressDAO = personAddressDAO;
  }

  public void setAddressPersonLinkDAO(AddressPersonLinkDAO addressPersonLinkDAO) {
    this.addressPersonLinkDAO = addressPersonLinkDAO;
  }

  public int insertPersonAddressAndAddressPersonLink(int idIncmgPerson, int idPerson) {
    // look up incoming addresses and insert associated tables
    // Returns 0 if any of the DAO calls does not yield a valid result.
    List<IncomingAddress> listIncmg = incomingAddressDAO.findIncomingAddressByIdIncmgPerson(idIncmgPerson);
    int rowsAdded = 0;
    if (listIncmg != null && !listIncmg.isEmpty()&& listIncmg.size() > 0) {
      rowsAdded = listIncmg.size();
      for (Iterator<IncomingAddress> it = listIncmg.iterator(); it.hasNext();) {
        IncomingAddress incmgAdr = it.next();
        int idPersonAddr = personAddressDAO.insertPersonAddressWithSeqPersonAddress(incmgAdr.getAddrIncmgAddrStLn1(),
                                                                                    incmgAdr.getAddrIncmgAddrStLn2(),
                                                                                    incmgAdr.getAddrIncmgAddrCity(),
                                                                                    incmgAdr.getAddrIncmgAddrZip(),
                                                                                    incmgAdr.getAddrIncmgAddrAttn(),
                                                                                    null,
                                                                                    incmgAdr.getCdIncmgAddrCounty(),
                                                                                    incmgAdr.getCdIncmgAddrState());
        if (idPersonAddr == 0) {
          return 0;
        }
        addressPersonLinkDAO.insertAddressPersonLinkStartEnd(idPersonAddr, idPerson,
                                                             incmgAdr.getCdIncmgAddrType(),
                                                             incmgAdr.getIndIncmgAddrInvalid(),
                                                             incmgAdr.getIndIncmgAddrPrimary(),
                                                             incmgAdr.getDtIncmgAddrStart(),
                                                             incmgAdr.getDtIncmgAddrEnd(),
                                                             null);
      }
    }
    return rowsAdded;
  }
}