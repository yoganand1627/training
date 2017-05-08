package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AddressPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AddressPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.PersonAddress;
import gov.georgia.dhr.dfcs.sacwis.db.PersonPhone;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveAddressAndPhone;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB77SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB77SO;

public class RetrieveAddressAndPhoneImpl extends BaseServiceImpl implements RetrieveAddressAndPhone {

  private AddressPersonLinkDAO addressPersonLinkDAO = null;
  private PersonPhoneDAO personPhoneDAO = null;

  public void setAddressPersonLinkDAO(AddressPersonLinkDAO addressPersonLinkDAO) {
    this.addressPersonLinkDAO = addressPersonLinkDAO;
  }

  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public CSUB77SO retrieveAddressAndPhone(CSUB77SI csub77si) throws ServiceException {
    CSUB77SO csub77so = new CSUB77SO();

    List<AddressPersonLink> addressPersonLinkList =
            addressPersonLinkDAO.findAddressPersonLinkForInvest(csub77si.getUlIdPerson());

    if (addressPersonLinkList != null) {
      // Set fields in CSUB77SO to fields in addressPersonLink
      for (Iterator<AddressPersonLink> it = addressPersonLinkList.iterator(); it.hasNext();) {
        AddressPersonLink addressPersonLink = it.next();
        if (ArchitectureConstants.Y.equals(addressPersonLink.getIndPersAddrLinkPrimary()) &&
            DateHelper.isNull(addressPersonLink.getDtPersAddrLinkEnd())) {
          // only finds one row and sets into csub77so
          PersonAddress personAddress = addressPersonLink.getPersonAddress();
          csub77so.setSzAddrPersAddrStLn1(personAddress.getAddrPersAddrStLn1());
          csub77so.setSzAddrPersAddrStLn2(personAddress.getAddrPersAddrStLn2());
          csub77so.setSzTxtPersAddrCmnts(addressPersonLink.getTxtPersAddrCmnts());
          csub77so.setLAddrZip(personAddress.getAddrPersonAddrZip());
          csub77so.setSzCdAddrCounty(personAddress.getCdPersonAddrCounty());
          csub77so.setSzAddrCity(personAddress.getAddrPersonAddrCity());
          csub77so.setSzCdAddrState(personAddress.getCdPersonAddrState());
        }
      }
    }

    List<PersonPhone> personPhoneList = personPhoneDAO.findPersonPhoneByIdPerson(csub77si.getUlIdPerson());
    for (Iterator<PersonPhone> it2 = personPhoneList.iterator(); it2.hasNext();) {
      PersonPhone personPhone = it2.next();
      if (ArchitectureConstants.Y.equals(personPhone.getIndPersonPhonePrimary()) &&
          DateHelper.MAX_JAVA_DATE.equals(personPhone.getDtPersonPhoneEnd())) {
        csub77so.setLNbrPhone(personPhone.getNbrPersonPhone());
        csub77so.setLNbrPhoneExtension(personPhone.getNbrPersonPhoneExtension());
      }
    }
    return csub77so;
  }
}
